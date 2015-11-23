package com.example.ui.radiobutton;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

import com.example.ui.R;

public class RadioButtonActivity extends Activity {
	private RadioGroup radioGroup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_radio_button);

		radioGroup = (RadioGroup) findViewById(R.id.radio_group);
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				String toastString = null;
				switch (checkedId) {
				case R.id.red:
					toastString ="RED";
					break;
					
				case R.id.yellow:
					toastString = "YELLOW";
					break;

				default:
					break;
				}
				Toast.makeText(RadioButtonActivity.this, toastString,
						Toast.LENGTH_SHORT).show();
			}
		});
	}
}
