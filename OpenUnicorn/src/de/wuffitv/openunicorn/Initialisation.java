package de.wuffitv.openunicorn;

public class Initialisation {
	
	private Window window;
	
	public Initialisation(){
		System.out.println("[OpenUnicorns] [Initialisation] [Initialisation] called");
		
		window = new Window();
		
		
	}
	
	public Window getWindow(){
		return window;
	}
	
}
