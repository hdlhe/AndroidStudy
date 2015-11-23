package com.example.ui.service;

import com.example.ui.service.IAnimal.Stub;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MyAIDLService extends Service {

	private AnimalBinder mAnimalBinder;
	private DogBinder mDogBinder;
	private CatBinder mCatBinder;

	public class DogBinder extends com.example.ui.service.IDog.Stub {
		private int index;
		private String[] mNames = new String[] { "A", "B", "C" };

		@Override
		public String getName() throws RemoteException {
			index ++;
			return mNames[index % mNames.length];
		}
	}

	public MyAIDLService() {
		System.out.println("ClassLoader->MyAIDLService");
	}

	public class AnimalBinder extends Stub {

		public AnimalBinder() {
			System.out.println("ClassLoader->AnimalBinder");
		}

		@Override
		public IDog getDog() throws RemoteException {
			return mDogBinder;
		}

		@Override
		public ICat getCat() throws RemoteException {
			return mCatBinder;
		}

	}

	@Override
	public void onCreate() {
		super.onCreate();
		mAnimalBinder = new AnimalBinder();
		mDogBinder = new DogBinder();
		mCatBinder = new CatBinder();
	}

	@Override
	public IBinder onBind(Intent intent) {
		return mAnimalBinder;
	}

}
