package com.xmansoft.libs.butterknife.annotation;
import android.support.annotation.ArrayRes;
@java.lang.annotation.Retention(value=java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Target(value=java.lang.annotation.ElementType.FIELD)

public @interface BindArray
{
 @ArrayRes  int value();
}
