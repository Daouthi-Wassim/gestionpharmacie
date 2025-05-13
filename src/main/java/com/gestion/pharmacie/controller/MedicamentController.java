package com.gestion.pharmacie.controller;


import com.gestion.pharmacie.entities.*;
import com.gestion.pharmacie.service.*;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.*;
import java.util.List;

@Controller
@RequestMapping("/medicament/")

public class MedicamentController {

    private final IServiceMedicament serviceMedicament;
    private final IServiceCategorie serviceCategorie;
    private final IServiceFournisseur serviceFournisseur;
    private final String UPLOAD_DIR = "uploads/";
    public MedicamentController(
            IServiceMedicament serviceMedicament,
            IServiceCategorie serviceCategorie,
            IServiceFournisseur serviceFournisseur
    ) {
        this.serviceMedicament = serviceMedicament;
        this.serviceCategorie = serviceCategorie;
        this.serviceFournisseur = serviceFournisseur;
    }
    @GetMapping("all")
    public String allMedicaments(Model model) {
        model.addAttribute("medicaments", serviceMedicament.findAllMedicaments());
        model.addAttribute("categories", serviceCategorie.findAllCategories());
        return "affiche";
    }

    @GetMapping("new")
    public String showAddForm(Model model) {
        model.addAttribute("medicament", new Medicament());
        model.addAttribute("categories", serviceCategorie.findAllCategories());
        model.addAttribute("fournisseurs", serviceFournisseur.findAllFournisseurs());
        return "ajout";
    }

    @PostMapping("add")
    public String addMedicament(
            @ModelAttribute Medicament m,
            @RequestParam("imageFile") MultipartFile file
    ) throws Exception {

        if (!file.isEmpty()) {
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.createDirectories(path.getParent());
            Files.write(path, file.getBytes());
            m.setImagePath(fileName);
        }

        serviceMedicament.createMedicament(m);
        return "redirect:/medicament/all";
    }

    @GetMapping("delete/{id}")
    public String deleteMedicament(@PathVariable int id) {
        serviceMedicament.deleteMedicament(id);
        return "redirect:/medicament/all";
    }

    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Medicament med = serviceMedicament.findMedicamentById(id);
        model.addAttribute("medicament", med);
        model.addAttribute("categories", serviceCategorie.findAllCategories());
        model.addAttribute("fournisseurs", serviceFournisseur.findAllFournisseurs());
        return "edit";
    }

    @PostMapping("update")
    public String updateMedicament(@ModelAttribute Medicament med ,
                                   @RequestParam("imageFile") MultipartFile file) throws Exception {

        if (!file.isEmpty()) {
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Files.write(Paths.get(UPLOAD_DIR + fileName), file.getBytes());
            med.setImagePath(fileName);
        }
        serviceMedicament.updateMedicament(med);
        return "redirect:/medicament/all";
    }



}