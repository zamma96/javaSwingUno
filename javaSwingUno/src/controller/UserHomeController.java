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
	static private Font MID_UI_FONT = new Font("Segoe UI", 0, 36);
	static private Font SMALL_UI_FONT = new Font("Segoe UI", 0, 18);
	private String[] imagesList = new String[] {"default.png", "Avatar_1.png", "Avatar_2.png", "Avatar_3.png", "Avatar_4.png", "Avatar_5.png", "Avatar_6.png", "Avatar_7.png", "Avatar_8.png", "Avatar_9.png"};
	private Integer pos;

	public UserHomeController(LoginModel loginModel, UserHomeView userHomeView)
	{
		this.view = userHomeView;
		this.model = loginModel;
		pos = model.getPos();
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
		view.setLocationRelativeTo(null);
		
		view.getjPanel1().setBackground(TABLE_GREEN);
		
		view.getjPanel2().setBackground(WHITE);
		view.getjPanel2().setPreferredSize(new Dimension(400, 299));
		
		view.getjLabel1().setText(model.getUser().getNickName() + "'s Home");
		view.getjLabel1().setBackground(TABLE_GREEN);
		view.getjLabel1().setFont(MID_UI_FONT);
		view.getjLabel1().setForeground(WHITE);
		view.getjLabel1().setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		
		view.getAvatarLabel().setFont(SMALL_UI_FONT);
		view.getAvatarLabel().setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		view.getAvatarLabel().setText("Avatar:");
		
		view.showImage();

		view.getGamesWonLabel().setFont(SMALL_UI_FONT);
		
		view.getGamesLossLabel().setFont(SMALL_UI_FONT);
		
		view.getGamesPlayedLabel().setFont(SMALL_UI_FONT);
		
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
		view.showImage();
	}
	
	private void PreviousButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{
		model.setPos(model.getPos()-1);
		if (model.getPos() < 0)
			model.setPos(getImagesList().length-1);
		view.showImage();  
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
		model.deleteObserver(this.view);
		gameModel.addObserver(gameView);
		//gameModel.observationRoutine(gameView, this.view);
		GameController controller = new GameController(gameModel, gameView);
		controller.initController();
		view.dispose();
	}
	
	
	public void setHistory()
	{
		view.getGamesPlayedLabel().setText("W: " + model.getDataBase().getSpecUserData(model.getUser()).getGamesPlayed());
		view.getGamesLossLabel().setText("L: " + model.getDataBase().getSpecUserData(model.getUser()).getGamesLoss());
		view.getGamesWonLabel().setText("P: " + model.getDataBase().getSpecUserData(model.getUser()).getGamesWon());
	}

}
