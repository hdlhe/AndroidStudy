package com.example.ui.chronometer;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;

import com.example.ui.R;

public class ChronometerActivity extends Activity {
	private Chronometer chronometer;
	private Button button;
	long baseTime;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chronometer);
		chronometer = (Chronometer) findViewById(R.id.chronometer1);
		
		button = (Button) findViewById(R.id.start);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				chronometer.setBase(SystemClock.elapsedRealtime());
				chronometer.start();
			}
		});
		
		button = (Button) findViewById(R.id.stop);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				baseTime = SystemClock.elapsedRealtime() - chronometer.getBase();
				chronometer.stop();
			}
		});
		
		button = (Button) findViewById(R.id.resume);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(0 == baseTime){
					baseTime = SystemClock.elapsedRealtime();
				}else{
					baseTime = SystemClock.elapsedRealtime() - baseTime;
				}
				chronometer.setBase(baseTime);
				chronometer.start();
			}
		});
	}
}
