package com.mingu.testkey;

import java.util.HashMap;
import java.util.Map;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	TextView keyinfo;
	Handler handler;
	
	private Runnable runnable = new Runnable() {
		@Override
   		public void run() {
      /* do what you need to do */
      /* and here comes the "trick" */
		keyinfo.setText("hey carlos runable work");
		String keyinfoStr = "Hold key: ";
			
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//				System.out.println("Key : " + entry.getKey() + " Value : "
//						+ entry.getValue());
				if(entry.getValue() == 1)
					keyinfoStr += "key"+entry.getKey()+" ";
			}
			Log.v("carlos", keyinfoStr);
			keyinfo.setText(keyinfoStr);
		handler.postDelayed(runnable, 50);
   		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		keyinfo = (TextView)findViewById(R.id.keyshow);
		keyinfo.setText("hey carlos");
		handler = new android.os.Handler();
		handler.postDelayed(runnable, 50);
		
//	Timer myTimer;
//	
//	myTimer = new Timer();
//	myTimer.schedule(new TimerTask() {
//		
//		@Override
//		public void run() {
//			// TODO Auto-generated method stub
//			try {
//				Thread.sleep(1000);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			String keyinfoStr = "Hold key: ";
//			Log.v("carlos", "timer work");
//			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
////				System.out.println("Key : " + entry.getKey() + " Value : "
////						+ entry.getValue());
//				if(entry.getValue() == 1)
//					keyinfoStr += "key"+entry.getKey()+" ";
//			}
//			Log.v("carlos", keyinfoStr);
////			keyinfo.setText(keyinfoStr);
//		}
//		}, 0,1000);
	}
	    
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
//		Log.v("carlos","keydowncode is "+keyCode);
		map.put(keyCode, 1);
		return true;
		// return super.onKeyDown(keyCode, event);
	}
	
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
//		Log.v("carlos", "keyupcode is "+keyCode);
		map.put(keyCode, 0);
		return true;
		//return super.onKeyUp(keyCode, event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
