package de.unicornworld.openunicorn.map.editor;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MenuBar extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8033602372515699110L;
	
	ArrayList<Material> materials = new ArrayList<>();
	
	public MenuBar(){
		/**
		 * init
		 */
		materials.add(Material.PLACEHOLDER);
		materials.add(Material.DIRT);
		materials.add(Material.GRASS);
		materials.add(Material.STONE_WAY);
		materials.add(Material.STONE_WAY_OLD);
		
		/**
		 * rendering
		 */
		setLayout(null);
		setBackground(Color.YELLOW);
		
		ArrayList<Item> items = new ArrayList<>();
		
		for(int i = 0; i < materials.size(); i++){
			items.add(new Item(materials.get(i)));
			items.get(i).setBounds(i*50, 0, 50, 50);
			this.add(items.get(i));
		}
		
		System.out.println(items.size());
		
		repaint();
	}
	
}
