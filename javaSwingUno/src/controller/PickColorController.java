package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.Card;
import model.Game;
import view.GameStage;
import view.PickColorFrame;
import view.PopUp;

public class PickColorController 
{
	private Game game;
	private GameStage gameView;
	private PopUp popUp;
	private PickColorFrame view;
	public boolean allow = false;
	
	public PickColorController(Game game, PickColorFrame view)
	{
		this.game = game;
		this.view = view;
		//Quando si crea una istanza di questa classe bisogna anche 
		//aggiungere agli observer del model la view.
		//initView();
	}
	
	public Game getGame()
	{
		return game;
	}
	
	
	public void initView()
	{
		view.getjLabel1().setText("Change color into:");
		view.getRedButton().setText("RED");
		view.getGreenButton().setText("GREEN");
		view.getBlueButton().setText("BLUE");
		view.getYellowButton().setText("YELLOW");
		view.setVisible(true);
	}
	
	public void initController(PickColorFrame view)
	{
		PickColorListeners(view);
	}
	
	public void PickColorListeners(PickColorFrame view)
	{
		view.getRedButton().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt)
			{
				redButtonActionPerformed(evt); 
				//sta nella classe PickColorFrame per ora
				//da spostare non appena modificato model e view.
			}
		});
		
		view.getBlueButton().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt)
			{
				blueButtonActionPerformed(evt);
			}
		});
		
		view.getGreenButton().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt)
			{
				greenButtonActionPerformed(evt);
			}
		});
		
		view.getYellowButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt)
			{
				yellowButtonActionPerformed(evt);
			}
		});

	}
	
	public void redButtonActionPerformed(ActionEvent evt)
	{
		//game.setWildColor(Card.Color.RED);
		showMessage("red!");
		allow = true;
		view.dispose();
		game.setDeclaredColor(Card.Color.RED);
		game.setPlayerIdName(game.getCurrentPlayer().getPlayerNickName());
		gameView.setButtonIcons();
		Icon icon = new ImageIcon(".\\resources\\UnoCards\\" + game.getTopCardImage());
		gameView.update(game, icon);
		gameView.getStockPileButton().setIcon(icon);
		game.setValidColor(Card.Color.RED);
		popUp.dispose();
	}
	
	public void greenButtonActionPerformed(ActionEvent evt)
	{
		//game.setWildColor(Card.Color.GREEN);
		showMessage("green!");
		allow = true;
		view.dispose();
		game.setDeclaredColor(Card.Color.GREEN);
		game.setPlayerIdName(game.getCurrentPlayer().getPlayerNickName());
		gameView.setButtonIcons();
		Icon icon = new ImageIcon(".\\resources\\UnoCards\\" + game.getTopCardImage());
		gameView.update(game, icon);
		gameView.getStockPileButton().setIcon(icon);
		game.setValidColor(Card.Color.GREEN);
		popUp.dispose();
	}
	
	public void blueButtonActionPerformed(ActionEvent evt)
	{
		//game.setWildColor(Card.Color.BLUE);
		showMessage("blue!");
		allow = true;
		view.dispose();
		game.setDeclaredColor(Card.Color.BLUE);
		game.setPlayerIdName(game.getCurrentPlayer().getPlayerNickName());
		gameView.setButtonIcons();
		Icon icon = new ImageIcon(".\\resources\\UnoCards\\" + game.getTopCardImage());
		gameView.update(game, icon);
		gameView.getStockPileButton().setIcon(icon);
		game.setValidColor(Card.Color.BLUE);
		popUp.dispose();
	}
	
	public void yellowButtonActionPerformed(ActionEvent evt)
	{
		//game.setWildColor(Card.Color.YELLOW);
		showMessage("yellow!");
		allow = true;
		view.dispose();
		game.setDeclaredColor(Card.Color.YELLOW);
		game.setPlayerIdName(game.getCurrentPlayer().getPlayerNickName());;
		gameView.setButtonIcons();
		Icon icon = new ImageIcon(".\\resources\\UnoCards\\"+ game.getTopCardImage());
		gameView.update(game, icon);
		gameView.getStockPileButton().setIcon(icon);
		game.setValidColor(Card.Color.YELLOW);
		popUp.dispose();
	}
	
	public void showMessage(String s)
	{
		JLabel message = new JLabel("The color changed into " + s);
		message.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
		message.setBackground(new Color(53, 101, 77));
		message.setForeground(new Color(255, 145, 164));
		JOptionPane.showMessageDialog(null, message);
	}
}
