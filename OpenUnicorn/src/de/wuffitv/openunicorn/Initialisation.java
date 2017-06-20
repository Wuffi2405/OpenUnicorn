package de.wuffitv.openunicorn;

import java.awt.Graphics;

import de.wuffitv.openunicorn.util.SourceLoader;

public class Initialisation {
	
	private static int frame_widthWithoutInsets = 0;
	private static int frame_heightWithoutInsets = 0;
	
	public Initialisation(){
		System.out.println("[OpenUnicorn] [Initialisation] [Initialisation] called");
		
		/**
		 * init KeyListener
		 * Updater
		 * Renderer
		 * 
		 * load World		
		 */
		
	}
	
	public void update(){
		
	}
	
	public void render(Graphics g){
		g.drawImage(SourceLoader.loadImage("/de/wuffitv/openunicorn/images/politics_merkel.png"), 0, 0, 128, 265, null);
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
