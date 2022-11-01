import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileHandling {
    public FileHandling() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Please input 'N' to enter new subject or 'A' for a created one: ");
        String response = in.nextLine();
        //in.close();
        
        if(response.equals("N"))
        	newFile();
        else if(response.equals("A"))
        	newQuestion();
        else {
        	System.out.println("Invalid choice. Please try again.");
        	new FileHandling();
        	return;
        }
    }
    
    public void newFile() {
    	Scanner in = new Scanner(System.in);
        System.out.print("Please enter flashcard subject: ");
        String fileName = in.nextLine();

        String theFile = fileName + ".txt";
        
        
        try {
            File myObj = new File("Subjects/"+theFile);
            
            
            if (myObj.createNewFile()) {
                System.out.println("Subject created");
            } else {
            	System.out.println("Subject already exists. Please enter another subject.");
            	newFile();
            	return;
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        try {
        	File indexFile = new File("Subjects.txt");
        	indexFile.createNewFile();
        	Scanner newFileContent = new Scanner(indexFile);
        	String indexContent = "";
        	
        	while(newFileContent.hasNextLine()) {
        		String data = newFileContent.nextLine();
        		indexContent += (data + "\n");
        	}
        	
        	newFileContent.close();
        	
        	FileWriter indexInp = new FileWriter("Subjects.txt");        	
        	indexInp.write(indexContent+fileName);
        	indexInp.close();
        } catch (IOException e) {
        	System.out.println("An error occured.");
        	e.printStackTrace();
        }
        
        System.out.print("Please enter your question: ");
        String question = in.nextLine();
        System.out.print("Please enter your answer: ");
        String answer = in.nextLine();
        //in.close();
        
        
        try {
            FileWriter writeObj = new FileWriter("Subjects/"+theFile);
            
            writeObj.write("{\n"+"Question: "+question+"\nAnswer: "+answer+"\n}");
            writeObj.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        System.out.println("Card added.");
    }
    
    public void newQuestion() throws IOException{
		File indexFile = new File("Subjects.txt");
		indexFile.createNewFile();
    	Scanner indexScan = new Scanner(indexFile);
    	String data;
    	
    	System.out.println("Available subjects:");
		try {
			data = indexScan.nextLine();
			System.out.println(data);
		} catch (NoSuchElementException e) {
			System.out.println("You currently have no subjects.\n");
			newFile();
			return;
		}
		
    	while(indexScan.hasNextLine()) {
    		data = indexScan.nextLine();
   			System.out.println(data);
   		}
    	
    	Scanner in = new Scanner(System.in);
        System.out.print("Please enter flashcard subject: ");
        String fileName = in.nextLine();
        
        String theFile = fileName + ".txt";
        String prevContents = "";
        
        try {
            File myObj = new File("Subjects/"+theFile);
            
            
            if (myObj.createNewFile()) {
                System.out.println("Subject is not available. Please input again.");
                newQuestion();
                return;
            } else {
            	Scanner out = new Scanner(myObj);
                while(out.hasNextLine()) {
                    String localData = out.nextLine() + "\n";
                    prevContents += localData;
                }
                out.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        System.out.print("Please enter your question: ");
        String question = in.nextLine();
        System.out.print("Please enter your answer: ");
        String answer = in.nextLine(); 
         
        try {
            FileWriter writeObj = new FileWriter("Subjects/"+theFile);
            
            writeObj.write(prevContents+"{\n"+"Question: "+question+"\nAnswer: "+answer+"\n}");
            writeObj.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        System.out.println("Card added.");
    }
}
