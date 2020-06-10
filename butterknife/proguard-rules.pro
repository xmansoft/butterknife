-dontwarn com.xmansoft.libs.butterknife.**

-keep @interface * { *; }

-keepclasseswithmembers, allowobfuscation class com.xmansoft.libs.butterknife.** { *; }
 
-keepclasseswithmembers public class com.xmansoft.libs.butterknife.ButterKnife { 
   public <methods>; 
 }
 
-keepattributes SourceFile
-renamesourcefileattribute Xmansoft

-dontshrink
-ignorewarnings
-dontwarn
-dontnote
