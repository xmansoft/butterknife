package com.xmansoft.libs.butterknife.annotation;

import android.support.annotation.IdRes;

@java.lang.annotation.Retention(value=java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Target(value=java.lang.annotation.ElementType.METHOD)
public @interface OnTouch {
    @IdRes int value();
}
