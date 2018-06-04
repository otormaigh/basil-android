package ie.pennylabs.x.basil.data.store

import android.content.Context
import androidx.lifecycle.LiveData
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import ie.pennylabs.x.basil.R
import ie.pennylabs.x.basil.data.model.Ingredient
import ie.pennylabs.x.basil.data.model.IngredientDao
import ie.pennylabs.x.basil.toolbox.extension.rawJsonToString

class IngredientStore(
  private val dao: IngredientDao,
  private val moshi: Moshi
) {

  fun fetchForRecipe(recipeId: String): LiveData<List<Ingredient>> = dao.fetchForRecipe(recipeId)

  suspend fun seed(context: Context) {
    dao.insert(moshi
        .adapter<List<Ingredient>>(Types.newParameterizedType(List::class.java, Ingredient::class.java))
        .fromJson(context.rawJsonToString(R.raw.ingredients))!!)
  }
}