-- 1️⃣ Drop old database if exists
DROP DATABASE IF EXISTS recipe_db;

-- 2️⃣ Create new database
CREATE DATABASE recipe_db;

-- 3️⃣ Use the database
USE recipe_db;

-- 4️⃣ Create recipes table
CREATE TABLE recipes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    category ENUM('Vegetarian','Non-Vegetarian','Quick Meals') NOT NULL,
    ingredients TEXT NOT NULL,
    steps TEXT NOT NULL
);

-- 5️⃣ Insert 20 sample recipes
INSERT INTO recipes(name, category, ingredients, steps) VALUES
('Veg Sandwich','Vegetarian','Bread,Tomato,Lettuce,Cheese','1. Spread butter on bread 2. Add vegetables 3. Serve'),
('Grilled Chicken','Non-Vegetarian','Chicken,Olive Oil,Spices','1. Marinate chicken 2. Grill 20 min 3. Serve hot'),
('Pasta Primavera','Vegetarian','Pasta,Tomato,Bell Pepper,Zucchini','1. Boil pasta 2. Saute vegetables 3. Mix and serve'),
('Egg Omelette','Non-Vegetarian','Egg,Onion,Tomato,Cheese','1. Beat eggs 2. Add vegetables 3. Cook on pan'),
('Fruit Salad','Vegetarian','Apple,Banana,Orange,Grapes','1. Chop fruits 2. Mix 3. Serve fresh'),
('Chicken Curry','Non-Vegetarian','Chicken,Onion,Tomato,Spices','1. Saute onion & tomato 2. Add chicken & spices 3. Cook 30 min'),
('Quick Veg Pizza','Quick Meals','Pizza Base,Tomato,Cheese,Bell Pepper','1. Add toppings 2. Bake 15 min 3. Serve hot'),
('Pancakes','Quick Meals','Flour,Milk,Egg,Sugar','1. Mix ingredients 2. Cook on pan 3. Serve with syrup'),
('Grilled Veg Sandwich','Vegetarian','Bread,Cheese,Tomato,Spinach','1. Assemble sandwich 2. Grill 5 min 3. Serve hot'),
('Spaghetti Bolognese','Non-Vegetarian','Spaghetti,Minced Meat,Tomato,Onion','1. Cook spaghetti 2. Prepare meat sauce 3. Mix and serve'),
('Veg Burger','Vegetarian','Bun,Patty,Lettuce,Tomato,Cheese','1. Assemble burger 2. Cook patty 3. Serve hot'),
('Chicken Tikka','Non-Vegetarian','Chicken,Yogurt,Spices','1. Marinate chicken 2. Grill 20 min 3. Serve with chutney'),
('Masala Dosa','Vegetarian','Rice,Potato,Spices','1. Prepare batter 2. Cook dosa 3. Add potato filling'),
('Omelette Sandwich','Non-Vegetarian','Egg,Bread,Onion,Cheese','1. Make omelette 2. Place in sandwich 3. Serve hot'),
('Veg Fried Rice','Vegetarian','Rice,Vegetables,Soy Sauce','1. Cook rice 2. Stir fry vegetables 3. Mix and serve'),
('Chicken Sandwich','Non-Vegetarian','Chicken,Bread,Lettuce,Mayo','1. Cook chicken 2. Assemble sandwich 3. Serve'),
('Idli Sambhar','Vegetarian','Rice,Lentils,Sambhar','1. Prepare batter 2. Steam idlis 3. Serve with sambhar'),
('Egg Curry','Non-Vegetarian','Egg,Onion,Tomato,Spices','1. Boil eggs 2. Prepare gravy 3. Add eggs 4. Serve'),
('Quick Noodles','Quick Meals','Noodles,Vegetables,Sauce','1. Boil noodles 2. Stir fry vegetables 3. Mix and serve'),
('Veg Wrap','Vegetarian','Tortilla,Vegetables,Cheese','1. Place vegetables on tortilla 2. Roll up 3. Serve');
