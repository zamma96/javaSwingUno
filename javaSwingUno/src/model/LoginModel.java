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
	private File userDataFile = new File("C:\\Users\\matte\\git\\javaSwingUno\\javaSwingUno\\resources\\UserData\\");
	private File posDataFile = new File("C:\\Users\\matte\\git\\javaSwingUno\\javaSwingUno\\resources\\PosData\\");
	private File gamesWonDataFile = new File("C:\\Users\\matte\\git\\javaSwingUno\\javaSwingUno\\resources\\GamesWonData\\");
	private File gamesLossDataFile = new File("C:\\Users\\matte\\git\\javaSwingUno\\javaSwingUno\\resources\\GamesLossData\\");
	private File gamesPlayedDataFile = new File("C:\\Users\\matte\\git\\javaSwingUno\\javaSwingUno\\resources\\GamesPlayedData\\");
	
	public LoginModel()	throws IOException
	{
		this.dataBase = new DataBase();
		//this.dataBase = new DataBase(userDataFile, posDataFile, gamesWonDataFile, gamesLossDataFile, gamesPlayedDataFile);
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
	public Integer getPos()	
	{
		return pos;
	}
	
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
	
	
	/**
	 * method that checks if userInfos are already saved on File
	 * if yes, it's going to swap userDatas updating the ArrayList with new UserDatas
	 * if no, it's going to save new UserData in the ArrayList
	 */
	public void saveUserData()
	{
		UserData ud = new UserData(user, pos, user.getGamesWon(), user.getGamesLoss(), user.getGamesPlayed());
		for (UserData userData : dataBase.getUserData())
			if (userData.getUser().getNickName().equals(ud.getUser().getNickName()))
				dataBase.setUserData(ud, dataBase.getUserData().indexOf(userData));
			else
				dataBase.setUserData(ud);		
	}

	/**
	 * 
	 * @param newView the new View that has to be addedd to the model's list of observers
	 * @param oldView the old View that has to be removed from the model's  list of observers
	 */
	public void observationRoutine(JFrame newView, JFrame oldView)
	{
		this.deleteObserver((Observer) oldView);
		this.addObserver((Observer)newView);
	}
	
}
