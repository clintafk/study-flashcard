import java.util.Scanner;
import java.io.File;

public class FileReader {
    public void readFile(String filename) {
        Scanner theRead;
        String questionAndAnswer = "";
        int numOfQuestion = 0;
        
        try {
             File myObj = new File(filename);
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
        
        String[] allQuestions = question(questionAndAnswer, numOfQuestion);
        String[] allAnswers = answer(questionAndAnswer, numOfQuestion);
        
        String[][] allSets = new String[allQuestions.length][2];
        
        for(int i = 0; i<allQuestions.length; i++) {
        	allSets[i][0] = allQuestions[i];
        	allSets[i][1] = allAnswers[i];
        }
        
        theRead = new Scanner(System.in);
        
        for(int i = 0; i<allQuestions.length; i++) {
        	System.out.print("\n"+allSets[i][0]);
        	theRead.nextLine();
        	System.out.print(allSets[i][1]);
        	theRead.nextLine();
        }
        
        System.out.println("\nSession finished...");
        
        theRead.close();
    }
    
    public String[] question(String theSet, int range) {
    	String[] theQuestions = new String[range];
    	for(int i = 0; i<theQuestions.length; i++)
    		theQuestions[i] = "";
    	
    	boolean scanQuestion = false;
    	char[] theSetCharred = theSet.toCharArray();
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
    	
    	return theQuestions;
    }
    
    public String[] answer(String theSet, int range) {
    	String[] theAnswers = new String[range];
    	for(int i = 0; i<theAnswers.length; i++)
    		theAnswers[i] = "";
    	
    	boolean scanAnswer = false;
    	char[] theSetCharred = theSet.toCharArray();
    	int index = 0;
    	int numOfNextLine = 0;
    	
    	for(int i = 0; i<theSetCharred.length; i++) {
    		if(theSetCharred[i] == '{') {
    			scanAnswer = true;
    			continue;
    		}
    		else if(theSetCharred[i] == '\n') {
    			numOfNextLine++;
    			continue;
    		}
    		else if(theSetCharred[i] == '}') {
    			scanAnswer = false;
    			numOfNextLine = 0;
    			i++;
    			index++;
    		}
    		else if(scanAnswer && numOfNextLine == 2) {
    			theAnswers[index] += theSetCharred[i];
    		}
    	}
    	
    	return theAnswers;
    }
}