package de.unicornworld.openunicorn;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

public class ConsoleListener implements KeyListener {

	public static String keyChar;
	public static Stack<Character> lastchars = new Stack<Character>();

	@Override
	public void keyPressed(KeyEvent e) {

		if (Component.state == 1) {

			if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

				try {

					lastchars.pop();

					keyChar = "";

					for (int i = 0; i < lastchars.size(); i++) {

						keyChar = keyChar + lastchars.get(i);

					}

				} catch (Exception ex) {

				}

			} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {

				System.out.println(keyChar);
				
			} else {

				lastchars.push(e.getKeyChar());

				keyChar = "";

				for (int i = 0; i < lastchars.size(); i++) {

					keyChar = keyChar + lastchars.get(i);

				}

			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
