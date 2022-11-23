package flashcardproject;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class MainFlashcardGui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFlashcardGui frame = new MainFlashcardGui();
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
	public MainFlashcardGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Color lightG = Color.decode("#D5E8D4");
		Color green = Color.decode("#82b366");
		JButton playButton = new JButton("PLAY");
		playButton.setFont(new Font("Inter", Font.PLAIN, 32));
		playButton.setOpaque(true);
		playButton.setBackground(lightG);
		playButton.setBorder(new LineBorder(green, 2));
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayFrame playFrame = new PlayFrame();
				playFrame.setVisible(true);
				dispose();
			}
		});
		playButton.setBounds(265, 93, 286, 88);
		contentPane.add(playButton);
		
		Color yellow = Color.decode("#fff2cc");
		Color yellowComplement = Color.decode("#d6b656");
		
		JButton editButton = new JButton("EDIT");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditFrame addFrame = new EditFrame();
				addFrame.setVisible(true);
				dispose();
				
			}
		});
		editButton.setOpaque(true);
		editButton.setFont(new Font("Inter", Font.PLAIN, 32));
		editButton.setBackground(yellow);
		editButton.setBorder(new LineBorder(yellowComplement, 2));
		editButton.setBounds(302, 193, 212, 88);
		contentPane.add(editButton);
		
		Color blue = Color.decode("#dae8fc");
		Color blueComplement = Color.decode("#6c8ebf");
		JButton optionsButton = new JButton("OPTIONS");
		optionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OptionsFrame optionsFrame = new OptionsFrame();
				optionsFrame.setVisible(true);
				dispose();
			}
		});
		optionsButton.setOpaque(true);
		optionsButton.setFont(new Font("Inter", Font.PLAIN, 32));
		optionsButton.setBackground(blue);
		optionsButton.setBorder(new LineBorder(blueComplement, 2));
		optionsButton.setBounds(302, 293, 212, 88);
		contentPane.add(optionsButton);
		
		Color red = Color.decode("#f8cecc");
		Color redComplement = Color.decode("#b85450");
		JButton exitButton = new JButton("EXIT");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setOpaque(true);
		exitButton.setFont(new Font("Inter", Font.PLAIN, 32));
		exitButton.setBackground(red);
		exitButton.setBorder(new LineBorder(redComplement, 2));
		exitButton.setBounds(302, 393, 212, 88);
		contentPane.add(exitButton);
	}
}
