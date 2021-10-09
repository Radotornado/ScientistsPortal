package de.uni_passau.fim.scientistsPortal;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.time.LocalDate;

@Named
@RequestScoped
public class Scientist {

    @Inject
    FacesContext fctx;

    private String username;
    private String password;
    private String name;
    private LocalDate birthdate;
    private String address;

    public Scientist() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String login() {
        boolean success = username.equals("admin") && password.equals("admin");
        if (success) {
            return "profile";
        } else {
            FacesMessage fmsg = new FacesMessage(
                    "Username or Password not correct.");
            fmsg.setSeverity(FacesMessage.SEVERITY_ERROR);
            fctx.addMessage("createCourse:id", fmsg);
            return null;
        }
    }
}