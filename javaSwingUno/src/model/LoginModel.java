package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

//subject must contain a list of observers that has to notify

public class LoginModel extends Observable
{
	private Integer startPos;
	private Integer pos;
	private String nickName;
	private User user;
	private DataBase dataBase;
	private File userDataFile = new File(".\\resources\\UserData");
	private File posDataFile = new File(".resources\\PosData");
	
	public LoginModel()	throws IOException
	{
		this.dataBase = new DataBase(userDataFile, posDataFile);
	}
	
	public void setUser(User user)
	{
		this.user = user;
		setChanged();
		notifyObservers(user.getNickName());
	}
	
	public DataBase getDataBase() {return dataBase;}
	
	public Integer getPos()	{return pos;}
	
	public void setPos(Integer pos) 
	{
		this.pos =(Integer) pos;
		setChanged();
		notifyObservers(pos);
	}
	
	public User getUser() {return user;}
	
	public String getNickName() {return nickName;}
	
	public void setNickname(String nickName) 
	{
		this.nickName = nickName;
		setChanged();
		notifyObservers(nickName);
	}
		
	public void saveUserData()
	{
				
		dataBase.addUser(user);
		dataBase.addPos(user, pos);
		try 
		{
			dataBase.saveOnFile(userDataFile, posDataFile);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public void observationRoutine(JFrame newView, JFrame oldView)
	{
		this.addObserver((Observer)newView);
		this.deleteObserver((Observer) oldView);
	}
	
}
