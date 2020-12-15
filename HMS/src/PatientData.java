import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class PatientData {

	private JFrame frame;
	private JTextField pname;
	private JTextField pid;
	private JTextField addr;
	private JTextField ill;
	private JTextField pnum;

	/**
	 * Launch the application.
	 */
	Connection conn = null;
	public void Patient() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientData window = new PatientData();
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
	public PatientData() {
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
		
		JLabel lblNewLabel = new JLabel("Patient Name");
		lblNewLabel.setBounds(10, 91, 89, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Patient ID");
		lblNewLabel_1.setBounds(10, 116, 89, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setBounds(10, 141, 89, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Illness");
		lblNewLabel_3.setBounds(10, 166, 89, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		pname = new JTextField();
		pname.setBounds(184, 88, 86, 20);
		frame.getContentPane().add(pname);
		pname.setColumns(10);
		
		pid = new JTextField();
		pid.setBounds(184, 113, 86, 20);
		frame.getContentPane().add(pid);
		pid.setColumns(10);
		
		addr = new JTextField();
		addr.setBounds(184, 138, 86, 20);
		frame.getContentPane().add(addr);
		addr.setColumns(10);
		
		ill = new JTextField();
		ill.setBounds(184, 163, 86, 20);
		frame.getContentPane().add(ill);
		ill.setColumns(10);
		
		pnum = new JTextField();
		pnum.setBounds(184, 194, 86, 20);
		frame.getContentPane().add(pnum);
		pnum.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","aXs");
					String query = "INSERT INTO patientdet values('"+pname.getText()+"','"+addr.getText()+"','"+pid.getText()+"','"+pnum.getText()+"','"+ill.getText()+"')";
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(query);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Phone Number");
		lblNewLabel_4.setBounds(10, 191, 89, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		
	}
}
