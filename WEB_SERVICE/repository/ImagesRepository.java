package com.example.gestion_flotte.repository;

import com.example.gestion_flotte.models.Images;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ImagesRepository extends CrudRepository<Images,Integer> {
    @Query(value = "select * from images where idavion=?1 order by datechangement desc limit 1",nativeQuery = true)
    public Images getImage(int idAvion);
}
