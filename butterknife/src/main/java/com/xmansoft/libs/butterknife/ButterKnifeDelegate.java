package com.xmansoft.libs.butterknife;
import android.app.Activity;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


abstract class ButterKnifeDelegate {
    
    public abstract ButterKnifeDelegate bindAnimator();
	public abstract ButterKnifeDelegate bindInterpolator();
    public abstract ButterKnifeDelegate bindString();
	public abstract ButterKnifeDelegate bindArray();
	public abstract ButterKnifeDelegate bindColor();

	public static ButterKnifeDelegate create( Activity act) {

		return ButterKnifeDelegate.mCreate(act);
	}
    
	private static ButterKnifeDelegate mCreate( Activity act) {
		return new ButterKnifeDelegateImpl(act);
	}
    
    
    public abstract ButterKnifeDelegate bindView();

    public abstract Field[] getDeclaredFields();
    
    
    public abstract Method[] getDeclaredMethods();
	
	public abstract ButterKnifeDelegate bindDrawable();
	public abstract ButterKnifeDelegate bindOnClick();
	
    public abstract ButterKnifeDelegate bindOnTextChanged();

    public abstract ButterKnifeDelegate bindOnCheckedChanged();
    public abstract ButterKnifeDelegate bindOnTouch();
	
    public abstract ButterKnifeDelegate bindOnLongClick();
	
   public abstract ButterKnifeDelegate bindAnimation();
   public abstract ButterKnifeDelegate bindOnItemLongClick();
    public abstract ButterKnifeDelegate bindOnItemClick();
    
   public abstract ButterKnifeDelegate bindOnItemSelected();
   
 
   public abstract ButterKnifeDelegate bindLayout();
   
   
   
   
   
   }
