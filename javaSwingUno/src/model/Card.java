package model;

public class Card 
{	
	public enum Color
	{
		RED, YELLOW, GREEN, BLUE, WILD;
		
		private final static Color[] colors = Color.values();
		public static Color getColor(int i)
		{
			return Color.colors[i];
		}
	}
	
	public enum Value 
	{
		ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, DRAW_TWO, SKIP, REVERSE, DRAW_FOUR, COLOR_CHANGE;
		
		private final static Value[] values = Value.values();
		public static Value getValue(int i)
		{
			return values[i];
		}
	}

	public final Color color;
	public final Value value;
	
	public Card(Color color, Value value)
	{
		this.color = color;
		this.value = value;
	}
	
	public Card.Color getColor()
	{
		if (this.color.equals(Card.Color.RED))
			return Card.Color.RED;
		else if (this.color.equals(Card.Color.BLUE))
			return Card.Color.BLUE;
		else if (this.color.equals(Card.Color.GREEN))
			return Card.Color.GREEN;
		else if (this.color.equals(Card.Color.YELLOW))
			return Card.Color.YELLOW;
		else
			return Card.Color.WILD;
	}
	
	public Card.Value getValue()
	{
		if (this.value.equals(Card.Value.ZERO))
			return Card.Value.ZERO;
		else if (this.value.equals(Card.Value.ONE))
			return Card.Value.ONE;
		else if (this.value.equals(Card.Value.TWO))
			return Card.Value.TWO;
		else if (this.value.equals(Card.Value.THREE))
			return Card.Value.THREE;
		else if (this.value.equals(Card.Value.FOUR))
			return Card.Value.FOUR;
		else if (this.value.equals(Card.Value.FIVE))
			return Card.Value.FIVE;
		else if (this.value.equals(Card.Value.SIX))
			return Card.Value.SIX;
		else if (this.value.equals(Card.Value.SEVEN))
			return Card.Value.SEVEN;
		else if (this.value.equals(Card.Value.EIGHT))
			return Card.Value.EIGHT;
		else if (this.value.equals(Card.Value.NINE))
			return Card.Value.NINE;
		else if (this.value.equals(Card.Value.DRAW_TWO))
			return Card.Value.DRAW_TWO;
		else if (this.value.equals(Card.Value.SKIP))
			return Card.Value.SKIP;
		else if (this.value.equals(Card.Value.REVERSE))
			return Card.Value.REVERSE;
		else if (this.value.equals(Card.Value.DRAW_FOUR))
			return Card.Value.DRAW_FOUR;
		else
			return Card.Value.COLOR_CHANGE;
	}
	
	@Override
	public String toString()
	{
		return color + "_" + value;
	}
	
}
