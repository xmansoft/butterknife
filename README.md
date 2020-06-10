## Prerequisites

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

## Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
	...
   
      //for android-x
	  implementation 'io.github.xmansoft:butterknife:1.1.0'
	
      //for old support library
      implementation 'io.github.xmansoft:butterknife:1.0.2'
	
	
}
```

 ## Usage
```java

   protected void onCreate (Bundle b) {
               super.onCreate(b);
               new ButterKnife(this) //required
               .getDelegate() //required
               .bindAnimation() //Set it if you use @BindAnimation
               .bindAnimator() //Set it if you use @BindAnimator
               .bindArray() //Set it if you use @BindArray
               .bindColor() //Set it if you use @BindColor
               .bindDrawable() //Set it if you use @BindDrawable
               .bindInterpolator() //Set it if you use @BindInterpolator
               .bindLayout()  //Set it if you use @BindLayout
               .bindOnCheckedChanged()  //Set it if you use @OnCheckedChanged
               .bindOnClick()  //Set it if you use @OnClick
               .bindOnItemClick()  //Set it if you use @OnItemClick
               .bindOnItemLongClick()  //Set it if you use @OnItemLongClick
               .bindOnTextChanged()  //Set it if you use @OnTextChanged
               .bindOnTouch()  //Set it if you use @OnTouch
               .bindString()  //Set it if you use @BindString
               .bindView();  //Set it if you use @BindView
               
               //You can use one, some or all
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
@BindArray(R.string.array)
String[] array;
```
To bind strings.

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
public void method ()
{
// You must use public to make it work.

}
```
``` java
@OnTouch(R.id.button)
public void method ()
{
// You must use public to make it work.

}
```
``` java
@OnLongClick(R.id.button)
public void method ()
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
@OnCheckedChanged(R.id.comp)
 public void method(boolean b){
 // You must use public to make it work.
// You must use boolean to make it work.
    
    }
```
``` java
@OnItemClick(R.id.list)
public void method (int i)
{
// You must use public to make it work.
// You must use int to make it work.
}
```
``` java
@OnItemLongClick(R.id.list)
public void method (int i)
{
// You must use public to make it work.
// You must use int to make it work.
}
```
``` java
@OnItemSelected(R.id.spinner)
public void method (int i)
{
// You must use public to make it work.
// You must use int to make it work.
}
```
## Progaurd 
```txt

-dontwarn com.mzstudio.libs.butterknife.**

-keepclasseswithmembers, allowobfuscation class * {
     @com.mzstudio.libs.butterknife.annotation.** <fields>;
}

-keepclasseswithmembers, allowobfuscation class * {
    @com.mzstudio.libs.butterknife.annotation.** <methods>;
}

-keepclasseswithmembers, allowobfuscation class * {
     @com.mzstudio.libs.butterknife.annotation.** <init>(...);
}

```
