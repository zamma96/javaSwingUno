package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import model.User;

public class GameStage extends JFrame implements Observer
{
	private User user;

	public GameStage(User user) 
	{
		this.user = user;
	}

	@Override
	public void update(Observable o, Object arg) 
	{
		
	}
	
}
