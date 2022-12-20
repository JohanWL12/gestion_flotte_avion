package com.example.gestion_flotte.controller;

import com.example.gestion_flotte.models.Marques;
import com.example.gestion_flotte.service.MarquesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MarquesController {
    @Autowired
    MarquesService marquesService;

    //creating a get mapping that retrieves all the Marques detail from the database
    @GetMapping("/marques")
    private List<Marques> getAllMarques() {
        return marquesService.getAllMarques();
    }

    //creating a get mapping that retrieves the detail of a specific marque
    @GetMapping("/marque/{marque_id}")
    private Marques getMarques(@PathVariable("marque_id") int marque_id) {
        return marquesService.getMarquesById(marque_id);
    }

    //creating a delete mapping that deletes a specified marque
    @DeleteMapping("/marque/{marque_id}")
    private void deleteBook(@PathVariable("marque_id") int marque_id) {
        marquesService.delete(marque_id);
    }

    //creating post mapping that post the marque detail in the database
    @PostMapping("/Marques")
    private int saveMarques(@RequestBody Marques marques) {
        marquesService.saveOrUpdate(marques);
        return marques.getIdMarque();
    }

    //creating put mapping that updates the marque detail
    @PutMapping("/Marques")
    private Marques updateMarques(@RequestBody Marques marques) {
        marquesService.saveOrUpdate(marques);
        return marques;
    }
}

