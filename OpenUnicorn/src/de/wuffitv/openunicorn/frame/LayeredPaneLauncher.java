package de.wuffitv.openunicorn.frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import de.wuffitv.openunicorn.Initialisation;
import de.wuffitv.openunicorn.OpenUnicorn;

public class LayeredPaneLauncher extends JPanel {
	
	private static final long serialVersionUID = 3803108154839418167L;

	public static JButton button_startGame;
	
	public static Initialisation initialisation;
	
	public LayeredPaneLauncher(){
		setBounds(0, 0, 800, 600);
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		button_startGame = new JButton("Spiel starten");
		button_startGame.setBounds(0, 0, 150, 50);
		button_startGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				initialisation = new Initialisation();
				Window.layeredPane.moveToFront(Window.layeredPaneGame);
				LayeredPaneGame.button_closeGame.setVisible(true);
				LayeredPaneLauncher.button_startGame.setVisible(false);
				
				OpenUnicorn.getOpenUnicorn().start();
			}
		});
		this.add(button_startGame);
		
	}

}
