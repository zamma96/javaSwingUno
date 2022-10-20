package controller;

import java.awt.Font;
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
		initView();
	}
	
	public void initView()
	{
		view.getjLabel1().setText(model.getNickName() + "'s Home");
		String[] imageList = getImages();
		String imageName = imageList[model.getPos()];
		view.getNickNameLabel().setFont(new java.awt.Font("Segoe UI", 0, 18));
		view.getNickNameLabel().setText("NickName:");
		view.getAvatarLabel().setFont(new java.awt.Font("Segoe UI", 0, 18));
		view.getAvatarLabel().setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		view.getAvatarLabel().setText("Avatar:");
		Icon icon = new ImageIcon(".\\resources\\Avatars"+imageName);
		view.getAvatarImageLabel().setIcon(icon);
		view.getEmptyNickNameLabel().setFont(new Font("Segoe UI", 0, 18));
		view.getEmptyNickNameLabel().setText(model.getNickName());
		view.getEmptyNickNameLabel().setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		view.getGamesWonLabel().setFont(new java.awt.Font("Segoe UI", 0, 18));
		view.getGamesWonLabel().setText("");
		view.getGamesLossLabel().setFont(new java.awt.Font("Segoe UI", 0, 18));
		view.getGamesLossLabel().setText("");
		view.getGamesPlayedLabel().setFont(new java.awt.Font("Segoe UI", 0, 18));
		view.getGamesPlayedLabel().setText("");
		view.getPreviousButton().setText("Previous");
		view.getNextButton().setText("Next");
		view.getPlayButton().setText("PLAY!");
		view.getExitButton().setText("EXIT");
		view.setVisible(true);
	}
	
	public void initController()
	{
		userHomeListeners(view);
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
		if (model.getPos() >= getImages().length)
			model.setPos(0);
		view.update(model, model.getPos());
		showImage(model.getPos());
	}
	
	private void PreviousButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{
		model.setPos(model.getPos()-1);
		if (model.getPos() < 0)
			model.setPos(getImages().length-1);
		//riga sotto credo sia inutile l'update dovrebbe essere chiamato dal notifyObservers() del metodo setPos();
		view.update(model, model.getPos());
		showImage(model.getPos());  
	}
	
	private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{	
		System.exit(0);
	}

	private void PlayButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{
		model.setPos(model.getPos());
		model.saveUserData();
		Game gameModel = new Game(model);
		GameStage gameView = new GameStage(gameModel);
		model.observationRoutine(gameView, this.view);
		GameController controller = new GameController(gameModel, gameView);
		controller.initController();
		view.dispose();
	}
	
	public String[] getImages() 
	{
		File file = new File(getClass().getResource(".\\resources\\Avatars").getFile());
		String[] imageList = file.list();
		return imageList;
	}
	
	public void showImage(Integer index)
	{
		String[] imageList = getImages();
		String imageName = imageList[model.getPos()];
		Icon icon = new ImageIcon(".\\resources\\Avatars"+imageName);
		view.getAvatarImageLabel().setIcon(icon);
	}
	
	public void setHistory()
	{
		view.getGamesPlayedLabel().setText("W: " + model.getDataBase().getGamesPlayed(model.getUser()));
		view.getGamesLossLabel().setText("W: " + model.getDataBase().getGamesLoss(model.getUser()));
		view.getGamesWonLabel().setText("W: " + model.getDataBase().getGamesWon(model.getUser()));
	}

}
