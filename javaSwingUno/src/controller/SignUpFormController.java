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

import model.LoginModel;
import model.User;
import view.SignUpFormView;

public class SignUpFormController 
{
	private File userData = new File(".\\resources\\UserData");
	private SignUpFormView signUpFormView;
	private LoginModel model;
	
	public SignUpFormController(LoginModel loginModel) throws IOException
	{
		model = loginModel;
	}
}
