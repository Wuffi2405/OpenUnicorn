package de.wuffitv.openunicorn;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class Window extends Canvas implements ActionListener {

	private static final long serialVersionUID = 8904967363319735435L;
	private JFrame frame;
	private JLayeredPane layeredPane_launcher, layeredPane_game;
	private JButton button, button2;
	
	public Window(){
		frame = new JFrame();
		frame.setLayout(null);
		frame.setSize(new Dimension(400, 600));
		frame.setLocationRelativeTo(null);
		MenuPane(frame);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void MenuPane(JFrame frame){
		button = new JButton("Spiel starten");
		button.addActionListener(this);
		button.setBounds(0, 0, 150, 50);
		
		button2 = new JButton("------Klick mich------");
		button2.addActionListener(this);
		button2.setBounds(0, 50, 100, 50);
		
		layeredPane_launcher = new JLayeredPane();
		layeredPane_launcher.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		layeredPane_launcher.add(button);
		frame.add(layeredPane_launcher);
		
		layeredPane_game = new JLayeredPane();
		layeredPane_game.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		layeredPane_game.add(button2);
		frame.add(layeredPane_game);
		
	}
	
	public void setForegroundLayer(int forgroundLayer){
		/**
		 * 0 == launcher
		 * 1 == game
		 */
		if(forgroundLayer == 0){
			layeredPane_game.setVisible(false);
			layeredPane_launcher.setVisible(true);
		}else if(forgroundLayer == 1){
			layeredPane_launcher.setVisible(false);
			layeredPane_game.setVisible(true);
		}else{
			System.err.println("[OpenUnicorn] [Window] [setForgroundLayer] Value of 'int forgroundLayer' isn't allowed ");		
		}
	}
	
	public JFrame getJFrame(){
		return frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button){
			setForegroundLayer(1);
		}
		if(e.getSource() == button2){
			setForegroundLayer(0);
		}
	}
	
}
