package de.unicornworld.openunicorn.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.unicornworld.openunicorn.OpenUnicorn;
import de.wuffitv.openunicorn.util.SourceLoader;

public class LayeredPaneLauncher extends JPanel {
	
	private static final long serialVersionUID = 3803108154839418167L;

	public static Button buttonStartGame, buttonCredits, buttonCloseGame;
	public static JLabel image;
	
	
	public LayeredPaneLauncher(){
		setBounds(0, 0, 800, 600);
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		buttonStartGame = new Button();
		buttonStartGame.setBounds(Window.getJFrame().getWidth()/2-100-Window.getJFrame().getInsets().left-Window.getJFrame().getInsets().right, 300, 200, 50);
		buttonStartGame.text.setText("Spiel Starten");
		buttonStartGame.text.setFont(new Font("Calibri", Font.BOLD, 30));
		Window.button_launcher.add(buttonStartGame);
		buttonStartGame.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
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
				for(int i = 0; i < Window.button_launcher.size(); i++) {
					Window.button_launcher.get(i).setVisible(false);
				}
				for(int i = 0; i < Window.button_credits.size(); i++) {
					Window.button_credits.get(i).setVisible(false);
				}
				for(int i = 0; i < Window.button_game.size(); i++) {
					Window.button_game.get(i).setVisible(true);
				}
				
				OpenUnicorn.getOpenUnicorn().start();				
			}
		});
		this.add(buttonStartGame);
		
		buttonCredits = new Button();
		buttonCredits.setBounds(Window.getJFrame().getWidth()/2-100-Window.getJFrame().getInsets().left-Window.getJFrame().getInsets().right, 400, 200, 50);
		buttonCredits.text.setText("Credits");
		buttonCredits.text.setFont(new Font("Calibri", Font.BOLD, 30));
		Window.button_launcher.add(buttonCredits);
		buttonCredits.addMouseListener(new MouseListener() {
			
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
				Window.layeredPane.moveToFront(Window.layeredPaneCredits);
				for(int i = 0; i < Window.button_launcher.size(); i++) {
					Window.button_launcher.get(i).setVisible(false);
				}
				for(int i = 0; i < Window.button_credits.size(); i++) {
					Window.button_credits.get(i).setVisible(true);
				}
				for(int i = 0; i < Window.button_game.size(); i++) {
					Window.button_game.get(i).setVisible(false);
				}
				LayeredPaneCredits.credits.setVisible(true);
				LayeredPaneCredits.animateCredits = true;
//				LayeredPaneCredits.callRun();
			}
		});
		this.add(buttonCredits);
		
		buttonCloseGame = new Button();
		buttonCloseGame.setBounds(Window.getJFrame().getWidth()/2-100-Window.getJFrame().getInsets().left-Window.getJFrame().getInsets().right, 500, 200, 50);
		buttonCloseGame.text.setText("Beenden");
		buttonCloseGame.text.setFont(new Font("Calibri", Font.BOLD, 30));
		Window.button_launcher.add(buttonCloseGame);
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
