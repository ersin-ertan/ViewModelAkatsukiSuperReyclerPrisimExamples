package com.nullcognition.androidviewmodel.fragment;// Created by ersin on 05/08/15

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nullcognition.androidviewmodel.R;
import com.nullcognition.androidviewmodel.viewmodel.SampleArgumentViewModel;

import butterknife.ButterKnife;
import eu.inloop.viewmodel.IView;
import eu.inloop.viewmodel.base.ViewModelBaseFragment;

public class SampleBundleFragment extends ViewModelBaseFragment<IView, SampleArgumentViewModel>{

	public static SampleBundleFragment newInstance(int userId){
		final Bundle bundle = new Bundle();
		bundle.putInt(SampleArgumentViewModel.ARG_INT_USER_ID, userId);

		final SampleBundleFragment fragment = new SampleBundleFragment();
		fragment.setArguments(bundle);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
		return inflater.inflate(R.layout.fragment_empty, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
		super.onViewCreated(view, savedInstanceState);
		ButterKnife.bind(this, view);
		setModelView(this);
	}

	@Override
	public Class<SampleArgumentViewModel> getViewModelClass(){
		return SampleArgumentViewModel.class;
	}
}
