package ie.pennylabs.x.basil.feature.recipe.detail.ingredients

import android.annotation.SuppressLint
import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ie.pennylabs.x.basil.data.store.IngredientStore

@SuppressLint("ViewConstructor")
class IngredientsPage(context: Context, recipeId: String) : RecyclerView(context) {
  private val store by lazy { IngredientStore() }

  init {
    layoutManager = LinearLayoutManager(context)
    adapter = IngredientsRecyclerAdapter().apply {
      submitList(store.fetchForRecipe(recipeId))
    }
  }
}