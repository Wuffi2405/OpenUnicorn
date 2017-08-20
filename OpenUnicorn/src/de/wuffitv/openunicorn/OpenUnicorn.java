package de.wuffitv.openunicorn;

import java.awt.Canvas;

import de.unicornworld.openunicorn.Component;
import de.wuffitv.openunicorn.frame.LayeredPaneGame;

public class OpenUnicorn extends Canvas implements Runnable {
	
	private static final long serialVersionUID = -3150180067987504535L;
	
	private static OpenUnicorn openUnicorn;
	private PreInitialisation preInitialisation;
	private Component component;
	private boolean running = false;
	private Thread thread;
	
	public static void main(String[] args) {
		openUnicorn = new OpenUnicorn();
	}
	
	public OpenUnicorn(){		
		preInitialisation = new PreInitialisation();
		//if start button was pushed, the loop begins
	}
	
	public void callInitialisation(){
		System.out.println("[OpenUnicorn] [OpenUnicorn] [callInitialisation] called");
		component = new Component();
	}
	
	public synchronized void start(){
		running = true;
		thread = new Thread(this);
		thread.setName("OpenUnicorn");
		thread.start();
	}
	
	public synchronized void stop(){
		running = false;
		
		thread.interrupt();
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
		
		LayeredPaneGame.getGameCanvas().update();
	}
	
	public void render(){
		LayeredPaneGame.getGameCanvas().render();
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
	
	public PreInitialisation getPreInitialisation(){
		return preInitialisation;
	}
	
	public Component getInitialisation(){
		return component;
	}
	
	public static OpenUnicorn getOpenUnicorn(){
		return openUnicorn;
	}
	
}
