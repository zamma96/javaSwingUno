package controller;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.LoginModel;
import model.User;
import view.GameStage;
import view.LoginMenuView;
import view.SignUpFormView;

public class LoginMenuController implements ActionListener
{
	User user;
	LoginMenuView loginMenuView;
	LoginModel loginModel;

	public LoginMenuController()
	{
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {}
	
	public WindowAdapter windowListener()
	{
		return new WindowAdapter()
		{
			public void windowOpened(WindowEvent evt) {formWindowOpened(evt);}
		};
	}
	
	public ActionListener LoginButtonListener()
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent evt) {LoginButtonActionPerformed(evt);}
		};
	}
	
	public ActionListener SignUpListener()
	{
		return new ActionListener()
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
				}}
		};
	}
	
    public void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) throws HeadlessException 
    {                                            
         if (loginMenuView.getTxtUser().isEmpty())
        {
            JLabel message = new JLabel("Please enter a name");
            message.setFont(new Font("Comic Sans MS", Font.BOLD, 48) );
            JOptionPane.showMessageDialog(null, message);
        }
        else
        {
            if (loginModel.getDataBase().getUser(loginMenuView.getTxtUser())!= null)
            {
            	new GameStage(loginMenuView.getDataBase().getUser(loginMenuView.getTxtUser())).setVisible(true);
            	user = loginMenuView.getDataBase().getUser(loginMenuView.getTxtUser());
            	loginModel.setUser(user);
            }
            else 
            {
                JLabel message = new JLabel("User not found, please sign up!");
                message.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message);
            }
        }
    } 
	
       
    public void formWindowOpened(java.awt.event.WindowEvent evt) 
    {                                  
        for (double i = 0.0; i <= 1.0; i+= 0.1)
        {
            String val = i + "";
            float f = Float.valueOf(val);
            loginMenuView.setOpacity(f);
            try
            {
                Thread.sleep(50);
            }
            catch(Exception e)
            {e.printStackTrace();}
        }
    }  

    public void SignUpButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException 
    {                                             
        new SignUpFormView().setVisible(true);
        loginMenuView.dispose();
    } 
}
