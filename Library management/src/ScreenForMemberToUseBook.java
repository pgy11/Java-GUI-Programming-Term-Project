import java.awt.*;
import java.util.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScreenForMemberToUseBook {

	private JFrame frame;
	private JTextField idText;
	private JDialog jd = new JDialog(frame,true);
	private JLabel jl ;
	 

	/**
	 * Create the application.
	 */
	public ScreenForMemberToUseBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 813, 537);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(14, 114, 767, 364);
		frame.getContentPane().add(textArea);
		
		JLabel sLabel = new JLabel("Serial number");
		sLabel.setBounds(28, 39, 97, 18);
		frame.getContentPane().add(sLabel);
		
		idText = new JTextField();
		idText.setBounds(156, 36, 116, 24);
		frame.getContentPane().add(idText);
		idText.setColumns(10);
		
		JButton okBtn = new JButton("OK");
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScreenForMemberToUseBook obj = new ScreenForMemberToUseBook();
				int flag = GlobalData.memberLogInIndex;
				int index;
				Book book;
				Member member = GlobalData.memberList.get(GlobalData.memberLogInIndex);
				switch(member.getMemberOption()){
				case 2:
					try{
					index = BookManage.searchBookUsingSerialNumber(Integer.parseInt(idText.getText()));
					
					if(index !=-1){
						book = GlobalData.bookList.get(index);
						if(GlobalData.memberList.get(flag).getBorrowedBook().size() <=5){
							if(book.getAmount() >0){
						book.setDateBorrowed();
						book.setDateReturned();
						GlobalData.bookList.get(index).decrementAmount();
						GlobalData.memberList.get(flag).setBookToBorrow(book);
						obj.displayBorrowedCompletelyMessage();
						idText.setText("");
							}else{
								obj.displayNoAmountMessage();
							}
					}else{
						obj.displayFullBookMessage();
					}
						}else{
							obj.displayNothinSearchedMessage();
						}
					}catch(Exception e1){
						obj.displayErrorMessage();
					}
					break;
				
				case 3:
					try{
						int mindex = BookManage.SearchBookMemberBorrowedUsingSerialNumber(member, Integer.parseInt(idText.getText()));
						
						if( mindex != -1){
							GlobalData.memberList.get(flag).getBorrowedBook().remove(mindex);
							int bindex = BookManage.searchBookUsingSerialNumber(Integer.parseInt(idText.getText()));
							GlobalData.bookList.get(bindex).incrementAmount();
							obj.displayReturnedCompletelyMessage();
						}else{
							obj.displayNothinSearchedMessage();
						}
					}catch(Exception e2){
						obj.displayErrorMessage();
					}
					break;
					
				case 5:
					try{
						int mindex = BookManage.SearchBookMemberBorrowedUsingSerialNumber(member, Integer.parseInt(idText.getText()));
						
						if( mindex != -1){
							GlobalData.memberList.get(flag).getBorrowedBook().get(mindex).prolongReturnDate();
							obj.displayProlongedCompletelyMessage();
						}else{
							obj.displayNothinSearchedMessage();
						}
						
					}catch(Exception ee){
						obj.displayErrorMessage();
					}
				}
			}
		});
		okBtn.setBounds(308, 35, 105, 27);
		frame.getContentPane().add(okBtn);
		
		JLabel lblNewLabel_1 = new JLabel("Serial number");
		lblNewLabel_1.setBounds(14, 82, 97, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(140, 82, 61, 18);
		frame.getContentPane().add(lblName);
		
		JLabel lblWriter = new JLabel("Writer");
		lblWriter.setBounds(222, 84, 50, 18);
		frame.getContentPane().add(lblWriter);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setBounds(396, 84, 85, 18);
		frame.getContentPane().add(lblPublisher);
		
		JLabel amountLabel = new JLabel("Amount");
		amountLabel.setBounds(295, 82, 67, 18);
		frame.getContentPane().add(amountLabel);
		
		JLabel dateLabel1 = new JLabel("Borrowed date");
		dateLabel1.setBounds(509, 82, 97, 18);
		frame.getContentPane().add(dateLabel1);
		
		JLabel dateLabel2 = new JLabel("Return date");
		dateLabel2.setBounds(674, 82, 85, 18);
		frame.getContentPane().add(dateLabel2);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ScreenForMemberToUseLibrary.displayScreen();
			}
		});
		btnNewButton.setBounds(450, 35, 105, 27);
		frame.getContentPane().add(btnNewButton);
		ArrayList<Integer> indexList = ScreenForManagerToSearchBook.getIndexList();
		int i, index = ScreenForManagerToSearchBook.getIndex();
		Book book;
		Member member = GlobalData.memberList.get(GlobalData.memberLogInIndex);
		switch(GlobalData.memberList.get(GlobalData.memberLogInIndex).getMemberOption()){
		case 2:
			dateLabel1.setVisible(false);
			dateLabel2.setVisible(false);
			
			if(indexList.size() == 0){
				index = ScreenForManagerToSearchBook.getIndex();
				
				book = GlobalData.bookList.get(index);
				textArea.append(Integer.toString(book.getSerialNumber())+"\t");
				textArea.append(book.getName()+"\t");
				textArea.append(book.getWriter()+"\t");
				textArea.append(Integer.toString(book.getAmount())+ "\t");
				textArea.append(book.getPublisher()+"\n");
				
				
			}else{
				
				for(i=0; i<indexList.size();i++){
					index = indexList.get(i).intValue();
					book = GlobalData.bookList.get(index);
					textArea.append(Integer.toString(book.getSerialNumber())+"\t");
					textArea.append(book.getName()+"\t");
					textArea.append(book.getWriter()+"\t");
					textArea.append(Integer.toString(book.getAmount())+ "\t");
					textArea.append(book.getPublisher()+"\n");
					
				}
			}break;
			
		case 3:
			amountLabel.setVisible(false);
			for(i=0; i<member.getBorrowedBook().size();i++){
				book = member.getBorrowedBook().get(i);
				textArea.append(Integer.toString(book.getSerialNumber())+"\t");
				textArea.append(book.getName()+"\t");
				textArea.append(book.getWriter()+"\t");
				textArea.append(book.getPublisher()+"\t");
				textArea.append(book.getDateBorrowed()+"\t");
				textArea.append(book.getDateRetuend()+"\n");
			}break;
			
		case 4:
			sLabel.setVisible(false);
			idText.setVisible(false);
			okBtn.setVisible(false);
			amountLabel.setVisible(false);
			for(i=0; i<member.getBorrowedBook().size();i++){
				book = member.getBorrowedBook().get(i);
				textArea.append(Integer.toString(book.getSerialNumber())+"\t");
				textArea.append(book.getName()+"\t");
				textArea.append(book.getWriter()+"\t");
				textArea.append(book.getPublisher()+"\t");
				textArea.append(book.getDateBorrowed()+"\t");
				textArea.append(book.getDateRetuend()+"\n");
			}
			break;
		
		case 5:
			
			amountLabel.setVisible(false);
			for(i=0; i<member.getBorrowedBook().size();i++){
				book = member.getBorrowedBook().get(i);
				textArea.append(Integer.toString(book.getSerialNumber())+"\t");
				textArea.append(book.getName()+"\t");
				textArea.append(book.getWriter()+"\t");
				textArea.append(book.getPublisher()+"\t");
				textArea.append(book.getDateBorrowed()+"\t");
				textArea.append(book.getDateRetuend()+"\n");
			}
			break;
			
		}
	}
	
	public static void displayScreen(){
		try {
			ScreenForMemberToUseBook window = new ScreenForMemberToUseBook();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void displayErrorMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(200,200,200,100);
		jl = new JLabel("Unvalid value!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public void displayNothinSearchedMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(200,200,200,100);
		jl = new JLabel("Nothing searched!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public void displayBorrowedCompletelyMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(200,200,200,100);
		jl = new JLabel("Borrowed completely!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public void displayReturnedCompletelyMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(200,200,200,100);
		jl = new JLabel("Returned completely!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public void displayFullBookMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(200,200,200,100);
		jl = new JLabel("You have 6 books borrowed!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public void displayNoAmountMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(200,200,200,100);
		jl = new JLabel("No Amount!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	public void displayProlongedCompletelyMessage(){
		jd.setTitle("Warning!");
		jd.setBounds(200,200,200,100);
		jl = new JLabel("Prolonged completely!",JLabel.CENTER);
		jd.getContentPane().add(jl);
		jd.setVisible(true);
		jd.remove(jl);
	}
	
	
}
