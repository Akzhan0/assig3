package model;

public abstract class BookBase {
    protected int id;
    protected String title;
    protected double price;
    protected Category category;

    public BookBase() {}

    public BookBase(int id, String title, double price, Category category) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.category = category;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public double getPrice() { return price; }
    public Category getCategory() { return category; }

    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setPrice(double price) { this.price = price; }
    public void setCategory(Category category) { this.category = category; }

    public abstract String getType();

    public void printInfo() {
        System.out.println(
                "[" + getType() + "] id=" + id +
                        ", title='" + title + "'" +
                        ", price=" + price +
                        ", category=" + (category != null ? category.getName() : "null")
        );
    }
}
