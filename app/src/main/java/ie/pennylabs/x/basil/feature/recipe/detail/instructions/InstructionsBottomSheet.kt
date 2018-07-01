package ie.pennylabs.x.basil.feature.recipe.detail.instructions

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import ie.pennylabs.x.basil.R
import ie.pennylabs.x.basil.toolbox.extension.doOnTabReselected
import ie.pennylabs.x.basil.toolbox.extension.doOnTabSelected
import ie.pennylabs.x.basil.toolbox.extension.expand
import kotlinx.android.synthetic.main.bottom_sheet_instructions.view.*

class InstructionsBottomSheet : ConstraintLayout {
  private val bottomSheet: BottomSheetBehavior<InstructionsBottomSheet> by lazy { BottomSheetBehavior.from(this) }
  var recipeId: String = ""

  constructor(context: Context) : super(context)
  constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
  constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

  init {
    LayoutInflater.from(context).inflate(R.layout.bottom_sheet_instructions, this, true)
  }

  override fun onAttachedToWindow() {
    super.onAttachedToWindow()
    pager.apply {
      adapter = InstructionsPagerAdapter(recipeId)
      pagerTabs?.setupWithViewPager(this)
    }

    pagerTabs.doOnTabReselected { bottomSheet.expand() }
    pagerTabs.doOnTabSelected { bottomSheet.expand() }
  }
}