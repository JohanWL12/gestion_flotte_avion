package com.example.gestion_flotte_avion_ws.repository;

import com.example.gestion_flotte_avion_ws.models.Kilometrages;
import com.example.gestion_flotte_avion_ws.models.Avions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface AvionsRepository extends CrudRepository<Avions,Integer> {
//    @Query(value = "select k.* from kilometrages k where idavion=?1",nativeQuery = true)
//    public ArrayList<Object[]> getKilometrages(Integer idavion);

    @Query(value = "select k from Kilometrages k where k.idAvion=?1",nativeQuery = false)
    public ArrayList<Kilometrages> getKilometrages(Integer idavion);
}
