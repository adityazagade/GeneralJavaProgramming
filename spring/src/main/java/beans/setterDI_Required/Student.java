package beans.setterDI_Required;

import org.springframework.beans.factory.annotation.Required;

public class Student {
    private String name;
    private String email;
    private int marks;

    public String getName() {
        return name;
    }

    @Required
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