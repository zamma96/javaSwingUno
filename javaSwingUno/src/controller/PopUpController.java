package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import model.Card;
import model.Game;
import model.InvalidColorSubmissionException;
import model.InvalidPlayerTurnException;
import model.InvalidValueSubmissionException;
import view.GameStage;
import view.PickColorFrame;
import view.PopUp;

public class PopUpController 
{
	private Game model;
	private PopUp popUpView;
	private GameStage view;
	
	public PopUpController(Game game, GameStage gameStage, PopUp popUpView)
	{
		this.model = game;
		this.view = gameStage;
		this.popUpView = popUpView;
		initView();
	}
	
	public void initView()
	{
		popUpView.setBounds(750, 40, 700, 800);
		popUpView.setResizable(false);
		popUpView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Icon icon = new ImageIcon(".\\resources\\Images\\" + popUpView.getCardImage() + ".png");
        popUpView.getCardLabel().setIcon(icon);
        popUpView.setVisible(true);
	}
	
	public void initController(PopUp view)
	{
		popUpActionListeners(view);
	}
	
	public void popUpActionListeners(PopUp view)
	{
		view.getUseCardButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt)
			{
				useCardButtonActionPerformed(evt);
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
	
	public void useCardButtonActionPerformed(ActionEvent evt)
	{
		PickColorFrame pickColorView = new PickColorFrame(popUpView);
		PickColorController controller = new PickColorController(model, popUpView, pickColorView);
		controller.initController(pickColorView);
		model.addObserver(pickColorView);
		//riga sotto può essere sostituita(?) in
		//model.setDeclaredColor(pickColorView.choseColor(model.getLastStockPileCard()));
		model.setDeclaredColor(pickColorView.choseColor(model.getPlayerHand(model.getCurrentPlayer()).get(popUpView.getChoice())));
		if (model.getDeclaredColor() != null)
		{
			try
			{
				model.submitPlayerCard(model.getCurrentPlayer(), model.getPlayerHand(model.getCurrentPlayer()).get(popUpView.getChoice()), model.getDeclaredColor());
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
			popUpView.revalidate();
			if (model.getDeclaredColor() != Card.Color.WILD)
				{
					view.setButtonIcons();
					Icon iconS = new ImageIcon(".\\resources\\UnoCards\\" + model.getTopCardImage());
					popUpView.getStockPileButton().setIcon(iconS);
					model.deleteObserver(pickColorView);
					model.deleteObserver(popUpView);
					popUpView.dispose();
				}
		}
	}
	
	public void cancelButtonActionPerformed(ActionEvent evt)
	{
		model.deleteObserver(popUpView);
		popUpView.dispose();
	}
}
