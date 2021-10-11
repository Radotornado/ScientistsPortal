package de.uni_passau.fim.scientistsPortal;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

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
                "Konrad Zuse", "1910-05-22",
                "none given");
        Scientist dennis = new Scientist("dennis", "admin",
                "Dennis Ritchie", "1941-09-09",
                "none given");

        scientists = new ArrayList<>();
        scientists.add(konrad);
        scientists.add(dennis);

        currentScientist = new Scientist();
    }

    public String login() {
        Logger log = Logger.getLogger(ProfileManager.class.getName());
        if (username != null) {
            log.severe(username);
        } else {
            log.severe("no username");
        }
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
        for (Scientist scientist : scientists) {
            if (username.equals(scientist.getUsername())
                    && password.equals(scientist.getPassword())) {
                currentScientist = scientist;
                return true;
            }
        }
        return false;
    }

    public String logout() {
        username = null;
        password = null;
        currentScientist = null;
        return "index";
    }
}
