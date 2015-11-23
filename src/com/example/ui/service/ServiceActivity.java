package com.example.ui.service;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.ui.R;

public class ServiceActivity extends Activity {
	private static final String TAG = "ServiceActivity";
	
	private Button mStartServiceButton, mStopStartServiceButton;
	private Button mBindServiceButton, mStopBindServiceButton;
	private Button mAIDLDogButton, mAIDLCatButton;
	private ICat mICat;
	private IDog mIDog;
	private IAnimal mIAnimal;
	private ServiceConnection mServiceConnection = new ServiceConnection() {
		@Override
		public void onServiceDisconnected(ComponentName name) {
			
			
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			mIAnimal = IAnimal.Stub.asInterface(service);
			try {
				mIDog = mIAnimal.getDog();
				mICat = mIAnimal.getCat();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service);
		
		mStartServiceButton = (Button)findViewById(R.id.start_service);
		mStopStartServiceButton = (Button)findViewById(R.id.stop_start_service);
		mBindServiceButton = (Button)findViewById(R.id.bind_service);
		mStopBindServiceButton = (Button)findViewById(R.id.stop_bind_service);
		mAIDLDogButton = (Button)findViewById(R.id.aidl_service_dog);
		mAIDLCatButton = (Button)findViewById(R.id.aidl_service_cat);
		
		
		mStartServiceButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
		
		mStopStartServiceButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
		
		mBindServiceButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
		
		mStopBindServiceButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
		
		mAIDLDogButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					Log.d(TAG, "mIDog.getName(): " + mIDog.getName());
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		});
		
		mAIDLCatButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					Log.d(TAG, "mICat.getColor(): " + mICat.getColor());
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		});
		
		Intent i = new Intent();
		i.setAction("MyAIDLService");
		bindService(i, mServiceConnection, Service.BIND_AUTO_CREATE);
	}
}
