package controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.LoginModel;
import model.User;
import view.GameStage;
import view.LoginMenuView;
import view.SignUpFormView;
import view.UserHomeView;

public class LoginMenuController 
{
	LoginMenuView view;
	LoginModel model;

	public LoginMenuController(LoginModel model, LoginMenuView view)
	{
		this.view = view;
		this.model = model;
		model.addObserver(view);
		initView();
	}
	
	public void initView()
	{
		view.getjLabel2().setIcon(new ImageIcon(getClass().getResource(".\\resources\\LoginImg\\unoLogo.png")));
		view.setVisible(true);
	}
	
	public void initController()
	{
		loginMenuListeners(view);
	}
	
	public void loginMenuListeners(LoginMenuView view) 
	{
		view.addWindowListener(new WindowAdapter()
		{
			public void windowOpened(WindowEvent evt)
			{
				formWindowOpened(evt);
			}
		});
		view.getLoginButton().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				LoginButtonActionPerformed(evt);
			}
		});
		view.getSignUpButton().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				try 
				{
					SignUpButtonActionPerformed(evt);
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
    private void formWindowOpened(java.awt.event.WindowEvent evt) 
    {
    	for (double i = 0.0; i <= 1.0; i+= 0.1) 
    	{
    		String val = i + ""; float f =Float.valueOf(val);
    		view.setOpacity(f); 
    		try 
    		{Thread.sleep(50);}
    		catch(Exception e) 
    		{e.printStackTrace();} 
    	}
    }
    
    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) 
    { 
    	if (view.getTxtUser().isEmpty()) 
    	{ 
    		JLabel message = new JLabel("Please enter a name"); 
    		message.setFont(new Font("Comic Sans MS", Font.BOLD, 48) ); 
    		JOptionPane.showMessageDialog(null, message);
    	}
    	else 
    	{ 
    		if (model.getDataBase().getUser(view.getTxtUser())!= null)
    		{
    			User user = model.getDataBase().getUser(view.getTxtUser());
    			model.setUser(user);
    			model.setPos(model.getDataBase().getPos(user));
    			model.setNickname(user.getNickName());
    			view.update(model, model.getNickName());
    			view.update(model, model.getPos());
    			UserHomeView newView = new UserHomeView(model);
    			model.observationRoutine(newView, view);
    			UserHomeController controller = new UserHomeController(model, newView);
    			controller.initController();
    			this.view.dispose();
    		}
    		else 
    		{
    			JLabel message = new JLabel("User not found, please sign up!");
    			message.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
    			JOptionPane.showMessageDialog(null, message); 
    		}
    	}
    }
    
    private void SignUpButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException 
    {
    	SignUpFormView newView = new SignUpFormView(model);
    	model.observationRoutine(newView, view);
    	SignUpFormController controller = new SignUpFormController(model, newView);
    	controller.initController();
    	this.view.dispose(); 
    }
}
