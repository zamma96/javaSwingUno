package view;


import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.Controller;
import model.Avatar;
import model.User;

	/**
	 *
	 * @author matte
	 */
public class SignUpForm extends javax.swing.JFrame {

	int pos = 9;
	Controller controller;
	File userData = new File(".\\resources\\UserData");
	
	public SignUpForm() 
	{
	    initComponents();
	    controller = new Controller();
	    showImage(pos);
	}

	public String[] getImages()
	{
		File file = new File(getClass().getResource(".\\resources\\Avatars").getFile());
	    String[] imageList = file.list();
	    return imageList;
	}
	        
	public void showImage(int index)
	{
		String[] imagesList = getImages();
	    String imageName = imagesList[index];
	    Icon icon = new ImageIcon(".\\resources\\Avatars" + imageName);
	    AvatarImageLabel.setIcon(icon);    
	}
	                     
	private void initComponents() 
	{
        jPanel2 = new javax.swing.JPanel();
        NickNameLabel = new javax.swing.JLabel();
        AvatarLabel = new javax.swing.JLabel();
        AvatarImageLabel = new javax.swing.JLabel();
        UsernameFieldLabel = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        PreviousButton = new javax.swing.JButton();
        NextButton = new javax.swing.JButton();
        SignUpButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        
	    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registration Form");
	    setBackground(new java.awt.Color(255, 255, 255));
	    setBounds(new java.awt.Rectangle(400, 400, 400, 400));
	    setMinimumSize(new java.awt.Dimension(400, 400));
	    setResizable(false);

	    jPanel2.setBackground(new java.awt.Color(255, 255, 255));
	    jPanel2.setPreferredSize(new java.awt.Dimension(400, 300));

	    NickNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 18));
	    NickNameLabel.setText("NickName:");

	    AvatarLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
	    AvatarLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	    AvatarLabel.setText("Avatar:");

	    AvatarImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(".\\reources\\Avatars\\default.png")));
        UsernameFieldLabel.setBackground(new java.awt.Color(255, 255, 255));
        UsernameFieldLabel.setText("______________________________________________");
        UsernameFieldLabel.setRequestFocusEnabled(false);

        txtUser.setFont(txtUser.getFont().deriveFont(txtUser.getFont().getSize()+2f));
        txtUser.setBorder(null);

	    PreviousButton.setText("Previous");
	    PreviousButton.addActionListener(new java.awt.event.ActionListener() 
	    {
	    	public void actionPerformed(java.awt.event.ActionEvent evt) 
	    	{
	            PreviousButtonActionPerformed(evt);
	        }
	    });

	    NextButton.setText("Next");
	    NextButton.addActionListener(new java.awt.event.ActionListener() 
	    {
	        public void actionPerformed(java.awt.event.ActionEvent evt) 
	        {
	            NextButtonActionPerformed(evt);
	        }
	    });

        SignUpButton.setText("Sign Up");
        SignUpButton.setBorder(null);
        SignUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NickNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AvatarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(AvatarImageLabel)
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PreviousButton)
                            .addComponent(NextButton)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UsernameFieldLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SignUpButton)
                .addGap(173, 173, 173))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UsernameFieldLabel)
                    .addComponent(NickNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(PreviousButton)
                        .addGap(18, 18, 18)
                        .addComponent(NextButton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(AvatarImageLabel))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(AvatarLabel)))
                .addGap(33, 33, 33)
                .addComponent(SignUpButton)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1.setBackground(new java.awt.Color(53, 101, 77));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 100));
        jLabel1.setBackground(new java.awt.Color(53, 101, 77));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registration Form");
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pack();
    }                       
                                    
    private void PreviousButtonActionPerformed(java.awt.event.ActionEvent evt) 
    {                                               
        pos = pos -1;
        if (pos < 0)
            pos = getImages().length -1;
        showImage(pos);
    }                                              
	private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                           
        pos = pos +1;
        if (pos >= getImages().length)
            pos = 0;
        showImage(pos);
    }                                          
	private void SignUpButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                             
        String nickName = txtUser.getText().toString();
        if (nickName == "")
            JOptionPane.showMessageDialog(null, "You need a Nickname!");
        else
        {
        	JLabel message = new JLabel("Welcome to JUno!");
        	message.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
        	message.setBackground(new Color(53, 101, 77));
        	message.setForeground(new Color(255, 145, 164));
            JOptionPane.showMessageDialog(null, message);   
        }
        controller.addUser(new User(nickName, pos));
        try 
        {
			controller.saveOnFile(userData);
		} catch (IOException e) 
        {
			e.printStackTrace();
		}
        new GameStage(controller.getUser(nickName)).setVisible(true);
    }               
	
	public static void main(String args[]) 
	{
	    /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new SignUpForm().setVisible(true);
            }
        });
    }
	// Variables declaration - do not modify                     
    private javax.swing.JLabel AvatarImageLabel;
    private javax.swing.JLabel AvatarLabel;
    private javax.swing.JButton NextButton;
    private javax.swing.JLabel NickNameLabel;
    private javax.swing.JButton PreviousButton;
    private javax.swing.JButton SignUpButton;
    private javax.swing.JLabel UsernameFieldLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtUser;                 
}

