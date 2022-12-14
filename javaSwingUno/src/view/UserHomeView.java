package view;

import model.LoginModel;

import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author matte
 */
public class UserHomeView extends JFrame implements Observer 
{
	private LoginModel model;
	private Integer pos;
	private String[] imagesList = new String[] {"default_avatar.png", "Avatar_1.png", "Avatar_2.png", "Avatar_3.png", "Avatar_4.png", "Avatar_5.png", "Avatar_6.png", "Avatar_7.png", "Avatar_8.png", "Avatar_9.png"};

	public UserHomeView(LoginModel model) 
	{
		this.model = model;
		this.pos = model.getPos();
		initComponents();
	}

	public void showImage()
	{
		String imageName = imagesList[pos];
		Icon icon = new ImageIcon(".\\resources\\Avatars\\"+imageName);
		AvatarImageLabel.setIcon(icon);
	}
	
	/**
	 * 
	 * set this instance's pos field to @param pos;
	 */
	public void setPos(Integer pos) 
	{
		this.pos = pos;
	}

	/**
	 * 
	 * @return NextButton variable
	 */
	public JButton getNextButton() 
	{
		return NextButton;
	}

	/**
	 * 
	 * @return PreviousButton variable
	 */
	public JButton getPreviousButton() 
	{
		return PreviousButton;
	}

	/**
	 * 
	 * @return exitButton variable
	 */
	public JButton getExitButton() 
	{
		return exitButton;
	}

	/**
	 * 
	 * @return playButton variable
	 */
	public JButton getPlayButton() 
	{
		return playButton;
	}

	/**
	 * 
	 * @return JLabel1 variable
	 */
	public JLabel getjLabel1() 
	{
		return jLabel1;
	}

	/**
	 * 
	 * @return AvatarImageLabel variable
	 */
	public JLabel getAvatarImageLabel() 
	{
		return AvatarImageLabel;
	}
	
    /**
     * 
     * @return EmptyNickNameLabel variable
     */
    public JLabel getEmptyNickNameLabel()
    {
    	return EmptyNickNameLabel;
    }
    
    /**
     * 
     * @return GamesWonLabel variable;
     */
    public JLabel getGamesWonLabel()
    {
    	return GamesWonLabel;
    }
    
    /**
     * 
     * @return GamesLossLabel variable;
     */
    public JLabel getGamesLossLabel()
    {
    	return GamesLossLabel;
    }
    
    /**
     * 
     * @return GamesPlayedLabel variable;
     */
    public JLabel getGamesPlayedLabel()
    {
    	return GamesPlayedLabel;
    }

    /**
     * 
     * @return NickNameLabel variable;
     */
    public JLabel getNickNameLabel()
    {
    	return NickNameLabel; 
    }
    
    /**
     * 
     * @return AvatarLabel variable;
     */
    public JLabel getAvatarLabel()
    {
    	return AvatarLabel;
    }
    
    /**
     * 
     * @return jPanel1
     */
    public JPanel getjPanel1()
    {
    	return JPanel1;
    }
    
    public JPanel getjPanel2()
    {
    	return JPanel2;
    }
    
	/**
	 * initialize all of this frame's components and their settings.
	 */
    private void initComponents() {

        JPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JPanel2 = new javax.swing.JPanel();
        AvatarLabel = new javax.swing.JLabel();
        AvatarImageLabel = new javax.swing.JLabel();
        PreviousButton = new javax.swing.JButton();
        NextButton = new javax.swing.JButton();
        playButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        GamesWonLabel = new javax.swing.JLabel();
        GamesLossLabel = new javax.swing.JLabel();
        GamesPlayedLabel = new javax.swing.JLabel();


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



        javax.swing.GroupLayout JPanel2Layout = new javax.swing.GroupLayout(JPanel2);
        JPanel2.setLayout(JPanel2Layout);
        JPanel2Layout.setHorizontalGroup(
            JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(GamesWonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(GamesPlayedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(JPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(PreviousButton)
                .addGap(18, 18, 18)
                .addComponent(AvatarImageLabel)
                .addGap(18, 18, 18)
                .addComponent(NextButton)
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanel2Layout.createSequentialGroup()
                        .addComponent(exitButton)
                        .addGap(74, 74, 74)
                        .addComponent(playButton)
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanel2Layout.createSequentialGroup()
                        .addGroup(JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(GamesLossLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AvatarLabel))
                        .addGap(158, 158, 158))))
        );
        JPanel2Layout.setVerticalGroup(
            JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GamesWonLabel)
                    .addComponent(GamesLossLabel)
                    .addComponent(GamesPlayedLabel))
                .addGap(18, 18, 18)
                .addComponent(AvatarLabel)
                .addGap(18, 18, 18)
                .addGroup(JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(JPanel2Layout.createSequentialGroup()
                            .addComponent(AvatarImageLabel)
                            .addGap(38, 38, 38))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanel2Layout.createSequentialGroup()
                            .addComponent(NextButton)
                            .addGap(94, 94, 94)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanel2Layout.createSequentialGroup()
                        .addComponent(PreviousButton)
                        .addGap(95, 95, 95)))
                .addGroup(JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playButton)
                    .addComponent(exitButton))
                .addContainerGap(28, Short.MAX_VALUE))
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
                .addComponent(JPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
        );

        pack();
    }            

	private JLabel AvatarImageLabel;
	private JLabel AvatarLabel;
	private JLabel EmptyNickNameLabel;
	private JPanel JPanel1;
	private JPanel JPanel2;
	private JButton NextButton;
	private JLabel NickNameLabel;
	private JButton PreviousButton;
	private JButton exitButton;
	private JLabel jLabel1;
	private JButton playButton;
    private JLabel GamesLossLabel;
    private JLabel GamesPlayedLabel;
    private JLabel GamesWonLabel; 

	@Override
	public void update(Observable o, Object arg) 
	{
		this.setPos((Integer) arg);
	}
}
