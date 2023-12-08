package LearnStringProg;

import java.util.LinkedHashMap;

public class IndexEachCharInStringAfterRemovedDuplicatesMAP_Q9_ii_07Dec {
	public static void main(String[] args) {
		String str = "tester";
		LinkedHashMap<Character, Integer> hm = new LinkedHashMap<Character, Integer>();

		for (int i = 0; i < str.length(); i++) {
			hm.put(str.charAt(i), i);

		}

		for (Character ch : hm.keySet()) {
			for (int i = 0; i < str.length(); i++) {
				if (ch == str.charAt(i)) {
					System.out.println(ch + " is present in " + (i + 1) + " position");
					break;
				}
			}
		}
	}
}
