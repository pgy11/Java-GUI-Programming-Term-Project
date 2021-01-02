import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ScreenForManagerToAddBook {

	private JFrame frame;
	private JTextField snumberText;
	private JTextField nameText;
	private JTextField writerText;
	private JTextField amountText;
	private JTextField publisherText;
	private int check = 0;
	private JDialog jd;
	private JLabel jl;
	

	/**
	 * Create the application.
	 */
	public ScreenForManagerToAddBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 551, 393);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Serial Number");
		lblNewLabel.setBounds(87, 44, 103, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(141, 96, 49, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Writer\r\n");
		lblNewLabel_3.setBounds(141, 151, 49, 18);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(128, 191, 62, 18);
		frame.getContentPane().add(lblAmount);
		JButton checkBtn = new JButton("Check");
		snumberText = new JTextField();
		snumberText.addKeyListener(new KeyAdapter() {
			
		
			@Override
			public void keyReleased(KeyEvent e) {
				check = 0;
			}
		});
		
		
		snumberText.setBounds(204, 41, 116, 24);
		frame.getContentPane().add(snumberText);
		snumberText.setColumns(10);
		
		nameText = new JTextField();
		nameText.setEnabled(false);
		nameText.setColumns(10);
		nameText.setBounds(204, 93, 116, 24);
		frame.getContentPane().add(nameText);
		
		writerText = new JTextField();
		writerText.setEnabled(false);
		writerText.setColumns(10);
		writerText.setBounds(204, 148, 116, 24);
		frame.getContentPane().add(writerText);
		
		amountText = new JTextField();
		amountText.setEnabled(false);
		amountText.setColumns(10);
		amountText.setBounds(204, 188, 116, 24);
		frame.getContentPane().add(amountText);
		
		JLabel lblNewLabel_2 = new JLabel("Publisher");
		lblNewLabel_2.setBounds(128, 247, 62, 18);
		frame.getContentPane().add(lblNewLabel_2);
		
		publisherText = new JTextField();
		publisherText.setEnabled(false);
		publisherText.setBounds(204, 244, 116, 24);
		frame.getContentPane().add(publisherText);
		publisherText.setColumns(10);
		
		
		checkBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{if(BookManage.checkDuplicationAddedSerialNumber(Integer.parseInt(snumberText.getText()))){
					check = 1;
					nameText.setEnabled(true);
					writerText.setEnabled(true);
					amountText.setEnabled(true);
					publisherText.setEnabled(true);
					jd = new JDialog(frame,true);
					jl = new JLabel("Serial number available",JLabel.CENTER);
					jd.getContentPane().add(jl);
					jd.setTitle("Warning!");
					jd.setBounds(200, 200, 200, 100);
					jd.setVisible(true);
				}else{
					jd = new JDialog(frame,true);
					jl = new JLabel("Serial number already exist!",JLabel.CENTER);
					jd.getContentPane().add(jl);
					jd.setTitle("Warning!");
					jd.setBounds(200, 200, 200, 100);
					jd.setVisible(true);
				}
				}catch(Exception e1){
					ScreenForManagerToAddBook i = new ScreenForManagerToAddBook();
					i.displayErrorMessage();
				}
			}
		});
		checkBtn.setBounds(356, 40, 105, 27);
		frame.getContentPane().add(checkBtn);
		
		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{if(check == 1){
					if(!nameText.getText().equals("") && !writerText.getText().equals("") && !publisherText.getText().equals("")
							&& Integer.parseInt(amountText.getText()) > 0){
						BookManage.addBook(Integer.parseInt(snumberText.getText()), nameText.getText(), writerText.getText(), 
								Integer.parseInt(amountText.getText()), publisherText.getText());
						jd = new JDialog(frame,true);
						jl = new JLabel("Added completely!");
						jd.setTitle("Warning!");
						jd.getContentPane().add(jl);
						jd.setBounds(200, 200, 200, 100);
						jd.setVisible(true);
						frame.dispose();
						ScreenForManagerToManageBook.displayScreen();
						
					}
				}
				
				else{
					jd = new JDialog(frame,true);
					jl = new JLabel("Press the check button!");
					jd.setTitle("Warning!");
					jd.getContentPane().add(jl);
					jd.setBounds(200,200,200,100);
					jd.setVisible(true);
				}
				}catch(Exception e2){
					ScreenForManagerToAddBook i = new ScreenForManagerToAddBook();
					i.displayErrorMessage();
				}
			}
		});
		btnNewButton_1.setBounds(128, 310, 105, 27);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancel");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ScreenForManagerToManageBook.displayScreen();
			}
		});
		btnNewButton_2.setBounds(301, 310, 105, 27);
		frame.getContentPane().add(btnNewButton_2);
	}
	
	public static void displayScreen(){
		try {
			ScreenForManagerToAddBook window = new ScreenForManagerToAddBook();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public  void displayErrorMessage(){
		jd = new JDialog(frame,true);
		jl = new JLabel("Unvalid value!");
		jd.setTitle("Warning!");
		jd.getContentPane().add(jl);
		jd.setBounds(200,200,200,100);
		jd.setVisible(true);
	}

}
