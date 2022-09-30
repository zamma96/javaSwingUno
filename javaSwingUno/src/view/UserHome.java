package view;


import controller.*;
import model.User;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author matte
 */
public class UserHome extends javax.swing.JFrame {
    
    File userData = new File(".\\resources\\UserData"); //gestione load e save da e su file da implementare
    User user;
    Controller controller;
    int pos = 0; //in realtà è da ricavare dalla finestra precedente
    
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
        Icon icon = new ImageIcon(".\\resources\\Avatar" + imageName);
        AvatarImageLabel.setIcon(icon);
            
       }
    
    /**
     * Creates new form UserHome
     */
    public UserHome(User user) {
        initComponents();
        this.user = user;
        Controller controller = new Controller();
        EmptyNickNameLabel.setText(user.getNickName());
        showImage(pos);
    }
                      
    private void initComponents() {

        JPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JPanel2 = new javax.swing.JPanel();
        NickNameLabel = new javax.swing.JLabel();
        AvatarLabel = new javax.swing.JLabel();
        AvatarImageLabel = new javax.swing.JLabel();
        EmptyNickNameLabel = new javax.swing.JLabel();
        PreviousButton = new javax.swing.JButton();
        NextButton = new javax.swing.JButton();
        playButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        JPanel1.setBackground(new java.awt.Color(53, 101, 77));

        jLabel1.setBackground(new java.awt.Color(53, 101, 77));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("'s Home");

        javax.swing.GroupLayout JPanel1Layout = new javax.swing.GroupLayout(JPanel1);
        JPanel1.setLayout(JPanel1Layout);
        JPanel1Layout.setHorizontalGroup(
            JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(JPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        JPanel1Layout.setVerticalGroup(
            JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(JPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        JPanel2.setBackground(new java.awt.Color(255, 255, 255));
        JPanel2.setPreferredSize(new java.awt.Dimension(400, 299));

        NickNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        NickNameLabel.setText("NickName:");

        AvatarLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        AvatarLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        AvatarLabel.setText("Avatar:");

        AvatarImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Avatar/default.png"))); 

        EmptyNickNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 18));
        EmptyNickNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        PreviousButton.setText("Previous");
        PreviousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousButtonActionPerformed(evt);
            }
        });

        NextButton.setText("Next");
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });

        playButton.setText("PLAY!");
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });

        exitButton.setText("EXIT");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPanel2Layout = new javax.swing.GroupLayout(JPanel2);
        JPanel2.setLayout(JPanel2Layout);
        JPanel2Layout.setHorizontalGroup(
            JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanel2Layout.createSequentialGroup()
                .addGroup(JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(AvatarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NickNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPanel2Layout.createSequentialGroup()
                                .addComponent(AvatarImageLabel)
                                .addGap(44, 44, 44)
                                .addGroup(JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PreviousButton)
                                    .addComponent(NextButton)))
                            .addComponent(EmptyNickNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JPanel2Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(exitButton)
                        .addGap(18, 18, 18)
                        .addComponent(playButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(14, 14, 14))
        );
        JPanel2Layout.setVerticalGroup(
            JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NickNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmptyNickNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanel2Layout.createSequentialGroup()
                        .addGroup(JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPanel2Layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(AvatarLabel))
                            .addGroup(JPanel2Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(PreviousButton)))
                        .addGap(2, 2, 2)
                        .addComponent(NextButton))
                    .addGroup(JPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(AvatarImageLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playButton)
                    .addComponent(exitButton))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }                        

    private void PreviousButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        pos = pos -1;
        if (pos < 0)
        pos = getImages().length -1;
        showImage(pos);
    }                                              

    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        pos = pos +1;
        if (pos >= getImages().length)
        pos = 0;
        showImage(pos);
    }                                          

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        System.exit(0);
    }                                          

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        String nickName = user.getNickName();
        new GameStage(controller.getUser(nickName)).setVisible(true);
    }                                          

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(User user) {
                new UserHome(user).setVisible(true);
            }
			@Override
			public void run() 
			{
				
			}
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel AvatarImageLabel;
    private javax.swing.JLabel AvatarLabel;
    private javax.swing.JLabel EmptyNickNameLabel;
    private javax.swing.JPanel JPanel1;
    private javax.swing.JPanel JPanel2;
    private javax.swing.JButton NextButton;
    private javax.swing.JLabel NickNameLabel;
    private javax.swing.JButton PreviousButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton playButton;               
}
