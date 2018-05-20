package ie.pennylabs.x.basil.feature.recipe.detail.ingredients

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ie.pennylabs.x.basil.data.model.Ingredient
import java.util.*

class IngredientsPage(context: Context) : RecyclerView(context) {
  init {
    layoutManager = LinearLayoutManager(context)
    adapter = IngredientsRecyclerAdapter().apply {
      submitList(Collections.nCopies(42, Ingredient("1", "Basil", "6 tbsp")))
    }
  }
}