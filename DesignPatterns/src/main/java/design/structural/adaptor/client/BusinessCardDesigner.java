package design.structural.adaptor.client;

public class BusinessCardDesigner {
    public String designCard(Customer customer) {
        StringBuilder sb = new StringBuilder();
        sb.append(customer.getName());
        sb.append("\n");
        sb.append(customer.getDesignation());
        sb.append("\n");
        sb.append(customer.getAddress());
        return sb.toString();
    }
}
