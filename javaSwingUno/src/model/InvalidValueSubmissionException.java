package model;

import javax.swing.JLabel;

public class InvalidValueSubmissionException extends Exception
{
	private Card.Value expected;
	private Card.Value actual;
	
	public InvalidValueSubmissionException(JLabel message, Card.Value actual, Card.Value expected)
	{
		this.actual = actual;
		this.expected = expected;
	}
}
