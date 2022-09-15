package model;

import java.util.Map;

import javax.swing.ImageIcon;

public class User 
{

	private String nickName;
	private Avatar avatar;
	private Map<String, Integer> gamesPlayed;
	private int level;
	
	//when building the user, the first int index has to be selected from 1 to 9 to select an avatar
	public User(String nickName, int index, Map<String, Integer> gamesPlayed, int level)
	{
		this.setNickName(nickName);
		this.avatar = new Avatar();
		this.setGamesPlayed(gamesPlayed);
		this.setLevel(level);
	}

	public String getNickName() 
	{
		return this.nickName;
	}

	public void setNickName(String nickName) 
	{
		this.nickName = nickName;
	}

	public Avatar getAvatar() 
	{
		return this.avatar;
	}

	public void setAvatar(int index) 
	{
		this.avatar = new Avatar(index);
	}

	public Map<String, Integer> getGamesPlayed() 
	{
		return this.gamesPlayed;
	}

	public void setGamesPlayed(Map<String, Integer> gamesPlayed) 
	{
		this.gamesPlayed = gamesPlayed;
	}

	public int getLevel() 
	{
		return this.level;
	}

	public void setLevel(int level) 
	{
		this.level = level;
	}
	
	public void maxLevelReward()
	{
		if (this.level == 10);
			this.avatar = avatar.getMaxLevelAvatar();
	}
	
	//Devo capire dove ficcare il metodo per gestire il livello dell'utente,
	//capire se per le partite giocate serve una map o basta un'ArrayList
	//public void setMaxLevelAvatar()
	//{
	//	if this.getUser().getLevel() == 10 then this.avatar = new Avatar().setMaxLevelAvatar();
	//}
}
