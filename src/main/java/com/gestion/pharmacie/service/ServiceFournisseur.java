package com.gestion.pharmacie.service;



import com.gestion.pharmacie.entities.Fournisseur;
import com.gestion.pharmacie.repository.FournisseurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ServiceFournisseur implements IServiceFournisseur {

    private final FournisseurRepository fournisseurRepository;
    // Manually add the constructor
    public ServiceFournisseur(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }
    @Override
    public Fournisseur createFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public List<Fournisseur> findAllFournisseurs() {
        return fournisseurRepository.findAll();
    }

    @Override
    public Fournisseur findFournisseurById(int id) {
        return fournisseurRepository.findById(id).orElse(null);
    }

    @Override
    public Fournisseur updateFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public void deleteFournisseur(int id) {
        fournisseurRepository.deleteById(id);
    }

    @Override
    public void addMedicament(int fournisseurId, int medicamentId) {

    }
}