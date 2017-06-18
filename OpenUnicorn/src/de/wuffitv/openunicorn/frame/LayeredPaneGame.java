package de.wuffitv.openunicorn.frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import de.wuffitv.openunicorn.GameCanvas;
import de.wuffitv.openunicorn.OpenUnicorn;
import de.wuffitv.openunicorn.Window;

public class LayeredPaneGame extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public static JButton button_closeGame;
	private static GameCanvas gameCanvas;
	
	public LayeredPaneGame(){
		setBounds(0, 0, (int)Window.dimension.getWidth(), (int)Window.dimension.getHeight());
		setBackground(Color.BLACK);
		setLayout(null);
		
		button_closeGame = new JButton("Spiel schlieﬂen");
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
		this.add(button_closeGame, 0);
		
		gameCanvas = new GameCanvas();
		this.add(gameCanvas);
	}

	public static GameCanvas getGameCanvas() {
		return gameCanvas;
	}
	
}
