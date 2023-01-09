package model;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Random;
import java.util.stream.Collectors;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Model extends Observable
{
	private static Font BIG_GAME_FONT = new Font("Comic Sans MS", Font.BOLD, 48);
	private static Color TABLE_GREEN = new Color(53, 101, 77);
	private static Color SALMON_PINK = new Color(255, 145, 164);
	
	private LoginModel loginModel;
	private DataBase dataBase;
	private User user;
	private Deck deck;
	private ArrayList<Card> stockPile;
	private Icon stockIcon = new ImageIcon();
	private ArrayList<ArrayList<Card>> playersHands;
	private Player[] players = new Player[4];
	private List<String> nameList = Arrays.asList("Carlo", "Gianluca", "Simone", "Giorno", "Marco", "Vista", "Karl", "Valentina", "Daniela", "Francesca", "Martina", "Elena");
	private int currentPlayer;
	private boolean gameDirection;
	private int drawTwoCounter = 0;
	private int drawFourCounter = 0;
	private Card.Color validColor;
	private Card.Value validValue;
	private ArrayList<String> cardIds;
	private ArrayList<JButton> cardButtons;
	private Integer choice;
	
	
	public Model(LoginModel loginModel)
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
		
		currentPlayer = 0;
		gameDirection = false;
	}
	
	/**
	 * 
	 * @param game tha game instance that has to be started.
	 * 
	 * Method that initializes the game in a correct way.
	 */
	public void start(Model game)
	{
		Card card = deck.drawCard();
		setValidColor(card.getColor());
		setValidValue(card.getValue());
		
		if (card.getValue().equals(Card.Value.COLOR_CHANGE)|| card.getValue().equals(Card.Value.DRAW_TWO) || card.getValue().equals(Card.Value.DRAW_FOUR))
			start(game); //this cards can't start a UNO game
		if (card.getValue().equals(Card.Value.SKIP))
		{
			showSkipDialog();
			passTurn();
		}
		if (card.getValue().equals(Card.Value.REVERSE))
		{
			firstReverseDialog();
			gameDirection ^= true;
			currentPlayer = players.length-1;
		}
		setStockPile(card);
	}
	
	/**
	 * 
	 * @param c color to be set as Valid
	 * @param v value to be set as Valid
	 */
	public void setValids(Card.Color c, Card.Value v)
	{
		setValidValue(v);
		setValidColor(c);
	}
	
	/**
	 * 
	 * @return Database where to save and load data
	 */
	public DataBase getDataBase()
	{
		return dataBase;
	}
	
	/**
	 * 
	 * @param cardNames a list of any player's hand cards.
	 */
	public void setCardIds(ArrayList<String> cardNames)
	{
		this.cardIds = cardNames;
		setChanged();
		notifyObservers(cardIds);
	}
	
	/**
	 * 
	 * @return the list of card names of any player's hand
	 */
	public ArrayList<String> getCardIds()
	{
		return cardIds;
	}
	
	/**
	 * 
	 * @return current validValue
	 */
	public Card.Value getValidValue()
	{
		return validValue;
	}
	
	/**
	 * 
	 * @param v the value to be set as Valid
	 */
	public void setValidValue(Card.Value v)
	{
		validValue = v;
		setChanged();
		notifyObservers(validValue);
	}
	
	/**
	 * 
	 * @return int choice (index of the human player's card from his hand)
	 */
	public Integer getChoice()
	{
		return choice;
	}
	
	/**
	 * 
	 * @param i the value of human player's choice
	 */
	public void setChoice(Integer i)
	{
		this.choice = i;
		setChanged();
		notifyObservers(i);
	}
	
	/**
	 * 
	 * @return current validColor
	 */
	public Card.Color getValidColor()
	{
		return validColor;
	}
	
	/**
	 * 
	 * @param c the color to bne set as valid
	 */
	public void setValidColor(Card.Color c)
	{
		validColor = c;
		setChanged();
		notifyObservers(validColor);
	}
	
	/**
	 * 
	 * @return the icon of the visible stockPile card.
	 */
	public Icon getStockIcon()
	{
		return stockIcon;
	}
	
	/**
	 * 
	 * @param i to be set as visible stockPile card
	 */
	public void setStockIcon(ImageIcon i)
	{
		stockIcon = i;
		setChanged();
		notifyObservers(stockIcon);
	}
	
	/**
	 * method that fills all player hands.
	 */
	public void fillPlayersHands()
	{
		ArrayList<Card> userHand = new ArrayList<Card>(Arrays.asList(deck.drawCard(7)));
		players[0] = new Player(0, user.getNickName(), true, userHand);
		Player[] ias = randomizePlayer();
		players[1] = ias[0]; players[2] = ias[1]; players[3] = ias[2];
		playersHands.add(getPlayerHand(players[0]));
		playersHands.add(getPlayerHand(players[1]));
		playersHands.add(getPlayerHand(players[2]));
		playersHands.add(getPlayerHand(players[3]));
	}
	
	/**
	 * 
	 * @return a list of this game's players.
	 */
	private Player[] randomizePlayer() 
	{
		Random rand = new Random();
		String ia1 = nameList.remove(rand.nextInt(11));
		String ia2 = nameList.remove(rand.nextInt(11)); 
		String ia3 = nameList.get(rand.nextInt(11));
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
	
	/**
	 * 
	 * @return a list of this game's players names.
	 */
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
	
	/**
	 * 
	 * @param player is the one's hand i'm looking for
	 * @return that player's hand
	 */
	public ArrayList<Card> getPlayerHand(Player player)
	{
		int index = Arrays.asList(players).indexOf(player);
		return playersHands.get(index);
	}
	
	/**
	 * 
	 * @return list of all players.
	 */
	public Player[] getPlayers()
	{
		return players;
	}
	
	/**
	 * 
	 * @return the human player
	 */
	public Player getHumanPlayer()
	{
		return players[0];
	}

	/**
	 * 
	 * @return true if someone has 0 cards in hand.
	 */
	public boolean isGameOver()
	{
		for (ArrayList<Card> h : playersHands)
		{
			if (h.size() == 0)
				return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @return currentPlayer
	 */
	public Player getCurrentPlayer()
	{
		return players[getCurrentPlayerCounter()];
	}
	
	/**
	 * 
	 * @return true if last player before current player has 
	 * submitted any card.
	 */
	public boolean getLastActivePlayer()
	{
		return players[getCurrentPlayerCounter()-1].hasPlayed();
	}
	
	/**
	 * 
	 * @return current player's NickName.
	 */
	public String getCurrentPlayerNickName()
	{
		return getCurrentPlayer().getPlayerNickName();
	}
	
	/**
	 * 
	 * @return the index for currentPlayer's position in players[]
	 */
	public int getCurrentPlayerCounter()
	{
		return currentPlayer;
	}
	
	/**
	 * 
	 * @return current player's hand
	 */
	public ArrayList<Card> getCurrentPlayerHand()
	{
		return getCurrentPlayer().getHand();
	}
	
	/**
	 * 
	 * @return true if current player has a draw four in his hand.
	 */
	public boolean hasDrawFour()
	{
		ArrayList<Card> hand = getCurrentPlayer().getHand();
		for(Card c : hand)
			if (c.getValue().equals(Card.Value.DRAW_FOUR))
				return true;
		return false;
	}
	
	/**
	 * 
	 * @return true if current player has a draw two in his hand.
	 */
	public boolean hasDrawTwo()
	{
		ArrayList<Card> hand = getCurrentPlayer().getHand();
		for(Card c : hand)
			if (c.getValue().equals(Card.Value.DRAW_TWO))
				return true;
		return false;
	}
	
	/**
	 * 
	 * @return currentPlayer's draw four from his hand, 
	 * only called after hasDrawFour check.
	 */
	public Card getDrawFour()
	{
		Card drawFour = new Card(null, null);;
		ArrayList<Card> hand = getCurrentPlayerHand();
		
		for (Card c : hand)
		{
			if (c.getValue().equals(Card.Value.DRAW_FOUR))
			{
				drawFour = getCurrentPlayerHand().get(getCurrentPlayerHand().indexOf(c));
				getCurrentPlayerHand().remove(c);
			}
		}
		return drawFour;
	}
	
	/**
	 * 
	 * @return currentPlayer's color change from his hand,
	 * only called after hasColorChange check.
	 */
	public Card getColorChange()
	{
		Card colorChange = new Card(null, null);
		ArrayList<Card> hand = getCurrentPlayerHand();
		for (Card c : hand)
		{
			if (c.getValue().equals(Card.Value.COLOR_CHANGE))
			{
				colorChange = c;
				getCurrentPlayerHand().remove(c);
			}
		}
		return colorChange;
	}
	
	/**
	 * 
	 * @return currentPlayer's draw two from his hand, 
	 * only called after hasDrawTwo check.
	 */
	public Card getDrawTwo()
	{
		Card drawTwo = new Card(null, null);;
		ArrayList<Card> hand = getCurrentPlayerHand();
		
		for (Card c : hand)
		{
			if (c.getValue().equals(Card.Value.DRAW_TWO))
			{
				drawTwo = getCurrentPlayerHand().get(getCurrentPlayerHand().indexOf(c));
				getCurrentPlayerHand().remove(c);
			}
		}
		return drawTwo;
	}
	
	/**
	 * 
	 * @param c the card to be set as stockPileCard
	 */
	public void setStockPile(Card c)
	{
		stockPile.add(c);
		setStockIcon(new ImageIcon(".\\resources\\UnoCards\\" + c.toString() + ".png"));
	}
	
	/**
	 * 
	 * @return the whole stockPile card list.
	 */
	public ArrayList<Card> getStockPile()
	{
		return stockPile;
	}
	
	/**
	 * 
	 * @return the whole list of JButton used for player's hand.
	 */
	public ArrayList<JButton> getcardButtons()
	{
		return cardButtons;
	}
	
	/**
	 * what to to if currentPlayer has a valid play.
	 */
	public void validPlayRoutine()
	{
		//cose da fare in ogni caso
		Card c = getValidPlay();
		getCurrentPlayerHand().remove(c);
		setStockPile(c);
		setValids(c.getColor(), c.getValue());
		//controlli casi speciali
		if (c.getValue().equals(Card.Value.SKIP))
		{
			sendSkipDialog();
			getCurrentPlayer().setPlayed(true);
			passTurn(); 
			getCurrentPlayer().setPlayed(false);
			passTurn();
		}
		else if (c.getValue().equals(Card.Value.REVERSE))
			sendReverseDialog();
		else if (c.getValue().equals(Card.Value.DRAW_TWO))
			hasDrawTwoRoutine();
		else if(c.getColor().equals(Card.Color.WILD))
			colorChangeRoutine();
		//fine routine
	}
	
	/**
	 * checks current game's direction and reverses it.
	 */
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
		{
			currentPlayer += 2;
			if (currentPlayer == players.length)
				currentPlayer = 0;
			if (currentPlayer == players.length+1)
				currentPlayer = 1;
		}
	}
	
	/**
	 * what to do when AI need to throw a colorChange
	 */
	public void colorChangeRoutine()
	{
		Card c = getColorChange();
		getCurrentPlayerHand().remove(c);
		setStockPile(c);
		setValids(getMostFrequentColor(), c.getValue());
		colorChangeDialog();
		getCurrentPlayer().setPlayed(true);
		passTurn();
	}
	
	/**
	 * what to do when AI need to throw a DrawTwo
	 */
	public void hasDrawTwoRoutine()
	{
		Card answer = getDrawTwo();
		getCurrentPlayerHand().remove(answer);
		drawTwoCounter++;
		setStockPile(answer);
		setValids(answer.getColor(), answer.getValue());
		getCurrentPlayer().setPlayed(true);
		passTurn();
	}
	
	/**
	 * what to do when AI need to throw a DrawFour
	 */
	public void hasDrawFourRoutine()
	{
		Card answer = getDrawFour();
		getCurrentPlayerHand().remove(answer);
		drawFourCounter++;
		setStockPile(answer);
		setValids(answer.getColor(), answer.getValue());
		getCurrentPlayer().setPlayed(true);
		passTurn();
	}
	
	/**
	 * dialog generated for colorChanges.
	 */
	public void colorChangeDialog()
	{
		JLabel message = new JLabel(getCurrentPlayerNickName() + " changed color into " + getValidColor());
		message.setBackground(TABLE_GREEN);
		message.setForeground(SALMON_PINK);
		message.setFont(BIG_GAME_FONT);
		JOptionPane.showMessageDialog(null, message);
	}
	
	/**
	 * dialog generated for invalid colorSubmissions.
	 * @param card: the invalid Card played.
	 * @throws InvalidColorSubmissionException
	 */
	public void showInvalidPlayerMoveColorDialog(Card card) throws InvalidColorSubmissionException
	{
		JLabel message = new JLabel("Invalid player move, expected color: " + validColor + " but got color " + card.getColor());
		message.setFont(BIG_GAME_FONT);
		message.setBackground(TABLE_GREEN);
		message.setForeground(SALMON_PINK);
		JOptionPane.showMessageDialog(null, message);
		throw new InvalidColorSubmissionException(message, card.getColor(), validColor);
	}
	
	/**
	 * dialog generated for invalid valueSubmissions.
	 * @param card: the invalid card played.
	 * @throws InvalidValueSubmissionException
	 */
	public void showInvalidPlayerMoveValueDialog(Card card) throws InvalidValueSubmissionException
	{
		JLabel message = new JLabel("Invalid player move, expected value: " + validValue +" but got value " + card.getValue());
		message.setFont(BIG_GAME_FONT);
		message.setBackground(TABLE_GREEN);
		message.setForeground(SALMON_PINK);
		JOptionPane.showMessageDialog(null, message);
		throw new InvalidValueSubmissionException(message, card.getValue() , validValue);	
	}
	
	/**
	 * 
	 * @param s the string caught from ColorChange dialogs
	 * 
	 * @return Card.Color translaction of that color.
	 */
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
	
	/**
	 * dialog that shows up when user wants to change color.
	 */
	public void colorChange()
	{
		Object[] possibilities = {"RED", "GREEN", "BLUE", "YELLOW"};
		String s = (String)JOptionPane.showInputDialog(null, "Change color into: ", "Change Color Frame", JOptionPane.PLAIN_MESSAGE, null, possibilities, "RED");
		if ((s!= null) && s.length() > 0)
			setValidColor(toColor(s));
	}
	
	/**
	 * 
	 * @return true if user wants to answer the 
	 * previous player's drawTwo.
	 */
	public boolean answerDrawTwo()
	{
		boolean answer = true;
		if(hasDrawTwo())
		{
			Object[] possibilities = {"YES", "NO"};
			String s = (String)JOptionPane.showInputDialog(null, "Do you want to answer a draw two?", "Warning, under attack!", JOptionPane.PLAIN_MESSAGE, null, possibilities, "YES");
			if (s.equals("NO"))
			{
				answer = false;
			}
		}
		else
			answer = false;
		return answer;
	}
	
	/**
	 * 
	 * @return true if user wants to answer the 
	 * previous player's drawFour.
	 */
	public boolean answerDrawFour()
	{
		boolean answer = true;
		if(hasDrawFour())
		{
			Object[] possibilities = {"YES", "NO"};
			String s = (String)JOptionPane.showInputDialog(null, "Do you want to answer a draw four?", "Warning, under attack!", JOptionPane.PLAIN_MESSAGE, null, possibilities, "YES");
			if (s.equals("NO"))
			{
				answer = false;
			}
		}
		else
			answer = false;
		return answer;
	}
	
	/**
	 * dialog that shows up when any player need to draw a card
	 */
	public void drawCardDialog()
	{
		JLabel message = new JLabel(getCurrentPlayerNickName() + " drew a Card");
		message.setBackground(TABLE_GREEN);
		message.setForeground(SALMON_PINK);
		message.setFont(BIG_GAME_FONT);
		JOptionPane.showMessageDialog(null, message);
	}
	
	/**
	 * 
	 * @return true if user wants to use the selected card.
	 */
	public boolean selectionDialog()
	{
		boolean selection = true;
		Object[] possibilities = {"YES", "NO"};
		String s = (String)JOptionPane.showInputDialog(null, "You want to use this card? ", "Card submission", JOptionPane.PLAIN_MESSAGE, null, possibilities, "YES");
		if (s.equals("NO"))
			selection = false;
		return selection;
	}
	
	/**
	 * 
	 * @param i the counter of the drawTwo answered from the players
	 */
	public void showAnsweredDrawTwoDialog(int i)
	{
		JLabel message = new JLabel(getCurrentPlayerNickName() + " drew " + i*2 + " cards!");
		message.setBackground(TABLE_GREEN);
		message.setForeground(SALMON_PINK);
		message.setFont(BIG_GAME_FONT);
		JOptionPane.showMessageDialog(null, message);
		
		drawTwoCounter = 0;
	}
	
	/**
	 * 
	 * @param i the counter of the drawFour answered from the players
	 */
	public void showAnsweredDrawFourDialog(int i)
	{
		JLabel message = new JLabel(getCurrentPlayerNickName() + " drew " + i*4 + " cards!");
		message.setBackground(TABLE_GREEN);
		message.setForeground(SALMON_PINK);
		message.setFont(BIG_GAME_FONT);
		JOptionPane.showMessageDialog(null, message);
		
		drawFourCounter = 0;
	}
	
	/**
	 * dialog that shows up when a game starts with a Skip Card.
	 */
	public void showSkipDialog()
	{
		JLabel message = new JLabel(getCurrentPlayerNickName() + " was skipped!");
		message.setFont(BIG_GAME_FONT);
		message.setBackground(TABLE_GREEN);
		message.setForeground(SALMON_PINK);
		JOptionPane.showMessageDialog(null, message);
	}
	
	/**
	 * dialog that shows up when a player uses a Skip Card.
	 */
	public void sendSkipDialog()
	{
		JLabel message;
		if (gameDirection == false)
		{
			if (currentPlayer+1 == players.length)
				currentPlayer = 0;
			message = new JLabel(players[getCurrentPlayerCounter()+1].getPlayerNickName() + " was skipped!");
		}
		else
		{
			if (currentPlayer-1 == -1)
				currentPlayer = players.length-1;
			message = new JLabel(players[getCurrentPlayerCounter()-1].getPlayerNickName() + " was skipped!");
		}
		message.setFont(BIG_GAME_FONT);
		message.setBackground(TABLE_GREEN);
		message.setForeground(SALMON_PINK);
		JOptionPane.showMessageDialog(null, message);
	}
	
	/**
	 * dialog that shows up when a player uses a Reverse Card
	 */
	public void sendReverseDialog()
	{
		reverseRoutine();
		getCurrentPlayer().setPlayed(true);
		JLabel message = new JLabel(getCurrentPlayerNickName() + " has changed the game direction!");
		message.setFont(BIG_GAME_FONT);
		message.setBackground(TABLE_GREEN);
		message.setForeground(SALMON_PINK);
		JOptionPane.showMessageDialog(null, message);
	}
	
	/**
	 * dialog that shows up if the game starts with a Reverse Card.
	 */
	public void firstReverseDialog()
	{
		JLabel message = new JLabel("The game direction has changed!");
		message.setFont(BIG_GAME_FONT);
		message.setBackground(TABLE_GREEN);
		message.setForeground(SALMON_PINK);
		JOptionPane.showMessageDialog(null, message);
	}
	
	/**
	 * uno scream by any player.
	 */
	public void screamUno()
	{
		JLabel message = new JLabel(getCurrentPlayerNickName() + ": 'UNO!'");
		message.setBackground(TABLE_GREEN);
		message.setForeground(SALMON_PINK);
		message.setFont(BIG_GAME_FONT);
		JOptionPane.showMessageDialog(null, message);
	}
	
	/**
	 * dialog that shows up if some player draws a card.
	 */
	public void drawMessage()
	{
		JLabel message = new JLabel(getCurrentPlayerNickName() + " drew a card");
		message.setBackground(TABLE_GREEN);
		message.setForeground(SALMON_PINK);
		message.setFont(BIG_GAME_FONT);
		JOptionPane.showMessageDialog(null, message);
	}
	
	/**
	 * dialog that shows up if the user tries to finish a game
	 * with a special card.
	 */
	public void unfortunateMessage()
	{
		JLabel message = new JLabel("It's not possible to finish a game \n with a non numeric card, sorry");
		message.setBackground(TABLE_GREEN);
		message.setForeground(SALMON_PINK);
		message.setFont(BIG_GAME_FONT);
		JOptionPane.showMessageDialog(null, message);
	}
	
	/**
	 * method for user only
	 * @param c the card to be checked
	 * @return true if c is a valid card play
	 */
	public boolean validCardPlay(Card c)
	{
		if (c.getColor().equals(validColor)||c.getValue().equals(validValue)||c.getColor().equals(Card.Color.WILD))
			return true;
		return false;
	}
	
	/**
	 * method that sumbits any player's draw.
	 */
	public void submitDraw() 
	{
		if (deck.isEmpty())
		{
			deck.replaceDeckWith(stockPile);
			deck.shuffle();
		}
		getCurrentPlayerHand().add(deck.drawCard());
		getCurrentPlayer().setPlayed(false);
	}
	
	/**
	 * method that submits any player pile of cards
	 * due to one or more drawTwo
	 */
	public void drawTwo()
	{
		for (int i = 0; i < drawTwoCounter; i++)
		{
			submitDraw();
			submitDraw();
		}
		showAnsweredDrawTwoDialog(drawTwoCounter);
		passTurn();
	}
	
	/**
	 * method that submits any player pile of cards
	 * due to one or more drawFour
	 */
	public void drawFour()
	{
		for (int i = 0; i < drawFourCounter; i++)
		{
			submitDraw();
			submitDraw();
			submitDraw();
			submitDraw();
		}
		showAnsweredDrawFourDialog(drawFourCounter);
		passTurn();
	}
	
	/**
	 * method that checks gameDirection and lets
	 * players to move forward on the clockwise or 
	 * counterClockwise direction.
	 */
	public void passTurn()
	{
		if (gameDirection == false)
		{
			currentPlayer++;
			if (currentPlayer == players.length)
				currentPlayer = 0;
		}
		else if(gameDirection == true) 
		{
			currentPlayer--;
			if (currentPlayer == -1)
				currentPlayer = players.length -1;		
		}
	}
	
	/**
	 * method that checks if currentPlayer's hand is one or two cards
	 * and calculates consequently.
	 */
	public boolean lastCardCheck()
	{
		boolean passed = true;
		if (getCurrentPlayer().isHuman())
		{
			if ((getCurrentPlayerHand().size() == 1) && ((getCurrentPlayerHand().get(0).getColor() == Card.Color.WILD) || (getCurrentPlayerHand().get(0).getValue() == Card.Value.SKIP) || (getCurrentPlayerHand().get(0).getValue() == Card.Value.REVERSE) || (getCurrentPlayerHand().get(0).getValue() == Card.Value.DRAW_TWO)))
			{
				passed = false;
				submitDraw();
				unfortunateMessage();
				passTurn();
			}
			else if (getCurrentPlayerHand().size() == 2)
			{
				if(hasValidPlay())
					screamUno();
			}
		}
		else 
		{
			if ((getCurrentPlayerHand().size() == 1) && ((getCurrentPlayerHand().get(0).getColor() == Card.Color.WILD) || (getCurrentPlayerHand().get(0).getValue() == Card.Value.SKIP) || (getCurrentPlayerHand().get(0).getValue() == Card.Value.REVERSE) || (getCurrentPlayerHand().get(0).getValue() == Card.Value.DRAW_TWO)))
			{
				passed = false;
				submitDraw();
				drawMessage();
				passTurn();
			}
			else if (getCurrentPlayerHand().size() == 2)
			{
				if (hasValidPlay())
					screamUno();
				else
				{
					passed = false;
					submitDraw();
					drawMessage();
					passTurn();
				}
			}
		}
		return passed;
	}
	
	/**
	 * method that exectute operations nedded when player
	 * has no valid card plays.
	 */
	public void noValidPlay()
	{
		submitDraw(); 
		passTurn();
	}
	
	/**
	 * 
	 * @return true if currentPlayer has a valid card play in his hand.
	 */
	public boolean hasValidPlay()
	{
		ArrayList<Card> hand = getCurrentPlayerHand();
		for (Card c : hand)
		{
			if (c.getColor().equals(getValidColor())||c.getValue().equals(getValidValue()) || c.getColor().equals(Card.Color.WILD))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @return the card that makes the play valid.
	 */
	public Card getValidPlay()
	{
		Card validCard = new Card(null, null);
		for(Card c : getCurrentPlayerHand())
		{
			if (c.getColor().equals(getValidColor())||c.getValue().equals(getValidValue()) || c.getColor().equals(Card.Color.WILD))
			{
				validCard = c;
			}
		}
		return validCard;
	}

	/**
	 * 
	 * @return true if currentPlayer can answer the previous player's 
	 * drawTwo or drawFour
	 * otherwise it makes the current player draw the number of card requested.
	 */
	public boolean cardCheck()
	{
		boolean passed = true;
		if (getLastActivePlayer())
		{
			Card downCard = stockPile.get(stockPile.size()-1);
			if (downCard.getValue().equals(Card.Value.DRAW_TWO))
			{
				if(!answerDrawTwo());
				{
					getCurrentPlayer().setPlayed(false);
					drawTwo();
					passed = false;
				}
			}
			else if (downCard.getValue().equals(Card.Value.DRAW_FOUR))
			{
				if (!answerDrawFour())
				{
					getCurrentPlayer().setPlayed(false);
					drawFour();
					passed = false;
				}
			}	
		}
		return passed;
	}
	
	/**
	 * game logic for AI players.
	 */
	public void submitAiCard()
	{
		Card downCard = stockPile.get(stockPile.size()-1);
		if (lastCardCheck())
		{
			if(getLastActivePlayer())
			{
				if (downCard.getValue().equals(Card.Value.DRAW_TWO))
				{
					if(hasDrawTwo())
						hasDrawTwoRoutine();
					else
						drawTwo();
				}
				else if (downCard.getValue().equals(Card.Value.DRAW_FOUR))
				{
					if (hasDrawFour())
						hasDrawFourRoutine();
					else
						drawFour();
				}	
				else 
				{
					if (hasValidPlay())
					{
						getCurrentPlayer().setPlayed(true);
						validPlayRoutine();	
					}
					else
					{
						getCurrentPlayer().setPlayed(false);
						noValidPlay();
					}
				}
			}
			else
			{
				if (hasValidPlay())
				{
					getCurrentPlayer().setPlayed(true);
					validPlayRoutine();	
				}
				else
				{
					getCurrentPlayer().setPlayed(false);
					noValidPlay();
				}
			}
		}
	}
	
	/**
	 * gameLogic for User.
	 * @param i the card choose from the user's hand by user input.
	 * @throws InvalidColorSubmissionException
	 * @throws InvalidValueSubmissionException
	 * @throws InvalidSubmissionFinisherException
	 * 
	 */
	public void submitPlayerCard(Integer i) throws InvalidColorSubmissionException, InvalidValueSubmissionException, InvalidSubmissionFinisherException
	{
		lastCardCheck();
		Card downCard = stockPile.get(stockPile.size()-1);
		Card choosen = getCurrentPlayerHand().get(i);
		//card check eseguito nel gameLoop nella classe View 
		//poi viene chiamata questa funzione
		if (hasValidPlay())
		{
			//da fare sempre
			getCurrentPlayer().setPlayed(true);
			getCurrentPlayerHand().remove(choosen);
			setStockPile(choosen);
			//setValids va bene qui perché in caso di wildCard
			//ricambia il valore validColor
			setValids(choosen.getColor(), choosen.getValue());
			
			if(choosen.getValue().equals(Card.Value.SKIP))
			{
				sendSkipDialog();
				getCurrentPlayer().setPlayed(true);
				passTurn();
				getCurrentPlayer().setPlayed(false);
				passTurn();
			}
			else if (choosen.getValue().equals(Card.Value.REVERSE))
			{
				sendReverseDialog();
				passTurn();
			}
			else if (choosen.getValue().equals(Card.Value.DRAW_TWO))
			{
				drawTwoCounter++;
			}
			else if (choosen.getColor().equals(Card.Color.WILD))
			{
				colorChange();
				if (choosen.getValue().equals(Card.Value.DRAW_FOUR))
					drawFourCounter++;
				colorChangeDialog();
			}
			passTurn();
		}
		else
		{
			getCurrentPlayer().setPlayed(false);
			if (!choosen.getColor().equals(validColor))
				showInvalidPlayerMoveColorDialog(choosen);
			else if (!choosen.getValue().equals(validValue))
				showInvalidPlayerMoveValueDialog(choosen);
			//praticamente qua si controlla se l'utente
			//ha provato una carta valida o meno,
			//se non valida lancia messaggio, altrimenti calcola
			//validità e si comporta di conseguenza
		}
	}
	
	/**
	 * @param player
	 * gets the mostFrequentColor on any Player's hand, selected by passing the player.
	 * with stream takes the list of all the player's hand's cards, splits it by underescore
	 * then count the most frequent value between the colors, without counting the wild one,
	 * because this method is needed to help the AI selecting the card to submit.
	 */
	public Card.Color getMostFrequentColor()
	{
		String red = "RED"; String blue = "BLUE"; String yellow = "YELLOW"; String green = "GREEN";
		int redCounter = 0; int blueCounter = 0; int yellowCounter = 0; int greenCounter = 0;
		String listString = getCurrentPlayerHand().stream().map(Object::toString).collect(Collectors.joining("_"));
        String[] cardNames = listString.split("_");
        for (int i = 0; i < cardNames.length; i++)
        {
        	if (cardNames[i].equals(red))
        		redCounter ++;
        	else if (cardNames[i].equals(blue))
        		blueCounter++;
        	else if (cardNames[i].equals(yellow))
        		yellowCounter++;
        	else if (cardNames[i].equals(green))
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
	
	
	public void addGameWon()
	{
		loginModel.getDataBase().setUserData(new UserData(user, loginModel.getPos(), user.getGamesWon()+1, user.getGamesLoss(), user.getGamesPlayed()+1), loginModel.getDataBase().getUserData().indexOf(loginModel.getDataBase().getSpecUserData(user)));
	}
	
	public void addGameLoss()
	{
		loginModel.getDataBase().setUserData(new UserData(user, loginModel.getPos(), user.getGamesWon(), user.getGamesLoss()+1, user.getGamesPlayed()+1), loginModel.getDataBase().getUserData().indexOf(loginModel.getDataBase().getSpecUserData(user)));
	}
	
	
}
