import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class TFIDF {

	/*
		Move readFile out into something else
		Pass in 3 ArrayLists instead
	*/
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
	
	public double tf( File f, String word ) throws Exception {
		
		ArrayList<String> words = readFile(f);
		int count = 0;
		for ( String w : words ) {
			if(word.equalsIgnoreCase(w)) {
				count++;
			}
		}	
		
		return count / words.size();
	}
	
	public double idf( File[] files, String word ) throws Exception {
		int count = 0;
		for ( File f : files ) {
			ArrayList<String> words = readFile(f);
			if ( words.contains(word) ) {
				count++;
			}
		}
		
		
		return 	Math.log(files.length / count);
	}
	
	public double tfidf(File[] files, File f, String w) throws Exception {
		return tf(f, w) * idf(files, w);
	}
	

}
