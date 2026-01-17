package controller;

import dto.BookCreateDto;
import model.BookBase;
import model.Category;
import service.BookService;
import service.CategoryService;

import java.util.List;

public class LibraryController {

    private final CategoryService categoryService = new CategoryService();
    private final BookService bookService = new BookService();

    public List<Category> listCategories() {
        return categoryService.getAllCategories();
    }

    public int createBook(BookCreateDto dto) {
        return bookService.addBook(dto);
    }

    public List<BookBase> listBooks() {
        return bookService.getAllBooks();
    }
}
