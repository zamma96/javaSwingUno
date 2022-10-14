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
	private PopUp window;
	
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
		
		view.getjButton2().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt)
			{
				jButton2ActionPerformed(evt);
			}
		});
		
		view.getjButton3().addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent evt)
			{
				jButton3ActionPerformed(evt);
			}
				});
	}
	
	//da rivedere assolutamente, ho solo tolto i main error
	private void jButton1ActionPerformed(ActionEvent evt) 
	{
		if (model.getCardIds().get(0) != null) {
			int index = 0;
			String cardId = model.getCardIds().get(0);
			window = new PopUp(cardId, model, index, model.getcardButtons(), view, view.getDeckPileButton(), view.getStockPileButton());
			window.setBounds(750, 40, 700, 800);
			window.setVisible(true);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}
	
	private void jButton2ActionPerformed(ActionEvent evt) 
	{
		if (model.getCardIds().get(1) != null) {
			int index = 1;
			String cardId = model.getCardIds().get(1);
			window = new PopUp(cardId, model, index, model.getcardButtons(), view, view.getDeckPileButton(), view.getStockPileButton());
			window.setBounds(750, 40, 700, 800);
			window.setVisible(true);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}
	
	private void jButton3ActionPerformed(ActionEvent evt)
	{
		if (model.getCardIds().get(2) != null)
		{
			int index = 2;
			String cardId = model.getCardIds().get(2);
			window = new PopUp(cardId, model, index, model.getcardButtons(), view, view.getDeckPileButton(), view.getStockPileButton());
			window.setBounds(750, 40, 700, 800);
			window.setVisible(true);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}
	
}
