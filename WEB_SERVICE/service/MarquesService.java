package com.example.gestion_flotte.service;

import com.example.gestion_flotte.models.Marques;
import com.example.gestion_flotte.repository.MarquesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarquesService {
    @Autowired
    MarquesRepository marquesRepository;

    //getting all marques record by using the method findAll() of CrudRepository
    public List<Marques> getAllMarques()
    {
        List<Marques> marques = new ArrayList<Marques>();
        marquesRepository.findAll().forEach(books1 -> marques.add(books1));
        return marques;
    }
    //getting a specific record by using the method findById() of CrudRepository
    public Marques getMarquesById(int id)
    {
        return marquesRepository.findById(id).get();
    }
    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(Marques marques)
    {
        marquesRepository.save(marques);
    }
    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int id)
    {
        marquesRepository.deleteById(id);
    }
    //updating a record
    public void update(Marques marques, int bookid)
    {
        marquesRepository.save(marques);
    }
}

