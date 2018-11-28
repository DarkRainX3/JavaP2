import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Exercise2 {
	public static void main(String args[]) throws Exception{
		File file = new File("words.txt"); 
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		String words = "";
		while ((line=br.readLine()) != null) 
			words+=line+" ";
		br.close();
		String[] splitted = words.split(" ");
		Word [] text = new Word [splitted.length];
		for (int i =0; i<splitted.length;i++) {
			text[i]=new Word(splitted[i]);
		}
		for (int i =0; i<splitted.length;i++) {
			System.out.println(text[i]);
		}
		
	}
}
