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
	private File userData = new File(".\\resources\\UserData"); 

	private ArrayList<User> users;
	
	public DataBase() throws IOException
	{
		loadByFile(userData);
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
	
	public void saveOnFile(File file) throws IOException
	{
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		User[] userArray = users.toArray(new User[users.size()]);
		
		oos.writeObject(userArray);
		
		oos.close();
		fos.close();
	}
	
	public void loadByFile(File file) throws IOException
	{
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		try 
		{
			User[] loadedUsers = (User[]) ois.readObject();
			users.clear();
			users.addAll(Arrays.asList(loadedUsers));
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		ois.close();
		fis.close();
	}
}
