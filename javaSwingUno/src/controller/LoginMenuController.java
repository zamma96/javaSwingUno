package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.LoginModel;
import model.User;
import view.LoginMenuView;
import view.SignUpFormView;
import view.UserHomeView;

public class LoginMenuController 
{
	private LoginMenuView view;
	private LoginModel model;
	static private Color WHITE = new Color(255,255,255);
	static private Color TABLE_GREEN = new Color(53, 101, 77);
	static private Font MID_UI_FONT = new Font("Segoe UI", 0, 32);
	static private Font SMALL_UI_FONT = new Font("Segoe UI", 0, 14);
	

	public LoginMenuController(LoginModel model, LoginMenuView view)
	{
		this.view = view;
		this.model = model;
		initView();
	}
	
	public void initView()
	{
		view.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		view.setMinimumSize(new Dimension(660, 420));
		view.setResizable(false);
		
		view.getjPanel1().setBackground(WHITE);
		view.getjPanel1().setPreferredSize(new Dimension(310, 383));
		view.getjPanel2().setBackground(TABLE_GREEN);
		view.getjPanel2().setPreferredSize(new Dimension(350, 383));
		
		view.getjLabel2().setIcon(new ImageIcon(".\\resources\\LoginImg\\unoLogo.png"));
		
		view.getLoginLabel().setFont(MID_UI_FONT);
		view.getLoginLabel().setForeground(WHITE);
		view.getLoginLabel().setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		view.getLoginLabel().setText("Login");        
        
		view.getWelcomeLabel().setFont(SMALL_UI_FONT);
		view.getWelcomeLabel().setForeground(WHITE);
		view.getWelcomeLabel().setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		view.getWelcomeLabel().setText("Welcome! Let's Play!");
		
		view.getUsernameLabel().setFont(SMALL_UI_FONT);
		view.getUsernameLabel().setForeground(WHITE);
		view.getUsernameLabel().setText("Username: ");
		
		view.gettxtUser().setBackground(TABLE_GREEN);
		view.gettxtUser().setFont((view.gettxtUser().getFont().deriveFont(view.gettxtUser().getFont().getSize()+2f)));
		view.gettxtUser().setForeground(WHITE);
		view.gettxtUser().setBorder(null);
		
		view.getUsernameFieldLabel().setForeground(WHITE);
		view.getUsernameFieldLabel().setText("________________________________________________________");
		
		view.getUserNameIconLabel().setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		view.getUserNameIconLabel().setIcon(new ImageIcon(".\\resources\\LoginImg\\icons8_customer_20px_2.png"));
		
		view.getLoginButton().setFont(SMALL_UI_FONT);
		view.getLoginButton().setForeground(TABLE_GREEN);
		view.getLoginButton().setText("LOGIN");
		
		view.getSignUpLabel().setFont(SMALL_UI_FONT);
		view.getSignUpLabel().setForeground(WHITE);
		view.getSignUpLabel().setText("Don't have an account?");
		
		view.getSignUpButton().setBackground(TABLE_GREEN);
		view.getSignUpButton().setForeground(WHITE);
		view.getSignUpButton().setText("Sign Up");
		view.getSignUpButton().setBorder(null);
		
		view.getjLabel2().setIcon(new ImageIcon(".\\resources\\LoginImg\\unoLogo.png"));
		view.setVisible(true);
	}
	
	public void initController()
	{
		loginMenuListeners(view);
	}
	
	public void loginMenuListeners(LoginMenuView view) 
	{
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
    		if (model.getDataBase().getMatch(view.getTxtUser())) 
    		{
    			User user = model.getDataBase().getUserFromNickName(view.getTxtUser());
    			model.setUser(user);
    			model.setPos(model.getDataBase().getPos(user));
    			model.setNickname(user.getNickName());
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
