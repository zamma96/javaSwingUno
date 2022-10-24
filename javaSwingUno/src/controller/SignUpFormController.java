package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Observer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.LoginModel;
import model.User;
import model.UserData;
import view.SignUpFormView;
import view.UserHomeView;

public class SignUpFormController 
{
	private SignUpFormView view;
	private LoginModel model;
	static private Color WHITE = new Color(255,255,255);
	static private Color TABLE_GREEN = new Color(53, 101, 77);
	static private Color SALMON_PINK = new Color(255, 145, 164);
	static private Font UiFont = new Font("Segoe UI", 0, 32);
	
	public SignUpFormController(LoginModel loginModel, SignUpFormView view) throws IOException
	{
		this.model = loginModel;
		this.view = view;
		initView();
	}
	
	public void initView()
	{
		view.getjPanel2().setBackground(WHITE);
		view.getjPanel2().setPreferredSize(new Dimension(400, 300));
		
		view.getjPanel1().setBackground(TABLE_GREEN);
		view.getjPanel1().setForeground(WHITE);
		view.getjPanel1().setPreferredSize(new Dimension(400, 100));
		
		view.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		view.setTitle("Registration Form");
		view.setBackground(WHITE);
		view.setBounds(new Rectangle(400, 400, 400, 400));
		view.setMinimumSize(new Dimension(400, 400));
		view.setResizable(false);
		
		view.showImage(model.getPos());
		
		view.getNickNameLabel().setFont(UiFont);
		view.getNickNameLabel().setText("NickName: ");
		
		view.getAvatarLabel().setFont(UiFont);
		view.getAvatarLabel().setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		view.getAvatarLabel().setText("Avatar: ");
		
		view.getUsernameFieldLabel().setBackground(WHITE);
		view.getUsernameFieldLabel().setText("______________________________________________");
		view.getUsernameFieldLabel().setRequestFocusEnabled(false);
		
		view.gettxtUser().setFont(UiFont);
		view.gettxtUser().setBorder(null);
		
		view.getPreviousButton().setText("Previous");
		view.getNextButton().setText("Next");
		view.getSignUpButton().setText("Sign Up");
		view.getSignUpButton().setBorder(null);
		
		view.getjLabel1().setBackground(TABLE_GREEN);
		view.getjLabel1().setFont(UiFont);
		view.getjLabel1().setForeground(WHITE);
		view.getjLabel1().setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		view.getjLabel1().setText("Registation Form");
		
		view.setVisible(true);
	}
	
	public void initController()
	{
		signUpFormListeners(view);
	}
	
	public void signUpFormListeners(SignUpFormView view)
	{
		view.getPreviousButton().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt)
			{
				PreviousButtonActionPerformed(evt);
			}
		});
		view.getNextButton().addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent evt)
			{
				NextButtonActionPerformed(evt);
			}
				});
		view.getSignUpButton().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt)
			{
				SignUpButtonActionPerformed(evt);
			}
		});
	}
	
	private void PreviousButtonActionPerformed(java.awt.event.ActionEvent evt)
	{
		model.setPos(model.getPos()-1);
		if(model.getPos() < 0)
			model.setPos(view.getImages().length-1);
		view.update(model, model.getPos());
		view.showImage(model.getPos()); 
	}

	private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{
		model.setPos(model.getPos()+1);
		if (model.getPos()>= view.getImages().length)
			model.setPos(0);
		view.update(model, model.getPos());
		view.showImage(model.getPos());
	}

	private void SignUpButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{
		String nickName	= view.gettxtUser().getText().toString();
		if (nickName == "")
			JOptionPane.showMessageDialog(null, "You need a Nickname!"); 
		else 
		{
			model.setUser(new User(nickName));
			model.setPos(0);
			model.getDataBase().addUserData(new UserData(model.getUser(), model.getPos(), 0, 0, 0));
			welcomeMessage();
			//riga sotto da spostare a inizio partita
			model.saveUserData();
			//riga sopra da spostare a inizio partita
			UserHomeView newView = new	UserHomeView(model);
			model.observationRoutine(newView, view);
			UserHomeController controller = new UserHomeController(model, newView);
			controller.initController();
			this.view.dispose();
		}
		
	}
	
	public void welcomeMessage()
	{
		JLabel message = new JLabel("Welcome to JUno!");
		message.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
		message.setBackground(TABLE_GREEN);
		message.setForeground(SALMON_PINK);
		JOptionPane.showMessageDialog(null, message); 
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
	
}
