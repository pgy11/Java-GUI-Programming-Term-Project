import java.awt.*;

import javax.swing.*;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InitialScreen {

	private JFrame frame;
	private final JLabel projectNameLabel = new JLabel("Library Management");
	static int check;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitialScreen window = new InitialScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InitialScreen() {
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
		projectNameLabel.setBounds(82, 88, 276, 57);
		projectNameLabel.setFont(new Font("Serif", Font.BOLD, 30));
		frame.getContentPane().add(projectNameLabel);
		
		JButton forManagerBtn = new JButton("For Manager");
		forManagerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check = 0;
				frame.dispose();
				ScreenForLogIn.displayScreen();
				
				
			}
		});
		forManagerBtn.setBounds(45, 184, 147, 27);
		frame.getContentPane().add(forManagerBtn);
		
		JButton btnForMember = new JButton("For Member");
		btnForMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check = 1;
				frame.dispose();
				ScreenForLogIn.displayScreen();
				
			}
		});
		btnForMember.setBounds(246, 184, 147, 27);
		frame.getContentPane().add(btnForMember);
	}
	
	public static void displayScreen(){
		try {
			InitialScreen window = new InitialScreen();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
