package de.unicornworld.openunicorn;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Stack;

import javax.imageio.ImageIO;

import de.unicornworld.openunicorn.entity.Player;
import de.unicornworld.openunicorn.util.SourceLoader;
import de.unicornworld.openunicorn.world.overwrite.Console;

public class ConsoleListener implements KeyListener {

	public static String keyChar;
	public static Stack<Character> lastchars = new Stack<Character>();

	@Override
	public void keyPressed(KeyEvent e) {

		if (Component.layer2 != null) {

			if (Component.layer2.getClass() == Console.class) {

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

					if (keyChar.startsWith("world.setname.")) {

						keyChar = keyChar.replace("world.setname.", "");
						Component.switchWorld(keyChar);

					}

					if (keyChar.startsWith("reloadtextures")) {

						try {

							Player.player = ImageIO.read(SourceLoader.class.getResourceAsStream("/assets/player.png"));
							Player.player_left = ImageIO
									.read(SourceLoader.class.getResourceAsStream("/assets/player_left.png"));

						} catch (IOException ex) {
							ex.printStackTrace();
						}

					}

				} else {

					lastchars.push(e.getKeyChar());

					keyChar = "";

					for (int i = 0; i < lastchars.size(); i++) {

						keyChar = keyChar + lastchars.get(i);

					}

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
