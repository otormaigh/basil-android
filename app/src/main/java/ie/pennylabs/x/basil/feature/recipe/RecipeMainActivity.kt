package ie.pennylabs.x.basil.feature.recipe

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import ie.pennylabs.x.basil.R
import kotlinx.android.synthetic.main.activity_recipe_main.*

class RecipeMainActivity : AppCompatActivity() {
  private val bottomSheet by lazy { BottomSheetBehavior.from(bsRecipeDetail) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_recipe_main)
  }

  companion object {
    fun start(context: Context) {
      context.startActivity(Intent(context, RecipeMainActivity::class.java))
    }
  }
}