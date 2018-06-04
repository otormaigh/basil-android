package ie.pennylabs.x.basil.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import ie.pennylabs.x.basil.BasilApplication
import ie.pennylabs.x.basil.feature.recipe.detail.RecipeDetailBottomSheet
import ie.pennylabs.x.basil.feature.recipe.detail.ingredients.IngredientsPage
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, DataModule::class, ActivityBuilder::class])
interface AppComponent {
  @Component.Builder
  interface Builder {
    @BindsInstance
    fun application(application: BasilApplication): Builder

    fun build(): AppComponent
  }

  fun inject(application: BasilApplication)
  fun inject(ingredientsPage: IngredientsPage)
  fun inject(recipeDetailBottomSheet: RecipeDetailBottomSheet)
}