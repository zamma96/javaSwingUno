package model;

import java.util.ArrayList;

public class Player 
{
	private String playerId;
	private boolean human;
	private ArrayList<Card> playerHand;
	
	
	public Player() {}
	
	@Override
	public String toString()
	{
		return this.playerId;
	}
	
}
