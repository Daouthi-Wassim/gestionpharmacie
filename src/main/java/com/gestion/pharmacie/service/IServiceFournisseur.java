package com.gestion.pharmacie.service;




import com.gestion.pharmacie.entities.Fournisseur;

import java.util.List;

public interface IServiceFournisseur {
    Fournisseur createFournisseur(Fournisseur fournisseur);
    List<Fournisseur> findAllFournisseurs();
    Fournisseur findFournisseurById(int id);
    Fournisseur updateFournisseur(Fournisseur fournisseur);
    void deleteFournisseur(int id);

    void addMedicament(int fournisseurId, int medicamentId);
}
