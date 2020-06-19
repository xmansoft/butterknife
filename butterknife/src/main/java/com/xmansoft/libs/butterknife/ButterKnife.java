package com.xmansoft.libs.butterknife;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.icu.util.Calendar;
import android.os.Build;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TimePicker;
import com.xmansoft.libs.butterknife.annotation.BindAnim;
import com.xmansoft.libs.butterknife.annotation.BindArray;
import com.xmansoft.libs.butterknife.annotation.BindBool;
import com.xmansoft.libs.butterknife.annotation.BindColor;
import com.xmansoft.libs.butterknife.annotation.BindDimen;
import com.xmansoft.libs.butterknife.annotation.BindDrawable;
import com.xmansoft.libs.butterknife.annotation.BindInt;
import com.xmansoft.libs.butterknife.annotation.BindLayout;
import com.xmansoft.libs.butterknife.annotation.BindString;
import com.xmansoft.libs.butterknife.annotation.BindView;
import com.xmansoft.libs.butterknife.annotation.OnCheckedChanged;
import com.xmansoft.libs.butterknife.annotation.OnClick;
import com.xmansoft.libs.butterknife.annotation.OnDateChanged;
import com.xmansoft.libs.butterknife.annotation.OnItemClick;
import com.xmansoft.libs.butterknife.annotation.OnItemLongClick;
import com.xmansoft.libs.butterknife.annotation.OnItemSelected;
import com.xmansoft.libs.butterknife.annotation.OnLongClick;
import com.xmansoft.libs.butterknife.annotation.OnRatingBarChange;
import com.xmansoft.libs.butterknife.annotation.OnSeekBarChange;
import com.xmansoft.libs.butterknife.annotation.OnTextChanged;
import com.xmansoft.libs.butterknife.annotation.OnTimeChanged;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import android.view.ActionMode;


public final  class ButterKnife {

    
    

    




  
 
    private static final Object sLock = new Object();
    private static TypedValue sTempValue;

    private static Drawable getDrawable(Context context, int i) {
        int i2 = 0;

        if (Build.VERSION.SDK_INT >= 21) {
            return context.getDrawable(i);
        }
        else if (Build.VERSION.SDK_INT >= 16) {
            return context.getResources().getDrawable(i);
        } 
        synchronized (sLock) {
            if (sTempValue == null) {
                sTempValue = new TypedValue();
            }
            context.getResources().getValue(i, sTempValue, true);
            i2 = sTempValue.resourceId;

        }
        return context.getResources().getDrawable(i2);
    }
    
 
    private static int getColor(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColor(i);
        }
        return context.getResources().getColor(i);
    }
 
 
public static void bind(Activity activity) {
   
   bindOnLongClick(activity,  activity);
   bindOnSeekBarChange(activity,  activity);
   bindOnDateChanged(activity,  activity);
   bindAnimation(activity,  activity.getClass().getDeclaredFields(),  activity);
   bindView(activity,  activity.getClass().getDeclaredFields(),  activity);
    bindOnRatingBarChange(activity,  activity);
    bindOnItemLongClick(activity,  activity);
   bindLayout(activity,  activity.getClass().getDeclaredFields(),  activity);
    bindOnItemClick(activity,  activity);
   bindString(activity,  activity.getClass().getDeclaredFields(),  activity);
    bindDrawable(activity,  activity.getClass().getDeclaredFields(),  activity);
    bindColor(activity,  activity.getClass().getDeclaredFields(),  activity);
    bindOnClick(activity,  activity);
    bindArray(activity,  activity.getClass().getDeclaredFields(),  activity);
    bindOnItemSelected(activity,  activity);
    bindBool(activity,  activity.getClass().getDeclaredFields(),  activity);
    bindOnTextChanged(activity,  activity);
    bindDimen(activity,  activity.getClass().getDeclaredFields(),  activity);
    bindInt(activity,  activity.getClass().getDeclaredFields(),  activity);
    bindOnCheckedChanged(activity,  activity);
    bindOnTimeChanged(activity,  activity);
   
   
   
   
}

private static void bindOnTimeChanged(Activity activity, Object p1) {
    
    
    Method[] methodArr = p1.getClass().getDeclaredMethods();
    int i = 0;
    while (i < methodArr.length) {
        Method method = methodArr[i];

        if (method.isAnnotationPresent(OnTimeChanged.class)) {

            TimePicker findViewById = activity.findViewById(((OnTimeChanged)  method.getAnnotation(OnTimeChanged.class)).value());
            if (findViewById instanceof TimePicker) {
                ((TimePicker) findViewById).setOnTimeChangedListener(new ButterKnifeListener(method, p1));
            }
        } 

        i++;

    }
    
    
    
// TODO: Implement this method
}

private static void bindOnCheckedChanged(Activity activity, Object p1) {
// TODO: Implement this method
    
    Method[] methodArr = p1.getClass().getDeclaredMethods();
    int i = 0;
    while (i < methodArr.length) {
        Method method = methodArr[i];

        if (method.isAnnotationPresent(OnCheckedChanged.class)) {

            View view = activity.findViewById(((OnCheckedChanged) method.getAnnotation(OnCheckedChanged.class)).value());
            if (view instanceof CompoundButton) {
                ((CompoundButton) view).setOnCheckedChangeListener(new ButterKnifeListener(method, p1));

            }
        }
        i++;

    }
    
    
    
}

private static void bindInt(Activity activity, Field[] declaredFields, Object p2) {
// TODO: Implement this method
    
    
    int mInt = 0;

    int i = 0;
    while (i < declaredFields.length) {
        Field field = declaredFields[i];

        BindInt bindInt =  (BindInt) field.getAnnotation(BindInt.class);

        if (bindInt != null) {
            try {


                mInt = activity.getResources().getInteger(bindInt.value());

                field.setAccessible(true);
                field.set(p2, mInt);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        i++;
    }
    
    
}

private static void bindDimen(Activity activity, Field[] declaredFields, Object p2) {
// TODO: Implement this method
    
    
    
    float dimen = 0;

    int i = 0;
    while (i < declaredFields.length) {
        Field field = declaredFields[i];

        BindDimen bindDimen =  (BindDimen) field.getAnnotation(BindDimen.class);

        if (bindDimen != null) {
            try {

                dimen = activity.getResources().getDimension(bindDimen.value());

                field.setAccessible(true);
                field.set(p2, dimen);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        i++;
    }
    
    
    
}

private static void bindOnTextChanged(Activity activity, Object p1) {
    
    Method[] methodArr = p1.getClass().getDeclaredMethods();
    int i = 0;
    while (i < methodArr.length) {
        Method method = methodArr[i];

        if (method.isAnnotationPresent(OnTextChanged.class)) {

            View view = activity.findViewById(((OnTextChanged) method.getAnnotation(OnTextChanged.class)).value());
            if (view instanceof EditText) {
                ((EditText) view).addTextChangedListener(new ButterKnifeListener(method, p1));

            }
        }
        i++;

    }
    
    
// TODO: Implement this method
}

private static void bindBool(Activity activity, Field[] declaredFields, Object p2) {
// TODO: Implement this method
    
    
    boolean bool = (Boolean) true;

    int i = 0;
    while (i < declaredFields.length) {
        Field field = declaredFields[i];

        BindBool bindBool =  (BindBool) field.getAnnotation(BindBool.class);

        if (bindBool != null) {
            try {

                bool = activity.getResources().getBoolean(bindBool.value());

                field.setAccessible(true);
                field.set(p2, bool);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        i++;
    }
    
    
    
}

private static void bindOnItemSelected(Activity activity, Object p1) {
    
    Method[] methodArr = p1.getClass().getDeclaredMethods();
    int i = 0;
    while (i < methodArr.length) {
        Method method = methodArr[i];

        if (method.isAnnotationPresent(OnItemSelected.class)) {

            View view = activity.findViewById(((OnItemSelected) method.getAnnotation(OnItemSelected.class)).value());
            if (view instanceof Spinner) {
                ((Spinner) view).setOnItemSelectedListener(new ButterKnifeListener(method, p1));

            }
        }
        i++;

    }
    
    
    
// TODO: Implement this method
}

private static void bindArray(Activity activity, Field[] declaredFields, Object p2) {
// TODO: Implement this method
    
    String[] str = (String[]) null;

    int i = 0;
    while (i < declaredFields.length) {
        Field field = declaredFields[i];

        BindArray bindString =  (BindArray) field.getAnnotation(BindArray.class);

        if (bindString != null) {
            try {

                str = activity.getResources().getStringArray(bindString.value());

                field.setAccessible(true);
                field.set(p2, str);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        i++;

    }
    
    
    
}

private static void bindOnClick(Activity activity, Object p1) {
    
    Method[] methodArr = p1.getClass().getDeclaredMethods();
    int i = 0;
    while (i < methodArr.length) {
        Method method = methodArr[i];

        if (method.isAnnotationPresent(OnClick.class)) {


            activity.findViewById(method.getAnnotation(OnClick.class).value()).setOnClickListener(new ButterKnifeListener(method, p1));

        }
        i++;
    }   
    
// TODO: Implement this method
}

private static void bindDrawable(Activity activity, Field[] declaredFields, Object p2) {
// TODO: Implement this method
    
    
    Drawable drawable = (Drawable) null;

    int i = 0;
    while (i < declaredFields.length) {
        Field field = declaredFields[i];

        BindDrawable bindDrawable = (BindDrawable) field.getAnnotation(BindDrawable.class);

        if (bindDrawable != null) {

            drawable = getDrawable(activity.getApplicationContext(), bindDrawable.value());

            try {
                field.setAccessible(true);
                field.set(p2, drawable);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        i++;

    }
    
}

private static void bindColor(Activity activity, Field[] declaredFields, Object p2) {
// TODO: Implement this method
    
    int color = 0;

    int i = 0;
    while (i < declaredFields.length) {
        Field field = declaredFields[i];

        BindColor bindColor =  (BindColor) field.getAnnotation(BindColor.class);

        if (bindColor != null) {
            try {

                color = getColor(activity.getApplicationContext(), bindColor.value());

                field.setAccessible(true);
                field.set(p2, color);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        i++;

    }
    
    
}

private static void bindString(Activity activity, Field[] declaredFields, Object p2) {
// TODO: Implement this method
    
    
    
    String string = (String) null;

    int i = 0;
    while (i < declaredFields.length) {
        Field field = declaredFields[i];

        BindString bindString =  (BindString) field.getAnnotation(BindString.class);

        if (bindString != null) {
            try {

                string = activity.getString(bindString.value());

                field.setAccessible(true);
                field.set(p2, string);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        i++;

    }
    
    
}

private static void bindOnItemClick(Activity activity, Object p1) {
    
    
    Method[] methodArr =p1.getClass().getDeclaredMethods();
    int i = 0;
    while (i < methodArr.length) {
        Method method = methodArr[i];

        if (method.isAnnotationPresent(OnItemClick.class)) {

            
            ((ListView) activity.findViewById((method.getAnnotation(OnItemClick.class)).value())).setOnItemClickListener(new ButterKnifeListener(method, p1));



        }
        i++;

    }
    
    
    
// TODO: Implement this method
}

private static void bindLayout(Activity activity, Field[] declaredFields, Object p2) {
// TODO: Implement this method
    
    View view  = (View) null;
    int i = 0;
    
    while (i < declaredFields.length) {
        Field field  = declaredFields[i];

        BindLayout bindLayout  = (BindLayout) field.getAnnotation(BindLayout.class);
        if (bindLayout != null) {
           
            LayoutInflater in = activity.getLayoutInflater(); 
            view = in.inflate(bindLayout.value(), null); 

            try {
                field.setAccessible(true);

                field.set(p2, view);


            }
            catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        i++;

    }
    
    
}

private static void bindOnItemLongClick(Activity activity, Object p1) {
    
    
    
    
    Method[] methodArr = p1.getClass().getDeclaredMethods();
    int i = 0;
    while (i < methodArr.length) {
        Method method = methodArr[i];

        if (method.isAnnotationPresent(OnItemLongClick.class)) {

            View findViewById = activity.findViewById(((OnItemLongClick)  method.getAnnotation(OnItemLongClick.class)).value());
            if (findViewById instanceof ListView) {
                ((ListView) findViewById).setOnItemLongClickListener(new ButterKnifeListener(method, p1));
            }
        } 

        i++;

    }
    
    
// TODO: Implement this method
}

private static void bindView(Activity activity, Field[] declaredFields, Object p2) {
// TODO: Implement this method
    
    View view  = (View) null;
    int i = 0;
    while (i < declaredFields.length) {
        Field field = declaredFields[i];

        BindView bindView = (BindView) field.getAnnotation(BindView.class);
        if (bindView != null) {
            view = activity.findViewById(bindView.value());
            try {
                field.setAccessible(true);

                field.set(p2, view);


            }
            catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        i++;

    }
    
    
}

private static void bindOnRatingBarChange(Activity activity, Object p1) {
    
    
    Method[] methodArr = p1.getClass().getDeclaredMethods();
    int i = 0;
    while (i < methodArr.length) {
        Method method = methodArr[i];

        if (method.isAnnotationPresent(OnRatingBarChange.class)) {

            RatingBar findViewById = activity.findViewById(((OnRatingBarChange)  method.getAnnotation(OnRatingBarChange.class)).value());
            if (findViewById instanceof RatingBar) {
                ((RatingBar) findViewById).setOnRatingBarChangeListener(new ButterKnifeListener(method, p1));
            }
        } 

        i++;

    }
    
    
    
    
// TODO: Implement this method
}

private static void bindAnimation(Activity activity, Field[] declaredFields, Object p2) {
// TODO: Implement this method
    
    Animation anim = (Animation) null;

    int i = 0;
    while (i < declaredFields.length) {
        Field field = declaredFields[i];

        BindAnim bindAnim = (BindAnim) field.getAnnotation(BindAnim.class);

        if (bindAnim != null) {
            anim = (Animation) AnimationUtils.loadAnimation(activity.getApplicationContext(), bindAnim.value());

            try {
                field.setAccessible(true);
                field.set(p2, anim);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        i++;

    }
    
    
    
}

private static void bindOnDateChanged(Activity activity, Object p1) {

    
    Method[] methodArr = p1.getClass().getDeclaredMethods();
    int i = 0;
    while (i < methodArr.length) {
        Method method = methodArr[i];

        if (method.isAnnotationPresent(OnDateChanged.class)) {
            View findViewById = activity.findViewById(((OnDateChanged)  method.getAnnotation(OnDateChanged.class)).value());
            if (findViewById instanceof DatePicker) {
                if (Build.VERSION.SDK_INT >= 26){



                    ((DatePicker) findViewById).setOnDateChangedListener(new ButterKnifeListener(method, p1));
                }     

                else if (Build.VERSION.SDK_INT <= 25){

                    Calendar calendar = Calendar.getInstance();  
                    calendar.setTimeInMillis(System.currentTimeMillis());
                    ((DatePicker) findViewById).init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new ButterKnifeListener(method,p1)); 
                       }     



            } else if (findViewById instanceof CalendarView) {

                ((CalendarView) findViewById).setOnDateChangeListener(new ButterKnifeListener(method, p1));


            }

        }






        i++;

    }
    
}

private static void bindOnLongClick(Activity activity, Object p1) {
// TODO: Implement this method
    
    Method[] methodArr =p1.getClass().getDeclaredMethods();
    int i = 0;
    while (i < methodArr.length) {
        Method method = methodArr[i];

        if (method.isAnnotationPresent(OnLongClick.class)) {

            activity.findViewById((method.getAnnotation(OnLongClick.class)).value()).setOnLongClickListener(new ButterKnifeListener(method, p1));

        }
        i++;

    } 
    
    
}


private static void bindOnSeekBarChange(Activity activity, Object obj) {

    
    Method[] methodArr = obj.getClass().getDeclaredMethods();
    int i = 0;
    while (i < methodArr.length) {
        Method method = methodArr[i];

        if (method.isAnnotationPresent(OnSeekBarChange.class)) {

            SeekBar findViewById = activity.findViewById(((OnSeekBarChange)  method.getAnnotation(OnSeekBarChange.class)).value());
            if (findViewById instanceof SeekBar) {
                ((SeekBar) findViewById).setOnSeekBarChangeListener(new ButterKnifeListener(method,  obj));
            }
        } 

        i++;
    
    
    }
}



    









    






}


