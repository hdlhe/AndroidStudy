package com.example.ui.button;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.ui.R;

public class ButtonActivity extends Activity {
	private Button button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_button);
		button = (Button) findViewById(R.id.test);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(ButtonActivity.this, "µã»÷ÁË°´Å¥" , Toast.LENGTH_SHORT).show();
			}
		});
	}
}
