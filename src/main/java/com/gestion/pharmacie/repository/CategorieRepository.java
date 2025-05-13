package com.gestion.pharmacie.repository;

import com.gestion.pharmacie.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
}