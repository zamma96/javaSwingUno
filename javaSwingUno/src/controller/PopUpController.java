package controller;

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
import model.InvalidValueSubmissionException;
import view.GameStage;
import view.PickColorFrame;
import view.PopUp;

public class PopUpController 
{
	private Game model;
	private GameStage view;
	private PopUp popUpView;
	
	public PopUpController(Game game, GameStage gameStage, PopUp popUpView)
	{
		this.model = game;
		this.view = gameStage;
		this.popUpView = popUpView;
		initView();
	}
	
	public void initView()
	{
		Icon icon = new ImageIcon(".\\resources\\Images\\" + popUpView.getCardImage() + ".png");
        popUpView.getCardLabel().setIcon(icon);
        view.setVisible(true);
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
		PickColorController controller = new PickColorController(model, pickColorView);
		controller.initController(pickColorView);
		model.addObserver(pickColorView);
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
					view.update(model, model.getCurrentPlayer().getPlayerNickName());
					//al posto della riga qua sotto
					view.setPlayerIdName(model.getCurrentPlayer().getPlayerNickName());
					view.setButtonIcons();
					Icon iconS = new ImageIcon(".\\resources\\UnoCards\\" + model.getTopCardImage());
					popUpView.getStockPileButton().setIcon(iconS);
					model.deleteObserver(pickColorView);
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
