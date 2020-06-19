-injars /storage/emulated/0/AppProjects/butterknife/app/build/bin/classesrelease_proguard
-outjars /storage/emulated/0/AppProjects/butterknife/app/build/bin/proguard

-libraryjars /data/user/0/com.aide.clone/no_backup/.aide/android.jar

-dontshrink
-printusage /storage/emulated/0/AppProjects/butterknife/app/build/bin/proguard.usage.txt
-dontoptimize
-optimizations !code/simplification/arithmetic,!code/simplification/cast,!field/*,!class/merging/*
-optimizationpasses 5
-allowaccessmodification
-printmapping /storage/emulated/0/AppProjects/butterknife/app/build/bin/proguard.mapping.txt
-obfuscationdictionary /storage/emulated/0/AppProjects/butterknife/app/dictionary.txt
-classobfuscationdictionary /storage/emulated/0/AppProjects/butterknife/app/dictionary.txt
-dontusemixedcaseclassnames
-keepattributes *Annotation*,SourceFile
-renamesourcefileattribute XMANSOFT
-dontpreverify
-verbose
-dontnote
-dontwarn android.support.**,android.arch.**,android.lifecycle.**,androidx.**,androidx.arch.**,androidx.lifecycle.**,com.xmansoft.libs.butterknife.**
-ignorewarnings
-printconfiguration /storage/emulated/0/AppProjects/butterknife/app/config.pro
-dump /storage/emulated/0/AppProjects/butterknife/app/dump.pro
-printseeds /storage/emulated/0/AppProjects/butterknife/app/build/bin/proguard.seeds.txt



-keep public class com.google.vending.licensing.ILicensingService

-keep public class com.android.vending.licensing.ILicensingService

-keepclasseswithmembers,allowshrinking class * {
    native <methods>;
}

-keepclassmembers public class * extends android.view.View {
    void set*(***);
    *** get*();
}

-keepclassmembers class * extends android.app.Activity {
    public void *(android.view.View);
}

-keepclassmembers enum  * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keepclassmembers class * extends android.os.Parcelable {
    public static final android.os.Parcelable$Creator CREATOR;
}

-keepclassmembers class **.R$* {
    public static <fields>;
}

-keep class android.support.annotation.Keep

-keep @android.support.annotation.Keep class * {
    <fields>;
    <methods>;
}

-keepclasseswithmembers class * {
    @android.support.annotation.Keep
    <methods>;
}

-keepclasseswithmembers class * {
    @android.support.annotation.Keep
    <fields>;
}

-keepclasseswithmembers class * {
    @android.support.annotation.Keep
    <init>(...);
}

-keep class androidx.annotation.Keep

-keep @androidx.annotation.Keep class * {
    <fields>;
    <methods>;
}

-keepclasseswithmembers class * {
    @androidx.annotation.Keep
    <methods>;
}

-keepclasseswithmembers class * {
    @androidx.annotation.Keep
    <fields>;
}

-keepclasseswithmembers class * {
    @androidx.annotation.Keep
    <init>(...);
}

# view AndroidManifest.xml #generated:19
-keep class com.xmansoft.apps.example_butterknife.MainActivity {
    <init>(...);
}

# view AndroidManifest.xml #generated:28
-keep class com.xmansoft.apps.example_butterknife.Temp {
    <init>(...);
}

-keepclassmembers,allowobfuscation class * {
    @com.xmansoft.libs.butterknife.annotation.**
    <fields>;
}

-keepclassmembers,allowobfuscation class * {
    @com.xmansoft.libs.butterknife.annotation.**
    <methods>;
}
