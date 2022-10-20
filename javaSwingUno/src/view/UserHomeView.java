package view;

import model.LoginModel;

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

	public UserHomeView(LoginModel model) 
	{
		this.model = model;
		this.pos = model.getPos();
		initComponents();
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
    
    public JLabel getGamesWonLabel()
    {
    	return GamesWonLabel;
    }
    
    public JLabel getGamesLossLabel()
    {
    	return GamesLossLabel;
    }
    
    public JLabel getGamesPlayedLabel()
    {
    	return GamesPlayedLabel;
    }

    public JLabel getNickNameLabel()
    {
    	return NickNameLabel; 
    }
    
    public JLabel getAvatarLabel()
    {
    	return AvatarLabel;
    }
    
	/**
	 * initialize all of this frame's components and their settings.
	 */
	private void initComponents() {
		JPanel1 = new JPanel();
		jLabel1 = new JLabel();
		JPanel2 = new JPanel();
		NickNameLabel = new JLabel();
		AvatarLabel = new JLabel();
		AvatarImageLabel = new JLabel();
		EmptyNickNameLabel = new JLabel();
		PreviousButton = new JButton();
		NextButton = new JButton();
		playButton = new JButton();
		exitButton = new JButton();
        GamesWonLabel = new JLabel();
        GamesLossLabel = new JLabel();
        GamesPlayedLabel = new JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(255, 255, 255));

		JPanel1.setBackground(new java.awt.Color(53, 101, 77));

		jLabel1.setBackground(new java.awt.Color(53, 101, 77));
		jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(255, 255, 255));
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

		javax.swing.GroupLayout JPanel1Layout = new javax.swing.GroupLayout(JPanel1);
		JPanel1.setLayout(JPanel1Layout);
		JPanel1Layout.setHorizontalGroup(JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 400, Short.MAX_VALUE)
				.addGroup(JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(JPanel1Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
								.addComponent(jLabel1).addGap(0, 0, Short.MAX_VALUE))));
		JPanel1Layout.setVerticalGroup(JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE)
				.addGroup(JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(JPanel1Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
								.addComponent(jLabel1).addGap(0, 0, Short.MAX_VALUE))));

		JPanel2.setBackground(new java.awt.Color(255, 255, 255));
		JPanel2.setPreferredSize(new java.awt.Dimension(400, 299));

		javax.swing.GroupLayout JPanel2Layout = new javax.swing.GroupLayout(JPanel2);
        JPanel2.setLayout(JPanel2Layout);
        JPanel2Layout.setHorizontalGroup(
            JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanel2Layout.createSequentialGroup()
                .addGroup(JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JPanel2Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(exitButton)
                        .addGap(18, 18, 18)
                        .addComponent(playButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPanel2Layout.createSequentialGroup()
                                .addGroup(JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(AvatarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(NickNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
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
                                .addComponent(GamesWonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(110, 110, 110)
                                .addComponent(GamesLossLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(GamesPlayedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        JPanel2Layout.setVerticalGroup(
            JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GamesWonLabel)
                    .addComponent(GamesLossLabel)
                    .addComponent(GamesPlayedLabel))
                .addGap(16, 16, 16)
                .addGroup(JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(AvatarImageLabel))
                    .addGroup(JPanel2Layout.createSequentialGroup()
                        .addGroup(JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPanel2Layout.createSequentialGroup()
                                .addComponent(EmptyNickNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(PreviousButton))
                            .addGroup(JPanel2Layout.createSequentialGroup()
                                .addComponent(NickNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addComponent(AvatarLabel)))
                        .addGap(2, 2, 2)
                        .addComponent(NextButton)))
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

	// Variables declaration - do not modify
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
