# Default Proguard Rules for Code Obfuscation & Size Reduction
-keepattributes SourceFile,LineNumberTable
-keep public class * extends android.app.Activity
-dontwarn okio.**
-dontwarn javax.annotation.**
