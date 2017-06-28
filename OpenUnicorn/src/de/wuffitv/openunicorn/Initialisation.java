package de.wuffitv.openunicorn;

import java.awt.Graphics;

import de.wuffitv.openunicorn.entity.Player;
import de.wuffitv.openunicorn.world.World;

public class Initialisation {
	
	public static Initialisation initialisation;
	
	private boolean readyForLoop = false;
	
	private static int frame_widthWithoutInsets = 0;
	private static int frame_heightWithoutInsets = 0;
	private Player player;
	private World world;
	
	public Initialisation(){
		System.out.println("[OpenUnicorn] [Initialisation] [Initialisation] called");
		
		world = new World();
		player = new Player();
		
//		World.background = SourceLoader.loadImage("assets/de/wuffitv/openunicorn/images/background.png");
//		world = new World();
//		player = new Player();
//		
		readyForLoop = true;
		/**
		 * init KeyListener
		 * Updater
		 * Renderer
		 * 
		 * load World		
		 */
		
	}
	
	public void update(){
		if(readyForLoop){
			world.update();
			player.update();
		}
	}
	
	public void render(Graphics g){
		if(readyForLoop){
			world.render(g);
			player.render(g);
		}
	}

	public static int getFrame_widthWithoutInsets() {
		return frame_widthWithoutInsets;
	}

	public static void setFrame_widthWithoutInsets(int frame_widthWithoutInsets) {
		Initialisation.frame_widthWithoutInsets = frame_widthWithoutInsets;
	}

	public static int getFrame_heightWithoutInsets() {
		return frame_heightWithoutInsets;
	}

	public static void setFrame_heightWithoutInsets(int frame_heightWithoutInsets) {
		Initialisation.frame_heightWithoutInsets = frame_heightWithoutInsets;
	}
	
}
