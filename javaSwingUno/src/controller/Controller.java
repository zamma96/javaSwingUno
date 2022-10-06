package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import model.DataBase;
import model.User;

public class Controller 
{
	private DataBase dataBase; 
	private File userData = new File(".\\resources\\UserData");
	
	public Controller() throws IOException
	{
		dataBase = new DataBase();
	}
	
	public void addUser(User user)
	{		
		dataBase.addUser(user);
	}
	
	public List<User> getUsers()
	{
		return dataBase.getUsers();
	}
	
	public User getUser(String nickName)
	{
		return dataBase.getUser(nickName);
	}
	
	public void saveOnFile(File file) throws IOException
	{
		dataBase.saveOnFile(file);
	}
	
	public void loadByFile(File file) throws IOException
	{
		dataBase.loadByFile(file);
	}
}
