import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Preprocessing {
	
	public ArrayList<String> readFile( File f ) throws Exception {
		ArrayList<String> words = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(f));
		String rec;
		
		
		while ( (rec = br.readLine() ) != null ) {
			String[] splitWords = rec.split(" ");
			for( String wordsInput : splitWords) {
				words.add(wordsInput);				
			}
		}
		
		br.close();
		return words;
	}
	
	public void tfidf(String w, int emotion) throws Exception {
		File pos = new File("positive.txt");
		File neg = new File("negative.txt");
		File neutral = new File("neutral.txt");
		ArrayList<String> positiveList = readFile(pos);
		ArrayList<String> negativeList = readFile(neg);
		ArrayList<String> neutralList = readFile(neutral);
		
		
		TFIDF tfidf = new TFIDF();
		
		double weight = tfidf.tfidf(positiveList, negativeList, neutralList, w, emotion);
	}

}
