<<<<<<< Updated upstream
package com.example.gestion_flotte.controller;

import com.example.gestion_flotte.format.Data;
import com.example.gestion_flotte.models.Assurances;
import com.example.gestion_flotte.service.AssurancesService;
=======
package com.example.gestion_flotte_avion_ws.controller;

import com.example.gestion_flotte_avion_ws.format.Data;
import com.example.gestion_flotte_avion_ws.models.Assurances;
import com.example.gestion_flotte_avion_ws.service.AssurancesService;
>>>>>>> Stashed changes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assurances")
public class AssurancesController {
    @Autowired
    AssurancesService assurancesService;

    @GetMapping
    private List<Assurances> getAllAssurances() {
        return assurancesService.getAllAssurances();
    }

    @GetMapping("/{assurance_id}")
    private Assurances getAssurances(@PathVariable("assurance_id") int assurance_id) {
        return assurancesService.getAssurancesById(assurance_id);
    }

    @DeleteMapping("/{assurance_id}")
    private void deleteBook(@PathVariable("assurance_id") int assurance_id) {
        assurancesService.delete(assurance_id);
    }

    @PostMapping
    private int saveAssurances(@RequestBody Assurances assurances) {
        assurancesService.saveOrUpdate(assurances);
        return assurances.getId();
    }

    @PutMapping
    private Assurances updateAssurances(@RequestBody Assurances assurances) {
        assurancesService.saveOrUpdate(assurances);
        return assurances;
    }

    @GetMapping("/expiration/{nbmois}")
    private Object getPreExpiration(@PathVariable long nbmois){
        try {
            return new Data(assurancesService.getPreDateExpiration(nbmois));
        }catch (Exception e){
            return new Error(e);
        }
    }
}
