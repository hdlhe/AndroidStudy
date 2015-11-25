package com.example.ui.asynctask;

import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.ui.R;

public class AsyncTaskActivity extends Activity {
	private static final String TAG = "AsyncTaskActivity";
	private static final boolean DEBUG = true;

	private ProgressBar progressBar;
	private Button mButton;
	private MyAsyncTask mMyAsyncTask;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_async_task);
		progressBar = (ProgressBar) findViewById(R.id.progress_bar);
		mButton = (Button)findViewById(R.id.start);
		mButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(DEBUG){
					Log.d(TAG, "onClick");
				}
				try {
					mMyAsyncTask = new MyAsyncTask();
					mMyAsyncTask.execute(new URL("http://www.baidu.com"));
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public class MyAsyncTask extends AsyncTask<URL, Integer, String>{
		private static final String TAG = "MyAsyncTask";
		private static final boolean DEBUG = true;
		
		@Override
		protected void onPreExecute() {
			if(DEBUG){
				Log.d(TAG, "onPreExecute");
			}
			mButton.setClickable(false);
		}
		
		@Override
		protected String doInBackground(URL... params) {
			if(DEBUG){
				Log.d(TAG, "doInBackground -> " + params[0].toString());
			}
			for(int i = 1; i <= 10; i ++){
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				publishProgress(i);
			}
			return "Over";
		}
		
		@Override
		protected void onProgressUpdate(Integer... values) {
			if(DEBUG){
				Log.d(TAG, "onProgressUpdate -> " + values[0]);
			}
			progressBar.setProgress(values[0]);
		}
		
		@Override
		protected void onPostExecute(String result) {
			if(DEBUG){
				Log.d(TAG, "onPostExecute -> " + result);
			}
			mButton.setClickable(true);
		}
	}
}
