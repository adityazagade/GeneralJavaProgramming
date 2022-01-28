package beans.forms;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class RegistrationFormBean extends ActionForm {
    private String name, email, address, gender;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public ActionErrors validate(ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (name == null || name.trim().length() == 0) {
            errors.add("name_e", new ActionMessage("invalid_name"));
        }
        if (email == null || email.trim().length() == 0) {
            errors.add("email_e", new ActionMessage("invalid_email_id"));
        }
        if (address == null || address.trim().length() == 0) {
            errors.add("address_e", new ActionMessage("invalid_address"));
        }
        return errors;
    }
}
