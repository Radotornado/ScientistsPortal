package de.uni_passau.fim.scientistsPortal;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.time.LocalDate;

@Named
@RequestScoped
public class Scientist {

    private String username;
    private String password;
    private String name;
    private LocalDate birthdate;
    private String address;

    public Scientist() {
    }

    public Scientist(String username, String password, String name,
                     LocalDate birthdate, String address) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.birthdate = birthdate;
        this.address = address;
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
}