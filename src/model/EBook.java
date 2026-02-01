package model;

import exception.InvalidInputException;

public class EBook extends BookBase {
    private double fileSizeMb;

    public EBook() {}

    public EBook(int id, String title, double price, Category category, double fileSizeMb) {
        super(id, title, price, category);
        this.fileSizeMb = fileSizeMb;
    }

    @Override
    public String getType() {
        return "EBOOK";
    }

    @Override
    public void validate() {
        if (getTitle() == null || getTitle().trim().isEmpty())
            throw new InvalidInputException("title must not be empty");
        if (getPrice() <= 0)
            throw new InvalidInputException("price must be > 0");
        if (getCategory() == null)
            throw new InvalidInputException("category is required");
        if (fileSizeMb <= 0)
            throw new InvalidInputException("fileSizeMb must be > 0");
    }

    public double getFileSizeMb() { return fileSizeMb; }
    public void setFileSizeMb(double fileSizeMb) { this.fileSizeMb = fileSizeMb; }

    public String fullInfo() {
        return shortInfo() + ", fileSizeMb=" + fileSizeMb;
    }
}

