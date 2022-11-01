import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException{
		File indexFile = new File("Subjects.txt");
		indexFile.createNewFile();
		
		File subjectFolder = new File("./Subjects");
       	subjectFolder.mkdir();
		
		Scanner in = new Scanner(System.in);
		Scanner indexScan = new Scanner(indexFile);
		
		FileHandling newEntry;
		FileReader study = new FileReader();
		
		System.out.println("WELCOME TO THE STUDY FLASHCARD (TUI EDITION)\n");
		System.out.print("Please choose if you would like to add or go though a study\nA for Add & S for Study: ");
		String response = in.nextLine();
		
		if(response.equals("A"))
			newEntry = new FileHandling();
		else if(response.equals("S")) {
			String data;

			System.out.println("Available subjects:");
			try {
				data = indexScan.nextLine();
				System.out.println(data);
			} catch (NoSuchElementException e) {
				System.out.println("You currently have no subjects.\n");
				main(null);
				return;
			}
			
			while(indexScan.hasNextLine()) {
				data = indexScan.nextLine();
				System.out.println(data);
			}
			System.out.print("Please enter subject to go through: ");
			String subj = in.nextLine();
			study.readFile("Subjects/"+subj+".txt");
		}
		else {
			System.out.println("Invalid choice. Please try again.");
			main(null);
			return;
		}
		
		in.close();
	}
}
