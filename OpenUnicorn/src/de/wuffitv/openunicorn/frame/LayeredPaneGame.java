package de.wuffitv.openunicorn.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import de.wuffitv.openunicorn.OpenUnicorn;

public class LayeredPaneGame extends JLayeredPane implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	public JLayeredPane layeredPane_game;
	private JButton button2;
	
	public LayeredPaneGame(JFrame frame){
		
		button2 = new JButton("------Klick mich------");
		button2.addActionListener(this);
		button2.setBounds(0, 50, 100, 50);
		
		layeredPane_game = new JLayeredPane();
		layeredPane_game.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		layeredPane_game.add(button2);
		frame.add(layeredPane_game);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button2){
			System.out.println("gggggggggg");
			OpenUnicorn.getOpenUnicorn().getPreInitialisation().getWindow().setForegroundLayer(0);
			/**
			 * BUG:
			 * GAME WIRD NICHT INVISIBLE
			 */
		}
	}
	
}
