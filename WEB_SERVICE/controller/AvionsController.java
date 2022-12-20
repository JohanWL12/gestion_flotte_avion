package com.example.gestion_flotte.controller;

import com.example.gestion_flotte.format.Data;
import com.example.gestion_flotte.models.Avions;
import com.example.gestion_flotte.models.Kilometrages;
import com.example.gestion_flotte.service.AvionsService;
import com.example.gestion_flotte.service.ModelesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/avions")
public class AvionsController {
    @Autowired
    AvionsService avionsService;
    @Autowired
    ModelesService modelesService;

    //creating a get mapping that retrieves all the Avions detail from the database
    @GetMapping()
    private Object getAllAvions()
    {
        try {
            return new Data(avionsService.getAllAvions());
        }catch (Exception e){
            return new Error(e);
        }
    }
    //creating a get mapping that retrieves the detail of a specific avions
    @GetMapping("/{avionid}")
    private Avions getAvions(@PathVariable("avionid") int avionid)
    {
        return avionsService.getAvionsById(avionid);
    }
    //creating a delete mapping that deletes a specified avions
    @DeleteMapping("/{avionid}")
    private void deleteBook(@PathVariable("avionid") int avionid)
    {
        avionsService.delete(avionid);
    }
    //creating post mapping that post the avions detail in the database
    @PostMapping()
    private int saveBook(@RequestBody Avions avions)
    {
        avionsService.saveOrUpdate(avions);
        return avions.getIdAvion();
    }
    //creating put mapping that updates the avions detail
    @PutMapping()
    private Avions update(@RequestBody Avions avions)
    {
        avionsService.saveOrUpdate(avions);
        return avions;
    }

    @GetMapping("/{avionid}/kilometrages")
    private List<Kilometrages> getKilometrages(@PathVariable("avionid") int avionid){
        Avions v=new Avions();
        v.setIdAvion(avionid);
        return avionsService.getKilometrages(v);
    }

    @GetMapping("/{avionid}/details")
    private Object getDetailsAvion(@PathVariable("avionid") int avionid){
        try{
            HashMap<String,Object> details=new HashMap<String,Object>();
            Avions v=avionsService.getAvionsById(avionid);
            details.put("avion",v);
            details.put("modele",modelesService.getModelesById(v.getModele().getIdModele()));
            details.put("kilometrages",avionsService.getKilometrages(avionid));
            return new Data(details);
        }catch(Exception e){
            return new Error(e);
        }
    }
}
