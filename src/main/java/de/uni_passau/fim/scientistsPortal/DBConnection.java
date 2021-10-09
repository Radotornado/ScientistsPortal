package de.uni_passau.fim.scientistsPortal;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.SessionScoped;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

@ManagedBean
@SessionScoped
public class DBConnection implements Serializable {

    private Connection dbconnection;
    private boolean isConnected;

    private synchronized void connect() {
        while (!isConnected) {
            try {
                wait();
            } catch (InterruptedException e) {
                return;
            }
        }
        isConnected = false;
    }

    private synchronized void initializeTable() {
        try{
            Properties props = new Properties();
            props.setProperty("user", "mandev");
            props.setProperty("password", "poh3deeMaivo");
            String url = "jdbc:postgresql://bueno.fim.uni-passau.de:5432/mandev";
            dbconnection = DriverManager.getConnection(url, props);
            dbconnection.setAutoCommit(false);
            PreparedStatement pstmt = dbconnection.prepareStatement(
                    "CREATE Table Scientists (" +
                            "username VARCHAR(20) PRIMARY KEY " +
                            "password VARCHAR(20) NOT NULL " +
                            "name VARCHAR(20) NOT NULL" +
                            "birthday DATE" +
                            "address VARCHAR(50)" +
                            ")");
            pstmt.execute();
            pstmt = dbconnection.prepareStatement(
                    "INSERT INTO Scientists (username, password, " +
                            "name, birthday, address)" +
                            "VALUES ('konrad', '123456', 'Konrad Zuse', '1910-05-22', 'not known')");
            pstmt.execute();
            pstmt = dbconnection.prepareStatement(
                    "INSERT INTO Scientists (username, password, " +
                            "name, birthday, address)" +
                            "VALUES ('dennis', 'admin', 'Dennis Ritchie', '1941-09-09', 'not known')");
            pstmt.execute();
            dbconnection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Scientist getScientist(String username) {
        Scientist scientist = null;
        try {
            scientist = getScientist(username);
            dbconnection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return scientist;
    }
}
