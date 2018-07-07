# local
-keep class ie.pennylabs.x.basil.** { *; }

# https://github.com/square/moshi/
-keepclassmembers class kotlin.Metadata {
    public <methods>;
}
-dontwarn okio.**
-dontwarn javax.annotation.**
-keepclasseswithmembers class * {
    @com.squareup.moshi.* <methods>;
}
-keep @com.squareup.moshi.JsonQualifier interface *

# https://github.com/google/dagger/
-dontwarn com.google.errorprone.annotations.**

# https://firebase.google.com/docs/crashlytics/get-deobfuscated-reports
-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable
-keep public class * extends java.lang.Exception%

# https://github.com/Kotlin/kotlinx.coroutines
-keepclassmembernames class kotlinx.** {
    volatile <fields>;
}

# kotlin.reflect
-dontwarn kotlin.reflect.jvm.internal.**
-keep class kotlin.reflect.jvm.internal.** { *; }