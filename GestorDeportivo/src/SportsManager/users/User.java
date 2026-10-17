package SportsManager.users;

import java.util.Objects;

public abstract class User {
    private String email;
    private String password;
    private boolean admin;

    public User(String email, String password, boolean admin) {
        this.email = email;
        this.password = password;
        this.admin = admin;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin(){
        return admin;
    }

    public boolean checkPassword(String password){
        return Objects.equals(this.password, password);
    }
}

