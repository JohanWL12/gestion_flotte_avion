package com.example.gestion_flotte.service;

import com.example.gestion_flotte.models.Avions;
import com.example.gestion_flotte.models.Kilometrages;
import com.example.gestion_flotte.repository.AvionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AvionsService {
    @Autowired
    AvionsRepository avionsRepository;

    //getting all avions record by using the method findaAll() of CrudRepository
    public List<Avions> getAllAvions()
    {
        List<Avions> avions = new ArrayList<Avions>();
        avionsRepository.findAll().forEach(avions::add);
        return avions;
    }
    //getting a specific record by using the method findById() of CrudRepository
    public Avions getAvionsById(int id)
    {
        return avionsRepository.findById(id).get();
    }
    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(Avions avions)
    {
        avionsRepository.save(avions);
    }
    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int id)
    {
        avionsRepository.deleteById(id);
    }
    //updating a record
    public void update(Avions avions, int bookid)
    {
        avionsRepository.save(avions);
    }

    public List<Kilometrages> getKilometrages(Avions v){
        return avionsRepository.getKilometrages(v.getIdAvion());
    }
    public List<Kilometrages> getKilometrages(int avionid){
        return avionsRepository.getKilometrages(avionid);
    }
}
