package com.example.LogiTrack.Models;

import com.example.LogiTrack.enums.StatutCommande;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime dateCommande;

    @Enumerated(EnumType.STRING)
    private StatutCommande statutCommande;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "commande" , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<LigneCommande> ligneCommandes;

    public Commande(){}

    public Commande(LocalDateTime dateCommande, StatutCommande statutCommande, Client client, List<LigneCommande> ligneCommandes) {
        this.dateCommande = dateCommande;
        this.statutCommande = statutCommande;
        this.client = client;
        this.ligneCommandes = ligneCommandes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDateTime dateCommande) {
        this.dateCommande = dateCommande;
    }

    public StatutCommande getStatutCommande() {
        return statutCommande;
    }

    public void setStatutCommande(StatutCommande statutCommande) {
        this.statutCommande = statutCommande;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<LigneCommande> getLigneCommandes() {
        return ligneCommandes;
    }

    public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
        this.ligneCommandes = ligneCommandes;
    }

    public void addLigneCommande(LigneCommande ligneCommande){
        this.ligneCommandes.add(ligneCommande);
    }
}
