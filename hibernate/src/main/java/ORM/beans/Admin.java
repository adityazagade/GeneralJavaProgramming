package ORM.beans;

public class Admin extends Employee {
    private String branchName;

    public Admin(String name, String email, int id, int salary, String branchName) {
        super(name, email, id, salary);
        this.branchName = branchName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}
