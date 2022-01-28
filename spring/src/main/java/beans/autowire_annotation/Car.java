package beans.autowire_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Car {
    @Autowired
    @Qualifier(value="e1")
    private Engine engine;

//    public void setEngine(Engine engine) {
//        this.engine = engine;
//    }

    public void printData(){
        System.out.println(engine.getModelYear());
    }
}
