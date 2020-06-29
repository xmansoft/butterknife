package com.xmansoft.apps.example_butterknife;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.xmansoft.apps.example_butterknife.R;
import android.app.Activity;
import com.xmansoft.libs.butterknife.ButterKnife;
import android.widget.Button;
import android.widget.TextView;
import com.xmansoft.libs.butterknife.annotation.BindView;
import android.widget.Toast;
import com.xmansoft.libs.butterknife.annotation.OnClick;

public class MyDialog 
{

    private AlertDialog dialog;
    
    @BindView(R.id.tempTextView1)
    TextView tv;

    private Context cc;
    public MyDialog(Context c){
        this.cc = c;
       dialog = new AlertDialog.Builder(c).create();
        LayoutInflater inflater = ((Activity) c).getLayoutInflater();

        View convertView = (View) inflater.inflate(R.layout.temp, null);
        dialog.setView(convertView);
        ButterKnife.bind(this, convertView);
        tv.setText("Success");
        
        
        
       
    }
    
    @OnClick(R.id.tempButton1)
    public void onButtonClick(){
        Toast.makeText(cc, tv.getText().toString(), 1).show();
        
        
    }
    
    public MyDialog show(){
        dialog.show();
        return this;
    }
    
    public void dismiss(){
        dialog.dismiss();
    }
}
