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

import model.DataBase;
import model.LoginModel;
import model.User;

public class LoginMenuView extends javax.swing.JFrame implements Observer
{
	private LoginModel loginModel;
	private String nickName;

	//constructor
    public LoginMenuView(LoginModel model) throws IOException 
    {
    	loginModel = model;
    	initComponents();
    }
    
    /**
     * 
     * @return the current model instance
     */
    public LoginModel getLoginModel() {return loginModel;}
                  
    /**
     * 
     * @return user's nickName
     */
    public String getNickName() {return nickName;}
    
    /**
     * 
     * @param nickName used in update() method to change this instance's nickName.
     */
    public void setNickName(String nickName) {this.nickName = nickName;}
    
    /**
     * 
     * @return jLabel2 used in controller method to change this label's Icon.
     */
    public JLabel getjLabel2()
    {
    	return jLabel2;
    }
    
    /**
     * init of all components of this view.
     */
    private void initComponents() 
    {
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        LoginLabel = new javax.swing.JLabel();
        WelcomeLabel = new javax.swing.JLabel();
        UsernameLabel = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        UsernameFieldLabel = new javax.swing.JLabel();
        UsernameIconLabel = new javax.swing.JLabel();
        LoginButton = new javax.swing.JButton();
        SignUpLabel = new javax.swing.JLabel();
        SignUpButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(655, 386));
        setResizable(false);
     
        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource(".\\resources\\LoginImg\\unoLogo.png")));

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

        jPanel2.setBackground(new java.awt.Color(53, 101, 77));

        LoginLabel.setFont(new java.awt.Font("Segoe UI", 0, 32));
        LoginLabel.setForeground(new java.awt.Color(255, 255, 255));
        LoginLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoginLabel.setText("Login");

        WelcomeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        WelcomeLabel.setForeground(new java.awt.Color(255, 255, 255));
        WelcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WelcomeLabel.setText("Hello! Let's play!");

        UsernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        UsernameLabel.setForeground(new java.awt.Color(255, 255, 255));
        UsernameLabel.setText("Username:");

        txtUser.setBackground(new java.awt.Color(53, 101, 77));
        txtUser.setFont(txtUser.getFont().deriveFont(txtUser.getFont().getSize()+2f));
        txtUser.setForeground(new java.awt.Color(255, 255, 255));
        txtUser.setBorder(null);

        UsernameFieldLabel.setForeground(new java.awt.Color(255, 255, 255));
        UsernameFieldLabel.setText("________________________________________________________");

        UsernameIconLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UsernameIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(".\\resources\\LoginImg\\icons8_customer_20px_2.png")));

        LoginButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
        LoginButton.setForeground(new java.awt.Color(53, 101, 77));
        LoginButton.setText("LOGIN");

        SignUpLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        SignUpLabel.setForeground(new java.awt.Color(255, 255, 255));
        SignUpLabel.setText("Don't have an account?");

        SignUpButton.setBackground(new java.awt.Color(53, 101, 77));
        SignUpButton.setForeground(new java.awt.Color(255, 255, 255));
        SignUpButton.setText("Sign Up");
        SignUpButton.setBorder(null);

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
                            .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(UsernameIconLabel))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(SignUpLabel)
                        .addGap(38, 38, 38)
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
                            .addComponent(UsernameFieldLabel)
                            .addComponent(UsernameIconLabel))))
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }                      

    //END OF INIT
    
    /**
     * 
     * @return user input on textField
     */
    public String getTxtUser() {return txtUser.getText().toString();}
    
    /**
     * 
     * @return current database instance
     */
    public DataBase getDataBase() {return loginModel.getDataBase();}
    
    public JButton getLoginButton(){return LoginButton;}
    
    public JButton getSignUpButton(){return SignUpButton;}

                  
    private javax.swing.JButton LoginButton;
    private javax.swing.JLabel LoginLabel;
    private javax.swing.JButton SignUpButton;
    private javax.swing.JLabel SignUpLabel;
    private javax.swing.JLabel UsernameFieldLabel;
    private javax.swing.JLabel UsernameIconLabel;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JLabel WelcomeLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtUser;

	@Override
	public void update(Observable o, Object arg) 
	{
		this.setNickName((String) arg);
	}                
}
