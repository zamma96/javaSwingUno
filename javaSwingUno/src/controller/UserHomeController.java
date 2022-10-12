package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.Game;
import model.LoginModel;
import view.GameStage;
import view.UserHomeView;

public class UserHomeController 
{
	private UserHomeView view;
	private LoginModel model;

	public UserHomeController(LoginModel loginModel, UserHomeView userHomeView)
	{
		this.view = userHomeView;
		this.model = loginModel;
		model.addObserver(view);
	}
	
	public void userHomeListeners(UserHomeView view)
	{
		view.getNextButton().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt)
			{
				NextButtonActionPerformed(evt);
			}
		});
		view.getPreviousButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt)
			{
				PreviousButtonActionPerformed(evt);
			}
		});
		view.getExitButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt)
			{
				ExitButtonActionPerformed(evt);
			}
		});
		view.getPlayButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt)
			{
				PlayButtonActionPerformed(evt);
			}
		});
	}
	
	private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{
		model.setPos(model.getPos()+1);
		if (model.getPos() >= view.getImages().length)
			model.setPos(0);
		view.update(model, model.getPos());
		view.showImage(model.getPos());
	}
	
	private void PreviousButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{
		model.setPos(model.getPos()-1);
		if (model.getPos() < 0)
			model.setPos(view.getImages().length-1);
		view.update(model, model.getPos());
		view.showImage(model.getPos());  
	}
	
	private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{	
		System.exit(0);
	}

	private void PlayButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{
		model.setPos(model.getPos());
		model.saveUserData();
		Game gameModel = new Game(model.getUser(), model.getDataBase());
		GameStage gameView = new GameStage(model.getUser());
		GameController controller = new GameController(gameModel, gameView);
		controller.gameViewListener(gameView);
		//il controller GameController inizializza il game, e da alla view
		//i metodi per i suoi actionListener, successivamente processa
		//le varie azioni del gioco catturando le interazioni dell'utente
		//con i vari Button ecc della view.
		model.observationRoutine(gameView, this.view);
		//Credo di dover mettere in mezzo la creazione del gameModel e del 
		//gameController, che al suo interno gestisce gli observer della view
		gameView.setVisible(true); 
		view.dispose();
	}
}
