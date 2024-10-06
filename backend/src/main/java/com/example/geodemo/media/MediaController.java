package com.example.geodemo.media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/rename/{oldName}/{newName}")
    public String renameMedia(@PathVariable String oldName, @PathVariable String newName) {
        return mediaService.renameMedia(oldName, newName);
    }

    @PutMapping("/annotate/{mediaName}/{annotation}")
    public String addAnnotations(@PathVariable String mediaName, @PathVariable String annotation) {
        return mediaService.addAnnotations(mediaName, annotation);
    }
}

