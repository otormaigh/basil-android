package ie.pennylabs.x.basil.feature.recipe

import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.app.AppCompatActivity
import ie.pennylabs.x.basil.R
import kotlinx.android.synthetic.main.activity_recipe_main.*

class RecipeMainActivity : AppCompatActivity() {
  private val bottomSheet by lazy { BottomSheetBehavior.from(bsRecipeDetail) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_recipe_main)
  }
}