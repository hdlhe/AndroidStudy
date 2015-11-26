package com.example.ui.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ui.R;

public class BookFragment extends Fragment {
	private static final String TAG = "BookFragment";
	private static final boolean DEBUG = true;
	
	private String mTag;
	private int mNo;
	
	public BookFragment(String tag, int no) {
		mTag = tag;
		mNo = no;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(DEBUG){
			Log.d(TAG, "onCreate -> " + mNo);
		}
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		if(DEBUG){
			Log.d(TAG, "onAttach -> " + mNo);
		}
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
		if(DEBUG){
			Log.d(TAG, "onDetach -> " + mNo);
		}
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		if(DEBUG){
			Log.d(TAG, "onDestroy -> " + mNo);
		}
	}
	
	@Override
	public void onPause() {
		super.onPause();
		if(DEBUG){
			Log.d(TAG, "onPause -> " + mNo);
		}
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if(DEBUG){
			Log.d(TAG, "onCreateView");
		}
		View view = inflater.inflate(R.layout.fragment_book, container, false);
		TextView textView = (TextView) view.findViewById(R.id.book_name);
		textView.setText(mTag);
		textView = (TextView) view.findViewById(R.id.book_no);
		textView.setText(String.valueOf(mNo));
		
		return view;
	}
}
