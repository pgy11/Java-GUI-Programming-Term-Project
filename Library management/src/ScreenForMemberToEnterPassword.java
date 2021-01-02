import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScreenForMemberToEnterPassword {

	private JFrame frame;
	private JPasswordField pwText;
	private JDialog jd = new JDialog(frame,true);
	private JLabel jl;
	 

	/**
	 * Create the application.
	 */
	public ScreenForMemberToEnterPassword() {
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
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setBounds(71, 111, 84, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScreenForMemberToEnterPassword obj = new ScreenForMemberToEnterPassword();
				int index = MemberManage.checkPassword(pwText.getText());
				if(index == GlobalData.memberLogInIndex){
					Member member;
					switch(GlobalData.memberList.get(index).getMemberOption()){
					case 0:
						frame.dispose();
						ScreenForMemberToReviseInformation.displayScreen();
						break;
						
					case 1:
						
						member = GlobalData.memberList.get(index);
						if(member.getBorrowedBook().size() == 0){
							GlobalData.memberList.remove(index);
							obj.displayLeavedCompletelyMessage();
							frame.dispose();
							ScreenForLogIn.displayScreen();
						}else{
							obj.displayFailToLeaveMessage();
							frame.dispose();
							ScreenForMemberToUseLibrary.displayScreen();
						}
						break;
					}
					
					
				}else{
					obj.displayFailToLogInMessage();
					pwText.setText("");
				}
			}
		});
		btnNewButton.setBounds(313, 107, 105, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ScreenForMemberToUseLibrary.displayScreen();
			}
		});
		btnBack.setBounds(313, 150, 105, 27);
		frame.getContentPane().add(btnBack);
		
		pwText = new JPasswordField();
		pwText.setBounds(156, 108, 125, 24);
		frame.getContentPane().add(pwText);
	}
	
	public void displayFailToLogInMessage(){
		jd = new JDialog(frame,true);
		jd.setTitle("Warning!");
		jl = new JLabel("Fail to log in",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setBounds(200,200,200,100);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public void displayLeavedCompletelyMessage(){
		jd = new JDialog(frame,true);
		jd.setTitle("Warning!");
		jl = new JLabel("Member leaved completely!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setBounds(200,200,200,100);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public void displayFailToLeaveMessage(){
		jd = new JDialog(frame,true);
		jd.setTitle("Warning!");
		jl = new JLabel("Return book first!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setBounds(200,200,200,100);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	
	public static void displayScreen(){
		try {
			ScreenForMemberToEnterPassword window = new ScreenForMemberToEnterPassword();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
