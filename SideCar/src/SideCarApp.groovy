import groovy.sql.Sql
import wslite.http.auth.HTTPBasicAuthorization
import wslite.rest.ContentType
import wslite.rest.RESTClient
import wslite.rest.Response

// let us start writing our code from here..
// Read a value of property

def server_host = "http://localhost:8080"
def server_uname = "admin";
def server_upass = "admin";
def device_name = "Questra-Aditya"
def interface_name = "VNC"
def state = "AVAILABLE"
def findOneUri = "/services/v2/rest/totalAccessSession/findOne"
String getPropURI = "/services/v2/rest/settings/install/system"
int numberOfRequestsFind = 100
int numberOfRequestsEhCacheSync = 10

ServerInfo info = new ServerInfo(server_host, server_uname, server_upass);
RemoteSessionInfo rsInfo = new RemoteSessionInfo(device_name, interface_name, state);
if (isInPassedArgs("doFindOne")) {
    List l = new FindTest(info, rsInfo, findOneUri).doTest(numberOfRequestsFind)
//    l.each { res -> println(res.toString()) }
}
if (isInPassedArgs("testEhCacheSync")) {
    List l = new EhCacheSyncTest(info, getPropURI).doTest(numberOfRequestsEhCacheSync)
    l.each { res -> println(res.toString()) }
}

class Entry {
    int id, statusCode;
    String node;
    String content;

    Entry(int id, String node, int statusCode, String content) {
        this.id = id
        this.statusCode = statusCode
        this.node = node
        this.content = content
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", statusCode=" + statusCode +
                ", node='" + node + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

class RestAPI {
    String host;
    String uname, pass
    RESTClient client;
//    Proxy proxy

    RestAPI(String host, String uname, String pass) {
        this.host = host
        this.uname = uname
        this.pass = pass
        this.client = new RESTClient(host)
        this.client.authorization = new HTTPBasicAuthorization(uname, pass)
//        this.proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress('127.0.0.1', 8888))

    }

    Response doGet(String uri, Map queryParams) {
        StringBuilder sb = new StringBuilder();
        queryParams.each { k, v -> sb.append("${k}=${v}") }
        def queryPart = (queryParams == null || queryParams.isEmpty()) ? "" : "?${sb.toString()}"
        return this.client.get(path: uri + queryPart)
    }

    Response doPost(String uri, Map headers, def body) {
//        def response = this.client.post(path: uri, headers: headers, proxy: this.proxy) {
        def response = this.client.post(path: uri, headers: headers) {
            text body
            type ContentType.XML
        }
        return response
    }

    Response doPut(String uri, Map headers, def body) {
//        def response = this.client.put(path: uri, headers: headers, proxy: this.proxy) {
        def response = this.client.put(path: uri, headers: headers) {
            text body
            type ContentType.XML
        }
        return response
    }
}

boolean isInPassedArgs(str) {
    for (i in 0..<this.args.length) {
        if (this.args[i].equals(str)) {
            return true;
        }
    }
    return false;
}

class EhCacheSyncTest {
    ServerInfo info
    String getPropURI

    EhCacheSyncTest(ServerInfo info, String getPropURI) {
        this.info = info
        this.getPropURI = getPropURI
    }

    List doTest(int numberOfRequests) {
        String prop = "com.axeda.drm.dummy.new.property"
        int value = (int) (Math.random() * 1000)
        println("${prop} : ${value}")
        boolean result = createNewProperty(prop, value)
        if (result) {
            List list = testSyncOnAllNodes(prop, value, numberOfRequests)
            return list
        }
        return Collections.emptyList()
    }

    boolean createNewProperty(String prop, int value) {
        Map headers = ["Accept": "*/*"]
        String uri = this.getPropURI + "/" + prop.replaceAll("\\.", "/")
        StringBuilder sb = new StringBuilder()
        String elem = prop.substring(prop.lastIndexOf(".") + 1)
        String body = sb.append("<${elem}>${value}</${elem}>").toString()
        def response = (new RestAPI(info.url, info.uname, info.pass)).doPut(uri, headers, body)
        if (response != null) {
            return response.statusCode == 200
        }
        return false
    }

    def List testSyncOnAllNodes(String prop, int value, int numberOfRequests) {
        // need to make 100 calls to the server and read the value or the property. dump the result.
        List l = [];
        String uri = this.getPropURI + "/" + prop.replaceAll("\\.", "/")
        for (i in 0..<numberOfRequests) {
            def response = (new RestAPI(info.url, info.uname, info.pass)).doGet(uri, Collections.emptyMap())
            if (response != null) {
                String nodeId = Utils.getNodeFromCookie(response.headers.get("Set-Cookie").toString())
                l.add(new Entry(i, (nodeId == "" ? response.headers.toString() : nodeId), response.statusCode, response.contentAsString));
            }
        }
        return l
    }
}

class ServerInfo {
    public String url, uname, pass

    ServerInfo(String url, String uname, String pass) {
        this.url = url
        this.uname = uname
        this.pass = pass
    }
}

class FindTest {
    ServerInfo info
    RemoteSessionInfo rsInfo
    String findOneUri

    FindTest(ServerInfo info, RemoteSessionInfo rsInfo, String findOneUri) {
        this.info = info
        this.rsInfo = rsInfo
        this.findOneUri = findOneUri
    }

    List doTest(int numberOfRequests) {
        def list = []
        def count = 0;
        while (count != numberOfRequests) {
            count++
            String body = getXMLRequestForFindOneCall()
            Map headers = ["Accept": "*/*"]
            def response = (new RestAPI(info.url, info.uname, info.pass)).doPost(findOneUri, headers, body)
            if (response != null) {
                String nodeId = Utils.getNodeFromCookie(response.headers.get("Set-Cookie").toString())
                def e = new Entry(count, (nodeId == "" ? response.headers.toString() : nodeId), response.statusCode, response.contentAsString);
                println(e)
                list.add(e)
            }
        }
        return list;
    }

    def getXMLRequestForFindOneCall() {
        StringBuilder sb = new StringBuilder();
        sb.append("<v2:TotalAccessSessionCriteria xmlns:v2=\"http://www.axeda.com/services/v2\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">")
                .append("<v2:serverConnectorAssetName>" + rsInfo.device_name + "</v2:serverConnectorAssetName>")
                .append("<v2:interfaceName>" + rsInfo.interface_name + "</v2:interfaceName>")
                .append("<v2:connectionState>" + rsInfo.state + "</v2:connectionState>")
                .append("</v2:TotalAccessSessionCriteria>")
        return sb.toString()
    }

}

class RemoteSessionInfo {
    String device_name, interface_name, state;

    RemoteSessionInfo(String device_name, String interface_name, String state) {
        this.device_name = device_name
        this.interface_name = interface_name
        this.state = state
    }
}

class Utils {
    static String getNodeFromCookie(String s) {
        if (s != "null") {
            int startIndex = s.indexOf("JSESSIONID=") + "JSESSIONID=".length()
            int endIndex = s.indexOf("; path=", startIndex)
            String jSessionId = s.substring(startIndex, endIndex);
//        return jSessionId.substring(jSessionId.lastIndexOf(".") + 1)
            return jSessionId
        }
        return ""
    }

}