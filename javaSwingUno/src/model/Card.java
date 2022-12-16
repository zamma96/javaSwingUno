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
		return this.color;
	}
	
	public Card.Value getValue()
	{
		return this.value;
	}
	
	@Override
	public String toString()
	{
		return color + "_" + value;
	}
	
}
