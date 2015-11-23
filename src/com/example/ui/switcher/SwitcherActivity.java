package com.example.ui.switcher;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.Toast;

import com.example.ui.R;

public class SwitcherActivity extends Activity {
	private Switch swither;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_switcher);
		
		swither = (Switch) findViewById(R.id.switch1);
		swither.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				Toast.makeText(SwitcherActivity.this, "默认关"  + String.valueOf(isChecked),
						Toast.LENGTH_SHORT).show();
			}
		});
		
		swither = (Switch) findViewById(R.id.switch2);
		swither.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				Toast.makeText(SwitcherActivity.this, "默认开"  + String.valueOf(isChecked),
						Toast.LENGTH_SHORT).show();
			}
		});
	}
}
