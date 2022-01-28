package design.structural.adaptor;

import design.structural.adaptor.client.Customer;

public class EmployeeObjectAdaptor implements Customer {
    Employee employee;

    public EmployeeObjectAdaptor(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String getName() {
        return employee.getFullName();
    }

    @Override
    public String getDesignation() {
        return employee.getJobTitle();
    }

    @Override
    public String getAddress() {
        return employee.getOfficeLocation();
    }
}
