package de.unicornworld.openunicorn;

import de.unicornworld.openunicorn.dir.D;
import de.unicornworld.openunicorn.frame.Window;

public class PreInitialisation {
	
	private Window window;
	@SuppressWarnings("unused")
	private D d;
	
	public PreInitialisation(){
		System.out.println("[OpenUnicorn] [PreInitialisation] [PreInitialisation] called");
		
		d = new D();
		//System.out.println(D.PATH_DIRECTORY);
		
		//last post init
		window = new Window();
		
	} 
	
	public Window getWindow(){
		return window;
	}
	
}
