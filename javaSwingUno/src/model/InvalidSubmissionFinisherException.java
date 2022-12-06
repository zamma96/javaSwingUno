package model;

import javax.swing.JLabel;

import model.Card.Value;

public class InvalidSubmissionFinisherException extends Exception 
{
	private Card.Value actual;

	public InvalidSubmissionFinisherException(JLabel message, Card.Value actual)
	{
		this.actual = actual;
	}
}
