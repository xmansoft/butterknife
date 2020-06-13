-keepattributes SourceFile
-renamesourcefileattribute XMANSOFT

-ignorewarnings
-dontwarn
-dontnote

-printconfiguration config.pro
-dump dump.pro

-optimizations !code/simplification/arithmetic,!code/simplification/cast,!field/*,!class/merging/*
-optimizationpasses 5
-allowaccessmodification

-obfuscationdictionary dictionary.txt
-classobfuscationdictionary dictionary.txt


-dontshrink

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

-keepclassmembers, allowobfuscation class * {
     @com.xmansoft.libs.butterknife.annotation.** <fields>;
}

-keepclassmembers, allowobfuscation class * {
    @com.xmansoft.libs.butterknife.annotation.** <methods>;
}

