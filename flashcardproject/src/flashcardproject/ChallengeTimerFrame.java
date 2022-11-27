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
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
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
				minLeft = min = Integer.parseInt(textField.getText());
				secLeft = sec = Integer.parseInt(textField_1.getText());
				try {
					File timeSet = new File("SetTime.txt");
					FileWriter writeToSet = new FileWriter(timeSet);
					writeToSet.write(min + ":" + sec);
					writeToSet.close();
				} catch (Exception er) {
					er.printStackTrace();
				}
				OptionsFrame optionsFrame = new OptionsFrame();
				optionsFrame.setVisible(true);
				dispose();
			}
		});

		contentPane.add(saveButton);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBorder(new LineBorder(new Color(0, 0, 0)));
		textField.setFont(new Font("Inter", Font.PLAIN, 32));
		textField.setBounds(323, 190, 61, 65);
		textField.setText("00");
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel(":");
		lblNewLabel_1.setFont(new Font("Inter", Font.PLAIN, 34));
		lblNewLabel_1.setBounds(396, 189, 11, 65);
		contentPane.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		textField_1.setText("00");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Inter", Font.PLAIN, 32));
		textField_1.setColumns(10);
		textField_1.setBounds(419, 190, 61, 65);
		contentPane.add(textField_1);
		
		JLabel minutesLabel = new JLabel("min");
		minutesLabel.setFont(new Font("Inter", Font.PLAIN, 13));
		minutesLabel.setBounds(343, 267, 24, 16);
		contentPane.add(minutesLabel);
		
		JLabel secondsLabel = new JLabel("sec");
		secondsLabel.setFont(new Font("Inter", Font.PLAIN, 13));
		secondsLabel.setBounds(439, 267, 24, 16);
		contentPane.add(secondsLabel);

		try {
			File timeSet = new File("SetTime.txt");
			timeSet.createNewFile();
			Scanner timeScan = new Scanner(timeSet);

			String data = timeScan.nextLine();
			timeScan.close();
			String theMin = "", theSec = "";
			boolean forSec = false;

			for (char i : data.toCharArray()) {
				if (i == ':')
					forSec = true;
				else if (forSec)
					theSec += i;
				else if (!forSec)
					theMin += i;
			}

			minLeft = min = Integer.parseInt(theMin);
			secLeft = sec = Integer.parseInt(theSec);
			if (min / 10 != 0)
				textField.setText(theMin);
			else if (sec / 10 != 0)
				textField_1.setText(theSec);
			else {
				textField.setText("0" + theMin);
				textField_1.setText("0" + theSec);
			}

		} catch (Exception er) {
			er.printStackTrace();
		}
	}
}
