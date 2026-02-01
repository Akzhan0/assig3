package model;

import exception.InvalidInputException;

public class PrintedBook extends BookBase {
    private int pages;

    public PrintedBook() {}

    public PrintedBook(int id, String title, double price, Category category, int pages) {
        super(id, title, price, category);
        this.pages = pages;
    }

    @Override
    public String getType() {
        return "PRINTED";
    }

    @Override
    public void validate() {
        if (getTitle() == null || getTitle().trim().isEmpty())
            throw new InvalidInputException("title must not be empty");
        if (getPrice() <= 0)
            throw new InvalidInputException("price must be > 0");
        if (getCategory() == null)
            throw new InvalidInputException("category is required");
        if (pages <= 0)
            throw new InvalidInputException("pages must be > 0");
    }

    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }

    public String fullInfo() {
        return shortInfo() + ", pages=" + pages;
    }
}

