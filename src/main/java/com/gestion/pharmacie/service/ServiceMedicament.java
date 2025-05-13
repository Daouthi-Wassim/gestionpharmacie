package com.gestion.pharmacie.service;

import com.gestion.pharmacie.entities.Medicament;
import com.gestion.pharmacie.repository.MedicamentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ServiceMedicament implements IServiceMedicament {

    private final MedicamentRepository medicamentRepository;
    // Manually add the constructor
    public ServiceMedicament(MedicamentRepository medicamentRepository) {
        this.medicamentRepository = medicamentRepository;
    }
    @Override
    public Medicament createMedicament(Medicament medicament) {
        return medicamentRepository.save(medicament);
    }

    @Override
    public Medicament updateMedicament(Medicament medicament) {
        return medicamentRepository.save(medicament);
    }
    @Override
    public List<Medicament> findAllMedicaments() {
        return medicamentRepository.findAllByOrderByNomAsc();
    }




    @Override
    public List<Medicament> searchByNom(String keyword) {
        return List.of();
    }

    @Override
    public List<Medicament> findByCategorieId(Integer categorieId) {
        return List.of();
    }

    @Override
    public boolean medicamentExist(int id) {
        return false;
    }

    @Override
    public Medicament findMedicamentById(int id) {
        return medicamentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteMedicament(int id) {
        medicamentRepository.deleteById(id);
    }
}