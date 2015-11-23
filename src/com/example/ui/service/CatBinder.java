package com.example.ui.service;

import com.example.ui.service.ICat.Stub;

import android.os.IBinder;
import android.os.RemoteException;

public class CatBinder extends Stub {
	String[] mColors = new String[] { "Red", "Yello", "Blue" };
	private int index;
	
	@Override
	public String getColor() throws RemoteException {
		index ++;
		return mColors[index % mColors.length];
	}
}
