package de.wuffitv.openunicorn.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import de.wuffitv.openunicorn.Initialisation;
import de.wuffitv.openunicorn.KeyInput;
import de.wuffitv.openunicorn.entity.Player;
import de.wuffitv.openunicorn.frame.Window;
import de.wuffitv.openunicorn.util.SourceLoader;

public class World {
	
	public static int world_x = 0;
	public static int world_y = 0;
	public static int world_width = 1024;
	public static int world_height = 1024;
	private BufferedImage background;
	
	public World(){
		System.out.println("[OpenUnicorn] [World] [World] called");
		
		background = SourceLoader.loadImage("/de/wuffitv/openunicorn/images/background.png");
		
	}
	
	public void update(){
		if(KeyInput.W){
			world_y += Player.player_speed_y;
		}
		if(KeyInput.A){//links
			/**
			 * Wenn über die Hälfte des Feldes
			 */
			if(Player.player_x < Window.getJFrame().getWidth()/2){				
				/**
				 * Welt bewegen
				 */
				if(world_x < 0){
					world_x += Player.player_speed_x;
				}else{
					/**
					 * Spieler bewegen
					 */
					if(Player.player_x > world_x){
						Player.player_x -= Player.player_speed_x;
					}
				}
				
			}
			
			/**
			 * bewegen bis zur Mitte des Fensters
			 */
			if(!(Player.player_x < Window.getJFrame().getWidth()/2)){
				Player.player_x -= Player.player_speed_x;
			}
		}
		
		if(KeyInput.S) world_y -= Player.player_speed_y;
		
		if(KeyInput.D){ //rechts
			/**
			 * Welt oder Spieler bewegen
			 */
			if(!(world_x+world_width < Initialisation.getFrame_widthWithoutInsets())){
				/**
				 * Welt bewegen
				 */
				world_x -= Player.player_speed_x;
			}
			
			if(world_x+world_width < Initialisation.getFrame_widthWithoutInsets()){
				/**
				 * Spieler bewegen
				 */
				if(Player.player_x + Player.player_width > Initialisation.getFrame_widthWithoutInsets() 
						|| Player.player_x + Player.player_width+Player.player_speed_x > Initialisation.getFrame_widthWithoutInsets()){
					Player.player_x = world_x+world_width-Player.player_width;
				}
			}
		}
//		
//		if(Player.player_x < 0){
//			world_x = 0;
//			Player.player_x = 0;
//		}
		
		if(Player.player_y < 0){
			world_y = 0;
			Player.player_y = 0;
		}
		
	}
	
	public void render(Graphics g){
		g.drawImage(background, world_x, world_y, world_width, world_height, null);
	}
	
}
