package com.xmansoft.libs.butterknife;

import android.app.Activity;
import java.util.Optional;
import android.view.View;
import android.app.Dialog;
import android.util.Log;
import android.content.Context;
import java.lang.reflect.Field;
import com.xmansoft.libs.butterknife.annotation.BindLayout;
import com.xmansoft.libs.butterknife.annotation.BindAnim;

public final  class ButterKnife {



    private static ButterKnifeDelegate mDelegate;

    
    
    private static void bind(Activity c, View view) {
       
        mDelegate = getDelegate(c, view);
       
        mDelegate.bindAnimation();
        mDelegate.bindArray();
        mDelegate.bindColor();
        mDelegate.bindDrawable();
        mDelegate.bindOnCheckedChanged();
        mDelegate.bindOnClick();
        mDelegate.bindOnItemClick();
        mDelegate.bindOnItemLongClick();
        mDelegate.bindOnItemSelected();
        mDelegate.bindOnLongClick();
        mDelegate.bindOnTextChanged();
        mDelegate.bindString();
        mDelegate.bindView();
        mDelegate.bindBool();
        mDelegate.bindDimen();
        mDelegate.bindLayout();
        mDelegate.bindOnTimeChanged();
        mDelegate.bindOnDateChanged();
        mDelegate.bindOnRatingBarChange();
        mDelegate.bindOnSeekBarChange();
     
    }
    
    
    
    public static void bind(Activity activity) {
    
        bind(activity,activity.getWindow().getDecorView());
              }

    



    
    private static ButterKnifeDelegate getDelegate(Activity v, View vv) {
        if (mDelegate == null) {
            mDelegate = ButterKnifeDelegate.create(v, vv);
        }
        return mDelegate;
    }
    
    
    
    





}


