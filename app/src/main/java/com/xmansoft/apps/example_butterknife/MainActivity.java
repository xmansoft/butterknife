package com.xmansoft.apps.example_butterknife;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.xmansoft.apps.example_butterknife.R;
import com.xmansoft.libs.butterknife.ButterKnife;
import com.xmansoft.libs.butterknife.annotation.BindView;
import android.text.Layout;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.xmansoft.libs.butterknife.annotation.BindString;
import com.xmansoft.libs.butterknife.annotation.BindLayout;
import com.xmansoft.libs.butterknife.annotation.OnTimeChanged;
import android.widget.TimePicker;
import com.xmansoft.libs.butterknife.annotation.OnDateChanged;
import android.widget.DatePicker;
import com.xmansoft.libs.butterknife.annotation.OnRatingBarChange;
import android.widget.RatingBar;
import android.widget.CompoundButton;
import com.xmansoft.libs.butterknife.annotation.OnSeekBarChange;
import android.content.Intent;

public class MainActivity extends BaseActivity {

    
  
    
    @OnSeekBarChange(R.id.seekbar1)
    public void onSeekBarChange(int i) {
        StringBuilder sb = new StringBuilder();
        String str = sb.append(i).toString().trim();
        showMessage(str);
    }
    

    
    
    /*
    @OnDateChanged(R.id.activitymainDatePicker1)
    public void onSeekBarChange(int i, int i2, int i3) {
        StringBuilder sb = new StringBuilder();

        if (i <= 9 && i2 <= 9 && i3 <= 9){
            sb.append(0);
            sb.append(i);
            sb.append("-");
            sb.append(0);
            sb.append(i2);
            sb.append("-");
            sb.append("0");
            sb.append(i3);


        }  
        else if (i <= 9 && i2 <= 9){
            sb.append(0);
            sb.append(i);
            sb.append("-");
            sb.append(0);
            sb.append(i2);
            sb.append("-");
           
            sb.append(i3);


        }  else  if (i <= 9 && i3 <= 9){
            sb.append(0);
            sb.append(i);
            sb.append("-");
            
            sb.append(i2);
            sb.append("-");
            sb.append("0");
            sb.append(i3);


        }  else  if (i2 <= 9 && i3 <= 9){
            
            sb.append(i);
            sb.append("-");
            sb.append(0);
            sb.append(i2);
            sb.append("-");
            sb.append("0");
            sb.append(i3);


        }  
        else 
            
        if (i <= 9){
            sb.append(0);
            sb.append(i);
            sb.append("-");
           
            sb.append(i2);
            sb.append("-");
            
            sb.append(i3);


        }  
      else  if (i2 <= 9){
            
            sb.append(i);
            sb.append("-");
            sb.append(0);
            sb.append(i2);
            sb.append("-");
            
            sb.append(i3);


        } else  if (i3 <= 9){
            
            sb.append(i);
            sb.append("-");
            
            sb.append(i2);
            sb.append("-");
            sb.append("0");
            sb.append(i3);


        }  
          else  {
           
               
                sb.append(i);
                sb.append("-");
                sb.append(i2);
                sb.append("-");
                sb.append(i3);


            
        }  
        showMessage(sb.toString());
    }
*/
    @OnRatingBarChange(R.id.ratingbar1)
    public void onRatingBarChange(float f) {
     StringBuilder sb = new StringBuilder();
     sb.append(f);
     tv.setText(sb.toString().trim());
    }


    /*
    @OnItemClick(R.id.listview1)
    public void onItemClick(int ii) {
      showMessage("Item " + ii + " clicked");
    }

    @OnItemLongClick(R.id.listview1)
    public void onItemLongClick(int ii) {
        showMessage("Item " + ii + " long clicked");
        
    }

    @OnItemSelected(R.id.spinner1)
    public void onItemSelected(int ii) {
        showMessage("Item " + ii + " selected");
        
    }


    @OnTextChanged(R.id.edittex1)
    public void onTextChanged(String str) {
         showMessage(str);
    }
*/

/*
@BindView(R.id.button1)
private Button button;

@BindBool(R.bool.mBool)
private boolean b;

@BindDimen(R.dimen.mDimen)
private float i;

@BindDrawable(R.drawable.abc_btn_borderless_material)
private Drawable d;

@BindInt(R.integer.mInt)
private int mInt;

@BindArray(R.array.mArray)
private String[] mArray;
*/
/* private String[] str = {
    
    "Mohamedً",
    "Hello",
    "Bonjour"
    
};
*/
/*
@BindView(R.id.listview1)
private ListView listview;
@BindView(R.id.spinner1)
private Spinner spinner;
*/

@BindView(R.id.activitymainTextView1)
private TextView tv;

@BindString(R.string.app_name)
private String strr;

@BindLayout(R.layout.toast)
private View v;

  



   
@Override
 protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        new MyDialog(this).show();
        
    //  startActivity(new Intent(getPackageName() + ".TEMP").putExtra("text", "Mohamed"));
     
/*
     LayoutInflater i = getLayoutInflater(); 
     View v = i.inflate(R.layout.*Custom view name*, (ViewGroup) findViewById(R.id.*Linear ID*) );
     t.setView(v);
     t.show(); 
  */
// tv.setText(strr);
// showMessages("Hello");
     //     tv1.setText(str[1]);
    //       tv2.setText(str[2]);
     
     
         
     //    showMessage("Hello");
     // new TimePicker(this).setOnTimeChangedListener(;
     // new DatePicker(this).setOnDateChangedListener(;
     // new RatingBar(this).setOnRatingBarChangeListener(;
   
     /*
     
      final ArrayList<String> arr = new ArrayList <>();  
      for (int a = 0; a < string.length; a++){
      arr.add(string[a]);

      }
     ArrayAdapter<String> adapter = new ArrayAdapter <String>(this, R.layout.support_simple_spinner_dropdown_item, arr); 
     listview.setAdapter(adapter); 
     spinner.setAdapter(adapter);
     */  
     
      /*
      button.setPadding((int)i,(int)i,(int)i,(int)i);
       button.setBackground(d);
       
       
       if (b){
            for (int ii = mInt; ii < mArray.length; ii++){
               showMessage(mArray[ii]);
            }
        }
        */
 }



  /*   
    @OnTimeChanged(R.id.activitymainTimePicker1)
    
    public void onTimeChanged(int i, int i2){
        StringBuilder sb = new StringBuilder();
        
        if (i <= 9 && i2 <= 9){
            sb.append(0);
            sb.append(i);
            sb.append(":");
            sb.append(0);
            sb.append(i2);
            

        } 
        else if (i <= 9){
            sb.append(0);
            sb.append(i);
            sb.append(":");
            sb.append(i2);
            
        } else if (i2 <= 9)
        {
            
           
            sb.append(i);
            sb.append(":");
            sb.append(0);
            sb.append(i2);
            
            
        }
        else {
          sb.append(i);
          sb.append(":");
          sb.append(i2);
        }  
        showMessage(sb.toString());
        
    }
   */
   
   private void showMessage(String ... str) {

      if (str != null){
       for (int i = 0; i < str.length; i++){
           
       
       Toast t = new Toast(this);
       ((TextView) v.findViewById(R.id.toastTextView1)).setText(str[i]);
       t.setDuration(1);
       t.setView(v); t.show();       
       
    }
    }
    }
	/*
    @OnClick(R.id.button1)
    public void onButtonClick(){
    showMessage("OnClick");
       }
       */
 /*
    @OnCheckedChanged(R.id.switch1)
    public void onSwitchChecked(boolean bb){
       if (bb){
         showMessage("OnChecked true");  
       } else {
          
           showMessage("OnChecked false");  
           
       }
    }
  
   */
  /*  
    @OnLongClick(R.id.button1)
    public void onButtonLongClick(){
        Toast.makeText(this, "OnLongClick", 1).show();
    }

    */
    
} 
