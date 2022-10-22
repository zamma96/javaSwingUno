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
import view.PickColorFrame;
import view.PopUp;

public class PickColorController 
{
	private Game game;
	private PopUp popUp;
	private PickColorFrame view;
	private static Font BIG_GAME_FONT = new Font("Comic Sans MS", Font.BOLD, 48);
	private static Font SMALL_GAME_FONT = new Font("Comic Sans MS", Font.BOLD, 18);
	private static Color TABLE_GREEN = new Color(53, 101, 77);
	private static Color SALMON_PINK = new Color(255, 145, 164);
	
	public PickColorController(Game game, PopUp popUpView, PickColorFrame view)
	{
		this.game = game;
		this.popUp = popUpView;
		this.view = view;
		initView();
	}
	
	public Game getGame()
	{
		return game;
	}
	
	
	public void initView()
	{
		view.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		view.setResizable(false);
		
		view.getjLabel1().setText("Change color into:");
		view.getjLabel1().setFont(SMALL_GAME_FONT);
		view.getjLabel1().setForeground(SALMON_PINK);
		view.getjLabel1().setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		
		view.getjPanel1().setBackground(TABLE_GREEN);
		
		view.getRedButton().setText("RED");
		view.getRedButton().setFont(SMALL_GAME_FONT);
		view.getRedButton().setBackground(TABLE_GREEN);
		view.getRedButton().setForeground(SALMON_PINK);
		
		view.getGreenButton().setText("GREEN");
		view.getGreenButton().setFont(SMALL_GAME_FONT);
		view.getGreenButton().setBackground(TABLE_GREEN);
		view.getGreenButton().setForeground(SALMON_PINK);
		
		view.getBlueButton().setText("BLUE");
		view.getBlueButton().setFont(SMALL_GAME_FONT);
		view.getBlueButton().setBackground(TABLE_GREEN);
		view.getBlueButton().setForeground(SALMON_PINK);
		
		view.getYellowButton().setText("YELLOW");
		view.getYellowButton().setFont(SMALL_GAME_FONT);
		view.getYellowButton().setBackground(TABLE_GREEN);
		view.getYellowButton().setForeground(SALMON_PINK);
		
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
		showMessage("red!");
		game.deleteObserver(view);
		view.dispose();
		game.setDeclaredColor(Card.Color.RED);
		//forse riga sotto è ridondante, intanto tolgo, poi provo ed effettuo considerazioni
		//gameView.setButtonIcons();
		Icon icon = new ImageIcon(".\\resources\\UnoCards\\" + game.getTopCardImage());
		game.setStockPileButton(icon);
		//questo sotto in teoria è automatizzato da ObserverObservable
		//col game.setStockPileButton chiamo notifyObservers(icon) che aggiorna la view;
		//gameView.getStockPileButton().setIcon(icon);
		game.setValidColor(Card.Color.RED);
		popUp.dispose();
	}
	
	public void greenButtonActionPerformed(ActionEvent evt)
	{
		showMessage("green!");
		game.deleteObserver(view);
		view.dispose();
		game.setDeclaredColor(Card.Color.GREEN);
		//forse riga sotto è ridondante
		//perché il setButtonIcons è chiamato dopo ogni carta giocata dalla classe PopUpController
		//gameView.setButtonIcons();
		Icon icon = new ImageIcon(".\\resources\\UnoCards\\" + game.getTopCardImage());
		game.setStockPileButton(icon);
		//riga sotto da togliere 
		//gameView.getStockPileButton().setIcon(icon);
		game.setValidColor(Card.Color.GREEN);
		popUp.dispose();
	}
	
	public void blueButtonActionPerformed(ActionEvent evt)
	{
		showMessage("blue!");
		game.deleteObserver(view);
		view.dispose();
		game.setDeclaredColor(Card.Color.BLUE);
		//forse riga sotto è ridondante
		//gameView.setButtonIcons();
		Icon icon = new ImageIcon(".\\resources\\UnoCards\\" + game.getTopCardImage());
		game.setStockPileButton(icon);
		//riga sotto da togliere
		//gameView.getStockPileButton().setIcon(icon);
		game.setValidColor(Card.Color.BLUE);
		popUp.dispose();
	}
	
	public void yellowButtonActionPerformed(ActionEvent evt)
	{
		showMessage("yellow!");
		game.deleteObserver(view);
		view.dispose();
		game.setDeclaredColor(Card.Color.YELLOW);
		//forse riga sotto è ridondante
		//gameView.setButtonIcons();
		Icon icon = new ImageIcon(".\\resources\\UnoCards\\"+ game.getTopCardImage());
		game.setStockPileButton(icon);
		//riga sotto da togliere.
		//gameView.getStockPileButton().setIcon(icon);
		game.setValidColor(Card.Color.YELLOW);
		popUp.dispose();
	}
	
	public void showMessage(String s)
	{
		JLabel message = new JLabel("The color changed into " + s);
		message.setFont(BIG_GAME_FONT);
		message.setBackground(TABLE_GREEN);
		message.setForeground(SALMON_PINK);
		JOptionPane.showMessageDialog(null, message);
	}
}
