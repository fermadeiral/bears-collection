package ru.job4j.loop;

/**
 * Paint.
 * @author Ivan Belyaev
 * @since 20.06.2017
 * @version 1.0
 */
public class Paint {
	/**
	 * The method draws a pyramid with pseudographics.
	 * @param h - the height of the pyramid
	 * @return returns a string which contains the pyramid graphics
	 */
	public String piramid(int h) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < 2 * h - 1; j++) {
				if (j < h - 1 - i || j > h - 1 + i) {
					sb.append(' ');
				} else {
					sb.append('^');
				}
			}
			if (i != h - 1) {
				sb.append(System.getProperty("line.separator"));
			}
		}
		return sb.toString();
	}
}
