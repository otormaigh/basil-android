package ie.pennylabs.x.basil.data.model

import androidx.lifecycle.LiveData
import androidx.room.*
import ie.pennylabs.x.basil.data.model.Recipe.Key.ID
import ie.pennylabs.x.basil.data.model.Recipe.Key.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class Recipe(
    @PrimaryKey
    @ColumnInfo(name = ID)
    val id: String,
    val name: String,
    val description: String,
    val calories: String,
    val protein: String,
    val fat: String) {

  object Key {
    const val TABLE_NAME = "recipe"
    const val ID = "id"
  }
}

@Dao
abstract class RecipeDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  abstract fun insert(recipes: List<Recipe>)

  @Query("SELECT * FROM $TABLE_NAME WHERE $ID = :id")
  abstract fun fetch(id: String): Recipe

  @Query("SELECT * FROM $TABLE_NAME")
  abstract fun fetchAll(): LiveData<List<Recipe>>
}