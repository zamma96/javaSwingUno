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
			
			game.reverseRoutine();
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
	
	public void submitPlayerCard(Card card) throws InvalidColorSubmissionException, InvalidPlayerTurnException, InvalidValueSubmissionException
	{
		ArrayList<Card> currentPlayerHand = game.getPlayerHand(players[game.getCurrentPlayerCounter()]);
		validColor = game.getLastStockPileCard().getColor();
		validValue = game.getLastStockPileCard().getValue();
		
		if (game.getLastStockPileCard().getColor().equals(Card.Color.WILD))	
		{
			if (game.getLastStockPileCard().getValue().equals(Card.Value.DRAW_FOUR))
			{
				if (game.hasDrawFour())
				{
					for (Card c : currentPlayerHand)
						if (c.toString().equals("WILD_DRAW_FOUR"))
							game.answerDrawFourDialog(c);
				}
				if (!game.hasDrawFour())
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
			if (game.getLastStockPileCard().getValue().equals(Card.Value.COLOR_CHANGE))
			{
				if (!game.validCardPlay(card))
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
							game.colorChangeDialog();
						}
						else
							game.showInvalidPlayerMoveValueDialog(card);
					}
					else
						game.showInvalidPlayerMoveColorDialog(card);
				}
			}
		}
		if (game.getLastStockPileCard().getValue().equals(Card.Value.DRAW_TWO))
		{
			if (game.hasDrawTwo())
			{
				for (Card c : currentPlayerHand)
					if (c.getValue().toString().equals("DRAW_TWO"))
						game.answerDrawTwoDialog(c);
			}
			if (!game.hasDrawTwo())
			{
				for (int i = 0; i<= game.getDrawTwoCount(); i++)
				{
					game.submitDraw(players[game.getCurrentPlayerCounter()]);
					game.submitDraw(players[game.getCurrentPlayerCounter()]);
				}
				game.showAnsweredDrawTwoDialog(game.getDrawTwoCount());
				game.resetDrawTwoCount();
				game.checkGameDirection();
			}
		}
		if (game.getLastStockPileCard().getValue().equals(Card.Value.SKIP))
		{
			game.checkGameDirection();
			game.showSkipDialog();
		}
		if (game.getLastStockPileCard().getValue().equals(Card.Value.REVERSE))
		{
			game.showReverseDialog();
			game.reverseRoutine();
		}
		else
		{
			if (!game.validCardPlay(card))
				game.showInvalidPlayerMoveColorDialog(card);
			else
			{
				currentPlayerHand.remove(card);
				gameOverCheck();
				game.setValidColor(card.getColor());
				game.setValidValue(card.getValue());
				game.setStockPile(card);
				game.checkGameDirection();
			}
		}
	}
}
