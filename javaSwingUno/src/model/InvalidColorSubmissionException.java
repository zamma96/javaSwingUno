package model;

import javax.swing.JLabel;

public class InvalidColorSubmissionException extends Exception
{
	private Card.Color expected;
	private Card.Color actual;
	
	public InvalidColorSubmissionException(JLabel message, Card.Color actual, Card.Color expected)
	{
		this.actual = actual;
		this.expected = expected;
	}
}

