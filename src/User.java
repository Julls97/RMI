import java.io.Serializable;

public class User implements Serializable {
    public String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.setEmail(email);
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}
