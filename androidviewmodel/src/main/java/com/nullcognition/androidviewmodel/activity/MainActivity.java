package com.nullcognition.androidviewmodel.activity;

import android.os.Bundle;

import com.nullcognition.androidviewmodel.R;
import com.nullcognition.androidviewmodel.fragment.UserListFragment;

import butterknife.ButterKnife;
import eu.inloop.viewmodel.base.ViewModelBaseActivity;

public class MainActivity extends ViewModelBaseActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

		if(savedInstanceState == null){
			getSupportFragmentManager().beginTransaction().replace(R.id.root_content, new UserListFragment(), "user-list-fragment").commit();
		}
	}

	@Override
	public Class getViewModelClass(){
		return null;
	}

}
