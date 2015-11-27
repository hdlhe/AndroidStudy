package com.example.ui.optionsmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.ui.R;

public class OptionsMenuActivity extends Activity {
	private static final String TAG = "OptionsMenuActivity";
	private static final boolean DEBUG = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (DEBUG) {
			Log.d(TAG, "onCreate");
		}
//		requestWindowFeature(Window.FEATURE_LEFT_ICON);
		setContentView(R.layout.activity_options_menu);
//		getWindow().setFeatureDrawableResource(Window.FEATURE_LEFT_ICON,
//                R.drawable.ic_launcher);
		
		Button button = (Button) findViewById(R.id.another_activity);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent  = new Intent(OptionsMenuActivity.this, AnotherActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (DEBUG) {
			Log.d(TAG, "onCreateOptionsMenu");
		}
		super.onCreateOptionsMenu(menu);

		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.option_menu, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (DEBUG) {
			Log.d(TAG, "onOptionsItemSelected");
		}
		switch (item.getItemId()) {
		case R.id.menu_1:
			if (DEBUG) {
				Log.d(TAG, "R.id.menu_1");
			}
			return true;

		case R.id.menu_2:
			if (DEBUG) {
				Log.d(TAG, "R.id.menu_2");
			}
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
