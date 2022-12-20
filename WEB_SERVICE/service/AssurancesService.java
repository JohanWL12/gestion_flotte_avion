<<<<<<< Updated upstream
package com.example.gestion_flotte.service;

import com.example.gestion_flotte.models.Assurances;
import com.example.gestion_flotte.repository.AssurancesRepository;
=======
package com.example.gestion_flotte_avion_ws.service;

import com.example.gestion_flotte_avion_ws.models.Assurances;
import com.example.gestion_flotte_avion_ws.repository.AssurancesRepository;
>>>>>>> Stashed changes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AssurancesService {
    @Autowired
    AssurancesRepository assurancesRepository;

    public List<Assurances> getAllAssurances()
    {
        List<Assurances> assurances = new ArrayList<>();
        assurancesRepository.findAll().forEach(assurances::add);
        return assurances;
    }

    public Assurances getAssurancesById(int id)
    {
        return assurancesRepository.findById(id).get();
    }

    public void saveOrUpdate(Assurances assurances)
    {
        assurancesRepository.save(assurances);
    }

    public void delete(int id)
    {
        assurancesRepository.deleteById(id);
    }

    public void update(Assurances avions, int bookid)
    {
        assurancesRepository.save(avions);
    }

    public List<Assurances> getPreDateExpiration(long nbmois){
        String condition=nbmois+" months";
        LocalDateTime ldt=LocalDateTime.now();
        ldt=ldt.plusMonths(nbmois);
        System.out.println(ldt);
        System.out.println(condition);
        return assurancesRepository.getAssurancesPreExpiration(ldt.toString().replaceAll("T"," "));
    }

}
