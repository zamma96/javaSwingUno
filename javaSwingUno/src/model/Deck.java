package model;

import java.util.ArrayList;
import java.util.Random;


public class Deck 
{
	//made of 108 uno cards, 25 each color
	//+ 4 wildColor and 4 wildDraw4 cards
	
	private Card[] cards;
	private int cardsInDeck;
	
	public Deck()
	{
		cards = new Card[108];
	}
	
	/*
	 * Method that initialize the uno deck, filling all the values.
	 */
	public void reset()
	{
		Card.Color[] colors = Card.Color.values(); //fillig "colors" array with the different colors
		cardsInDeck = 0;
		
		for (int i = 0; i < colors.length-1; i++)
		{
			Card.Color color = colors[i];
			
			cards[cardsInDeck++] = new Card(color, Card.Value.getValue(0)); //putting all the 0s in the deck
		
			for (int j = 1; j < 10; j++)
			{
				cards[cardsInDeck++] = new Card(color, Card.Value.getValue(j)); //then all the other values twice, as the 
				cards[cardsInDeck++] = new Card(color, Card.Value.getValue(j)); //uno deck states.
			}
			
			Card.Value[] values = new Card.Value[] {Card.Value.DRAW_TWO, Card.Value.REVERSE, Card.Value.SKIP};
			for (Card.Value value: values)
			{
				cards[cardsInDeck++] = new Card(color, value);
				cards[cardsInDeck++] = new Card(color, value);
			}
			
		}
		
		Card.Value[] values = new Card.Value[] {Card.Value.DRAW_FOUR, Card.Value.COLOR_CHANGE};
		for(Card.Value value : values)
		{
			for(int i = 0; i<4; i++) 
			{
				cards[cardsInDeck++] = new Card(Card.Color.WILD, value);
			}
		}
		
	}
	
	public void resetTwoPlayers()
	{
		Card.Color[] colors = Card.Color.values(); //fillig "colors" array with the different colors
		cardsInDeck = 0;
		
		for (int i = 0; i < colors.length-1; i++)
		{
			Card.Color color = colors[i];
			
			cards[cardsInDeck++] = new Card(color, Card.Value.getValue(0)); //putting all the 0s in the deck
		
			for (int j = 1; j < 10; j++)
			{
				cards[cardsInDeck++] = new Card(color, Card.Value.getValue(j)); //then all the other values twice, as the 
				cards[cardsInDeck++] = new Card(color, Card.Value.getValue(j)); //uno deck states.
			}
			
			Card.Value[] values = new Card.Value[] {Card.Value.DRAW_TWO, Card.Value.SKIP, Card.Value.SKIP};
			for (Card.Value value: values)
			{
				cards[cardsInDeck++] = new Card(color, value);
				cards[cardsInDeck++] = new Card(color, value);
			}
			
		}
		
		Card.Value[] values = new Card.Value[] {Card.Value.DRAW_FOUR, Card.Value.COLOR_CHANGE};
		for(Card.Value value : values)
		{
			for(int i = 0; i<4; i++) 
			{
				cards[cardsInDeck++] = new Card(Card.Color.WILD, value);
			}
		}
		
	}
	
	/**
	 * @param ArrayList<Card> cards (StockPile)
	 * replace the deck with an ArrayList of Uno Cards
	 */
	
	public void replaceDeckWith(ArrayList<Card> cards)
	{
		this.cards = cards.toArray(new Card[cards.size()]);
		this.cardsInDeck = this.cards.length;
	}
	
	public boolean isEmpty()
	{
		return cardsInDeck == 0;
	}
	
	/**
	 * Method that shuffles the deck;
	 */
	public void shuffle()
	{
		int l = cards.length;
		Random random = new Random();
		/**
		 * Get a random index of the array after the current index
		 * Swap the random element with the present element
		 */
		for (int i = 0; i < l; i++)
		{
			int rValue = random.nextInt(l-i) + i;
			Card randomCard = cards[rValue];
			cards[rValue] = cards[i];
			cards[i] = randomCard;
		}
	}
	
	public Card drawCard() throws IllegalArgumentException
	{
		if (isEmpty())
			throw new IllegalArgumentException("Cannot draw a card since the deck is empty");
		return cards[--cardsInDeck];
	}
	
	public Card[] drawCard(int a)
	{
		if (a < 0)
			throw new IllegalArgumentException("Just draw positive cards but tried to draw " + a + " cards.");
		if (a > cardsInDeck)
			throw new IllegalArgumentException("Cannot draw " + a + " cards since there are only " + cardsInDeck + " cards left in the deck");
		
		Card[] drawn = new Card[a];
		
		//Da implementare i casi in cui le carte da pescare siano più di una e le carte rimaste nel deck meno di quelle da pescare.
		/*
		 * if ((a == 1) && (cardsInDeck == 1)) 
		 * { 
		 * 		drawn[0] = cards[--cardsInDeck]; reset(); shuffle(); 
		 * }
		 * if (a > cardsInDeck) 
		 * {
		 * 		int flag = cardsInDeck;
		 * 		while (a <= cardsInDeck)
		 * 		{
		 * 			drawn[i] == cards[--cardsInDeck];
		 * 			reset(); shuffle();
		 * 		} 
		 * 		for(int j = flag; j < a; j++)
		 * 			drawn[j] == cards[--carsInDeck]
		 * }
		 */
		
		for (int i = 0; i < a; i++)
			drawn[i] = cards[--cardsInDeck];
		return drawn;
		
	}
}
