package com.example.gestion_flotte_avion_ws.repository;

import com.example.gestion_flotte_avion_ws.models.Images;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ImagesRepository extends CrudRepository<Images,Integer> {
    @Query(value = "select * from images where idavion=?1 order by datechangement desc limit 1",nativeQuery = true)
    public Images getImage(int idAvion);

    @Transactional
    @Query(value = "insert into images values (?1, decode(?2, 'base64'))",nativeQuery = true)
    public void setImage(int idAvion, String base64);
}
