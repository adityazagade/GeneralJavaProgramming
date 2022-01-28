package ORM.beans;

public class SEmployee extends Employee{
    private String tool;

    public SEmployee(String name, String email, int id, int salary, String tool) {
        super(name, email, id, salary);
        this.tool = tool;
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }
}
