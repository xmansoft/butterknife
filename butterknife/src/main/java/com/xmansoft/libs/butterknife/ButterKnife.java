package com.xmansoft.libs.butterknife;

import android.app.Activity;


public final  class ButterKnife {


	private static bfd mDelegate;

	private static Activity act;



 /* 
public ButterKnife() {
	
	mDelegate = getButterKnifeDelegate();
	
}
*/
public ButterKnife(Activity activity){
   act = activity; 
}
  
/*
	private void mBind( Activity activity) {
	
		mDelegate.bind(activity);
	}
*/

	
    public  bfd getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = bfd.a(act);
        }
        return this.mDelegate;
    }
	









}


