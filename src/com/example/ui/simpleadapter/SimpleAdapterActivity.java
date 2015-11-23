package com.example.ui.simpleadapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.example.ui.R;

public class SimpleAdapterActivity extends Activity {
	int[] images = new int[]{
			R.drawable.bomb5, R.drawable.bomb6, R.drawable.bomb7,
			R.drawable.bomb8, R.drawable.bomb9, R.drawable.bomb10,
			
	};
	private GridView gridView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_adapter);
		
		List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
		for(int i = 0; i < images.length; i ++){
			Map<String, Object> listItem = new HashMap<String, Object>();
			listItem.put("images", images[i]);
			listItem.put("text1", i % 2 == 0 ? true : false);
			listItem.put("text2", "" + i);
			listItem.put("check", i % 2 == 0 ? true : false);
			listItems.add(listItem);
		}
		
		gridView = (GridView) findViewById(R.id.grid_view);

		/*
		SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.list_item_simple_adapter, 
				new String[]{"images", "check", "text1", "text2", }, new int[]{R.id.image_view1,R.id.check_box1, R.id.text_view1, R.id.text_view2, });
		 */
		
		SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.list_item_simple_adapter, 
				new String[]{"images"}, new int[]{R.id.image_view1});
		gridView.setAdapter(adapter);
		
		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id)
			{
				System.out.println(position + "被单击了");
			}
		});
		
		gridView.setOnItemSelectedListener(new OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id)
			{
				// 显示当前被选中的图片
				System.out.println(position + "被单击了");
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent)
			{
			}
		});			
	}
}
