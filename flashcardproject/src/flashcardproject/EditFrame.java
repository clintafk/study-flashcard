package flashcardproject;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditFrame frame = new EditFrame();
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
	public EditFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Color lightG = Color.decode("#D5E8D4");
		Color green = Color.decode("#82b366");
		JButton newSubjectButton = new JButton("New Subject");
		newSubjectButton.setFont(new Font("Inter", Font.PLAIN, 32));
		newSubjectButton.setOpaque(true);
		newSubjectButton.setBackground(lightG);
		newSubjectButton.setFocusable(false);
		newSubjectButton.setBorder(new LineBorder(green, 2));
		newSubjectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewSubjectFrame newSubjectFrame = new NewSubjectFrame();
				newSubjectFrame.setVisible(true);
				dispose();
			}
		});
		newSubjectButton.setFont(new Font("Inter", Font.PLAIN, 32));
		newSubjectButton.setBounds(66, 178, 309, 86);
		contentPane.add(newSubjectButton);
		
		Color yellow = Color.decode("#fff2cc");
		Color yellowComplement = Color.decode("#d6b656");
		JButton currentSubjectButton = new JButton("Current Subjects");
		currentSubjectButton.setFont(new Font("Inter", Font.PLAIN, 32));
		currentSubjectButton.setOpaque(true);
		currentSubjectButton.setBackground(yellow);
		currentSubjectButton.setFocusable(false);
		currentSubjectButton.setBorder(new LineBorder(yellowComplement, 2));
		currentSubjectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				CurrentSubjectFrame currentSubjectFrame = new CurrentSubjectFrame();
				currentSubjectFrame.setVisible(true);
				dispose();
				} catch(Exception er) {
					er.printStackTrace();
				}
			}
		});
		currentSubjectButton.setFont(new Font("Inter", Font.PLAIN, 32));
		currentSubjectButton.setBounds(437, 179, 309, 86);
		contentPane.add(currentSubjectButton);
		
		JLabel newSubjectLabel = new JLabel("Add lessons in a new subject");
		newSubjectLabel.setFont(new Font("Inter", Font.PLAIN, 13));
		newSubjectLabel.setBounds(136, 276, 231, 14);
		contentPane.add(newSubjectLabel);
		
		JLabel currentSubjectLabel = new JLabel("Add lessons in a old subject");
		currentSubjectLabel.setFont(new Font("Inter", Font.PLAIN, 13));
		currentSubjectLabel.setBounds(511, 276, 220, 14);
		contentPane.add(currentSubjectLabel);
		
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
				MainFlashcardGui mainFrame = new MainFlashcardGui();
				mainFrame.setVisible(true);
				dispose();
			}
		});
		backButton.setBounds(6, 6, 117, 29);
		contentPane.add(backButton);
	}
}