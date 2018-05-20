package ie.pennylabs.x.basil.feature.recipe.detail

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import ie.pennylabs.x.basil.feature.recipe.detail.ingredients.IngredientsPage

class RecipePagerAdapter : PagerAdapter() {
  override fun isViewFromObject(view: View, `object`: Any) = view === `object`
  override fun getCount() = 2
  override fun getPageTitle(position: Int) = when (position) {
    0 -> "Ingredients"
    1 -> "Directions"
    else -> throw IndexOutOfBoundsException()
  }

  override fun instantiateItem(container: ViewGroup, position: Int): Any {
    val view = when (position) {
      0 -> IngredientsPage(container.context)
      1 -> IngredientsPage(container.context)
      else -> throw IndexOutOfBoundsException()
    }
    container.addView(view)
    return view
  }

  override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
    container.removeViewAt(position)
  }
}