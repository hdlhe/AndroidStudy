package com.example.ui.optionsmenu;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class DogFragment extends Fragment {
	private static final String TAG = "DogFragment";
	private static final boolean DEBUG = true;
	
	private String mName;
	
	public DogFragment(String name) {
		mName = name;
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		if(DEBUG){
			Log.d(TAG, "onAttach");
		}
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
		
		if(DEBUG){
			Log.d(TAG, "onDetach");
		}
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		if(DEBUG){
			Log.d(TAG, "onCreate");
		}
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}
	
	@Override
	public void onDestroy() {
		if(DEBUG){
			Log.d(TAG, "onDestroy");
		}
		super.onDestroy();
	}
	
	@Override
	public void onStart() {
		if(DEBUG){
			Log.d(TAG, "onStart");
		}
		super.onStart();
	}
	
	@Override
	public void onPause() {
		if(DEBUG){
			Log.d(TAG, "onPause");
		}
		super.onPause();
	}
	
	@Override
	public void onStop() {
		if(DEBUG){
			Log.d(TAG, "onStop");
		}
		super.onStop();
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		
		menu.add("Dog M1").setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
        menu.add("Dog M2").setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
	}
}
