package ie.pennylabs.x.basil.feature.recipe.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ie.pennylabs.x.basil.BasilApplication
import ie.pennylabs.x.basil.R
import ie.pennylabs.x.basil.data.store.RecipeStore
import kotlinx.android.synthetic.main.bottom_sheet_detail.*
import javax.inject.Inject

class DetailBottomSheet : BottomSheetDialogFragment() {
  @Inject
  lateinit var store: RecipeStore
  var recipeId: String = ""

  init {
    BasilApplication.component.inject(this)
  }

  fun show(manager: FragmentManager?) {
    super.show(manager, TAG)

    store.fetch(recipeId).observeForever {
      it?.let { recipe ->
        tvTitle.text = recipe.name
        tvDescription.text = recipe.description
        tvValueCalories.text = recipe.calories
        tvValueProtein.text = recipe.protein
        tvValueFat.text = recipe.fat

        bsRecipeInstructions.recipeId = recipeId
      }
    }
  }

  override fun onStart() {
    super.onStart()
    dialog.findViewById<View>(R.id.design_bottom_sheet)?.let { bs ->
      bs.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
    }

    view?.post {
      val params = (view?.parent as View).layoutParams as CoordinatorLayout.LayoutParams
      val bottomSheetBehavior = params.behavior as BottomSheetBehavior<*>?
      bottomSheetBehavior?.peekHeight = view?.measuredHeight ?: 0
    }
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
    inflater.inflate(R.layout.bottom_sheet_detail, container, false)

  override fun dismiss() {
    super.dismiss()

    store.fetch(recipeId).removeObservers(this)
  }

  companion object {
    const val TAG = "bottom_sheet_recipe_detail"
  }
}