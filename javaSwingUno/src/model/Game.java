package model;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.UserHomeController;
import view.UserHomeView;

public class Game extends Observable
{
	//qui dataBase serve solo per salvare i risultati delle partite (Games won, Games played, Games loss)
	private DataBase dataBase;
	private LoginModel loginModel;
	private String[] nameArray = new String[] {"Carlo", "Gianluca", "Simone", "Giorno", "Marco", "Vista", "Karl", "Valentina", "Daniela", "Francesca", "Martina", "Elena"};
	private ArrayList<String> namePool = new ArrayList<String>();
	private ArrayList<String> cardIds;
	private int currentPlayer;
	private Player[] players = new Player[4];
	private Deck deck;
	private ArrayList<ArrayList<Card>> playersHands = new ArrayList<ArrayList<Card>>();
	private ArrayList<Card> stockPile;
	private Card.Color validColor;
	private Card.Value validValue;
	private ArrayList<JButton> cardButtons;
	public boolean gameDirection;
	private User user;
	private Card.Color declaredColor;
	private String playerIdName;
	private int drawTwoCount = 0;
	private int drawFourCount = 0;
	private Icon stockPileIcon = new ImageIcon();
	private int choice;
	
	private static Font BIG_GAME_FONT = new Font("Comic Sans MS", Font.BOLD, 48);
	private static Color TABLE_GREEN = new Color(53, 101, 77);
	private static Color SALMON_PINK = new Color(255, 145, 164);
	
	public Game(LoginModel loginModel)
	{
		this.loginModel = loginModel;
		
		this.dataBase = loginModel.getDataBase();
		this.user = loginModel.getUser();
		hasChanged();
		notifyObservers(user);
		deck = new Deck();
		deck.reset();
		deck.shuffle();
		stockPile = new ArrayList<Card>();
		for (int i = 0; i < nameArray.length; i++)
			namePool.add(nameArray[i]);
		players[0] = new Player(0, user.getNickName(), true, new ArrayList<Card>(Arrays.asList(deck.drawCard(7))));
		//playersHands.add(getPlayerHand(players[0]));
		Player[] ias = randomizePlayer();
		players[1] = ias[0]; players[2] = ias[1]; players[3] = ias[2];
		playersHands.add(getPlayerHand(players[1]));
		playersHands.add(getPlayerHand(players[2]));
		playersHands.add(getPlayerHand(players[3]));
		currentPlayer = 0;
		gameDirection = false;
	}
	
	private Player[] randomizePlayer() 
	{
		Random rand = new Random();
		String ia1 = namePool.get(rand.nextInt(11));
		String ia2 = namePool.get(rand.nextInt(11)); 
		String ia3 = namePool.get(rand.nextInt(11));
		for (int i = 0; i <= 3; i++)
		{
			ArrayList<Card> hand = new ArrayList<Card>(Arrays.asList(deck.drawCard(7)));
			playersHands.add(hand);
		}
		Player pia1 = new Player(1, ia1, false, playersHands.get(1));
		Player pia2 = new Player(2, ia2, false, playersHands.get(2));
		Player pia3 = new Player(3, ia3, false, playersHands.get(3));
		Player[] players = new Player[3];
		players[0] = pia1;
		players[1] = pia2;
		players[2] = pia3;
		return players;
	}
	
	public ArrayList<Card> getStockPile()
	{
		return stockPile;
	}
	
	public void setStockPile(Card card)
	{
		this.stockPile.add(card);
		validColor = card.getColor();
		validValue = card.getValue();
		setChanged();
		notifyObservers(card);
	}
	
	public void setStockPileButton(Icon icon)
	{
		this.stockPileIcon = icon;
		setChanged();
		notifyObservers(stockPileIcon);
	}
	
	public int getChoice()
	{
		return choice;
	}
	
	public void setChoice(int i)
	{
		this.choice = i;
		setChanged();
		notifyObservers(i);
	}
	
	public int getDrawFourCount()
	{
		return drawFourCount;
	}
	
	public int getDrawTwoCount()
	{
		return drawTwoCount;
	}
	
	public void setDrawFourCount()
	{
		drawFourCount++;
	}
	
	public void setDrawTwoCount()
	{
		drawTwoCount++;
	}
	
	public void resetDrawFourCount()
	{
		drawFourCount = 0;
	}
	
	public void resetDrawTwoCount()
	{
		drawTwoCount = 0;
	}
	
	public int getCurrentPlayerCounter()
	{
		return currentPlayer;
	}
	
	public void setCurrentPlayerCounter(int c)
	{
		this.currentPlayer = c;
	}
	
	public void showInvalidPlayerMoveFinishDialog(Card card) throws InvalidSubmissionFinisherException
	{
		JLabel message = new JLabel("You can't finish a UNO game with a non-basic Card");
		message.setFont(BIG_GAME_FONT);
		message.setBackground(TABLE_GREEN);
		message.setForeground(SALMON_PINK);
		JOptionPane.showMessageDialog(null, message);
		throw new InvalidSubmissionFinisherException(message, card.getValue());
	}
	
	public void showInvalidPlayerMoveColorDialog(Card card) throws InvalidColorSubmissionException
	{
		JLabel message = new JLabel("Invalid player move, expected color: " + validColor + " but got color " + card.getColor());
		message.setFont(BIG_GAME_FONT);
		message.setBackground(TABLE_GREEN);
		message.setForeground(SALMON_PINK);
		JOptionPane.showMessageDialog(null, message);
		throw new InvalidColorSubmissionException(message, card.getColor(), validColor);
	}
	
	public void showInvalidPlayerMoveValueDialog(Card card) throws InvalidValueSubmissionException
	{
		JLabel message = new JLabel("Invalid player move, expected value: " + validValue +" but got value " + card.getValue());
		message.setFont(BIG_GAME_FONT);
		message.setBackground(TABLE_GREEN);
		message.setForeground(SALMON_PINK);
		JOptionPane.showMessageDialog(null, message);
		throw new InvalidValueSubmissionException(message, card.getValue() , validValue);	
	}
	
	public void showSkipDialog()
	{
		JLabel message = new JLabel(this.players[currentPlayer].getPlayerNickName() + " was skipped!");
		message.setFont(BIG_GAME_FONT);
		message.setBackground(TABLE_GREEN);
		message.setForeground(SALMON_PINK);
		JOptionPane.showMessageDialog(null, message);
	}
	
	public void showReverseDialog()
	{

		JLabel message = new JLabel(this.players[currentPlayer].getPlayerNickName() + " has changed the game direction!");
		message.setFont(BIG_GAME_FONT);
		message.setBackground(TABLE_GREEN);
		message.setForeground(SALMON_PINK);
		JOptionPane.showMessageDialog(null, message);
	}
	
	public void showDrawTwoDialog()
	{
		JLabel message = new JLabel(this.players[currentPlayer].getPlayerNickName() + " drew 2 cards!");
		message.setBackground(TABLE_GREEN);
		message.setForeground(SALMON_PINK);
		message.setFont(BIG_GAME_FONT);
		JOptionPane.showMessageDialog(null, message);
	}
	
	public void showAnsweredDrawTwoDialog(int i)
	{
		JLabel message = new JLabel(this.players[currentPlayer].getPlayerNickName() + " drew" + i*2 + " cards!");
		message.setBackground(TABLE_GREEN);
		message.setForeground(SALMON_PINK);
		message.setFont(BIG_GAME_FONT);
		JOptionPane.showMessageDialog(null, message);
	}
	
	public void showDrawFourDialog()
	{
		JLabel message = new JLabel(this.players[currentPlayer].getPlayerNickName() + " drew 4 cards!");			
		message.setBackground(TABLE_GREEN);
		message.setForeground(SALMON_PINK);
		message.setFont(BIG_GAME_FONT);
		JOptionPane.showMessageDialog(null, message);
	}
	
	public void showAnsweredDrawFourDialog(int i)
	{
		JLabel message = new JLabel(this.players[currentPlayer].getPlayerNickName() + " drew" + i*4 + " cards!");			
		message.setBackground(TABLE_GREEN);
		message.setForeground(SALMON_PINK);
		message.setFont(BIG_GAME_FONT);
		JOptionPane.showMessageDialog(null, message);
	}
	
	public void showGameWonDialog()
	{
		JLabel message = new JLabel(this.players[currentPlayer].getPlayerNickName() + " won the game!");
		message.setFont(BIG_GAME_FONT);
		message.setBackground(TABLE_GREEN);
		message.setForeground(SALMON_PINK);
		JOptionPane.showMessageDialog(null, message);
	}
	
	/**
	 * @param player
	 * gets the mostFrequentColor on any Player's hand, selected by passing the player.
	 * with stream takes the list of all the player's hand's cards, splits it by underescore
	 * then count the most frequent value between the colors, without counting the wild one,
	 * because this method is needed to help the CPU selecting the card to submit.
	 */
	public Card.Color getMostFrequentColor(Player player)
	{
		String red = "RED"; String blue = "BLUE"; String yellow = "YELLOW"; String green = "GREEN";
		int redCounter = 0; int blueCounter = 0; int yellowCounter = 0; int greenCounter = 0;
		String listString = getPlayerHand(getCurrentPlayer()).stream().map(Object::toString).collect(Collectors.joining("_"));
        String[] cardNames = listString.split("_");
        for (int i = 0; i < cardNames.length; i++)
        {
        	if (cardNames[i] == red)
        		redCounter ++;
        	else if (cardNames[i] == blue)
        		blueCounter++;
        	else if (cardNames[i] == yellow)
        		yellowCounter++;
        	else if (cardNames[i] == green)
        		greenCounter++;
        }
        if (redCounter > blueCounter && redCounter > yellowCounter && redCounter > greenCounter)
        	return Card.Color.RED;
        else if (blueCounter > redCounter && blueCounter > yellowCounter && blueCounter > greenCounter)
        	return Card.Color.BLUE;
        else if (yellowCounter > redCounter && yellowCounter > blueCounter && yellowCounter > greenCounter)
        	return Card.Color.YELLOW;
        else if (greenCounter > redCounter && greenCounter > blueCounter && greenCounter > yellowCounter)
        	return Card.Color.GREEN;
        return Card.Color.WILD;
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
			checkGameDirection();
		}
		if (card.getValue() == Card.Value.REVERSE)
		{
			showReverseDialog();
			gameDirection ^= true;
			currentPlayer = players.length-1;
		}
		stockPile.add(card);
		setChanged();
		notifyObservers(card);
	}
	
	
	public void setDeclaredColor(Card.Color c)
	{
		declaredColor = c;
		setChanged();
		notifyObservers((Card.Color) c);
	}
	
	public Card.Color getDeclaredColor()
	{
		return declaredColor;
	}
	
	public Card getLastStockPileCard()
	{
		return stockPile.get(stockPile.size()-1);
	}
	
	public void setCardIds(ArrayList<String> cardNames)
	{
		this.cardIds = cardNames;
		setChanged();
		notifyObservers(cardIds);
	}
	
	public ArrayList<String> getCardIds()
	{
		return cardIds;
	}
	
	public ArrayList<JButton> getcardButtons()
	{
		return cardButtons;
	}
	
	public DataBase getDataBase()
	{
		return dataBase;
	}
	
	public Card getTopCard()
	{
		return stockPile.get(stockPile.size()-1);
		//return new Card(validColor, validValue);
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
	
	public Player getHumanPlayer()
	{
		for (Player p : players)
			if (p.getPlayerNickName() == user.getNickName())
				return p;
		return null;
	}
	
	public void addGameWon()
	{
		loginModel.getDataBase().setUserData(new UserData(user, loginModel.getPos(), user.getGamesWon()+1, user.getGamesLoss(), user.getGamesPlayed()+1), loginModel.getDataBase().getUserData().indexOf(loginModel.getDataBase().getSpecUserData(user)));
	}
	
	public void addGameLoss()
	{
		loginModel.getDataBase().setUserData(new UserData(user, loginModel.getPos(), user.getGamesWon(), user.getGamesLoss()+1, user.getGamesPlayed()+1), loginModel.getDataBase().getUserData().indexOf(loginModel.getDataBase().getSpecUserData(user)));
	}
	
	
	public String[] getPlayersNames()
	{
		ArrayList<String> playerNamesL = new ArrayList<String>();
		String[] playerNames = new String[4];
		for (Player p : players)
			playerNamesL.add(p.getPlayerNickName());
		String playerList = playerNamesL.stream().collect(Collectors.joining(","));
		playerNames = playerList.split(",");
		return playerNames;
	}
	
	public ArrayList<Card> getPlayerHand(Player player)
	{
		int index = Arrays.asList(players).indexOf(player);
		return playersHands.get(index);
	}
	
	public ArrayList<ArrayList<Card>> getPlayersHands()
	{
		return this.playersHands;
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
/*	Useless
	public void setPlayerIdName(String s)
	{
		this.playerIdName = s;
		setChanged();
		notifyObservers(s);
	}
*/
	public String getPlayerIdName() 
	{
		return playerIdName;
	}
	
	public boolean hasEmptyHand(Player player)
	{
		return getPlayerHand(player).isEmpty();
	}
	
	public boolean hasDrawTwo()
	{
		for(int i = 0; i < getPlayerHandSize(players[currentPlayer]); i++)
			 if (getPlayerHand(players[currentPlayer]).get(i).toString() == "RED_DRAW_TWO" || getPlayerHand(players[currentPlayer]).get(i).toString() == "BLUE_DRAW_TWO" || getPlayerHand(players[currentPlayer]).get(i).toString() == "YELLOW_DRAW_TWO" || getPlayerHand(players[currentPlayer]).get(i).toString() == "GREEN_DRAW_TWO") 
			 	return true;
		return false;
	}

	public boolean isDrawTwo(int i)
	{
		if (getPlayerHand(players[currentPlayer]).get(i).toString() == "RED_DRAW_TWO" || getPlayerHand(players[currentPlayer]).get(i).toString() == "BLUE_DRAW_TWO" || getPlayerHand(players[currentPlayer]).get(i).toString() == "YELLOW_DRAW_TWO" || getPlayerHand(players[currentPlayer]).get(i).toString() == "GREEN_DRAW_TWO")
			return true;
		return false;
	}

	public boolean hasDrawFour()
	{
		for (int i = 0; i < getPlayerHandSize(players[currentPlayer]); i++)
			if (getPlayerHand(players[currentPlayer]).get(i).toString() == "WILD_DRAW_FOUR")
				return true;
		return false;
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
	
	/**
	 * method to check gameDirection and go to next player
	 */
	public void checkGameDirection()
	{
		if (gameDirection == false)
			currentPlayer++;
		else if(gameDirection == true) 
		{
			currentPlayer--;
			if (currentPlayer == -1)
				currentPlayer = players.length -1;		
		}
		if (players[currentPlayer].isHuman() == false)
		{
			
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
		checkGameDirection();
	}
	
	public void setValidColor(Card.Color color)
	{
		validColor = color;
	}
	
	public void setValidValue(Card.Value value)
	{
		validValue = value;
	}
	
	public String[] handToString(Player player)
	{
		String[] cards = new String[getPlayerHand(player).size()];
		int index = 0;
		for (Card c : getPlayerHand(player))
		{
			cards[index] = c.toString();
			index++;
		}
		return cards;
	}
	
	public void gameOverCheck()
	{
		if (isGameOver())
		{
			showGameWonDialog();
			if (getHumanPlayer() == players[currentPlayer])
				addGameWon();
			else
				addGameLoss();
			System.exit(0);
		}
	}
	
	public void answerDrawTwoDialog(Card c) throws InvalidPlayerTurnException
	{
		ArrayList<Card> currentPlayerHand = getPlayerHand(players[getCurrentPlayerCounter()]);
		String[] options = {"Yes", "No"};
		JOptionPane.showConfirmDialog(null, "Do you want to answer \n" + players[currentPlayer-1].getPlayerNickName() + "'s draw two?", "Answer Dialog", JOptionPane.YES_NO_OPTION);
		int n = JOptionPane.showOptionDialog(null, "Do you want to answer \n" + players[currentPlayer-1].getPlayerNickName() + "'s draw two?", "Answer Dialog", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
		if (n == JOptionPane.YES_OPTION)
		{
			currentPlayerHand.remove(c);
			gameOverCheck();
			stockPile.add(c);
			drawTwoCount++;
		}
		else
		{
			for (int i = 0; i <= getDrawTwoCount(); i++)
			{
				submitDraw(players[getCurrentPlayerCounter()]);
				submitDraw(players[getCurrentPlayerCounter()]);
			}
			showAnsweredDrawTwoDialog(getDrawTwoCount());
			resetDrawTwoCount();
			checkGameDirection();
		}
	}
	
	public void answerDrawFourDialog(Card c) throws InvalidPlayerTurnException
	{
		ArrayList<Card> currentPlayerHand = getPlayerHand(players[getCurrentPlayerCounter()]);
		String[] options = {"Yes", "No"};
		JOptionPane.showConfirmDialog(null, "Do you want to answer \n" + players[currentPlayer-1].getPlayerNickName() + "'s draw four?", "Answer Dialog", JOptionPane.YES_NO_OPTION);
		int n = JOptionPane.showOptionDialog(null, "Do you want to answer \n" + players[currentPlayer-1].getPlayerNickName() + "'s draw four?", "Answer Dialog", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
		if (n == JOptionPane.YES_OPTION)
		{
			currentPlayerHand.remove(c);
			colorChangeDialog();
			gameOverCheck();
			stockPile.add(c);
			drawFourCount++;
		}
		else
		{
			for (int i = 0; i <= getDrawFourCount(); i++)
			{
				submitDraw(players[getCurrentPlayerCounter()]);
				submitDraw(players[getCurrentPlayerCounter()]);
				submitDraw(players[getCurrentPlayerCounter()]);
				submitDraw(players[getCurrentPlayerCounter()]);
			}
			showAnsweredDrawFourDialog(getDrawFourCount());
			resetDrawFourCount();
			checkGameDirection();
		}
	}

	public void submitAICard() throws InvalidColorSubmissionException, InvalidValueSubmissionException, InvalidPlayerTurnException
	{
		checkPlayerTurn(players[getCurrentPlayerCounter()]);
		
		ArrayList<Card> currentPlayerHand = getPlayerHand(players[getCurrentPlayerCounter()]);
		setValidColor(getLastStockPileCard().getColor());
		setValidValue(getLastStockPileCard().getValue());
		
		if ((currentPlayerHand.size() == 1) && (currentPlayerHand.get(0).getValue().equals(Card.Value.COLOR_CHANGE) || currentPlayerHand.get(0).getValue().equals(Card.Value.DRAW_FOUR) && currentPlayerHand.get(0).getValue().equals(Card.Value.DRAW_TWO) && currentPlayerHand.get(0).getValue().equals(Card.Value.SKIP) && currentPlayerHand.get(0).getValue().equals(Card.Value.REVERSE)))
		{
			submitDraw(players[getCurrentPlayerCounter()]);
			checkGameDirection();
		}
		
		if (validColor.equals(Card.Color.WILD))
		{
			if (validValue.equals(Card.Value.DRAW_FOUR)) 
			{
				if (hasDrawFour())
				{
					for (Card c : currentPlayerHand)
						if (c.toString().equals("WILD_DRAW_FOUR"))
						{
							currentPlayerHand.remove(currentPlayerHand.indexOf(c));
							gameOverCheck();
							setValidColor(getMostFrequentColor(players[getCurrentPlayerCounter()]));
							setValidValue(c.getValue());
							isGameOver();
							setStockPile(c);
							checkGameDirection();
							setDrawFourCount();
						}
				}
				else
				{
					for (int i = 0; i <= getDrawFourCount(); i++)
					{
						submitDraw(players[getCurrentPlayerCounter()]);
						submitDraw(players[getCurrentPlayerCounter()]);
						submitDraw(players[getCurrentPlayerCounter()]);
						submitDraw(players[getCurrentPlayerCounter()]);
					}
					showAnsweredDrawFourDialog(getDrawFourCount());
					resetDrawFourCount();
					checkGameDirection();
				}	
			}	
			if (validValue.toString().equals("COLOR_CHANGE"))
			{
				for (Card c : currentPlayerHand)
				{
					if (c.getColor().equals(validColor))
					{
						currentPlayerHand.remove(currentPlayerHand.indexOf(c));
						gameOverCheck();
						setValidColor(c.getColor());
						setValidValue(c.getValue());
						setStockPile(c);
						checkGameDirection();
					}
					else if (c.getValue().equals(validValue))
					{
						currentPlayerHand.remove(currentPlayerHand.indexOf(c));
						gameOverCheck();
						setValidColor(getMostFrequentColor(players[getCurrentPlayerCounter()]));
						setValidValue(c.getValue());
						setStockPile(c);
						checkGameDirection();
					}
					else
						submitDraw(players[getCurrentPlayerCounter()]);
				}
			}
		}
		else if (validValue.toString().equals("DRAW_TWO"))
		{
			if(hasDrawTwo())
			{
				for (Card c : currentPlayerHand)
					if (c.getValue().toString().equals("DRAW_TWO"))
					{
						currentPlayerHand.remove(currentPlayerHand.indexOf(c));
						gameOverCheck();
						setValidColor(c.getColor());
						setValidValue(c.getValue());
						setStockPile(c);
						checkGameDirection();
						setDrawTwoCount();
					}
			}
			else 
			{
				for (int i = 0; i <= getDrawTwoCount(); i++)
				{
					submitDraw(players[getCurrentPlayerCounter()]);
					submitDraw(players[getCurrentPlayerCounter()]);
				}
				showAnsweredDrawTwoDialog(getDrawTwoCount());
				resetDrawTwoCount();
				checkGameDirection();
			}
		}
		else if(getLastStockPileCard().getValue().toString().equals("SKIP"))
		{
			checkGameDirection();
			showSkipDialog();
		}
		else if(getLastStockPileCard().getValue().toString().equals("REVERSE"))
		{
			showReverseDialog();
			
			reverseRoutine();
		}
		else
		{
			for (Card c : currentPlayerHand)
			{
				if (c.getColor() == validColor)
				{
					currentPlayerHand.remove(currentPlayerHand.indexOf(c));
					gameOverCheck();
					setValidValue(c.getValue());
					setStockPile(c);
					checkGameDirection();
				}
				else if (c.getValue() == validValue)
				{
					currentPlayerHand.remove(currentPlayerHand.indexOf(c));
					gameOverCheck();
					setValidColor(c.getColor());
					setStockPile(c);
					checkGameDirection();
				}
			}
		}
	}
	
	public void submitPlayerCard(Card card) throws InvalidColorSubmissionException, InvalidPlayerTurnException, InvalidValueSubmissionException, InvalidSubmissionFinisherException
	{
		ArrayList<Card> currentPlayerHand = getPlayerHand(players[getCurrentPlayerCounter()]);
		validColor = getLastStockPileCard().getColor();
		validValue = getLastStockPileCard().getValue();
		
		if ((currentPlayerHand.size() == 1) && (currentPlayerHand.get(0).getValue().equals(Card.Value.COLOR_CHANGE) || currentPlayerHand.get(0).getValue().equals(Card.Value.DRAW_FOUR) && currentPlayerHand.get(0).getValue().equals(Card.Value.DRAW_TWO) && currentPlayerHand.get(0).getValue().equals(Card.Value.SKIP) && currentPlayerHand.get(0).getValue().equals(Card.Value.REVERSE)))
		{
			JLabel message = new JLabel ("You should draw a card, can't win a UNO game with a non-basic Card");
			message.setFont(BIG_GAME_FONT);
			message.setBackground(TABLE_GREEN);
			message.setForeground(SALMON_PINK);
			JOptionPane.showMessageDialog(null, message);
			throw new InvalidSubmissionFinisherException(message, card.getValue());
		}
		
		if (validValue.equals(Card.Value.DRAW_FOUR))
		{
			if (hasDrawFour())
			{
				for (Card c : currentPlayerHand)
					if (c.toString().equals("WILD_DRAW_FOUR"))
						answerDrawFourDialog(c);
			}
			if (!hasDrawFour())
			{
				for (int i = 0; i <= getDrawFourCount(); i++)
				{
					submitDraw(players[getCurrentPlayerCounter()]);
					submitDraw(players[getCurrentPlayerCounter()]);
					submitDraw(players[getCurrentPlayerCounter()]);
					submitDraw(players[getCurrentPlayerCounter()]);
				}
				showAnsweredDrawFourDialog(getDrawFourCount());
				resetDrawFourCount();
				checkGameDirection();
			}
		}
		if (getLastStockPileCard().getValue().equals(Card.Value.COLOR_CHANGE))
		{
			if (!validCardPlay(card))
			{
				if (card.getColor().equals(Card.Color.WILD))
				{
					currentPlayerHand.remove(card);
					validColor = card.getColor();
					validValue = card.getValue();
				}
				if (card.getColor() != validColor)
				{
					if (card.getValue().equals(validValue))
					{
						currentPlayerHand.remove(card);
						colorChangeDialog();
					}
					else
						showInvalidPlayerMoveValueDialog(card);
		    		}
				else
					showInvalidPlayerMoveColorDialog(card);
			}
		}
		if (getLastStockPileCard().getValue().equals(Card.Value.DRAW_TWO))
		{
			if (hasDrawTwo())
			{
				for (Card c : currentPlayerHand)
					if (c.getValue().toString().equals("DRAW_TWO"))
						answerDrawTwoDialog(c);
			}
			if (!hasDrawTwo())
			{
				for (int i = 0; i<= getDrawTwoCount(); i++)
				{
					submitDraw(players[getCurrentPlayerCounter()]);
					submitDraw(players[getCurrentPlayerCounter()]);
				}
				showAnsweredDrawTwoDialog(getDrawTwoCount());
				resetDrawTwoCount();
				checkGameDirection();
			}
		}
		if (getLastStockPileCard().getValue().equals(Card.Value.SKIP))
		{
			checkGameDirection();
			showSkipDialog();
		}
		if (getLastStockPileCard().getValue().equals(Card.Value.REVERSE))
		{
			showReverseDialog();
			reverseRoutine();
		}
		else
		{
			if (!validCardPlay(card))
			{
				if (card.getValue().equals(Card.Value.COLOR_CHANGE))
				{
					if(currentPlayerHand.size()==1)
						showInvalidPlayerMoveFinishDialog(card);
					colorChangeDialog();
					currentPlayerHand.remove(card);
					gameOverCheck();
					
				}
				showInvalidPlayerMoveColorDialog(card);
			}
			else
			{
				if(currentPlayerHand.size()==1)
					if ((card.getValue().equals(Card.Value.REVERSE)) || (card.getValue().equals(Card.Value.SKIP)) || (card.getValue().equals(Card.Value.COLOR_CHANGE)) || (card.getValue().equals(Card.Value.DRAW_FOUR)) || (card.getValue().equals(Card.Value.DRAW_TWO)))
							showInvalidPlayerMoveFinishDialog(card);
				currentPlayerHand.remove(card);
				gameOverCheck();
				setValidColor(card.getColor());
				setValidValue(card.getValue());
				setStockPile(card);
				checkGameDirection();
			}
		}
	}

	
	//va in GameControllerClass
	public void gameLoop() throws InvalidPlayerTurnException, InvalidColorSubmissionException, InvalidValueSubmissionException, InterruptedException, InvalidSubmissionFinisherException
	{
		while (players[currentPlayer].isHuman() == false)
		{
			submitAICard();
			gameOverCheck();
			TimeUnit.SECONDS.sleep(5L);
		}	
		if (players[currentPlayer].isHuman())
		{
			submitPlayerCard(getPlayerHand(players[currentPlayer]).get(choice));
			gameOverCheck();
		}
	}
	
	public void observationRoutine(JFrame newView, JFrame oldView)
	{
		this.addObserver((Observer)newView);
		this.deleteObserver((Observer) oldView);
	}
	
	public void colorChangeDialog()
	{
		Object[] possibilities = {"RED", "GREEN", "BLUE", "YELLOW"};
		String s = (String)JOptionPane.showInputDialog(null, "Change color into: ", "Change Color Frame", JOptionPane.PLAIN_MESSAGE, null, possibilities, "RED");
		if ((s!= null) && s.length() > 0)
			validColor = toColor(s);
	}
	
	public Card.Color toColor(String s)
	{
		if (s.equals("RED"))
			return Card.Color.RED;
		if (s.equals("GREEN"))
			return Card.Color.GREEN;
		if (s.equals("BLUE"))
			return Card.Color.BLUE;
		if (s.equals("YELLOW"))
			return Card.Color.YELLOW;
		return null;
	}
	
	public void checkColorChange(Card c)
	{
		if (c.getValue().equals(Card.Value.COLOR_CHANGE))
		{
			setValidColor(getMostFrequentColor(players[currentPlayer]));
			setValidValue(c.getValue());
			setStockPile(c);
		}
	}
	
	public void reverseRoutine()
	{
		gameDirection ^= true;
		if (gameDirection == true)
		{
			currentPlayer -= 2;
			if (currentPlayer == -1)
				currentPlayer = players.length-1;
			if (currentPlayer == -2)
				currentPlayer = players.length-2;
		}
		else if(gameDirection == false)
			currentPlayer += 2;
	}
}