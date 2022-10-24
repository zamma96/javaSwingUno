package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Observer;

import javax.swing.Icon;
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
	private LoginMenuView view;
	private LoginModel model;
	static private Color WHITE = new Color(255,255,255);
	static private Color TABLE_GREEN = new Color(53, 101, 77);
	static private Color SALMON_PINK = new Color(255, 145, 164);
	static private Font UiFont = new Font("Segoe UI", 0, 32);
	

	public LoginMenuController(LoginModel model, LoginMenuView view)
	{
		this.view = view;
		this.model = model;
		model.addObserver(view);
		initView();
	}
	
	public void initView()
	{
		view.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		view.setMinimumSize(new Dimension(655, 386));
		view.setResizable(false);
		
		view.getjPanel1().setBackground(WHITE);
		view.getjPanel2().setBackground(TABLE_GREEN);
		
		view.getjLabel2().setIcon(new ImageIcon(".\\resources\\LoginImg\\unoLogo.png"));
		
		view.getLoginLabel().setFont(UiFont);
		view.getLoginLabel().setForeground(WHITE);
		view.getLoginLabel().setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		view.getLoginLabel().setText("Login");        
        
		view.getWelcomeLabel().setFont(UiFont);
		view.getWelcomeLabel().setForeground(WHITE);
		view.getWelcomeLabel().setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		view.getWelcomeLabel().setText("Welcome! Let's Play!");
		
		view.getUsernameLabel().setFont(UiFont);
		view.getUsernameLabel().setForeground(WHITE);
		view.getUsernameLabel().setText("Username: ");
		
		view.gettxtUser().setBackground(new Color(53,101, 77));
		view.gettxtUser().setFont((view.gettxtUser().getFont().deriveFont(view.gettxtUser().getFont().getSize()+2f)));
		view.gettxtUser().setForeground(WHITE);
		view.gettxtUser().setBorder(null);
		
		view.getUsernameFieldLabel().setForeground(WHITE);
		view.getUsernameFieldLabel().setText("________________________________________________________");
		
		view.getUserNameIconLabel().setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		view.getUserNameIconLabel().setIcon(new ImageIcon(".\\resources\\LoginImg\\icons8_customer_20px_2.png"));
		
		view.getLoginButton().setFont(UiFont);
		view.getLoginButton().setForeground(TABLE_GREEN);
		view.getLoginButton().setText("LOGIN");
		
		view.getSignUpLabel().setFont(UiFont);
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
    		if (model.getDataBase().getUser(model.getUser())!= null)
    		{
    			User user = model.getDataBase().getUser(model.getUser());
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
