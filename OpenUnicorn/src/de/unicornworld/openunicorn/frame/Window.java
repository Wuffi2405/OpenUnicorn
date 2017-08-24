package de.unicornworld.openunicorn.frame;

import java.awt.Canvas;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class Window extends Canvas{

	private static final long serialVersionUID = 8904967363319735435L;
	private static JFrame frame;
	public static JLayeredPane layeredPane;
	public static LayeredPaneLauncher layeredPaneLauncher;
	public static LayeredPaneCredits layeredPaneCredits;
	public static LayeredPaneGame layeredPaneGame;
	
	public static ArrayList<Button> button_launcher = new ArrayList<>();
	public static ArrayList<Button> button_credits = new ArrayList<>();
	public static ArrayList<Button> button_game = new ArrayList<>();
	
	
	public Window(){
		System.out.println("[OpenUnicorn] [Window] [Window] called");
		
		frame = new JFrame();
		frame.setLayout(null);
		frame.setSize(800, 600);
		MenuPane(frame);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(true);	
	}
	
	public void MenuPane(JFrame frame){
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 800, 600);
		
		/**
		 * Ebenen initialisieren
		 */
		layeredPaneLauncher = new LayeredPaneLauncher(Window.this);
		layeredPaneCredits = new LayeredPaneCredits();
		layeredPaneGame = new LayeredPaneGame();
		
		/**
		 * Ebenen hinzufügen
		 */
		layeredPane.add(layeredPaneLauncher, 0);
		layeredPane.add(layeredPaneCredits, 1);
		layeredPane.add(layeredPaneGame, 2);
		
		/**
		 * Buttons visible || alles was nicht auf den Hauptscreen gehört wird unsichtbar
		 */
		LayeredPaneGame.button_closeGame.setVisible(false);
		
		/**
		 * LayeredPane zum Frame hinzufügen
		 */
		frame.add(layeredPane);
	}
	
	public void callCreditsAnimation() {
		layeredPaneCredits.run();
	}
	
	public static JFrame getJFrame(){
		return frame;
	}	
	
}
