package com.example.ui.fragment;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.ui.R;

public class FragmentActivityTest extends Activity {
	private static final String TAG = "FragmentActivityTest";
	private static final boolean DEBUG = true;

	private FragmentManager mFragmentManager;
	private Button mButton;
	private Fragment mFragment;
	private int mAddId;
	private ArrayList<Fragment> mBookFragments = new ArrayList<Fragment>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (DEBUG) {
			Log.d(TAG, "onCreate");
		}
		setContentView(R.layout.activity_fragment);

		mFragmentManager = getFragmentManager();

		mButton = (Button) findViewById(R.id.add_frame);
		mButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mFragment = new BookFragment("Add", mAddId);
				mFragmentManager.beginTransaction()
						.add(R.id.frame_container, mFragment).commit();
				mBookFragments.add(mFragment);
				mAddId++;
			}
		});

		mButton = (Button) findViewById(R.id.remove_frame);
		mButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mFragmentManager.beginTransaction().remove(mFragment).commit();
				if (mBookFragments.size() > 0) {
					mBookFragments.remove(mFragment);
				}
			}
		});

		mButton = (Button) findViewById(R.id.attach_frag);
		mButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mFragmentManager.beginTransaction().attach(mFragment).commit();
			}
		});

		mButton = (Button) findViewById(R.id.deattach_frag);
		mButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mFragmentManager.beginTransaction().detach(mFragment).commit();
			}
		});

		mButton = (Button) findViewById(R.id.del_next);
		mButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mBookFragments.size() > 0) {
					mFragmentManager.beginTransaction()
							.remove(mBookFragments.get(0)).commit();
					mBookFragments.remove(0);
				}

			}
		});
	}
}
