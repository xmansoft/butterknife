package com.xmansoft.libs.butterknife;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import com.xmansoft.libs.butterknife.annotation.BindAnim;
import com.xmansoft.libs.butterknife.annotation.BindArray;
import com.xmansoft.libs.butterknife.annotation.BindBool;
import com.xmansoft.libs.butterknife.annotation.BindColor;
import com.xmansoft.libs.butterknife.annotation.BindDimen;
import com.xmansoft.libs.butterknife.annotation.BindDrawable;
import com.xmansoft.libs.butterknife.annotation.BindInt;
import com.xmansoft.libs.butterknife.annotation.BindString;
import com.xmansoft.libs.butterknife.annotation.BindView;
import com.xmansoft.libs.butterknife.annotation.OnCheckedChanged;
import com.xmansoft.libs.butterknife.annotation.OnClick;
import com.xmansoft.libs.butterknife.annotation.OnItemClick;
import com.xmansoft.libs.butterknife.annotation.OnItemLongClick;
import com.xmansoft.libs.butterknife.annotation.OnItemSelected;
import com.xmansoft.libs.butterknife.annotation.OnLongClick;
import com.xmansoft.libs.butterknife.annotation.OnTextChanged;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import com.xmansoft.libs.butterknife.annotation.BindLayout;
import android.widget.TimePicker;
import com.xmansoft.libs.butterknife.annotation.OnTimeChanged;
import android.widget.DatePicker;
import com.xmansoft.libs.butterknife.annotation.OnDateChanged;
import com.xmansoft.libs.butterknife.annotation.OnRatingBarChange;
import android.widget.RatingBar;
import android.widget.CalendarView;
import android.icu.util.Calendar;
import android.widget.SeekBar;
import com.xmansoft.libs.butterknife.annotation.OnSeekBarChange;

final class ButterKnifeDelegateImpl extends ButterKnifeDelegate {

    @Override
    public void bindOnSeekBarChange() {
        Method[] methodArr = getDeclaredMethods();
        int i = 0;
        while (i < methodArr.length) {
            Method method = methodArr[i];

            if (method.isAnnotationPresent(OnSeekBarChange.class)) {

                SeekBar findViewById = b.findViewById(((OnSeekBarChange)  method.getAnnotation(OnSeekBarChange.class)).value());
                if (findViewById instanceof SeekBar) {
                    ((SeekBar) findViewById).setOnSeekBarChangeListener(new ButterKnifeListener(method, a));
                }
            } 

            i++;

        }
    }


    @Override
    public void bindOnDateChanged() {
        Method[] methodArr = getDeclaredMethods();
        int i = 0;
        while (i < methodArr.length) {
            Method method = methodArr[i];

            if (method.isAnnotationPresent(OnDateChanged.class)) {
                View findViewById = b.findViewById(((OnDateChanged)  method.getAnnotation(OnDateChanged.class)).value());
                if (findViewById instanceof DatePicker) {
                    if (Build.VERSION.SDK_INT >= 26){



                        ((DatePicker) findViewById).setOnDateChangedListener(new ButterKnifeListener(method, a));
                    }     
                        
                        else if (Build.VERSION.SDK_INT <= 25){

                            Calendar calendar = Calendar.getInstance();  
                            calendar.setTimeInMillis(System.currentTimeMillis());
                            ((DatePicker) findViewById).init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new ButterKnifeListener(method,a)); 
                           // ((DatePicker) findViewById).getCalendarView().setOnDateChangeListener(new ButterKnifeListener(method, a));
                        }     
                        
                    
                    
                } else if (findViewById instanceof CalendarView) {
                  
                    ((CalendarView) findViewById).setOnDateChangeListener(new ButterKnifeListener(method, a));
                    
                    
                }
        
                }
                
                
                
                
           

            i++;

        }
    }

    @Override
    public void bindOnRatingBarChange() {
        Method[] methodArr = getDeclaredMethods();
        int i = 0;
        while (i < methodArr.length) {
            Method method = methodArr[i];

            if (method.isAnnotationPresent(OnRatingBarChange.class)) {

              RatingBar findViewById = b.findViewById(((OnRatingBarChange)  method.getAnnotation(OnRatingBarChange.class)).value());
                if (findViewById instanceof RatingBar) {
                    ((RatingBar) findViewById).setOnRatingBarChangeListener(new ButterKnifeListener(method, a));
                }
            } 

            i++;

        }
    }


    @Override
    public void bindOnTimeChanged() {
        Method[] methodArr = getDeclaredMethods();
        int i = 0;
        while (i < methodArr.length) {
            Method method = methodArr[i];

            if (method.isAnnotationPresent(OnTimeChanged.class)) {

                TimePicker findViewById = b.findViewById(((OnTimeChanged)  method.getAnnotation(OnTimeChanged.class)).value());
                if (findViewById instanceof TimePicker) {
                    ((TimePicker) findViewById).setOnTimeChangedListener(new ButterKnifeListener(method, a));
                }
            } 

            i++;

        }
    }


    @Override
    public void bindLayout() {
        View view  = (View) null;
        int i = 0;
        while (i < getDeclaredFields().length) {
            Field field  = getDeclaredFields()[i];

            BindLayout bindLayout  = (BindLayout) field.getAnnotation(BindLayout.class);
            if (bindLayout != null) {
                LayoutInflater in = a.getLayoutInflater(); 
                view = in.inflate(bindLayout.value(), null); 
                
                try {
                    field.setAccessible(true);
              
                    field.set(a, view);


                }
                catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            i++;
            
    }

}
    private View b;

  
    @Override
    public void bindInt() {
        int mInt = 0;

        int i = 0;
        while (i < getDeclaredFields().length) {
            Field field = getDeclaredFields()[i];

            BindInt bindInt =  (BindInt) field.getAnnotation(BindInt.class);

            if (bindInt != null) {
                try {

                    
                    mInt = b.getResources().getInteger(bindInt.value());

                    field.setAccessible(true);
                    field.set(a, mInt);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            i++;
        }
        
    }


    @Override
    public void bindDimen() {

        float dimen = 0;

        int i = 0;
        while (i < getDeclaredFields().length) {
            Field field = getDeclaredFields()[i];

            BindDimen bindDimen =  (BindDimen) field.getAnnotation(BindDimen.class);

            if (bindDimen != null) {
                try {

                    dimen = b.getResources().getDimension(bindDimen.value());

                    field.setAccessible(true);
                    field.set(a, dimen);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            i++;
        }

        
    }


    @Override
    public void bindBool() {
        //getResources().getBoolean(R.bool.mBool)


        boolean b = (Boolean) true;

        int i = 0;
        while (i < getDeclaredFields().length) {
            Field field = getDeclaredFields()[i];

            BindBool bindBool =  (BindBool) field.getAnnotation(BindBool.class);

            if (bindBool != null) {
                try {

                    b = this.b.getResources().getBoolean(bindBool.value());

                    field.setAccessible(true);
                    field.set(a, b);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            i++;
        }
       


    }




    @Override
    public void bindString() {
        String string = (String) null;

        int i = 0;
        while (i < getDeclaredFields().length) {
            Field field = getDeclaredFields()[i];

            BindString bindString =  (BindString) field.getAnnotation(BindString.class);

            if (bindString != null) {
                try {

                    string = a.getString(bindString.value());

                    field.setAccessible(true);
                    field.set(a, string);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            i++;

        }
       
    }

    @Override
    public void bindArray() {
        String[] str = (String[]) null;

        int i = 0;
        while (i < getDeclaredFields().length) {
            Field field = getDeclaredFields()[i];

            BindArray bindString =  (BindArray) field.getAnnotation(BindArray.class);

            if (bindString != null) {
                try {

                    str = a.getResources().getStringArray(bindString.value());

                    field.setAccessible(true);
                    field.set(a, str);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            i++;

        }


        
    }
    private static int getColor(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColor(i);
        }
        return context.getResources().getColor(i);
    }

    @Override
    public void bindColor() {
        int color = 0;

        int i = 0;
        while (i < getDeclaredFields().length) {
            Field field = getDeclaredFields()[i];

            BindColor bindColor =  (BindColor) field.getAnnotation(BindColor.class);

            if (bindColor != null) {
                try {

                    color = getColor(a, bindColor.value());

                    field.setAccessible(true);
                    field.set(a, color);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            i++;

        }


       
    }
    private static final Object sLock = new Object();
    private static TypedValue sTempValue;

    private static Drawable getDrawable(Context context, int i) {
        int i2 = 0;
        if (Build.VERSION.SDK_INT >= 21) {
            if (Build.VERSION.SDK_INT >= 21) {
                return context.getDrawable(i);
            }
            if (Build.VERSION.SDK_INT >= 16) {
                return context.getResources().getDrawable(i);
            }
         synchronized (sLock) {
                if (sTempValue == null) {
                    sTempValue = new TypedValue();
                }
                context.getResources().getValue(i, sTempValue, true);
                i2 = sTempValue.resourceId;
            }
        }
        return context.getResources().getDrawable(i2);
    }




    @Override
    public void bindDrawable() {


        Drawable drawable = (Drawable) null;

        int i = 0;
        while (i < getDeclaredFields().length) {
            Field field = getDeclaredFields()[i];

            BindDrawable bindDrawable = (BindDrawable) field.getAnnotation(BindDrawable.class);

            if (bindDrawable != null) {

                drawable = getDrawable(a, bindDrawable.value());

                try {
                    field.setAccessible(true);
                    field.set(a, drawable);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            i++;

        }

       
    }

    @Override
    public void bindOnClick() {

        Method[] methodArr = getDeclaredMethods();
        int i = 0;
        while (i < methodArr.length) {
            Method method = methodArr[i];

            if (method.isAnnotationPresent(OnClick.class)) {


                b.findViewById(method.getAnnotation(OnClick.class).value()).setOnClickListener(new ButterKnifeListener(method, a));

            }
            i++;
        }   

    
    }

    @Override
    public void bindOnTextChanged() {
        Method[] methodArr = getDeclaredMethods();
        int i = 0;
        while (i < methodArr.length) {
            Method method = methodArr[i];

            if (method.isAnnotationPresent(OnTextChanged.class)) {

                View view = b.findViewById(((OnTextChanged) method.getAnnotation(OnTextChanged.class)).value());
                if (view instanceof EditText) {
                    ((EditText) view).addTextChangedListener(new ButterKnifeListener(method, a));

                }
            }
            i++;

        }

        
    }

    @Override
    public void bindOnCheckedChanged() {
        Method[] methodArr = getDeclaredMethods();
        int i = 0;
        while (i < methodArr.length) {
            Method method = methodArr[i];

            if (method.isAnnotationPresent(OnCheckedChanged.class)) {

                View view = b.findViewById(((OnCheckedChanged) method.getAnnotation(OnCheckedChanged.class)).value());
                if (view instanceof CompoundButton) {
                    ((CompoundButton) view).setOnCheckedChangeListener(new ButterKnifeListener(method, a));

                }
            }
            i++;

        }
        
    }

  
    @Override
    public void bindOnLongClick() {

        Method[] methodArr = getDeclaredMethods();
        int i = 0;
        while (i < methodArr.length) {
            Method method = methodArr[i];

            if (method.isAnnotationPresent(OnLongClick.class)) {

                b.findViewById((method.getAnnotation(OnLongClick.class)).value()).setOnLongClickListener(new ButterKnifeListener(method, a));

            }
            i++;

        } 

       
    }

    @Override
    public void bindAnimation() {

        Animation anim = (Animation) null;

        int i = 0;
        while (i < getDeclaredFields().length) {
            Field field = getDeclaredFields()[i];

            BindAnim bindAnim = (BindAnim) field.getAnnotation(BindAnim.class);

            if (bindAnim != null) {
                anim = (Animation) AnimationUtils.loadAnimation(a, bindAnim.value());

                try {
                    field.setAccessible(true);
                    field.set(a, anim);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            i++;

        }

     
    }

    @Override
    public void bindOnItemLongClick() {
        Method[] methodArr = getDeclaredMethods();
        int i = 0;
        while (i < methodArr.length) {
            Method method = methodArr[i];

            if (method.isAnnotationPresent(OnItemLongClick.class)) {

                View findViewById = b.findViewById(((OnItemLongClick)  method.getAnnotation(OnItemLongClick.class)).value());
                if (findViewById instanceof ListView) {
                    ((ListView) findViewById).setOnItemLongClickListener(new ButterKnifeListener(method, a));
                }
            } 

            i++;

        }


        
    }

    @Override
    public void bindOnItemClick() {
        Method[] methodArr = getDeclaredMethods();
        int i = 0;
        while (i < methodArr.length) {
            Method method = methodArr[i];

            if (method.isAnnotationPresent(OnItemClick.class)) {

                ((ListView) b.findViewById((method.getAnnotation(OnItemClick.class)).value())).setOnItemClickListener(new ButterKnifeListener(method, a));



            }
            i++;

        }
       
    }

    @Override
    public void bindOnItemSelected() {
        Method[] methodArr = getDeclaredMethods();
        int i = 0;
        while (i < methodArr.length) {
            Method method = methodArr[i];

            if (method.isAnnotationPresent(OnItemSelected.class)) {

                View view = b.findViewById(((OnItemSelected) method.getAnnotation(OnItemSelected.class)).value());
                if (view instanceof Spinner) {
                    ((Spinner) view).setOnItemSelectedListener(new ButterKnifeListener(method, a));

                }
            }
            i++;

        }

        
    }


	private Activity a;

	@Override

	public Method[] getDeclaredMethods() {
       
		return a.getClass().getDeclaredMethods();

         
    
}
    public Field[] getDeclaredFields() {
       
        return a.getClass().getDeclaredFields();
        
    }

    public ButterKnifeDelegateImpl(Activity v, View vv) {
        this.a = v;
        this.b = vv;

    }

    

    public void bindView() {

        View view  = (View) null;
        int i = 0;
        while (i < getDeclaredFields().length) {
            Field field = getDeclaredFields()[i];

            BindView bindView = (BindView) field.getAnnotation(BindView.class);
            if (bindView != null) {
                view = b.findViewById(bindView.value());
                try {
                    field.setAccessible(true);
                   
                    field.set(a, view);
              
              
                  }
               catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            i++;

        }
        

    }









}
