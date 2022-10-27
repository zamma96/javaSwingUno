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
	private File userDataFile = new File("C:\\Users\\matte\\git\\javaSwingUno\\javaSwingUno\\resources\\UserData\\");
	private ArrayList<UserData> userData;

	public DataBase()
	{
		userData = new ArrayList<UserData>();
	}
	 
	public void addUserData(UserData ud)
	{
		userData.add(ud);
	}
	
	public ArrayList<UserData> getUserData()
	{
		return userData;
	}
	
	public UserData getSpecUserData(User user)
	{
		for (UserData userD : this.userData)
			if (userD.getUser().getNickName().equals(user.getNickName()))
				return userD;
		return null;
	}
	
	public User getUser(User user) 
	{
		for (UserData u : userData)
		{
			if(u.getUser() == user)
				return user;
		}
		return null;
	}
	
	public User getUserFromNickName(String nickName)
	{
		for(UserData u : userData)
			if(u.getUser().getNickName().equals(nickName))
				return u.getUser();
		return null;
	}
	
	public String[] getUserNickNames()
	{
		String[] nickNames = new String[userData.size()];
		int temp = 0;
		for (UserData ud : userData)
		{
			nickNames[temp] = ud.getUser().getNickName();
			temp++;
		}
		return nickNames;
	}
	
	public boolean getMatch(String s)
	{
		for(String nickName : getUserNickNames())
			if (nickName.equals(s))
				return true;
		return false;
	}
	
	public void setUserData(UserData ud)
	{
		userData.add(ud);
		try 
		{
			saveOnFile(userDataFile);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void setUserData(UserData ud, int pos)
	{
		userData.remove(pos);
		userData.add(pos, ud);
		try 
		{
			saveOnFile(userDataFile);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public Integer getPos(User user)
	{
		for (UserData u : userData)
		{
			if (u.getUser() == user)
			{
				return u.getPosition();
			}
		}
		return -1;
	}
	
	public void saveOnFile(File file) throws IOException
	{
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		UserData[] userDataArray = userData.toArray(new UserData[userData.size()]);
		
		oos.writeObject(userDataArray);
		
		oos.close();
		fos.close();
	}
	
	public void loadByFile(File file) throws IOException
	{
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		try
		{
			UserData[] loadedUserData = (UserData[]) ois.readObject();
			userData.clear();
			userData.addAll(Arrays.asList(loadedUserData));
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		ois.close();
		fis.close();
	}

}
