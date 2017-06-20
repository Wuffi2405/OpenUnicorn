package de.wuffitv.openunicorn;

import java.awt.Canvas;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import de.wuffitv.openunicorn.frame.LayeredPaneGame;
import de.wuffitv.openunicorn.frame.LayeredPaneLauncher;

public class Window extends Canvas{

	private static final long serialVersionUID = 8904967363319735435L;
	private static JFrame frame;
	public static JLayeredPane layeredPane;
//	public static Dimension dimension;
	public static LayeredPaneLauncher layeredPaneLauncher;
	public static LayeredPaneGame layeredPaneGame;
	
	
	public Window(){
		System.out.println("[OpenUnicorn] [Window] [Window] called");
//		dimension = new Dimension(800, 600);
		
		frame = new JFrame();
		frame.setLayout(null);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
//		MenuPane(frame);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		MenuPane(frame);
		
		Initialisation.setFrame_widthWithoutInsets(frame.getWidth()-(frame.getInsets().left+frame.getInsets().right));
		
	}
	
	public void MenuPane(JFrame frame){
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 800, 600);
		
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
