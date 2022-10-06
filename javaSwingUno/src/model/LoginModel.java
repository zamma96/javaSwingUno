package model;

import java.io.File;
import java.io.IOException;

public class LoginModel 
{
	private int pos;
	private User user;
	private DataBase dataBase = new DataBase();
	private File dataFile = new File(".\\resources\\UserData");
	
	public LoginModel() throws IOException
	{
		dataBase.loadByFile(dataFile);
	}
	
	public void setUser(User user) 
	{
		this.user = user;
		dataBase.addUser(user);
		try 
		{
			dataBase.saveOnFile(dataFile);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public DataBase getDataBase() {return dataBase;}
	
	public int getPos()	{return pos;}
	
	public void setPos(int pos) {this.pos = pos;}
	
	public User getUser() {return user;}
		
}
