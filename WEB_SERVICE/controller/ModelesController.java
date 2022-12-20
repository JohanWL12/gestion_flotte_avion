package com.example.gestion_flotte.controller;

import com.example.gestion_flotte.models.Modeles;
import com.example.gestion_flotte.service.ModelesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ModelesController {

    @Autowired
    ModelesService modelesService;

    @GetMapping("/modeles")
    private List<Modeles> getAllModeles() {
        return modelesService.getAllModeles();
    }

    @GetMapping("/modeles/{modelesid}")
    private Modeles getModeles(@PathVariable("modeleid") int modelesid) {
        return modelesService.getModelesById(modelesid);
    }

    @DeleteMapping("/modeles/{modelesid}")
    private void deleteBook(@PathVariable("modelesid") int modelesid) {
        modelesService.delete(modelesid);
    }

    @PostMapping("/modeles")
    private int saveBook(@RequestBody Modeles modeles) {
        modelesService.saveOrUpdate(modeles);
        return modeles.getIdModele();
    }

    //creating put mapping that updates the avion detail
    @PutMapping("/modeles")
    private Modeles update(@RequestBody Modeles modeles) {
        modelesService.saveOrUpdate(modeles);
        return modeles;
    }
}