package com.example.gestion_flotte.repository;

import com.example.gestion_flotte.models.Marques;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarquesRepository extends CrudRepository<Marques,Integer> {
}

