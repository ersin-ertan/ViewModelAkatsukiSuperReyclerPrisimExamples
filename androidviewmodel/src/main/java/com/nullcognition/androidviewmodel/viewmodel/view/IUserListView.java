package com.nullcognition.androidviewmodel.viewmodel.view;// Created by ersin on 05/08/15

import java.util.List;

import eu.inloop.viewmodel.IView;

public interface IUserListView extends IView{

	void showLoading(float progress);
	void hideProgress();

	void showUsers(List<String> users);
}
