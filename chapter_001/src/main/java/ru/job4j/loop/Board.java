package ru.job4j.loop;

/**
 * Board.
 * @author Ivan Belyaev
 * @since 19.06.2017
 * @version 1.0
 */
public class Board {
	/**
	 * The method builds a chess-Board graphics.
	 * @param width - width board
	 * @param height - height board
	 * @return returns string which contains chess-Board graphics
	 */
	public String paint(int width, int height) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if ((j + i) % 2 == 0) {
					sb.append('x');
				} else {
					sb.append(' ');
				}
			}
			sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();
	}
}
