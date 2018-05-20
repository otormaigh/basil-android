package ie.pennylabs.x.basil.data.store

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import ie.pennylabs.x.basil.data.model.Recipe


class RecipeStore {
  fun fetchAll(): List<Recipe> {
    val type = Types.newParameterizedType(List::class.java, Recipe::class.java)
    val adapter = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
        .adapter<List<Recipe>>(type)

    return adapter.fromJson(mockRecipes)!!
  }
}

private val mockRecipes = """
[
  {
    "id":"recipe_1",
    "name":"Creamy Pesto Pasta"
  },
  {
    "id":"recipe_1",
    "name":"Spinach Filo Puffs"
  },
  {
    "id":"recipe_1",
    "name":"Beef Pot Pie"
  },
  {
    "id":"recipe_1",
    "name":"Herb Roasted Chicken"
  }
]
"""