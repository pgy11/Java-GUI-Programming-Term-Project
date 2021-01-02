import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScreenForMemberToReviseInformation {

	private JFrame frame;
	private JTextField idText;
	private JTextField nameText;
	private JTextField pnText;
	private JTextField addrText;
	private JPasswordField pwText1;
	private JPasswordField pwText2;
	private JDialog jd = new JDialog(frame,true);
	private JLabel jl;
    private int idCheck = 0;
    private int pnCheck = 0;
    private int flag = 0;
	/**
	 * Create the application.
	 */
	public ScreenForMemberToReviseInformation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 664, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(176, 102, 62, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(157, 144, 62, 18);
		frame.getContentPane().add(lblName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(138, 179, 81, 18);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblNewLabel_1 = new JLabel("Phone number");
		lblNewLabel_1.setBounds(109, 237, 110, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(150, 281, 62, 18);
		frame.getContentPane().add(lblAddress);
		
		idText = new JTextField();
		idText.setBounds(252, 99, 116, 24);
		frame.getContentPane().add(idText);
		idText.setColumns(10);
		
		nameText = new JTextField();
		nameText.setColumns(10);
		nameText.setBounds(252, 141, 116, 24);
		frame.getContentPane().add(nameText);
		
		pnText = new JTextField();
		pnText.setColumns(10);
		pnText.setBounds(252, 234, 116, 24);
		frame.getContentPane().add(pnText);
		
		addrText = new JTextField();
		addrText.setColumns(10);
		addrText.setBounds(252, 278, 116, 24);
		frame.getContentPane().add(addrText);
		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScreenForMemberToReviseInformation obj = new ScreenForMemberToReviseInformation();
				try{
					if(MemberManage.checkDuplicationUpdatedId(Integer.parseInt(idText.getText()))){
						obj.displayIdPossibleMessage();
						idCheck = 1;
					}else{
						obj.displayIdImpossibleMessage();
					}
					
				}catch(Exception e1){
					obj.displayErrorMessage();
				}
			}
		});
		btnNewButton.setBounds(418, 98, 105, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Check");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScreenForMemberToReviseInformation obj = new ScreenForMemberToReviseInformation();
				try{
					if(MemberManage.checkDuplicationUpdatedPhonenumber((long)Integer.parseInt(pnText.getText()))){
						obj.displayPhoneNumberPossibleMessage();
						pnCheck = 1;
					}else{
						obj.displayPhoneNumberImpossibleMessage();
					}
				}catch(Exception e2){
					obj.displayErrorMessage();
				}
			}
		});
		btnNewButton_1.setBounds(418, 233, 105, 27);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("OK");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScreenForMemberToReviseInformation obj = new ScreenForMemberToReviseInformation();
				try{
					Member member = GlobalData.memberList.get(GlobalData.memberLogInIndex);
					if(idCheck == 1){
						member.setId(Integer.parseInt(idText.getText()));
						flag = 1;
					}else if(!idText.getText().equals("")){
						obj.displayPressIdCheckButtonMessage();
					}
					if(!nameText.getText().equals("")){
						member.setName(nameText.getText());
						flag = 1;
					}
					if(pwText1.getText().equals(pwText2.getText())){
						if(!pwText1.getText().equals("")){
						member.setPassword(pwText1.getText());
						flag = 1;
						}
					}else {
						obj.displayPasswordNotCorrectedMessage();
					}
					if(pnCheck == 1){
						member.setPassword(pnText.getText());
						flag = 1;
					}else if(!pnText.getText().equals("")){
						obj.displayPressPhoneNumberCheckButtonMessage();
					}
					if(!addrText.getText().equals("")){
						member.setAddress(addrText.getText());
						flag = 1;
					}
					
					if(flag == 1){
						obj.displayRevisedCompletelyMessage();
						frame.dispose();
						ScreenForMemberToUseLibrary.displayScreen();
						
					}else{
						obj.displayNothingRevisedMessage();
					}
					
					
					
				}catch(Exception e3){
					obj.displayErrorMessage();
				}
			}
		});
		btnNewButton_2.setBounds(308, 344, 105, 27);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ScreenForMemberToUseLibrary.displayScreen();
				
			}
		});
		btnBack.setBounds(455, 344, 105, 27);
		frame.getContentPane().add(btnBack);
		
		pwText1 = new JPasswordField();
		pwText1.setBounds(251, 176, 117, 24);
		frame.getContentPane().add(pwText1);
		
		pwText2 = new JPasswordField();
		pwText2.setBounds(251, 206, 117, 24);
		frame.getContentPane().add(pwText2);
		
		JLabel lblCheckPassword = new JLabel("Check password");
		lblCheckPassword.setBounds(95, 207, 124, 18);
		frame.getContentPane().add(lblCheckPassword);
	}
	
	public static void displayScreen(){
		try {
			ScreenForMemberToReviseInformation window = new ScreenForMemberToReviseInformation();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void displayErrorMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(300,300,200,100);
		jl = new JLabel("Unvalid value!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public void displayNothingRevisedMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(300,300,200,100);
		jl = new JLabel("Nothing Reviesed!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public void displayRevisedCompletelyMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(300,300,200,100);
		jl = new JLabel("Reviesed completely!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public void displayIdPossibleMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(300,300,200,100);
		jl = new JLabel("ID possible!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public void displayIdImpossibleMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(300,300,200,100);
		jl = new JLabel("ID impossible!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public void displayPasswordNotCorrectedMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(300,300,200,100);
		jl = new JLabel("Password not corrected each other!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
		
	}
	
	public void displayPhoneNumberPossibleMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(300,300,200,100);
		jl = new JLabel("Phone number possible!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public void displayPhoneNumberImpossibleMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(300,300,200,100);
		jl = new JLabel("Phone number impossible!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public void displayPressIdCheckButtonMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(300,300,200,100);
		jl = new JLabel("Press ID Check Button!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public void displayPressPhoneNumberCheckButtonMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(300,300,200,100);
		jl = new JLabel("Press Phone number Check Button!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}

}
