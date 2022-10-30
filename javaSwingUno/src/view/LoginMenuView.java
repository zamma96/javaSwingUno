package view;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.DataBase;
import model.LoginModel;
import model.User;

public class LoginMenuView extends javax.swing.JFrame implements Observer
{
	private LoginModel loginModel;
	private String nickName;
	private Integer pos;

	//constructor
    public LoginMenuView(LoginModel model) throws IOException 
    {
    	loginModel = model;
    	initComponents();
    }
    
    /**
     * 
     * @return user input on textField
     */
    public String getTxtUser() 
    {
    	return txtUser.getText().toString();
    }
    
    /**
     * 
     * @return current database instance
     */
    public DataBase getDataBase() 
    {
    	return loginModel.getDataBase();
    }
    
    /**
     * 
     * @return LoginButton variable
     */
    public JButton getLoginButton()
    {
    	return LoginButton;
    }
   
    /**
     * 
     * @return SignUpButton variable
     */
    public JButton getSignUpButton()
    {
    	return SignUpButton;
    }
    
    public JLabel getSignUpLabel()
    {
    	return SignUpLabel;
    }
    
    /**
     * 
     * @return the current model instance
     */
    public LoginModel getLoginModel() 
    {
    	return loginModel;
    }
                  
    /**
     * 
     * @return user's nickName
     */
    public String getNickName() 
    {
    	return nickName;
    }
    
    /**
     * 
     * @param nickName used in update() method to change this instance's nickName.
     */
    public void setNickName(String nickName) 
    {
    	this.nickName = nickName;
    }
    
    public void setPos(Integer pos)
    {
    	this.pos = pos;
    }
    
    /**
     * 
     * @return jLabel2 used in controller method to change this label's Icon.
     */
    public JLabel getjLabel2()
    {
    	return jLabel2;
    }
    
    /**
     * 
     * @return LoginLabel variable
     */
    public JLabel getLoginLabel()
    {
    	return LoginLabel;
    }
    
    /**
     * 
     * @return WelcomeLabel variable
     */
    public JLabel getWelcomeLabel()
    {
    	return WelcomeLabel;
    }
    
    /**
     * 
     * @return Usernameabel variable
     */
    public JLabel getUsernameLabel()
    {
    	return UsernameLabel;
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
     * @return UsernameFieldLabel variable
     */
    public JLabel getUsernameFieldLabel()
    {
    	return UsernameFieldLabel;
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
     * init of all components of this view.
     */
    private void initComponents() 
    {
        jPanel1 = new JPanel();
        jLabel2 = new JLabel();
        jPanel2 = new JPanel();
        LoginLabel = new JLabel();
        WelcomeLabel = new JLabel();
        UsernameLabel = new JLabel();
        txtUser = new JTextField();
        UsernameFieldLabel = new JLabel();
        LoginButton = new JButton();
        SignUpLabel = new JLabel();
        SignUpButton = new JButton();
     
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );
        
        
        
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LoginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(WelcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(UsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UsernameFieldLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(SignUpLabel)
                        .addGap(50, 50, 50)
                        .addComponent(SignUpButton)))
                .addGap(41, 41, 41))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(LoginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(WelcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(UsernameLabel)
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UsernameFieldLabel))))
                .addGap(28, 28, 28)
                .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SignUpLabel)
                    .addComponent(SignUpButton))
                .addGap(88, 88, 88))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }                     
                  
    private JButton LoginButton;
    private JLabel LoginLabel;
    private JButton SignUpButton;
    private JLabel SignUpLabel;
    private JLabel UsernameFieldLabel;
    private JLabel UsernameLabel;
    private JLabel WelcomeLabel;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JTextField txtUser;

	@Override
	public void update(Observable o, Object arg) 
	{
		if (arg.getClass().getName().equals("java.lang.String"))
			this.setNickName((String) arg);
		else if (arg.getClass().getName().equals("java.lang.Integer"))
			this.setPos((Integer)arg);
	}                
}
