package com.incidentmng.incidentmng.service;

import com.incidentmng.incidentmng.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public interface CategoryService {
    Category save(Category category);

    Optional<Category> getCategoryById(long id);

    ArrayList<Category> getAllCategories();

    Long deleteCategoryById(long id);
}
