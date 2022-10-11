package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.LoginModel;
import view.GameStage;
import view.UserHomeView;

public class UserHomeController 
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
}
