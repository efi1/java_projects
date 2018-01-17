import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Contact {
    private String name;
    private String mobile;
    private String email;
    private List<String> contactDetails = Arrays.asList();

    public Contact(String name, String mobile, String email) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getValues(){
        contactDetails = Arrays.asList(name, mobile, email);
        return contactDetails ;
    }

    public String toString(){
        return String.format("name=%s, mobile=%s, email=%s ", name, mobile, email);
    }
}

