[![](https://jitpack.io/v/io.github.xmansoft/butterknife.svg)](https://jitpack.io/#io.github.xmansoft/butterknife)

## Prerequisites

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		
		maven { url "https://jitpack.io" }
	}
}
```

## Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
    
      implementation 'io.github.xmansoft:butterknife:2.2.0'

}
```

 ## Usage
```java

   protected void onCreate (Bundle b) {
               super.onCreate(b);
               setContentView(R.layout.main);
               ButterKnife.bind(this) //required
}

```
``` java
@BindView(R.id.view)
View view;
```
To bind all views.
Use this it to set up findViewById with out add findViewById (R.id.view).
You can use this code with all views (Linear, Button, Toolbar, Fab, Textview and EditText ... etc)

``` java
@BindDrawable(R.drawable.image)
Drawable image;
```
To bind drawables or mipmaps.

``` java
@BindLayout(R.layout.dialog)
View dialog;
```
To bind layout.
Use this when you want to make custom toast or dialog.

``` java
@BindAnim(R.anim.animation)
Animation animation;
```
To bind animations.

``` java
@BindString(R.string.str)
String str;
```
``` java
@BindArray(R.array.mArray)
String[] mArray;
```
To bind array string.

``` java
@BindColor(R.color.red)
int red;
```
To bind colors.
```java
@BindView(R.id.edt)
EditText edt;
```
To bind edittexts.
```java
@BindView(R.id.comp)
CompoundButton comp;
```
To bind compoundbuttons like checkbox and switch ... etc
``` java
@OnClick(R.id.button)
public void method()
{
// You must use public to make it work.

}
```
``` java
@OnTouch(R.id.button)
public void method()
{
// You must use public to make it work.

}
```
``` java
@OnLongClick(R.id.button)
public void method()
{
// You must use public to make it work.
 
}
```
```java
@OnTextChanged(R.id.edt)
 public void method(String text){
 // You must use public to make it work.
// You must use String to make it work.
    
    }
```
```java
@OnCheckedChanged(R.id.checkbox / radiobutton / swith / toggelbutton ... etc extends CompoundButton)
 public void method(boolean b){
 // You must use public to make it work.
// You must use boolean to make it work.
    
    }
```
``` java
@OnItemClick(R.id.list)
public void method(int i)
{
// You must use public to make it work.
// You must use int to make it work.
}
```
``` java
@OnItemLongClick(R.id.list)
public void method(int i)
{
// You must use public to make it work.
// You must use int to make it work.
}
```
``` java
@OnItemSelected(R.id.spinner)
public void method(int i)
{
// You must use public to make it work.
// You must use int to make it work.
}
```
``` java
@OnRatingBarChange(R.id.ratingbar)
public void method(float f)
{
// You must use public to make it work.
// You must use float to make it work.

}
```
``` java
@OnTimeChanged(R.id.timepicker)
public void method(int i, int i2)
{
// You must use public to make it work.
// You must use int to make it work.
// i = hour, i2 = minute.
}
```
``` java
@OnDateChanged(R.id.datepicker / calenderview)
public void method(int i, int i2, int i3)
{
// You must use public to make it work.
// You must use int to make it work.
// i = year, i2 = month, i3 = day.
}
```
## Progaurd 
```txt

-dontwarn com.xmansoft.libs.butterknife.**

-keepclasseswithmembers @interface com.xmansoft.libs.butterknife.annotation.** { 
     int value();
}

-keepclassmembers, allowobfuscation class * {
     @com.xmansoft.libs.butterknife.annotation.** <fields>;
}

-keepclassmembers, allowobfuscation class * {
    @com.xmansoft.libs.butterknife.annotation.** <methods>;
}


```
