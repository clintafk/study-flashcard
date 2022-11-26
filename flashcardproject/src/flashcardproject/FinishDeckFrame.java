package flashcardproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FinishDeckFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinishDeckFrame frame = new FinishDeckFrame(0);
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
	public FinishDeckFrame(int id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800, 600);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		Color gray = Color.decode("#f5f5f5");
		Color grayComplement = Color.decode("#333333");

		JPanel panel = new JPanel();
		panel.setBackground(gray);
		panel.setBorder(new LineBorder(grayComplement, 2));
		panel.setBounds(149, 173, 512, 121);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel congratsPrompt = new JLabel("You have finished the deck!");
		congratsPrompt.setHorizontalAlignment(SwingConstants.CENTER);
		congratsPrompt.setFont(new Font("Inter", Font.PLAIN, 28));
		congratsPrompt.setBounds(6, 42, 500, 41);
		panel.add(congratsPrompt);

		Color lightG = Color.decode("#D5E8D4");
		Color green = Color.decode("#82b366");
		JButton nextButton = new JButton("Next");
		nextButton.setFocusable(false);
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (id == 1) {
					try {
						ChooseSubjectFrame chooseSubjectFrame = new ChooseSubjectFrame();
						chooseSubjectFrame.setVisible(true);
						dispose();
					} catch (Exception er) {
						er.printStackTrace();
					}
				} else if (id == 2) {
					try {
						ChallengeTimerFrame.minLeft = ChallengeTimerFrame.min;
						ChallengeTimerFrame.secLeft = ChallengeTimerFrame.sec;
						ChallengeChooseSubjectFrame chooseSubjectFrame = new ChallengeChooseSubjectFrame();
						chooseSubjectFrame.setVisible(true);
						dispose();
					} catch (Exception er) {
						er.printStackTrace();
					}
				}
			}
		});
		nextButton.setFont(new Font("Inter", Font.PLAIN, 24));
		nextButton.setBackground(lightG);
		nextButton.setOpaque(true);
		nextButton.setBorder(new LineBorder(green, 2));
		nextButton.setBounds(310, 315, 191, 49);
		contentPane.add(nextButton);
	}
}
