package vn.t3h.java2109.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {
    private Integer id;
    private String img;
    private Double price;
    private String des;
    private String name;
    private Integer category;

    public ProductDTO(String img, Double price, String des, String name, Integer category) {
        this.img = img;
        this.price = price;
        this.des = des;
        this.name = name;
        this.category = category;
    }

    public ProductDTO(Integer id, String img, Double price, String des, String name, Integer category) {
        this.id = id;
        this.img = img;
        this.price = price;
        this.des = des;
        this.name = name;
        this.category = category;
    }
}
