package controller;

import java.io.IOException;

import model.LoginModel;
import view.LoginMenuView;

public class JUno 
{

	public static void main(String[] args) throws IOException 
	{
		LoginModel model = new LoginModel();
		LoginMenuView view = new LoginMenuView(model);
		model.addObserver(view);
		LoginMenuController controller = new LoginMenuController(model, view);
		controller.initController();
	}
}
