-dontshrink
-ignorewarnings
-dontwarn
-dontnote

-keepattributes SourceFile
-renamesourcefileattribute XMANSOFT

-obfuscationdictionary dictionary.txt
-classobfuscationdictionary dictionary.txt


-dontwarn com.xmansoft.libs.butterknife.**

-keep public class com.xmansoft.libs.butterknife.** {
     public static <methods>;  
}

-keep public final class com.xmansoft.libs.butterknife.** {
     public static final <fields>;  
}

-keepclasseswithmembers @interface com.xmansoft.libs.butterknife.annotation.** { 
     int value();
}

