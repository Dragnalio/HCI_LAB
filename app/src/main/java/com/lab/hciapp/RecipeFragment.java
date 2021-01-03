package com.lab.hciapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Vector;

public class RecipeFragment extends Fragment {

    RecipeAdapter recipeAdapter;
    RecyclerView recyclerView;

    public RecipeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (Recipe.recipes.size() == 0){
            Recipe.addRecipe(new Recipe(
                    "Simple Instant Pot® Mashed Potatoes",
                    "This is an easy take on mashed potatoes. The potatoes pressure cook away while you focus on other things. This is a basic but tasty recipe; feel free to update with your own ingredients. You can peel the skins if you prefer. Once you mash it up, you can return insert back to the pot, reattach the lid, and place it on the Keep Warm function until you are ready to serve.",
                    "Ingredients (4 servings)\n" +
                    " 1 ¼ pounds Yukon Gold potatoes\n" +
                    " 1 ½ cups water\n" +
                    " 2 cubes chicken bouillon\n" +
                    " ½ cup sour cream\n" +
                    " ½ cup unsalted butter, cubed\n" +
                    " 2 tablespoons milk\t\n" +
                    "\n" +
                    "Directions\n" +
                    "\n" +
                    " Step 1\n" +
                    "Cut potatoes into 1-inch cubes. Add to a multi-functional pressure cooker (such as Instant Pot®) with water and bouillon cubes. Select Saute function; set timer for 4 minutes on High.\n" +
                    " Step 2\n" +
                    "Mix potatoes and water and break up the bouillon cubes. Close and lock the lid. Select high pressure according to manufacturer's instructions; set timer for 10 minutes. Allow 10 to 15 minutes for pressure to build.\n" +
                    " Step 3\n" +
                    "Release pressure using the natural-release method according to manufacturer's instructions, about 10 minutes. Release remaining pressure carefully using the quick-release method. Remove the pot and carefully drain off most of the liquid.\n" +
                    " Step 4\n" +
                    "Add sour cream, butter, and milk. Gently mash with a potato masher to reach your desired consistency.",
                    R.drawable.image1));
            Recipe.addRecipe(new Recipe(
                    "Instant Pot® Yankee Pot Roast",
                    "This kind of pressure cooking turns complex weekend-only dishes into everyday fare. For this Instant Pot® recipe, I adapted our recipe for classic Yankee pot roast, using baby carrots and frozen pearl onions to cut down on prep time. Coating the roast with seasoned flour before browning adds flavor and helps thicken the sauce--an important step in a sealed system where water can't evaporate. Spoon the sauce over the beef and vegetables alongside mashed potatoes, buttered egg noodles, or rice.",
                    "Ingredients (14 servings)\n" +
                    " 1 (3 1/2) pound boneless beef chuck roast\n" +
                    " ¼ cup all-purpose flour \n" +
                    " 1 tablespoon kosher salt \n" +
                    " 1 ½ teaspoons freshly ground black pepper \n" +
                    " 3 tablespoons olive oil \n" +
                    " 1 large yellow onion, diced \n" +
                    " 3 cloves garlic, minced \n" +
                    " 1 ½ teaspoons minced fresh rosemary \n" +
                    " 1 cup beef stock, divided \n" +
                    " ¾ cup Merlot wine \n" +
                    " 2 tablespoons tomato paste \n" +
                    " 1 bay leaf \n" +
                    " aluminum foil \n" +
                    " 2 cups baby carrots \n" +
                    " 2 cups frozen pearl onions \n" +
                    " 3 stalks celery, cut into 2-inch pieces \n" +
                    " fresh rosemary sprigs, for garnish \n" +
                    "\n" +
                    "Directions \n" +
                    " Step 1 \n" +
                    "Pat chuck roast dry with a paper towel. Stir together flour, salt, and pepper in a small bowl. Sprinkle flour mixture all over the roast, pressing lightly to ensure it sticks to the meat.\n" +
                    " Step 2 \n" +
                    "Turn on a multi-functional pressure cooker (such as Instant Pot®) and select Saute function. Add oil. Add roast to the hot oil and cook, without turning, until browned, about 3 minutes. Turn roast to brown each side, about 3 minutes per side. Transfer roast to a plate.\n" +
                    " Step 3 \n" +
                    "Add onion, garlic, and minced rosemary to the pot; cook, stirring often, until onion is translucent, about 6 minutes. Add beef stock, wine, and tomato paste and simmer while scraping the browned bits of food off the bottom of the pan with a wooden spoon. Return roast to the pot along with bay leaf.\n" +
                    " Step 4 \n" +
                    "Close and lock the lid, select Meat/Stew function, and set timer for 40 minutes.\n" +
                    " Step 5 \n" +
                    "Release pressure carefully using the quick-release method according to manufacturer's instructions, about 5 minutes. Unlock and remove the lid. Transfer roast to a plate and tent with aluminum foil for 15 minutes.\n" +
                    " Step 6 \n" +
                    "Add carrots, pearl onions, and celery to the pot. Close and lock the lid. Select high pressure according to manufacturer's instructions; set timer for 4 minutes. Allow 5 to 10 minutes for pressure to build.\n" +
                    " Step 7 \n" +
                    "Release pressure carefully using the quick-release method according to manufacturer's instructions, about 5 minutes. Unlock and remove the lid.\n" +
                    " Step 8 \n" +
                    "Slice roast against the grain, or use 2 forks to pull meat into chunks. Transfer roast, vegetables, and sauce to a serving platter. Discard bay leaf and garnish with rosemary sprigs.",
                    R.drawable.image2));
            Recipe.addRecipe(new Recipe(
                    "Basic Crepes",
                    "Here is a simple but delicious crepe batter which can be made in minutes. It's made from ingredients that everyone has on hand.",
                    "Ingredients (4 servings)\n" +
                    " 1 cup all-purpose flour \n" +
                    " 2 eggs \n" +
                    " ½ cup milk \n" +
                    " ½ cup water \n" +
                    " ¼ teaspoon salt \n" +
                    " 2 tablespoons butter, melted \n" +
                    "\n" +
                    "Directions\n" +
                    " Step 1 \n" +
                    "In a large mixing bowl, whisk together the flour and the eggs. Gradually add in the milk and water, stirring to combine. Add the salt and butter; beat until smooth.\n" +
                    " Step 2 \n" +
                    "Heat a lightly oiled griddle or frying pan over medium high heat. Pour or scoop the batter onto the griddle, using approximately 1/4 cup for each crepe. Tilt the pan with a circular motion so that the batter coats the surface evenly.\n" +
                    " Step 3 \n" +
                    "Cook the crepe for about 2 minutes, until the bottom is light brown. Loosen with a spatula, turn and cook the other side. Serve hot.",
                    R.drawable.image3));
            Recipe.addRecipe(new Recipe(
                    "Best Brownies",
                    "These brownies always turn out!",
                    "Ingredients (16 servings)\n" +
                    " ½ cup butter \n" +
                    " 1 cup white sugar \n" +
                    " 2 eggs \n" +
                    " 1 teaspoon vanilla extract \n" +
                    " ⅓ cup unsweetened cocoa powder \n" +
                    " ½ cup all-purpose flour \n" +
                    " ¼ teaspoon salt \n" +
                    " ¼ teaspoon baking powder \n" +
                    "Frosting: \n" +
                    " 3 tablespoons butter, softened \n" +
                    " 3 tablespoons unsweetened cocoa powder \n" +
                    " 1 tablespoon honey \n" +
                    " 1 teaspoon vanilla extract \n" +
                    " 1 cup confectioners' sugar \n" +
                    "\n" +
                    "Directions \n" +
                    " Step 1 \n" +
                    "Preheat oven to 350 degrees F (175 degrees C). Grease and flour an 8-inch square pan.\n" +
                    " Step 2 \n" +
                    "In a large saucepan, melt 1/2 cup butter. Remove from heat, and stir in sugar, eggs, and 1 teaspoon vanilla. Beat in 1/3 cup cocoa, 1/2 cup flour, salt, and baking powder. Spread batter into prepared pan.\n" +
                    " Step 3 \n" +
                    "Bake in preheated oven for 25 to 30 minutes. Do not overcook.\n" +
                    " Step 4 \n" +
                    "To Make Frosting: Combine 3 tablespoons softened butter, 3 tablespoons cocoa, honey, 1 teaspoon vanilla extract, and 1 cup confectioners' sugar. Stir until smooth. Frost brownies while they are still warm.",
                    R.drawable.image4));
            Recipe.addRecipe(new Recipe(
                    "Christmas Breakfast Pizza",
                    "Sausage, eggs, crescent rolls, and cheese snuggle down in a casserole, chill overnight, and bake in the morning. It's a great dish for a holiday brunch.",
                    "Ingredients (8 servings)\n" +
                    " 1 pound ground pork sausage \n" +
                    " 1 (8 ounce) package refrigerated crescent roll dough, or as needed \n" +
                    " 8 ounces mild Cheddar cheese, shredded \n" +
                    " 6 eggs \n" +
                    " ½ cup milk \n" +
                    " ½ teaspoon salt \n" +
                    " ground black pepper to taste \n" +
                    "\n" +
                    "Directions \n" +
                    " Step 1 \n" +
                    "Heat a skillet over medium heat. Crumble sausage into skillet; cook and stir until browned and crumbly, 5 to 7 minutes; drain and discard grease. Cool sausage.\n" +
                    " Step 2 \n" +
                    "Grease a 9x13-inch baking dish. Line the baking dish with crescent roll dough.\n" +
                    " Step 3 \n" +
                    "Sprinkle cooled sausage and Cheddar cheese over crescent roll dough. Cover the baking dish with plastic wrap and refrigerate, 8 hours to overnight.\n" +
                    " Step 4 \n" +
                    "Preheat oven to 350 degrees F (175 degrees C).\n" +
                    " Step 5 \n" +
                    "Whisk eggs, milk, salt, and black pepper together in a bowl. Pour egg mixture over sausage and cheese in the baking dish. Cover the baking dish with aluminum foil.\n" +
                    " Step 6 \n" +
                    "Bake in the preheated oven for 20 minutes. Remove and discard aluminum foil and reduce oven temperature to 325 degrees F (165 degrees C). Continue baking until egg mixture is set, 15 to 25 minutes.",
                    R.drawable.image5));
            Recipe.addRecipe(new Recipe(
                    "Oven Baked Omelet",
                    "Yummy, fluffy eggs made in the oven.",
                    "Ingredients (6 servings)\n" +
                    " 1 teaspoon butter \n" +
                    " 9 large eggs \n" +
                    " ½ cup sour cream \n" +
                    " ½ cup milk \n" +
                    " 1 teaspoon salt \n" +
                    " 2 green onions, chopped \n" +
                    " ¼ cup shredded Cheddar cheese \n" +
                    "\n" +
                    "Directions \n" +
                    " Step 1 \n" +
                    "Preheat oven to 350 degrees F (175 degrees C). Grease an 8x8-inch baking dish with butter.\n" +
                    " Step 2 \n" +
                    "Beat eggs, sour cream, milk, and salt in a bowl until blended. Stir in green onions. Pour mixture in the prepared baking dish.\n" +
                    " Step 3 \n" +
                    "Bake in the preheated oven until set, 25 to 30 minutes. Sprinkle Cheddar cheese over eggs and continue baking until cheese is melted, 2 to 3 minutes more.",
                    R.drawable.image6));
            Recipe.addRecipe(new Recipe(
                    "Cream Cheese and Tomato Omelet with Chives",
                    "This omelet is light, fluffy, and delicious! Perfect with tomatoes and chives fresh from the garden. Use garlic chives to make this omelet extra flavorful.",
                    "Ingredients (1 servings)\n" +
                    " 2 eggs \n" +
                    " 1 tablespoon milk \n" +
                    " salt and ground black pepper to taste \n" +
                    " 3 tablespoons cream cheese, softened \n" +
                    " 2 tablespoons seeded and diced tomato \n" +
                    " 1 tablespoon chopped fresh chives \n" +
                    "\n" +
                    "Directions \n" +
                    " Step 1 \n" +
                    "Whisk eggs, milk, salt, and pepper together in a bowl.\n" +
                    " Step 2 \n" +
                    "Heat a 6-inch nonstick skillet over medium heat; pour egg mixture into the hot skillet, tilting so egg mixture covers the entire bottom of skillet. Slowly cook egg mixture until set, 5 to 10 minutes.\n" +
                    " Step 3 \n" +
                    "Arrange small dollops of cream cheese onto half the omelet; sprinkle tomato and chives over cream cheese. Fold omelet in half over the fillings. Remove skillet from heat and cover until cream cheese has softened, 2 to 3 minutes.",
                    R.drawable.image7));
            Recipe.addRecipe(new Recipe(
                    "Slow Cooker Texas Pulled Pork",
                    "Slow cooked, Texas-style pulled pork that is served on a buttered and toasted roll. My family's favorite.",
                    "Ingredients (8 servings)\n" +
                    " 1 teaspoon vegetable oil \n" +
                    " 1 (4 pound) pork shoulder roast \n" +
                    " 1 cup barbeque sauce \n" +
                    " ½ cup apple cider vinegar \n" +
                    " ½ cup chicken broth \n" +
                    " ¼ cup light brown sugar \n" +
                    " 1 tablespoon prepared yellow mustard \n" +
                    " 1 tablespoon Worcestershire sauce \n" +
                    " 1 tablespoon chili powder \n" +
                    " 1 extra large onion, chopped \n" +
                    " 2 large cloves garlic, crushed \n" +
                    " 1 ½ teaspoons dried thyme \n" +
                    " 8 hamburger buns, split \n" +
                    " 2 tablespoons butter, or as needed \n" +
                    "\n" +
                    "Directions \n" +
                    " Step 1 \n" +
                    "Pour the vegetable oil into the bottom of a slow cooker. Place the pork roast into the slow cooker; pour in the barbecue sauce, apple cider vinegar, and chicken broth. Stir in the brown sugar, yellow mustard, Worcestershire sauce, chili powder, onion, garlic, and thyme. Cover and cook on High until the roast shreds easily with a fork, 5 to 6 hours.\n" +
                    " Step 2 \n" +
                    "Remove the roast from the slow cooker, and shred the meat using two forks. Return the shredded pork to the slow cooker, and stir the meat into the juices.\n" +
                    " Step 3 \n" +
                    "Spread the inside of both halves of hamburger buns with butter. Toast the buns, butter side down, in a skillet over medium heat until golden brown. Spoon pork into the toasted buns.",
                    R.drawable.image8));
            Recipe.addRecipe(new Recipe(
                    "Valerio's Pulled Pork Sandwich",
                    "This is a very messy but delicious sandwich with lots of BBQ sauce.",
                    "Ingredients (8 servings)\n" +
                    "Dry Rub: \n" +
                    " 2 tablespoons brown sugar \n" +
                    " 2 tablespoons garlic powder \n" +
                    " 2 tablespoons ground black pepper \n" +
                    " 2 tablespoons red pepper flakes \n" +
                    " 2 tablespoons salt \n" +
                    " 2 tablespoons paprika \n" +
                    " 1 (3 1/2) pound pork butt roast with bone \n" +
                    "Cooking Liquid: \n" +
                    " 4 cups beef stock \n" +
                    " ½ cup hot sauce \n" +
                    " 3 tablespoons honey \n" +
                    " 1 tablespoon molasses \n" +
                    " 1 tablespoon maple syrup \n" +
                    " 4 cloves garlic, crushed \n" +
                    "Coleslaw: \n" +
                    " 1 cup mayonnaise \n" +
                    " 2 tablespoons Dijon mustard \n" +
                    " 1 teaspoon hot sauce \n" +
                    " 1 teaspoon salt \n" +
                    " 1 teaspoon ground black pepper \n" +
                    " 2 tablespoons white vinegar \n" +
                    " 1 (16 ounce) bag coleslaw mix \n" +
                    "BBQ Sauce: \n" +
                    " 1 tablespoon vegetable oil \n" +
                    " 5 cloves garlic, minced \n" +
                    " 2 cups ketchup \n" +
                    " ½ cup honey \n" +
                    " 2 tablespoons hot pepper sauce \n" +
                    " 2 tablespoons molasses \n" +
                    " 5 tablespoons cider vinegar \n" +
                    " salt and ground black pepper to taste \n" +
                    " 8 Kaiser rolls, split \n" +
                    "\n" +
                    "Directions \n" +
                    " Step 1 \n" +
                    "Combine brown sugar, garlic powder, 2 tablespoons black pepper, red pepper flakes, 2 tablespoons salt, and paprika in a bowl. Rub the spice mixture over pork butt, cover, and refrigerate 5 hours or overnight.\n" +
                    " Step 2 \n" +
                    "Pour beef stock and 1/2 cup hot sauce in a pressure cooker. Stir in 3 tablespoons honey, 1 tablespoon molasses, maple syrup, and 4 crushed garlic cloves. Place the pork butt in the pressure cooker, seal the lid, and bring up to low pressure over high heat. Reduce the heat to low, maintaining low pressure, and cook for 2 hours.\n" +
                    " Step 3 \n" +
                    "While the pork is cooking, make the coleslaw. Mix mayonnaise, Dijon mustard, 1 teaspoon hot sauce, white vinegar, 1 teaspoon salt, and 1 teaspoon black pepper in a bowl. Add the coleslaw mix and toss to coat. Cover and refrigerate.\n" +
                    " Step 4 \n" +
                    "Turn off the heat and let the pressure reduce naturally; remove the lid and let the pork rest for 5 minutes. The meat should shred easily with a fork; if it doesn't fall off the bone, reseal the lid, turn on the heat, return the pressure cooker to low pressure, and cook for another 30 minutes.\n" +
                    " Step 5 \n" +
                    "Remove meat from the pressure cooker, reserving 1/4 cup cooking liquid. Shred the meat using two forks and set aside.\n" +
                    " Step 6 \n" +
                    "Heat vegetable oil in a saucepan over medium heat. Stir in 5 cloves of garlic; cook and stir until the garlic is fragrant and just starting to turn brown, about 3 minutes. Remove from heat and stir in ketchup, 1/2 cup honey, 2 tablespoons hot sauce, 2 tablespoons molasses, cider vinegar, and reserved cooking liquid. Season with salt and black pepper to taste. Bring the sauce to a simmer over medium heat.\n" +
                    " Step 7 \n" +
                    "Fill each Kaiser roll with two big forkfuls of pork, two tablespoons of barbeque sauce, and 2 spoonfuls of coleslaw.",
                    R.drawable.image9));
            Recipe.addRecipe(new Recipe(
                    "Quick and Easy Pizza Crust",
                    "This is a great recipe when you don't want to wait for the dough to rise. You just mix it and allow it to rest for 5 minutes and then it's ready to go!! It yields a soft, chewy crust. For a real treat, I recommend you use bread flour and bake it on a pizza stone, but all-purpose flour works well too. Enjoy!",
                    "Ingredients (8 servings)\n" +
                    " 1 (.25 ounce) package active dry yeast \n" +
                    " 1 teaspoon white sugar \n" +
                    " 1 cup warm water (110 degrees F/45 degrees C) \n" +
                    " 2 ½ cups bread flour \n" +
                    " 2 tablespoons olive oil \n" +
                    " 1 teaspoon salt \n" +
                    "\n" +
                    "Directions\n" +
                    " Step 1 \n" +
                    "Preheat oven to 450 degrees F (230 degrees C). In a medium bowl, dissolve yeast and sugar in warm water. Let stand until creamy, about 10 minutes.\n" +
                    " Step 2 \n" +
                    "Stir in flour, salt and oil. Beat until smooth. Let rest for 5 minutes.\n" +
                    " Step 3 \n" +
                    "Turn dough out onto a lightly floured surface and pat or roll into a round. Transfer crust to a lightly greased pizza pan or baker's peel dusted with cornmeal. Spread with desired toppings and bake in preheated oven for 15 to 20 minutes, or until golden brown. Let baked pizza cool for 5 minutes before serving.",
                    R.drawable.image10));
            Recipe.addRecipe(new Recipe(
                    "Pizza Dough I",
                    "This one is a quick recipe that merely involves mixing a few basic ingredients and patting the dough into the pan. No need to wait for the dough to rise with this approach.",
                    "Ingredients (15 servings)\n" +
                    " 3 cups all-purpose flour \n" +
                    " 1 (.25 ounce) package active dry yeast \n" +
                    " 2 tablespoons vegetable oil \n" +
                    " 1 teaspoon salt \n" +
                    " 1 tablespoon white sugar \n" +
                    " 1 cup warm water (110 degrees F/45 degrees C) \n" +
                    "\n" +
                    "Directions \n" +
                    " Step 1 \n" +
                    "Combine flour, salt, sugar, and yeast in a large bowl. Mix in oil and warm water. Spread out on a large pizza pan. Top as desired.\n" +
                    " Step 2 \n" +
                    "Bake at 375 degrees C (190 degrees C) for 20 to 25 minutes.",
                    R.drawable.image11));
        }
        // RecyclerView
        recipeAdapter = new RecipeAdapter(getContext(), Recipe.recipes);
        recyclerView = view.findViewById(R.id.recipe_rv_list);
        recyclerView.setAdapter(recipeAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));

        recipeAdapter.setOnClick(recipe -> {
            Recipe.recipe = recipe;
            Intent intent = new Intent(getContext(), DetailActivity.class);
            startActivity(intent);
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe, container, false);
    }
}