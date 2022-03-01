package vn.t3h.java2109.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CateogryDTO {
    private Integer id;

    private String name;

    public CateogryDTO(String name) {
        this.name = name;
    }

}
