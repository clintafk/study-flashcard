package flashcardproject;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewSubjectFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel textFieldLabel;
	private JButton backButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewSubjectFrame frame = new NewSubjectFrame();
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
	public NewSubjectFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(120, 168, 547, 151);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField(20);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Inter", Font.PLAIN, 32));
		textField.setBackground(UIManager.getColor("Button.background"));
		textField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		textField.setBounds(17, 39, 513, 72);
		panel.add(textField);
		textField.setColumns(10);
		
		
		textFieldLabel = new JLabel("Write the subject's name (MAX: 20 Characters)");
		textFieldLabel.setFont(new Font("Inter", Font.PLAIN, 13));
		textFieldLabel.setBounds(256, 331, 463, 16);
		contentPane.add(textFieldLabel);
		
		Color lightG = Color.decode("#D5E8D4");
		Color green = Color.decode("#82b366");
		JButton nextButton = new JButton("Confirm");
		nextButton.setFont(new Font("Inter", Font.PLAIN, 28));
		nextButton.setOpaque(true);
		nextButton.setBackground(lightG);
		nextButton.setBorder(new LineBorder(green, 2));
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CurrentSubjectFrame currentSubjectFrame = new CurrentSubjectFrame();
				currentSubjectFrame.setVisible(true);
				dispose();
			}
		});
		nextButton.setBounds(266, 371, 273, 48);
		contentPane.add(nextButton);
		
		Color red = Color.decode("#f8cecc");
		Color redComplement = Color.decode("#b85450");
		JButton backButton = new JButton("Back");
		backButton.setFont(new Font("Inter", Font.PLAIN, 24));
		backButton.setOpaque(true);
		backButton.setBackground(red);
		backButton.setBorder(new LineBorder(redComplement, 2));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditFrame addFrame = new EditFrame();
				addFrame.setVisible(true);
				dispose();
			}
		});
		backButton.setBounds(6, 6, 117, 29);
		contentPane.add(backButton);
		
		JLabel newSubjectLabel = new JLabel("New Subject");
		newSubjectLabel.setFont(new Font("Inter", Font.PLAIN, 36));
		newSubjectLabel.setBounds(287, 52, 231, 44);
		contentPane.add(newSubjectLabel);
		
		
	}
	
	void drawLines(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(150, 308, 625, 308);
    }
 
    public void paint(Graphics g) {
        super.paint(g);
        drawLines(g);
    }
}
