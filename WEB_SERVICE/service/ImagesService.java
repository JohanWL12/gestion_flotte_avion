package com.example.gestion_flotte_avion_ws.service;

import com.example.gestion_flotte_avion_ws.models.Images;
import com.example.gestion_flotte_avion_ws.repository.ImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImagesService {

    @Autowired
    ImagesRepository imagesRepository;

    //getting all images record by using the method findAll() of CrudRepository
    public List<Images> getAllImages()
    {
        List<Images> images = new ArrayList<Images>();
        imagesRepository.findAll().forEach(books1 -> images.add(books1));
        return images;
    }
    //getting a specific record by using the method findById() of CrudRepository
    public Images getImagesById(int id)
    {
        return imagesRepository.findById(id).get();
    }
    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(Images images)
    {
        imagesRepository.save(images);
    }
    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int id)
    {
        imagesRepository.deleteById(id);
    }
    //updating a record
    public void update(Images images, int bookid)
    {
        imagesRepository.save(images);
    }

    public Images getImage(int idAvion){
       return imagesRepository.getImage(idAvion);
    }

    public void setImage(int idAvion, String base64) {imagesRepository.setImage(idAvion, base64);}
}
