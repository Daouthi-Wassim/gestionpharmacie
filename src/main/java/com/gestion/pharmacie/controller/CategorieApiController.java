package com.gestion.pharmacie.controller;

import com.gestion.pharmacie.entities.Categorie;
import com.gestion.pharmacie.service.IServiceCategorie;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
@Tag(name = "Catégories", description = "API de gestion des catégories")
public class CategorieApiController {

    private final IServiceCategorie serviceCategorie;

    public CategorieApiController(IServiceCategorie serviceCategorie) {
        this.serviceCategorie = serviceCategorie;
    }

    @Operation(summary = "Créer une nouvelle catégorie")
    @PostMapping
    public ResponseEntity<Categorie> createCategorie(@RequestBody Categorie categorie) {
        return ResponseEntity.ok(serviceCategorie.createCategorie(categorie));
    }
}