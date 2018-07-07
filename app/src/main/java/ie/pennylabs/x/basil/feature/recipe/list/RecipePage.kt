package ie.pennylabs.x.basil.feature.recipe.list

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.updatePadding
import ie.pennylabs.x.basil.R
import ie.pennylabs.x.basil.data.model.Recipe
import kotlinx.android.synthetic.main.page_recipe.view.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

@SuppressLint("ViewConstructor")
class RecipePage(context: Context,
                 imagePaddingTop: Int,
                 private val recipe: Recipe) : CoordinatorLayout(context) {

  init {
    LayoutInflater.from(context).inflate(R.layout.page_recipe, this, true)

    launch(UI) {
      ivImage.updatePadding(top = imagePaddingTop + resources.getDimension(R.dimen.vertical_margin).toInt())
      recipeDetailBottomSheet.recipe = recipe
      recipeDetailBottomSheet.setPeekHeight(ivImage.bottom - ivImage.paddingTop)
    }
  }
}