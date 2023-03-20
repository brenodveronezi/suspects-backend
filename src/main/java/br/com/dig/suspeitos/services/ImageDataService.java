package br.com.dig.suspeitos.services;

import br.com.dig.suspeitos.entity.ImageData;
import br.com.dig.suspeitos.repository.ImageDataRepository;
import br.com.dig.suspeitos.response.ImageUploadResponse;
import br.com.dig.suspeitos.utils.ImageUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageDataService {

    @Autowired
    private ImageDataRepository imageDataRepository;

    @Transactional
    public ResponseEntity<ImageUploadResponse> store(MultipartFile file) throws IOException {

        ImageData image = imageDataRepository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .data(ImageUtil.compressImage(file.getBytes())).build());

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ImageUploadResponse(
                        image.getId()));
    }


    public ResponseEntity<byte[]> getImage(String id) {
        Optional<ImageData> dbImage = imageDataRepository.findById(id);

        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(dbImage.get().getType()))
                .body(ImageUtil.decompressImage(dbImage.get().getData()));
    }
}
