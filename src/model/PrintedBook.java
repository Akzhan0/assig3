package model;

public class PrintedBook extends BookBase {
    private int pages;

    public PrintedBook() {}

    public PrintedBook(int id, String title, double price, Category category, int pages) {
        super(id, title, price, category);
        this.pages = pages;
    }

    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }

    @Override
    public String getType() {
        return "PRINTED";
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("   pages=" + pages);
    }
}
