package flashcardproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

public class DeleteAllSubjectsFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteAllSubjectsFrame frame = new DeleteAllSubjectsFrame(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DeleteAllSubjectsFrame(String subj) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800, 600);
		setResizable(false);
	
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel delAllSubLabel = new JLabel("Delete All Subjects?");
		delAllSubLabel.setForeground(Color.RED);
		delAllSubLabel.setFont(new Font("Inter", Font.PLAIN, 36));
		delAllSubLabel.setBounds(220, 121, 431, 44);
		contentPane.add(delAllSubLabel);
		
		JLabel warningLabel = new JLabel("Warning! Cannot be undone");
		warningLabel.setFont(new Font("Inter", Font.PLAIN, 13));
		warningLabel.setBounds(292, 176, 210, 16);
		contentPane.add(warningLabel);
		
		Color red = Color.decode("#f8cecc");
		Color redComplement = Color.decode("#b85450");
		JButton confirmDeleteButton = new JButton("Confirm Delete");
		confirmDeleteButton.setFont(new Font("Inter", Font.PLAIN, 24));
		confirmDeleteButton.setOpaque(true);
		confirmDeleteButton.setBackground(red);
		confirmDeleteButton.setFocusable(false);
		confirmDeleteButton.setBorder(new LineBorder(redComplement, 2));
		confirmDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		confirmDeleteButton.setBounds(230, 213, 313, 51);
		contentPane.add(confirmDeleteButton);
		
		Color white = Color.decode("#f5f5f5");
		Color whiteComplement = Color.decode("#333333");
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBounds(230, 275, 313, 51);
		cancelButton.setFont(new Font("Inter", Font.PLAIN, 24));
		cancelButton.setOpaque(true);
		cancelButton.setBackground(white);
		cancelButton.setFocusable(false);
		cancelButton.setBorder(new LineBorder(whiteComplement, 2));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
			}
		});
		contentPane.add(cancelButton);
	
	
	}
}