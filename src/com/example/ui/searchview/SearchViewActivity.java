package com.example.ui.searchview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

import com.example.ui.R;

public class SearchViewActivity extends Activity {
	private static final String TAG = "SearchViewActivity";
	private static final boolean DEBUG = true;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(DEBUG){
			Log.d(TAG, "onCreate");
		}
		setContentView(R.layout.activity_search_view);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater mi = getMenuInflater();
		MenuItem item = menu.add("Search");
		item.setVisible(true);
		item.setIcon(android.R.drawable.ic_menu_search);
		item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		final SearchView sv = new SearchView(getApplicationContext());
		sv.setQueryHint("AA");
        sv.setOnQueryTextListener(new OnQueryTextListener() {
			@Override
			public boolean onQueryTextSubmit(String query) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean onQueryTextChange(String newText) {
				if(DEBUG){
					Log.d(TAG, "onQueryTextChange -> " + newText);
				}
				return false;
			}
		});
        
        item.setActionView(sv);

		return true;
	}
}
