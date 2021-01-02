import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScreenForManagerToManageBook {

	private JFrame frame;
	private JDialog jd;
	private JLabel jl;
	

	/**
	 * Create the application.
	 */
	public ScreenForManagerToManageBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 583, 399);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Add a book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ScreenForManagerToAddBook.displayScreen();
			}
		});
		btnNewButton.setBounds(193, 43, 169, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSearchABook = new JButton("Search a book");
		btnSearchABook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(BookManage.checkExistanceOfBook()){
					GlobalData.manager.setManagerOption(0);
					frame.dispose();
					ScreenForManagerToSearchBook.displayScreen();
				}
				else{
					ScreenForManagerToManageBook obj = new ScreenForManagerToManageBook();
					obj.displayAddBookMessage();
				}
			}
		});
		btnSearchABook.setBounds(193, 82, 169, 27);
		frame.getContentPane().add(btnSearchABook);
		
		JButton btnDisplayAllBooks = new JButton("Display all books");
		btnDisplayAllBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(BookManage.checkExistanceOfBook()){
				GlobalData.manager.setManagerOption(1);
				frame.dispose();
				ScreenForBookManagerSearched.displayScreen();
				}
				
				else{
					ScreenForManagerToManageBook obj = new ScreenForManagerToManageBook();
					obj.displayAddBookMessage();
				}
			}
		});
		btnDisplayAllBooks.setBounds(193, 121, 169, 27);
		frame.getContentPane().add(btnDisplayAllBooks);
		
		JButton btnUpdateABook = new JButton("Update a book");
		btnUpdateABook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(BookManage.checkExistanceOfBook()){
					GlobalData.manager.setManagerOption(2);
					frame.dispose();
					ScreenForManagerToSearchBook.displayScreen();
				}
				
				else{
					ScreenForManagerToManageBook obj = new ScreenForManagerToManageBook();
					obj.displayAddBookMessage();
				}
			}
		});
		btnUpdateABook.setBounds(193, 160, 169, 27);
		frame.getContentPane().add(btnUpdateABook);
		
		JButton btnDeleteABook = new JButton("Delete a book\r\n\r\n");
		btnDeleteABook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(BookManage.checkExistanceOfBook()){
					GlobalData.manager.setManagerOption(3);
					frame.dispose();
					ScreenForManagerToSearchBook.displayScreen();
				}
				
				else{
					ScreenForManagerToManageBook obj = new ScreenForManagerToManageBook();
					obj.displayAddBookMessage();
				}
			}
		});
		btnDeleteABook.setBounds(193, 196, 169, 27);
		frame.getContentPane().add(btnDeleteABook);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ScreenForManagerToManageSomething.displayScreen();
			}
		});
		btnBack.setBounds(193, 236, 169, 27);
		frame.getContentPane().add(btnBack);
	}
	
	public static void displayScreen(){
		try {
			ScreenForManagerToManageBook window = new ScreenForManagerToManageBook();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void displayAddBookMessage(){
		jd = new JDialog(frame,true);
		jl = new JLabel("Add book first!",JLabel.CENTER);
		jd.setTitle("Warning!");
		jd.getContentPane().add(jl);
		jd.setBounds(200, 200, 200, 100);
		jd.setVisible(true);
	}

}
