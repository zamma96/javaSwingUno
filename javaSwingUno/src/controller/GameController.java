package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import model.Game;
import view.GameStage;
import view.PopUp;

public class GameController 
{
	
	//classe che serve ad amministrare cambiamenti sulla view scatenati dalle interazioni delle IA col model nella partita
	private Game model;
	private GameStage view;
	
	public GameController(Game game, GameStage gameStage)
	{
		this.model = game;
		this.view = gameStage;
		initView();
	}
	
	public void initView()
	{
		Icon icon = new ImageIcon(".\\resources\\UnoCards\\CARD_BACK.png");
		Icon iconS = new ImageIcon(".\\resources\\UnoCards\\" + model.getTopCardImage());
		view.getStockPileButton().setIcon(iconS);
		view.getDeckPileButton().setIcon(icon);
		view.setVisible(true);
	}
	
	public void initController()
	{
		gameViewListener(view);
	}
	
	public void gameViewListener(GameStage gameView)
	{
		view.getjButton1().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt)
			{
				jButton1ActionPerformed(evt);
			}
		});
	}
	
	private void jButton1ActionPerformed(ActionEvent evt) 
	{
		if (cardIds.get(0) != null) {
			int index = 0;
			String cardId = cardIds.get(0);
			window = new PopUp(cardId, game, index, cardButtons, this, DeckPileButton, StockPileButton);
			window.setBounds(750, 40, 700, 800);
			window.setVisible(true);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}
	
}
