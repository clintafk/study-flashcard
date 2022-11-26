package flashcardproject;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class EditCardFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditCardFrame frame = new EditCardFrame(null);
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
	public EditCardFrame(String subj) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(93, 84, 660, 482);
		contentPane.add(panel);
		
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
					CurrentSubjectFrame currentFrame = new CurrentSubjectFrame();
					currentFrame.setVisible(true);
					dispose();
				} catch (Exception er) {
					er.printStackTrace();
				}
	
			}
		});
		backButton.setBounds(6, 6, 117, 29);
		contentPane.add(backButton);
		
		Color lightG = Color.decode("#D5E8D4");
		Color green = Color.decode("#82b366");
		JButton addCardButton = new JButton("+ Add Card");
		addCardButton.setFont(new Font("Inter", Font.PLAIN, 24));
		addCardButton.setOpaque(true);
		addCardButton.setBackground(lightG);
		addCardButton.setFocusable(false);
		addCardButton.setBorder(new LineBorder(green, 2));
		addCardButton.setBounds(632, 6, 162, 29);
		addCardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCardFrame addCardFrame = new AddCardFrame(subj);
				addCardFrame.setVisible(true);
				dispose();
			}
		});
		contentPane.add(addCardButton);
		
		JLabel subjectLabel = new JLabel(subj);
		subjectLabel.setFont(new Font("Inter", Font.PLAIN, 36));
		subjectLabel.setBounds(313, 28, 231, 44);
		contentPane.add(subjectLabel);
		
		Color yellow = Color.decode("#fff2cc");
		Color yellowComplement = Color.decode("#d6b656");
		JButton editCardButton = new JButton("Edit Card");
		editCardButton.setBounds(89, 46, 117, 29);
		editCardButton.setFont(new Font("Inter", Font.PLAIN, 15));
		editCardButton.setOpaque(true);
		editCardButton.setBackground(yellow);
		editCardButton.setFocusable(false);
		editCardButton.setBorder(new LineBorder(yellowComplement, 2));
		editCardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPane.add(editCardButton);
		
		JButton deleteCardButton = new JButton("Delete Card");
		deleteCardButton.setFont(new Font("Inter", Font.PLAIN, 15));
		deleteCardButton.setOpaque(true);
		deleteCardButton.setBackground(red);
		deleteCardButton.setFocusable(false);
		deleteCardButton.setBorder(new LineBorder(redComplement, 2));
		deleteCardButton.setBounds(603, 43, 117, 29);
		deleteCardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(deleteCardButton);
		
		subjectTextField = new JTextField();
		subjectTextField.setEditable(false);
		subjectTextField.setBorder(null);
		subjectTextField.setBackground(Color.WHITE);
		subjectTextField.setFont(new Font("Inter", Font.PLAIN, 32));
		subjectTextField.setText("Title");
		subjectTextField.setHorizontalAlignment(SwingConstants.CENTER);
		subjectTextField.setBounds(247, 32, 325, 39);
		subjectTextField.setColumns(10);
		contentPane.add(subjectTextField);
		
		
		JList<String> list = new JList<String>();
		list.setBounds(6, 6, 579, 460);
		list.setFixedCellHeight(75);
		list.setCellRenderer(getRenderer());
		list.setFont(new Font("MonoLisa", Font.PLAIN, 16));
		
		Scanner theRead;
        String questionAndAnswer = "";
        int numOfQuestion = 0;
        
        try {
             File myObj = new File("./Subjects/"+subj+".txt");
             theRead = new Scanner(myObj);
             while(theRead.hasNextLine()) {
                 String data = theRead.nextLine();
                 questionAndAnswer += (data + "\n");
                 if(data.equals("{"))
                	 numOfQuestion++;
             }
             theRead.close();
        } catch(Exception e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
        
		String[] theQuestions = new String[numOfQuestion];
    	for(int i = 0; i<theQuestions.length; i++)
    		theQuestions[i] = "";
    	
    	boolean scanQuestion = false;
    	char[] theSetCharred = questionAndAnswer.toCharArray();
    	int index = 0;
    	
    	for(int i = 0; i<theSetCharred.length; i++) {
    		if(theSetCharred[i] == '{') {
    			scanQuestion = true;
    			i++;
    			continue;
    		}
    		else if(theSetCharred[i] == '\n' && scanQuestion) {
    			scanQuestion = false;
    			index++;
    		}
    		else if(scanQuestion){
    			theQuestions[index] += theSetCharred[i];
    		}
    	}
    	
    	final String[] valQue = theQuestions;
    	
		list.setModel(new AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
			String[] values = valQue;
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		DefaultListCellRenderer renderer =  (DefaultListCellRenderer)list.getCellRenderer();  
		renderer.setHorizontalAlignment(JLabel.CENTER);
		
		JScrollPane sp = new JScrollPane();
		sp.setViewportView(list);
		sp.setBounds(6, 6, 623, 460);
		panel.add(sp);
		
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
