package vn.t3h.java2109.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class TableDataDTO<T> {
    private List<T> data;
    private Integer page;
    private Integer perPage;
    private Integer totalItems;
    private Integer totalPages;

}
