package de.wuffitv.openunicorn.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import de.unicornworld.openunicorn.Component;
import de.wuffitv.openunicorn.OpenUnicorn;

public class LayeredPaneGame extends JPanel {

	private static final long serialVersionUID = 1L;

	public static JButton button_closeGame;
	private static Component gameCanvas;

	public LayeredPaneGame() {
		setBounds(0, 0, 800, 600);
		setLayout(null);

		button_closeGame = new JButton("Spiel schlie�en");
		button_closeGame.setBounds(200, 0, 150, 50);
		button_closeGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Window.layeredPane.moveToFront(Window.layeredPaneLauncher);
				LayeredPaneLauncher.button_startGame.setVisible(true);
				LayeredPaneGame.button_closeGame.setVisible(false);

				Window.getJFrame().dispose();
				OpenUnicorn.getOpenUnicorn().stop();
			}
		});
		button_closeGame.setFocusable(false);
		this.add(button_closeGame, 0);

		gameCanvas = new Component();
		this.add(gameCanvas);
	}

	public static Component getGameCanvas() {
		return gameCanvas;
	}

}
