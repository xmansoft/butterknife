package com.xmansoft.apps.example_butterknife;
import android.app.Activity;
import android.os.Bundle;
import com.xmansoft.libs.butterknife.ButterKnife;
import com.xmansoft.libs.butterknife.annotation.BindView;
import android.widget.TextView;

public class Temp extends Activity
{
    
@BindView(R.id.tempTextView1)
private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp);
         ButterKnife.bind(this);
        try {
         tv.setText(getIntent().getStringExtra("text"));
          } catch (NullPointerException n){
              
          }
            
         
      }
}
