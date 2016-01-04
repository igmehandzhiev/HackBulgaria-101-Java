package p08_09_readableHashMap;

import java.util.Map;

public class Main {

	public static void main(String[] args) {

		String text = "Ninjas are all over the place! We are all going to die!";

		Map<String, Integer> map = ReadableHashMap.countOccurences(text);
		String result = ReadableHashMap.readHashMap(map);

		System.out.println(result);

	}

}
