package flashcardproject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class AnswerFrame extends JFrame {
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnswerFrame frame = new AnswerFrame();
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
	public AnswerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		
		JPanel flashcardPanel = new JPanel();
		flashcardPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		flashcardPanel.setBackground(new Color(255, 255, 136));
		flashcardPanel.setBounds(148, 118, 495, 350);
		contentPane.add(flashcardPanel);
		flashcardPanel.setLayout(null);
		
		Color lightG = Color.decode("#D5E8D4");
		Color green = Color.decode("#82b366");
		JButton nextCardButton = new JButton("Next Card");
		nextCardButton.setFont(new Font("Inter", Font.PLAIN, 24));
		nextCardButton.setOpaque(true);
		nextCardButton.setBackground(lightG);
		nextCardButton.setBorder(new LineBorder(green, 2));
		nextCardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FinishDeckFrame finishDeckFrame = new FinishDeckFrame();
				finishDeckFrame.setVisible(true);
				dispose();
			}
		});
		nextCardButton.setBounds(155, 269, 193, 55);
		flashcardPanel.add(nextCardButton);
		
		JLabel answerLabel_1 = new JLabel("Answer");
		answerLabel_1.setFont(new Font("Inter", Font.PLAIN, 13));
		answerLabel_1.setBounds(219, 160, 61, 16);
		flashcardPanel.add(answerLabel_1);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel answerLabel = new JLabel("Answer");
		answerLabel.setFont(new Font("Inter", Font.PLAIN, 13));
		answerLabel.setBounds(148, 90, 61, 16);
		contentPane.add(answerLabel);
		
		JProgressBar deckProgressBar = new JProgressBar();
		deckProgressBar.setFont(new Font("Inter", Font.PLAIN, 13));
		deckProgressBar.setBounds(6, 517, 871, 20);
		contentPane.add(deckProgressBar);
		deckProgressBar.setMaximum(10);
		deckProgressBar.setValue(5);
		
		JLabel progressLabel = new JLabel("");
		progressLabel.setForeground(Color.BLACK);
		progressLabel.setFont(new Font("Inter", Font.PLAIN, 13));
		progressLabel.setBounds(718, 503, 61, 16);
		contentPane.add(progressLabel);
		
		progressLabel.setText(deckProgressBar.getValue() + " / " +  deckProgressBar.getMaximum());
		contentPane.add(progressLabel);
		
		JLabel lblNewLabel = new JLabel("14:56");
		lblNewLabel.setFont(new Font("Inter", Font.PLAIN, 32));
		lblNewLabel.setBounds(690, 6, 89, 44);
		contentPane.add(lblNewLabel);
		
	}

}
