package prithwimig16.visitnortheast.models;

/**
 * Created by Prithwi on 24/10/17.
 */

public class Users {
    public String name;
    public String email;
    public String userId;

    public Users() {
    }

    public Users(String email, String name) {
        this.name = name;
        this.email = email;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


}
