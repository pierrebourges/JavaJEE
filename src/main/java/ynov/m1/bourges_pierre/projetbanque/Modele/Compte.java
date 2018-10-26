package ynov.m1.bourges_pierre.projetbanque.Modele;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_compte;
    private Integer id_type_compte;
    private float solde;
    private Date date_creation;
    @OneToMany(mappedBy = "compte", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Transaction> transactions = new LinkedHashSet<Transaction>();
    @ManyToOne
    @JoinColumn(name = "UtilisateurSource")
    private Utilisateur unUtilisateur;

    public Integer getId_compte() {
        return id_compte;
    }

    public void setId_compte(Integer id_compte) {
        this.id_compte = id_compte;
    }

    public Integer getId_type_compte() {
        return id_type_compte;
    }

    public void setId_type_compte(Integer id_type_compte) {
        this.id_type_compte = id_type_compte;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Utilisateur getUnUtilisateur() {
        return unUtilisateur;
    }

    public void setUnUtilisateur(Utilisateur unUtilisateur) {
        this.unUtilisateur = unUtilisateur;
    }

}
