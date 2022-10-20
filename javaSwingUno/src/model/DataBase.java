package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBase 
{
	private ArrayList<User> users;
	private ArrayList<Integer> positions;
	private ArrayList<Integer> gamesWon;
	private ArrayList<Integer> gamesLoss;
	private ArrayList<Integer> gamesPlayed;
	
	public DataBase(File userData, File posData, File gamesWonData, File gamesLossData, File gamesPlayedData) throws IOException
	{
		loadByFile(userData, posData, gamesWonData, gamesLossData, gamesPlayedData);
			
	}
	
	public void addGameWon(User user)
	{
		int index = users.indexOf(user);
		gamesWon.add(index, gamesWon.get(index)+1);
		gamesPlayed.add(index, gamesPlayed.get(index)+1);
	}
	
	public Integer getGamesWon(User user)
	{
		int index = users.indexOf(user);
		return gamesWon.get(index);
	}
	
	public Integer getGamesPlayed(User user)
	{
		int index = users.indexOf(user);
		return gamesPlayed.get(index);
	}
	
	public void addGameLoss(User user)
	{
		int index = users.indexOf(user);
		gamesLoss.add(index, gamesLoss.get(index)+1);
		gamesPlayed.add(index, gamesPlayed.get(index)+1);
	}
	
	public Integer getGamesLoss(User user)
	{
		int index = users.indexOf(user);
		return gamesLoss.get(index);
	}
	
	public void addPos(User user, Integer pos)
	{
		Integer temp = users.indexOf(user);
		positions.add(temp, pos);
	}
	
	public Integer getPos(User user)
	{
		Integer temp = users.indexOf(user);
		return positions.get(temp);
	}
	
	public void addUser(User user)
	{
		users.add(user);
		positions.add(users.indexOf(user), 0);
		gamesWon.add(users.indexOf(user), 0);
		gamesLoss.add(users.indexOf(user), 0);
		gamesPlayed.add(users.indexOf(user), 0);
	}
	
	public List<User> getUsers()
	{
		return users;
	}
	
	public User getUser(String nickName)
	{
		for(User u : users)
		{
			if (u.getNickName() == nickName)
				return u;
		}
		return null;
	}
	
	public void saveOnFile(File userFile, File posFile, File gamesWonFile, File gamesLossFile, File gamesPlayedFile) throws IOException
	{
		FileOutputStream fos0 = new FileOutputStream(posFile);
		FileOutputStream fos1 = new FileOutputStream(userFile);
		FileOutputStream fos2 = new FileOutputStream(gamesWonFile);
		FileOutputStream fos3 = new FileOutputStream(gamesLossFile);
		FileOutputStream fos4 = new FileOutputStream(gamesPlayedFile);
		ObjectOutputStream oos0 = new ObjectOutputStream(fos0);
		ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
		ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
		ObjectOutputStream oos3 = new ObjectOutputStream(fos3);
		ObjectOutputStream oos4 = new ObjectOutputStream(fos4);
		
		User[] userArray = users.toArray(new User[users.size()]);
		Integer[] posArray = positions.toArray(new Integer[positions.size()]);
		Integer[] gamesWonArray = gamesWon.toArray(new Integer[gamesWon.size()]);
		Integer[] gamesLossArray = gamesLoss.toArray(new Integer[gamesLoss.size()]);
		Integer[] gamesPlayedArray = gamesPlayed.toArray(new Integer[gamesPlayed.size()]);
		
		oos4.writeObject(gamesPlayedArray);
		oos3.writeObject(gamesLossArray);
		oos2.writeObject(gamesWonArray);
		oos1.writeObject(userArray);
		oos0.writeObject(posArray);
		
		oos4.close();
		oos3.close();
		oos2.close();
		oos1.close();
		oos0.close();
		fos4.close();
		fos3.close();
		fos2.close();
		fos1.close();
		fos0.close();
	}
	
	public void loadByFile(File userFile, File posFile, File gamesWonFile, File gamesLossFile, File gamesPlayedFile) throws IOException
	{
		FileInputStream fis0 = new FileInputStream(userFile);
		FileInputStream fis1 = new FileInputStream(posFile);
		FileInputStream fis2 = new FileInputStream(gamesWonFile);
		FileInputStream fis3 = new FileInputStream(gamesLossFile);
		FileInputStream fis4 = new FileInputStream(gamesPlayedFile);
		ObjectInputStream ois0 = new ObjectInputStream(fis0);
		ObjectInputStream ois1 = new ObjectInputStream(fis1);
		ObjectInputStream ois2 = new ObjectInputStream(fis2);
		ObjectInputStream ois3 = new ObjectInputStream(fis3);
		ObjectInputStream ois4 = new ObjectInputStream(fis4);
		
		
		try 
		{
			User[] loadedUsers = (User[]) ois0.readObject();
			Integer[] loadedPos = (Integer[]) ois1.readObject();
			Integer[] loadedWonGames = (Integer[]) ois2.readObject();
			Integer[] loadedLossGames = (Integer[]) ois3.readObject();
			Integer[] loadedPlayedGames = (Integer[]) ois4.readObject();
			users.clear();
			positions.clear();
			gamesWon.clear();
			gamesLoss.clear();
			gamesPlayed.clear();
			users.addAll(Arrays.asList(loadedUsers));
			positions.addAll(Arrays.asList(loadedPos));
			gamesWon.addAll(Arrays.asList(loadedWonGames));
			gamesLoss.addAll(Arrays.asList(loadedLossGames));
			gamesPlayed.addAll(Arrays.asList(loadedPlayedGames));

		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		ois0.close();
		ois1.close();
		ois2.close();
		fis0.close();
		fis1.close();
		fis2.close();
	}
}
