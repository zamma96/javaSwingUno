package model;

import java.io.Serializable;

public class User implements Serializable 
{
	/**
	 * 
	 */
	private static long counter = 1L;
	private String nickName;
	private Integer level;
	private Integer gamesWon;
	private Integer gamesLoss;
	private Integer gamesPlayed;

	public User(String nickName, Integer gamesWon, Integer gamesLoss, Integer gamesPlayed)
	{
		this.setNickName(nickName);
		this.setLevel(1);
		this.gamesWon = gamesWon;
		this.gamesLoss = gamesLoss;
		this.gamesPlayed = gamesPlayed;
		counter++;
	}
	
	public User(String nickName)
	{
		this.setNickName(nickName);
		this.setLevel(1);
		this.gamesWon = 0;
		this.gamesLoss = 0;
		this.gamesPlayed = 0;
		counter++;
	}

	public String getNickName() 
	{
		return this.nickName;
	}

	public void setNickName(String nickName) 
	{
		this.nickName = nickName;
	}

	public int getGamesPlayed() 
	{
		return gamesPlayed;
	}
	
	public int getGamesWon()
	{
		return gamesWon;
	}
	
	public int getGamesLoss()
	{
		return gamesLoss;
	}

	public int getLevel() 
	{
		return this.level;
	}

	public void setLevel(int level) 
	{
		this.level = level;
	}
	
	
	public void levelUp()
	{
		switch(level) {
		case 1: if(gamesPlayed == 2)
			level++;
		case 2: if(gamesPlayed == 4)
			level++;
		case 3: if(gamesPlayed == 6)
			level++;
		case 4: if(gamesPlayed == 9)
			level++;
		case 5: if(gamesPlayed == 12)
			level++;
		case 6: if(gamesPlayed == 15)
			level++;
		case 7: if(gamesPlayed == 20)
			level++;
		case 8: if(gamesPlayed == 25)
			level++;
		case 9: if(gamesPlayed == 30)
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
