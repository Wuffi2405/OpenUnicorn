package de.wuffitv.openunicorn.frame;

import java.awt.Canvas;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import de.wuffitv.openunicorn.Initialisation;

public class Window extends Canvas{

	private static final long serialVersionUID = 8904967363319735435L;
	private static JFrame frame;
	public static JLayeredPane layeredPane;
	public static LayeredPaneLauncher layeredPaneLauncher;
	public static LayeredPaneGame layeredPaneGame;
	
	
	public Window(){
		System.out.println("[OpenUnicorn] [Window] [Window] called");
		
		frame = new JFrame();
		frame.setLayout(null);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		MenuPane(frame);
		
		Initialisation.setFrame_widthWithoutInsets(frame.getWidth()-(frame.getInsets().left+frame.getInsets().right));
		
	}
	
	public void MenuPane(JFrame frame){
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 800, 600);
		
		/**
		 * Ebenen initialisieren
		 */
		layeredPaneLauncher = new LayeredPaneLauncher();
		layeredPaneGame = new LayeredPaneGame();
		
		/**
		 * Ebenen hinzuf�gen
		 */
		layeredPane.add(layeredPaneLauncher, 0);
		layeredPane.add(layeredPaneGame, 1);
		
		/**
		 * Buttons verstecken
		 */
		LayeredPaneLauncher.button_startGame.setVisible(true);
		LayeredPaneGame.button_closeGame.setVisible(false);
		
		/**
		 * LayeredPane zum Frame hinzuf�gen
		 */
		frame.add(layeredPane);
	}
	
	public static JFrame getJFrame(){
		return frame;
	}	
	
}
