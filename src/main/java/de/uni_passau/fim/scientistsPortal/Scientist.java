package de.uni_passau.fim.scientistsPortal;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
                     String birthdate, String address) {
        this.username = username;
        this.password = password;
        this.name = name;
        setBirthdate(birthdate);
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

    public String getBirthdate() {
        if (birthdate == null) {
            return "unknown";
        }
        return birthdate.toString();
    }

    public void setBirthdate(String birthdate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.birthdate = LocalDate.parse(birthdate, formatter);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}