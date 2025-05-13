package com.gestion.pharmacie.controller;

import com.gestion.pharmacie.entities.Fournisseur;
import com.gestion.pharmacie.service.IServiceFournisseur;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fournisseur/")

public class FournisseurController {
    private final IServiceFournisseur serviceFournisseur;

    public FournisseurController(IServiceFournisseur serviceFournisseur) {
        this.serviceFournisseur = serviceFournisseur;
    }
    @GetMapping("new")
    public String showAddForm(Model model) {
        model.addAttribute("fournisseur", new Fournisseur());
        return "ajoutFournisseur";
    }

    @PostMapping("add")
    public String addFournisseur(@ModelAttribute Fournisseur fournisseur) {
        serviceFournisseur.createFournisseur(fournisseur);
        return "redirect:/medicament/all";
    }
}
