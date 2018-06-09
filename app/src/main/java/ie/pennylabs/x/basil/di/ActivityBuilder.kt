package ie.pennylabs.x.basil.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ie.pennylabs.x.basil.feature.recipe.list.ListActivity

@Module
abstract class ActivityBuilder {
  @ContributesAndroidInjector
  abstract fun bindRecipeListActivity(): ListActivity
}