package p33_sms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Sms {

	public final static Map<Integer, String[]> keys = new HashMap<Integer, String[]>() {
		{
			put(2, new String[] { "a", "b", "c" });
			put(3, new String[] { "d", "e", "f" });
			put(4, new String[] { "g", "h", "i" });
			put(5, new String[] { "j", "k", "l" });
			put(6, new String[] { "m", "n", "o" });
			put(7, new String[] { "p", "q", "r", "s" });
			put(8, new String[] { "t", "u", "v" });
			put(9, new String[] { "w", "z", "y", "z" });
		}
	};

	public static String numbersToMessage(int[] arr) {

		boolean capitalized = false;
		boolean threeLetters = false;

		StringBuilder result = new StringBuilder();
		int count = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == 1) {
				capitalized = true;

			} else if (arr[i] == 0) {
				result.append(" ");

			} else if (arr[i] == -1) {
				continue;

			} else {

				if (i != arr.length - 1 && arr[i] == arr[i + 1]) {
					count++;
				} else {
					count++;
					String[] getValues = keys.get(arr[i]);

					if (arr[i] == 7 || arr[i] == 9) {
						threeLetters = false;
					} else {
						threeLetters = true;
					}

					String letter = returnLetter(getValues, count, capitalized, threeLetters);

					result.append(letter);
					count = 0;
					capitalized = false;
				}

			}
		}
		return result.toString();
	}

	private static String returnLetter(String[] arr, int count, boolean capitalized, boolean threeLetters) {
		if (capitalized) {
			if (threeLetters) {
				if (count % 3 == 0) {
					return arr[2].toUpperCase();
				} else {
					return arr[(count % 3) - 1].toUpperCase();
				}
			} else {
				if (count % 4 == 0) {
					return arr[3].toUpperCase();
				} else {
					return arr[(count % 4) - 1].toUpperCase();
				}
			}
		} else {
			if (threeLetters) {
				if (count % 3 == 0) {
					return arr[2];
				} else {
					return arr[(count % 3) - 1];
				}
			} else {
				if (count % 4 == 0) {
					return arr[3];
				} else {
					return arr[(count % 4) - 1];
				}
			}
		}
	}

	public static List<Integer> messageToNumbers(String message) {
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < message.length(); i++) {

			if (message.charAt(i) == ' ') {
				result.add(0);

			} else {
				if (Character.isUpperCase(message.charAt(i))) {
					result.add(1);
				}

				String toStr = Character.toString(message.charAt(i));
				int getKey = Sms.getKey(toStr);
				int getKeystrokeAmount = getKeystrokeAmount(toStr);

				for (int j = 0; j < getKeystrokeAmount; j++) {
					result.add(getKey);
				}

				if (i < message.length() - 1) {

					int getKeyNextChar = Sms.getKey(Character.toString(message.charAt(i + 1)));
					if (getKey == getKeyNextChar) {
						result.add(-1);
					}
				}
			}

		}

		return result;
	}

	static int getKey(String value) {

		String newValue = value.toLowerCase();
		int key = 0;

		Set<Entry<Integer, String[]>> entries = keys.entrySet();

		for (Map.Entry<Integer, String[]> entr : entries) {
			for (int i = 0; i < entr.getValue().length; i++) {
				if (newValue.equals(entr.getValue()[i])) {
					key = entr.getKey();
					return key;

				}
			}
		}
		return key;
	}

	static int getKeystrokeAmount(String value) {

		String newValue = value.toLowerCase();
		int key = 0;

		Set<Entry<Integer, String[]>> entries = keys.entrySet();

		for (Map.Entry<Integer, String[]> entr : entries) {
			for (int i = 0; i < entr.getValue().length; i++) {
				
				if (newValue.equals(entr.getValue()[i])) {
					key = entr.getKey();
					return i + 1;

				}
			}
		}
		return key;
	}

}
