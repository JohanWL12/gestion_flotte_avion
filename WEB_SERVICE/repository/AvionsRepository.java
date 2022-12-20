package com.example.gestion_flotte.repository;

import com.example.gestion_flotte.models.Avions;
import com.example.gestion_flotte.models.Images;
import com.example.gestion_flotte.models.Kilometrages;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface AvionsRepository extends CrudRepository<Avions,Integer> {
//    @Query(value = "select k.* from kilometrages k where idavion=?1",nativeQuery = true)
//    public ArrayList<Object[]> getKilometrages(Integer idavion);

    @Query(value = "select k from Kilometrages k where k.idAvion=?1",nativeQuery = false)
    public ArrayList<Kilometrages> getKilometrages(Integer idavion);

//    @Query(value = "select * from images where idavion=?1 order by datechangement desc limit 1",nativeQuery = true)
//    public Images getImage(int idAvion);
}
