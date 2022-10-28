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
	
	public Color getColor()
	{
		return this.color;
	}
	
	public Value getValue()
	{
		return this.value;
	}
	
	@Override
	public String toString()
	{
		return color + "_" + value;
	}
	
    /**
     * Gets the score based on the faceValue of the card.
     * Numbered cards are their face value, wild and +4 are worth 50,
     * and others are worth 20.
     *
     * @return The calculated score for this card.
     */
    public int getScoreValue() 
    {
        if(this.value == Card.Value.ONE || (this.value == Card.Value.TWO) || (this.value == Card.Value.THREE) ||
        		(this.value == Card.Value.FOUR) || (this.value == Card.Value.FIVE) || (this.value == Card.Value.SIX) ||
        		(this.value == Card.Value.SEVEN) || (this.value == Card.Value.EIGHT) || (this.value == Card.Value.NINE))
        	return 10;
        else if(this.getValue() == Card.Value.DRAW_FOUR || this.getValue() == Card.Value.COLOR_CHANGE) return 50;
        else return 20;
    }
}
