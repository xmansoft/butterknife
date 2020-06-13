package com.xmansoft.libs.butterknife;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TimePicker;
import java.lang.reflect.Method;


final class ButterKnifeListener implements SeekBar.OnSeekBarChangeListener,      CalendarView.OnDateChangeListener, RatingBar.OnRatingBarChangeListener,DatePicker.OnDateChangedListener   ,TimePicker.OnTimeChangedListener, View.OnClickListener, View.OnLongClickListener,  AdapterView.OnItemClickListener,AdapterView.OnItemSelectedListener,   AdapterView.OnItemLongClickListener, TextWatcher, CompoundButton.OnCheckedChangeListener
{

    @Override
    public void onProgressChanged(SeekBar p1, int p2, boolean p3) {
        try {
            this.metho.invoke(objc, new Object[]{new Integer(p2)});
        } catch (Exception e) {
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar p1) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar p1) {

    }
    

    @Override
    public void onSelectedDayChange(CalendarView p1, int p2, int p3, int p4) {
        try {
            this.metho.invoke(objc, new Object[]{new Integer(p2), new Integer(p3), new Integer(p4)});
        } catch (Exception e) {
        }
    }
    

    @Override
    public void onRatingChanged(RatingBar p1, float p2, boolean p3) {
        try {
            this.metho.invoke(objc, new Object[]{new Float(p2)});
        } catch (Exception e) {
        }
    }
    

    @Override
    public void onDateChanged(DatePicker p1, int p2, int p3, int p4) {
        try {
            this.metho.invoke(objc, new Object[]{new Integer(p2), new Integer(p3), new Integer(p4)});
        } catch (Exception e) {
        }
    }
    

    @Override
    public void onTimeChanged(TimePicker p1, int p2, int p3) {
        try {
            this.metho.invoke(objc, new Object[]{new Integer(p2), new Integer(p3)});
        } catch (Exception e) {
        }
    }





    

    @Override
    public void onClick(View view) {

        try {
            this.metho.invoke(objc, new Object[0]);
        } catch (Exception e) {
        }

    }


    @Override
    public void onCheckedChanged(CompoundButton p1, boolean p2) {
        try {
            this.metho.invoke(this.objc, new Object[]{new Boolean(p2)});
        } catch (Exception e) {
        }


    }


    @Override
    public void beforeTextChanged(CharSequence p1, int p2, int p3, int p4) {

    }

    @Override
    public void onTextChanged(CharSequence p1, int p2, int p3, int p4) {
        String str = p1.toString();

        try {
            this.metho.invoke(this.objc, new Object[]{new String(str)});
        } catch (Exception e) {
        }

    }

    @Override
    public void afterTextChanged(Editable p1) {



    }


    @Override

    public boolean onItemLongClick(AdapterView<?> p1, View p2, int p3, long p4) {


        try {
            this.metho.invoke(this.objc, new Object[]{new Integer(p3)});
        } catch (Exception e) {
        }
        return true;

    }


    @Override

    public void onItemSelected(AdapterView<?> p1, View p2, int p3, long p4) {

        try {
            this.metho.invoke(this.objc, new Object[]{new Integer(p3)});
        } catch (Exception e) {
        }


    }

    @Override

    public void onNothingSelected(AdapterView<?> p1) {
    }


    @Override

    public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4) {

        try {
            this.metho.invoke(this.objc, new Object[]{new Integer(p3)});
        } catch (Exception e) {
        }

    }





    @Override
    public boolean onLongClick(View p1) {
        try {
            this.metho.invoke(this.objc, new Object[0]);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    private Method metho;
    private Object objc;
    ButterKnifeListener(Method m, Object o) {
        this.metho = m;
        this.objc = o;
    }

}
