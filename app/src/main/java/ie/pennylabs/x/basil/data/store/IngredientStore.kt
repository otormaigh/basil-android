package ie.pennylabs.x.basil.data.store

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import ie.pennylabs.x.basil.data.model.Ingredient

class IngredientStore {
  fun fetchForRecipe(recipeId: String) = fetchAll().filter { it.recipeId == recipeId }

  private fun fetchAll() = listAdapter.fromJson(mockIngredients)!!
}

private val listAdapter = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
    .adapter<List<Ingredient>>(Types.newParameterizedType(List::class.java, Ingredient::class.java))
private const val mockIngredients = """
[
  {
    "id":"ingredient_1",
    "recipe_id":"recipe_1",
    "sort_order":"1",
    "name":"Basil",
    "quantity":"6 tbps"
  },
  {
    "id":"ingredient_2",
    "recipe_id":"recipe_1",
    "sort_order":"2",
    "name":"Gluten-free spahgetti",
    "quantity":"2 cups"
  },
  {
    "id":"ingredient_3",
    "recipe_id":"recipe_1",
    "sort_order":"3",
    "name":"Garlic",
    "quantity":"1 tbsp"
  },
  {
    "id":"ingredient_4",
    "recipe_id":"recipe_1",
    "sort_order":"4",
    "name":"Ricotta",
    "quantity":"4 cups"
  },
  {
    "id":"ingredient_5",
    "recipe_id":"recipe_1",
    "sort_order":"5",
    "name":"Kale",
    "quantity":"3 cups"
  },
  {
    "id":"ingredient_6",
    "recipe_id":"recipe_1",
    "sort_order":"6",
    "name":"Red Pepper Flakes",
    "quantity":"1 tbsp"
  },
  {
    "id":"ingredient_7",
    "recipe_id":"recipe_1",
    "sort_order":"7",
    "name":"Extra Virgin Olive Oil",
    "quantity":"1 tbsp"
  },
  {
    "id":"ingredient_8",
    "recipe_id":"recipe_1",
    "sort_order":"8",
    "name":"Salt",
    "quantity":"1 tbsp"
  },
  {
    "id":"ingredient_9",
    "recipe_id":"recipe_1",
    "sort_order":"9",
    "name":"Pine Nuts",
    "quantity":"2 tbsp"
  }
]
"""


/* val id: String,
    val recipeId: String,
    @Json(name = "sort_order")
    val sortOrder: String,
    val name: String,
    val quantity: String*/