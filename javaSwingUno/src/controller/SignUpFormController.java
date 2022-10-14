package controller;

import java.awt.Color;
import java.awt.Font;
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
import view.LoginMenuView;
import view.SignUpFormView;
import view.UserHomeView;

public class SignUpFormController 
{
	private SignUpFormView view;
	private LoginModel model;
	
	public SignUpFormController(LoginModel loginModel, SignUpFormView view) throws IOException
	{
		this.model = loginModel;
		this.view = view;
		initView();
	}
	
	public void initView()
	{
		view.showImage(model.getPos());
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
			model.setUser(new User(nickName, model.getPos()));
			view.update(model, model.getUser());
			view.update(model, model.getPos());
			welcomeMessage();
			model.saveUserData();
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
		message.setBackground(new Color(53, 101, 77));
		message.setForeground(new Color(255, 145, 164));
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
