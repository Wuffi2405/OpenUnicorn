package de.wuffitv.openunicorn.world;

import java.awt.Graphics;

import de.wuffitv.openunicorn.util.SourceLoader;

public class World {
	
	public static int world_x;
	public static int world_y;
	public static int world_width = 1024;
	public static int world_height = 1024;
	
	public World(){
		System.out.println("WARNING [OpenUnicorn] [World] NOT ENOUGH FPS, FPS: 15-26; NEED: MIN 30");
		System.out.println("[OpenUnicorn] [World] [World] called");
		
	}
	
	public void update(){
		
	}
	
	public void render(Graphics g){
		g.drawImage(SourceLoader.loadImage("/de/wuffitv/openunicorn/images/background.png"), 0, 0, world_width, world_height, null);
	}
	
}
