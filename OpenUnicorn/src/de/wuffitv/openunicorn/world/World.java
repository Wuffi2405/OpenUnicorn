package de.wuffitv.openunicorn.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import de.wuffitv.openunicorn.KeyInput;
import de.wuffitv.openunicorn.entity.Player;

public class World {
	
	public static int world_x = 0;
	public static int world_y = 0;
	public static int world_width = 1024;
	public static int world_height = 1024;
	private BufferedImage background;
	
	public World(){
		System.out.println("[OpenUnicorn] [World] [World] called");
//		background = new BufferedImage(1024, 1024, BufferedImage.TYPE_INT_ARGB);
//		background = SourceLoader.loadImage("/de/wuffitv/openunicorn/images/background.png");
		
	}
	
	public void update(){
		if(KeyInput.W) world_y += Player.player_speed_y;
		if(KeyInput.A) world_x += Player.player_speed_x;
		if(KeyInput.S) world_y -= Player.player_speed_y;
		if(KeyInput.D) world_x -= Player.player_speed_x;
		
		if(Player.player_x < 0){
			world_x = 0;
			Player.player_x = 0;
		}
		
		if(Player.player_y < 0){
			world_y = 0;
			Player.player_y = 0;
		}
		
//		if(Player.player_x + Player.player_width > world_x+world_width){
//			Player.player_x = world_x+world_width-Player.player_width;
//			System.out.println(222);
//		}
//		if(world_x > background.getWidth() - Window.getJFrame().getWidth()){
//			System.out.println(222);
//		}
////		System.out.println(world_x*-1 + " || " + world_width + " || " + (Player.player_x + Player.player_width));
	}
	
	public void render(Graphics g){
//		g.drawImage(SourceLoader.loadImage("/de/wuffitv/openunicorn/images/background.png"), world_x, world_y, world_width, world_height, null);
	}
	
}
