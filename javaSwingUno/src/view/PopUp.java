package view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Card;
import model.Game;
import model.InvalidColorSubmissionException;
import model.InvalidPlayerTurnException;
import model.InvalidValueSubmissionException;

/**
 *
 * @author matte
 */
public class PopUp extends JFrame implements Observer
{

    private String cardImage = "";
    private Game game;
    private ArrayList<Card> playerHand;
    private int choice;
    private ArrayList<JButton> cardButtons;
    private GameStage gameStage;
    private Card.Color validColor;
    private Card choosenCard;
    
    
    /**
     * 
     * @param cardName
     * @param game
     * @param index
     * @param cardButtons
     * @param gameStage
     * 
     * Constructor, sets class fields to the params specified 
     * 
     */
    public PopUp(String cardName, Game game, ArrayList<JButton> cardButtons, GameStage gameStage) 
    {
        initComponents();
        this.validColor = game.getValidColor();
        this.cardImage = cardName;
        this.game = game;
        this.playerHand = game.getPlayerHand(game.getCurrentPlayer());
        this.cardButtons = cardButtons;
        this.gameStage = gameStage;
    }
     
    /**
     * 
     * @return UseCardButton variable
     */
    public JButton getUseCardButton()
    {
    	return UseCardButton;
    }
    
    /**
     * 
     * @return CancelButton variable
     */
    public JButton getCancelButton()
    {
    	return CancelButton;
    }
    
    /**
     * 
     * @return cardImage variable
     */
    public String getCardImage() 
    {
    	return cardImage;
    }
    
    /**
     * 
     * @return CardLabel variable
     */
    public JLabel getCardLabel()
    {
    	return CardLabel;
    }
    
    /**
     * 
     * @return choice variable
     */
	public int getChoice() 
	{
		return choice;
	}
	
	public Card getChoosenCard()
	{
		return choosenCard;
	}
	
	/**
	 * 
	 * @return jPanel1 variable
	 */
	public JPanel getjPanel1()
	{
		return jPanel1;
	}
    
    private void initComponents() 
    {
        jPanel1 = new JPanel();
        CancelButton = new JButton();
        UseCardButton = new JButton();
        CardLabel = new JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(UseCardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(CardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(250, 250, 250))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(CardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UseCardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }               

                 
    private JButton CancelButton;
    private JLabel CardLabel;
    private JButton UseCardButton;
    private JPanel jPanel1;    


	@Override
	public void update(Observable o, Object arg) 
	{
		if (arg.getClass().getName().equals("Card.Color"))
			this.validColor = (Card.Color)arg;
		if (arg.getClass().getName().equals("java.lang.Integer"))
			this.choice = (Integer)arg;
		if (arg.getClass().getName().equals("model.Card"))
				this.choosenCard = (Card)arg;
	}
}
