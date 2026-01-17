package service;

import dto.BookCreateDto;
import exception.ValidationException;
import model.*;
import repository.BookRepository;

import java.util.List;

public class BookService {

    private final BookRepository repo = new BookRepository();
    private final CategoryService categoryService = new CategoryService();

    public int addBook(BookCreateDto dto) {

        if (dto == null) {
            throw new ValidationException("DTO is null");
        }

        if (dto.title == null || dto.title.trim().isEmpty()) {
            throw new ValidationException("Title cannot be empty");
        }

        if (dto.price <= 0) {
            throw new ValidationException("Price must be > 0");
        }

        Category category = categoryService.getCategoryById(dto.categoryId);
        if (category == null) {
            throw new ValidationException("Category not found. id=" + dto.categoryId);
        }

        String type = (dto.type == null) ? "" : dto.type.trim().toUpperCase();

        // --- EBOOK ---
        if (type.equals("EBOOK")) {
            if (dto.fileSizeMb == null || dto.fileSizeMb <= 0) {
                throw new ValidationException("fileSizeMb must be > 0 for EBOOK");
            }

            EBook b = new EBook(0, dto.title.trim(), dto.price, category, dto.fileSizeMb);
            return repo.createEBook(b);
        }

        // --- PRINTED ---
        if (type.equals("PRINTED")) {
            if (dto.pages == null || dto.pages <= 0) {
                throw new ValidationException("pages must be > 0 for PRINTED");
            }

            PrintedBook b = new PrintedBook(0, dto.title.trim(), dto.price, category, dto.pages);
            return repo.createPrintedBook(b);
        }

        throw new ValidationException("Unknown book type: " + dto.type);
    }

    public List<BookBase> getAllBooks() {
        return repo.findAll();
    }
}


