package de.unicornworld.openunicorn.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.wuffitv.openunicorn.util.SourceLoader;

public class LayeredPaneCredits extends JPanel {

	private static final long serialVersionUID = -1924166369822977552L;
	
	private Button button_back;
	public static JLabel credits;
	private JLabel image;
	public static boolean animateCredits = false;
	private int y = 0;
	
	String credits_text = "<html><body>Projektleitung:<br>Nico Matzke<br><br>Game Design:<br>Markus Krancher<br>Nico Matzke<br><br>Programmierung:<br>Fabius Mayer-Uhma<br>Nico Matzke<br><br>Grafik:<br>Jesko Alexander Kloß<br><br>Sounds:<br>Markus Krancher<br></body></html>";
	
	public LayeredPaneCredits() {
		setBounds(0, 0, 800, 600);
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		credits = new JLabel(credits_text);
		credits.setBounds(y, 0, Window.getJFrame().getWidth(), Window.getJFrame().getHeight());
		credits.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		credits.setFont(new Font("Calibri", Font.BOLD, 25));
		credits.setForeground(Color.BLACK);
		this.add(credits);
		
		button_back = new Button();
		button_back.setBounds(20, 20, 100, 30);
		button_back.text.setText("Zurück");
		button_back.text.setFont(new Font("Calibri", Font.BOLD, 17));
		Window.button_credits.add(button_back);
		button_back.addMouseListener(new MouseListener() {
			 
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
				Window.layeredPane.moveToFront(Window.layeredPaneLauncher);
				for(int i = 0; i < Window.button_launcher.size(); i++) {
					Window.button_launcher.get(i).setVisible(true);
				}
				for(int i = 0; i < Window.button_credits.size(); i++) {
					Window.button_credits.get(i).setVisible(false);
				}
				for(int i = 0; i < Window.button_game.size(); i++) {
					Window.button_game.get(i).setVisible(false);
				}
				credits.setVisible(false);
				animateCredits = false;
			}
		});
		this.add(button_back);
		
		image = new JLabel(new ImageIcon(SourceLoader.loadImage("/assets/texture/launcher/launcher-background.png")));
		image.setBounds(0, 0, Window.getJFrame().getWidth(), Window.getJFrame().getHeight());
		this.add(image);
		
	}
	
	public synchronized void callRun() {
		run();
	}
	
	public void run() {
		System.out.println(9);
//		OpenUnicorn.getOpenUnicorn().getPreInitialisation().getWindow().requestFocus();
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		while(animateCredits){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				update();
				updates++;
				delta --;
			}
			frames ++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println(updates + "ups, " + frames + "fps");
				frames = 0;
				updates = 0;
			}
		}
	}
	
	public void update() {
		y+=5;
		System.out.println(5);
		repaint();
	}
	
}
