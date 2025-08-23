-- 1. Create Database
CREATE DATABASE IF NOT EXISTS MagicPantryDB;

-- 2. Use Database
USE MagicPantryDB;

-- 3. Create Table
CREATE TABLE IF NOT EXISTS recipes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    category VARCHAR(50) NOT NULL,
    ingredients TEXT NOT NULL,
    steps TEXT NOT NULL
);

-- 4. Insert 20 Recipes
INSERT INTO recipes(name, category, ingredients, steps) VALUES
('Veg Sandwich','Vegetarian','Bread, Lettuce, Tomato, Cheese','Assemble all ingredients and serve'),
('Grilled Chicken','Non-Vegetarian','Chicken, Spices, Oil','Marinate chicken, grill for 20 minutes'),
('Pasta Primavera','Vegetarian','Pasta, Tomato, Broccoli, Carrot, Olive oil','Boil pasta, sauté vegetables, mix together'),
('Omelette','Non-Vegetarian','Eggs, Salt, Pepper, Onion, Tomato','Beat eggs, cook in pan, add vegetables'),
('Fruit Salad','Vegetarian','Apple, Banana, Orange, Grapes','Chop fruits, mix and serve'),
('Chicken Curry','Non-Vegetarian','Chicken, Onion, Tomato, Spices','Cook chicken, add spices and simmer'),
('Tomato Soup','Vegetarian','Tomato, Onion, Garlic, Cream','Boil tomatoes, blend, cook with cream'),
('Grilled Cheese','Vegetarian','Bread, Cheese, Butter','Butter bread, add cheese, grill until golden'),
('Fried Rice','Vegetarian','Rice, Carrot, Peas, Soy sauce','Cook rice, sauté vegetables, mix together'),
('Beef Stir Fry','Non-Vegetarian','Beef, Soy sauce, Broccoli, Carrot','Stir fry beef, add vegetables and sauce'),
('Masala Dosa','Vegetarian','Rice, Lentils, Potato, Spices','Prepare batter, cook dosa, fill with potato masala'),
('Chicken Biryani','Non-Vegetarian','Rice, Chicken, Spices, Onion, Yogurt','Cook chicken, layer with rice and spices, steam'),
('Paneer Butter Masala','Vegetarian','Paneer, Tomato, Cream, Spices','Cook paneer in tomato gravy with cream'),
('Fish Curry','Non-Vegetarian','Fish, Coconut, Spices, Onion','Cook fish with coconut gravy and spices'),
('Veg Burger','Vegetarian','Burger buns, Patty, Lettuce, Tomato, Sauce','Assemble patty and vegetables in bun'),
('Chicken Nuggets','Non-Vegetarian','Chicken, Breadcrumbs, Egg, Spices','Coat chicken with egg and breadcrumbs, fry'),
('Chocolate Cake','Vegetarian','Flour, Cocoa, Sugar, Butter, Eggs','Mix ingredients, bake at 180C for 30 min'),
('Egg Fried Rice','Non-Vegetarian','Rice, Egg, Onion, Carrot, Soy sauce','Cook rice, scramble eggs, mix with vegetables'),
('Greek Salad','Vegetarian','Cucumber, Tomato, Feta, Olive oil, Olives','Chop ingredients, mix and serve'),
('Shrimp Pasta','Non-Vegetarian','Pasta, Shrimp, Garlic, Olive oil, Tomato','Cook pasta, sauté shrimp, mix with pasta and sauce');
