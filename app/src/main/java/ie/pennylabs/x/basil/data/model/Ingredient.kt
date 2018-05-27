package ie.pennylabs.x.basil.data.model

import androidx.recyclerview.widget.DiffUtil
import com.squareup.moshi.Json

data class Ingredient(
    val id: String,
    @Json(name = "recipe_id")
    val recipeId: String,
    @Json(name = "sort_order")
    val sortOrder: String,
    val name: String,
    val quantity: String)

class IngredientDiffUtil : DiffUtil.ItemCallback<Ingredient>() {
  override fun areItemsTheSame(oldItem: Ingredient, newItem: Ingredient) = oldItem.id === newItem.id

  override fun areContentsTheSame(oldItem: Ingredient, newItem: Ingredient) = oldItem === newItem
}