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
import javax.swing.JLabel;

public class ThemeFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemeFrame frame = new ThemeFrame();
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
	public ThemeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
				OptionsFrame optionsFrame = new OptionsFrame();
				optionsFrame.setVisible(true);
				dispose();
			}
		});
		backButton.setBounds(6, 6, 117, 29);
		contentPane.add(backButton);
		
		Color yellow = Color.decode("#fff2cc");
		Color yellowComplement = Color.decode("#d6b656");
		JButton lightThemeButton = new JButton("Light Theme");
		lightThemeButton.setFont(new Font("Inter", Font.PLAIN, 32));
		lightThemeButton.setOpaque(true);
		lightThemeButton.setFocusable(false);
		lightThemeButton.setBackground(yellow);
		lightThemeButton.setBorder(new LineBorder(yellowComplement, 2));
		lightThemeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		lightThemeButton.setFont(new Font("Dialog", Font.PLAIN, 32));
		lightThemeButton.setBounds(213, 148, 393, 84);
		contentPane.add(lightThemeButton);
		
		Color darkBlue = Color.decode("#b1ddf0");
		Color darkBlueComplement = Color.decode("#10739e");
		JButton darkThemeButton = new JButton("Dark Theme");
		darkThemeButton.setFont(new Font("Inter", Font.PLAIN, 32));
		darkThemeButton.setOpaque(true);
		darkThemeButton.setFocusable(false);
		darkThemeButton.setBackground(darkBlue);
		darkThemeButton.setBorder(new LineBorder(darkBlueComplement, 2));
		darkThemeButton.setBounds(213, 244, 393, 84);
		contentPane.add(darkThemeButton);
		
		JLabel themeLabel = new JLabel("Themes");
		themeLabel.setFont(new Font("Inter", Font.PLAIN, 36));
		themeLabel.setBounds(327, 54, 231, 44);
		contentPane.add(themeLabel);
		
		Color lightG = Color.decode("#D5E8D4");
		Color green = Color.decode("#82b366");
		JButton saveButton = new JButton("Save");
		saveButton.setFont(new Font("Inter", Font.PLAIN, 24));
		saveButton.setOpaque(true);
		saveButton.setFocusable(false);
		saveButton.setBackground(lightG);
		saveButton.setBorder(new LineBorder(green, 2));
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		saveButton.setBounds(677, 6, 117, 29);
		contentPane.add(saveButton);
	}
}