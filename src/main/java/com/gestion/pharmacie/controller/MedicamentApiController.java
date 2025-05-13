package com.gestion.pharmacie.controller;

import com.gestion.pharmacie.entities.Medicament;
import com.gestion.pharmacie.service.IServiceMedicament;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicaments")
//@Tag(name = "Médicaments", description = "API de gestion des médicaments")
public class MedicamentApiController {

    private final IServiceMedicament serviceMedicament;

    public MedicamentApiController(IServiceMedicament serviceMedicament) {
        this.serviceMedicament = serviceMedicament;
    }

    @Operation(
            summary = "Récupérer tous les médicaments",
            description = "Retourne une liste triée de tous les médicaments"
    )
    @ApiResponse(responseCode = "200", description = "Liste des médicaments trouvée")
    @GetMapping
    public ResponseEntity<List<Medicament>> getAllMedicaments() {
        return ResponseEntity.ok(serviceMedicament.findAllMedicaments());
    }

    @Operation(summary = "Rechercher un médicament par ID")
    @ApiResponse(responseCode = "200", description = "Médicament trouvé")
    @ApiResponse(responseCode = "404", description = "Médicament non trouvé")
    @GetMapping("/{id}")
    public ResponseEntity<Medicament> getMedicamentById(@PathVariable int id) {
        Medicament medicament = serviceMedicament.findMedicamentById(id);
        return medicament != null ?
                ResponseEntity.ok(medicament) :
                ResponseEntity.notFound().build();
    }
}