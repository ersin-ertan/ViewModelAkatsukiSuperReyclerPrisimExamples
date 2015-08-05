package com.nullcognition.androidviewmodel.viewmodel;// Created by ersin on 05/08/15

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.nullcognition.androidviewmodel.viewmodel.view.IUserListView;

import java.util.ArrayList;
import java.util.List;

import eu.inloop.viewmodel.AbstractViewModel;


public class UserListViewModel extends AbstractViewModel<IUserListView>{

	private static final int TOTAL_USERS = 7;
	private List<String> mLoadedUsers;

	//Don't persist state variables
	private boolean mLoadingUsers;

	private float mCurrentLoadingProgress = 0;

	@Override
	public void onCreate(@Nullable Bundle arguments, @Nullable Bundle savedInstanceState){
		super.onCreate(arguments, savedInstanceState);

		//this will be only not null in case the application was killed due to low memory
		if(savedInstanceState != null){
			mLoadedUsers = savedInstanceState.getStringArrayList("userlist");
		}
	}

	@Override
	public void bindView(@NonNull IUserListView view){
		super.bindView(view);

		//downloading list of users
		if(mLoadedUsers != null){
			view.showUsers(mLoadedUsers);
		}
		else if(mLoadingUsers){
			view.showLoading(mCurrentLoadingProgress);
		}
		else{
			loadUsers();
		}
	}

	private void loadUsers(){
		mLoadingUsers = true;
		mCurrentLoadingProgress = 0;
		if(getView() != null){
			getView().showLoading(mCurrentLoadingProgress);
		}
		new AsyncTask<Void, Float, List<String>>(){

			@Override
			protected List<String> doInBackground(Void... voids){
				final List<String> list = new ArrayList<>();
				for(int i = 0; i < TOTAL_USERS; i++){
					list.add("User " + i);

					try{
						Thread.sleep(1000);
					}
					catch(InterruptedException e){
						//
					}
					publishProgress((i + 1) / (float) TOTAL_USERS);
				}

				return list;
			}

			@Override
			protected void onProgressUpdate(Float... values){
				super.onProgressUpdate(values);
				mCurrentLoadingProgress = values[0];
				if(getView() != null){
					getView().showLoading(mCurrentLoadingProgress);
				}
			}

			@Override
			protected void onPostExecute(List<String> s){
				super.onPostExecute(s);
				mLoadedUsers = s;
				mLoadingUsers = false;
				if(getView() != null){
					getView().showUsers(s);
					getView().hideProgress();
				}
			}
		}.execute();
	}

	public void deleteUser(final int position){
		if(position > mLoadedUsers.size() - 1){
			return;
		}
		mLoadedUsers.set(position, "Deleting in 5 seconds...");
		if(getView() != null){
			getView().showUsers(mLoadedUsers);
		}

		final String itemToDelete = mLoadedUsers.get(position);
		new AsyncTask<Void, Void, Void>(){

			@Override
			protected Void doInBackground(Void... voids){
				try{
					Thread.sleep(5000);
				}
				catch(InterruptedException e){
					//
				}
				mLoadedUsers.remove(itemToDelete);
				return null;
			}

			@Override
			protected void onPostExecute(Void aVoid){
				super.onPostExecute(aVoid);
				if(getView() != null){
					getView().showUsers(mLoadedUsers);
				}
			}
		}.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
	}


	@Override
	public void saveState(Bundle bundle){
		super.saveState(bundle);
		if(mLoadedUsers != null){
			bundle.putStringArrayList("userlist", new ArrayList<>(mLoadedUsers));
		}
	}

	@Override
	public void onModelRemoved(){
		super.onModelRemoved();
		//use this to cancel any planned requests
	}
}
