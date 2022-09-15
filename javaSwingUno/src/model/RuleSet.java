package model;

public class RuleSet 
{
    /**
     * True if +2 and +4 cards can be stacked in response.
     */
    private boolean canStackCards;
    /**
     * The time player's have to make their choice during actions.
     */
    private final int defaultTimeOut;
    /**
     * Used to determine if Reverse becomes a skip when true.
     */
    private boolean onlyTwoPlayers;

    /**
     * Initialises a default RuleSet.
     */
    public RuleSet() 
    {
        defaultTimeOut = 25;
        setToDefaults();
    }

    public void setToDefaults() 
    {
        setCanStackCards(true);
        setTwoPlayers(false);
    }

    /**
     * Checks whether +2 and +4 cards can be played in response to other +2 and +4 cards.
     *
     * @return True if +2 and +4 cards can be stacked in response.
     */
    public boolean canStackCards() 
    {
        return canStackCards;
    }

    /**
     * Changes the state of card stacking.
     *
     * @param canStackCards When true +2 and +4 cards can be stacked in response.
     */
    public void setCanStackCards(boolean canStackCards) 
    {
        this.canStackCards = canStackCards;
    }
    
    /**
     * Gets the time in seconds that can be spent maximum for any individual action.
     *
     * @return The time player's have to make their choice during actions.
     */
    public int getDefaultTimeOut()
    {
        return defaultTimeOut;
    }

    /**
     * Sets the state of whether there are only two players.
     *
     * @param onlyTwoPlayers When true Reverse becomes a skip.
     */
    public void setTwoPlayers(boolean onlyTwoPlayers) 
    {
        this.onlyTwoPlayers = onlyTwoPlayers;
        Deck deck  = new Deck();
        deck.resetTwoPlayers();
    }

    /**
     * Gets the current state of the two players.
     *
     * @return True if the only two player rules are active with Reverse set to a skip.
     */
    public boolean getOnlyTwoPlayers() 
    {
        return onlyTwoPlayers;
    }

}
