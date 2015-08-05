package com.nullcognition.superrecyclerview;// Created by ersin on 05/08/15

import android.os.Handler;
import android.os.Looper;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.malinskiy.superrecyclerview.OnMoreListener;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import com.malinskiy.superrecyclerview.swipe.SparseItemRemoveAnimator;
import com.malinskiy.superrecyclerview.swipe.SwipeDismissRecyclerViewTouchListener;

import java.util.ArrayList;

public abstract class BaseActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, OnMoreListener, SwipeDismissRecyclerViewTouchListener.DismissCallbacks {

	private SuperRecyclerView          mRecycler;
	private StringListAdapter          mAdapter;
	private SparseItemRemoveAnimator   mSparseAnimator;
	private RecyclerView.LayoutManager mLayoutManager;
	private Handler                    mHandler;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(getLayoutId());

		ArrayList<String> list = new ArrayList<>();
		mAdapter = new StringListAdapter(list);

		mRecycler = (SuperRecyclerView) findViewById(R.id.list);
		mLayoutManager = getLayoutManager();
		mRecycler.setLayoutManager(mLayoutManager);

		boolean dismissEnabled = isSwipeToDismissEnabled();
		if(dismissEnabled){
			mRecycler.setupSwipeToDismiss(this);
			mSparseAnimator = new SparseItemRemoveAnimator();
			mRecycler.getRecyclerView().setItemAnimator(mSparseAnimator);
		}

		mHandler = new Handler(Looper.getMainLooper());

		Thread thread = new Thread(new Runnable(){
			@Override
			public void run(){
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						mRecycler.setAdapter(mAdapter);
					}
				});

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						mAdapter.addAll(new String[]{"More stuff", "More stuff", "More stuff"});
					}
				});
			}
		});
		thread.start();

		mRecycler.setRefreshListener(this);
		mRecycler.setRefreshingColorResources(android.R.color.holo_orange_light, android.R.color.holo_blue_light, android.R.color.holo_green_light, android.R.color.holo_red_light);
		mRecycler.setupMoreListener(this, 1);
	}

	protected abstract int getLayoutId();

	protected abstract boolean isSwipeToDismissEnabled();

	protected abstract RecyclerView.LayoutManager getLayoutManager();

	@Override
	public void onRefresh() {
		Toast.makeText(this, "Refresh", Toast.LENGTH_LONG).show();

		mHandler.postDelayed(new Runnable() {
			public void run() {
				mAdapter.add("New stuff");
			}
		}, 2000);
	}

	@Override
	public void onMoreAsked(int numberOfItems, int numberBeforeMore, int currentItemPos) {
		Toast.makeText(this, "More", Toast.LENGTH_LONG).show();

		mHandler.postDelayed(new Runnable() {
			public void run() {
				mAdapter.add("More asked, more served");
			}
		}, 300);
	}

	@Override
	public boolean canDismiss(int position) {
		return true;
	}

	@Override
	public void onDismiss(RecyclerView recyclerView, int[] reverseSortedPositions) {
		for (int position : reverseSortedPositions) {
			mSparseAnimator.setSkipNext(true);
			mAdapter.remove(position);
		}
	}
}
