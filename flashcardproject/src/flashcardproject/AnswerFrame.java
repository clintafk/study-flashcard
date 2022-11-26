package flashcardproject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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
					AnswerFrame frame = new AnswerFrame(null, 0, 0);
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
	public AnswerFrame(String subj, int item, int max) {
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
		nextCardButton.setFocusable(false);
		nextCardButton.setBorder(new LineBorder(green, 2));
		final int stat = item + 1, limit = max;
		nextCardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stat != limit) {
					StudyFrame studyFrame = new StudyFrame(subj, stat);
					studyFrame.setVisible(true);
					dispose();
				} else {
					FinishDeckFrame finishDeckFrame = new FinishDeckFrame(1);
					finishDeckFrame.setVisible(true);
					dispose();
				}
			}
		});
		nextCardButton.setBounds(155, 269, 193, 55);
		flashcardPanel.add(nextCardButton);

		// JLabel answerLabel_1 = new JLabel();
		// answerLabel_1.setFont(new Font("Inter", Font.PLAIN, 13));
		// answerLabel_1.setBounds(219, 160, 500, 16);

		Color yellowSomething = Color.decode("#ffff88");
		JTextField answerTextField = new JTextField();
		answerTextField.setFont(new Font("Inter", Font.PLAIN, 30));
		answerTextField.setHorizontalAlignment(SwingConstants.CENTER);
		answerTextField.setBorder(null);
		answerTextField.setBackground(yellowSomething);
		answerTextField.setEditable(false);
		answerTextField.setBounds(10, 138, 475, 43);
		answerTextField.setColumns(10);
		// flashcardPanel.add(answerTextField);

		Scanner theRead;
		String questionAndAnswer = "";
		int numOfQuestion = 0;

		try {
			File myObj = new File("./Subjects/" + subj + ".txt");
			theRead = new Scanner(myObj);
			while (theRead.hasNextLine()) {
				String data = theRead.nextLine();
				questionAndAnswer += (data + "\n");
				if (data.equals("{"))
					numOfQuestion++;
			}
			theRead.close();
		} catch (Exception e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		}

		String[] theAnswers = new String[numOfQuestion];
		for (int i = 0; i < theAnswers.length; i++)
			theAnswers[i] = "";

		boolean scanAns = false;
		char[] theSetCharredAns = questionAndAnswer.toCharArray();
		int indexAns = 0;
		int numOfNextLine = 0;

		for (int i = 0; i < theSetCharredAns.length; i++) {
			if (theSetCharredAns[i] == '{') {
				scanAns = true;
				continue;
			} else if (theSetCharredAns[i] == '\n') {
				numOfNextLine++;
				continue;
			} else if (theSetCharredAns[i] == '}') {
				scanAns = false;
				numOfNextLine = 0;
				i++;
				indexAns++;
			} else if (scanAns && numOfNextLine == 2) {
				theAnswers[indexAns] += theSetCharredAns[i];
			}
		}
		// answerLabel_1.setText(theAnswers[item]);
		answerTextField.setText(theAnswers[item]);

		flashcardPanel.add(answerTextField);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel answerLabel = new JLabel("Answer");
		answerLabel.setFont(new Font("Inter", Font.PLAIN, 18));
		answerLabel.setBounds(148, 90, 77, 16);
		contentPane.add(answerLabel);

		JProgressBar deckProgressBar = new JProgressBar();
		deckProgressBar.setFont(new Font("Inter", Font.PLAIN, 13));
		deckProgressBar.setBounds(6, 517, 871, 20);
		contentPane.add(deckProgressBar);
		deckProgressBar.setMaximum(max);
		deckProgressBar.setValue(item + 1);

		JLabel progressLabel = new JLabel("");
		progressLabel.setForeground(Color.BLACK);
		progressLabel.setFont(new Font("Inter", Font.PLAIN, 13));
		progressLabel.setBounds(718, 503, 61, 16);
		contentPane.add(progressLabel);

		progressLabel.setText(deckProgressBar.getValue() + " / " + deckProgressBar.getMaximum());
		contentPane.add(progressLabel);
	}

}
