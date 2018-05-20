package ie.pennylabs.x.basil.feature.recipe.list

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.widget.FrameLayout
import ie.pennylabs.x.basil.R
import ie.pennylabs.x.basil.data.model.Recipe
import ie.pennylabs.x.basil.feature.recipe.RecipeMainActivity
import kotlinx.android.synthetic.main.page_recipe.view.*

@SuppressLint("ViewConstructor")
class RecipePage(context: Context, recipe: Recipe) : FrameLayout(context) {
  init {
    LayoutInflater.from(context).inflate(R.layout.page_recipe, this, true)

    ivOpenRecipe.setOnClickListener { RecipeMainActivity.start(context, recipe.id) }
    tvRecipeName.text = recipe.name
  }
}