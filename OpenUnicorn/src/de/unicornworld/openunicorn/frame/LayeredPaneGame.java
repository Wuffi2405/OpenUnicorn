package de.unicornworld.openunicorn.frame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JPanel;

import de.unicornworld.openunicorn.Component;
import de.unicornworld.openunicorn.OpenUnicorn;
import de.unicornworld.openunicorn.world.World;

public class LayeredPaneGame extends JPanel {

	private static final long serialVersionUID = 1L;

	public static Button button_closeGame;
	private static Component gameCanvas;

	public LayeredPaneGame() {
		setBounds(0, 0, 800, 600);
		setLayout(null);

		button_closeGame = new Button(150, 50);
		button_closeGame.setBounds(Window.getJFrame().getWidth() - 150, 0, 150, 50);
		button_closeGame.getText().setText("Spiel schlieﬂen");
		// button_closeGame.text.setVerticalAlignment((int) CENTER_ALIGNMENT);
		Window.button_game.add(button_closeGame);
		button_closeGame.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src/assets/files/log.uwuf")));

					writer.flush();
					writer.write(Component.worldName);
					writer.newLine();
					writer.write(String.valueOf(Component.player.x));
					writer.newLine();
					writer.write(String.valueOf(Component.player.y));
					writer.newLine();
					writer.write(String.valueOf(World.difx));
					writer.newLine();
					writer.write(String.valueOf(World.dify));
					writer.close();

				} catch (IOException ex) {
				}

				Window.getJFrame().dispose();
				OpenUnicorn.getOpenUnicorn().stop();
			}
		});
		this.add(button_closeGame, 0);

		gameCanvas = new Component();
		this.add(gameCanvas);
	}

	public static Component getGameCanvas() {
		return gameCanvas;
	}

}
