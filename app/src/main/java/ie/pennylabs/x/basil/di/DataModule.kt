package ie.pennylabs.x.basil.di

import androidx.room.Room
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import ie.pennylabs.x.basil.BasilApplication
import ie.pennylabs.x.basil.data.BasilDatabase
import ie.pennylabs.x.basil.data.store.IngredientStore
import ie.pennylabs.x.basil.data.store.RecipeStore
import javax.inject.Singleton

@Module
object DataModule {
  @Provides
  @Singleton
  @JvmStatic
  fun provideMoshi(): Moshi = Moshi.Builder()
      .add(KotlinJsonAdapterFactory())
      .build()

  @Provides
  @Singleton
  @JvmStatic
  fun provideDatabase(context: BasilApplication): BasilDatabase =
      Room.databaseBuilder(context.applicationContext, BasilDatabase::class.java, "basil.db")
          .fallbackToDestructiveMigration()
          .build()

  @Provides
  @JvmStatic
  fun provideIngredientStore(database: BasilDatabase, moshi: Moshi): IngredientStore = IngredientStore(database.ingredientDao(), moshi)

  @Provides
  @JvmStatic
  fun provideRecipeStore(database: BasilDatabase, moshi: Moshi): RecipeStore = RecipeStore(database.recipeDao(), moshi)
}