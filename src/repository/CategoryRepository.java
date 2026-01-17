package repository;

import model.Category;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {

    // получить все категории
    public List<Category> findAll() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT category_id, name FROM categories ORDER BY category_id;";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("category_id");
                String name = rs.getString("name");
                list.add(new Category(id, name));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // найти категорию по id
    public Category findById(int id) {
        String sql = "SELECT category_id, name FROM categories WHERE category_id = ?;";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int catId = rs.getInt("category_id");
                    String name = rs.getString("name");
                    return new Category(catId, name);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

