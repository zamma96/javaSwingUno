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
    private JButton StockPileButton;
    private Card.Color declaredColor;
    
    
    public PopUp(){}
    public PopUp(String cardName, Game game, int index, ArrayList<JButton> cardButtons, GameStage gameStage, JButton StockPileButton) 
    {
        initComponents();
        //in teoria declaredColor viene aggiornato subito dopo che viene settato il declaredColor nel model
        declaredColor = game.getTopCard().getColor();
        this.cardImage = cardName;
        this.game = game;
        this.playerHand = game.getPlayerHand(game.getCurrentPlayer());
        this.choice = index;
        this.cardButtons = cardButtons;
        Icon icon = new ImageIcon(".\\resources\\Images\\" + cardImage + ".png");
        CardLabel.setIcon(icon);
        this.gameStage = gameStage;
        this.StockPileButton = StockPileButton;
    }
     
    //forse tocca fare model anche di popUp
    
    public JButton getStockPileButton()
    {
    	return StockPileButton;
    }
    
    public JButton getUseCardButton()
    {
    	return UseCardButton;
    }
    
    public JButton getCancelButton()
    {
    	return CancelButton;
    }
    
    public String getCardImage() 
    {
    	return cardImage;
    }
    
    public JLabel getCardLabel()
    {
    	return CardLabel;
    }
    
	public int getChoice() 
	{
		return choice;
	}
    
    private void initComponents() 
    {
        jPanel1 = new JPanel();
        CancelButton = new JButton();
        UseCardButton = new JButton();
        CardLabel = new JLabel();

        jPanel1.setBackground(new Color(53,101,77));
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setPreferredSize(new java.awt.Dimension(500, 500));

        CancelButton.setFont(new java.awt.Font("Comic Sans MS", Font.BOLD, 18));
        CancelButton.setText("Cancel");
		CancelButton.setBackground(new Color(53,101,77));
		CancelButton.setForeground(new Color(255, 145, 164));

        UseCardButton.setFont(new java.awt.Font("Comic Sans MS", Font.BOLD, 18));
        UseCardButton.setText("Use card");
		UseCardButton.setBackground(new Color(53,101,77));
		UseCardButton.setForeground(new Color(255, 145, 164));

        CardLabel.setPreferredSize(new java.awt.Dimension(190, 300));
        
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
		if (arg.getClass().getName() == "Card.Color")
			this.declaredColor = (Card.Color)arg;

		
	}
}
