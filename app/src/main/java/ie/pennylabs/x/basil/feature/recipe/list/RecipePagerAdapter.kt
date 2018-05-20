package ie.pennylabs.x.basil.feature.recipe.list

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class RecipePagerAdapter : PagerAdapter() {
  override fun isViewFromObject(view: View, `object`: Any) = view === `object`
  override fun getCount() = 5
  override fun instantiateItem(container: ViewGroup, position: Int): Any {
    val page = RecipePage(container.context)
    container.addView(page)
    return page
  }

  override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
    container.removeView(`object` as View)
  }
}