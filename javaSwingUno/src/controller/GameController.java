package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.Game;
import model.InvalidPlayerTurnException;
import view.GameStage;
import view.PopUp;

public class GameController 
{
	
	//classe che serve ad amministrare cambiamenti
	//sulla view scatenati dalle interazioni delle IA
	//col model nella partita
	private Game model;
	private GameStage view;
	private PopUp window;
	
	public GameController(Game game, GameStage gameStage)
	{
		this.model = game;
		this.view = gameStage;
		initView();
	}
	
	public void setPlayerNames()
	{
		view.getPlayerIdName().setText(model.getPlayers()[0].getPlayerNickName() + "'s cards");
		view.getPlayerIdName().setForeground(new Color(255, 145, 164));
		view.getIaNameLabel1().setText(model.getPlayers()[1].getPlayerNickName());
		view.getIaNameLabel1().setForeground(new Color(255, 145, 164));
		view.getIaNameLabel2().setText(model.getPlayers()[2].getPlayerNickName());
		view.getIaNameLabel2().setForeground(new Color(255, 145, 164));
		view.getIaNameLabel3().setText(model.getPlayers()[3].getPlayerNickName());
		view.getIaNameLabel3().setForeground(new Color(255, 145, 164));
	}
	
	public void initView()
	{
		Icon icon = new ImageIcon(".\\resources\\UnoCards\\CARD_BACK.png");
		Icon iconS = new ImageIcon(".\\resources\\UnoCards\\" + model.getTopCardImage());
		view.getStockPileButton().setIcon(iconS);
		view.getDeckPileButton().setIcon(icon);
		setPlayerNames();
		view.setVisible(true);
	}
	
	public void initController()
	{
		gameViewListener(view);
	}
	
	public void gameViewListener(GameStage gameView)
	{
		view.getjButton1().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt)
			{
				jButton1ActionPerformed(evt);
			}
		});
		
		view.getjButton2().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt)
			{
				jButton2ActionPerformed(evt);
			}
		});
		
		view.getjButton3().addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent evt)
			{
				jButton3ActionPerformed(evt);
			}
				});
		view.getjButton4().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt)
			{
				jButton4ActionPerformed(evt);
			}
		});
		view.getjButton5().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				jButton5ActionPerformed(evt);
			}
		});
		view.getjButton6().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				jButton6ActionPerformed(evt);
			}
		});
		view.getjButton7().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				jButton7ActionPerformed(evt);
			}
		});
		view.getjButton8().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				jButton8ActionPerformed(evt);
			}
		});
		view.getjButton9().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				jButton9ActionPerformed(evt);
			}
		});
		view.getjButton10().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				jButton10ActionPerformed(evt);
			}
		});
		view.getjButton11().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				jButton11ActionPerfomed(evt);
			}
		});
		view.getjButton12().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				jButton12ActionPerformed(evt);
			}
		});
		view.getjButton13().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				jButton13ActionPerformed(evt);
			}
		});
		view.getjButton14().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				jButton14ActionPerformed(evt);
			}
		});
		view.getjButton15().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				jButton15ActionPerformed(evt);
			}
		});
		view.getjButton16().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				jButton16ActionPerformed(evt);
			}
		});
		view.getDrawCardButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt)
			{
				drawCardButtonActionPerformed(evt);
			}
		});
	}
	
	//da rivedere assolutamente, ho solo tolto i main error
	private void jButton1ActionPerformed(ActionEvent evt) 
	{
		if (model.getCardIds().get(0) != null) 
		{
			int index = 0;
			String cardId = model.getCardIds().get(0);
			window = new PopUp(cardId, model, index, model.getcardButtons(), view, view.getStockPileButton());
			PopUpController controller = new PopUpController(model, view, window);
			controller.initController(window);
			model.addObserver(window);
		}
	}
	
	private void jButton2ActionPerformed(ActionEvent evt) 
	{
		if (model.getCardIds().get(1) != null) 
		{
			int index = 1;
			String cardId = model.getCardIds().get(1);
			window = new PopUp(cardId, model, index, model.getcardButtons(), view, view.getStockPileButton());
			PopUpController controller = new PopUpController(model, view, window);
			controller.initController(window);
			model.addObserver(window);
		}
	}
	
	private void jButton3ActionPerformed(ActionEvent evt)
	{
		if (model.getCardIds().get(2) != null)
		{
			int index = 2;
			String cardId = model.getCardIds().get(2);
			window = new PopUp(cardId, model, index, model.getcardButtons(), view, view.getStockPileButton());
			PopUpController controller = new PopUpController(model, view, window);
			controller.initController(window);
			model.addObserver(window);
		}
	}
	
	private void jButton4ActionPerformed(ActionEvent evt)
	{
		if (model.getCardIds().get(3) != null)
		{
			int index = 3;
			String cardId = model.getCardIds().get(3);
			window = new PopUp(cardId, model, index, model.getcardButtons(), view, view.getStockPileButton());
			PopUpController controller = new PopUpController(model, view, window);
			controller.initController(window);
			model.addObserver(window);
		}
	}
	
	private void jButton5ActionPerformed(ActionEvent evt)
	{
		if (model.getCardIds().get(4) != null)
		{
			int index = 4;
			String cardId = model.getCardIds().get(4);
			window = new PopUp(cardId, model, index, model.getcardButtons(), view, view.getStockPileButton());
			PopUpController controller = new PopUpController(model, view, window);
			controller.initController(window);
			model.addObserver(window);
		}
	}
	
	private void jButton6ActionPerformed(ActionEvent evt)
	{
		if (model.getCardIds().get(5) != null)
		{
			int index = 5;
			String cardId = model.getCardIds().get(5);
			window = new PopUp(cardId, model, index, model.getcardButtons(), view, view.getStockPileButton());
			PopUpController controller = new PopUpController(model, view, window);
			controller.initController(window);
			model.addObserver(window);
		}
	}
	
	private void jButton7ActionPerformed(ActionEvent evt)
	{
		if (model.getCardIds().get(6) != null)
		{
			int index = 6;
			String cardId = model.getCardIds().get(6);
			window = new PopUp(cardId, model, index, model.getcardButtons(), view, view.getStockPileButton());
			PopUpController controller = new PopUpController(model, view, window);
			controller.initController(window);
			model.addObserver(window);
		}
	}
	
	private void jButton8ActionPerformed(ActionEvent evt)
	{
		if (model.getCardIds().get(7) != null)
		{
			int index = 7;
			String cardId = model.getCardIds().get(7);
			window = new PopUp(cardId, model, index, model.getcardButtons(), view, view.getStockPileButton());
			PopUpController controller = new PopUpController(model, view, window);
			controller.initController(window);
			model.addObserver(window);
		}
	}
	
	private void jButton9ActionPerformed(ActionEvent evt)
	{
		if(model.getCardIds().get(8) != null)
		{
			int index = 8;
			String cardId = model.getCardIds().get(8);
			window = new PopUp(cardId, model, index, model.getcardButtons(), view, view.getStockPileButton());
			PopUpController controller = new PopUpController(model, view, window);
			controller.initController(window);
			model.addObserver(window);
		}
	}
	
	private void jButton10ActionPerformed(ActionEvent evt)
	{
		if(model.getCardIds().get(9) != null)
		{
			int index = 9;
			String cardId = model.getCardIds().get(9);
			window = new PopUp(cardId, model, index, model.getcardButtons(), view, view.getStockPileButton());
			PopUpController controller = new PopUpController(model, view, window);
			controller.initController(window);
			model.addObserver(window);
		}
	}
	
	private void jButton11ActionPerfomed(ActionEvent evt)
	{
		if(model.getCardIds().get(10) != null)
		{
			int index = 10;
			String cardId = model.getCardIds().get(10);
			window = new PopUp(cardId, model, index, model.getcardButtons(), view, view.getStockPileButton());
			PopUpController controller = new PopUpController(model, view, window);
			controller.initController(window);
			model.addObserver(window);
		}
	}
	
	private void jButton12ActionPerformed(ActionEvent evt)
	{
		if (model.getCardIds().get(11) != null)
		{
			int index = 11;
			String cardId = model.getCardIds().get(11);
			window = new PopUp(cardId, model, index, model.getcardButtons(), view, view.getStockPileButton());
			PopUpController controller = new PopUpController(model, view, window);
			controller.initController(window);
			model.addObserver(window);
		}
	}
	
	private void jButton13ActionPerformed(ActionEvent evt)
	{
		if(model.getCardIds().get(12)!= null)
		{
			int index = 12;
			String cardId = model.getCardIds().get(12);
			window = new PopUp(cardId, model, index, model.getcardButtons(), view, view.getStockPileButton());
			PopUpController controller = new PopUpController(model, view, window);
			controller.initController(window);
			model.addObserver(window);
		}
	}
	
	private void jButton14ActionPerformed(ActionEvent evt)
	{
		if (model.getCardIds().get(13) != null)
		{
			int index = 13;
			String cardId = model.getCardIds().get(13);
			window = new PopUp(cardId, model, index, model.getcardButtons(), view, view.getStockPileButton());
			PopUpController controller = new PopUpController(model, view, window);
			controller.initController(window);
			model.addObserver(window);
		}
	}
	
	private void jButton15ActionPerformed(ActionEvent evt)
	{
		if (model.getCardIds().get(14) != null)
		{
			int index = 14;
			String cardId = model.getCardIds().get(14);
			window = new PopUp(cardId, model, index, model.getcardButtons(), view, view.getStockPileButton());
			PopUpController controller = new PopUpController(model, view, window);
			controller.initController(window);
			model.addObserver(window);
		}
	}
	
	private void jButton16ActionPerformed(ActionEvent evt)
	{
		if (model.getCardIds().get(15) != null)
		{
			int index = 15;
			String cardId = model.getCardIds().get(15);
			window = new PopUp(cardId, model, index, model.getcardButtons(), view, view.getStockPileButton());
			PopUpController controller = new PopUpController(model, view, window);
			controller.initController(window);
			model.addObserver(window);
		}
	}
	
	private void drawCardButtonActionPerformed(ActionEvent evt)
	{
		try
		{
			model.submitDraw(model.getCurrentPlayer());
		}
		catch (InvalidPlayerTurnException ex)
		{
			Logger.getLogger(GameStage.class.getName()).log(Level.SEVERE, null, ex);
		}
		drawCardMessage();
		view.setButtonIcons();
	}
	
	private void drawCardMessage()
	{
		JLabel message = new JLabel(model.getCurrentPlayer().getPlayerNickName() + " drew a card" );
		message.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
		message.setBackground(new Color(53, 101, 77));
		message.setForeground(new Color(255, 145, 164));
		JOptionPane.showMessageDialog(null, message);
	}
}
