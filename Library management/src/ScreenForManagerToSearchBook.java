import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.event.ActionEvent;

public class ScreenForManagerToSearchBook {

	private JFrame frame;
	private JTextField searchText;
	private JDialog jd;
	private JLabel jl;
	private static int index;
	private static ArrayList<Integer> indexList = new ArrayList<>();
	/**
	 * Create the application.
	 */
	public ScreenForManagerToSearchBook() {
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
		
		JComboBox searchMenu = new JComboBox();
		searchMenu.setModel(new DefaultComboBoxModel(new String[] {"Serial number", "Book name", "Writer", "Publisher"}));
		searchMenu.setBounds(65, 77, 123, 24);
		frame.getContentPane().add(searchMenu);
		
		searchText = new JTextField();
		searchText.setBounds(218, 77, 144, 24);
		frame.getContentPane().add(searchText);
		searchText.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ScreenForManagerToSearchBook obj = new ScreenForManagerToSearchBook();
				switch(searchMenu.getSelectedIndex()){
				case 0:
					try{index = BookManage.searchBookUsingSerialNumber(Integer.parseInt(searchText.getText()));
					if(index != -1){
						frame.dispose();
						if(InitialScreen.check == 0){
							
						ScreenForBookManagerSearched.displayScreen();
						}else{
							ScreenForMemberToUseBook.displayScreen();
						}
					}else{
						obj.displayNothingsearched();
					}
					}catch(Exception e1){
						obj.displayErrorMessage();
					}
					break;
				case 1:
					try{indexList = BookManage.searchBookUsingBookName(searchText.getText());
					if(indexList.size() > 0){
						frame.dispose();
						if(InitialScreen.check == 0){
						ScreenForBookManagerSearched.displayScreen();
						}else{
							ScreenForMemberToUseBook.displayScreen();
						}
					}else{
						obj.displayNothingsearched();
					}
					}catch(Exception e1){
						obj.displayErrorMessage();
					}
					break;
				case 2:
					try{indexList = BookManage.searchBookUsingWriter(searchText.getText());
					if(indexList.size() > 0){
						frame.dispose();
						if(InitialScreen.check == 0){
						ScreenForBookManagerSearched.displayScreen();
						}else{
							ScreenForMemberToUseBook.displayScreen();
						}
					}else{
						obj.displayNothingsearched();
					}
					}catch(Exception e1){
						obj.displayErrorMessage();
					}
					break;
				case 3:
					try{indexList = BookManage.searchBookUsingPublisher(searchText.getText());
					if(indexList.size() > 0){
						frame.dispose();
						if(InitialScreen.check == 0){
						ScreenForBookManagerSearched.displayScreen();
						}else{
							ScreenForMemberToUseBook.displayScreen();
						}
					}else{
						obj.displayNothingsearched();
					}
					}catch(Exception e1){
						obj.displayErrorMessage();
					}
					break;
				}
			}
		});
		btnNewButton.setBounds(77, 187, 105, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				if(InitialScreen.check == 0)
				ScreenForManagerToManageBook.displayScreen();
				else
					ScreenForMemberToUseLibrary.displayScreen();
			}
		});
		btnNewButton_1.setBounds(224, 187, 105, 27);
		frame.getContentPane().add(btnNewButton_1);
	}
	
	public static void displayScreen(){
		try {
			ScreenForManagerToSearchBook window = new ScreenForManagerToSearchBook();
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
	
	public static int getIndex(){
		return index;
	}
	
	public static ArrayList<Integer> getIndexList(){
		return indexList;
	}
	

}
