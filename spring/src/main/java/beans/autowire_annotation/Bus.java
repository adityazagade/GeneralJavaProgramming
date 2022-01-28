package beans.autowire_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Bus {
    @Autowired
    @Qualifier(value="e2")
    private Engine engine;

    public void printData(){
        System.out.println(engine.getModelYear());
    }

//    public Bus(Engine engine) {
//        this.engine = engine;
//    }
}
