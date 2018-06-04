package ie.pennylabs.x.basil.feature.recipe.list

import android.os.Bundle
import androidx.lifecycle.Observer
import dagger.android.AndroidInjection
import ie.pennylabs.x.basil.R
import ie.pennylabs.x.basil.arch.BaseActivity
import ie.pennylabs.x.basil.data.store.RecipeStore
import ie.pennylabs.x.basil.feature.recipe.detail.RecipeDetailBottomSheet
import kotlinx.android.synthetic.main.activity_recipe_list.*
import javax.inject.Inject

class RecipeListActivity : BaseActivity() {
  @Inject
  lateinit var store: RecipeStore
  private val recipeDetailBottomSheet by lazy { RecipeDetailBottomSheet() }

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_recipe_list)

    store.fetchAll().observe(this@RecipeListActivity, Observer { recipes ->
      if (recipes != null) {
        pagerRecipe.adapter = RecipePagerAdapter(recipes)

        ivOpenRecipe.setOnClickListener {
          recipeDetailBottomSheet.show(supportFragmentManager)
          recipeDetailBottomSheet.recipeId = recipes[pagerRecipe.currentItem].id
        }
      }
    })
  }

  override fun onBackPressed() {
    if (recipeDetailBottomSheet.isVisible) {
      recipeDetailBottomSheet.dismiss()
    } else {
      super.onBackPressed()
    }
  }
}