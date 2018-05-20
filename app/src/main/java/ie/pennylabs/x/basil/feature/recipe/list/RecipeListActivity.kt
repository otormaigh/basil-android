package ie.pennylabs.x.basil.feature.recipe.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ie.pennylabs.x.basil.R
import ie.pennylabs.x.basil.data.store.RecipeStore
import ie.pennylabs.x.basil.feature.recipe.RecipeMainActivity
import kotlinx.android.synthetic.main.activity_recipe_list.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext

class RecipeListActivity : AppCompatActivity() {
  private val store by lazy { RecipeStore() }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_recipe_list)

    launch {
      val recipes = store.fetchAll()
      withContext(UI) {
        pagerRecipe.adapter = RecipePagerAdapter(recipes)
        ivOpenRecipe.setOnClickListener {
          RecipeMainActivity.start(this@RecipeListActivity, recipes[pagerRecipe.currentItem].id)
        }
      }
    }
  }
}