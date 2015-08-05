package com.nullcognition.superrecyclerview;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.malinskiy.superrecyclerview.OnMoreListener;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import com.malinskiy.superrecyclerview.swipe.SparseItemRemoveAnimator;
import com.malinskiy.superrecyclerview.swipe.SwipeDismissRecyclerViewTouchListener;

import java.util.ArrayList;

public class MainActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_chooser);
//
//		findViewById(R.id.button_list_sample).setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				Intent intent = new Intent(MainActivity.this, ListActivity.class);
//				startActivity(intent);
//			}
//		});
//
//		findViewById(R.id.button_grid_sample).setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				Intent intent = new Intent(MainActivity.this, GridActivity.class);
//				startActivity(intent);
//			}
//		});
//
//		findViewById(R.id.button_staggered_sample).setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				Intent intent = new Intent(MainActivity.this, StaggeredGridActivity.class);
//				startActivity(intent);
//			}
//		});
//
//		findViewById(R.id.button_swipe_sample).setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				Intent intent = new Intent(MainActivity.this, SwipeActivity.class);
//				startActivity(intent);
//			}
//		});
//
//		findViewById(R.id.button_header_sample).setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				Intent intent = new Intent(MainActivity.this, HeaderAdapterActivity.class);
//				startActivity(intent);
//			}
//		});
	}
}
