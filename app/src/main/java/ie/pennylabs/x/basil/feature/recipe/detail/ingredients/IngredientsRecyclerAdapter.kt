package ie.pennylabs.x.basil.feature.recipe.detail.ingredients

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ie.pennylabs.x.basil.R
import ie.pennylabs.x.basil.data.model.Ingredient
import ie.pennylabs.x.basil.data.model.IngredientDiffUtil
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_ingredient.*

class IngredientsRecyclerAdapter : ListAdapter<Ingredient, IngredientsRecyclerAdapter.ViewHolder>(IngredientDiffUtil()) {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
      ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_ingredient, parent, false))

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(getItem(position))
  }

  inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    fun bind(ingredient: Ingredient) {
      Log.e("MY_LOG", "BIND")
      tvName.text = ingredient.name
      tvQuantity.text = ingredient.quantity
    }
  }
}