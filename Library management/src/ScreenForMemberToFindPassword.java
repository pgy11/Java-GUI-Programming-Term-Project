import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScreenForMemberToFindPassword {

	private JFrame frame;
	private JTextField idText;
	private JDialog jd = new JDialog(frame,true);
	private JLabel jl;
	

	/**
	 * Create the application.
	 */
	public ScreenForMemberToFindPassword() {
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
		
		JLabel ID = new JLabel("ID");
		ID.setBounds(92, 113, 33, 18);
		frame.getContentPane().add(ID);
		
		idText = new JTextField();
		idText.setBounds(139, 110, 116, 24);
		frame.getContentPane().add(idText);
		idText.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScreenForMemberToFindPassword obj = new ScreenForMemberToFindPassword();
				int index;
				Member member;
				
				try{
					index = MemberManage.searchMemberUsingId(Integer.parseInt(idText.getText()));
					if(index != -1){
						member = GlobalData.memberList.get(index);
						jd.setTitle("Warning!");
						jd.setBounds(200,200,200,100);
						jl = new JLabel("Password : " + member.getPassword(),JLabel.CENTER);
						jd.getContentPane().add(jl);
						jd.setVisible(true);
						jd.remove(jl);
						frame.dispose();
						ScreenForLogIn.displayScreen();
						
					}else{
						obj.displayNotSearchedMessage();
						idText.setText("");
					}
				}catch(Exception e1){
					obj.displayErrorMessage();
				}
				
			}
		});
		btnNewButton.setBounds(302, 109, 105, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ScreenForLogIn.displayScreen();
			}
		});
		btnNewButton_1.setBounds(302, 162, 105, 27);
		frame.getContentPane().add(btnNewButton_1);
	}
	
	public static void displayScreen(){
		try {
			ScreenForMemberToFindPassword window = new ScreenForMemberToFindPassword();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void displayErrorMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(200,200,200,100);
		jl = new JLabel("Unvalid value!");
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public void displayNotSearchedMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(200,200,200,100);
		jl = new JLabel("Nothing searched!");
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
}
