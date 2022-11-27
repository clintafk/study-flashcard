package flashcardproject;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OptionsFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptionsFrame frame = new OptionsFrame();
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
	public OptionsFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		Color yellow = Color.decode("#fff2cc");
		Color yellowComplement = Color.decode("#d6b656");
		JButton challengeTimerButton = new JButton("CHALLENGE TIMER");
		challengeTimerButton.setFont(new Font("Inter", Font.PLAIN, 32));
		challengeTimerButton.setOpaque(true);
		challengeTimerButton.setFocusable(false);
		challengeTimerButton.setBackground(yellow);
		challengeTimerButton.setBorder(new LineBorder(yellowComplement, 2));
		challengeTimerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChallengeTimerFrame challengeTimerFrame = new ChallengeTimerFrame();
				challengeTimerFrame.setVisible(true);
				dispose();
			}
		});
		challengeTimerButton.setFont(new Font("Inter", Font.PLAIN, 32));
		challengeTimerButton.setBounds(208, 150, 393, 84);
		contentPane.add(challengeTimerButton);

		Color darkRed = Color.decode("#a20025");
		Color darkRedComplement = Color.decode("#ffffff");
		JButton deleteAllSubjectsButton = new JButton("DELETE ALL SUBJECTS");
		deleteAllSubjectsButton.setFont(new Font("Inter", Font.PLAIN, 32));
		deleteAllSubjectsButton.setOpaque(true);
		deleteAllSubjectsButton.setFocusable(false);
		deleteAllSubjectsButton.setBackground(darkRed);
		deleteAllSubjectsButton.setBorder(new LineBorder(darkRedComplement, 2));
		deleteAllSubjectsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteAllSubjectsFrame deleteAllSubjectsFrame = new DeleteAllSubjectsFrame();
				deleteAllSubjectsFrame.setVisible(true);
				dispose();
			}
		});
		deleteAllSubjectsButton.setFont(new Font("Inter", Font.PLAIN, 32));
		deleteAllSubjectsButton.setBounds(208, 250, 393, 84);
		contentPane.add(deleteAllSubjectsButton);

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
