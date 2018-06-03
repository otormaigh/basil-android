package ie.pennylabs.x.basil.toolbox.extension

import android.content.Context
import androidx.annotation.RawRes
import java.nio.charset.StandardCharsets

fun Context.rawJsonToString(@RawRes resourceId: Int): String =
    resources.openRawResource(resourceId).use {
      val size = it.available()
      val buffer = ByteArray(size)
      it.read(buffer)
      it.close()

      String(buffer, StandardCharsets.UTF_8)
    }