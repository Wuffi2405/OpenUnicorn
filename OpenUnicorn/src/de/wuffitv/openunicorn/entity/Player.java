package de.wuffitv.openunicorn.entity;

import java.awt.Graphics;

import de.wuffitv.openunicorn.KeyInput;
import de.wuffitv.openunicorn.util.SourceLoader;

public class Player {
	
	public static int player_x = 0;
	public static int player_y = 0;
	public static int player_width = 64;
	public static int player_height = 128;
	public static int player_speed_x = 2;
	public static int player_speed_y = 1;
	public static boolean move_permission = true;
	public static boolean isMoving = false;
	
	public Player(){
		System.out.println("[OpenUnicorn] [Player] [Player] called");
	}
	
	public void update(){
		if(move_permission){
			if(KeyInput.W) player_y -= player_speed_y;
//			if(KeyInput.A) player_x -= player_speed_x;
			if(KeyInput.S) player_y += player_speed_y;
//			if(KeyInput.D) player_x += player_speed_x;
		}		
		
	}
	
	public void render(Graphics g){
		g.drawImage(SourceLoader.loadImage("/assets/player.png"), player_x, player_y, player_width, player_height, null);
	}
	
}
