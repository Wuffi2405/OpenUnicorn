package de.unicornworld.openunicorn.frame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import de.unicornworld.openunicorn.OpenUnicorn;
import de.wuffitv.openunicorn.util.SourceLoader;

public class LayeredPaneLauncher extends JPanel {
	
	private static final long serialVersionUID = 3803108154839418167L;

	public static JButton button_startGame;
	
	public LayeredPaneLauncher(){
		setBounds(0, 0, 800, 600);
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		button_startGame = new JButton("Spiel starten");
		button_startGame.setBounds(0, 0, 150, 50);
		button_startGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Window.layeredPane.moveToFront(Window.layeredPaneGame);
				LayeredPaneGame.button_closeGame.setVisible(true);
				LayeredPaneLauncher.button_startGame.setVisible(false);
				
				OpenUnicorn.getOpenUnicorn().start();
			}
		});
		this.add(button_startGame);
		
	}
	
	@Override
	public void paint(Graphics g) {
//		g.drawImage(SourceLoader.loadImage("/assets/texture/launcher/launcher-background.png"), 0, 0, Window.getJFrame().getWidth(), Window.getJFrame().getHeight(), null);
	}
	
}
