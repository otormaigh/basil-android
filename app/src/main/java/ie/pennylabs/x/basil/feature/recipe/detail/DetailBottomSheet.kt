package ie.pennylabs.x.basil.feature.recipe.detail

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import ie.pennylabs.x.basil.R
import ie.pennylabs.x.basil.data.model.Recipe
import kotlinx.android.synthetic.main.bottom_sheet_detail.view.*

class DetailBottomSheet : ConstraintLayout {
  val bottomSheet: BottomSheetBehavior<DetailBottomSheet> by lazy { BottomSheetBehavior.from(this) }
  var recipe: Recipe? = null
    set(value) {
      field = value
      bsRecipeInstructions.recipeId = value?.id ?: ""
      tvTitle.text = recipe?.name
      tvDescription.text = recipe?.description
      tvValueCalories.text = recipe?.calories
      tvValueProtein.text = recipe?.protein
      tvValueFat.text = recipe?.fat
    }

  constructor(context: Context) : super(context)
  constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
  constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

  init {
    LayoutInflater.from(context).inflate(R.layout.bottom_sheet_detail, this, true)
  }

  fun setPeekHeight(peekHeight: Int) {
    bottomSheet.peekHeight = peekHeight
  }
}