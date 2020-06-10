package com.xmansoft.apps.example_butterknife;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import com.xmansoft.libs.butterknife.ButterKnife;
import com.xmansoft.libs.butterknife.annotation.OnClick;


public class MainActivity extends AppCompatActivity { 

//@BindView(R.id.button1)
//private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         new ButterKnife(this)
         .getDelegate()
         .bindOnClick();
        //ButterKnife.bind(this);
        
    }
	
  
    @OnClick(R.id.button1)
    public void onButtonClick(){
         Toast.makeText(this, "OnClick", 1).show();
    /*    if (this.mInt == 0){
           this.mInt = 1; 
           
           button.setBackgroundColor(mColor);
           
        } else if(this.mInt == 1){
           this.mInt =  0;
            button.setBackgroundColor(mColor2);
            
        }*/
    }
    /*
    @OnLongClick(R.id.button1)
    public void onButtonLongClick(){
        Toast.makeText(this, "OnLongClick", 1).show();
    }
*/
    
    
} 
