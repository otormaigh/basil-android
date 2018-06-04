package ie.pennylabs.x.basil.data.store

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import ie.pennylabs.x.basil.R
import ie.pennylabs.x.basil.data.model.Recipe
import ie.pennylabs.x.basil.data.model.RecipeDao
import ie.pennylabs.x.basil.toolbox.extension.rawJsonToString

class RecipeStore(
  private val dao: RecipeDao,
  private val moshi: Moshi
) {

  fun fetch(id: String) = dao.fetch(id)

  fun fetchAll() = dao.fetchAll()

  suspend fun seed(context: Context) {
    dao.insert(moshi
        .adapter<List<Recipe>>(Types.newParameterizedType(List::class.java, Recipe::class.java))
        .fromJson(context.rawJsonToString(R.raw.recipes))!!)
  }
}