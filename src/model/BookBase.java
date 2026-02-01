package model;

public abstract class   BookBase {
    private int id;
    private String title;
    private double price;
    private Category category;

    protected BookBase() {}

    protected BookBase(int id, String title, double price, Category category) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.category = category;
    }

    // 2 abstract methods
    public abstract String getType();
    public abstract void validate();

    // 1 concrete method
    public String shortInfo() {
        String catName = (category == null) ? "null" : category.getName();
        return "[" + getType() + "] id=" + id +
                ", title='" + title + "'" +
                ", price=" + price +
                ", category=" + catName;
    }

    // getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public double getPrice() { return price; }
    public Category getCategory() { return category; }

    // setters
    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setPrice(double price) { this.price = price; }
    public void setCategory(Category category) { this.category = category; }
}

