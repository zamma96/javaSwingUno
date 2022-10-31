package model;

import java.util.TimerTask;

import controller.GameController;

import java.util.ArrayList;
import java.util.Timer;

public class Helper extends TimerTask
{
	private Game game;
	private Player[] players;
	private Card.Color validColor;
	private Card.Value validValue;
	
	public Helper(Game game, GameController gameController)
	{
		this.game = game;
		this.players = game.getPlayers();
	}

	@Override
	public void run() 
	{
		//while currentPlayer.isHuman() == false
		//DELAY
		//submitAiCard()
		//DELAY
		//If currentPlayer è HUMAN -> wait(?);
	}
	
	public void setValidColor(Card.Color c)
	{
		this.validColor = c;
		game.setValidColor(c);
	}
	
	public void setValidValue(Card.Value v)
	{
		this.validValue = v;
		game.setValidValue(v);
	}
	
	public void gameOverCheck()
	{
		if (game.isGameOver())
		{
			game.showGameWonDialog();
			if (game.getHumanPlayer() == players[game.getCurrentPlayerCounter()])
				
				game.addGameWon();
			else
				game.addGameLoss();
			System.exit(0);
		}
	}
	
	public void submitAICard() throws InvalidColorSubmissionException, InvalidValueSubmissionException, InvalidPlayerTurnException
	{
		game.checkPlayerTurn(players[game.getCurrentPlayerCounter()]);
		
		ArrayList<Card> currentPlayerHand = game.getPlayerHand(players[game.getCurrentPlayerCounter()]);
		setValidColor(game.getLastStockPileCard().getColor());
		setValidValue(game.getLastStockPileCard().getValue());
		
		if (game.getLastStockPileCard().getColor().equals(Card.Color.WILD))
		{
			if (game.getLastStockPileCard().getValue().equals(Card.Value.DRAW_FOUR)) 
			{
				if (game.hasDrawFour())
				{
					for (Card c : currentPlayerHand)
						if (c.toString().equals("WILD_DRAW_FOUR"))
						{
							currentPlayerHand.remove(currentPlayerHand.indexOf(c));
							gameOverCheck();
							setValidColor(game.getMostFrequentColor(players[game.getCurrentPlayerCounter()]));
							setValidValue(c.getValue());
							game.isGameOver();
							game.setStockPile(c);
							game.checkGameDirection();
							game.setDrawFourCount();
						}
				}
				else
				{
					for (int i = 0; i <= game.getDrawFourCount(); i++)
					{
						game.submitDraw(players[game.getCurrentPlayerCounter()]);
						game.submitDraw(players[game.getCurrentPlayerCounter()]);
						game.submitDraw(players[game.getCurrentPlayerCounter()]);
						game.submitDraw(players[game.getCurrentPlayerCounter()]);
					}
					game.showAnsweredDrawFourDialog(game.getDrawFourCount());
					game.resetDrawFourCount();
					game.checkGameDirection();
				}	
			}	
			if (game.getLastStockPileCard().getValue().toString().equals("COLOR_CHANGE"))
			{
				for (Card c : currentPlayerHand)
				{
					if (c.getColor().equals(validColor))
					{
						currentPlayerHand.remove(currentPlayerHand.indexOf(c));
						gameOverCheck();
						setValidColor(c.getColor());
						setValidValue(c.getValue());
						game.setStockPile(c);
						game.checkGameDirection();
					}
					else if (c.getValue().equals(validValue))
					{
						currentPlayerHand.remove(currentPlayerHand.indexOf(c));
						gameOverCheck();
						setValidColor(game.getMostFrequentColor(players[game.getCurrentPlayerCounter()]));
						setValidValue(c.getValue());
						game.setStockPile(c);
						game.checkGameDirection();
					}
					else
						game.submitDraw(players[game.getCurrentPlayerCounter()]);
				}
			}
		}
		else if (game.getLastStockPileCard().getValue().toString().equals("DRAW_TWO"))
		{
			if(game.hasDrawTwo())
			{
				for (Card c : currentPlayerHand)
					if (c.getValue().toString().equals("DRAW_TWO"))
					{
						currentPlayerHand.remove(currentPlayerHand.indexOf(c));
						gameOverCheck();
						setValidColor(c.getColor());
						setValidValue(c.getValue());
						game.setStockPile(c);
						game.checkGameDirection();
						game.setDrawTwoCount();
					}
			}
			else 
			{
				for (int i = 0; i <= game.getDrawTwoCount(); i++)
				{
					game.submitDraw(players[game.getCurrentPlayerCounter()]);
					game.submitDraw(players[game.getCurrentPlayerCounter()]);
				}
				game.showAnsweredDrawTwoDialog(game.getDrawTwoCount());
				game.resetDrawTwoCount();
				game.checkGameDirection();
			}
		}
		else if(game.getLastStockPileCard().getValue().toString().equals("SKIP"))
		{
			game.checkGameDirection();
			game.showSkipDialog();
		}
		else if(game.getLastStockPileCard().getValue().toString().equals("REVERSE"))
		{
			game.showReverseDialog();
			
			game.gameDirection ^= true;
			if (game.gameDirection == true)
			{
				game.setCurrentPlayerCounter(game.getCurrentPlayerCounter()-2);
				if (game.getCurrentPlayerCounter() == -1)
					game.setCurrentPlayerCounter(players.length-1);
				if (game.getCurrentPlayerCounter() == -2)
					game.setCurrentPlayerCounter(players.length-2);
			}
			else if(game.gameDirection == false)
				game.setCurrentPlayerCounter(game.getCurrentPlayerCounter()+2);
		}
		else
		{
			for (Card c : currentPlayerHand)
			{
				if (c.getColor() == validColor)
				{
					currentPlayerHand.remove(currentPlayerHand.indexOf(c));
					gameOverCheck();
					game.setValidValue(c.getValue());
					game.setStockPile(c);
					game.checkGameDirection();
				}
				else if (c.getValue() == validValue)
				{
					currentPlayerHand.remove(currentPlayerHand.indexOf(c));
					gameOverCheck();
					game.setValidColor(c.getColor());
					game.setStockPile(c);
					game.checkGameDirection();
				}
			}
		}
	}
}
