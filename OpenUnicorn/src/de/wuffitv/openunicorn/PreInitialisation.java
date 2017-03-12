package de.wuffitv.openunicorn;

public class PreInitialisation {
	
	private Window window;
	
	public PreInitialisation(){
		System.out.println("[OpenUnicorn] [PreInitialisation] [PreInitialisation] called");
		
		
		//Als letztes aufrufen
		window = new Window();
	}
	
	public Window getWindow(){
		return window;
	}
	
}
