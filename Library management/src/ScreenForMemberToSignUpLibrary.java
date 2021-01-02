import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ScreenForMemberToSignUpLibrary {

	private JFrame frame;
	private JTextField idText;
	private JTextField nameText;
	private JTextField pnText;
	private JTextField addrText;
	private int check = 0;
	private int flag = 0;
	private JDialog jd = new JDialog(frame,true);
	private  JLabel jl;
	private JPasswordField pwText1;
	private JPasswordField pwText2;
	

	/**
	 * Create the application.
	 */
	public ScreenForMemberToSignUpLibrary() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 505, 349);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(132, 54, 21, 18);
		frame.getContentPane().add(lblId);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(116, 143, 62, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(84, 84, 94, 18);
		frame.getContentPane().add(lblPassword);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(55, 143, 62, 18);
		frame.getContentPane().add(label_2);
		
		JLabel lblNewLabel_1 = new JLabel("Check Password");
		lblNewLabel_1.setBounds(40, 114, 113, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(55, 143, 62, 18);
		frame.getContentPane().add(label_4);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setBounds(55, 172, 106, 18);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setBounds(97, 203, 62, 18);
		frame.getContentPane().add(lblNewLabel_2);
		
		idText = new JTextField();
		idText.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				check = 0;
			}
		});
		idText.setBounds(188, 51, 116, 24);
		frame.getContentPane().add(idText);
		idText.setColumns(10);
		
		nameText = new JTextField();
		nameText.setEnabled(false);
		nameText.setColumns(10);
		nameText.setBounds(188, 140, 116, 24);
		frame.getContentPane().add(nameText);
		
		pnText = new JTextField();
		pnText.setEnabled(false);
		pnText.setColumns(10);
		pnText.setBounds(188, 169, 116, 24);
		frame.getContentPane().add(pnText);
		
		addrText = new JTextField();
		addrText.setEnabled(false);
		addrText.setColumns(10);
		addrText.setBounds(188, 200, 116, 24);
		frame.getContentPane().add(addrText);
		
		JButton checkIdBtn = new JButton("Check ID");
		checkIdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScreenForMemberToSignUpLibrary obj = new ScreenForMemberToSignUpLibrary();
				try{
					if(MemberManage.checkDuplicationaddedId(Integer.parseInt(idText.getText()))){
						obj.displayIdPossibleMessage();
						pwText1.setEnabled(true);
						pwText2.setEnabled(true);
						nameText.setEnabled(true);
						pnText.setEnabled(true);
						addrText.setEnabled(true);
						
						check = 1;
					}else{
						obj.displayIdImpossibleMessage();
					}
				}catch(Exception e1){
					obj.displayErrorMessage();
					
				}
			}
		});
		checkIdBtn.setBounds(337, 50, 105, 27);
		frame.getContentPane().add(checkIdBtn);
		
		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScreenForMemberToSignUpLibrary obj = new ScreenForMemberToSignUpLibrary();
				if(check ==1 && flag ==1){
					if(pwText1.getText().equals(pwText2.getText())){
						if(!nameText.getText().equals("") && !addrText.getText().equals("")){
							try{
								MemberManage.signUpMember(Integer.parseInt(idText.getText()), pwText1.getText(), nameText.getText(), 
										(long)Integer.parseInt(pnText.getText()), addrText.getText());
								obj.displaySignUpMessage();
								frame.dispose();
								ScreenForLogIn.displayScreen();
							}catch(Exception e2){
								obj.displayErrorMessage();
							}
						}else{
							obj.displayFillTheBlackMessage();
						}
					}else{
						obj.displayWrongPasswordMessage();
					}
				}else{
					obj.displayCheckIdMessage();
				}
				
			}
		});
		btnNewButton_1.setBounds(235, 247, 105, 27);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				InitialScreen.displayScreen();
			}
		});
		btnNewButton_2.setBounds(368, 247, 105, 27);
		frame.getContentPane().add(btnNewButton_2);
		
		pwText1 = new JPasswordField();
		pwText1.setEnabled(false);
		pwText1.setBounds(188, 81, 116, 24);
		frame.getContentPane().add(pwText1);
		
		pwText2 = new JPasswordField();
		pwText2.setEnabled(false);
		pwText2.setBounds(188, 111, 116, 24);
		frame.getContentPane().add(pwText2);
		
		JButton btnNewButton = new JButton("Check ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScreenForMemberToSignUpLibrary obj = new ScreenForMemberToSignUpLibrary();
				try{
					if(MemberManage.checkDuplicationaddedPhonenumber((long)Integer.parseInt(pnText.getText()))){
						obj.displayPhoneNumberPossibleMessage();
						flag = 1;
				}else{
					obj.displayPhoneNumberImpossibleMessage();
				}
				 }catch(Exception e1){
					 obj.displayErrorMessage();
				 }
			}
		});
		btnNewButton.setBounds(337, 168, 105, 27);
		frame.getContentPane().add(btnNewButton);
	}
	public void displayErrorMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(200,200,200,100);
		jl = new JLabel("Unvalid value!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public void displayIdPossibleMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(200,200,200,100);
		jl = new JLabel("ID possible!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public void displayIdImpossibleMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(200,200,200,100);
		jl = new JLabel("ID already exists!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public void displaySignUpMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(200,200,200,100);
		jl = new JLabel("Signed up completely!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public void displayWrongPasswordMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(200,200,200,100);
		jl = new JLabel("Password is not correct each other!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public void displayFillTheBlackMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(200,200,200,100);
		jl = new JLabel("Fill the blank!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public void displayCheckIdMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(200,200,200,100);
		jl = new JLabel("Press each Check Button!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public static void displayScreen(){
		try {
			ScreenForMemberToSignUpLibrary window = new ScreenForMemberToSignUpLibrary();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void displayPhoneNumberPossibleMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(200,200,200,100);
		jl = new JLabel("Phone number available!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public void displayPhoneNumberImpossibleMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(200,200,200,100);
		jl = new JLabel("Phone number not available!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
}
