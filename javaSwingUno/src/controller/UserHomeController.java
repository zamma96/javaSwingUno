package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.LoginModel;
import view.GameStage;
import view.UserHomeView;

public class UserHomeController implements ActionListener
{
	private UserHomeView userHomeView;
	private LoginModel loginModel;

	public UserHomeController(UserHomeView userHomeView, LoginModel loginModel)
	{
		this.userHomeView = userHomeView;
		this.loginModel = loginModel;
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
        Icon icon = new ImageIcon(".\\resources\\Avatar" + imageName);
        userHomeView.setAvatarImageLabel(icon);
            
    }
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub	
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
	
	public ActionListener ExitButtonListener()
	{
		return new ActionListener()
				{
			public void actionPerformed(ActionEvent evt) {ExitButtonActionPerformed(evt);}
				};
	}
	
	public ActionListener PlayButtonListener()
	{
		return new ActionListener()
				{
			public void actionPerformed(ActionEvent evt) {PlayButtonActionPerformed(evt);}
				};
	}
	
	public void PreviousButtonActionPerformed(ActionEvent e)
	{
		loginModel.setPos(loginModel.getPos() -1);
		if(loginModel.getPos() < 0)
			loginModel.setPos(getImages().length-1);
		showImage(loginModel.getPos());
	}
	
	public void NextButtonActionPerformed(ActionEvent e)
	{
		loginModel.setPos(loginModel.getPos() +1);
		if (loginModel.getPos() >= getImages().length)
			loginModel.setPos(0);
		showImage(loginModel.getPos());
	}
	
	public void ExitButtonActionPerformed(ActionEvent e)
	{
		System.exit(0);
	}
	
	public void PlayButtonActionPerformed(ActionEvent e)
	{
		new GameStage(loginModel.getUser()).setVisible(true);
	}
	
}
