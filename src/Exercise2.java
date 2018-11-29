import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exercise2 {
	
	private static Word [] text;
	private static String[] splitted;
	private static ArrayList list = new ArrayList();
	
	private static void readFile(String filename) throws IOException {
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
	}
	
	private static void insertArray() {
		for (int i =0; i<splitted.length;i++) {
			if (i==0) {
				WordLinkedList temp = new WordLinkedList(text[i]);
				list.addElement(temp);
			}
			else {
				char temp = text[i].getAbcWord().charAt(0);
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
	public static void main(String args[]) throws Exception{
		
		readFile("morewords.txt");
		insertArray();
//		list.printElements();
		list.sortEachElement();
		//list.printElements();
		list.sortArray();
		list.printElements();
		
	}
}
