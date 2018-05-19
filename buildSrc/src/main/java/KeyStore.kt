@file:JvmName("Keystore")

import org.gradle.api.Project

const val releaseStore = "../signing/release.keystore"
const val debugStore = "../signing/debug.keystore"
const val playJson = "../signing/play.json"

val Project.storePassword get() = properties["BASIL_STORE_PASSWORD"].toString()
val Project.keyAlias get() = properties["BASIL_KEY_ALIAS"].toString()
val Project.keyPassword get() = properties["BASIL_KEY_PASSWORD"].toString()