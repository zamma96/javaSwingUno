package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Game;
import view.GameStage;

public class GameController 
{
	
	//classe che serve ad amministrare cambiamenti sulla view scatenati dalle interazioni delle IA col model nella partita
	private Game gameModel;
	private GameStage gameView;
	
	public GameController(Game game, GameStage gameStage)
	{
		this.gameModel = game;
		this.gameView = gameStage;
	}
	
	public void gameViewListener(GameStage gameView)
	{
		//TODO
		//implementare qui l'aggiunta dei listener ai button della view.
	}
	
}
