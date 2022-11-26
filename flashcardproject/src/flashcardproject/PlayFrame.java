package flashcardproject;

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
import java.awt.Color;

public class PlayFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.a
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayFrame frame = new PlayFrame();
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
	public PlayFrame() {
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
		JButton normalModeButton = new JButton("Normal Mode");
		normalModeButton.setBackground(new Color(0, 255, 23));
		normalModeButton.setFont(new Font("Inter", Font.PLAIN, 32));
		normalModeButton.setOpaque(true);
		normalModeButton.setFocusable(false);
		normalModeButton.setBackground(lightG);
		normalModeButton.setBorder(new LineBorder(green, 2));
		normalModeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ChooseSubjectFrame chooseSubject = new ChooseSubjectFrame();
					chooseSubject.setVisible(true);
					dispose();
				} catch (Exception er) {
					er.printStackTrace();
				}
			}
		});
		normalModeButton.setBounds(69, 172, 305, 86);
		normalModeButton.setFont(new Font("Inter", Font.PLAIN, 32));
		contentPane.add(normalModeButton);

		Color yellow = Color.decode("#fff2cc");
		Color yellowComplement = Color.decode("#d6b656");
		JButton challengeModeButton = new JButton("Challenge Mode");
		challengeModeButton.setFont(new Font("Inter", Font.PLAIN, 32));
		challengeModeButton.setOpaque(true);
		challengeModeButton.setFocusable(false);
		challengeModeButton.setBackground(yellow);
		challengeModeButton.setBorder(new LineBorder(yellowComplement, 2));
		challengeModeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ChallengeChooseSubjectFrame chooseSubject = new ChallengeChooseSubjectFrame();
					chooseSubject.setVisible(true);
					dispose();
				} catch (Exception er) {
					er.printStackTrace();
				}
			}
		});
		challengeModeButton.setFont(new Font("Inter", Font.PLAIN, 32));
		challengeModeButton.setBounds(424, 172, 305, 86);
		contentPane.add(challengeModeButton);

		JLabel normalModeLabel = new JLabel("No time limits with hints.");
		normalModeLabel.setBounds(136, 270, 255, 14);
		contentPane.add(normalModeLabel);

		JLabel challengeModeLabel = new JLabel("User-defined time limit without hints");
		challengeModeLabel.setBounds(454, 270, 300, 14);
		contentPane.add(challengeModeLabel);

		Color red = Color.decode("#f8cecc");
		Color redComplement = Color.decode("#b85450");
		JButton backButton = new JButton("Back");
		backButton.setFont(new Font("Inter", Font.PLAIN, 24));
		backButton.setOpaque(true);
		backButton.setFocusable(false);
		backButton.setBackground(red);
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