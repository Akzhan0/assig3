package repository;

import model.*;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    // добавить EBook
    public int createEBook(EBook book) {
        String sql =
                "INSERT INTO books(title, price, book_type, file_size_mb, pages, category_id) " +
                        "VALUES (?, ?, 'EBOOK', ?, NULL, ?) RETURNING book_id;";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, book.getTitle());
            ps.setDouble(2, book.getPrice());
            ps.setDouble(3, book.getFileSizeMb());
            ps.setInt(4, book.getCategory().getId());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("book_id");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

    // добавить PrintedBook
    public int createPrintedBook(PrintedBook book) {
        String sql =
                "INSERT INTO books(title, price, book_type, file_size_mb, pages, category_id) " +
                        "VALUES (?, ?, 'PRINTED', NULL, ?, ?) RETURNING book_id;";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, book.getTitle());
            ps.setDouble(2, book.getPrice());
            ps.setInt(3, book.getPages());
            ps.setInt(4, book.getCategory().getId());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("book_id");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

    // получить все книги
    public List<BookBase> findAll() {
        List<BookBase> list = new ArrayList<>();

        String sql =
                "SELECT b.book_id, b.title, b.price, b.book_type, b.file_size_mb, b.pages, " +
                        "c.category_id, c.name AS category_name " +
                        "FROM books b JOIN categories c ON b.category_id = c.category_id " +
                        "ORDER BY b.book_id;";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                // category
                int catId = rs.getInt("category_id");
                String catName = rs.getString("category_name");
                Category category = new Category(catId, catName);

                // base fields
                int id = rs.getInt("book_id");
                String title = rs.getString("title");
                double price = rs.getDouble("price");
                String type = rs.getString("book_type");

                // create correct object
                if ("EBOOK".equals(type)) {
                    double size = rs.getDouble("file_size_mb");
                    EBook eb = new EBook(id, title, price, category, size);
                    list.add(eb);
                } else {
                    int pages = rs.getInt("pages");
                    PrintedBook pb = new PrintedBook(id, title, price, category, pages);
                    list.add(pb);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
