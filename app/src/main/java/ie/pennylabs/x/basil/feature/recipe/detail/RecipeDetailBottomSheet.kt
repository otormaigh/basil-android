package ie.pennylabs.x.basil.feature.recipe.detail

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.tabs.TabLayout
import ie.pennylabs.x.basil.R
import ie.pennylabs.x.basil.toolbox.extension.expand
import kotlinx.android.synthetic.main.bottom_sheet_recipe_detail.view.*

class RecipeDetailBottomSheet : ConstraintLayout {
  val bottomSheet: BottomSheetBehavior<RecipeDetailBottomSheet> by lazy { BottomSheetBehavior.from(this) }

  constructor(context: Context) : super(context)
  constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
  constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

  init {
    LayoutInflater.from(context).inflate(R.layout.bottom_sheet_recipe_detail, this, true)

    pager.apply {
      pagerTabs.setupWithViewPager(this)
      adapter = RecipePagerAdapter()
    }

    pagerTabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
      override fun onTabReselected(p0: TabLayout.Tab?) {
        bottomSheet.expand()
      }

      override fun onTabUnselected(p0: TabLayout.Tab?) {
      }

      override fun onTabSelected(p0: TabLayout.Tab?) {
        bottomSheet.expand()
      }
    })
  }
}