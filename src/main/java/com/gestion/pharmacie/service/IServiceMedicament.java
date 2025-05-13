package com.gestion.pharmacie.service;



import com.gestion.pharmacie.entities.Medicament;

import java.util.List;

public interface IServiceMedicament {
    Medicament createMedicament(Medicament medicament);
    Medicament findMedicamentById(int id);
    List<Medicament> findAllMedicaments();
    Medicament updateMedicament(Medicament medicament);
    void deleteMedicament(int id);
    List<Medicament> searchByNom(String keyword);
    List<Medicament> findByCategorieId(Integer categorieId);

    boolean medicamentExist(int id);
}