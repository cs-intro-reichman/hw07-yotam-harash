

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);
		for (int i = 0; i < dictionary.length; i++) {
			dictionary[i]=in.readLine();
		}

		

		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) {

		String s1=word.toLowerCase();
		for (int i = 0; i < dictionary.length; i++) {
			if (s1.equals(dictionary[i])) {
				return  true;
			}
		}
		return false;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {

		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
		String s1=hashtag.toLowerCase();
        int N = hashtag.length();
		for (int i = 1; i <= N; i++) {
			String prefix = hashtag.substring(0, i);
			if (existInDictionary(prefix, dictionary)) {
				// Found a valid word, print it
				System.out.println(prefix);
				// Recur for the remaining part of the hashtag
				breakHashTag(hashtag.substring(i), dictionary);
				
			}
		}
    }

}
