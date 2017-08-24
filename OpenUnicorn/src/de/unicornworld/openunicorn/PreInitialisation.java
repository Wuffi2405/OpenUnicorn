package de.unicornworld.openunicorn;

import de.unicornworld.openunicorn.frame.Window;

public class PreInitialisation {
	
	private Window window;
	
	public PreInitialisation(){
		System.out.println("[OpenUnicorn] [PreInitialisation] [PreInitialisation] called");
		
		//last post init
		window = new Window();
		
	} 
	
	public Window getWindow(){
		return window;
	}
	
}
