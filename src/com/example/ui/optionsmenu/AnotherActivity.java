package com.example.ui.optionsmenu;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.ui.R;

public class AnotherActivity extends Activity {
	private static final String TAG = "AnotherActivity";
	private static final boolean DEBUG = true;
	
	FragmentManager fm;
	Fragment mCat;
	Fragment mDog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(DEBUG){
			Log.d(TAG, "onCrate");
		}
		setContentView(R.layout.activity_another);
		
		fm = getFragmentManager();
		Fragment f = fm.findFragmentById(R.id.fragment_container);
		mCat = new CatFragment("Joy");
		mDog = new DogFragment("Joy");
		if(f == null){
			fm.beginTransaction().add(mCat, "Cat").commit();
			fm.beginTransaction().add(mDog, "Dot").commit();
		}
		
		Button button = (Button)findViewById(R.id.detach_cat);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				fm.beginTransaction().detach(mCat).commit();
			}
		});
		
		button = (Button)findViewById(R.id.attach_cat);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				fm.beginTransaction().attach(mCat).commit();
			}
		});
		
		button = (Button)findViewById(R.id.detach_dog);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				fm.beginTransaction().detach(mDog).commit();
			}
		});
		
		button = (Button)findViewById(R.id.attach_dog);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				fm.beginTransaction().attach(mDog).commit();
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add("A M1").setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
        menu.add("A M2").setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
		return true;
	}
}
