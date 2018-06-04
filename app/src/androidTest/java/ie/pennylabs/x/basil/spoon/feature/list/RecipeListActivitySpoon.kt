package ie.pennylabs.x.basil.spoon.feature.list

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import ie.pennylabs.x.basil.R
import ie.pennylabs.x.basil.feature.recipe.list.RecipeListActivity
import ie.pennylabs.x.basil.spoon.SpoonTest
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RecipeListActivitySpoon : SpoonTest() {
  @get:Rule
  val activityRule = ActivityTestRule(RecipeListActivity::class.java)

  @Test
  fun spoonRecipeList() = runBlocking<Unit> {
    delay(700)
    spoon.screenshot(activityRule.activity, "activity_recipe_list_page_one")

    onView(withId(R.id.ivOpenRecipe))
      .perform(click())
    spoon.screenshot(activityRule.activity, "bottom_sheet_recipe_detail")
  }
}