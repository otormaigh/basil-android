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
