package ie.pennylabs.x.basil.feature.recipe.list

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.view.updatePadding
import ie.pennylabs.x.basil.R
import ie.pennylabs.x.basil.data.model.Recipe
import kotlinx.android.synthetic.main.page_recipe.view.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

@SuppressLint("ViewConstructor")
class RecipePage(context: Context,
                 private val recipe: Recipe,
                 private val imagePaddingTop: Int) : FrameLayout(context) {

  init {
    LayoutInflater.from(context).inflate(R.layout.page_recipe, this, true)
  }

  override fun onAttachedToWindow() {
    super.onAttachedToWindow()
    ivImage.updatePadding(top = imagePaddingTop)

    launch(UI) {
      recipeDetailBottomSheet.recipe = recipe
      recipeDetailBottomSheet.setPeekHeight(ivImage.bottom - imagePaddingTop)
    }
  }
}