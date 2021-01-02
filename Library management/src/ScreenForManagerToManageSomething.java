import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScreenForManagerToManageSomething {

	private JFrame frame;

	

	/**
	 * Create the application.
	 */
	public ScreenForManagerToManageSomething() {
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
		
		JButton bookBtn = new JButton("Manage Book");
		bookBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ScreenForManagerToManageBook.displayScreen();
			}
		});
		bookBtn.setBounds(141, 55, 141, 27);
		frame.getContentPane().add(bookBtn);
		
		JButton btnManageMember = new JButton("Manage Member");
		btnManageMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ScreenForManagerToManageMember.displayScreen();
			}
		});
		btnManageMember.setBounds(141, 94, 141, 27);
		frame.getContentPane().add(btnManageMember);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				InitialScreen.displayScreen();
				
			}
		});
		btnBack.setBounds(141, 172, 141, 27);
		frame.getContentPane().add(btnBack);
		
		JButton btnChangePassword = new JButton("Change password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ScreenForManageToChangePassword.displayScreen();
			}
		});
		btnChangePassword.setBounds(141, 133, 141, 27);
		frame.getContentPane().add(btnChangePassword);
	}
	
	public static void displayScreen(){
		try {
			ScreenForManagerToManageSomething window = new ScreenForManagerToManageSomething();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
