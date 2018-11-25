package ru.job4j.exam;

/**
 * SubstringSearch.
 * @author Ivan Belyaev
 * @since 03.07.2017
 * @version 1.0
 */
public class SubstringSearch {
	/**
	 * The method contains checks whether the substring in the string.
	 * @param origin - string in which the search.
	 * @param sub - the substring that is searched for in the string.
	 * @return returns true if the search was successful, otherwise returns false.
	 */
	boolean contains(String origin, String sub) {
		char[] originCharArray = origin.toCharArray();
		char[] subCharArray = sub.toCharArray();
		for (int i = 0; i < originCharArray.length - subCharArray.length + 1; i++) {
			int j = 0;
			int saveI = i;
			while (j < subCharArray.length && originCharArray[i] == subCharArray[j]) {
				i++;
				j++;
			}
			if (j == subCharArray.length) {
				return true;
			} else {
				i = saveI;
			}
		}
		return false;
	}
}
