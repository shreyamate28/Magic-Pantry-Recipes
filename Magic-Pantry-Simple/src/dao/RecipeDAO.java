package dao;

import model.Recipe;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeDAO {
    private Connection conn;

    public RecipeDAO() {
        conn = DBConnection.getConnection();
    }

    public void addRecipe(Recipe recipe) {
        String query = "INSERT INTO recipes(name, category, ingredients, steps) VALUES(?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, recipe.getName());
            ps.setString(2, recipe.getCategory());
            ps.setString(3, recipe.getIngredients());
            ps.setString(4, recipe.getSteps());
            ps.executeUpdate();
            System.out.println("Recipe added successfully!");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<Recipe> getAllRecipes() {
        List<Recipe> list = new ArrayList<>();
        String query = "SELECT * FROM recipes";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                list.add(new Recipe(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getString("ingredients"),
                        rs.getString("steps")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public List<Recipe> searchByCategory(String category) {
        List<Recipe> list = new ArrayList<>();
        String query = "SELECT * FROM recipes WHERE category=?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, category);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Recipe(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getString("ingredients"),
                        rs.getString("steps")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public List<Recipe> searchByIngredients(String ingredientsInput) {
        List<Recipe> list = new ArrayList<>();
        String[] ingredientsArr = ingredientsInput.split(",");
        StringBuilder query = new StringBuilder("SELECT * FROM recipes WHERE ");
        for (int i = 0; i < ingredientsArr.length; i++) {
            query.append("ingredients LIKE ?");
            if (i != ingredientsArr.length - 1) query.append(" OR ");
        }

        try (PreparedStatement ps = conn.prepareStatement(query.toString())) {
            for (int i = 0; i < ingredientsArr.length; i++) {
                ps.setString(i + 1, "%" + ingredientsArr[i].trim() + "%");
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Recipe(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getString("ingredients"),
                        rs.getString("steps")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }
}
