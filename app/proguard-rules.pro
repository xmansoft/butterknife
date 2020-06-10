-keepattributes SourceFile
-renamesourcefileattribute Xmansoft

-ignorewarnings
-dontwarn
-dontnote

-dontshrink


-keep @interface * { *; }

-keepclasseswithmembers, allowobfuscation class com.xmansoft.libs.butterknife.** { *; }
 
-keepclasseswithmembers public class com.xmansoft.libs.butterknife.ButterKnife { 
  public <methods>; 
}

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


