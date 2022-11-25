package flashcardproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditCardDetails extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JTextField textField_1;
	private JLabel lblAnswer;
	private JPanel panel_2;
	private JTextField textField_2;
	private JLabel lblHint;
	private JButton backButton;
	private JButton saveButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditCardDetails frame = new EditCardDetails();
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
	public EditCardDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800, 600);
		
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Color grayBorder = Color.decode("#333333");
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setLayout(null);
		panel.setBorder(new LineBorder(grayBorder, 2));
		panel.setBounds(101, 99, 604, 104);
		contentPane.add(panel);
		
		textField = new JTextField(10);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Inter", Font.PLAIN, 20));
		textField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		textField.setBackground(new Color(245, 245, 245));
		textField.setBounds(6, 26, 592, 72);;
		panel.add(textField);
		
		lblNewLabel = new JLabel("question");
		lblNewLabel.setFont(new Font("Inter", Font.PLAIN, 16));
		lblNewLabel.setBounds(375, 215, 99, 16);
		contentPane.add(lblNewLabel);
		
		Color lightG = Color.decode("#D5E8D4");
		Color green = Color.decode("#82b366");
		panel_1 = new JPanel();
		panel_1.setBackground(lightG);
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(green, 2));
		panel_1.setBounds(101, 243, 604, 104);
		contentPane.add(panel_1);
		
		textField_1 = new JTextField(10);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Inter", Font.PLAIN, 20));
		textField_1.setBorder(null);
		textField_1.setBackground(lightG);
		textField_1.setBounds(6, 22, 592, 72);
		panel_1.add(textField_1);
		
		lblAnswer = new JLabel("answer");
		lblAnswer.setFont(new Font("Inter", Font.PLAIN, 16));
		lblAnswer.setBounds(375, 359, 61, 16);
		contentPane.add(lblAnswer);
		
		Color orange = Color.decode("#fad7ac");
		Color orangeComplement = Color.decode("#b46504");
		panel_2 = new JPanel();
		panel_2.setBackground(orange);
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(orangeComplement, 2));
		panel_2.setBounds(159, 387, 498, 104);
		contentPane.add(panel_2);
		
		textField_2 = new JTextField(10);
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Inter", Font.PLAIN, 20));
		textField_2.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		textField_2.setBackground(orange);
		textField_2.setBounds(6, 26, 486, 72);
		panel_2.add(textField_2);
		
		lblHint = new JLabel("hint");
		lblHint.setFont(new Font("Inter", Font.PLAIN, 16));
		lblHint.setBounds(387, 503, 61, 16);
		contentPane.add(lblHint);
		
		Color red = Color.decode("#f8cecc");
		Color redComplement = Color.decode("#b85450");
		backButton = new JButton("Back");
		backButton.setFont(new Font("Inter", Font.PLAIN, 24));
		backButton.setOpaque(true);
		backButton.setBackground(red);
		backButton.setFocusable(false);
		backButton.setBorder(new LineBorder(redComplement, 2));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditCardFrame editCardFrame = new EditCardFrame(null);
				editCardFrame.setVisible(true);
				dispose();
			}
		});
		backButton.setBounds(6, 6, 117, 29);
		contentPane.add(backButton);
		
		JButton saveButton = new JButton("Save");
		saveButton.setBounds(677, 6, 117, 29);
		saveButton.setFont(new Font("Inter", Font.PLAIN, 24));
		saveButton.setOpaque(true);
		saveButton.setBackground(lightG);
		saveButton.setFocusable(false);
		saveButton.setBorder(new LineBorder(green, 2));
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		saveButton.setBounds(677, 6, 117, 29);
		contentPane.add(saveButton);
	}

}
