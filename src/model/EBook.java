package model;

public class EBook extends BookBase {
    private double fileSizeMb;

    public EBook() {}

    public EBook(int id, String title, double price, Category category, double fileSizeMb) {
        super(id, title, price, category);
        this.fileSizeMb = fileSizeMb;
    }

    public double getFileSizeMb() { return fileSizeMb; }
    public void setFileSizeMb(double fileSizeMb) { this.fileSizeMb = fileSizeMb; }

    @Override
    public String getType() {
        return "EBOOK";
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("   fileSizeMb=" + fileSizeMb);
    }
}
