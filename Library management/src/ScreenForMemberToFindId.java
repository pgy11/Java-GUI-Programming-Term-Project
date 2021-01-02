import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScreenForMemberToFindId {

	private JFrame frame;
	private JTextField pnText;
	private JDialog jd = new JDialog(frame,true);
	private JLabel jl;
 

	/**
	 * Create the application.
	 */
	public ScreenForMemberToFindId() {
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
		
		JLabel lblNewLabel = new JLabel("Phone number");
		lblNewLabel.setBounds(14, 116, 103, 18);
		frame.getContentPane().add(lblNewLabel);
		
		pnText = new JTextField();
		pnText.setBounds(143, 113, 116, 24);
		frame.getContentPane().add(pnText);
		pnText.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ScreenForMemberToFindId obj = new ScreenForMemberToFindId();
				try{
					int index = MemberManage.searchMemberUsingPhoneNumber((long)Integer.parseInt(pnText.getText()));
					if(index != -1){
						Member member = GlobalData.memberList.get(index);
						jd.setTitle("Warning!");
						jd.setBounds(200,200,200,100);
						jl = new JLabel("ID : " + member.getId() , JLabel.CENTER);
						jd.getContentPane().add(jl);
						jd.setVisible(true);
						jd.remove(jl);
						
						frame.dispose();
						ScreenForLogIn.displayScreen();
					}else{
						obj.displayNothingSearchedMessage();
					}
				}catch(Exception e1){
					obj.displayErrorMessage();
				}
			}
		});
		btnNewButton.setBounds(296, 112, 105, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ScreenForLogIn.displayScreen();
			}
		});
		btnNewButton_1.setBounds(296, 162, 105, 27);
		frame.getContentPane().add(btnNewButton_1);
	}
	
	public void displayErrorMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(200,200,200,100);
		jl = new JLabel("Unvalid value!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public void displayNothingSearchedMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(200,200,200,100);
		jl = new JLabel("Nothing searched!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public static void displayScreen(){
		try {
			ScreenForMemberToFindId window = new ScreenForMemberToFindId();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
