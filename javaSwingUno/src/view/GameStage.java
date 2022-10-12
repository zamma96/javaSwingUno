/*
 * package view;
 * 
 * import java.util.Observable; import java.util.Observer;
 * 
 * import javax.swing.JFrame;
 * 
 * import model.User;
 * 
 * public class GameStage extends JFrame implements Observer { private User
 * user;
 * 
 * public GameStage(User user) { this.user = user; }
 * 
 * @Override public void update(Observable o, Object arg) {
 * 
 * }
 * 
 * }
 */

package view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.*;
import java.util.stream.Collectors;
import javax.swing.*;
import model.InvalidPlayerTurnException;
import model.User;
import model.Game;

public class GameStage extends javax.swing.JFrame {
	private User user;
	ArrayList<String> temp = new ArrayList<>();
	String[] playerIds = new String[4];
	Game game;
	ArrayList<JButton> cardButtons = new ArrayList<JButton>();
	ArrayList<String> cardIds;
	// PopUp window;

	/* Double constructors for both ways of creating a new gameStage */

	public GameStage(User user) {}

	public GameStage(ArrayList<String> playerIds) {
		initComponents();
		temp = playerIds;
		this.playerIds = temp.toArray(new String[temp.size()]);
		game = new Game(user);
		populateArrayList();
		game.start(game);
		setPlayerIdName();
		Icon icon = new ImageIcon(".\\resources\\UnoCards\\CARD_BACK.png");
		Icon iconS = new ImageIcon(".\\resources\\UnoCards\\" + game.getTopCardImage());
		StockPileButton.setIcon(iconS);
		DeckPileButton.setIcon(icon);
		setButtonIcons();
	}

	public void setButtonIcons() 
	{
		/*
		 * Using stream to transform an ArrayList<Card> into a String list
		 */

		String listString = (game.getPlayerHand(game.getCurrentPlayer())).stream().map(Object::toString)
				.collect(Collectors.joining(","));
		String[] cardNames = listString.split(",");
		cardIds = new ArrayList<>(Arrays.asList(cardNames));
		/*
		 * Setting all card icons in that particular player's hand when is it's turn
		 */
		for (int i = 0; i < cardIds.size(); i++) {
			Icon iconH = new ImageIcon(".\\resources\\UnoCards\\" + cardIds.get(i) + ".png");
			cardButtons.get(i).setIcon(iconH);
		}
		/*
		 * setting all the card Icons to null if they are not in the player's hand.
		 */
		for (int i = cardIds.size(); i < cardButtons.size(); i++) {
			cardButtons.get(i).setIcon(null);
		}
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

	public void setPlayerIdName() {
		String currentPlayer = game.getCurrentPlayer().getPlayerNickName();
		playerIdNameLabel.setForeground(new Color(255, 145, 164));
		playerIdNameLabel.setText(currentPlayer + "'s cards");
	}

	public void setPlayerIdName(String currentPlayer) {
		playerIdNameLabel.setText(currentPlayer + "'s cards");
		playerIdNameLabel.setForeground(new Color(255, 145, 164));
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		jButton7 = new javax.swing.JButton();
		jButton8 = new javax.swing.JButton();
		jButton9 = new javax.swing.JButton();
		jButton10 = new javax.swing.JButton();
		jButton11 = new javax.swing.JButton();
		jButton12 = new javax.swing.JButton();
		jButton13 = new javax.swing.JButton();
		jButton14 = new javax.swing.JButton();
		jButton15 = new javax.swing.JButton();
		jButton16 = new javax.swing.JButton();
		playerIdNameLabel = new javax.swing.JLabel();
		drawCardButton = new javax.swing.JButton();
		DeckPileButton = new javax.swing.JButton();
		StockPileButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("UNO");
		setResizable(false);

		jPanel1.setToolTipText("");
		jPanel1.setBackground(new Color(53, 101, 77));
		jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jButton1.setBackground(new Color(53, 101, 77));

		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		jButton2.setBackground(new Color(53, 101, 77));

		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});
		jButton3.setBackground(new Color(53, 101, 77));

		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});
		jButton4.setBackground(new Color(53, 101, 77));

		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});
		jButton5.setBackground(new Color(53, 101, 77));

		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});
		jButton6.setBackground(new Color(53, 101, 77));

		jButton7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});
		jButton7.setBackground(new Color(53, 101, 77));

		jButton8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton8ActionPerformed(evt);
			}
		});
		jButton8.setBackground(new Color(53, 101, 77));

		jButton9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton9ActionPerformed(evt);
			}
		});
		jButton9.setBackground(new Color(53, 101, 77));

		jButton10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton10ActionPerformed(evt);
			}
		});
		jButton10.setBackground(new Color(53, 101, 77));

		jButton11.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton11ActionPerformed(evt);
			}
		});
		jButton11.setBackground(new Color(53, 101, 77));

		jButton12.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton12ActionPerformed(evt);
			}
		});
		jButton12.setBackground(new Color(53, 101, 77));

		jButton13.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton13ActionPerformed(evt);
			}
		});
		jButton13.setBackground(new Color(53, 101, 77));

		jButton14.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton14ActionPerformed(evt);
			}
		});
		jButton14.setBackground(new Color(53, 101, 77));

		jButton15.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton15ActionPerformed(evt);
			}
		});
		jButton15.setBackground(new Color(53, 101, 77));

		jButton16.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton16ActionPerformed(evt);
			}
		});
		jButton16.setBackground(new Color(53, 101, 77));

		playerIdNameLabel.setFont(new java.awt.Font("Comic Sans MS", Font.BOLD, 48));

		drawCardButton.setFont(new java.awt.Font("Comic Sans MS", Font.BOLD, 36));
		drawCardButton.setForeground(new Color(255, 145, 164));
		drawCardButton.setBackground(new Color(53, 101, 77));
		drawCardButton.setText("draw card");
		drawCardButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				drawCardButtonActionPerformed(evt);
			}
		});

		DeckPileButton.setPreferredSize(new java.awt.Dimension(100, 70));

		StockPileButton.setPreferredSize(new java.awt.Dimension(100, 70));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(35, 35, 35)
								.addGroup(jPanel1Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(8, 8, 8)
												.addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(playerIdNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel1Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(drawCardButton, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
								.addComponent(DeckPileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(StockPileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(33, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(DeckPileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(StockPileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 433, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(playerIdNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(drawCardButton, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButton16, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}

	private void drawCardButtonActionPerformed(java.awt.event.ActionEvent evt) {
		JLabel message = new JLabel(game.getCurrentPlayer() + " drew a card");
		message.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
		message.setBackground(new Color(53, 101, 77));
		message.setForeground(new Color(255, 145, 164));
		JOptionPane.showMessageDialog(null, message);
		try {
			game.submitDraw(game.getCurrentPlayer());
		} catch (InvalidPlayerTurnException ex) {
			Logger.getLogger(GameStage.class.getName()).log(Level.SEVERE, null, ex);
		}
		this.setPlayerIdName(game.getCurrentPlayer().getPlayerNickName());
		this.setButtonIcons();
	}

	//da implementare classe popup per scelta carta,
	//attenzione al limite di carte in mano, per questo codice 15, aumentare?
	
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		if (cardIds.get(0) != null) {
			int index = 0;
			String cardId = cardIds.get(0);
			window = new PopUp(cardId, game, index, cardButtons, this, DeckPileButton, StockPileButton);
			window.setBounds(750, 40, 700, 800);
			window.setVisible(true);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		if (cardIds.get(1) != null) {
			int index = 1;
			String cardId = cardIds.get(1);
			window = new PopUp(cardId, game, index, cardButtons, this, DeckPileButton, StockPileButton);
			window.setBounds(750, 40, 700, 800);
			window.setVisible(true);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		if (cardIds.get(2) != null) {
			int index = 2;
			String cardId = cardIds.get(2);
			window = new PopUp(cardId, game, index, cardButtons, this, DeckPileButton, StockPileButton);
			window.setBounds(750, 40, 700, 800);
			window.setVisible(true);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		if (cardIds.get(3) != null) {
			int index = 3;
			String cardId = cardIds.get(3);
			window = new PopUp(cardId, game, index, cardButtons, this, DeckPileButton, StockPileButton);
			window.setBounds(750, 40, 700, 800);
			window.setVisible(true);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		if (cardIds.get(4) != null) {
			int index = 4;
			String cardId = cardIds.get(4);
			window = new PopUp(cardId, game, index, cardButtons, this, DeckPileButton, StockPileButton);
			window.setBounds(750, 40, 700, 800);
			window.setVisible(true);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}

	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
		if (cardIds.get(5) != null) {
			int index = 5;
			String cardId = cardIds.get(5);
			window = new PopUp(cardId, game, index, cardButtons, this, DeckPileButton, StockPileButton);
			window.setBounds(750, 40, 700, 800);
			window.setVisible(true);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}

	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
		if (cardIds.get(6) != null) {
			int index = 6;
			String cardId = cardIds.get(6);
			window = new PopUp(cardId, game, index, cardButtons, this, DeckPileButton, StockPileButton);
			window.setBounds(750, 40, 700, 800);
			window.setVisible(true);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}

	private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
		if (cardIds.get(7) != null) {
			int index = 7;
			String cardId = cardIds.get(7);
			window = new PopUp(cardId, game, index, cardButtons, this, DeckPileButton, StockPileButton);
			window.setBounds(750, 40, 700, 800);
			window.setVisible(true);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}

	private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
		if (cardIds.get(8) != null) {
			int index = 8;
			String cardId = cardIds.get(8);
			window = new PopUp(cardId, game, index, cardButtons, this, DeckPileButton, StockPileButton);
			window.setBounds(750, 40, 700, 800);
			window.setVisible(true);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}

	private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {
		if (cardIds.get(9) != null) {
			int index = 9;
			String cardId = cardIds.get(9);
			window = new PopUp(cardId, game, index, cardButtons, this, DeckPileButton, StockPileButton);
			window.setBounds(750, 40, 700, 800);
			window.setVisible(true);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}

	private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {
		if (cardIds.get(10) != null) {
			int index = 10;
			String cardId = cardIds.get(10);
			window = new PopUp(cardId, game, index, cardButtons, this, DeckPileButton, StockPileButton);
			window.setBounds(750, 40, 700, 800);
			window.setVisible(true);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}

	private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {
		if (cardIds.get(11) != null) {
			int index = 11;
			String cardId = cardIds.get(11);
			window = new PopUp(cardId, game, index, cardButtons, this, DeckPileButton, StockPileButton);
			window.setBounds(750, 40, 700, 800);
			window.setVisible(true);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}

	private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {
		if (cardIds.get(12) != null) {
			int index = 12;
			String cardId = cardIds.get(12);
			window = new PopUp(cardId, game, index, cardButtons, this, DeckPileButton, StockPileButton);
			window.setBounds(750, 40, 700, 800);
			window.setVisible(true);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}

	private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {
		if (cardIds.get(13) != null) {
			int index = 13;
			String cardId = cardIds.get(13);
			window = new PopUp(cardId, game, index, cardButtons, this, DeckPileButton, StockPileButton);
			window.setBounds(750, 40, 700, 800);
			window.setVisible(true);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}

	private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {
		if (cardIds.get(14) != null) {
			int index = 14;
			String cardId = cardIds.get(14);
			window = new PopUp(cardId, game, index, cardButtons, this, DeckPileButton, StockPileButton);
			window.setBounds(750, 40, 700, 800);
			window.setVisible(true);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}

	private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {
		if (cardIds.get(15) != null) {
			int index = 15;
			String cardId = cardIds.get(15);
			window = new PopUp(cardId, game, index, cardButtons, this, DeckPileButton, StockPileButton);
			window.setBounds(750, 40, 700, 800);
			window.setVisible(true);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}

	/**
	 * @param args the command line arguments
	 */
	/*
	 * public static void main(String args[]) { try { for
	 * (javax.swing.UIManager.LookAndFeelInfo info :
	 * javax.swing.UIManager.getInstalledLookAndFeels()) { if
	 * ("Nimbus".equals(info.getName())) {
	 * javax.swing.UIManager.setLookAndFeel(info.getClassName()); break; } } } catch
	 * (ClassNotFoundException ex) {
	 * java.util.logging.Logger.getLogger(GameStage.class.getName()).log(java.util.
	 * logging.Level.SEVERE, null, ex); } catch (InstantiationException ex) {
	 * java.util.logging.Logger.getLogger(GameStage.class.getName()).log(java.util.
	 * logging.Level.SEVERE, null, ex); } catch (IllegalAccessException ex) {
	 * java.util.logging.Logger.getLogger(GameStage.class.getName()).log(java.util.
	 * logging.Level.SEVERE, null, ex); } catch
	 * (javax.swing.UnsupportedLookAndFeelException ex) {
	 * java.util.logging.Logger.getLogger(GameStage.class.getName()).log(java.util.
	 * logging.Level.SEVERE, null, ex); }
	 * 
	 * Create and display the form java.awt.EventQueue.invokeLater(new Runnable() {
	 * public void run() { new GameStage().setVisible(true); } }); }
	 */

	// Variables declaration - do not modify
	private javax.swing.JButton DeckPileButton;
	private javax.swing.JButton StockPileButton;
	private javax.swing.JButton drawCardButton;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton10;
	private javax.swing.JButton jButton11;
	private javax.swing.JButton jButton12;
	private javax.swing.JButton jButton13;
	private javax.swing.JButton jButton14;
	private javax.swing.JButton jButton15;
	private javax.swing.JButton jButton16;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JButton jButton8;
	private javax.swing.JButton jButton9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel playerIdNameLabel;
	// End of variables declaration
}
