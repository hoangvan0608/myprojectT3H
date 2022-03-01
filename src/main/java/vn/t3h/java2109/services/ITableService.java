package vn.t3h.java2109.services;

import vn.t3h.java2109.dto.TableDataDTO;

public interface ITableService<T> {
    public TableDataDTO<T> findAll(Integer page, Integer perPage, String searchString);
}
