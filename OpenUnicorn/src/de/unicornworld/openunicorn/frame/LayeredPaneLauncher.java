package de.unicornworld.openunicorn.frame;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.unicornworld.openunicorn.OpenUnicorn;
import de.wuffitv.openunicorn.util.SourceLoader;

public class LayeredPaneLauncher extends JPanel {
	
	private static final long serialVersionUID = 3803108154839418167L;

	public static Button buttonStartGame, buttonCloseGame;
	public static JLabel image;
	
	
	public LayeredPaneLauncher(){
		setBounds(0, 0, 800, 600);
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		buttonStartGame = new Button();
		buttonStartGame.setBounds(Window.getJFrame().getWidth()/2-100-Window.getJFrame().getInsets().left-Window.getJFrame().getInsets().right, 300, 200, 50);
		buttonStartGame.text.setText("Spiel Starten");
		buttonStartGame.addMouseListener(new MouseListener() {
			
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
				Window.layeredPane.moveToFront(Window.layeredPaneGame);
				LayeredPaneGame.button_closeGame.setVisible(true);
				LayeredPaneLauncher.buttonStartGame.setVisible(false);
				
				OpenUnicorn.getOpenUnicorn().start();				
			}
		});
		this.add(buttonStartGame);
		
		buttonCloseGame = new Button();
		buttonCloseGame.setBounds(Window.getJFrame().getWidth()/2-100-Window.getJFrame().getInsets().left-Window.getJFrame().getInsets().right, 500, 200, 50);
		buttonCloseGame.text.setText("Beenden");
		buttonCloseGame.addMouseListener(new MouseListener() {
			
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
				System.exit(0);			
			}
		});
		this.add(buttonCloseGame);
		
		image = new JLabel(new ImageIcon(SourceLoader.loadImage("/assets/texture/launcher/launcher-background.png")));
		image.setBounds(0, 0, Window.getJFrame().getWidth(), Window.getJFrame().getHeight());
		this.add(image);
		
	}
}
