package flashcardproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class StudyFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudyFrame frame = new StudyFrame(null, 0);
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
	public StudyFrame(String subj, int item) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel flashcardPanel = new JPanel();
		flashcardPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		flashcardPanel.setBackground(new Color(245, 245, 245));
		flashcardPanel.setBounds(148, 118, 495, 350);
		contentPane.add(flashcardPanel);
		flashcardPanel.setLayout(null);
		

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
        int max = 0;
        
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
    			max++;
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
    	
		
		Color lightG = Color.decode("#D5E8D4");
		Color green = Color.decode("#82b366");
		JButton flipCard = new JButton("FLIP");
		flipCard.setFont(new Font("Inter", Font.PLAIN, 24));
		flipCard.setOpaque(true);
		flipCard.setFocusable(false);
		flipCard.setBackground(lightG);
		flipCard.setBorder(new LineBorder(green, 2));
		
		final int forMax = max;
		flipCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnswerFrame answerFrame = new AnswerFrame(subj, item, forMax);
				answerFrame.setVisible(true);
				dispose();
			}
		});
		flipCard.setBounds(155, 269, 193, 55);
		flashcardPanel.add(flipCard);
		
		JLabel questionLabel = new JLabel("Question: ");
		questionLabel.setForeground(Color.BLACK);
		questionLabel.setFont(new Font("Inter", Font.PLAIN, 18));
		questionLabel.setBounds(148, 78, 500, 29);
		
    	questionLabel.setText(theQuestions[item]);
		
		contentPane.add(questionLabel);
		
		//JLabel hintLabel = new JLabel();
		//hintLabel.setForeground(Color.BLACK);
		//hintLabel.setFont(new Font("Inter", Font.PLAIN, 13));
		//hintLabel.setBounds(329, 480, 500, 16);
		
		hintTextArea = new JTextField();
		hintTextArea.setHorizontalAlignment(SwingConstants.CENTER);
		hintTextArea.setFont(new Font("Inter", Font.PLAIN, 18));
		hintTextArea.setEditable(false);
		hintTextArea.setColumns(10);
		hintTextArea.setBorder(null);
		hintTextArea.setBackground(Color.WHITE);
		hintTextArea.setBounds(148, 479, 495, 27);
		
		String[] theHints = new String[numOfQuestion];
    	for(int i = 0; i<theHints.length; i++)
    		theHints[i] = "";
    	
    	boolean scanHint = false;
    	char[] theSetCharredHint = questionAndAnswer.toCharArray();
    	int indexHint = 0;
    	int numOfNextLine = 0;
    	
    	for(int i = 0; i<theSetCharredHint.length; i++) {
    		if(theSetCharredHint[i] == '{') {
    			scanHint = true;
    			continue;
    		}
    		else if(theSetCharredHint[i] == '\n') {
    			numOfNextLine++;
    			continue;
    		}
    		else if(theSetCharredHint[i] == '}') {
    			scanHint = false;
    			numOfNextLine = 0;
    			i++;
    			indexHint++;
    		}
    		else if(scanHint && numOfNextLine == 3) {
    			theHints[indexHint] += theSetCharredHint[i];
    		}
    	}
    	hintTextArea.setText("HINT: "+theHints[item]);
		contentPane.add(hintTextArea);
		
		deckNameTextField = new JTextField();
		deckNameTextField.setText(subj);
		deckNameTextField.setBorder(null);
		deckNameTextField.setFont(new Font("Inter", Font.PLAIN, 32));
		deckNameTextField.setBackground(Color.WHITE);
		deckNameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		deckNameTextField.setBounds(148, 27, 495, 52);
		deckNameTextField.setEditable(false);
		deckNameTextField.setColumns(10);
		contentPane.add(deckNameTextField);
		
		JLabel progressLabel = new JLabel("");
		progressLabel.setForeground(Color.BLACK);
		progressLabel.setFont(new Font("Inter", Font.PLAIN, 13));
		progressLabel.setBounds(718, 503, 61, 16);
		contentPane.add(progressLabel);
		
		JProgressBar deckProgressBar = new JProgressBar();
		deckProgressBar.setBounds(6, 517, 871, 20);
		contentPane.add(deckProgressBar);
		deckProgressBar.setMaximum(max);
		deckProgressBar.setValue(item+1);
		progressLabel.setText(deckProgressBar.getValue() + " / " +  deckProgressBar.getMaximum());
		
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
				PlayFrame playFrame = new PlayFrame();
				playFrame.setVisible(true);
				dispose();
			}
		});
		backButton.setBounds(6, 6, 117, 29);
		contentPane.add(backButton);
	}
}
