package com.nullcognition.superrecyclerview;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.malinskiy.superrecyclerview.OnMoreListener;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import com.malinskiy.superrecyclerview.swipe.SparseItemRemoveAnimator;
import com.malinskiy.superrecyclerview.swipe.SwipeDismissRecyclerViewTouchListener;

/**
 A placeholder fragment containing a simple view.
 */
//public class MainActivityFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, OnMoreListener, SwipeDismissRecyclerViewTouchListener.DismissCallbacks{
//
//	private SuperRecyclerView          mRecycler;
//	private StringListAdapter          mAdapter;
//	private SparseItemRemoveAnimator   mSparseAnimator;
//	private RecyclerView.LayoutManager mLayoutManager;
//	private Handler                    mHandler;
//
//	public MainActivityFragment(){
//	}
//
//	@Override
//	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
//		View rootView = inflater.inflate(R.layout.fragment_main, container, false);
//
//
//		SuperRecyclerView recycler = (SuperRecyclerView) rootView.findViewById(R.id.list);
//
//		recycler.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
//			@Override
//			public void onRefresh(){
//
//			}
//		});
//
//		// when there is only 10 items to see in the recycler, this is triggered
//		recycler.setupMoreListener(new OnMoreListener(){
//			@Override
//			public void onMoreAsked(int numberOfItems, int numberBeforeMore, int currentItemPos){
//				// Fetch more from Api or DB
//			}
//		}, 10);
//
//		recycler.setupSwipeToDismiss(new SwipeDismissListViewTouchListener.DismissCallbacks(){
//			@Override
//			public boolean canDismiss(int position){
//
//
//				return true;
//			}
//
//			@Override
//			public void onDismiss(RecyclerView recyclerView, int[] reverseSortedPositions){
//				// Do your stuff like call an Api or update your db
//			}
//		});
//
//
//		return rootView;
//
//
//	}
//	@Override
//	public boolean canDismiss(final int i){
//		return false;
//	}
//	@Override
//	public void onDismiss(final RecyclerView recyclerView, final int[] ints){
//
//	}
//	@Override
//	public void onMoreAsked(final int i, final int i1, final int i2){
//
//	}
//	@Override
//	public void onRefresh(){
//
//	}
//}
