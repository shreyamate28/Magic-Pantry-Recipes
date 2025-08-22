package ui;

import dao.RecipeDAO;
import model.Recipe;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.List;

public class RecipeManagerGUI extends JFrame {
    private RecipeDAO dao;
    private JTable table;
    private DefaultTableModel model;

    public RecipeManagerGUI() {
        dao = new RecipeDAO();
        setTitle("Magic Pantry: Recipes from Your Ingredients 🍲");
        setSize(1000, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(255, 248, 220)); // light cream background

        // Table
        model = new DefaultTableModel(new String[]{"ID","Name","Category","Ingredients","Steps"},0);
        table = new JTable(model);
        table.setRowHeight(30);
        table.setFont(new Font("Serif", Font.PLAIN, 14));
        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(255, 165, 0));
        header.setForeground(Color.white);
        header.setFont(new Font("SansSerif", Font.BOLD, 16));

        add(new JScrollPane(table), BorderLayout.CENTER);

        // Buttons panel
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 228, 196));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton addBtn = new JButton("➕ Add Recipe");
        JButton refreshBtn = new JButton("🔄 Refresh");
        JButton searchCategoryBtn = new JButton("🔍 Search Category");
        JButton searchIngredientBtn = new JButton("🍴 Suggest by Ingredients");

        Font btnFont = new Font("Arial", Font.BOLD, 14);
        addBtn.setFont(btnFont); refreshBtn.setFont(btnFont);
        searchCategoryBtn.setFont(btnFont); searchIngredientBtn.setFont(btnFont);

        addBtn.setBackground(new Color(144, 238, 144));
        refreshBtn.setBackground(new Color(135, 206, 250));
        searchCategoryBtn.setBackground(new Color(255, 182, 193));
        searchIngredientBtn.setBackground(new Color(255, 218, 185));

        panel.add(addBtn);
        panel.add(refreshBtn);
        panel.add(searchCategoryBtn);
        panel.add(searchIngredientBtn);
        add(panel, BorderLayout.SOUTH);

        // Button Actions
        addBtn.addActionListener(e -> addRecipeDialog());
        refreshBtn.addActionListener(e -> loadAllRecipes());
        searchCategoryBtn.addActionListener(e -> searchCategoryDialog());
        searchIngredientBtn.addActionListener(e -> searchIngredientsDialog());

        loadAllRecipes();
        setVisible(true);
    }

    private void addRecipeDialog() {
        JTextField nameField = new JTextField();
        JTextField ingredientsField = new JTextField();
        JTextField stepsField = new JTextField();
        String[] categories = {"Vegetarian","Non-Vegetarian","Quick Meals"};
        JComboBox<String> categoryBox = new JComboBox<>(categories);

        Object[] message = {
                "Name:", nameField,
                "Category:", categoryBox,
                "Ingredients (comma separated):", ingredientsField,
                "Steps:", stepsField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Add Recipe", JOptionPane.OK_CANCEL_OPTION);
        if(option == JOptionPane.OK_OPTION) {
            Recipe r = new Recipe(nameField.getText(), categoryBox.getSelectedItem().toString(),
                    ingredientsField.getText(), stepsField.getText());
            dao.addRecipe(r);
            loadAllRecipes();
        }
    }

    private void loadAllRecipes() {
        model.setRowCount(0);
        List<Recipe> recipes = dao.getAllRecipes();
        for(Recipe r : recipes) {
            model.addRow(new Object[]{r.getId(), r.getName(), r.getCategory(), r.getIngredients(), r.getSteps()});
        }
    }

    private void searchCategoryDialog() {
        String category = JOptionPane.showInputDialog(this, "Enter Category (Vegetarian, Non-Vegetarian, Quick Meals):");
        if(category != null && !category.isEmpty()) {
            model.setRowCount(0);
            List<Recipe> recipes = dao.searchByCategory(category);
            for(Recipe r : recipes) {
                model.addRow(new Object[]{r.getId(), r.getName(), r.getCategory(), r.getIngredients(), r.getSteps()});
            }
        }
    }

    private void searchIngredientsDialog() {
        String input = JOptionPane.showInputDialog(this, "Enter ingredients you have (comma separated):");
        if(input != null && !input.isEmpty()) {
            model.setRowCount(0);
            List<Recipe> recipes = dao.searchByIngredients(input);
            for(Recipe r : recipes) {
                model.addRow(new Object[]{r.getId(), r.getName(), r.getCategory(), r.getIngredients(), r.getSteps()});
            }
        }
    }
}

