package com.example.ui.arrayadapter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ui.R;

public class ArrayAdapterActivity extends Activity	{
	private ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_array_adapter);
		listView = (ListView) findViewById(R.id.list_view1);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,new String[]{"1", "2", "3", "4", "5", "6", "7"});
		listView.setAdapter(adapter);
		
		listView = (ListView) findViewById(R.id.list_view2);
		adapter = new ArrayAdapter<String>(this, R.layout.list_item_array_adapter,new String[]{"A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9"});
		listView.setAdapter(adapter);
	}
}
