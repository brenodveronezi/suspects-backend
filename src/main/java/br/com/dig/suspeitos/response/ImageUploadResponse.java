package br.com.dig.suspeitos.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ImageUploadResponse {

    private String id;


    public ImageUploadResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
