package model;

import java.util.ArrayList;

public class Player 
{
	private int playerId;
	private String nickName;
	private boolean human;
	private ArrayList<Card> playerHand;
	
	
	public Player(int playerId, String nickName, boolean human, ArrayList<Card> playerHand) 
	{
		this.playerId = playerId; this.nickName = nickName;
		this.human = human; this.playerHand = playerHand;
	}
	
	public int getPlayerId()
	{
		return this.playerId;
	}
	
	public ArrayList<Card> getHand()
	{
		return this.playerHand;
	}
	
	@Override
	public String toString()
	{
		return this.nickName;
	}
	
	//bisogna rivedere nel Game il metodo che mostra le carte al giocatore, se è umano le mostra altrimenti
	//mostra il retro delle carte mentre si applica un leggero delay per simulare la scelta della carta;
	//
	
	public String getPlayerNickName()
	{
		return this.nickName;
	}
	
	public boolean isHuman()
	{
		return human;
	}
}
