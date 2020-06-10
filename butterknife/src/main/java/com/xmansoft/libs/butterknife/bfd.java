package com.xmansoft.libs.butterknife;
import android.app.Activity;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


abstract class bfd {
    
    public abstract bfd bindAnimator();
	public abstract bfd bindInterpolator();
    public abstract bfd bindString();
	public abstract bfd bindArray();
	public abstract bfd bindColor();

	public static bfd a( Activity act) {

		return bfd.b(act);
	}
    
	private static bfd b( Activity act) {
		return new bfdi(act);
	}
    
    
    public abstract bfd bindView();

    public abstract Field[] a();
    
    
    public abstract Method[] b();
	
	public abstract bfd bindDrawable();
	public abstract bfd bindOnClick();
	
    public abstract bfd bindOnTextChanged();

    public abstract bfd bindOnCheckedChanged();
    public abstract bfd bindOnTouch();
	
    public abstract bfd bindOnLongClick();
	
   public abstract bfd bindAnimation();
   public abstract bfd bindOnItemLongClick();
    public abstract bfd bindOnItemClick();
    
   public abstract bfd bindOnItemSelected();
   
 
   public abstract bfd bindLayout();
   
   
   
   
   
   }
