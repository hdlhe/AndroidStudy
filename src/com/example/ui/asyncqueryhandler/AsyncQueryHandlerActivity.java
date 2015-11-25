package com.example.ui.asyncqueryhandler;

import android.app.Activity;
import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.ui.R;

public class AsyncQueryHandlerActivity extends Activity {
	private static final String TAG = "AsyncQueryHandlerActivity";
	private static final boolean DEBUG = true;
	private ListView mListView;
	private Button mQueryButton;
	private QueryHandler mQueryHandler;
	private SimpleCursorAdapter mSimpleCursorAdapter;

	private String[] cols = new String[] { MediaStore.Audio.Artists._ID,
			MediaStore.Audio.Artists.ARTIST,
			MediaStore.Audio.Artists.NUMBER_OF_ALBUMS,
			MediaStore.Audio.Artists.NUMBER_OF_TRACKS };
	Uri uri = MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (DEBUG) {
			Log.d(TAG, "onCreate");
		}
		setContentView(R.layout.activity_async_query_handler);
		mListView = (ListView) findViewById(R.id.list_view);
		mQueryButton = (Button) findViewById(R.id.query);

		mQueryHandler = new QueryHandler(getContentResolver());
		mQueryButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mQueryHandler.startQuery(0, null, uri, cols, null, null,
						MediaStore.Audio.Artists.ARTIST_KEY);
			}
		});

		mSimpleCursorAdapter = new SimpleCursorAdapter(this,
				android.R.layout.simple_list_item_1, null,
				new String[] { MediaStore.Audio.Artists.ARTIST },
				new int[] { android.R.id.text1 });
		mListView.setAdapter(mSimpleCursorAdapter);
	}

	class QueryHandler extends AsyncQueryHandler {
		private static final String TAG = "QueryHandler";
		private static final boolean DEBUG = true;

		public QueryHandler(ContentResolver cr) {
			super(cr);
		}

		@Override
		protected void onQueryComplete(int token, Object cookie, Cursor cursor) {
			if (DEBUG) {
				Log.d(TAG, "onQueryComplete");
			}

			mSimpleCursorAdapter.changeCursor(cursor);
		}

		@Override
		protected void onDeleteComplete(int token, Object cookie, int result) {
			if (DEBUG) {
				Log.d(TAG, "onDeleteComplete");
			}
			super.onDeleteComplete(token, cookie, result);
		}

		@Override
		protected void onInsertComplete(int token, Object cookie, Uri uri) {
			if (DEBUG) {
				Log.d(TAG, "onInsertComplete");
			}
			super.onInsertComplete(token, cookie, uri);
		}

		@Override
		protected void onUpdateComplete(int token, Object cookie, int result) {
			if (DEBUG) {
				Log.d(TAG, "onUpdateComplete");
			}
			super.onUpdateComplete(token, cookie, result);
		}
	}
}
