package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.User;
import view.SignUpFormView;

public class SignUpFormController implements ActionListener
{
	private File userData = new File(".\\resources\\UserData");
	private SignUpFormView signUpFormView;
	private Controller controller;
	
	public SignUpFormController(SignUpFormView signUpFormView) throws IOException
	{
		this.signUpFormView = signUpFormView;
		controller = new Controller();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
	}
	
	public ActionListener PreviousButtonListener()
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent evt) {PreviousButtonActionPerformed(evt);}
		};
	}
	
	public ActionListener NextButtonListener()
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent evt) {NextButtonActionPerformed(evt);}
		};
	}
	
	public ActionListener SignUpButtonListener()
	{
		return new ActionListener()
				{
			public void actionPerformed(ActionEvent evt) {SignUpButtonActionPerformed(evt);}
				};
	}
	
	public String[] getImages()
	{
		File file = new File(getClass().getResource(".\\resources\\Avatars").getFile());
	    String[] imageList = file.list();
	    return imageList;
	}
	        
	public void showImage(int index)
	{
		String[] imagesList = getImages();
	    String imageName = imagesList[index];
	    Icon icon = new ImageIcon(".\\resources\\Avatars" + imageName);
	    signUpFormView.setAvatarImageLabel(icon);    
	}
	
	public void PreviousButtonActionPerformed(ActionEvent evt)
	{
		signUpFormView.setPos(signUpFormView.getPos()-1);
		if (signUpFormView.getPos() < 0)
			signUpFormView.setPos(getImages().length - 1);
		showImage(signUpFormView.getPos());
	}
	
	public void NextButtonActionPerformed(ActionEvent evt)
	{
		signUpFormView.setPos(signUpFormView.getPos()+1);
		if (signUpFormView.getPos() >= getImages().length)
			signUpFormView.setPos(0);
		showImage(signUpFormView.getPos());
	}
	
	public void SignUpButtonActionPerformed(ActionEvent evt)
	{
		String nickName = signUpFormView.getTxtUser();
		if (nickName == "")
			JOptionPane.showMessageDialog(null, "You need a NickName");
		else
		{
			signUpFormView.setUser(new User(nickName, signUpFormView.getPos()));
			JLabel message = new JLabel("Welcome to JUno!");
        	message.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
        	message.setBackground(new Color(53, 101, 77));
        	message.setForeground(new Color(255, 145, 164));
            JOptionPane.showMessageDialog(null, message);
		}
		controller.addUser(signUpFormView.getUser());
		  try 
	        {
				controller.saveOnFile(userData);
			} catch (IOException e) 
	        {
				e.printStackTrace();
			}
	}
}
