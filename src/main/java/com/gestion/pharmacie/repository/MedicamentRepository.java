package com.gestion.pharmacie.repository;

import com.gestion.pharmacie.entities.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MedicamentRepository extends JpaRepository<Medicament, Integer> {
    List<Medicament> findByNomContainingIgnoreCase(String nom);
    List<Medicament> findAllByOrderByNomAsc();
    List<Medicament> findByCategorieId(Integer categorieId);
}