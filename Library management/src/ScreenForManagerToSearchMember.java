import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.event.ActionEvent;

public class ScreenForManagerToSearchMember {

	private JFrame frame;
	private JTextField searchText;
	private int index;
	private ArrayList<Integer> indexList = new ArrayList<>();
	private JDialog jd = new JDialog(frame,true);
	private JLabel jl;
	/**
	 * Create the application.
	 */
	public ScreenForManagerToSearchMember() {
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ID", "Member name"}));
		comboBox.setBounds(65, 99, 132, 24);
		frame.getContentPane().add(comboBox);
		
		searchText = new JTextField();
		searchText.setBounds(211, 99, 116, 24);
		frame.getContentPane().add(searchText);
		searchText.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScreenForManagerToSearchMember obj = new ScreenForManagerToSearchMember();
				switch(comboBox.getSelectedIndex()){
				case 0:
					try{
						index = MemberManage.searchMemberUsingId(Integer.parseInt(searchText.getText()));
						if(index != -1){
							frame.dispose();
							ScreenForManagerToDisplayMember.displayScreen();
						}else{
							obj.displayNothingsearched();
						}
						
					}catch(Exception e1){
						obj.displayErrorMessage();
					}break;
				case 1:
					indexList = MemberManage.searchInformationUsingName(searchText.getText());
					if(indexList.size()>0){
						frame.dispose();
						ScreenForManagerToDisplayMember.displayScreen();
					}else{
						obj.displayNothingsearched();
					}
				}
			}
		});
		btnNewButton.setBounds(78, 185, 105, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ScreenForManagerToManageMember.displayScreen();
			}
		});
		btnNewButton_1.setBounds(225, 185, 105, 27);
		frame.getContentPane().add(btnNewButton_1);
	}
	
	public static void displayScreen(){
		try {
			ScreenForManagerToSearchMember window = new ScreenForManagerToSearchMember();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getIndex(){
		return this.index;
	}
	
	public ArrayList<Integer> getIndexList(){
		return this.indexList;
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

}
