package ie.pennylabs.x.basil.data.store

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import ie.pennylabs.x.basil.data.model.Recipe


class RecipeStore {
  fun fetch(id: String) = fetchAll().first { it.id == id }

  fun fetchAll(): List<Recipe> {
    val type = Types.newParameterizedType(List::class.java, Recipe::class.java)
    val adapter = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
        .adapter<List<Recipe>>(type)

    return adapter.fromJson(mockRecipes)!!
  }
}

private const val mockRecipes = """
[
  {
    "id":"recipe_1",
    "name":"Creamy Pesto Pasta",
    "description":"Guilt-free gluten-free spaghetti pasta is sautéed in a garlic, kale pesto. It's an easy and healthy dinner.",
    "calories":"456g",
    "protein":"27g",
    "fat":"12g"
  },
  {
    "id":"recipe_2",
    "name":"Spinach Filo Puffs",
    "description":"Guilt-free gluten-free spaghetti pasta is sautéed in a garlic, kale pesto. It's an easy and healthy dinner.",
    "calories":"456g",
    "protein":"27g",
    "fat":"12g"
  },
  {
    "id":"recipe_3",
    "name":"Beef Pot Pie",
    "description":"Guilt-free gluten-free spaghetti pasta is sautéed in a garlic, kale pesto. It's an easy and healthy dinner.",
    "calories":"456g",
    "protein":"27g",
    "fat":"12g"
  },
  {
    "id":"recipe_4",
    "name":"Herb Roasted Chicken",
    "description":"Guilt-free gluten-free spaghetti pasta is sautéed in a garlic, kale pesto. It's an easy and healthy dinner.",
    "calories":"456g",
    "protein":"27g",
    "fat":"12g"
  }
]
"""