package beans.setterDI;

public class Student {
    private String name;
    private String email;
    private int marks;

    public Student(String name, String email, int marks) {
        this.name = name;
        this.email = email;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}