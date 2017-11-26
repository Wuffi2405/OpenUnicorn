package de.unicornworld.openunicorn.map.editor;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import de.unicornworld.openunicorn.util.SourceLoader;

public class MenuBar extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8033602372515699110L;
	
	private JButton button;
	
	public MenuBar(){
		button = new JButton("/assets/texture/icon/dirt.ico");
		button.setBounds(0, 0, 100, 20);
		button.setBackground(Color.GREEN);
		add(button);
	}
	
}
