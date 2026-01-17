package service;

import model.Category;
import repository.CategoryRepository;

import java.util.List;

public class CategoryService {

    private final CategoryRepository repo = new CategoryRepository();

    public List<Category> getAllCategories() {
        return repo.findAll();
    }

    public Category getCategoryById(int id) {
        return repo.findById(id);
    }
}


