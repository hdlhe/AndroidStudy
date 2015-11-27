package com.example.ui.cursorloader;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.ui.R;

public class CursorLoaderActivity extends Activity {
	private static final String TAG = "CursorLoaderActivity";
	private static final boolean DEBUG = true;

	FragmentManager fm;
	Fragment fragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (DEBUG) {
			Log.d(TAG, "onCreate");
		}
		setContentView(R.layout.activity_cursor_loader);
		Button button = (Button) findViewById(R.id.add);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				fm.beginTransaction().add(R.id.fragment_container, fragment)
						.commit();
			}
		});

		button = (Button) findViewById(R.id.destory_loader);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				((CursorLoaderListFragment)fragment).destoryLoader();
				//getLoaderManager().destroyLoader(((CursorLoaderListFragment)fragment).getLoaderId());
			}
		});

		fm = getFragmentManager();
		fragment = new CursorLoaderListFragment();
	}
}
