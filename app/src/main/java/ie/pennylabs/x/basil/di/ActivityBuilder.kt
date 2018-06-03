package ie.pennylabs.x.basil.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ie.pennylabs.x.basil.feature.recipe.RecipeMainActivity
import ie.pennylabs.x.basil.feature.recipe.list.RecipeListActivity

@Module
abstract class ActivityBuilder {
  @ContributesAndroidInjector
  abstract fun bindRecipeMainActivity(): RecipeMainActivity

  @ContributesAndroidInjector
  abstract fun bindRecipeListActivity(): RecipeListActivity
}