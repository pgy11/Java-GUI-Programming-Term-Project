import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScreenForMemberToUseLibrary {

	private JFrame frame;
	private JLabel jl;
	private JDialog jd  = new JDialog(frame,true);

	 

	/**
	 * Create the application.
	 */
	public ScreenForMemberToUseLibrary() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 649, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Search or borrow book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GlobalData.memberList.get(GlobalData.memberLogInIndex).setMemberOption(2);
				frame.dispose();
				ScreenForManagerToSearchBook.displayScreen();
			}
		});
		btnNewButton.setBounds(193, 43, 213, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnRetrunBook = new JButton("Retrun  book");
		btnRetrunBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScreenForMemberToUseLibrary obj = new ScreenForMemberToUseLibrary();
				Member member = GlobalData.memberList.get(GlobalData.memberLogInIndex);
				if(member.getBorrowedBook().size() == 0){
					obj.displayNoBookBorrowedMessage();
				}else{
					GlobalData.memberList.get(GlobalData.memberLogInIndex).setMemberOption(3);
					frame.dispose();
					ScreenForMemberToUseBook.displayScreen();
				}
			}
		});
		btnRetrunBook.setBounds(193, 82, 213, 27);
		frame.getContentPane().add(btnRetrunBook);
		
		JButton btnCheckBookI = new JButton("Check book I borrowed");
		btnCheckBookI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = GlobalData.memberLogInIndex;
				Member member = GlobalData.memberList.get(index);
				ScreenForMemberToUseLibrary obj = new ScreenForMemberToUseLibrary();
				if(member.getBorrowedBook().size() == 0){
					obj.displayNoBookBorrowedMessage();
				}else{
					GlobalData.memberList.get(index).setMemberOption(4);
					frame.dispose();
					ScreenForMemberToUseBook.displayScreen();
				}
			}
		});
		btnCheckBookI.setBounds(193, 121, 213, 27);
		frame.getContentPane().add(btnCheckBookI);
		
		JButton btnSearchOrBorrow = new JButton("Revise my information");
		btnSearchOrBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GlobalData.memberList.get(GlobalData.memberLogInIndex).setMemberOption(0);
				frame.dispose();
				ScreenForMemberToEnterPassword.displayScreen();
			}
		});
		btnSearchOrBorrow.setBounds(193, 195, 213, 27);
		frame.getContentPane().add(btnSearchOrBorrow);
		
		JButton btnLeaveAMember = new JButton("Leave a member");
		btnLeaveAMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GlobalData.memberList.get(GlobalData.memberLogInIndex).setMemberOption(1);
				frame.dispose();
				ScreenForMemberToEnterPassword.displayScreen();
			}
		});
		btnLeaveAMember.setBounds(193, 234, 213, 27);
		frame.getContentPane().add(btnLeaveAMember);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScreenForMemberToUseLibrary obj = new ScreenForMemberToUseLibrary();
				obj.displayLogOutMessage();
				frame.dispose();
				ScreenForLogIn.displayScreen();
			}
		});
		btnLogOut.setBounds(193, 351, 213, 27);
		frame.getContentPane().add(btnLogOut);
		
		JButton btnSendAMessage = new JButton("Send a message to manager");
		btnSendAMessage.setBounds(193, 273, 213, 27);
		frame.getContentPane().add(btnSendAMessage);
		
		JButton btnReceiveMessageFrom = new JButton("Receive message from manager");
		btnReceiveMessageFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReceiveMessageFrom.setBounds(193, 312, 213, 27);
		frame.getContentPane().add(btnReceiveMessageFrom);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScreenForMemberToUseLibrary obj = new ScreenForMemberToUseLibrary();
				obj.displayLogOutMessage();
				frame.dispose();
				ScreenForLogIn.displayScreen();
				
			}
		});
		btnBack.setBounds(193, 390, 213, 27);
		frame.getContentPane().add(btnBack);
		
		JButton btnProlongBook = new JButton("Prolong book");
		btnProlongBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScreenForMemberToUseLibrary obj = new ScreenForMemberToUseLibrary();
				if(GlobalData.memberList.get(GlobalData.memberLogInIndex).getBorrowedBook().size()>0){
					GlobalData.memberList.get(GlobalData.memberLogInIndex).setMemberOption(5);
					frame.dispose();
					ScreenForMemberToUseBook.displayScreen();
				}else{
					obj.displayNoBookBorrowedMessage();
				}
			}
		});
		btnProlongBook.setBounds(193, 160, 213, 27);
		frame.getContentPane().add(btnProlongBook);
	}
	
	
	public void displayErrorMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(200,200,200,100);
		jl = new JLabel("Unvalid value!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public void displayLogOutMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(200,200,200,100);
		jl = new JLabel("Log out!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public void displayNoBookBorrowedMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(200,200,200,100);
		jl = new JLabel("No book you borrow!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public static void displayScreen(){
		try {
			ScreenForMemberToUseLibrary window = new ScreenForMemberToUseLibrary();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
