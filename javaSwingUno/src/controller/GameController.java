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

import model.Game;
import model.InvalidColorSubmissionException;
import model.InvalidPlayerTurnException;
import model.InvalidSubmissionFinisherException;
import model.InvalidValueSubmissionException;
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
	private static Font MID_GAME_FONT = new Font("Comic Sans MS", Font.BOLD, 36);
	private static Color TABLE_GREEN = new Color(53, 101, 77);
	private static Color SALMON_PINK = new Color(255, 145, 164);
	
	public GameController(Game game, GameStage gameStage)
	{
		this.model = game;
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
		Icon iconS = new ImageIcon(".\\resources\\UnoCards\\" + model.getTopCardImage());
		view.getStockPileButton().setIcon(iconS);
		view.getDeckPileButton().setIcon(icon);
		setPlayerNames();
		view.setVisible(true);
	}
	
	public void initController()
	{
		gameViewListener(view);
		//view.run();
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
	
	
	/**
	 * 
	 * @param evt
	 * 
	 * Forse per migliorare e facilitarmi il tutto posso semplicemente
	 * prendere l'indice della carta in mano dalla pressione del bottone
	 * della carta, e implementare un metodo per aprire la relativa 
	 * finestra senza ripetere lo stesso codice per 16 volte.
	 */
	
	
	public void cardAction(int i)
	{
		String cardId = model.getCardIds().get(i);
		String stockCard = model.getLastStockPileCard().toString();
		window = new PopUp(cardId, model, model.getcardButtons(), view);
		model.addObserver(window);
		model.setChoice(i);
		PopUpController controller = new PopUpController(model, view, window);
		controller.initController(window);
		view.setButtonIcons();
	}
	

	private void jButton1ActionPerformed(ActionEvent evt) 
	{
		if (model.getCardIds().get(0) != null) 
			cardAction(0);
	}
	
	private void jButton2ActionPerformed(ActionEvent evt) 
	{
		if (model.getCardIds().get(1) != null) 
			cardAction(1);
	}
	
	private void jButton3ActionPerformed(ActionEvent evt)
	{
		if (model.getCardIds().get(2) != null)
			cardAction(2);
	}
	
	private void jButton4ActionPerformed(ActionEvent evt)
	{
		if (model.getCardIds().get(3) != null)
			cardAction(3);
	}
	
	private void jButton5ActionPerformed(ActionEvent evt)
	{
		if (model.getCardIds().get(4) != null)
			cardAction(4);
	}
	
	private void jButton6ActionPerformed(ActionEvent evt)
	{
		if (model.getCardIds().get(5) != null)
			cardAction(5);
	}
	
	private void jButton7ActionPerformed(ActionEvent evt)
	{
		if (model.getCardIds().get(6) != null)
			cardAction(6);
	}
	
	private void jButton8ActionPerformed(ActionEvent evt)
	{
		if (model.getCardIds().get(7) != null)
			cardAction(7);
	}
	
	private void jButton9ActionPerformed(ActionEvent evt)
	{
		if(model.getCardIds().get(8) != null)
			cardAction(8);
	}
	
	private void jButton10ActionPerformed(ActionEvent evt)
	{
		if(model.getCardIds().get(9) != null)
			cardAction(9);
	}
	
	private void jButton11ActionPerfomed(ActionEvent evt)
	{
		if(model.getCardIds().get(10) != null)
			cardAction(10);
	}
	
	private void jButton12ActionPerformed(ActionEvent evt)
	{
		if (model.getCardIds().get(11) != null)
			cardAction(11);
	}
	
	private void jButton13ActionPerformed(ActionEvent evt)
	{
		if(model.getCardIds().get(12)!= null)
			cardAction(12);
	}
	
	private void jButton14ActionPerformed(ActionEvent evt)
	{
		if (model.getCardIds().get(13) != null)
			cardAction(13);
	}
	
	private void jButton15ActionPerformed(ActionEvent evt)
	{
		if (model.getCardIds().get(14) != null)
			cardAction(14);
	}
	
	private void jButton16ActionPerformed(ActionEvent evt)
	{
		if (model.getCardIds().get(15) != null)
			cardAction(15);
	}
	
	private void drawCardButtonActionPerformed(ActionEvent evt)
	{
		int y = model.getCurrentPlayerCounter();
		try
		{
			if (model.getCurrentPlayer().isHuman())
				model.submitDraw(model.getHumanPlayer());
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
