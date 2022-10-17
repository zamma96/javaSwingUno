package view;

import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.*;
import javax.swing.*;

import model.Card;

/**
 *
 * @author matte
 */
public class PickColorFrame extends JFrame implements Observer
{

    private Card.Color wildColor = null;
    boolean allow = false;
    PopUp popUp;
    
    
    public PickColorFrame() 
    {
        initComponents();
    }

    public PickColorFrame(PopUp pop)
    {
        initComponents();
        popUp = pop;
    }
    
    public Card.Color choseColor(Card card)
    {
        if (card.getColor() == Card.Color.WILD)
        {
            this.setVisible(true);
            this.setResizable(false);
            this.setBounds(100, 150, 600, 700);
        }
        return card.getColor();
    }
    
    public JLabel getjLabel1()
    {
    	return jLabel1;
    }
    
    public JButton getRedButton()
    {
    	return redButton;
    }
    
    public JButton getGreenButton()
    {
    	return greenButton;
    }
    
    public JButton getYellowButton()
    {
    	return yellowButton;
    }
    
    public JButton getBlueButton()
    {
    	return blueButton;
    }
                              
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        redButton = new javax.swing.JButton();
        greenButton = new javax.swing.JButton();
        blueButton = new javax.swing.JButton();
        yellowButton = new javax.swing.JButton();

        jPanel1.setBackground(new Color(53,101,77));
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", Font.BOLD, 18)); // NOI18N
        jLabel1.setForeground(new Color(255, 145, 164));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Change color into:");

        redButton.setFont(new java.awt.Font("Comic Sans MS", Font.BOLD, 18)); // NOI18N
        redButton.setText("RED");
        redButton.setBackground(new Color(53,101,77));
		redButton.setForeground(new Color(255, 145, 164));
/*
        redButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redButtonActionPerformed(evt);
            }
        });
*/
        greenButton.setFont(new java.awt.Font("Comic Sans MS", Font.BOLD, 18)); // NOI18N
        greenButton.setText("GREEN");
        greenButton.setBackground(new Color(53,101,77));
		greenButton.setForeground(new Color(255, 145, 164));
/*
        greenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                greenButtonActionPerformed(evt);
            }
        });
*/
        blueButton.setFont(new java.awt.Font("Comic Sans MS", Font.BOLD, 18)); // NOI18N
        blueButton.setText("BLUE");
        blueButton.setBackground(new Color(53,101,77));
		blueButton.setForeground(new Color(255, 145, 164));
/*
        blueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueButtonActionPerformed(evt);
            }
        });
*/
        yellowButton.setFont(new java.awt.Font("Comic Sans MS", Font.BOLD, 18)); // NOI18N
        yellowButton.setText("YELLOW");
        yellowButton.setBackground(new Color(53,101,77));
		yellowButton.setForeground(new Color(255, 145, 164));
/*
        yellowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yellowButtonActionPerformed(evt);
            }
        });
*/
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(redButton, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(greenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(blueButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(yellowButton, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(redButton)
                .addGap(50, 50, 50)
                .addComponent(greenButton)
                .addGap(50, 50, 50)
                .addComponent(blueButton)
                .addGap(50, 50, 50)
                .addComponent(yellowButton)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }                       
/*
    private void yellowButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        wildColor = Card.Color.YELLOW;
        JLabel message = new JLabel("The color changed into yellow!");
		message.setBackground(new Color(53,101,77));
		message.setForeground(new Color(255, 145, 164));
        message.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
        JOptionPane.showMessageDialog(null, message);
        allow = true;
        this.dispose();
        popUp.declaredColor = Card.Color.YELLOW;
        popUp.gameStage.setPlayerIdName(popUp.game.getCurrentPlayer());
        popUp.gameStage.setButtonIcons();
        Icon icon = new ImageIcon(".\\resources\\UnoCards\\" + popUp.game.getTopCardImage());
        popUp.StockPileButton.setIcon(icon);
        popUp.game.setCardColor(Card.Color.YELLOW);
        popUp.dispose();
    }                                            

    private void greenButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        wildColor = Card.Color.GREEN;
        JLabel message = new JLabel("The color changed into green!");
        message.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
		message.setBackground(new Color(53,101,77));
		message.setForeground(new Color(255, 145, 164));
        JOptionPane.showMessageDialog(null, message);
        allow = true;
        this.dispose();
        popUp.declaredColor = Card.Color.GREEN;
        popUp.gameStage.setPlayerIdName(popUp.game.getCurrentPlayer());
        popUp.gameStage.setButtonIcons();
        Icon icon = new ImageIcon(".\\resources\\UnoCards\\" + popUp.game.getTopCardImage());
        popUp.StockPileButton.setIcon(icon);
        popUp.game.setCardColor(Card.Color.GREEN);
        popUp.dispose();
    }                                           

    private void redButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        wildColor = Card.Color.RED;
        JLabel message = new JLabel("The color changed into red!");
        message.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
		message.setBackground(new Color(53,101,77));
		message.setForeground(new Color(255, 145, 164));
        JOptionPane.showMessageDialog(null, message);
        allow = true;
        this.dispose();
        popUp.declaredColor = Card.Color.RED;
        popUp.gameStage.setPlayerIdName(popUp.game.getCurrentPlayer());
        popUp.gameStage.setButtonIcons();
        Icon icon = new ImageIcon(".\\resources\\UnoCards\\" + popUp.game.getTopCardImage());
        popUp.StockPileButton.setIcon(icon);
        popUp.game.setCardColor(Card.Color.RED);
        popUp.dispose();
        
    }                                         

    private void blueButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        wildColor = Card.Color.BLUE;
        JLabel message = new JLabel("The color changed into blue!");
        message.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
		message.setBackground(new Color(53,101,77));
		message.setForeground(new Color(255, 145, 164));
        JOptionPane.showMessageDialog(null, message);
        allow = true;
        this.dispose();
        popUp.declaredColor = Card.Color.BLUE;
        //need to reorganize mvc on this view too
        popUp.gameStage.setPlayerIdName(popUp.game.getCurrentPlayer());
        popUp.gameStage.setButtonIcons();
        Icon icon = new ImageIcon(".\\resources\\UnoCards\\" + popUp.game.getTopCardImage());
        popUp.StockPileButton.setIcon(icon);
        popUp.game.setCardColor(Card.Color.BLUE);
        popUp.dispose();
    }                                          
*/


    // Variables declaration - do not modify                     
    private javax.swing.JButton blueButton;
    private javax.swing.JButton greenButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton redButton;
    private javax.swing.JButton yellowButton;
    // End of variables declaration                   


	@Override
	public void update(Observable o, Object arg) 
	{
		
	}
}
