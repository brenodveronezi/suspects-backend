package br.com.dig.suspeitos.controller;

import br.com.dig.suspeitos.response.ResponseFile;
import br.com.dig.suspeitos.services.ImageDataService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/upload")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ImageDataController {

    private ImageDataService imageDataService;

    @PostMapping
    public ResponseEntity<?> imageData(@RequestParam("image")MultipartFile file) throws IOException {
        return imageDataService.store(file);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateImageData(@PathVariable String id, @RequestParam("image") MultipartFile file) throws IOException {
        return imageDataService.update(id, file);
    }

    @GetMapping
    public ResponseEntity<List<ResponseFile>> findAllImages(){
        return imageDataService.getAllImages();
    }

    @GetMapping("/{id}" )
    public ResponseEntity<byte[]> getImageByName(@PathVariable("id") String id){
        return imageDataService.getImage(id);
    }

}
