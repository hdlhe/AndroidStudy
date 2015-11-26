package com.example.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.ui.arrayadapter.ArrayAdapterActivity;
import com.example.ui.asyncqueryhandler.AsyncQueryHandlerActivity;
import com.example.ui.asynctask.AsyncTaskActivity;
import com.example.ui.button.ButtonActivity;
import com.example.ui.chronometer.ChronometerActivity;
import com.example.ui.edittext.EditTextActivity;
import com.example.ui.fragment.FragmentActivityTest;
import com.example.ui.include_tag.IncludeTagActivity;
import com.example.ui.optionsmenu.OptionsMenuActivity;
import com.example.ui.radiobutton.RadioButtonActivity;
import com.example.ui.service.ServiceActivity;
import com.example.ui.simpleadapter.SimpleAdapterActivity;
import com.example.ui.simplecursoradapter.SimpleCursorAdapterActivity;
import com.example.ui.switcher.SwitcherActivity;
import com.example.ui.tabwidget.TableWidgetActivity;
import com.example.ui.textview.TextViewActivity;
import com.example.ui.togglebutton.TogleButtonActivity;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";

	private ListView listView;

	Intent[] activityIntent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		activityIntent = new Intent[] {
				new Intent(MainActivity.this, TextViewActivity.class),
				new Intent(MainActivity.this, EditTextActivity.class),
				new Intent(MainActivity.this, ButtonActivity.class),
				new Intent(MainActivity.this, RadioButtonActivity.class),
				new Intent(MainActivity.this, TogleButtonActivity.class),
				new Intent(MainActivity.this, SwitcherActivity.class), 
		        null, //<item>AnalogClock</item>
		        null, //<item>DigitalClock</item>
				new Intent(MainActivity.this, ChronometerActivity.class),
				null, //<item>ImageView</item>
				new Intent(MainActivity.this, ArrayAdapterActivity.class),
				new Intent(MainActivity.this, SimpleAdapterActivity.class), 
				null, //<item>BaseAdapter</item>
				new Intent(MainActivity.this, SimpleCursorAdapterActivity.class),
				null, //<item>ExpandableListView</item>
				null, //<item>Spinner</item>
				null, //<item>Gallery</item>
				null, //<item>ViewFlipper</item>
				null, //<item>StackView</item>
		        
				null, //<item>Canvas</item>
		        
				null, //<item>Handler</item>
				new Intent(MainActivity.this, FragmentActivityTest.class),
				null, //<item >Activity</item>
				new Intent(MainActivity.this, ServiceActivity.class),
				null, //<item >Broadcast</item>
				null, //<item >Content Provider</item>
				new Intent(MainActivity.this, IncludeTagActivity.class),
				new Intent(MainActivity.this, TableWidgetActivity.class),
				new Intent(MainActivity.this, AsyncQueryHandlerActivity.class),
				new Intent(MainActivity.this, AsyncTaskActivity.class),
				new Intent(MainActivity.this, OptionsMenuActivity.class),
				};

		listView = (ListView) findViewById(R.id.list_view);
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				Log.d(TAG, "listView->onItemClick" + "(" + position + ")");

				if (position < activityIntent.length) {
					if (null != activityIntent[position]) {
						startActivity(activityIntent[position]);
					}
				}
			}

		});
	}
}
