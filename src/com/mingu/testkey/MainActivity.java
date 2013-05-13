package com.mingu.testkey;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	@SuppressLint("UseSparseArrays")
	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	TextView keyinfo;
	Handler handler;
	Timer myTimer;
	
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
	protected void onPause() {
//		myTimer.cancel();
		handler.removeCallbacks(runnable);
		super.onPause();
	};
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
//		myTimer = new Timer();
//		myTimer.schedule(new MyTimerTask(), 0,100);
		handler.postDelayed(runnable, 50);

		super.onResume();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		keyinfo = (TextView)findViewById(R.id.keyshow);
		keyinfo.setText("hey carlos");
		handler = new Handler();
//		handler.postDelayed(runnable, 50);
		
	
	
//	myTimer = new Timer();
//	myTimer.schedule(new MyTimerTask(), 0,1000);
	}
	    
	class MyTimerTask extends TimerTask {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
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
			handler.postDelayed(runnable, 50);

//			Log.v("carlos", keyinfoStr);
//			keyinfo.setText(keyinfoStr);
			}
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
