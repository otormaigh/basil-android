package ie.pennylabs.x.basil.feature.recipe

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import ie.pennylabs.x.basil.R
import ie.pennylabs.x.basil.data.store.RecipeStore
import kotlinx.android.synthetic.main.activity_recipe_main.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext

class RecipeMainActivity : AppCompatActivity() {
  private val store by lazy { RecipeStore() }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_recipe_main)

    val recipeId = intent.getStringExtra(RECIPE_ID)
    bsRecipeDetail.recipeId = recipeId
    launch {
      val recipe = store.fetch(recipeId)
      withContext(UI) {
        tvTitle.text = recipe.name
        tvDescription.text = recipe.description
        tvValueCalories.text = recipe.calories
        tvValueProtein.text = recipe.protein
        tvValueFat.text = recipe.fat
      }
    }
  }

  override fun onBackPressed() {
    if (bsRecipeDetail.bottomSheet.state != BottomSheetBehavior.STATE_COLLAPSED) {
      bsRecipeDetail.bottomSheet.state = BottomSheetBehavior.STATE_COLLAPSED
    } else {
      super.onBackPressed()
    }
  }

  companion object {
    const val RECIPE_ID = "extra.recipe_id"

    fun start(context: Context, recipeId: String) {
      val intent = Intent(context, RecipeMainActivity::class.java).apply {
        putExtra(RECIPE_ID, recipeId)
      }
      context.startActivity(intent)
    }
  }
}