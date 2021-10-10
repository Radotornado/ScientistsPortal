package de.uni_passau.fim.scientistsPortal;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

@Named
@RequestScoped
public class ProfileManager {

    @Inject
    FacesContext fctx;

    private String username;
    private String password;
    private Scientist currentScientist;
    private List<Scientist> scientists;

    public ProfileManager() {
        initializeScientists();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Scientist getCurrentScientist() {
        return currentScientist;
    }

    public void setCurrentScientist(Scientist currentScientist) {
        this.currentScientist = currentScientist;
    }

    private void initializeScientists() {
        Scientist konrad = new Scientist("konrad", "123456",
                "Konrad Zuse", LocalDate.of(1910, 5, 22),
                "none given");
        Scientist dennis = new Scientist("dennis", "admin",
                "Dennis Ritchie", LocalDate.of(1941, 9, 9),
                "none given");
        currentScientist = null;
        scientists = new ArrayList<>();
        scientists.add(konrad);
        scientists.add(dennis);
    }

    public String login() {
        boolean success = isLoginDataCorrect();
        if (success) {
            return "profile";
        } else {
            FacesMessage fmsg = new FacesMessage(
                    "Username or Password not correct.");
            fmsg.setSeverity(FacesMessage.SEVERITY_ERROR);
            fctx.addMessage("loggedIn:username", fmsg);
            return null;
        }
    }

    private boolean isLoginDataCorrect() {
        for(Scientist scientist : scientists) {
            if (username.equals(scientist.getUsername())
                    && password.equals(scientist.getPassword())) {
                this.currentScientist = scientist;
                return true;
            }
        }
        return false;
    }
}
