package com.gestion.pharmacie.controller;


import com.gestion.pharmacie.service.IServiceFournisseur;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fournisseurs")
@Tag(name = "Fournisseurs", description = "API de gestion des fournisseurs")
public class FournisseurApiController {

    private final IServiceFournisseur serviceFournisseur;

    public FournisseurApiController(IServiceFournisseur serviceFournisseur) {
        this.serviceFournisseur = serviceFournisseur;
    }

    @Operation(summary = "Supprimer un fournisseur par ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFournisseur(@PathVariable int id) {
        serviceFournisseur.deleteFournisseur(id);
        return ResponseEntity.noContent().build();
    }
}