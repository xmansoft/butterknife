-keepattributes SourceFile
-renamesourcefileattribute Xmansoft

-ignorewarnings
-dontwarn
-dontnote

-dontshrink

-keep class * { *; }
-keep @interface * { *; }

-dontobfuscate

-dontwarn com.xmansoft.libs.butterknife.**


-keepclasseswithmembers, allowobfuscation class * {
     @com.xmansoft.libs.butterknife.annotation.** <fields>;
}
-keepclasseswithmembers, allowobfuscation class * {
    @com.xmansoft.libs.butterknife.annotation.** <methods>;
}
-keepclasseswithmembers, allowobfuscation class * {
     @com.xmansoft.libs.butterknife.annotation.** <init>(...);
}


