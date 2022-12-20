package com.example.gestion_flotte_avion_ws.repository;

import com.example.gestion_flotte_avion_ws.models.Marques;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarquesRepository extends CrudRepository<Marques,Integer> {
}

