package ie.pennylabs.x.basil.feature.recipe.detail.ingredients

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ie.pennylabs.x.basil.BasilApplication
import ie.pennylabs.x.basil.data.store.IngredientStore
import javax.inject.Inject

@SuppressLint("ViewConstructor")
class IngredientsPage(context: Context, recipeId: String) : RecyclerView(context), LifecycleOwner {
  private val lifecycleRegistry = LifecycleRegistry(this)
  @Inject
  lateinit var store: IngredientStore

  init {
    BasilApplication.component.inject(this)

    layoutManager = LinearLayoutManager(context)
    adapter = IngredientsRecyclerAdapter().apply {
      store.fetchForRecipe(recipeId).observe(this@IngredientsPage, Observer {
        if (it != null) submitList(it)
      })
    }
  }

  override fun onAttachedToWindow() {
    super.onAttachedToWindow()
    lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START)
  }

  override fun onDetachedFromWindow() {
    super.onDetachedFromWindow()
    lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  }

  override fun getLifecycle() = lifecycleRegistry
}