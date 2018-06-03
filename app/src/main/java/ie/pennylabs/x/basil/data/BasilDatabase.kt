package ie.pennylabs.x.basil.data

import androidx.room.Database
import androidx.room.RoomDatabase
import ie.pennylabs.x.basil.data.model.Ingredient
import ie.pennylabs.x.basil.data.model.IngredientDao
import ie.pennylabs.x.basil.data.model.Recipe
import ie.pennylabs.x.basil.data.model.RecipeDao

@Database(entities = [Ingredient::class, Recipe::class], version = 1)
abstract class BasilDatabase : RoomDatabase() {
  abstract fun ingredientDao(): IngredientDao
  abstract fun recipeDao(): RecipeDao
}