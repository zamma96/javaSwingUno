package controller;

import java.util.Observer;

import model.LoginModel;
import model.User;
import view.GameStage;
import view.LoginMenuView;
import view.UserHomeView;

public class LoginMenuController 
{
	User user;
	LoginMenuView view;
	LoginModel model;

	public LoginMenuController(LoginModel model, LoginMenuView view)
	{
		this.view = view;
		this.model = model;
		model.setNickname(view.getTxtUser());
		model.addObserver(view);
		//if(model.getNickName().equals(view.getTxtUser()))
	}
	
	public void setUser(User user)
	{
		this.user = user;
		model.setUser(user);
	}
	
	public User getUser()
	{
		this.user = model.getUser();
		return user;
	}
	
	public void loginObservation(UserHomeView newView, LoginMenuView oldView)
	{
		model.addObserver((Observer)newView);
		model.deleteObserver(oldView);
	}
}
