package de.wuffitv.openunicorn;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class Window extends Canvas {

	private static final long serialVersionUID = 8904967363319735435L;
	private JFrame frame;
	private JLayeredPane launcher, launcher2;
	
	public Window(){
		frame = new JFrame();
		frame.setLayout(null);
		frame.setSize(new Dimension(400, 600));
		frame.setLocationRelativeTo(null);
		MenuPane();
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void MenuPane(){
		JButton button = new JButton("Klick mich");
		button.setBounds(0, 0, 100, 50);
		
		JButton button2 = new JButton("Klick mich");
		button.setBounds(0, 50, 100, 50);
		
		launcher = new JLayeredPane();
		launcher.setBounds(0, 0, 100, 200);
		launcher.add(button);
		frame.add(launcher);
		
		launcher2 = new JLayeredPane();
		launcher2.setBounds(0, 0, 100, 200);
		launcher2.add(button2);
		frame.add(launcher2);
	}
	
}
