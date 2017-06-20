package de.wuffitv.openunicorn.entity;

import java.awt.Graphics;

import de.wuffitv.openunicorn.KeyInput;
import de.wuffitv.openunicorn.util.SourceLoader;

public class Player {
	
	public static int player_x = 0;
	public static int player_y = 0;
	public static int player_width = 64;
	public static int player_height = 64;
	public static int player_speed_x = 3;
	public static int player_speed_y = 3;
	
	public Player(){
		System.out.println("[OpenUnicorn] [Player] [Player] called");
		
	}
	
	public void update(){
		if(KeyInput.W) player_y -= player_speed_y;
		if(KeyInput.A) player_x -= player_speed_x;
		if(KeyInput.S) player_y += player_speed_y;
		if(KeyInput.D) player_x += player_speed_x;
		
		
	}
	
	public void render(Graphics g){
		g.drawImage(SourceLoader.loadImage("/de/wuffitv/openunicorn/images/politics_merkel.png"), player_x, player_y, player_width, player_height, null);
	}
	
}
