package com.example.geodemo.media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController for operations on Media objects
 * Calls methods in mediaService
 */
@RestController
@RequestMapping("/media")
public class MediaController {

    private final MediaService mediaService;

    @Autowired
    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @PatchMapping("/rename/{id}")
    public String renameMedia(@PathVariable String id, @RequestBody String newName) {
        return mediaService.renameMedia(id, newName);
    }

    @PatchMapping("/annotate/{id}")
    public String addAnnotations(@PathVariable String id, @RequestBody String annotation) {
        return mediaService.addAnnotations(id, annotation);
    }

    @PatchMapping("/longitude/{id}")
    public String addLong(@PathVariable String id, @RequestBody double longitude) {
        return mediaService.addLong(id, longitude);
    }

    @PatchMapping("/latitude/{id}")
    public String addLat(@PathVariable String id, @RequestBody double latitude) {
        return mediaService.addLat(id, latitude);
    }

    @PatchMapping("/updateMedia/{id}")
    public ResponseEntity<Media> updateMedia(@PathVariable String id, @RequestBody Media update){
        try{
            mediaService.updateMedia(id,update);

            return ResponseEntity.noContent().build();
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }
}

