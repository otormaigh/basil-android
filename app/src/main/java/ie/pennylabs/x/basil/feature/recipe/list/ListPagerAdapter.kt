package ie.pennylabs.x.basil.feature.recipe.list

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import ie.pennylabs.x.basil.data.model.Recipe

class ListPagerAdapter(private val recipes: List<Recipe>, private val imagePaddingTop: Int) : PagerAdapter() {
  override fun isViewFromObject(view: View, `object`: Any) = view === `object`
  override fun getCount() = recipes.size
  override fun instantiateItem(container: ViewGroup, position: Int): Any {
    val page = RecipePage(container.context, recipes[position], imagePaddingTop)
    container.addView(page)
    return page
  }

  override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
    container.removeView(`object` as View)
  }
}