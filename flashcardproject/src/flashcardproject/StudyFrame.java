package flashcardproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class StudyFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudyFrame frame = new StudyFrame();
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
	public StudyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel flashcardPanel = new JPanel();
		flashcardPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		flashcardPanel.setBackground(new Color(245, 245, 245));
		flashcardPanel.setBounds(148, 118, 495, 350);
		contentPane.add(flashcardPanel);
		flashcardPanel.setLayout(null);
		
		Color lightG = Color.decode("#D5E8D4");
		Color green = Color.decode("#82b366");
		JButton flipCard = new JButton("FLIP");
		flipCard.setFont(new Font("Inter", Font.PLAIN, 24));
		flipCard.setOpaque(true);
		flipCard.setFocusable(false);
		flipCard.setBackground(lightG);
		flipCard.setBorder(new LineBorder(green, 2));
		flipCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnswerFrame answerFrame = new AnswerFrame();
				answerFrame.setVisible(true);
				dispose();
			}
		});
		flipCard.setBounds(155, 269, 193, 55);
		flashcardPanel.add(flipCard);
		
		JLabel questionLabel = new JLabel("Question: ");
		questionLabel.setForeground(Color.BLACK);
		questionLabel.setFont(new Font("Inter", Font.PLAIN, 13));
		questionLabel.setBounds(148, 90, 89, 16);
		contentPane.add(questionLabel);
		
		JLabel hintLabel = new JLabel("HINT: ");
		hintLabel.setForeground(Color.BLACK);
		hintLabel.setFont(new Font("Inter", Font.PLAIN, 13));
		hintLabel.setBounds(329, 480, 61, 16);
		contentPane.add(hintLabel);
		
		JLabel deckNameLabel = new JLabel("Deck Name");
		deckNameLabel.setForeground(Color.BLACK);
		deckNameLabel.setFont(new Font("Inter", Font.PLAIN, 36));
		deckNameLabel.setBounds(299, 22, 231, 44);
		contentPane.add(deckNameLabel);
		
		JLabel progressLabel = new JLabel("");
		progressLabel.setForeground(Color.BLACK);
		progressLabel.setFont(new Font("Inter", Font.PLAIN, 13));
		progressLabel.setBounds(718, 503, 61, 16);
		contentPane.add(progressLabel);
		
		JProgressBar deckProgressBar = new JProgressBar();
		deckProgressBar.setBounds(6, 517, 871, 20);
		contentPane.add(deckProgressBar);
		deckProgressBar.setMaximum(10);
		deckProgressBar.setValue(5);
		progressLabel.setText(deckProgressBar.getValue() + " / " +  deckProgressBar.getMaximum());
		
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
				PlayFrame playFrame = new PlayFrame();
				playFrame.setVisible(true);
				dispose();
			}
		});
		backButton.setBounds(6, 6, 117, 29);
		contentPane.add(backButton);
		
		JLabel timerLabel = new JLabel("15:00");
		timerLabel.setFont(new Font("Inter", Font.PLAIN, 32));
		timerLabel.setBounds(690, 6, 89, 44);
		contentPane.add(timerLabel);
	}
}