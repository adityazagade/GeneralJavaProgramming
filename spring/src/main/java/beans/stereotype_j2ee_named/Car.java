package beans.stereotype_j2ee_named;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Car {
    @Resource
    private Engine e;

    public void printCar() {
        System.out.println("Enginer " + e.getEngineName());
    }



}
