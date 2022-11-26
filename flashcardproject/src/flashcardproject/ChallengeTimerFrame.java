package flashcardproject;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ChallengeTimerFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	
	public static int min = 0;
	public static int sec = 0;
	public static int minLeft = 0;
	public static int secLeft = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChallengeTimerFrame frame = new ChallengeTimerFrame();
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
	public ChallengeTimerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel challengeTimerButton = new JLabel("Challenge Timer");
		challengeTimerButton.setFont(new Font("Inter", Font.PLAIN, 36));
		challengeTimerButton.setBounds(269, 54, 300, 44);
		contentPane.add(challengeTimerButton);
		
		Color red = Color.decode("#f8cecc");
		Color redComplement = Color.decode("#b85450");
		JButton backButton = new JButton("Back");
		backButton.setFont(new Font("Inter", Font.PLAIN, 24));
		backButton.setOpaque(true);
		backButton.setBackground(red);
		backButton.setFocusable(false);
		backButton.setBorder(new LineBorder(redComplement, 2));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OptionsFrame optionsFrame = new OptionsFrame();
				optionsFrame.setVisible(true);
				dispose();
			}
		});
		backButton.setBounds(6, 6, 117, 29);
		contentPane.add(backButton);
		
		Color lightG = Color.decode("#D5E8D4");
		Color green = Color.decode("#82b366");
		JButton saveButton = new JButton("Save");
		saveButton.setBounds(677, 6, 117, 29);
		saveButton.setFont(new Font("Inter", Font.PLAIN, 24));
		saveButton.setOpaque(true);
		saveButton.setFocusable(false);
		saveButton.setBackground(lightG);
		saveButton.setBorder(new LineBorder(green, 2));
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minLeft= min = Integer.parseInt(textField.getText());
				secLeft = sec = Integer.parseInt(textField_1.getText());
				
			}
		});
		
		contentPane.add(saveButton);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		textField.setText("01");
		textField.setBounds(323, 190, 61, 65);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel(":");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 34));
		lblNewLabel_1.setBounds(396, 189, 11, 65);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setText("33");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		textField_1.setColumns(10);
		textField_1.setBounds(419, 190, 61, 65);
		contentPane.add(textField_1);
	}
}
