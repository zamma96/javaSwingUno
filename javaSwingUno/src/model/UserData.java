package model;

import java.io.Serializable;

public class UserData implements Serializable
{
	private static long contatore = 0L;
	
	private User user;
	private Integer position;
	private Integer gamesWon;
	private Integer gamesLoss;
	private Integer gamesPlayed;
	
	public UserData(User user, Integer position, Integer gamesWon, Integer gamesLoss, Integer gamesPlayed)
	{
		this.user = user; this.position = position;
		this.gamesWon = gamesWon; this.gamesLoss = gamesLoss;
		this.gamesPlayed = gamesPlayed;
	}
	
	public User getUser()
	{
		return this.user;
	}
	
	public Integer getPosition()
	{
		return this.position;
	}
	
	public Integer getGamesWon()
	{
		return gamesWon;
	}
	
	public Integer getGamesLoss()
	{
		return this.gamesLoss;
	}
	
	public Integer getGamesPlayed()
	{
		return gamesPlayed;
	}
	
	public void setUser(User user)
	{
		this.user = user;
	}
	
	public void setPosition(Integer pos)
	{
		this.position = pos;
	}
	
	public void setGamesWon(Integer gamesWon)
	{
		this.gamesWon = gamesWon;
	}
	
	public void setGamesLoss(Integer gamesLoss)
	{
		this.gamesLoss = gamesLoss;
	}

	public void setGamesPlayed(Integer gamesPlayed)
	{
		this.gamesPlayed = gamesPlayed;
	}
}
