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
	
	public DataBase(File userData, File posData) throws IOException
	{
		loadByFile(userData, posData);
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
	
	public void saveOnFile(File userFile, File posFile) throws IOException
	{
		FileOutputStream fos0 = new FileOutputStream(posFile);
		ObjectOutputStream oos0 = new ObjectOutputStream(fos0);
		FileOutputStream fos1 = new FileOutputStream(userFile);
		ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
		
		User[] userArray = users.toArray(new User[users.size()]);
		Integer[] posArray = positions.toArray(new Integer[positions.size()]);
		
		oos1.writeObject(userArray);
		oos0.writeObject(posArray);
		
		oos1.close();
		oos0.close();
		fos1.close();
		fos0.close();
	}
	
	public void loadByFile(File userFile, File posFile) throws IOException
	{
		FileInputStream fis0 = new FileInputStream(userFile);
		FileInputStream fis1 = new FileInputStream(posFile);
		ObjectInputStream ois0 = new ObjectInputStream(fis0);
		ObjectInputStream ois1 = new ObjectInputStream(fis1);
		
		try 
		{
			User[] loadedUsers = (User[]) ois0.readObject();
			Integer[] loadedPos = (Integer[]) ois1.readObject();
			users.clear();
			positions.clear();
			users.addAll(Arrays.asList(loadedUsers));
			positions.addAll(Arrays.asList(loadedPos));

		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		ois0.close();
		ois1.close();
		fis0.close();
		fis1.close();
	}
}
