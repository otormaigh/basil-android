package ie.pennylabs.x.basil.data.model

import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import com.squareup.moshi.Json
import ie.pennylabs.x.basil.data.model.Ingredient.Key.RECIPE_ID
import ie.pennylabs.x.basil.data.model.Ingredient.Key.SORT_ORDER
import ie.pennylabs.x.basil.data.model.Ingredient.Key.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class Ingredient(
  @PrimaryKey
  val id: String,
  @Json(name = RECIPE_ID)
  @ColumnInfo(name = RECIPE_ID)
  val recipeId: String,
  @Json(name = SORT_ORDER)
  @ColumnInfo(name = SORT_ORDER)
  val sortOrder: String,
  val name: String,
  val quantity: String
) {

  object Key {
    const val TABLE_NAME = "ingredient"
    const val RECIPE_ID = "recipe_id"
    const val SORT_ORDER = "sort_order"
  }
}

class IngredientDiffUtil : DiffUtil.ItemCallback<Ingredient>() {
  override fun areItemsTheSame(oldItem: Ingredient, newItem: Ingredient) = oldItem.id === newItem.id

  override fun areContentsTheSame(oldItem: Ingredient, newItem: Ingredient) = oldItem === newItem
}

@Dao
interface IngredientDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(ingredients: List<Ingredient>)

  @Query("SELECT * FROM $TABLE_NAME WHERE $RECIPE_ID = :recipeId")
  fun fetchForRecipe(recipeId: String): LiveData<List<Ingredient>>
}