package view;

import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.LoginModel;
import model.User;

/**
 *
 * @author matte
 */
public class SignUpFormView extends javax.swing.JFrame implements Observer
{

	private LoginModel model;
	private String nickName;
	private Integer pos;
	private User user;

	public SignUpFormView(LoginModel loginModel) throws IOException 
	{
		initComponents();
		this.model = loginModel;
		//model.setPos(0);		
	}

	public JLabel getAvatarImageLabel()
	{
		return AvatarImageLabel;
	}
	
	/**
	 * 
	 * @return pos field
	 */
	public Integer getPos() 
	{
		return pos;
	}

	/**
	 * 
	 * @param pos
	 * set this instance's pos to the passed Integer
	 */
	public void setPos(Integer pos) 
	{
		this.pos = pos;
	}

	/**
	 * 
	 * @return user Input on KeyBoard
	 */
	public String getTxtUser() 
	{
		return txtUser.getText().toString();
	}

	/**
	 * 
	 * @param user
	 * set this instance's user to the passed User;
	 */
	public void setUser(User user) 
	{
		this.user = user;
	}

	/**
	 * 
	 * @return user field
	 */
	public User getUser() 
	{
		return user;
	}

	/**
	 * 
	 * @return loginModel field
	 */
	public LoginModel getLoginModel() 
	{
		return model;
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
	 * @return NextButton variable
	 */
	public JButton getNextButton() 
	{
		return NextButton;
	}

	/**
	 * 
	 * @return txtUser variable
	 */
	public JTextField gettxtUser() 
	{
		return txtUser;
	}
	
	/**
	 * 
	 * @return SignUpButton variable
	 */
	public JButton getSignUpButton() 
	{
		return SignUpButton;
	}
	
	/**
	 * 
	 * @return NickNameLabel variable
	 */
	public JLabel getNickNameLabel()
	{
		return NickNameLabel;
	}
	
	/**
	 * 
	 * @return AvatarLabel variable
	 */
	public JLabel getAvatarLabel()
	{
		return AvatarLabel;
	}

	/**
	 * 
	 * @return UsernameFieldLabel variable
	 */
	public JLabel getUsernameFieldLabel()
	{
		return UsernameFieldLabel;
	}
	
	/**
	 * 
	 * @return jLabel1 variable
	 */
	public JLabel getjLabel1()
	{
		return jLabel1;
	}
	
	/**
	 * 
	 * @return jPanel1 variable
	 */
	public JPanel getjPanel1()
	{
		return jPanel1;
	}
	
	/**
	 * 
	 * @return jPanel2 variable
	 */
	public JPanel getjPanel2()
	{
		return jPanel2;
	}
	
	/**
	 * 
	 * @return A stringList with the names of the avatarImages
	 */
	public String[] getImages() 
	{
		File file = new File(".\\resources\\Avatars");
		String[] imageList = file.list();
		return imageList;
	}

	/**
	 * 
	 * @param index to set the AvatarImageLabel to the right Icon
	 * got by index.
	 */
	public void showImage(Integer index) 
	{
		String[] imagesList = getImages();
		String imageName = imagesList[index];
		Icon icon = new ImageIcon(".\\resources\\Avatars" + imageName);
		AvatarImageLabel.setIcon(icon);
	}

	private void initComponents() {
		jPanel2 = new JPanel();
		NickNameLabel = new JLabel();
		AvatarLabel = new JLabel();
		AvatarImageLabel = new JLabel();
		UsernameFieldLabel = new JLabel();
		txtUser = new JTextField();
		PreviousButton = new JButton();
		NextButton = new JButton();
		SignUpButton = new JButton();
		jPanel1 = new JPanel();
		jLabel1 = new JLabel();

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(26, 26, 26)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(NickNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(AvatarLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel2Layout.createSequentialGroup().addGap(26, 26, 26)
										.addComponent(AvatarImageLabel).addGap(37, 37, 37)
										.addGroup(jPanel2Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(PreviousButton).addComponent(NextButton)))
								.addGroup(jPanel2Layout.createSequentialGroup().addGap(6, 6, 6).addGroup(jPanel2Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 256,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(UsernameFieldLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 233,
												javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(18, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel2Layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(SignUpButton).addGap(173, 173, 173)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel2Layout.createSequentialGroup().addGap(28, 28, 28)
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(UsernameFieldLabel)
										.addComponent(NickNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(
												txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 12,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel2Layout.createSequentialGroup().addGap(53, 53, 53)
												.addComponent(PreviousButton).addGap(18, 18, 18)
												.addComponent(NextButton))
										.addGroup(jPanel2Layout.createSequentialGroup().addGap(18, 18, 18)
												.addComponent(AvatarImageLabel))
										.addGroup(jPanel2Layout.createSequentialGroup().addGap(70, 70, 70)
												.addComponent(AvatarLabel)))
								.addGap(33, 33, 33).addComponent(SignUpButton).addContainerGap(53, Short.MAX_VALUE)));


		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel1,
						javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(32, 32, 32).addComponent(jLabel1)
						.addContainerGap(36, Short.MAX_VALUE)));
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));
		pack();
		setLocationRelativeTo(null);
	}
	
	private JLabel AvatarImageLabel;
	private JLabel AvatarLabel;
	private JButton NextButton;
	private JLabel NickNameLabel;
	private JButton PreviousButton;
	private JButton SignUpButton;
	private JLabel UsernameFieldLabel;
	private JLabel jLabel1;
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JTextField txtUser;

	@Override
	public void update(Observable o, Object arg) 
	{
		if(arg.getClass().getName() == "java.lang.Integer")
			this.setPos((Integer) arg);
		if (arg.getClass().getName() == "model.User")
			this.setUser((User) arg);
		if(arg.getClass().getName() == "java.lang.String")
			this.setName((String) arg);
	}	
}
