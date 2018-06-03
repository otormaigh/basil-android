package ie.pennylabs.x.basil.arch

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.experimental.Job

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {
  protected val job = Job()

  override fun onDestroy() {
    super.onDestroy()
    job.cancel()
  }
}