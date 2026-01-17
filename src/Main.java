import controller.LibraryController;
import dto.BookCreateDto;
import model.BookBase;
import utils.SchemaInitializer;

public class Main {
    public static void main(String[] args) {

        SchemaInitializer.init();

        LibraryController controller = new LibraryController();

        System.out.println("  CATEGORIES  ");
        controller.listCategories().forEach(System.out::println);

        BookCreateDto dto = new BookCreateDto();
        dto.title = "Java for Beginners";
        dto.price = 12.50;
        dto.type = "EBOOK";
        dto.fileSizeMb = 6.2;
        dto.categoryId = 1;

        int newId = controller.createBook(dto);
        System.out.println(" New book created, id=" + newId);

        System.out.println("  BOOKS  ");
        for (BookBase b : controller.listBooks()) {
            b.printInfo();
        }
    }
}



