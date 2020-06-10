package com.xmansoft.libs.butterknife;
import android.animation.Animator;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.graphics.drawable.AnimationUtilsCompat;
import android.support.graphics.drawable.AnimatorInflaterCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import com.xmansoft.libs.butterknife.annotation.BindAnim;
import com.xmansoft.libs.butterknife.annotation.BindAnimator;
import com.xmansoft.libs.butterknife.annotation.BindArray;
import com.xmansoft.libs.butterknife.annotation.BindColor;
import com.xmansoft.libs.butterknife.annotation.BindDrawable;
import com.xmansoft.libs.butterknife.annotation.BindInterpolator;
import com.xmansoft.libs.butterknife.annotation.BindLayout;
import com.xmansoft.libs.butterknife.annotation.BindString;
import com.xmansoft.libs.butterknife.annotation.BindView;
import com.xmansoft.libs.butterknife.annotation.OnCheckedChanged;
import com.xmansoft.libs.butterknife.annotation.OnClick;
import com.xmansoft.libs.butterknife.annotation.OnItemClick;
import com.xmansoft.libs.butterknife.annotation.OnItemLongClick;
import com.xmansoft.libs.butterknife.annotation.OnItemSelected;
import com.xmansoft.libs.butterknife.annotation.OnLongClick;
import com.xmansoft.libs.butterknife.annotation.OnTextChanged;
import com.xmansoft.libs.butterknife.annotation.OnTouch;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import android.app.Activity;

final class bfdl extends bfd {

    @Override
    public bfd bindAnimator() {
        Animator anim = (Animator) null;

        int i = 0;
        while (i < a().length) {
            Field field = a()[i];

            BindAnimator bindAnimator =  (BindAnimator) field.getAnnotation(BindAnimator.class);

            if (bindAnimator != null) {
                try {

                    anim = AnimatorInflaterCompat.loadAnimator(a, bindAnimator.value());

                    field.setAccessible(true);
                    field.set(a, anim);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            i++;

        }
        return this;
    }

    @Override
    public bfd bindInterpolator() {
        Interpolator anim = (Interpolator) null;

        int i = 0;
        while (i < a().length) {
            Field field = a()[i];

            BindInterpolator bindAnimator =  (BindInterpolator) field.getAnnotation(BindInterpolator.class);

            if (bindAnimator != null) {
                try {

                    anim = (Interpolator) AnimationUtilsCompat.loadInterpolator(a, bindAnimator.value());

                    field.setAccessible(true);
                    field.set(a, anim);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            i++;

        }
        return this;
    }

    @Override
    public bfd bindString() {
        String string = (String) null;

        int i = 0;
        while (i < a().length) {
            Field field = a()[i];

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
        return this;
    }

    @Override
    public bfd bindArray() {
        String[] str = (String[]) null;

        int i = 0;
        while (i < a().length) {
            Field field = a()[i];

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


        return this;
    }

    @Override
    public bfd bindColor() {
        int color = 0;

        int i = 0;
        while (i < a().length) {
            Field field = a()[i];

            BindColor bindColor =  (BindColor) field.getAnnotation(BindColor.class);

            if (bindColor != null) {
                try {

                    color = ContextCompat.getColor(a, bindColor.value());

                    field.setAccessible(true);
                    field.set(a, color);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            i++;

        }


        return this;
    }




    @Override
    public bfd bindDrawable() {


        Drawable drawable = (Drawable) null;

        int i = 0;
        while (i < a().length) {
            Field field = a()[i];

            BindDrawable bindDrawable = (BindDrawable) field.getAnnotation(BindDrawable.class);

            if (bindDrawable != null) {

                drawable = ContextCompat.getDrawable(a, bindDrawable.value());

                try {
                    field.setAccessible(true);
                    field.set(a, drawable);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            i++;

        }

        return this;
    }

    @Override
    public bfd bindOnClick() {
        Method[] methodArr = b();
        int i = 0;
        while (i < methodArr.length) {
            Method method = methodArr[i];

            if (method.isAnnotationPresent(OnClick.class)) {


                a.findViewById(method.getAnnotation(OnClick.class).value()).setOnClickListener(new bfll(method, a));

            }
            i++;
        }   

        return this;
    }

    @Override
    public bfd bindOnTextChanged() {
        Method[] methodArr = b();
        int i = 0;
        while (i < methodArr.length) {
            Method method = methodArr[i];

            if (method.isAnnotationPresent(OnTextChanged.class)) {

                View view = a.findViewById(((OnTextChanged) method.getAnnotation(OnTextChanged.class)).value());
                if (view instanceof EditText) {
                    ((EditText) view).addTextChangedListener(new bfll(method, a));

                }
            }
            i++;

        }

        return this;
    }

    @Override
    public bfd bindOnCheckedChanged() {
        Method[] methodArr = b();
        int i = 0;
        while (i < methodArr.length) {
            Method method = methodArr[i];

            if (method.isAnnotationPresent(OnCheckedChanged.class)) {

                View view = a.findViewById(((OnCheckedChanged) method.getAnnotation(OnCheckedChanged.class)).value());
                if (view instanceof CompoundButton) {
                    ((CompoundButton) view).setOnCheckedChangeListener(new bfll(method, a));

                }
            }
            i++;

        }
        return this;
    }

    @Override
    public bfd bindOnTouch() {
        Method[] methodArr = b();
        int i = 0;
        while (i < methodArr.length) {
            Method method = methodArr[i];

            if (method.isAnnotationPresent(OnTouch.class)) {


                a.findViewById(method.getAnnotation(OnTouch.class).value()).setOnTouchListener(new bfll(method, a));

            }
            i++;
        }   
        return this;
    }

    @Override
    public bfd bindOnLongClick() {

        Method[] methodArr = b();
        int i = 0;
        while (i < methodArr.length) {
            Method method = methodArr[i];

            if (method.isAnnotationPresent(OnLongClick.class)) {

                a.findViewById((method.getAnnotation(OnLongClick.class)).value()).setOnLongClickListener(new bfll(method, a));

            }
            i++;

        } 

        return this;
    }

    @Override
    public bfd bindAnimation() {

        Animation anim = (Animation) null;

        int i = 0;
        while (i < a().length) {
            Field field = a()[i];

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

        return this;
    }

    @Override
    public bfd bindOnItemLongClick() {
        Method[] methodArr = b();
        int i = 0;
        while (i < methodArr.length) {
            Method method = methodArr[i];

            if (method.isAnnotationPresent(OnItemLongClick.class)) {

                View findViewById = a.findViewById(((OnItemLongClick)  method.getAnnotation(OnItemLongClick.class)).value());
                if (findViewById instanceof ListView) {
                    ((ListView) findViewById).setOnItemLongClickListener(new bfll(method, a));
                }
            } 

            i++;

        }


        return this;
    }

    @Override
    public bfd bindOnItemClick() {
        Method[] methodArr = b();
        int i = 0;
        while (i < methodArr.length) {
            Method method = methodArr[i];

            if (method.isAnnotationPresent(OnItemClick.class)) {

                ((ListView) a.findViewById((method.getAnnotation(OnItemClick.class)).value())).setOnItemClickListener(new bfll(method, a));



            }
            i++;

        }
        return this;
    }

    @Override
    public bfd bindOnItemSelected() {
        Method[] methodArr = b();
        int i = 0;
        while (i < methodArr.length) {
            Method method = methodArr[i];

            if (method.isAnnotationPresent(OnItemSelected.class)) {

                View view = a.findViewById(((OnItemSelected) method.getAnnotation(OnItemSelected.class)).value());
                if (view instanceof Spinner) {
                    ((Spinner) view).setOnItemSelectedListener(new bfll(method, a));

                }
            }
            i++;

        }

        return this;
    }

    @Override
    public bfd bindLayout() {

        View layout = (View) null;

        int i = 0;
        while (i < a().length) {
            Field field = a()[i];

            BindLayout bindLayout = (BindLayout) field.getAnnotation(BindLayout.class);

            if (bindLayout != null) {
                try {


                    LayoutInflater iF = a.getLayoutInflater(); 
                    layout = iF.inflate(bindLayout.value(), null);

                    field.setAccessible(true);
                    field.set(a, layout);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            i++;

        }
        return this;
    }

	private Activity a;

	@Override

	public Method[] b() {
		return a.getClass().getDeclaredMethods();
	}

    public Field[] a() {
        return a.getClass().getDeclaredFields();

    }

    public bfdl(Activity act) {
        this.a = act;

    }



    public bfd bindView() {

        View view = (View) null;
        int i = 0;
        while (i < a().length) {
            Field field = a()[i];

            BindView bindView = (BindView) field.getAnnotation(BindView.class);
            if (bindView != null) {
                view = a.findViewById(bindView.value());
                try {
                    field.setAccessible(true);
                    field.set(a, view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            i++;

        }
        return this;

    }









}
