package com.ccsw.tutorial.category.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ccsw.tutorial.category.model.CategoryDTO;

@Service
public class CategoryServiceImpl implements CategoryService {

    private long SEQUENCE = 1;
    private Map<Long, CategoryDTO> categories = new HashMap<Long, CategoryDTO>();

    public List<CategoryDTO> findAll() {
        return new ArrayList<CategoryDTO>(this.categories.values());
    }

    public void save(Long id, CategoryDTO dto) {

        CategoryDTO category;

        if (id == null) {
            category = new CategoryDTO();
            category.setId(this.SEQUENCE++);
            this.categories.put(category.getId(), category);
        } else {
            category = this.categories.get(id);
        }

        category.setName(dto.getName());
    }

    public void delete(Long id) {
        this.categories.remove(id);
    }

}
