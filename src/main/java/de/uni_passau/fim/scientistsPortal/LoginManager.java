package de.uni_passau.fim.scientistsPortal;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class LoginManager {
dd
    private String username;
    private String password;

    public LoginManager() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String user_name) {
        this.username = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}