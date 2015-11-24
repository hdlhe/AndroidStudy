package com.example.ui.simplecursoradapter;

import android.app.Activity;
import android.content.CursorLoader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Contacts.Phones;
import android.provider.ContactsContract;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.ui.R;

public class SimpleCursorAdapterActivity extends Activity {

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_cursor_adapter);

		ListView listView = (ListView) findViewById(R.id.ListView);
		/*
		Cursor c = getContentResolver().query(Phones.CONTENT_URI, null, null,
				null, null); // 获得一个ContentResolver并读取联系人列表
		startManagingCursor(c); // 托管结果
		ListAdapter adapter = new SimpleCursorAdapter(this,
				R.layout.layout_simple_cursor_adapter, c, new String[] {
						Phones.NAME}, new int[] {
						R.id.textView });// 生成适配器。
		listView.setAdapter(adapter); // 绑定List
		*/
		
		Cursor c;
		CursorLoader cursorLoader = new CursorLoader(
                this,
                Phones.CONTENT_URI,
                null,
                null,
                null,
                null
        );
		c = cursorLoader.loadInBackground();
		SimpleCursorAdapter adapter=new SimpleCursorAdapter(this, R.layout.layout_simple_cursor_adapter,c, new String[]{ContactsContract.Contacts.DISPLAY_NAME}, new int[]{R.id.textView});
		listView.setAdapter(adapter); // 绑定List
	}
}
