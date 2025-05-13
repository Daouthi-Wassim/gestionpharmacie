package com.gestion.pharmacie.service;



import com.gestion.pharmacie.entities.Categorie;
import com.gestion.pharmacie.entities.Medicament;

import java.util.List;

public interface IServiceCategorie {
    Categorie createCategorie(Categorie categorie);
    List<Categorie> findAllCategories();
    Categorie updateCategorie(Categorie categorie);
    Categorie findCategorieById(int id);

    List<Medicament> findMedicamentsByCategorie(int id);
}