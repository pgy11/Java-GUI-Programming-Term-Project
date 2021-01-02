import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScreenForManagerToUpdateBook {

	private JFrame frame;
	private JTextField updateText;
	private JDialog jd;
	private JLabel jl;
	private int check = 0;
	private int index = ScreenForBookManagerSearched.getIndex();
	/**
	 * Create the application.
	 */
	public ScreenForManagerToUpdateBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 564, 409);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JButton checkBtn = new JButton("Check serial number\r\n");
		JComboBox comboBox = new JComboBox();
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex() != 0)
					checkBtn.setEnabled(false);
				
				else
					checkBtn.setEnabled(true);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Serial number", "Book name", "Writer", "Amount", "Publisher"}));
		comboBox.setSelectedIndex(1);
		comboBox.setBounds(51, 122, 120, 24);
		frame.getContentPane().add(comboBox);
		
		updateText = new JTextField();
		updateText.setBounds(200, 122, 144, 24);
		frame.getContentPane().add(updateText);
		updateText.setColumns(10);
		
		jd = new JDialog(frame,true);
		jd.setTitle("Warning!");
		jl = new JLabel();
		jd.getContentPane().add(jl);
		jd.setBounds(200, 200, 100, 100);
		
		checkBtn.setEnabled(false);
		checkBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{if(BookManage.checkDuplicationUpdatedSerialNumber(Integer.parseInt(updateText.getText()), ScreenForBookManagerSearched.getIndex())){
					check = 1;
					jl.setText("Serial number available!");
					jd.setVisible(true);
				}
				
				else{
					jl.setText("Serial number already exist!");
					jd.setVisible(true);
				}}catch(Exception e1){
					jl.setText("Unvalid value!");
					jd.setVisible(true);
				}
			}
		});
		
		
		
			
		
		
		checkBtn.setBounds(358, 121, 165, 27);
		frame.getContentPane().add(checkBtn);
		
		JButton okBtn = new JButton("OK");
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBtn.isEnabled()){
					if(check == 1){
						try{BookManage.updateBookSerialNumber(Integer.parseInt(updateText.getText()), index);}
						catch(Exception e1){
							jl.setText("Unvalid vlaue!");
							jd.setVisible(true);
						}
						jl.setText("Updated completely!");
						jd.setVisible(true);
						frame.dispose();
						ScreenForManagerToManageBook.displayScreen();
					}
					else{
						jl.setText("Press the check button");
						jd.setVisible(true);
					}
				}
				
				else{
					switch(comboBox.getSelectedIndex()){
					case 1:
						if(!updateText.getText().equals("")){
							BookManage.updateBookName(updateText.getText(), index);
							jl.setText("Updated completely!");
							jd.setVisible(true);
							frame.dispose();
							ScreenForManagerToManageBook.displayScreen();
						}else{
							jl.setText("Unvalid vlaue!");
							jd.setVisible(true);
						}
						break;
					case 2:
						if(!updateText.getText().equals("")){
							BookManage.updateBookWriter(updateText.getText(), index);
							jl.setText("Updated completely!");
							jd.setVisible(true);
							frame.dispose();
							ScreenForManagerToManageBook.displayScreen();
						}else{
							jl.setText("Unvalid vlaue!");
							jd.setVisible(true);
						}
						break;
					case 3:
						try{
							BookManage.updateBookAmount(Integer.parseInt(updateText.getText()), index);
							jl.setText("Updated completely!");
							jd.setVisible(true);
							frame.dispose();
							ScreenForManagerToManageBook.displayScreen();
						}catch(Exception e1){
							jl.setText("Unvalid vlaue!");
							jd.setVisible(true);
						}
						break;
					case 4:
						if(!updateText.getText().equals("")){
							BookManage.updateBookPublisher(updateText.getText(), index);
							jl.setText("Updated completely!");
							jd.setVisible(true);
							frame.dispose();
							ScreenForManagerToManageBook.displayScreen();
						}else{
							jl.setText("Unvalid vlaue!");
							jd.setVisible(true);
						}
						break;
					default :
						jl.setText("Unvalid vlaue!");
						jd.setVisible(true);
						break;
					}
				}
			}
		});
		okBtn.setBounds(211, 262, 105, 27);
		frame.getContentPane().add(okBtn);
		
		JButton btnNewButton_2 = new JButton("Cancel");
		btnNewButton_2.setBounds(374, 262, 105, 27);
		frame.getContentPane().add(btnNewButton_2);
		
		
			
		
	}
	
	public static void displayScreen(){
		try {
			ScreenForManagerToUpdateBook window = new ScreenForManagerToUpdateBook();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
