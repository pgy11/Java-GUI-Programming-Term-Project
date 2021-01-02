import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScreenForManagerToManageMember {

	private JFrame frame;

 

	/**
	 * Create the application.
	 */
	public ScreenForManagerToManageMember() {
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
		
		JLabel label = new JLabel("");
		label.setBounds(68, 127, 62, 18);
		frame.getContentPane().add(label);
		
		JButton btnNewButton = new JButton("Display member");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(122, 35, 195, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSearchMember = new JButton("Search member");
		btnSearchMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GlobalData.manager.setManagerOption(10);
				frame.dispose();
				ScreenForManagerToSearchMember.displayScreen();
			}
		});
		btnSearchMember.setBounds(122, 74, 195, 27);
		frame.getContentPane().add(btnSearchMember);
		
		JButton btnDeleteMember = new JButton("Delete member\r\n");
		btnDeleteMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GlobalData.manager.setManagerOption(11);
				frame.dispose();
				ScreenForManagerToSearchMember.displayScreen();
			}
		});
		btnDeleteMember.setBounds(122, 113, 195, 27);
		frame.getContentPane().add(btnDeleteMember);
		
		JButton btnSendAMessage = new JButton("Send a message to member\r\n");
		btnSendAMessage.setBounds(122, 157, 195, 27);
		frame.getContentPane().add(btnSendAMessage);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ScreenForManagerToManageSomething.displayScreen();
			}
		});
		btnNewButton_1.setBounds(122, 196, 195, 27);
		frame.getContentPane().add(btnNewButton_1);
	}
	
	public static void displayScreen(){
		try {
			ScreenForManagerToManageMember window = new ScreenForManagerToManageMember();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
