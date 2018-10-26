package ynov.m1.bourges_pierre.projetbanque.Modele;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_trasaction;
    private float montant;
    private Integer compte_source;
    private Integer compte_destination;
    private Date date;
    private String lebelle;

    @ManyToOne
    @JoinColumn(name = "compteId")
    private Compte compte;

    public Integer getId_trasaction() {
        return id_trasaction;
    }

    public void setId_trasaction(Integer id_trasaction) {
        this.id_trasaction = id_trasaction;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public Integer getCompte_source() {
        return compte_source;
    }

    public void setCompte_source(Integer compte_source) {
        this.compte_source = compte_source;
    }

    public Integer getCompte_destination() {
        return compte_destination;
    }

    public void setCompte_destination(Integer compte_destination) {
        this.compte_destination = compte_destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLebelle() {
        return lebelle;
    }

    public void setLebelle(String lebelle) {
        this.lebelle = lebelle;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
