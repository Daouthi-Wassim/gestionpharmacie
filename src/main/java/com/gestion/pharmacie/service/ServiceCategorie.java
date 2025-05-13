package com.gestion.pharmacie.service;



import com.gestion.pharmacie.entities.Categorie;
import com.gestion.pharmacie.entities.Medicament;
import com.gestion.pharmacie.repository.CategorieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ServiceCategorie implements IServiceCategorie {

    private final CategorieRepository categorieRepository;
    public ServiceCategorie(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }
    @Override
    public Categorie createCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public List<Categorie> findAllCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie updateCategorie(Categorie categorie) {
        return null;
    }

    @Override
    public Categorie findCategorieById(int id) {
        return null;
    }

    @Override
    public List<Medicament> findMedicamentsByCategorie(int id) {
        return List.of();
    }


}
