package com.ccsw.tutorial.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.tutorial.category.model.CategoryDTO;
import com.ccsw.tutorial.category.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Category", description = "API of Category")
@RequestMapping(value = "/category")
@RestController
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Operation(summary = "Find", description = "Method that return a list of categories")
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<CategoryDTO> findAll() {
        return this.categoryService.findAll();
    }

    @Operation(summary = "Save or Update", description = "Method that saves or update categories")
    @RequestMapping(path = { "", "/{id}" }, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody CategoryDTO dto) {
        this.categoryService.save(id, dto);
    }

    @Operation(summary = "Delete", description = "Method that deletes categories")
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        this.categoryService.delete(id);
    }

}
