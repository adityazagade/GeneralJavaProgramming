package beans.factory_instance;

import org.springframework.beans.factory.FactoryBean;

public class CarFactoryImpFactoryBean implements FactoryBean {
    private String carName;

    public void setCarName(String carName) {
        this.carName = carName;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public Object getObject() throws Exception {
        Car c = (Car) Class.forName(carName).newInstance();
        return c;
    }

    @Override
    public Class getObjectType() {
        return CarFactoryImpFactoryBean.class;
    }
}
