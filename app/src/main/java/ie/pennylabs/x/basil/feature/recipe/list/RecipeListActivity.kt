package ie.pennylabs.x.basil.feature.recipe.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ie.pennylabs.x.basil.R
import kotlinx.android.synthetic.main.activity_recipe_list.*

class RecipeListActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_recipe_list)

    pagerRecipe.adapter = RecipePagerAdapter()
  }
}