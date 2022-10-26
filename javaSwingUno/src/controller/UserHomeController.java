package controller;

import java.awt.Color;
import java.awt.Dimension;
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
	static private Color WHITE = new Color(255,255,255);
	static private Color TABLE_GREEN = new Color(53, 101, 77);
	static private Font UiFont = new Font("Segoe UI", 0, 32);
	private String[] imagesList = new String[] {"default.png", "Avatar_1.png", "Avatar_2.png", "Avatar_3.png", "Avatar_4.png", "Avatar_5.png", "Avatar_6.png", "Avatar_7.png", "Avatar_8.png", "Avatar_9.png"};

	public UserHomeController(LoginModel loginModel, UserHomeView userHomeView)
	{
		this.view = userHomeView;
		this.model = loginModel;
		initView();
	}
	
	public String[] getImagesList()
	{
		return this.imagesList;
	}
	
	public void initView()
	{
		setHistory();
		
		view.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		view.setBackground(WHITE);
		
		view.getjPanel1().setBackground(TABLE_GREEN);
		
		view.getjPanel2().setBackground(WHITE);
		view.getjPanel2().setPreferredSize(new Dimension(400, 299));
		
		view.getjLabel1().setText(model.getNickName() + "'s Home");
		view.getjLabel1().setBackground(TABLE_GREEN);
		view.getjLabel1().setFont(UiFont);
		view.getjLabel1().setForeground(WHITE);
		view.getjLabel1().setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		
		String imageName = imagesList[model.getPos()];
		
		view.getNickNameLabel().setFont(UiFont);
		view.getNickNameLabel().setText("NickName:");
		
		view.getAvatarLabel().setFont(UiFont);
		view.getAvatarLabel().setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		view.getAvatarLabel().setText("Avatar:");
		
		Icon icon = new ImageIcon(".\\resources\\Avatars"+imageName);
		view.getAvatarImageLabel().setIcon(icon);
		view.getEmptyNickNameLabel().setFont(UiFont);
		view.getEmptyNickNameLabel().setText(model.getNickName());
		view.getEmptyNickNameLabel().setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		
		view.getGamesWonLabel().setFont(UiFont);
		
		view.getGamesLossLabel().setFont(UiFont);
		
		view.getGamesPlayedLabel().setFont(UiFont);
		
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
		if (model.getPos() >= getImagesList().length)
			model.setPos(0);
		view.update(model, model.getPos());
		showImage(model.getPos());
	}
	
	private void PreviousButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{
		model.setPos(model.getPos()-1);
		if (model.getPos() < 0)
			model.setPos(getImagesList().length-1);
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
	
	
	public void showImage(Integer index)
	{
		String imageName = imagesList[model.getPos()];
		Icon icon = new ImageIcon(".\\resources\\Avatars"+imageName);
		view.getAvatarImageLabel().setIcon(icon);
	}
	
	public void setHistory()
	{
		view.getGamesPlayedLabel().setText("W: " + model.getDataBase().getSpecUserData(model.getUser()).getGamesPlayed());
		view.getGamesLossLabel().setText("L: " + model.getDataBase().getSpecUserData(model.getUser()).getGamesLoss());
		view.getGamesWonLabel().setText("P: " + model.getDataBase().getSpecUserData(model.getUser()).getGamesWon());
	}

}
