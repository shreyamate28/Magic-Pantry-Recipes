import dao.RecipeDAO;
import model.Recipe;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static RecipeDAO dao = new RecipeDAO();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Magic Pantry: Recipes from Your Ingredients");
        int choice;
        do {
            System.out.println("\n1. Add Recipe");
            System.out.println("2. View All Recipes");
            System.out.println("3. Search by Category");
            System.out.println("4. Suggest by Ingredients");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: addRecipe(); break;
                case 2: viewAllRecipes(); break;
                case 3: searchByCategory(); break;
                case 4: suggestByIngredients(); break;
                case 5: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice!"); break;
            }
        } while (choice != 5);
    }

    private static void addRecipe() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Category (Vegetarian / Non-Vegetarian / Quick Meals): ");
        String category = sc.nextLine();
        System.out.print("Enter Ingredients (comma separated): ");
        String ingredients = sc.nextLine();
        System.out.print("Enter Steps: ");
        String steps = sc.nextLine();

        Recipe r = new Recipe(name, category, ingredients, steps);
        dao.addRecipe(r);
    }

    private static void viewAllRecipes() {
        List<Recipe> recipes = dao.getAllRecipes();
        System.out.println("\nAll Recipes:");
        for (Recipe r : recipes) {
            System.out.println("ID: " + r.getId() + " | Name: " + r.getName() + " | Category: " + r.getCategory());
            System.out.println("Ingredients: " + r.getIngredients());
            System.out.println("Steps: " + r.getSteps());
            System.out.println("-------------------------------------");
        }
    }

    private static void searchByCategory() {
        System.out.print("Enter Category: ");
        String category = sc.nextLine();
        List<Recipe> recipes = dao.searchByCategory(category);
        if(recipes.isEmpty()) System.out.println("No recipes found!");
        else {
            for (Recipe r : recipes) {
                System.out.println("ID: " + r.getId() + " | Name: " + r.getName());
                System.out.println("Ingredients: " + r.getIngredients());
                System.out.println("Steps: " + r.getSteps());
                System.out.println("-------------------------------------");
            }
        }
    }

    private static void suggestByIngredients() {
        System.out.print("Enter ingredients you have (comma separated): ");
        String input = sc.nextLine();
        List<Recipe> recipes = dao.searchByIngredients(input);
        if(recipes.isEmpty()) System.out.println("No recipes found with these ingredients!");
        else {
            System.out.println("Matching Recipes:");
            for (Recipe r : recipes) {
                System.out.println("ID: " + r.getId() + " | Name: " + r.getName() + " | Category: " + r.getCategory());
                System.out.println("Ingredients: " + r.getIngredients());
                System.out.println("Steps: " + r.getSteps());
                System.out.println("-------------------------------------");
            }
        }
    }
}
