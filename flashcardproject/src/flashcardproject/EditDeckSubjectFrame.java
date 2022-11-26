package flashcardproject;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class EditDeckSubjectFrame extends JFrame {

	private JPanel contentPane;
	private JLabel editDeckSubject;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditDeckSubjectFrame frame = new EditDeckSubjectFrame(null);
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
	public EditDeckSubjectFrame(String subj) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

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
				try {
					CurrentSubjectFrame currentSubjectFrame = new CurrentSubjectFrame();
					currentSubjectFrame.setVisible(true);
					dispose();
				} catch (Exception er) {
					er.printStackTrace();
				}
			}
		});
		backButton.setBounds(6, 6, 117, 29);
		contentPane.add(backButton);

		JLabel lblNewLabel;
		editDeckSubject = new JLabel("Edit Deck Subject");
		editDeckSubject.setFont(new Font("Inter", Font.PLAIN, 36));
		editDeckSubject.setBounds(269, 48, 313, 35);
		contentPane.add(editDeckSubject);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(131, 126, 547, 151);
		contentPane.add(panel);
		panel.setLayout(null);

		JTextField txtGeography = new JTextField(20);
		txtGeography.setText(subj);
		txtGeography.setHorizontalAlignment(SwingConstants.CENTER);
		txtGeography.setFont(new Font("Inter", Font.PLAIN, 32));
		txtGeography.setBackground(UIManager.getColor("Button.background"));
		txtGeography.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtGeography.setBounds(40, 38, 479, 72);
		panel.add(txtGeography);
		txtGeography.setColumns(10);

		Color lightG = Color.decode("#D5E8D4");
		Color green = Color.decode("#82b366");
		JButton saveButton = new JButton("Save");
		saveButton.setBounds(677, 6, 117, 29);
		saveButton.setFont(new Font("Inter", Font.PLAIN, 24));
		saveButton.setOpaque(true);
		saveButton.setBackground(lightG);
		saveButton.setFocusable(false);
		saveButton.setBorder(new LineBorder(green, 2));
		saveButton.addActionListener(new ActionListener() { // URGENT PROBLEM HERE
			public void actionPerformed(ActionEvent e) {
				try {
					String newSubjName = txtGeography.getText();

					if (!(subj.equals(newSubjName))) {
						File subjects = new File("Subjects.txt");
						Scanner scanSubjFile = new Scanner(subjects);
						File oldSubjName = new File("./Subjects/" + subj + ".txt");
						Scanner oldSubjConScan = new Scanner(oldSubjName);
						File editSubjName = new File("./Subjects/" + newSubjName + ".txt");
						FileWriter editSubjCon = new FileWriter(editSubjName);
						editSubjName.createNewFile();

						String prevCon = "";
						while (scanSubjFile.hasNextLine()) {
							String data = scanSubjFile.nextLine();
							if (data.equals(subj))
								continue;
							prevCon += (data + "\n");
						}
						scanSubjFile.close();

						FileWriter newSubj = new FileWriter(subjects);
						newSubj.write(prevCon + newSubjName);
						newSubj.close();

						String newCon = "";
						while (oldSubjConScan.hasNextLine()) {
							String data = oldSubjConScan.nextLine();
							if (oldSubjConScan.hasNextLine())
								newCon += (data + "\n");
							else
								newCon += data;
						}
						oldSubjConScan.close();
						editSubjCon.write(newCon);
						editSubjCon.close();
						oldSubjName.delete();
					}

					else {
						System.out.println("Something went wrong.");
					}
					CurrentSubjectFrame currentSubjectFrame = new CurrentSubjectFrame();
					currentSubjectFrame.setVisible(true);
					dispose();
				} catch (Exception er) {
					er.printStackTrace();
				}
			}
		});
		saveButton.setBounds(677, 6, 117, 29);
		contentPane.add(saveButton);

		lblNewLabel = new JLabel("Write the subject's name (MAX: 20 Characters)");
		lblNewLabel.setFont(new Font("Inter", Font.PLAIN, 13));
		lblNewLabel.setBounds(257, 289, 463, 16);
		contentPane.add(lblNewLabel);

		Color orange = Color.decode("#fff2cc");
		Color orangeComplement = Color.decode("#d6b656");
		JButton editCardButton = new JButton("Edit Cards");
		editCardButton.setFont(new Font("Inter", Font.PLAIN, 24));
		editCardButton.setOpaque(true);
		editCardButton.setBackground(orange);
		editCardButton.setFocusable(false);
		editCardButton.setBorder(new LineBorder(orangeComplement, 2));
		editCardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditCardFrame editCardFrame = new EditCardFrame(txtGeography.getText());
				editCardFrame.setVisible(true);
				dispose();
			}
		});
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		editCardButton.setBounds(230, 346, 352, 78);
		contentPane.add(editCardButton);

		JButton deleteSubjButton = new JButton("Delete Subject");
		deleteSubjButton.setFont(new Font("Inter", Font.PLAIN, 24));
		deleteSubjButton.setOpaque(true);
		deleteSubjButton.setBackground(red);
		deleteSubjButton.setFocusable(false);
		deleteSubjButton.setBorder(new LineBorder(redComplement, 2));
		deleteSubjButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteSubjectFrame deleteSubjectFrame = new DeleteSubjectFrame(subj);
				deleteSubjectFrame.setVisible(true);
				dispose();
			}
		});
		deleteSubjButton.setBounds(230, 436, 352, 78);
		contentPane.add(deleteSubjButton);
	}
}
