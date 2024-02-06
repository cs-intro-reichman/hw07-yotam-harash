
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}

	public static String tail(String str) {
		
		return  str.substring(1, str.length());

	}

	public static int levenshtein(String word1, String word2) {
		
		word1=word1.toLowerCase();
		word2=word2.toLowerCase();

		
		if (word1.isEmpty()) {
			return word2.length();
		}
		if (word2.isEmpty()) {
			return word1.length();
		}
		if (word1.charAt(0)==word2.charAt(0)) {
			return levenshtein(tail(word1), tail(word2));
		}
		int min=Math.min(levenshtein(tail(word1), word2),Math.min(levenshtein(tail(word1), tail(word2)), levenshtein(word1, tail(word2))));
		return 1+ min;

		
		
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);
		for (int i = 0; i < dictionary.length; i++) {
			dictionary[i]=in.readLine();
		}

		

		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		
		String des="";
		int min=word.length();
		for (int i = 0; i < dictionary.length; i++) {
			int  lev=levenshtein(word, dictionary[i]);
			if (lev<min) {
				des=dictionary[i];
				min=lev;
			}
		
			
		}
		if (threshold<min) {
			return word;
		}
		return des;

	}

}
