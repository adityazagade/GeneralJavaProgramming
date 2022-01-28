package beans.PropertiesDI;

import java.util.Properties;
import java.util.Set;

public class Test {
    private Properties drivers;

    public void setDrivers(Properties drivers) {
        this.drivers = drivers;
    }

    public void printDrivers() {
        Set<Object> keys = drivers.keySet();
        keys.forEach(key -> {
            System.out.println(key + ": " + drivers.get(key));
            return;
        });
    }
}
