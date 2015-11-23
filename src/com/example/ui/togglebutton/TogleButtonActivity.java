package com.example.ui.togglebutton;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.ui.R;

public class TogleButtonActivity extends Activity {
	private ToggleButton toggleButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_toogle_button);
		
		toggleButton = (ToggleButton) findViewById(R.id.toggle_button);
		
		toggleButton.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				Toast.makeText(TogleButtonActivity.this, isChecked == true ? "Checked" : "UnChecked", Toast.LENGTH_SHORT).show();
			}
		});
	}
}
