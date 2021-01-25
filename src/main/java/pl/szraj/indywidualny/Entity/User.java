package pl.szraj.indywidualny.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long IDuser;

    String email;
    String haslo;
    String login;
    String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User(String email, String haslo, String login, String role) {
        this.email = email;
        this.haslo = haslo;
        this.login = login;
        this.role = role;
    }

    public User() {
    }

    public Long getIDuser() {
        return IDuser;
    }

    public void setIDuser(Long IDuser) {
        this.IDuser = IDuser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
