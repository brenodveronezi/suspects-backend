package br.com.dig.suspeitos.repository;

import br.com.dig.suspeitos.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.Optional;

@Repository
public interface ImageDataRepository  extends JpaRepository<ImageData, String> {

    //Optional<ImageData> findByName(String name);

}
