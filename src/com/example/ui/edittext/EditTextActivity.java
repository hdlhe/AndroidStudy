package com.example.ui.edittext;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ui.R;

public class EditTextActivity extends Activity {
	private EditText editText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_text);
		
		editText = (EditText) findViewById(R.id.edit_text);
		
		((Button)findViewById(R.id.enter)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(EditTextActivity.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
			}
		});
	}
}
