package com.example.gestion_flotte.service;

import com.example.gestion_flotte.models.Modeles;
import com.example.gestion_flotte.repository.ModelesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ModelesService {


        @Autowired
        ModelesRepository modelesRepository;

        public List<Modeles> getAllModeles()
        {
            List<Modeles> modeles = new ArrayList<Modeles>();
            modelesRepository.findAll().forEach(books1 -> modeles.add(books1));
            return modeles;
        }



        //getting a specific record by using the method findById() of CrudRepository
        public Modeles getModelesById(int id)
        {
            return modelesRepository.findById(id).get();
        }
        //saving a specific record by using the method save() of CrudRepository
        public void saveOrUpdate(Modeles modeles)
        {
            modelesRepository.save(modeles);
        }
        //deleting a specific record by using the method deleteById() of CrudRepository
        public void delete(int id)
        {
            modelesRepository.deleteById(id);
        }
        //updating a record
        public void update(Modeles modeles, int bookid)
        {
            modelesRepository.save(modeles);
        }
    }


