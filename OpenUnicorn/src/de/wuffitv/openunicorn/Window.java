package de.wuffitv.openunicorn;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas {

	private static final long serialVersionUID = 8904967363319735435L;
	private JFrame frame;
	
	public Window(){
		frame = new JFrame();
		frame.setLayout(null);
		frame.setSize(new Dimension(400, 600));
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
