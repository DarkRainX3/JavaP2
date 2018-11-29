import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Exercise2 {
	
	private static Word [] text;
	private static String[] splitted;
	private static ArrayList list = new ArrayList();
	private static long estimatedTime;
	
	private static void readFile(String filename) throws IOException {
		try {
		File file = new File(filename); 
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		String words = "";
		while ((line=br.readLine()) != null) 
			words+=line+" ";
		br.close();
		splitted = words.split(" ");
		text = new Word [splitted.length];
		for (int i =0; i<splitted.length;i++) {
			text[i]=new Word(splitted[i]);
		}
		} catch (FileNotFoundException e){
			System.out.println("File Not Found, Please Try Again!");
			System.exit(0);
		}
	}
	
	private static void insertArray() {
		for (int i =0; i<splitted.length;i++) {
			if (i==0) {
				WordLinkedList temp = new WordLinkedList(text[i]);
				list.addElement(temp);
			}
			else {
				String sorted = text[i].getAbcWord();
				boolean inserted = false;
				WordLinkedList [] anagrams = list.getArray();
				for (int j =0; j<anagrams.length;j++) {
					if (anagrams[j].getHead().getAbcWord().equals(sorted)) {
						anagrams[j].insertToEndOfList(text[i]);
						inserted = true;
						break;
					}
				}
				if (inserted ==false) {
					WordLinkedList word = new WordLinkedList(text[i]);
					list.addElement(word);
				}
				else
					continue;
			}
		}
	}
	
	private static void printFile(String filename, ArrayList data) throws IOException{
		String str;
	    BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
	    WordLinkedList [] array = data.getArray();
	    writer.write("Run in " + estimatedTime + " nanoseconds");
	    writer.newLine();
	    writer.write("Run in " + estimatedTime/(Math.pow(10, 9)) + " seconds");
	    writer.newLine();
	    for (int i =0; i<array.length;i++) {
	    	str = array[i].toString();
	    	writer.write(str);
	    	writer.newLine();
	    }
	    writer.close();
	}
	
	private static boolean checkInput(String [] args) {
		if (args.length==2)
			return true;
		else {
			System.out.println("Invalid Number of Arguments Please Try Again!");
			return false;
		}
	}
	
	public static void main(String args[]) throws Exception{
		if (!checkInput(args))
			System.exit(0);
		String inFile = args[0];
		String outFile = args[1];
		long startTime = System.nanoTime();
//		readFile("morewords.txt");
		readFile(inFile);
		insertArray();
//		list.printElements();
		list.sortEachElement();
//		list.printElements();
		list.sortArray();
		estimatedTime = System.nanoTime() - startTime;
		System.out.println("Run in " + estimatedTime + " nanoseconds");
        System.out.println("Run in " + estimatedTime/(Math.pow(10, 9)) + " seconds");
		printFile(outFile, list);
	}
}
