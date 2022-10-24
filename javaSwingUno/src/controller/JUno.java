package controller;

import java.io.IOException;

import model.LoginModel;

public class JUno 
{

	public static void main(String[] args) throws IOException 
	{
		LoginModel model = new LoginModel();
		view.LoginMenuView view = new view.LoginMenuView(model);
		LoginMenuController controller = new LoginMenuController(model, view);
		controller.initController();
	}
}
