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
	private File posDataFile = new File(".\\resources\\PosData");
	private File gamesWonDataFile = new File(".\\resources\\GamesWonData");
	private File gamesLossDataFile = new File(".\\resources\\GamesLossData");
	private File gamesPlayedDataFile = new File(".\\resources\\GamesPlayedData");
	private GamesPlayed games;
	
	public LoginModel()	throws IOException
	{
		this.dataBase = new DataBase(userDataFile, posDataFile, gamesWonDataFile, gamesLossDataFile, gamesPlayedDataFile);
	}
	
	/**
	 * 
	 * @param user setted as this instance's user;
	 * then notifies all the observers;
	 */
	public void setUser(User user)
	{
		this.user = user;
		setChanged();
		notifyObservers(user.getNickName());
	}

	/**
	 * 
	 * @return this instance's user;
	 */
	public User getUser() {return user;}
	
	/**
	 * 
	 * @return this instance's dataBase;
	 */
	public DataBase getDataBase() {return dataBase;}
	
	/**
	 * return this instance's pos;
	 * @return
	 */
	public Integer getPos()	{return pos;}
	
	/**
	 * 
	 * @param pos setted as this instance's pos;
	 * then notifies all the observers;
	 */
	public void setPos(Integer pos) 
	{
		this.pos =(Integer) pos;
		setChanged();
		notifyObservers(pos);
	}
	
	/**
	 * 
	 * @return this instance's user's nickName;
	 */
	public String getNickName() {return nickName;}
	
	/**
	 * 
	 * @param nickName setted as this instance's nickName;
	 * then notifies all the observers;
	 */
	public void setNickname(String nickName) 
	{
		this.nickName = nickName;
		setChanged();
		notifyObservers(nickName);
	}
	
	public void setGamesInfo()
	{
		games.addGameWin(user);
		games.addGamePlayed(user);
	}
	
	
	/**
	 * method that saves user info (User user, Integer pos) on file
	 */
	public void saveUserData()
	{
				
		dataBase.addUser(user);
		dataBase.addPos(user, pos);
		try 
		{
			dataBase.saveOnFile(userDataFile, posDataFile, gamesWonDataFile, gamesLossDataFile, gamesPlayedDataFile);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param newView the new View that has to be addedd to the model's list of observers
	 * @param oldView the old View that has to be removed from the model's  list of observers
	 */
	public void observationRoutine(JFrame newView, JFrame oldView)
	{
		this.addObserver((Observer)newView);
		this.deleteObserver((Observer) oldView);
	}
	
}
