package de.wuffitv.openunicorn;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class OpenUnicorn implements Runnable {
	
	private static OpenUnicorn openUnicorn;
	private PreInitialisation preInitialisation;
	private Initialisation initialisation;
	private boolean running = false;
	private Thread thread;
	
	public static void main(String[] args) {
		openUnicorn = new OpenUnicorn();
	}
	
	public OpenUnicorn(){
		preInitialisation = new PreInitialisation();
		start();
		/*
		 * 
		 * start(); bzw. run() wird erst nach initialisation aufgerufen
		 * --> soll nicht so sein
		 * --> am besten aus dem Ende der PreInitialisation aufrufen
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		initialisation = new Initialisation();
	}
	
	
	/**
	 * Getter & Setter
	 */
	public PreInitialisation getPreInitialisation(){
		return preInitialisation;
	}
	
	public Initialisation getInitialisation(){
		return initialisation;
	}
	
	public static OpenUnicorn getOpenUnicorn(){
		return openUnicorn;
	}
	
	public synchronized void start(){
		running = true;
		thread = new Thread(this);
		thread.setName("OpenUnicorn");
		thread.start();
	}
	
	public synchronized void stop(){
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		System.out.println("[OpenUnicorn] [OpenUnicorn] [run] started running");
		while(running){
			OpenUnicorn.getOpenUnicorn().getPreInitialisation().getWindow().requestFocus();
			long lastTime = System.nanoTime();
			long timer = System.currentTimeMillis();
			double ns = 1000000000.0 / 60.0;
			double delta = 0;
			int frames = 0;
			int updates = 0;
			while(running){
				long now = System.nanoTime();
				delta += (now - lastTime) / ns;
				lastTime = now;
				while(delta >= 1){
					update();
					updates++;
					delta --;
				}
				render();
				frames ++;
				
				if(System.currentTimeMillis() - timer > 1000){
					timer += 1000;
					System.out.println(updates + "ups, " + frames + "fps");
					frames = 0;
					updates = 0;
				}
			}
			stop();
		}
	}
	
	public void update(){
		
	}
	
	public void render(){
		
//		BufferStrategy bs = getBufferStrategy();
//		if(bs == null){
//			createBufferStrategy(3);
//			return;
//		}
//		
//		Graphics g = bs.getDrawGraphics();
//		
//		g.setColor(Color.BLACK);
//		g.fillRect(0, 0, 100, 500);
//		
//		g.dispose();
//		bs.show();
//		
		/**
		 * NOR WORKING
		 * 
		 * Create a seperat class for the Layered_game
		 * --> create it there
		 */
		
	}
	
}
