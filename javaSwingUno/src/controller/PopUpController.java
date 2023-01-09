package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.Card;
import model.Game;
import model.InvalidColorSubmissionException;
import model.InvalidPlayerTurnException;
import model.InvalidSubmissionFinisherException;
import model.InvalidValueSubmissionException;
import model.Model;
import view.GameStage;
import view.PopUp;
import view.View;

public class PopUpController 
{
	private Model model;
	private PopUp popUpView;
	private View view;
	private static Font SMALL_GAME_FONT = new Font("Comic Sans MS", Font.BOLD, 18);
	private static Color TABLE_GREEN = new Color(53, 101, 77);
	private static Color SALMON_PINK = new Color(255, 145, 164);
	
	public PopUpController(Model game, View gameStage, PopUp popUpView)
	{
		this.model = game;
		this.view = gameStage;
		this.popUpView = popUpView;
		initView();
	}
	
	public void initView()
	{
		popUpView.setPreferredSize(new Dimension(500, 600));
		popUpView.setBounds(750, 40, 700, 800);
		popUpView.setResizable(false);
		popUpView.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		popUpView.getjPanel1().setBackground(TABLE_GREEN);
		
		popUpView.getCancelButton().setFont(SMALL_GAME_FONT);
		popUpView.getCancelButton().setText("Cancel");
		popUpView.getCancelButton().setBackground(TABLE_GREEN);
		popUpView.getCancelButton().setForeground(SALMON_PINK);
		
		popUpView.getUseCardButton().setFont(SMALL_GAME_FONT);
		popUpView.getUseCardButton().setText("Use card");
		popUpView.getUseCardButton().setBackground(TABLE_GREEN);
		popUpView.getUseCardButton().setForeground(SALMON_PINK);
		
		popUpView.getCardLabel().setPreferredSize(new Dimension(190, 300));
		
		Icon icon = new ImageIcon(".\\resources\\Images\\" + popUpView.getCardImage() + ".png");
        popUpView.getCardLabel().setIcon(icon);
        popUpView.setVisible(true);
	}
	
	public void initController(PopUp view)
	{
		popUpActionListeners(view);
		initView();
	}
	
	public void popUpActionListeners(PopUp view) 
	{
		view.getUseCardButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt)
			{
				try 
				{
					useCardButtonActionPerformed(evt);
				}
				catch (InvalidSubmissionFinisherException e) 
				{
					Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, e);
					e.printStackTrace();
				}
			}
		});
		view.getCancelButton().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt)
			{
				cancelButtonActionPerformed(evt);
			}
		});
	}
	
	public void useCardButtonActionPerformed(ActionEvent evt) throws InvalidSubmissionFinisherException
	{
		if (model.getValidColor() != null)
		{
			try
			{
				Card c = model.getHumanPlayer().getHand().get(model.getChoice());
				model.submitPlayerCard(c);
			}
			catch (InvalidColorSubmissionException ex) 
            { 
                Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (InvalidValueSubmissionException ex)
            {
                Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (InvalidPlayerTurnException ex)
            {
                Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, ex);
            }
			catch (InvalidSubmissionFinisherException ex)
			{
				Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, ex);
			}
			popUpView.revalidate();
			view.setButtonIcons();
			model.deleteObserver(popUpView);
			popUpView.dispose();
		}
	}
	
	public void cancelButtonActionPerformed(ActionEvent evt)
	{
		model.deleteObserver(popUpView);
		popUpView.dispose();
	}
}
