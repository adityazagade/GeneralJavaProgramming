package beans.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test implements InitializingBean, DisposableBean {
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

    @Override
    public void afterPropertiesSet() throws Exception {
        Class.forName(driverName);
        con = DriverManager.getConnection(url, userName, password);
        System.out.println("Connection opened");
    }

    @Override
    public void destroy() throws Exception {
        con.close();
        System.out.println("Connection closed");
    }

    public void save(int id, String name, String email, String address) {
        System.out.println("Save successful");
    }
}
