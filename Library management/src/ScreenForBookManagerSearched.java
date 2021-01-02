import java.awt.*;
import java.util.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScreenForBookManagerSearched {

	private JFrame frame;
	private JTextField optionText;
	private static int INDEX;
	private JDialog jd;
	private JLabel jl;

	/**
	 * Create the application.
	 */
	public ScreenForBookManagerSearched() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 852, 501);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Serial number\r\n");
		lblNewLabel.setBounds(30, 88, 120, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblDateCreated = new JLabel("Date created");
		lblDateCreated.setBounds(690, 88, 95, 18);
		frame.getContentPane().add(lblDateCreated);
		
		JLabel lblBookName = new JLabel("Book name\r\n");
		lblBookName.setBounds(180, 88, 84, 18);
		frame.getContentPane().add(lblBookName);
		
		JLabel lblWriter = new JLabel("Writer");
		lblWriter.setBounds(304, 88, 46, 18);
		frame.getContentPane().add(lblWriter);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(432, 88, 62, 18);
		frame.getContentPane().add(lblAmount);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setBounds(553, 88, 62, 18);
		frame.getContentPane().add(lblPublisher);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(14, 131, 806, 300);
		frame.getContentPane().add(textArea);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ScreenForManagerToManageBook.displayScreen();
			}
		});
		btnBack.setBounds(641, 27, 105, 27);
		frame.getContentPane().add(btnBack);
		
		JLabel optionLabel = new JLabel("ID");
		optionLabel.setBounds(83, 31, 38, 18);
		frame.getContentPane().add(optionLabel);
		
		optionText = new JTextField();
		optionText.setBounds(135, 28, 116, 24);
		frame.getContentPane().add(optionText);
		optionText.setColumns(10);
		optionText.setVisible(true);
		optionLabel.setVisible(true);
		
		JButton optionBtn = new JButton("OK");
		optionBtn.setVisible(true);
		optionBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(GlobalData.manager.getManagerOption() == 2){
				if((INDEX =BookManage.searchBookUsingSerialNumber(Integer.parseInt(optionText.getText()))) != -1){
					frame.dispose();
					ScreenForManagerToUpdateBook.displayScreen();
				}
				
				else{
					ScreenForBookManagerSearched obj = new ScreenForBookManagerSearched();
					obj.displayNothingsearched();
				}
				}else if(GlobalData.manager.getManagerOption() == 3){
					if((INDEX = BookManage.searchBookUsingSerialNumber(Integer.parseInt(optionText.getText()))) != -1){
						GlobalData.bookList.remove(INDEX);
						jd = new JDialog(frame,"true");
						jd.setBounds(200,200,200,100);
						jd.setTitle("Warning!");
						jl = new JLabel("Deleted!",JLabel.CENTER);
						jd.getContentPane().add(jl);
						jd.setVisible(true);
						optionText.setText("");
						
					}else{
						ScreenForBookManagerSearched obj = new ScreenForBookManagerSearched();
						obj.displayNothingsearched();
					}
				}
				
				
			}
		});
		optionBtn.setBounds(276, 27, 105, 27);
		frame.getContentPane().add(optionBtn);
		ArrayList<Integer> indexList = new ArrayList<>();
		indexList = ScreenForManagerToSearchBook.getIndexList();
		Book book = new Book();
		int index;
		int i;
		switch(GlobalData.manager.getManagerOption()){
		case 0:
			optionText.setVisible(false);
			optionLabel.setVisible(false);
			optionBtn.setVisible(false);
			if(indexList.size() == 0){
				index = ScreenForManagerToSearchBook.getIndex();
				
				book = GlobalData.bookList.get(index);
				textArea.append(Integer.toString(book.getSerialNumber())+"\t");
				textArea.append(book.getName()+"\t");
				textArea.append(book.getWriter()+"\t");
				textArea.append(Integer.toString(book.getAmount())+ "\t");
				textArea.append(book.getPublisher()+"\t");
				textArea.append(book.getDateCreated()+"\n");
				
			}else{
				
				for(i=0; i<indexList.size();i++){
					index = indexList.get(i).intValue();
					book = GlobalData.bookList.get(index);
					textArea.append(Integer.toString(book.getSerialNumber())+"\t");
					textArea.append(book.getName()+"\t");
					textArea.append(book.getWriter()+"\t");
					textArea.append(Integer.toString(book.getAmount())+ "\t");
					textArea.append(book.getPublisher()+"\t");
					textArea.append(book.getDateCreated()+"\n");
				}
			}break;
		case 1:
			optionText.setVisible(false);
			optionLabel.setVisible(false);
			optionBtn.setVisible(false);
			for(i=0; i<GlobalData.bookList.size();i++){
				book = GlobalData.bookList.get(i);
				textArea.append(Integer.toString(book.getSerialNumber())+"\t");
				textArea.append(book.getName()+"\t");
				textArea.append(book.getWriter()+"\t");
				textArea.append(Integer.toString(book.getAmount())+ "\t");
				textArea.append(book.getPublisher()+"\t");
				textArea.append(book.getDateCreated()+"\n");
			}
			break;
		
		case 2:
			optionText.setVisible(true);
			optionLabel.setVisible(true);
			optionBtn.setVisible(true);
			for(i=0; i<GlobalData.bookList.size();i++){
				book = GlobalData.bookList.get(i);
				textArea.append(Integer.toString(book.getSerialNumber())+"\t");
				textArea.append(book.getName()+"\t");
				textArea.append(book.getWriter()+"\t");
				textArea.append(Integer.toString(book.getAmount())+ "\t");
				textArea.append(book.getPublisher()+"\t");
				textArea.append(book.getDateCreated()+"\n");
			}
			break;
		
		case 3:
			optionText.setVisible(true);
			optionLabel.setVisible(true);
			optionBtn.setVisible(true);
			for(i=0; i<GlobalData.bookList.size();i++){
				book = GlobalData.bookList.get(i);
				textArea.append(Integer.toString(book.getSerialNumber())+"\t");
				textArea.append(book.getName()+"\t");
				textArea.append(book.getWriter()+"\t");
				textArea.append(Integer.toString(book.getAmount())+ "\t");
				textArea.append(book.getPublisher()+"\t");
				textArea.append(book.getDateCreated()+"\n");
			}
			break;
			
		case 4:
			optionText.setVisible(true);
			optionLabel.setVisible(true);
			optionBtn.setVisible(true);
			for(i=0; i<GlobalData.bookList.size();i++){
				book = GlobalData.bookList.get(i);
				textArea.append(Integer.toString(book.getSerialNumber())+"\t");
				textArea.append(book.getName()+"\t");
				textArea.append(book.getWriter()+"\t");
				textArea.append(Integer.toString(book.getAmount())+ "\t");
				textArea.append(book.getPublisher()+"\t");
				textArea.append(book.getDateCreated()+"\n");
			}
			break;
		
		}
		
	}
	
	public static void displayScreen(){
		try {
			ScreenForBookManagerSearched window = new ScreenForBookManagerSearched();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static int getIndex(){
		return INDEX;
	}
	
	public  void displayNothingsearched(){
		jd = new JDialog(frame,true);
		jl = new JLabel("Nothing searched!");
		jd.setTitle("Warning!");
		jd.getContentPane().add(jl);
		jd.setBounds(200,200,200,100);
		jd.setVisible(true);
		jd.remove(jl);
	}
}
