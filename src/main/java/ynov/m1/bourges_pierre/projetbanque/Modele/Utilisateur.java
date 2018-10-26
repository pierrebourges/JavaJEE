package ynov.m1.bourges_pierre.projetbanque.Modele;


import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_utilisateur;
    private String nom;
    private String prenom;
    private String email;
    private String login;
    private String password;
    private String phone;
    private Date date_naissance;
    private String address;
    @OneToMany(mappedBy = "unUtilisateur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Compte> comptes = new LinkedHashSet<Compte>();

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id_utilisateur=" + id_utilisateur +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", date_naissance=" + (new java.sql.Date(date_naissance.getTime())) +
                ", address='" + address + '\'' +
//                ", comptes=" + comptes +
                '}';
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public Integer getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(Integer id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
    }
}
