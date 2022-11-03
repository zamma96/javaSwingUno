package view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;
import java.util.stream.Collectors;
import javax.swing.*;
import model.InvalidPlayerTurnException;
import model.InvalidValueSubmissionException;
import model.User;
import model.Card;
import model.Game;
import model.InvalidColorSubmissionException;

public class GameStage extends JFrame implements Observer 
{
	private User user;
	private String[] playerIds = new String[4];
	private Game game;
	private ArrayList<JButton> cardButtons = new ArrayList<JButton>();
	private ArrayList<String> cardIds;
	private Card lastCard;

	/* Double constructors for both ways of creating a new gameStage */

	public GameStage(Game model) 
	{
		this.game = model;
		initComponents();
		populateArrayList();
		game.start(game);
		//setButtonIcons();
		this.lastCard = model.getLastStockPileCard();
		this.playerIds = model.getPlayersNames();
	}
	
	/**
	 * 
	 * @return StockPileButton;
	 */
	public JButton getStockPileButton()
	{
		return StockPileButton;
	}
	
	/**
	 * 
	 * @return DeckPileButton;
	 */
	public JButton getDeckPileButton()
	{
		return DeckPileButton;
	}
	
	public void setLastCard(Card card)
	{
		this.lastCard = card;
	}
	
	/**
	 * use of stream to trasform an ArrayList<Card> into a String list;
	 * this method sets all user's button icons to show the proper card
	 * and the other buttons are set to null
	 */
	public void setButtonIcons() 
	{
		String listString = (game.getPlayerHand(game.getHumanPlayer())
				.stream().map(Object::toString)
				.collect(Collectors.joining(",")));
		String[] cardNames = listString.split(",");
		game.setCardIds(new ArrayList<>(Arrays.asList(cardNames)));
		for (int i = 0; i < cardIds.size(); i++) 
		{
			Icon iconH = new ImageIcon(".\\resources\\UnoCards\\" + cardIds.get(i) + ".png");
			cardButtons.get(i).setIcon(iconH);
		}
		for (int i = cardIds.size(); i < cardButtons.size(); i++) 
		{	
			cardButtons.get(i).setIcon(null);
			cardButtons.get(i).setBackground(new Color(53, 101, 77));
		}	
	}

	public void setCardIds(ArrayList<String> cardIds)
	{
		this.cardIds = cardIds;
	}
	
	public void populateArrayList() {
		cardButtons.add(jButton1);
		cardButtons.add(jButton2);
		cardButtons.add(jButton3);
		cardButtons.add(jButton4);
		cardButtons.add(jButton5);
		cardButtons.add(jButton6);
		cardButtons.add(jButton7);
		cardButtons.add(jButton8);
		cardButtons.add(jButton9);
		cardButtons.add(jButton10);
		cardButtons.add(jButton11);
		cardButtons.add(jButton12);
		cardButtons.add(jButton13);
		cardButtons.add(jButton14);
		cardButtons.add(jButton15);
		cardButtons.add(jButton16);

	}
	
	public JLabel getPlayerIdName()
	{
		return playerIdNameLabel;
	}

	public JLabel getIaNameLabel1()
	{
		return iaNameLabel1;
	}
	
	public JLabel getIaNameLabel2()
	{
		return iaNameLabel2;
	}
	
	public JLabel getIaNameLabel3()
	{
		return iaNameLabel3;
	}

	public void setUser(User user)
	{
		this.user = user;
	}
	
	public JButton getjButton1()
	{
		return jButton1;
	}
	
	public JButton getjButton2()
	{
		return jButton2;
	}
	
	public JButton getjButton3()
	{
		return jButton3;
	}

	public JButton getjButton4()
	{
		return jButton4;
	}
	
	public JButton getjButton5()
	{
		return jButton5;
	}
	
	public JButton getjButton6()
	{
		return jButton6;
	}
	
	public JButton getjButton7()
	{
		return jButton7;
	}
	
	public JButton getjButton8()
	{
		return jButton8;
	}
	
	public JButton getjButton9()
	{
		return jButton9;
	}
	
	public JButton getjButton10()
	{
		return jButton10;
	}
	
	public JButton getjButton11()
	{
		return jButton11;
	}
	
	public JButton getjButton12()
	{
		return jButton12;
	}
	
	public JButton getjButton13()
	{
		return jButton13;
	}
	
	public JButton getjButton14()
	{
		return jButton14;
	}
	
	public JButton getjButton15()
	{
		return jButton15;
	}
	
	public JButton getjButton16()
	{
		return jButton16;
	}
	
	public JPanel getjPanel1()
	{
		return jPanel1;
	}
	
	public JButton getDrawCardButton()
	{
		return drawCardButton;
	}
	
	private void initComponents() {

        jPanel1 = new JPanel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jButton6 = new JButton();
        jButton7 = new JButton();
        jButton8 = new JButton();
        jButton9 = new JButton();
        jButton10 = new JButton();
        jButton11 = new JButton();
        jButton12 = new JButton();
        jButton13 = new JButton();
        jButton14 = new JButton();
        jButton15 = new JButton();
        jButton16 = new JButton();
        playerIdNameLabel = new JLabel();
        drawCardButton = new JButton();
        DeckPileButton = new JButton();
        StockPileButton = new JButton();
        iaNameLabel1 = new JLabel();
        iaNameLabel3 = new JLabel();
        iaNameLabel2 = new JLabel();


        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(8, 8, 8)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(playerIdNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(drawCardButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(DeckPileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(StockPileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(328, 328, 328)
                            .addComponent(iaNameLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(iaNameLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iaNameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DeckPileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(StockPileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(iaNameLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iaNameLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iaNameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(131, 131, 131)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(playerIdNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(drawCardButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
	
	/*
	 * private void initComponents() {
	 * 
	 * jPanel1 = new JPanel(); jButton1 = new JButton(); jButton2 = new JButton();
	 * jButton3 = new JButton(); jButton4 = new JButton(); jButton5 = new JButton();
	 * jButton6 = new JButton(); jButton7 = new JButton(); jButton8 = new JButton();
	 * jButton9 = new JButton(); jButton10 = new JButton(); jButton11 = new
	 * JButton(); jButton12 = new JButton(); jButton13 = new JButton(); jButton14 =
	 * new JButton(); jButton15 = new JButton(); jButton16 = new JButton();
	 * playerIdNameLabel = new JLabel(); drawCardButton = new JButton();
	 * DeckPileButton = new JButton(); StockPileButton = new JButton(); iaNameLabel1
	 * = new JLabel(); iaNameLabel2 = new JLabel(); iaNameLabel3 = new JLabel();
	 * 
	 * javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
	 * jPanel1.setLayout(jPanel1Layout);
	 * jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.
	 * swing.GroupLayout.Alignment.LEADING)
	 * .addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
	 * .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	 * .addGroup(jPanel1Layout.createSequentialGroup().addGap(35, 35, 35)
	 * .addGroup(jPanel1Layout
	 * .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	 * .addGroup(jPanel1Layout.createSequentialGroup() .addComponent(jButton1,
	 * javax.swing.GroupLayout.PREFERRED_SIZE, 70,
	 * javax.swing.GroupLayout.PREFERRED_SIZE)
	 * .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	 * .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
	 * javax.swing.GroupLayout.PREFERRED_SIZE)
	 * .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	 * .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
	 * javax.swing.GroupLayout.PREFERRED_SIZE) .addGap(8, 8, 8)
	 * .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
	 * javax.swing.GroupLayout.PREFERRED_SIZE)
	 * .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	 * .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
	 * javax.swing.GroupLayout.PREFERRED_SIZE)
	 * .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	 * .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
	 * javax.swing.GroupLayout.PREFERRED_SIZE)
	 * .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	 * .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
	 * javax.swing.GroupLayout.PREFERRED_SIZE)
	 * .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	 * .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
	 * javax.swing.GroupLayout.PREFERRED_SIZE)) .addComponent(playerIdNameLabel,
	 * javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
	 * Short.MAX_VALUE))
	 * .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	 * .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
	 * javax.swing.GroupLayout.PREFERRED_SIZE)
	 * .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	 * .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
	 * javax.swing.GroupLayout.PREFERRED_SIZE)
	 * .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	 * .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
	 * javax.swing.GroupLayout.PREFERRED_SIZE)
	 * .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	 * .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
	 * javax.swing.GroupLayout.PREFERRED_SIZE)
	 * .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	 * .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
	 * javax.swing.GroupLayout.PREFERRED_SIZE)
	 * .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	 * .addGroup(jPanel1Layout
	 * .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	 * .addGroup(jPanel1Layout.createSequentialGroup() .addComponent(jButton14,
	 * javax.swing.GroupLayout.PREFERRED_SIZE, 70,
	 * javax.swing.GroupLayout.PREFERRED_SIZE)
	 * .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	 * .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
	 * javax.swing.GroupLayout.PREFERRED_SIZE)
	 * .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	 * .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
	 * javax.swing.GroupLayout.PREFERRED_SIZE)) .addComponent(drawCardButton,
	 * javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
	 * Short.MAX_VALUE)))
	 * .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
	 * .addComponent(DeckPileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
	 * javax.swing.GroupLayout.PREFERRED_SIZE)
	 * .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	 * .addComponent(StockPileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
	 * javax.swing.GroupLayout.PREFERRED_SIZE)))
	 * .addGroup(jPanel1Layout.createSequentialGroup() .addGap(67, 67, 67)
	 * .addComponent(iaNameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
	 * javax.swing.GroupLayout.PREFERRED_SIZE)
	 * .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
	 * javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	 * .addComponent(iaNameLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
	 * javax.swing.GroupLayout.PREFERRED_SIZE) .addGap(34, 34, 34))
	 * .addContainerGap(33, Short.MAX_VALUE))
	 * .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment
	 * .LEADING) .addGroup(jPanel1Layout.createSequentialGroup() .addGap(488, 488,
	 * 488) .addComponent(iaNameLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
	 * javax.swing.GroupLayout.PREFERRED_SIZE) .addContainerGap(492,
	 * Short.MAX_VALUE))));
	 * jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.
	 * GroupLayout.Alignment.LEADING)
	 * .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
	 * .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment
	 * .LEADING, false) .addComponent(DeckPileButton,
	 * javax.swing.GroupLayout.PREFERRED_SIZE, 100,
	 * javax.swing.GroupLayout.PREFERRED_SIZE) .addComponent(StockPileButton,
	 * javax.swing.GroupLayout.PREFERRED_SIZE, 100,
	 * javax.swing.GroupLayout.PREFERRED_SIZE))
	 * .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 433,
	 * Short.MAX_VALUE)
	 * .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment
	 * .LEADING, false) .addComponent(playerIdNameLabel,
	 * javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
	 * Short.MAX_VALUE) .addComponent(drawCardButton,
	 * javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
	 * Short.MAX_VALUE)) .addGap(18, 18, 18)
	 * .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment
	 * .LEADING, false) .addComponent(jButton1,
	 * javax.swing.GroupLayout.Alignment.TRAILING,
	 * javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
	 * Short.MAX_VALUE) .addComponent(jButton2,
	 * javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
	 * Short.MAX_VALUE) .addComponent(jButton3,
	 * javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
	 * Short.MAX_VALUE) .addComponent(jButton4,
	 * javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
	 * Short.MAX_VALUE) .addComponent(jButton5,
	 * javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
	 * Short.MAX_VALUE) .addComponent(jButton6,
	 * javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
	 * Short.MAX_VALUE) .addComponent(jButton7,
	 * javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
	 * Short.MAX_VALUE) .addComponent(jButton8,
	 * javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
	 * Short.MAX_VALUE) .addComponent(jButton9,
	 * javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
	 * Short.MAX_VALUE) .addComponent(jButton10,
	 * javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
	 * Short.MAX_VALUE) .addComponent(jButton11,
	 * javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
	 * Short.MAX_VALUE) .addComponent(jButton12,
	 * javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
	 * Short.MAX_VALUE) .addComponent(jButton13,
	 * javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
	 * Short.MAX_VALUE) .addComponent(jButton14,
	 * javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
	 * Short.MAX_VALUE) .addComponent(jButton15,
	 * javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
	 * Short.MAX_VALUE) .addComponent(jButton16,
	 * javax.swing.GroupLayout.Alignment.TRAILING,
	 * javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
	 * Short.MAX_VALUE)) .addContainerGap()));
	 * 
	 * javax.swing.GroupLayout layout = new
	 * javax.swing.GroupLayout(getContentPane());
	 * getContentPane().setLayout(layout);
	 * layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.
	 * Alignment.LEADING).addComponent( jPanel1,
	 * javax.swing.GroupLayout.Alignment.TRAILING,
	 * javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
	 * Short.MAX_VALUE));
	 * layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.
	 * Alignment.LEADING).addComponent( jPanel1,
	 * javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
	 * Short.MAX_VALUE));
	 * 
	 * pack(); }
	 */

	private JPanel jPanel1;
	private JButton DeckPileButton;
	private JButton StockPileButton;
	private JButton drawCardButton;
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButton5;
	private JButton jButton6;
	private JButton jButton7;
	private JButton jButton8;
	private JButton jButton9;
	private JButton jButton10;
	private JButton jButton11;
	private JButton jButton12;
	private JButton jButton13;
	private JButton jButton14;
	private JButton jButton15;
	private JButton jButton16;
	private JLabel playerIdNameLabel;
    private JLabel iaNameLabel1;
    private JLabel iaNameLabel2;
    private JLabel iaNameLabel3;
	
    
    public void run() throws InvalidPlayerTurnException, InvalidColorSubmissionException, InvalidValueSubmissionException, InterruptedException
    {
    	while (this != null)
    	{
    		int currentPlayer = game.getCurrentPlayerCounter();
    		//1. update
    		//2. draw
    		if (game.getPlayers()[currentPlayer].isHuman() == false)
    		{
    			game.submitAICard();
    		}
    	}
    }
    
	@Override
	public void update(Observable o, Object arg) 
	{
		if (arg.getClass().getName().equals("model.User"))
			setUser((User)arg);
		else if(arg.getClass().getName().equals("javax.swing.ImageIcon"))
			StockPileButton.setIcon((Icon)arg);
		else if(arg.getClass().getName().equals("java.util.ArrayList"))
			setCardIds((ArrayList<String>)arg);
		else if(arg.getClass().getName().equals("model.Card"))
			setLastCard((Card) arg);
		
	}
}
