package flashcardproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class DeleteSubjectFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteSubjectFrame frame = new DeleteSubjectFrame(null);
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
	public DeleteSubjectFrame(String subj) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800, 600);
		setResizable(false);
	
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete Subject?");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Inter", Font.PLAIN, 36));
		lblNewLabel.setBounds(278, 114, 313, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Warning! Cannot be undone");
		lblNewLabel_1.setFont(new Font("Inter", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(318, 172, 210, 16);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(190, 212, 449, 151);
		contentPane.add(panel);
		
		textField = new JTextField(10);
		textField.setText(subj);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Inter", Font.PLAIN, 32));
		textField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		textField.setBackground(SystemColor.window);
		textField.setBounds(6, 38, 437, 72);
		panel.add(textField);
		
		Color red = Color.decode("#f8cecc");
		Color redComplement = Color.decode("#b85450");
		JButton confirmDeleteButton = new JButton("Confirm Delete");
		confirmDeleteButton.setFont(new Font("Inter", Font.PLAIN, 24));
		confirmDeleteButton.setOpaque(true);
		confirmDeleteButton.setBackground(red);
		confirmDeleteButton.setFocusable(false);
		confirmDeleteButton.setBorder(new LineBorder(redComplement, 2));
		confirmDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File subjectToDelete = new File("./Subjects/"+subj+".txt");
					subjectToDelete.delete();
					
					File removeEntry  = new File("Subjects.txt");
					Scanner scanEntry = new Scanner(removeEntry);
					String revisedContent = "";
					
					while(scanEntry.hasNextLine()) {
						String data = scanEntry.nextLine();
						if(data.equals(subj))
							continue;
						revisedContent += data+"\n";
					}
					scanEntry.close();
					
					FileWriter updateContent = new FileWriter(removeEntry);
					updateContent.write(revisedContent);
					updateContent.close();
					
					CurrentSubjectFrame currentSubjectFrame = new CurrentSubjectFrame();
					currentSubjectFrame.setVisible(true);
					dispose();
				} catch(Exception er) {
					er.printStackTrace();
				}
			}
		});
		confirmDeleteButton.setBounds(263, 385, 313, 51);
		contentPane.add(confirmDeleteButton);
		
		Color white = Color.decode("#f5f5f5");
		Color whiteComplement = Color.decode("#333333");
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBounds(263, 448, 313, 51);
		cancelButton.setFont(new Font("Inter", Font.PLAIN, 24));
		cancelButton.setOpaque(true);
		cancelButton.setBackground(white);
		cancelButton.setFocusable(false);
		cancelButton.setBorder(new LineBorder(whiteComplement, 2));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(cancelButton);
	}
}
