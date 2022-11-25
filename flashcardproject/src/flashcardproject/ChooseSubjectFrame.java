package flashcardproject;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ChooseSubjectFrame extends JFrame {

	private JPanel contentPane;
	public String selected;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseSubjectFrame frame = new ChooseSubjectFrame();
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
	public ChooseSubjectFrame() throws IOException, FileNotFoundException{
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
		backButton.setBackground(red);
		backButton.setFocusable(false);
		backButton.setBorder(new LineBorder(redComplement, 2));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayFrame addFrame = new PlayFrame();
				addFrame.setVisible(true);
				dispose();
			}
		});
		backButton.setBounds(6, 6, 117, 29);
		contentPane.add(backButton);
		
		JLabel chooseSubjectLabel = new JLabel("Choose Subject");
		chooseSubjectLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 36));
		chooseSubjectLabel.setBounds(278, 35, 301, 48);
		contentPane.add(chooseSubjectLabel);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(116, 87, 591, 472);
		contentPane.add(panel);
		panel.setLayout(null);
		JList<String> list = new JList<String>();
		list.setBounds(6, 6, 579, 460);
		list.setFixedCellHeight(75);
		list.setCellRenderer(getRenderer());
		list.setFont(new Font("Inter", Font.PLAIN, 36));
		String[] subjects;
		
		File subj = new File("Subjects.txt");
		Scanner subSc = new Scanner(subj);
		int range = 1;
		while(subSc.hasNextLine()) {
			subSc.nextLine();
			range++;
		}
		subSc.close();
		
		Scanner subCon = new Scanner(subj);
			
		subjects = new String[range-1];
		
		int i = 0;
		while(subCon.hasNextLine()) {
			String data = subCon.nextLine();
			subjects[i] = data;
			i++;
		}
		subCon.close();
		final String[] valSubj = subjects;
		
		list.setModel(new AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
			String[] values = valSubj;
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (!arg0.getValueIsAdjusting()) {
					selected = list.getSelectedValue().toString();
				}
			}
		});
		try {
			list.setSelectionInterval(0, 0);
		} catch(NullPointerException er) {}
		
		DefaultListCellRenderer renderer =  (DefaultListCellRenderer)list.getCellRenderer();  
		renderer.setHorizontalAlignment(JLabel.CENTER);
		
		
		JScrollPane sp = new JScrollPane();
		sp.setViewportView(list);
		sp.setBounds(6, 6, 579, 460);
		panel.add(sp);
		
		Color lightG = Color.decode("#D5E8D4");
		Color green = Color.decode("#82b366");
		JButton nextButton = new JButton("Next");
		nextButton.setBounds(677, 6, 117, 29);
		nextButton.setFont(new Font("Inter", Font.PLAIN, 24));
		nextButton.setOpaque(true);
		nextButton.setBackground(lightG);
		nextButton.setFocusable(false);
		nextButton.setBorder(new LineBorder(green, 2));
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudyFrame studyFrame = new StudyFrame(selected, 0);
				studyFrame.setVisible(true);
				dispose();
			}
		});
		nextButton.setBounds(677, 6, 117, 29);
		contentPane.add(nextButton);
		
	}
	private ListCellRenderer<? super String> getRenderer() {
        return new DefaultListCellRenderer(){
            private static final long serialVersionUID = 1L;
			@Override
            public Component getListCellRendererComponent(JList<?> list,
                    Object value, int index, boolean isSelected,
                    boolean cellHasFocus) {
                JLabel listCellRendererComponent = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected,cellHasFocus);
                listCellRendererComponent.setBorder(BorderFactory.createLineBorder(Color.black));
                return listCellRendererComponent;
            }
        };
    }
}


