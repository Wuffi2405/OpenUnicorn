package de.wuffitv.openunicorn;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import de.wuffitv.openunicorn.frame.LayeredPaneGame;
import de.wuffitv.openunicorn.frame.LayeredPaneLauncher;

public class Window extends Canvas{

	private static final long serialVersionUID = 8904967363319735435L;
	private static JFrame frame;
	public static JLayeredPane layeredPane;
	public static Dimension dimension;
	public static LayeredPaneLauncher layeredPaneLauncher;
	public static LayeredPaneGame layeredPaneGame;
	
	
	public Window(){
		System.out.println("[OpenUnicorn] [Window] [Window] called");
		dimension = new Dimension(800, 600);
		
		frame = new JFrame();
		frame.setLayout(null);
		frame.setSize(dimension);
		frame.setLocationRelativeTo(null);
		MenuPane(frame);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	public void MenuPane(JFrame frame){
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, dimension.width, dimension.height);
		
		layeredPaneLauncher = new LayeredPaneLauncher();
		layeredPaneGame = new LayeredPaneGame();
		
		layeredPane.add(layeredPaneLauncher, 0);
		layeredPane.add(layeredPaneGame, 1);
		
		LayeredPaneLauncher.button_startGame.setVisible(true);
		LayeredPaneGame.button_closeGame.setVisible(false);
		
		frame.add(layeredPane);
	}
	
	public static JFrame getJFrame(){
		return frame;
	}	
	
}
