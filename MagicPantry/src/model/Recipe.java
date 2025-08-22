package model;

public class Recipe {
    private int id;
    private String name;
    private String category;
    private String ingredients;
    private String steps;

    public Recipe(int id, String name, String category, String ingredients, String steps) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public Recipe(String name, String category, String ingredients, String steps) {
        this.name = name;
        this.category = category;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getIngredients() { return ingredients; }
    public String getSteps() { return steps; }
}
