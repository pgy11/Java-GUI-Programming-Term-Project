import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScreenForManageToChangePassword {

	private JFrame frame;
	private JPasswordField currentText;
	private JPasswordField pwText1;
	private JPasswordField pwText2;
	private JDialog jd = new JDialog(frame,true);
	private JLabel jl;

	 

	/**
	 * Create the application.
	 */
	public ScreenForManageToChangePassword() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel currentpwText = new JLabel("Current Password");
		currentpwText.setBounds(75, 77, 125, 18);
		frame.getContentPane().add(currentpwText);
		
		JLabel changedPwText1 = new JLabel("Password to be changed");
		changedPwText1.setBounds(32, 121, 168, 18);
		frame.getContentPane().add(changedPwText1);
		
		JLabel changedPwText2 = new JLabel("check changed password");
		changedPwText2.setBounds(32, 167, 168, 18);
		frame.getContentPane().add(changedPwText2);
		
		currentText = new JPasswordField();
		currentText.setBounds(234, 74, 148, 21);
		frame.getContentPane().add(currentText);
		
		pwText1 = new JPasswordField();
		pwText1.setBounds(234, 118, 148, 21);
		frame.getContentPane().add(pwText1);
		
		pwText2 = new JPasswordField();
		pwText2.setBounds(234, 167, 148, 21);
		frame.getContentPane().add(pwText2);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScreenForManageToChangePassword obj = new ScreenForManageToChangePassword();
				Manager manager = GlobalData.manager;
				if(currentText.getText().equals(manager.getPassword())){
					if(!pwText1.getText().equals("")){
					if(pwText1.getText().equals(pwText2.getText())){
						GlobalData.manager.setPassword(pwText1.getText());
						obj.displayChangedCompletelyMessage();
						frame.dispose();
						ScreenForLogIn.displayScreen();
					}else{
						obj.displayChangedPasswordNotCorrectedMessage();
						currentText.setText("");
						pwText1.setText("");
						pwText1.setText("");
					}
					}else{
						obj.displayEnterChangedPasswordMessage();
						currentText.setText("");
						pwText1.setText("");
						pwText1.setText("");
					}
				}else{
					obj.displayCurrentPasswordNotCorrectedMessage();
					currentText.setText("");
					pwText1.setText("");
					pwText1.setText("");
				}
			}
		});
		btnNewButton.setBounds(133, 214, 105, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ScreenForManagerToManageSomething.displayScreen();
			}
		});
		btnNewButton_1.setBounds(278, 214, 105, 27);
		frame.getContentPane().add(btnNewButton_1);
	}
	
	public void displayChangedCompletelyMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(200,200,200,100);
		jl = new JLabel("Changed completely!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public void displayCurrentPasswordNotCorrectedMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(200,200,200,100);
		jl = new JLabel("Current password not corrected!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public void displayChangedPasswordNotCorrectedMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(200,200,200,100);
		jl = new JLabel("Changed password not corrected each other!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public void displayEnterChangedPasswordMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(200,200,200,100);
		jl = new JLabel("Enter a  password to be changed!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public static void displayScreen(){
		try {
			ScreenForManageToChangePassword window = new ScreenForManageToChangePassword();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
