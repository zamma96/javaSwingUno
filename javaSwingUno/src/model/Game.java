package model;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Game 
{
	private int currentPlayer;
	private Player[] players;
	private Deck deck;
	private ArrayList<ArrayList<Card>> playersHands;
	private ArrayList<Card> stockPile;
	private Card.Color validColor;
	private Card.Value validValue;
	boolean gameDirection;
	
	public Game(Player[] players)
	{
		deck = new Deck();
		deck.reset();
		deck.shuffle();
		stockPile = new ArrayList<Card>();
		
		this.players = players;
		currentPlayer = 0;
		gameDirection = false;
		
		playersHands = new ArrayList<ArrayList<Card>>();
		
		for (int i = 0; i < players.length; i++)
		{
			ArrayList<Card> hand = new ArrayList<Card>(Arrays.asList(deck.drawCard(7)));
			playersHands.add(hand);
		}
	}
	
	public void showInvalidPlayerMoveColorDialog(Card card) throws InvalidColorSubmissionException
	{
		JLabel message = new JLabel("Invalid player move, expected color: " + validColor + " but got color " + card.getColor());
		message.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
		message.setBackground(new Color(53,101,77));
		message.setForeground(new Color(255, 145, 164));
		JOptionPane.showMessageDialog(null, message);
		throw new InvalidColorSubmissionException(message, card.getColor(), validColor);
	}
	
	public void showInvalidPlayerMoveValueDialog(Card card) throws InvalidValueSubmissionException
	{
		JLabel message = new JLabel("Invalid player move, expected value: " + validValue +" but got value " + card.getValue());
		message.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
		message.setBackground(new Color(53,101,77));
		message.setForeground(new Color(255, 145, 164));
		JOptionPane.showMessageDialog(null, message);
		throw new InvalidValueSubmissionException(message, card.getValue() , validValue);	
	}
	
	public void showSkipDialog()
	{
		JLabel message = new JLabel(this.players[currentPlayer] + " was skipped!");
		message.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
		message.setBackground(new Color(53,101,77));
		message.setForeground(new Color(255, 145, 164));
		JOptionPane.showMessageDialog(null, message);
	}
	
	public void showReverseDialog()
	{

		JLabel message = new JLabel(this.players[currentPlayer].toString() + " has changed the game direction!");
		message.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
		message.setBackground(new Color(53,101,77));
		message.setForeground(new Color(255, 145, 164));
		JOptionPane.showMessageDialog(null, message);
	}
	
	public void showDrawTwoDialog()
	{
		JLabel message = new JLabel(this.players[currentPlayer].toString() + " drew two cards!");
		message.setBackground(new Color(53,101,77));
		message.setForeground(new Color(255, 145, 164));
		message.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
		JOptionPane.showMessageDialog(null, message);
	}
	
	public void showDrawFourDialog()
	{
		JLabel message = new JLabel(this.players[currentPlayer].toString() + " drew four cards!");			
		message.setBackground(new Color(53,101,77));
		message.setForeground(new Color(255, 145, 164));
		message.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
		JOptionPane.showMessageDialog(null, message);
	}
	
	public void showGameWonDialog()
	{
		JLabel message = new JLabel(this.players[currentPlayer] + " won the game!");
		message.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
		message.setBackground(new Color(53,101,77));
		message.setForeground(new Color(255, 145, 164));
		JOptionPane.showMessageDialog(null, message);
	}
	
	public void start(Game game)
	{
		Card card = deck.drawCard();
		validColor = card.getColor();
		validValue = card.getValue();
		
		if (card.getValue() == Card.Value.COLOR_CHANGE|| card.getValue() == Card.Value.DRAW_TWO || card.getValue() == Card.Value.DRAW_FOUR)
			start(game); //this cards can't start a UNO game
		if (card.getValue() == Card.Value.SKIP)
		{
			showSkipDialog();
			checkGameDirection(this.players);
		}
		if (card.getValue() == Card.Value.REVERSE)
		{
			showReverseDialog();
			gameDirection ^= true;
			currentPlayer = players.length-1;
		}
		stockPile.add(card);
	}
	
	public Card getTopCard()
	{
		return new Card(validColor, validValue);
	}
	
	public ImageIcon getTopCardImage()
	{
		return new ImageIcon(validColor + "_" + validValue + ".png");
	}
	
	public Player getCurrentPlayer()
	{
		return this.players[currentPlayer];
	}
	
	public Player getPreviousPlayer(int i)
	{
		int index = currentPlayer - i;
		if(index == -1)
			index = players.length - 1;
		return players[index];
	}
	
	public Player[] getPlayers()
	{
		return players;
	}
	
	public ArrayList<Card> getPlayerHand(Player player)
	{
		int index = Arrays.asList(players).indexOf(player);
		return playersHands.get(index);
	}
	
	public int getPlayerHandSize(Player player)
	{
		return getPlayerHand(player).size();
	}
	
	public Card getPlayerCard(Player player, int choice)
	{
		ArrayList<Card> hand = getPlayerHand(player);
		return hand.get(choice);
	}
	
	public Deck getDeck()
	{
		return this.deck;
	}
	
	public boolean hasEmptyHand(Player player)
	{
		return getPlayerHand(player).isEmpty();
	}
	
	public boolean isGameOver()
	{
		for(Player player : this.players)
			if (hasEmptyHand(player))
				return true;
		return false;
	}
	
	public boolean validCardPlay(Card card)
	{
		return card.getColor() == validColor || card.getValue() == validValue;
	}
	
	public void checkPlayerTurn(Player player) throws InvalidPlayerTurnException
	{
		if (this.players[this.currentPlayer] != player)
			throw new InvalidPlayerTurnException("it is not " + player.toString() + "'s turn", player.toString());
	}
	
	public void checkGameDirection(Player[] players)
	{
		if (gameDirection == false)
			currentPlayer = (currentPlayer + 1)% players.length;
		else if(gameDirection == true) 
		{
			currentPlayer = (currentPlayer - 1)% players.length;
			if (currentPlayer == -1)
				currentPlayer = players.length -1;		
		}
	}
	
	public void submitDraw(Player player) throws InvalidPlayerTurnException
	{
		checkPlayerTurn(player);
		if (deck.isEmpty())
		{
			deck.replaceDeckWith(stockPile);
			deck.shuffle();
		}
		getPlayerHand(player).add(deck.drawCard());
		checkGameDirection(players);
	}
	
	public void setCardColor(Card.Color color)
	{
		validColor = color;
	}
	
	public void submitPlayerCard(Player player, Card card, Card.Color declaredColor)throws InvalidColorSubmissionException, InvalidValueSubmissionException, InvalidPlayerTurnException
	{
		checkPlayerTurn(player);
		
		ArrayList<Card> playerHand = getPlayerHand(player);
		
		if(!validCardPlay(card))
		{
			if (card.getColor() == Card.Color.WILD)
			{
				playerHand.remove(card);
				validColor = card.getColor();
				validValue = card.getValue();
			}
			if (card.getColor() != validColor)
			{
				if (card.getValue() == validValue)
					playerHand.remove(card);
				showInvalidPlayerMoveColorDialog(card);
			}
			else if (card.getValue() != validValue)
				showInvalidPlayerMoveValueDialog(card);
		}
		playerHand.remove(card);
		
		if (isGameOver())
		{
			showGameWonDialog();
			System.exit(0);
		}
		validColor = card.getColor();
		validValue = card.getValue();
		stockPile.add(card);
		checkGameDirection(players);
		
		if (card.getColor() == Card.Color.WILD)
			validColor = declaredColor;
		if (card.getValue() == Card.Value.DRAW_TWO)
		{
			player = players[currentPlayer];
			getPlayerHand(player).add(deck.drawCard());
			getPlayerHand(player).add(deck.drawCard());
			showDrawTwoDialog();
		}
		if (card.getValue() == Card.Value.DRAW_FOUR)
		{
			player = players[currentPlayer];
			getPlayerHand(player).add(deck.drawCard());
			getPlayerHand(player).add(deck.drawCard());
			getPlayerHand(player).add(deck.drawCard());
			getPlayerHand(player).add(deck.drawCard());
			showDrawFourDialog();
		}
		if (card.getValue() == Card.Value.SKIP)
		{
			showSkipDialog();
			checkGameDirection(players);
		}
		if (card.getValue() == Card.Value.REVERSE)
		{
			showReverseDialog();
			
			gameDirection ^= true;
			if (gameDirection == true)
			{
				currentPlayer = (currentPlayer - 2)% players.length;
				if (currentPlayer == -1)
					currentPlayer = players.length - 1;
				if (currentPlayer == -2)
					currentPlayer = players.length - 2;
			}
			else if(gameDirection == false)
			{
				currentPlayer = (currentPlayer + 2)%players.length;
			}
		}
	}
}