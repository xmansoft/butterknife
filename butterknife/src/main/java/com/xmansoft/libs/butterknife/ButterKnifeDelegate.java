package com.xmansoft.libs.butterknife;
import android.app.Activity;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import android.view.View;
import android.app.Dialog;
import android.content.Context;
import com.xmansoft.libs.butterknife.annotation.BindLayout;
import com.xmansoft.libs.butterknife.annotation.OnRatingBarChange;


abstract class ButterKnifeDelegate {

    

    public static ButterKnifeDelegate create(Activity v, View vv) {
// TODO: Implement this method
        return new ButterKnifeDelegateImpl(v,vv);
    }

    public abstract void bindOnDateChanged();
    public abstract void bindOnRatingBarChange();
    public abstract void bindLayout();
    public abstract void bindString();
	public abstract void bindArray();
	public abstract void bindColor();
    public abstract void bindBool();
	public abstract void bindDimen();
    public abstract void bindInt();
     public abstract void bindOnTimeChanged();
    
    public abstract void bindOnSeekBarChange();
      
    public abstract void bindView();
  
    public abstract Field[] getDeclaredFields();


    public abstract Method[] getDeclaredMethods();

	public abstract void bindDrawable();
	public abstract void bindOnClick();

    public abstract void bindOnTextChanged();

    public abstract void bindOnCheckedChanged();
    
    public abstract void bindOnLongClick();

    public abstract void bindAnimation();
    public abstract void bindOnItemLongClick();
    public abstract void bindOnItemClick();

    public abstract void bindOnItemSelected();

    

}
