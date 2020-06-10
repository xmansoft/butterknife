package com.xmansoft.libs.butterknife.annotation;

import androidx.annotation.AnimRes;

@java.lang.annotation.Retention(value=java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Target(value=java.lang.annotation.ElementType.FIELD)

public @interface BindAnim {
    @AnimRes int value();
}
