package com.xmansoft.libs.butterknife;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import java.lang.reflect.Method;

final class bfll implements View.OnTouchListener, View.OnClickListener, View.OnLongClickListener,  AdapterView.OnItemClickListener,AdapterView.OnItemSelectedListener,   AdapterView.OnItemLongClickListener, TextWatcher, CompoundButton.OnCheckedChangeListener {

    @Override
    public boolean onTouch(View p1, MotionEvent p2) {
        try {
            this.metho.invoke(this.objc, new Object[]{p2});
        } catch (Exception e) {
        }
        return true;
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
    bfll( Method m, Object o){
        this.metho = m;
        this.objc= o;
    }

}
