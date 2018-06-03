package ie.pennylabs.x.basil

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import ie.pennylabs.x.basil.data.store.IngredientStore
import ie.pennylabs.x.basil.data.store.RecipeStore
import ie.pennylabs.x.basil.di.AppComponent
import ie.pennylabs.x.basil.di.DaggerAppComponent
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.launch
import timber.log.Timber
import javax.inject.Inject

class BasilApplication : Application(), HasActivityInjector {
  @Inject
  lateinit var activityInjector: DispatchingAndroidInjector<Activity>
  @Inject
  lateinit var recipeStore: RecipeStore
  @Inject
  lateinit var ingredientsStore: IngredientStore
  private val job = Job()

  override fun onCreate() {
    super.onCreate()

    @Suppress("ConstantConditionIf")
    if (BuildConfig.DEBUG) {
      Timber.plant(object : Timber.DebugTree() {
        override fun createStackElementTag(element: StackTraceElement): String {
          return "(${element.fileName}:${element.lineNumber})"
        }
      })
    }

    component = DaggerAppComponent.builder()
        .application(this)
        .build()
    component.inject(this)

    launch(job) {
      recipeStore.seed(this@BasilApplication)
      ingredientsStore.seed(this@BasilApplication)
    }
  }

  override fun activityInjector(): AndroidInjector<Activity> = activityInjector

  companion object {
    lateinit var component: AppComponent
  }
}