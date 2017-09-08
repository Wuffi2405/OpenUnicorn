package de.unicornworld.openunicorn.util;

public class Path {

	public String[] direction;

	public int[] x = new int[100];
	public int[] y = new int[100];

	public Path(String[] direction) {
		this.direction = direction;

		for (int i = 0; i < direction.length; i++) {

			if (direction[i].contains("left")) {
				for (int count = 0; count < 40; count++) {
					x[count] = -1;
				}
			}

			if (direction[i].contains("right")) {
				for (int count = 0; count < 40; count++) {
					x[count] = 1;
				}
			}

			if (direction[i].contains("up")) {
				for (int count = 0; count < 40; count++) {
					y[count] = -1;
				}
			}

			if (direction[i].contains("down")) {
				for (int count = 0; count < 40; count++) {
					x[count] = 1;
				}
			}

		}

	}

}
