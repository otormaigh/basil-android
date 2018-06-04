package ie.pennylabs.x.basil.spoon

import android.Manifest
import androidx.test.rule.GrantPermissionRule
import com.squareup.spoon.SpoonRule
import org.junit.Rule

open class SpoonTest {
  @get:Rule
  val spoon = SpoonRule()
  @get:Rule
  val permissionRule = GrantPermissionRule.grant(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
}