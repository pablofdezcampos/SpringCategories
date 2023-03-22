package com.ccsw.tutorial.category.service;

import java.util.List;

import com.ccsw.tutorial.category.model.CategoryDTO;

public interface CategoryService {

    List<CategoryDTO> findAll();

    void save(Long id, CategoryDTO dto);

    void delete(Long id);
}
