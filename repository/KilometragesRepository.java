package com.example.gestion_flotte_avion_ws.repository;

import com.example.gestion_flotte_avion_ws.models.Kilometrages;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KilometragesRepository extends CrudRepository<Kilometrages,Integer> {
}
