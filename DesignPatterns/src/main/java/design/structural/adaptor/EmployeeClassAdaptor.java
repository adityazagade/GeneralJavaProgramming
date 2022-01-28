package design.structural.adaptor;

import design.structural.adaptor.client.Customer;

public class EmployeeClassAdaptor extends Employee implements Customer {
    @Override
    public String getName() {
        return getFullName();
    }

    @Override
    public String getDesignation() {
        return getJobTitle();
    }

    @Override
    public String getAddress() {
        return getOfficeLocation();
    }
}
