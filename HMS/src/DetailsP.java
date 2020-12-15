import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class DetailsP {

	private JFrame frame;
	private JTextField pid;

	/**
	 * Launch the application.
	 */
	public void DetP() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetailsP window = new DetailsP();
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
	public DetailsP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	Connection conn = null;
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Patient ID");
		lblNewLabel.setBounds(10, 11, 69, 14);
		frame.getContentPane().add(lblNewLabel);
		
		pid = new JTextField();
		pid.setBounds(166, 8, 86, 20);
		frame.getContentPane().add(pid);
		pid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Patient Name");
		lblNewLabel_1.setBounds(10, 110, 69, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Phone Number");
		lblNewLabel_2.setBounds(10, 160, 86, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Illness");
		lblNewLabel_3.setBounds(10, 185, 69, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setBounds(10, 135, 69, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel p_name = new JLabel("");
		p_name.setBounds(157, 110, 46, 14);
		frame.getContentPane().add(p_name);
		
		JLabel ad_dr = new JLabel("");
		ad_dr.setBounds(157, 135, 46, 14);
		frame.getContentPane().add(ad_dr);
		
		JLabel ph_no = new JLabel("");
		ph_no.setBounds(157, 160, 46, 14);
		frame.getContentPane().add(ph_no);
		
		JLabel il_ln = new JLabel("");
		il_ln.setBounds(157, 185, 46, 14);
		frame.getContentPane().add(il_ln);
		
		JButton srch = new JButton("Search");
		srch.setBounds(166, 39, 89, 23);
		frame.getContentPane().add(srch);
		
		srch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","aXs");
					String query = "SELECT * FROM patientdet where pid='"+pid.getText()+"'";
					System.out.println(pid.getText());
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					rs.next();
					System.out.println(rs.getString("pname"));
					p_name.setText(rs.getString("pname"));
					ad_dr.setText(rs.getString("address"));
					ph_no.setText(rs.getString("phone_number"));
					il_ln.setText(rs.getString("illness"));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});		
	}
}