import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScreenForManagerToDisplayMember {

	private JFrame frame;
	private JTextField idText;
	private JDialog jd = new JDialog(frame, true);
	private JLabel jl;
	 

	/**
	 * Create the application.
	 */
	public ScreenForManagerToDisplayMember() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 871, 587);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(36, 71, 40, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(90, 71, 62, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Phone number\r\n");
		lblNewLabel_2.setBounds(150, 71, 95, 18);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setBounds(296, 71, 62, 18);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblDateCreated = new JLabel("Date created");
		lblDateCreated.setBounds(401, 71, 83, 18);
		frame.getContentPane().add(lblDateCreated);
		
		JLabel lblBookBorrowed = new JLabel("Book borrowed");
		lblBookBorrowed.setBounds(515, 71, 105, 18);
		frame.getContentPane().add(lblBookBorrowed);
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setBounds(58, 26, 62, 18);
		frame.getContentPane().add(idLabel);
		
		idText = new JTextField();
		
		idText.setBounds(134, 23, 116, 24);
		frame.getContentPane().add(idText);
		idText.setColumns(10);
		
		JButton okBtn = new JButton("OK");
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScreenForManagerToDisplayMember obj = new ScreenForManagerToDisplayMember();
				try{
					int index = MemberManage.searchMemberUsingId(Integer.parseInt(idText.getText()));
					if(index != -1){
						if(GlobalData.memberList.get(index).getBorrowedBook().size() == 0){
						GlobalData.memberList.remove(index);
						obj.displayDeletedMessage();
						}else{
							obj.displayFailToDeleteMessage();
						}
					}else{
						obj.displayNothingsearched();
					}
				}catch(Exception e1){
					obj.displayErrorMessage();
				}
			}
		});
		okBtn.setBounds(286, 22, 105, 27);
		frame.getContentPane().add(okBtn);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(14, 119, 603, 409);
		frame.getContentPane().add(textArea);
		
		JTextArea textArea2 = new JTextArea();
		textArea2.setBounds(617, 119, 232, 409);
		frame.getContentPane().add(textArea2);
		
		JLabel lblBorrowedDate = new JLabel("Borrowed date");
		lblBorrowedDate.setBounds(636, 71, 105, 18);
		frame.getContentPane().add(lblBorrowedDate);
		
		JLabel lblReturnDate = new JLabel("Return date");
		lblReturnDate.setBounds(744, 71, 105, 18);
		frame.getContentPane().add(lblReturnDate);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ScreenForManagerToManageMember.displayScreen();
			}
		});
		btnNewButton.setBounds(515, 22, 105, 27);
		frame.getContentPane().add(btnNewButton);
		ScreenForManagerToSearchMember obj = new ScreenForManagerToSearchMember();
		ArrayList<Integer> indexList = new ArrayList<>();
		int index = obj.getIndex();
		indexList = obj.getIndexList();
		Member member;
		if(GlobalData.manager.getManagerOption()==10){
		
			idLabel.setVisible(false);
			idText.setVisible(false);
			okBtn.setVisible(false);
			if(indexList.size() == 0){
				member  = GlobalData.memberList.get(index);
				textArea.append(Integer.toString(member.getId()) + "\t");
				textArea.append(member.getName() + "\t");
				textArea.append(Integer.toString((int)member.getPhoneNumber()) + "\t");
				textArea.append(member.getAddress() + "\t");
				textArea.append(member.getDateCreated() + "\n");
				
				if(member.getBorrowedBook().size()>0){
					for(int i=0;i<member.getBorrowedBook().size();i++){
						Book book = member.getBorrowedBook().get(i);
						textArea2.append(book.getName() + "\t");
						textArea2.append(member.getBorrowedBook().get(i).getDateBorrowed()  +"\t");
						textArea2.append(member.getBorrowedBook().get(i).getDateRetuend() + "\n");
						
					}
					
				}
			}else{
				for(int i=0; i<indexList.size();i++){
				 member = GlobalData.memberList.get(indexList.get(i).intValue());
				 textArea.append(Integer.toString(member.getId()) + "\t");
					textArea.append(member.getName() + "\t");
					textArea.append(Integer.toString((int)member.getPhoneNumber()) + "\t");
					textArea.append(member.getAddress() + "\t");
					textArea.append(member.getDateCreated() + "\t");
				}
			}
			
		}else{
			idLabel.setVisible(true);
			idText.setVisible(true);
			okBtn.setVisible(true);
			if(indexList.size() == 0){
				member  = GlobalData.memberList.get(index);
				textArea.append(Integer.toString(member.getId()) + "\t");
				textArea.append(member.getName() + "\t");
				textArea.append(Integer.toString((int)member.getPhoneNumber()) + "\t");
				textArea.append(member.getAddress() + "\t");
				textArea.append(member.getDateCreated() + "\t");
				if(member.getBorrowedBook().size()>0){
					for(int i=0;i<member.getBorrowedBook().size();i++){
						Book book = member.getBorrowedBook().get(i);
						textArea2.append(book.getName() + "\n");
						
					}
					
				}
			}else{
				for(int i=0; i<indexList.size();i++){
				 member = GlobalData.memberList.get(indexList.get(i).intValue());
				 textArea.append(Integer.toString(member.getId()) + "\t");
					textArea.append(member.getName() + "\t");
					textArea.append(Integer.toString((int)member.getPhoneNumber()) + "\t");
					textArea.append(member.getAddress() + "\t");
					textArea.append(member.getDateCreated() + "\t");
				}
		}}
	}
	
	public static void displayScreen(){
		try {
			ScreenForManagerToDisplayMember window = new ScreenForManagerToDisplayMember();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public  void displayNothingsearched(){
		jd = new JDialog(frame,true);
		jl = new JLabel("Nothing searched!");
		jd.setTitle("Warning!");
		jd.getContentPane().add(jl);
		jd.setBounds(200,200,200,100);
		jd.setVisible(true);
	}
	
	public void displayErrorMessage(){
		jd = new JDialog(frame,true);
		jl = new JLabel("Unvalid value!");
		jd.setTitle("Warning!");
		jd.getContentPane().add(jl);
		jd.setBounds(200,200,200,100);
		jd.setVisible(true);
	}
	
	public void displayDeletedMessage(){
		jd = new JDialog(frame,true);
		jl = new JLabel("Deleted completely!");
		jd.setTitle("Warning!");
		jd.getContentPane().add(jl);
		jd.setBounds(200,200,200,100);
		jd.setVisible(true);
	}
	
	public void displayFailToDeleteMessage(){
		jd = new JDialog(frame,true);
		jl = new JLabel("Member doesn't return book!");
		jd.setTitle("Warning!");
		jd.getContentPane().add(jl);
		jd.setBounds(200,200,200,100);
		jd.setVisible(true);
	}
}
