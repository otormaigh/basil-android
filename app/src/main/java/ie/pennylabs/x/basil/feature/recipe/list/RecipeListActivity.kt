package ie.pennylabs.x.basil.feature.recipe.list

import android.os.Bundle
import androidx.lifecycle.Observer
import dagger.android.AndroidInjection
import ie.pennylabs.x.basil.R
import ie.pennylabs.x.basil.arch.BaseActivity
import ie.pennylabs.x.basil.data.store.RecipeStore
import ie.pennylabs.x.basil.feature.recipe.RecipeMainActivity
import kotlinx.android.synthetic.main.activity_recipe_list.*
import javax.inject.Inject

class RecipeListActivity : BaseActivity() {
  @Inject
  lateinit var store: RecipeStore

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_recipe_list)

    store.fetchAll().observe(this@RecipeListActivity, Observer {recipes ->
      if (recipes != null) {
        pagerRecipe.adapter = RecipePagerAdapter(recipes)
        ivOpenRecipe.setOnClickListener {
          RecipeMainActivity.start(this@RecipeListActivity, recipes[pagerRecipe.currentItem].id)
        }
      }
    })
  }
}