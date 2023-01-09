package model;

import java.util.ArrayList;

public class Player 
{
	private int playerId;
	private String nickName;
	private boolean human;
	private ArrayList<Card> playerHand;
	private boolean played = false;
	
	
	public Player(int playerId, String nickName, boolean human, ArrayList<Card> playerHand) 
	{
		this.playerId = playerId; this.nickName = nickName;
		this.human = human; this.playerHand = playerHand;
	}
	
	public void setPlayed(boolean b)
	{
		this.played = b;
	}
	
	public boolean hasPlayed()
	{
		return this.played;
	}
	
	public int getPlayerId()
	{
		return this.playerId;
	}
	
	public ArrayList<Card> getHand()
	{
		return this.playerHand;
	}
	
	public String getPlayerNickName()
	{
		return this.nickName;
	}
	
	public boolean isHuman()
	{
		return human;
	}
}
