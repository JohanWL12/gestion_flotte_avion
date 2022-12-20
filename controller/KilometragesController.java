package com.example.gestion_flotte_avion_ws.controller;

import com.example.gestion_flotte_avion_ws.models.Kilometrages;
import com.example.gestion_flotte_avion_ws.service.KilometragesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kilometrages")
public class KilometragesController {
    @Autowired
    KilometragesService kilometragesService;

    @GetMapping()
    private List<Kilometrages> getAllKilometrages()
    {
        return kilometragesService.getAllKilometrages();
    }

    @GetMapping("/{idkm}")
    private Kilometrages getAllKilometrages(@PathVariable("idkm") int idKm)
    {
        return kilometragesService.getKilometragesById(idKm);
    }

    @DeleteMapping("/{idkm}")
    private void deleteBook(@PathVariable("idkm") int idKm)
    {
        kilometragesService.delete(idKm);
    }

    @PostMapping()
    private int saveBook(@RequestBody Kilometrages kms)
    {
        kilometragesService.saveOrUpdate(kms);
        return kms.getId();
    }

    @PutMapping()
    private Kilometrages update(@RequestBody Kilometrages kms)
    {
        kilometragesService.saveOrUpdate(kms);
        return kms;
    }
}
