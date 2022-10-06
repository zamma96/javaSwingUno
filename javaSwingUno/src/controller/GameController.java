package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Game;
import view.GameStage;

public class GameController implements ActionListener
{
	
	//classe che serve ad amministrare cambiamenti sulla view scatenati dalle interazioni delle IA col model nella partita
	private Game game;
	private GameStage gameStage;
	
	public GameController(Game game, GameStage gameStage)
	{
		this.game = game;
		this.gameStage = gameStage;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
