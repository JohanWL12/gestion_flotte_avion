package com.example.gestion_flotte_avion_ws.controller;

import com.example.gestion_flotte_avion_ws.models.Images;
import com.example.gestion_flotte_avion_ws.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/images")
public class ImagesController {

    @Autowired
    ImagesService imagesService;

    //creating a get mapping that retrieves all the Images detail from the database
    @GetMapping
    private List<Images> getAllImages() {
        return imagesService.getAllImages();
    }

    //creating a get mapping that retrieves the detail of a specific image
    @GetMapping("/{image_id}")
    private Images getImages(@PathVariable("image_id") int image_id) {
        return imagesService.getImagesById(image_id);
    }

    //creating a delete mapping that deletes a specified image
    @DeleteMapping("/{image_id}")
    private void deleteBook(@PathVariable("image_id") int image_id) {
        imagesService.delete(image_id);
    }

    //creating post mapping that post the image detail in the database
    @PostMapping
    private int saveImages(@RequestBody Images images) {
        imagesService.saveOrUpdate(images);
        return images.getIdImage();
    }

    //creating put mapping that updates the image detail
    @PutMapping
    private Images updateImages(@RequestBody Images images) {
        imagesService.saveOrUpdate(images);
        return images;
    }

    @GetMapping("/idavion/{idavion}")
    private Images getImagesByAvion(@PathVariable("idavion") int idAvion){
        return imagesService.getImage(idAvion);
    }
}
