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

final class ButterKnifeDelegateImpl extends ButterKnifeDelegate {

    @Override
    public ButterKnifeDelegate bindAnimator() {
        Animator anim = (Animator) null;

        int i = 0;
        while (i < getDeclaredFields().length) {
            Field field = getDeclaredFields()[i];

            BindAnimator bindAnimator =  (BindAnimator) field.getAnnotation(BindAnimator.class);

            if (bindAnimator != null) {
                try {

                    anim = AnimatorInflaterCompat.loadAnimator(activity, bindAnimator.value());

                    field.setAccessible(true);
                    field.set(activity, anim);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            i++;

        }
        return this;
    }

    @Override
    public ButterKnifeDelegate bindInterpolator() {
        Interpolator anim = (Interpolator) null;

        int i = 0;
        while (i < getDeclaredFields().length) {
            Field field = getDeclaredFields()[i];

            BindInterpolator bindAnimator =  (BindInterpolator) field.getAnnotation(BindInterpolator.class);

            if (bindAnimator != null) {
                try {

                    anim = (Interpolator) AnimationUtilsCompat.loadInterpolator(activity, bindAnimator.value());

                    field.setAccessible(true);
                    field.set(activity, anim);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            i++;

        }
        return this;
    }

    @Override
    public ButterKnifeDelegate bindString() {
        String string = (String) null;

        int i = 0;
        while (i < getDeclaredFields().length) {
            Field field = getDeclaredFields()[i];

            BindString bindString =  (BindString) field.getAnnotation(BindString.class);

            if (bindString != null) {
                try {

                    string = activity.getString(bindString.value());

                    field.setAccessible(true);
                    field.set(activity, string);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            i++;

        }
        return this;
    }

    @Override
    public ButterKnifeDelegate bindArray() {
        String[] str = (String[]) null;

        int i = 0;
        while (i < getDeclaredFields().length) {
            Field field = getDeclaredFields()[i];

            BindArray bindString =  (BindArray) field.getAnnotation(BindArray.class);

            if (bindString != null) {
                try {

                    str = activity.getResources().getStringArray(bindString.value());

                    field.setAccessible(true);
                    field.set(activity, str);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            i++;

        }


        return this;
    }

    @Override
    public ButterKnifeDelegate bindColor() {
        int color = 0;

        int i = 0;
        while (i < getDeclaredFields().length) {
            Field field = getDeclaredFields()[i];

            BindColor bindColor =  (BindColor) field.getAnnotation(BindColor.class);

            if (bindColor != null) {
                try {

                    color = ContextCompat.getColor(activity, bindColor.value());

                    field.setAccessible(true);
                    field.set(activity, color);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            i++;

        }


        return this;
    }




    @Override
    public ButterKnifeDelegate bindDrawable() {


        Drawable drawable = (Drawable) null;

        int i = 0;
        while (i < getDeclaredFields().length) {
            Field field = getDeclaredFields()[i];

            BindDrawable bindDrawable = (BindDrawable) field.getAnnotation(BindDrawable.class);

            if (bindDrawable != null) {

                drawable = ContextCompat.getDrawable(activity, bindDrawable.value());

                try {
                    field.setAccessible(true);
                    field.set(activity, drawable);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            i++;

        }

        return this;
    }

    @Override
    public ButterKnifeDelegate bindOnClick() {
        Method[] methodArr = getDeclaredMethods();
        int i = 0;
        while (i < methodArr.length) {
            Method method = methodArr[i];

            if (method.isAnnotationPresent(OnClick.class)) {


                activity.findViewById(method.getAnnotation(OnClick.class).value()).setOnClickListener(new ButterKnifeListenerImpl(method, activity));

            }
            i++;
        }   

        return this;
    }

    @Override
    public ButterKnifeDelegate bindOnTextChanged() {
        Method[] methodArr = getDeclaredMethods();
        int i = 0;
        while (i < methodArr.length) {
            Method method = methodArr[i];

            if (method.isAnnotationPresent(OnTextChanged.class)) {

                View view = activity.findViewById(((OnTextChanged) method.getAnnotation(OnTextChanged.class)).value());
                if (view instanceof EditText) {
                    ((EditText) view).addTextChangedListener(new ButterKnifeListenerImpl(method, activity));

                }
            }
            i++;

        }

        return this;
    }

    @Override
    public ButterKnifeDelegate bindOnCheckedChanged() {
        Method[] methodArr = getDeclaredMethods();
        int i = 0;
        while (i < methodArr.length) {
            Method method = methodArr[i];

            if (method.isAnnotationPresent(OnCheckedChanged.class)) {

                View view = activity.findViewById(((OnCheckedChanged) method.getAnnotation(OnCheckedChanged.class)).value());
                if (view instanceof CompoundButton) {
                    ((CompoundButton) view).setOnCheckedChangeListener(new ButterKnifeListenerImpl(method, activity));

                }
            }
            i++;

        }
        return this;
    }

    @Override
    public ButterKnifeDelegate bindOnTouch() {
        Method[] methodArr = getDeclaredMethods();
        int i = 0;
        while (i < methodArr.length) {
            Method method = methodArr[i];

            if (method.isAnnotationPresent(OnTouch.class)) {


                activity.findViewById(method.getAnnotation(OnTouch.class).value()).setOnTouchListener(new ButterKnifeListenerImpl(method, activity));

            }
            i++;
        }   
        return this;
    }

    @Override
    public ButterKnifeDelegate bindOnLongClick() {

        Method[] methodArr = getDeclaredMethods();
        int i = 0;
        while (i < methodArr.length) {
            Method method = methodArr[i];

            if (method.isAnnotationPresent(OnLongClick.class)) {

                activity.findViewById((method.getAnnotation(OnLongClick.class)).value()).setOnLongClickListener(new ButterKnifeListenerImpl(method, activity));

            }
            i++;

        } 

        return this;
    }

    @Override
    public ButterKnifeDelegate bindAnimation() {

        Animation anim = (Animation) null;

        int i = 0;
        while (i < getDeclaredFields().length) {
            Field field = getDeclaredFields()[i];

            BindAnim bindAnim = (BindAnim) field.getAnnotation(BindAnim.class);

            if (bindAnim != null) {
                anim = (Animation) AnimationUtils.loadAnimation(activity, bindAnim.value());

                try {
                    field.setAccessible(true);
                    field.set(activity, anim);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            i++;

        }

        return this;
    }

    @Override
    public ButterKnifeDelegate bindOnItemLongClick() {
        Method[] methodArr = getDeclaredMethods();
        int i = 0;
        while (i < methodArr.length) {
            Method method = methodArr[i];

            if (method.isAnnotationPresent(OnItemLongClick.class)) {

                View findViewById = activity.findViewById(((OnItemLongClick)  method.getAnnotation(OnItemLongClick.class)).value());
                if (findViewById instanceof ListView) {
                    ((ListView) findViewById).setOnItemLongClickListener(new ButterKnifeListenerImpl(method, activity));
                }
            } 

            i++;

        }


        return this;
    }

    @Override
    public ButterKnifeDelegate bindOnItemClick() {
        Method[] methodArr = getDeclaredMethods();
        int i = 0;
        while (i < methodArr.length) {
            Method method = methodArr[i];

            if (method.isAnnotationPresent(OnItemClick.class)) {

                ((ListView) activity.findViewById((method.getAnnotation(OnItemClick.class)).value())).setOnItemClickListener(new ButterKnifeListenerImpl(method, activity));



            }
            i++;

        }
        return this;
    }

    @Override
    public ButterKnifeDelegate bindOnItemSelected() {
        Method[] methodArr = getDeclaredMethods();
        int i = 0;
        while (i < methodArr.length) {
            Method method = methodArr[i];

            if (method.isAnnotationPresent(OnItemSelected.class)) {

                View view = activity.findViewById(((OnItemSelected) method.getAnnotation(OnItemSelected.class)).value());
                if (view instanceof Spinner) {
                    ((Spinner) view).setOnItemSelectedListener(new ButterKnifeListenerImpl(method, activity));

                }
            }
            i++;

        }

        return this;
    }

    @Override
    public ButterKnifeDelegate bindLayout() {

        View layout = (View) null;

        int i = 0;
        while (i < getDeclaredFields().length) {
            Field field = getDeclaredFields()[i];

            BindLayout bindLayout = (BindLayout) field.getAnnotation(BindLayout.class);

            if (bindLayout != null) {
                try {


                    LayoutInflater iF = activity.getLayoutInflater(); 
                    layout = iF.inflate(bindLayout.value(), null);

                    field.setAccessible(true);
                    field.set(activity, layout);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            i++;

        }
        return this;
    }

	private Activity activity;

	@Override

	public Method[] getDeclaredMethods() {
		return activity.getClass().getDeclaredMethods();
	}

    public Field[] getDeclaredFields() {
        return activity.getClass().getDeclaredFields();

    }

    public ButterKnifeDelegateImpl(Activity act) {
        this.activity = act;

    }



    public ButterKnifeDelegate bindView() {

        View view = (View) null;
        int i = 0;
        while (i < getDeclaredFields().length) {
            Field field = getDeclaredFields()[i];

            BindView bindView = (BindView) field.getAnnotation(BindView.class);
            if (bindView != null) {
                view = activity.findViewById(bindView.value());
                try {
                    field.setAccessible(true);
                    field.set(activity, view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            i++;

        }
        return this;

    }









}
