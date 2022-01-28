package beans.autowire_stereotype_annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value="b1")
public class Bus {
    @Autowired
    @Qualifier(value = "e1")
    private Engine engine;

    public void printData(){
        System.out.println(engine.getModelYear());
    }

//    public Bus(Engine engine) {
//        this.engine = engine;
//    }
}
