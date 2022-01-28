package ORM.beans;

public class HEmployee extends Employee {
    private int wh;

    public HEmployee(String name, String email, int id, int salary, int wh) {
        super(name, email, id, salary);
        this.wh = wh;
    }

    public int getWh() {
        return wh;
    }

    public void setWh(int wh) {
        this.wh = wh;
    }
}
