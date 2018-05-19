package ie.pennylabs.x.basil

import android.support.test.annotation.UiThreadTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.squareup.spoon.SpoonRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivitySpoon {
  @get:Rule
  val spoon = SpoonRule()
  @get:Rule
  val activityRule = ActivityTestRule(MainActivity::class.java)

  @Test
  @UiThreadTest
  fun testScreenshot() {
    spoon.screenshot(activityRule.activity, "activity_main")
  }
}