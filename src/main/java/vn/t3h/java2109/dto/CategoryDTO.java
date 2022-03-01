package vn.t3h.java2109.dto;

import lombok.Data;

@Data
public class CategoryDTO {
    private Integer id;

    private String name;

    public CategoryDTO(String name) {
        this.name = name;
    }

    public CategoryDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
