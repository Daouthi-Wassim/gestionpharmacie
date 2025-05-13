package com.gestion.pharmacie.controller;


import com.gestion.pharmacie.entities.Categorie;
import com.gestion.pharmacie.service.IServiceCategorie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categorie/")

public class CategorieController {
    private final IServiceCategorie serviceCategorie;
    // Constructeur explicite
    public CategorieController(IServiceCategorie serviceCategorie) {
        this.serviceCategorie = serviceCategorie;
    }
    @GetMapping("new")
    public String showAddForm(Model model) {
        model.addAttribute("categorie", new Categorie());
        return "ajoutCategorie";
    }

    @PostMapping("add")
    public String addCategorie(@ModelAttribute Categorie categorie) {
        serviceCategorie.createCategorie(categorie);
        return "redirect:/medicament/all";
    }
}