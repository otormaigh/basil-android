package ie.pennylabs.x.basil.data.model

import androidx.recyclerview.widget.DiffUtil

data class Ingredient(
    val id: String,
    val name: String,
    val quantity: String)

class IngredientDiffUtil : DiffUtil.ItemCallback<Ingredient>() {
  override fun areItemsTheSame(oldItem: Ingredient, newItem: Ingredient) = oldItem.id === newItem.id

  override fun areContentsTheSame(oldItem: Ingredient, newItem: Ingredient) = oldItem === newItem
}