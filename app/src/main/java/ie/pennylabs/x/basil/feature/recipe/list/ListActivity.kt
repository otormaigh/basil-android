package ie.pennylabs.x.basil.feature.recipe.list

import android.os.Bundle
import androidx.lifecycle.Observer
import dagger.android.AndroidInjection
import ie.pennylabs.x.basil.R
import ie.pennylabs.x.basil.arch.BaseActivity
import ie.pennylabs.x.basil.data.store.RecipeStore
import ie.pennylabs.x.basil.feature.recipe.detail.DetailBottomSheet
import kotlinx.android.synthetic.main.activity_list.*
import javax.inject.Inject

class ListActivity : BaseActivity() {
  @Inject
  lateinit var store: RecipeStore
  private val recipeDetailBottomSheet by lazy { DetailBottomSheet() }

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_list)

    store.fetchAll().observe(this@ListActivity, Observer { recipes ->
      if (recipes != null) {
        pagerRecipe.adapter = ListPagerAdapter(recipes)

        ivOpenRecipe.setOnClickListener {
          recipeDetailBottomSheet.recipeId = recipes[pagerRecipe.currentItem].id
          recipeDetailBottomSheet.show(supportFragmentManager)
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