import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScreenForLogIn {

	private JFrame frame;
	private JTextField idText;
	private JPasswordField passwordText;
	private JDialog jd;
	private JLabel jl;

	/**
	 * Create the application.
	 */
	public ScreenForLogIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 468, 322);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(90, 90, 18, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(68, 138, 77, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		idText = new JTextField();
		idText.setBounds(159, 87, 116, 24);
		frame.getContentPane().add(idText);
		idText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Log - In");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel_2.setBounds(164, 30, 83, 45);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(InitialScreen.check){
				case 0:
					try{if(GlobalData.manager.checkLogIn(Integer.parseInt(idText.getText()), passwordText.getText())){
						frame.dispose();
						ScreenForManagerToManageSomething.displayScreen();
					}
					else{
						jd = new JDialog(frame,true);
						jd.setTitle("Warning!");
						jl = new JLabel("Fail to log in",JLabel.CENTER);
						jd.getContentPane().add(jl);
						jd.setBounds(200,200,200,100);
						jd.setVisible(true);
					}
					}catch(Exception e1){
						jd = new JDialog(frame,true);
						jl = new JLabel("Unvalid value!",JLabel.CENTER);
						jd.setTitle("Warning!");
						jd.getContentPane().add(jl);
						jd.setBounds(200, 200, 200, 100);
						jd.setVisible(true);
					}
					break;
				case 1:
					try{
						if(MemberManage.logIn(Integer.parseInt(idText.getText()), passwordText.getText())){
						frame.dispose();
						ScreenForMemberToUseLibrary.displayScreen();
					}
					else{
						jd = new JDialog(frame,true);
						jd.setTitle("Warning!");
						jl = new JLabel("Fail to log in",JLabel.CENTER);
						jd.getContentPane().add(jl);
						jd.setBounds(200,200,200,100);
						jd.setVisible(true);
					}
					}catch(Exception e1){
						jd = new JDialog(frame,true);
						jl = new JLabel("Unvalid value!",JLabel.CENTER);
						jd.setTitle("Warning!");
						jd.getContentPane().add(jl);
						jd.setBounds(200, 200, 200, 100);
						jd.setVisible(true);
					}
					break;
				
					
				}
			}
		});
		btnNewButton.setBounds(90, 195, 105, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				InitialScreen.displayScreen();
			}
		});
		btnBack.setBounds(241, 195, 105, 27);
		frame.getContentPane().add(btnBack);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(159, 135, 116, 24);
		frame.getContentPane().add(passwordText);
		
		JButton signUpBtn = new JButton("Sign up");
		
		signUpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ScreenForMemberToSignUpLibrary.displayScreen();
			}
		});
		signUpBtn.setBounds(174, 236, 105, 27);
		frame.getContentPane().add(signUpBtn);
		
		JButton searchPasswordBtn = new JButton("Find password");
		
		
		searchPasswordBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ScreenForMemberToFindPassword.displayScreen();
			}
		});
		searchPasswordBtn.setBounds(309, 134, 127, 27);
		frame.getContentPane().add(searchPasswordBtn);
		
		JButton searchIdBtn = new JButton("Find ID");
		
		searchIdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ScreenForMemberToFindId.displayScreen();
			}
		});
		searchIdBtn.setBounds(309, 86, 127, 27);
		frame.getContentPane().add(searchIdBtn);
		
		if(InitialScreen.check == 0){
			searchIdBtn.setVisible(false);
			searchPasswordBtn.setVisible(false);
			signUpBtn.setVisible(false);
			System.out.println("GGG");
		}else{
			searchIdBtn.setVisible(true);
			searchPasswordBtn.setVisible(true);
			signUpBtn.setVisible(true);
		}
		
	}
	
	public static void displayScreen(){
		try {
			ScreenForLogIn window = new ScreenForLogIn();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
