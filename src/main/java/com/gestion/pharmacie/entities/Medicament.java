package com.gestion.pharmacie.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
public class Medicament {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String description;
    private double prix;

    private String imagePath;

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public void setFournisseurs(List<Fournisseur> fournisseurs) {
        this.fournisseurs = fournisseurs;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public double getPrix() {
        return prix;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public List<Fournisseur> getFournisseurs() {
        return fournisseurs;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @ManyToOne
    private Categorie categorie;

    @ManyToMany
    @JoinTable(
            name = "medicament_fournisseur",
            joinColumns = @JoinColumn(name = "medicament_id"),
            inverseJoinColumns = @JoinColumn(name = "fournisseur_id")
    )
    private List<Fournisseur> fournisseurs;

}