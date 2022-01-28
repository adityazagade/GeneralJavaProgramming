package design_patterns.structural;

import design.structural.adaptor.Employee;
import design.structural.adaptor.EmployeeClassAdaptor;
import design.structural.adaptor.EmployeeObjectAdaptor;
import design.structural.adaptor.client.BusinessCardDesigner;
import design.structural.adaptor.client.Customer;

public class Client_Adaptor {
    /*
     * What is Adaptor?
     *
     * We have an existing object which provides the functionality that client needs. But client code cant use this
     * object because it expects an object with different interface ...
     *
     * Using adaptor design pattern we make this existing object work with client by adapting the object to client's
     * expected interface.
     *
     * Adaptor == wrapper ?
     *
     * There are two types of adaptors.
     * 1) class adaptor.
     * 2) Two way adaptor.
     *
     * The class adaptor vs ObjectAdaptor(Two way adaptor)
     * The class adaptor inherits the adaptee.
     * The object adaptor uses composition.
     *
     * Implement an Adaptor
     * 1. Adaptor must implement the interface expected by client.
     * 2. First we are going to try out a class adaptor by also extending from our existing class.
     * 3. In the class adaptor implementation, we're simply going to forward the method to another inherited from adaptee.
     * 4. Next for object adaptor, we are only going to implement target interface and accept adaptee as constructor arguement in
     *  adaptor. i.e. make use of composition.
     * 5.An object adaptor should take adaptee as an arguement in constructor or as a less preferred solution, you can
     * instantiate it in the constructor thus tightly coupling with a specific adaptee
     * */

    /*Examples of Adaptor pattern
    * InputStreamReader and OutputStreamReader.*/
    public static void main(String[] args) {
        BusinessCardDesigner designer = new BusinessCardDesigner();
        EmployeeClassAdaptor adaptor = new EmployeeClassAdaptor();
        /*Because of this class adaptor you now have exposed methods from the Employee class as well. Not
        recommeneded in general*/
        populateData(adaptor);
        String card = designer.designCard(adaptor);
        System.out.println(card);

        System.out.println("-------------------------------------------");
        Employee e = new Employee();
        /*Advantage of object adaptor is that we can potentially change adaptee class with one of its subclass*/
        populateData(e);
        EmployeeObjectAdaptor objectAdaptor = new EmployeeObjectAdaptor(e);
        String card1 = designer.designCard(objectAdaptor);
        System.out.println(card1);
    }

    public static void populateData(EmployeeClassAdaptor adaptor) {
        adaptor.setFullName("aditya zagade");
        adaptor.setJobTitle("Developer");
        adaptor.setOfficeLocation("Mumbai");
    }

    static void populateData(Employee e) {
        e.setFullName("aditya zagade");
        e.setJobTitle("Developer");
        e.setOfficeLocation("Mumbai");
    }
}
