package com.xmansoft.apps.example_butterknife;
import android.app.Activity;
import android.os.Bundle;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import android.widget.DatePicker.OnDateChangedListener;
import com.xmansoft.libs.butterknife.annotation.OnRatingBarChange;


public abstract class BaseActivity extends Activity
{
    
    
    
    public abstract void onSeekBarChange(int i);
    public abstract void onRatingBarChange(float f);
    
    
    
}
