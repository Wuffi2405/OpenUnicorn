package de.wuffitv.openunicorn.world;

import java.awt.Graphics;

import de.wuffitv.openunicorn.KeyInput;
import de.wuffitv.openunicorn.entity.Player;
import de.wuffitv.openunicorn.util.SourceLoader;

public class World {
	
	public static int world_x = 0;
	public static int world_y = 0;
	public static int world_width = 1024;
	public static int world_height = 1024;
	
	public World(){
//		System.out.println("WARNING [OpenUnicorn] [World] NOT ENOUGH FPS, FPS: 15-26; NEED: MIN 30");
		System.out.println("[OpenUnicorn] [World] [World] called");
		
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
		
		if(Player.player_x + Player.player_width > world_x+world_width){
			System.out.println(222);
		}
		System.out.println(world_x*-1 + " || " + world_width + " || " + (Player.player_x + Player.player_width));
	}
	
	public void render(Graphics g){
		g.drawImage(SourceLoader.loadImage("/de/wuffitv/openunicorn/images/background.png"), world_x, world_y, world_width, world_height, null);
	}
	
}
