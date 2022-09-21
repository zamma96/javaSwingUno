package model;

import java.util.Map;

import javax.swing.ImageIcon;

public class User 
{

	private String nickName;
	private Avatar avatar;
	private GamesPlayed gamesPlayed;
	private int level;
	
	//when building the user, the first int index has to be selected from 1 to 9 to select an avatar
	public User(String nickName, int index)
	{
		this.setNickName(nickName);
		this.avatar = new Avatar(index);
		this.gamesPlayed = new GamesPlayed(this);
		this.setLevel(1);
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
	
	public String getAvatarInfo()
	{
		return this.avatar.toString();
	}

	public void setAvatar(int index) 
	{
		this.avatar = new Avatar(index);
	}

	public int getGamesPlayed() 
	{
		return gamesPlayed.getGamesPlayed(this);
	}
	
	public int getGamesWon()
	{
		return gamesPlayed.getGamesWon(this);
	}
	
	public int getGamesLoss()
	{
		return gamesPlayed.getGamesLoss(this);
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
	
	public void levelUp()
	{
		switch(level) {
		case 1: if(gamesPlayed.getGamesPlayed(this) == 2)
			level++;
		case 2: if(gamesPlayed.getGamesPlayed(this) == 4)
			level++;
		case 3: if(gamesPlayed.getGamesPlayed(this) == 6)
			level++;
		case 4: if(gamesPlayed.getGamesPlayed(this) == 9)
			level++;
		case 5: if(gamesPlayed.getGamesPlayed(this) == 12)
			level++;
		case 6: if(gamesPlayed.getGamesPlayed(this) == 15)
			level++;
		case 7: if(gamesPlayed.getGamesPlayed(this) == 20)
			level++;
		case 8: if(gamesPlayed.getGamesPlayed(this) == 25)
			level++;
		case 9: if(gamesPlayed.getGamesPlayed(this) == 30)
			level++;
		
		}
	}
	
	//Devo capire dove ficcare il metodo per gestire il livello dell'utente,
	//capire se per le partite giocate serve una map o basta un'ArrayList
	//public void setMaxLevelAvatar()
	//{
	//	if this.getUser().getLevel() == 10 then this.avatar = new Avatar().setMaxLevelAvatar();
	//}
}
