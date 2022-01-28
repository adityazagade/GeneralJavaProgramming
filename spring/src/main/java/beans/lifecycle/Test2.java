package beans.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.DriverManager;

public class Test2 {
    private Connection con;
    private String driverName, url, userName, password;

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @PostConstruct
    public void myInit() throws Exception {
        Class.forName(driverName);
        con = DriverManager.getConnection(url, userName, password);
        System.out.println("Connection opened");
    }

    @PreDestroy
    public void myDestroy() throws Exception {
        con.close();
        System.out.println("Connection closed");
    }

    public void save(int id, String name, String email, String address) {
        System.out.println("Save successful");
    }
}
