package dao.model;

public class Student {
    private String name, email, address;
    private int id;
    public static String st_tb_name = "student007";

    public Student() {
    }

    public Student(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Student(int id, String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }
}
