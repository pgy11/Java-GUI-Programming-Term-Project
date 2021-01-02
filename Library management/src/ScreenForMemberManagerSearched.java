import java.awt.*;

import javax.swing.*;

public class ScreenForMemberManagerSearched {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScreenForMemberManagerSearched window = new ScreenForMemberManagerSearched();
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
	public ScreenForMemberManagerSearched() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 894, 517);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(14, 136, 848, 322);
		frame.getContentPane().add(textArea);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(27, 84, 19, 18);
		frame.getContentPane().add(lblId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(60, 84, 80, 18);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(141, 84, 42, 18);
		frame.getContentPane().add(lblName);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setBounds(209, 84, 95, 18);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(318, 84, 62, 18);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblDateCreated = new JLabel("Date created");
		lblDateCreated.setBounds(394, 84, 83, 18);
		frame.getContentPane().add(lblDateCreated);
		
		JLabel lblBookBorrowed = new JLabel("Book borrowed");
		lblBookBorrowed.setBounds(502, 84, 108, 18);
		frame.getContentPane().add(lblBookBorrowed);
		
		JLabel lblDateWhenBook = new JLabel("Borrow date");
		lblDateWhenBook.setBounds(624, 84, 95, 18);
		frame.getContentPane().add(lblDateWhenBook);
		
		JLabel lblDateWhenMember = new JLabel("Return date");
		lblDateWhenMember.setBounds(723, 84, 98, 18);
		frame.getContentPane().add(lblDateWhenMember);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(614, 27, 105, 27);
		frame.getContentPane().add(btnNewButton);
	}
}
