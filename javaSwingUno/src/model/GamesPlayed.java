package model;

public class GamesPlayed 
{
	private User user;
	private Integer[] games_w_l_played;
	
	public GamesPlayed(User user)
	{
		this.user = user; 
		this.games_w_l_played  = new Integer[] {0,0,0}; 
	}
	
	public void addGameWin(User user)
	{
		if (user == this.user)
			games_w_l_played[0]++;
	}
	
	public void addGameLoss(User user)
	{
		if (user == this.user)
			games_w_l_played[1]++;
	}
	
	public void addGamePlayed(User user)
	{
		if (user == this.user)
			games_w_l_played[2]++;
	}
	
	public int getGamesWon(User user)
	{
		if (this.user == user)
			return games_w_l_played[0];
		return 0;
	}
	
	public int getGamesLoss(User user)
	{
		if (this.user == user)
			return games_w_l_played[1];
		return 0;
	}
	public int getGamesPlayed(User user)
	{
		if (this.user == user)
			return games_w_l_played[2];
		return 0;
	}
}
