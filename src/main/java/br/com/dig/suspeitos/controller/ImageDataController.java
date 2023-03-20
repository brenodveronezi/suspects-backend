package br.com.dig.suspeitos.controller;

import br.com.dig.suspeitos.response.ImageUploadResponse;
import br.com.dig.suspeitos.services.ImageDataService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "/upload")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ImageDataController {

    private ImageDataService imageDataService;

    @PostMapping
    public ResponseEntity<?> imageData(@RequestParam("image")MultipartFile file) throws IOException {
        return imageDataService.store(file);
    }


    @GetMapping("/{id}" )
    public ResponseEntity<byte[]> getImageByName(@PathVariable("id") String id){
        return imageDataService.getImage(id);
    }

}
