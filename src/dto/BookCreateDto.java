package dto;

public class BookCreateDto {
    private String title;
    private double price;
    private String type;       
    private double fileSizeMb; 
    private int pages;         
    private int categoryId;

    public BookCreateDto() {}

    public BookCreateDto(String title, double price, String type, double fileSizeMb, int pages, int categoryId) {
        this.title = title;
        this.price = price;
        this.type = type;
        this.fileSizeMb = fileSizeMb;
        this.pages = pages;
        this.categoryId = categoryId;
    }

    public String getTitle() { return title; }
    public double getPrice() { return price; }
    public String getType() { return type; }
    public double getFileSizeMb() { return fileSizeMb; }
    public int getPages() { return pages; }
    public int getCategoryId() { return categoryId; }

    public void setTitle(String title) { this.title = title; }
    public void setPrice(double price) { this.price = price; }
    public void setType(String type) { this.type = type; }
    public void setFileSizeMb(double fileSizeMb) { this.fileSizeMb = fileSizeMb; }
    public void setPages(int pages) { this.pages = pages; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }
    
}


