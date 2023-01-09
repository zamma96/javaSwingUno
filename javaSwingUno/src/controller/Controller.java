package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.InvalidColorSubmissionException;
import model.InvalidSubmissionFinisherException;
import model.InvalidValueSubmissionException;
import model.Model;
import view.PopUp;
import view.View;

public class Controller 
{
		private Model model;
		private View view;
		private static Font MID_GAME_FONT = new Font("Comic Sans MS", Font.BOLD, 36);
		private static Color TABLE_GREEN = new Color(53, 101, 77);
		private static Color SALMON_PINK = new Color(255, 145, 164);
		
		public Controller(Model model, View gameStage)
		{
			this.model = model;
			this.view = gameStage;
			gameStage.setButtonIcons();
			initView();
		}
		
		public void setPlayerNames()
		{
			view.getPlayerIdName().setText(model.getPlayers()[0].getPlayerNickName() + "'s cards");
			view.getPlayerIdName().setForeground(SALMON_PINK);
			view.getPlayerIdName().setBackground(TABLE_GREEN);
			view.getIaNameLabel1().setText(model.getPlayers()[1].getPlayerNickName());
			view.getIaNameLabel1().setForeground(SALMON_PINK);
			view.getIaNameLabel1().setBackground(TABLE_GREEN);
			view.getIaNameLabel2().setText(model.getPlayers()[2].getPlayerNickName());
			view.getIaNameLabel2().setForeground(SALMON_PINK);
			view.getIaNameLabel2().setBackground(TABLE_GREEN);
			view.getIaNameLabel3().setText(model.getPlayers()[3].getPlayerNickName());
			view.getIaNameLabel3().setForeground(SALMON_PINK);
			view.getIaNameLabel3().setBackground(TABLE_GREEN);
		}
		
		public void initView()
		{
			view.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
			view.setTitle("UNO");
			view.setResizable(false);
			view.setLocationRelativeTo(null);
			
			view.getjPanel1().setToolTipText("");
			view.getjPanel1().setBackground(TABLE_GREEN);
			view.setPreferredSize(new Dimension(1200, 720));
			
			view.getDrawCardButton().setFont(MID_GAME_FONT);
			view.getDrawCardButton().setForeground(SALMON_PINK);
			view.getDrawCardButton().setBackground(TABLE_GREEN);
			view.getDrawCardButton().setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
			view.getDrawCardButton().setText("Draw Card");
			
			view.getDeckPileButton().setPreferredSize(new Dimension(100, 70));
			view.getStockPileButton().setPreferredSize(new Dimension(100, 70));
			
			view.getPlayerIdName().setFont(MID_GAME_FONT);
			view.getPlayerIdName().setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
			view.getIaNameLabel1().setFont(MID_GAME_FONT);
			view.getIaNameLabel1().setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
			view.getIaNameLabel2().setFont(MID_GAME_FONT);
			view.getIaNameLabel2().setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
			view.getIaNameLabel3().setFont(MID_GAME_FONT);
			view.getIaNameLabel3().setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
			
			Icon icon = new ImageIcon(".\\resources\\UnoCards\\CARD_BACK.png");
			Icon iconS = new ImageIcon(".\\resources\\UnoCards\\" + model.getStockIcon() + ".png");
			view.getStockPileButton().setIcon(iconS);
			view.getDeckPileButton().setIcon(icon);
			setPlayerNames();
			view.setVisible(true);
		}
		
		public void initController()
		{
			gameViewListener(view);
			view.run();
		}
		
		public void gameViewListener(View gameView)
		{
			view.getjButton1().addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent evt)
				{
					try 
					{
						jButton1ActionPerformed(evt);
					}
					catch (InvalidColorSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidValueSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidSubmissionFinisherException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					}
				}
			});
			
			view.getjButton2().addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent evt)
				{
					try 
					{
						jButton2ActionPerformed(evt);
					}
					catch (InvalidColorSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidValueSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidSubmissionFinisherException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					}
				}
			});
			
			view.getjButton3().addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent evt)
				{
					try 
					{
						jButton3ActionPerformed(evt);
					}
					catch (InvalidColorSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidValueSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidSubmissionFinisherException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					}
				}
					});
			view.getjButton4().addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent evt)
				{
					try 
					{
						jButton4ActionPerformed(evt);
					}
					catch (InvalidColorSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidValueSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidSubmissionFinisherException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					}
				}
			});
			view.getjButton5().addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt)
				{
					try 
					{
						jButton5ActionPerformed(evt);
					}
					catch (InvalidColorSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidValueSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidSubmissionFinisherException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					}
				}
			});
			view.getjButton6().addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt)
				{
					try 
					{
						jButton6ActionPerformed(evt);
					}
					catch (InvalidColorSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidValueSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidSubmissionFinisherException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					}
				}
			});
			view.getjButton7().addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt)
				{
					try 
					{
						jButton7ActionPerformed(evt);
					}
					catch (InvalidColorSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidValueSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidSubmissionFinisherException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					}
				}
			});
			view.getjButton8().addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt)
				{
					try 
					{
						jButton8ActionPerformed(evt);
					}
					catch (InvalidColorSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidValueSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidSubmissionFinisherException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					}
				}
			});
			view.getjButton9().addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt)
				{
					try 
					{
						jButton9ActionPerformed(evt);
					}
					catch (InvalidColorSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidValueSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidSubmissionFinisherException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					}
				}
			});
			view.getjButton10().addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt)
				{
					try 
					{
						jButton10ActionPerformed(evt);
					}
					catch (InvalidColorSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidValueSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidSubmissionFinisherException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					}
				}
			});
			view.getjButton11().addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt)
				{
					try 
					{
						jButton11ActionPerfomed(evt);
					}
					catch (InvalidColorSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidValueSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidSubmissionFinisherException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					}
				}
			});
			view.getjButton12().addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt)
				{
					try 
					{
						jButton12ActionPerformed(evt);
					}
					catch (InvalidColorSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidValueSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidSubmissionFinisherException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					}
				}
			});
			view.getjButton13().addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt)
				{
					try 
					{
						jButton13ActionPerformed(evt);
					}
					catch (InvalidColorSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidValueSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidSubmissionFinisherException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					}
				}
			});
			view.getjButton14().addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt)
				{
					try 
					{
						jButton14ActionPerformed(evt);
					}
					catch (InvalidColorSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidValueSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidSubmissionFinisherException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					}
				}
			});
			view.getjButton15().addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt)
				{
					try 
					{
						jButton15ActionPerformed(evt);
					}
					catch (InvalidColorSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidValueSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidSubmissionFinisherException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					}
				}
			});
			view.getjButton16().addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt)
				{
					try 
					{
						jButton16ActionPerformed(evt);
					}
					catch (InvalidColorSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidValueSubmissionException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					} 
					catch (InvalidSubmissionFinisherException e) 
					{
						Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					}
				}
			});
			view.getDrawCardButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt)
				{
					drawCardButtonActionPerformed(evt);
				}
			});
		}
		
		
		/**
		 * 
		 * @param evt
		 * 
		 * Forse per migliorare e facilitarmi il tutto posso semplicemente
		 * prendere l'indice della carta in mano dalla pressione del bottone
		 * della carta, e implementare un metodo per aprire la relativa 
		 * finestra senza ripetere lo stesso codice per 16 volte.
		 * @throws InvalidValueSubmissionException 
		 * @throws InvalidColorSubmissionException 
		 * @throws InvalidSubmissionFinisherException 
		 */
		
		public void userCardAction(Integer i) throws InvalidColorSubmissionException, InvalidValueSubmissionException, InvalidSubmissionFinisherException
		{
			if (model.selectionDialog())
			{
				model.setChoice((Integer)i);
				model.submitPlayerCard(i);
			}
			//dato che la risposta a +2/+4 è implementata nel gameLoop,
			//qua bisongna solo valutare la correttezza della giocata 
			//scelta dall'utente
			
			//metodo da rivedere tutto dopo aver completato metodo
			//submitPlayerCard
			
			// e cardAction da View
			
			//controllare se serve
			view.setButtonIcons();
		}
		

		private void jButton1ActionPerformed(ActionEvent evt) throws InvalidColorSubmissionException, InvalidValueSubmissionException, InvalidSubmissionFinisherException 
		{
			if (model.getCardIds().get(0) != null) 
				userCardAction(0);
		}
		
		private void jButton2ActionPerformed(ActionEvent evt) throws InvalidColorSubmissionException, InvalidValueSubmissionException, InvalidSubmissionFinisherException 
		{
			if (model.getCardIds().get(1) != null) 
				userCardAction(1);
		}
		
		private void jButton3ActionPerformed(ActionEvent evt) throws InvalidColorSubmissionException, InvalidValueSubmissionException, InvalidSubmissionFinisherException
		{
			if (model.getCardIds().get(2) != null)
				userCardAction(2);
		}
		
		private void jButton4ActionPerformed(ActionEvent evt) throws InvalidColorSubmissionException, InvalidValueSubmissionException, InvalidSubmissionFinisherException
		{
			if (model.getCardIds().get(3) != null)
				userCardAction(3);
		}
		
		private void jButton5ActionPerformed(ActionEvent evt) throws InvalidColorSubmissionException, InvalidValueSubmissionException, InvalidSubmissionFinisherException
		{
			if (model.getCardIds().get(4) != null)
				userCardAction(4);
		}
		
		private void jButton6ActionPerformed(ActionEvent evt) throws InvalidColorSubmissionException, InvalidValueSubmissionException, InvalidSubmissionFinisherException
		{
			if (model.getCardIds().get(5) != null)
				userCardAction(5);
		}
		
		private void jButton7ActionPerformed(ActionEvent evt) throws InvalidColorSubmissionException, InvalidValueSubmissionException, InvalidSubmissionFinisherException
		{
			if (model.getCardIds().get(6) != null)
				userCardAction(6);
		}
		
		private void jButton8ActionPerformed(ActionEvent evt) throws InvalidColorSubmissionException, InvalidValueSubmissionException, InvalidSubmissionFinisherException
		{
			if (model.getCardIds().get(7) != null)
				userCardAction(7);
		}
		
		private void jButton9ActionPerformed(ActionEvent evt) throws InvalidColorSubmissionException, InvalidValueSubmissionException, InvalidSubmissionFinisherException
		{
			if(model.getCardIds().get(8) != null)
				userCardAction(8);
		}
		
		private void jButton10ActionPerformed(ActionEvent evt) throws InvalidColorSubmissionException, InvalidValueSubmissionException, InvalidSubmissionFinisherException
		{
			if(model.getCardIds().get(9) != null)
				userCardAction(9);
		}
		
		private void jButton11ActionPerfomed(ActionEvent evt) throws InvalidColorSubmissionException, InvalidValueSubmissionException, InvalidSubmissionFinisherException
		{
			if(model.getCardIds().get(10) != null)
				userCardAction(10);
		}
		
		private void jButton12ActionPerformed(ActionEvent evt) throws InvalidColorSubmissionException, InvalidValueSubmissionException, InvalidSubmissionFinisherException
		{
			if (model.getCardIds().get(11) != null)
				userCardAction(11);
		}
		
		private void jButton13ActionPerformed(ActionEvent evt) throws InvalidColorSubmissionException, InvalidValueSubmissionException, InvalidSubmissionFinisherException
		{
			if(model.getCardIds().get(12)!= null)
				userCardAction(12);
		}
		
		private void jButton14ActionPerformed(ActionEvent evt) throws InvalidColorSubmissionException, InvalidValueSubmissionException, InvalidSubmissionFinisherException
		{
			if (model.getCardIds().get(13) != null)
				userCardAction(13);
		}
		
		private void jButton15ActionPerformed(ActionEvent evt) throws InvalidColorSubmissionException, InvalidValueSubmissionException, InvalidSubmissionFinisherException
		{
			if (model.getCardIds().get(14) != null)
				userCardAction(14);
		}
		
		private void jButton16ActionPerformed(ActionEvent evt) throws InvalidColorSubmissionException, InvalidValueSubmissionException, InvalidSubmissionFinisherException
		{
			if (model.getCardIds().get(15) != null)
				userCardAction(15);
		}
		
		private void drawCardButtonActionPerformed(ActionEvent evt)
		{
			int y = model.getCurrentPlayerCounter();
			if (model.getCurrentPlayer().isHuman())
				model.submitDraw();
			drawCardMessage();
			view.setButtonIcons();
		}
		
		private void drawCardMessage()
		{
			JLabel message = new JLabel(model.getCurrentPlayerNickName() + " drew a card" );
			message.setFont(MID_GAME_FONT);
			message.setBackground(TABLE_GREEN);
			message.setForeground(SALMON_PINK);
			JOptionPane.showMessageDialog(null, message);
		}

		private void saveOnFile(java.io.File file) throws java.io.IOException
		{
			model.getDataBase().saveOnFile(file);
		}
		
		private void loadByFile(java.io.File file) throws java.io.IOException 
		{
			model.getDataBase().loadByFile(file);
		}
	}

