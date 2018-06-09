package ie.pennylabs.x.basil.data.model

import androidx.lifecycle.LiveData
import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
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
  val fat: String
) {

  object Key {
    const val TABLE_NAME = "recipe"
    const val ID = "id"
  }
}

@Dao
interface RecipeDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(recipes: List<Recipe>)

  @Query("SELECT * FROM $TABLE_NAME WHERE $ID = :id")
  fun fetch(id: String): LiveData<Recipe>

  @Query("SELECT * FROM $TABLE_NAME")
  fun fetchAll(): LiveData<List<Recipe>>
}