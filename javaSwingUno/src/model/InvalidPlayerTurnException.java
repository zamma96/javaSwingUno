package model;

public class InvalidPlayerTurnException extends Exception 
{
	String playerId;
	public InvalidPlayerTurnException(String s, String l)
	{
		super(s);
		this.playerId = l;
	}
	
	public String getPlayerId()
	{
		return playerId;
	}
}
