package p08_09_readableHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class ReadableHashMap {

	public static String readHashMap(Map<? extends Object, ? extends Object> myHMap) {
		StringBuilder result = new StringBuilder();

		for (Map.Entry<? extends Object, ? extends Object> entry : myHMap.entrySet()) {
			result.append((entry.getKey().toString() + ": " + entry.getValue().toString()) + ", ");
		}
		
		result.delete(result.length() - 2, result.length() - 1);
		
		return result.toString();
	}

	public static Map<String, Integer> countOccurences(String text) {
		Map<String, Integer> result = new LinkedHashMap<>();

		String noCharactersText = text.replaceAll("[-+.^:,!]", "");
		String[] words = noCharactersText.split(" ");

		for (String word : words) {
			if (result.containsKey(word)) {
				result.put(word, result.get(word) + 1);
			} else {
				result.put(word, 1);
			}
		}

		return result;
	}
}
