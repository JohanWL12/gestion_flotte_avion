package com.example.gestion_flotte.repository;

import com.example.gestion_flotte.models.Kilometrages;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KilometragesRepository extends CrudRepository<Kilometrages,Integer> {
}
