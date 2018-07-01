package basil

import java.io.IOException
import java.util.concurrent.TimeUnit

object BuildConst {
  object Git {
    val shortHash = "git rev-parse --short HEAD".runCommand()?.trim() ?: ""
  }

  object Version {
    private const val major = 0
    private const val minor = 1
    private const val patch = 16
    private val build = System.getenv("CIRCLE_BUILD_NUM")?.toInt() ?: 1

    val name = "$major.$minor.$patch-${Git.shortHash}"
    val code = major * 10000000 + minor * 100000 + patch * 1000 + build
  }
}

private fun String.runCommand(): String? {
  return try {
    val parts = split("\\s".toRegex())
    val proc = ProcessBuilder(*parts.toTypedArray())
      .redirectOutput(ProcessBuilder.Redirect.PIPE)
      .redirectError(ProcessBuilder.Redirect.PIPE)
      .start()

    proc.waitFor(60, TimeUnit.MINUTES)
    proc.inputStream.bufferedReader().readText()
  } catch (e: IOException) {
    e.printStackTrace()
    null
  }
}