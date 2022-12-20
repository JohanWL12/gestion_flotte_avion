package com.example.gestion_flotte.service;

import com.example.gestion_flotte.models.Kilometrages;
import com.example.gestion_flotte.repository.KilometragesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KilometragesService {
    @Autowired
    KilometragesRepository kilometragesRepository;

    public List<Kilometrages> getAllKilometrages()
    {
        List<Kilometrages> kilometrages = new ArrayList<>();
        kilometragesRepository.findAll().forEach(books1 -> kilometrages.add(books1));
        return kilometrages;
    }

    public Kilometrages getKilometragesById(int id)
    {
        return kilometragesRepository.findById(id).get();
    }

    public void saveOrUpdate(Kilometrages kilometrages)
    {
        kilometragesRepository.save(kilometrages);
    }

    public void delete(int id)
    {
        kilometragesRepository.deleteById(id);
    }

    public void update(Kilometrages avions, int bookid)
    {
        kilometragesRepository.save(avions);
    }
}
