package de.unicornworld.openunicorn.frame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import de.unicornworld.openunicorn.Component;
import de.unicornworld.openunicorn.OpenUnicorn;

public class LayeredPaneGame extends JPanel {

	private static final long serialVersionUID = 1L;

	public static Button button_closeGame;
	private static Component gameCanvas;

	public LayeredPaneGame() {
		setBounds(0, 0, 800, 600);
		setLayout(null);
 
		button_closeGame = new Button();
		button_closeGame.setBounds(Window.getJFrame().getWidth()-150, 10, 100, 25);
		button_closeGame.text.setText("Spiel schlieﬂen");
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
