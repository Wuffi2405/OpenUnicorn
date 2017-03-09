package de.wuffitv.openunicorn;

public class OpenUnicorn {
	
	private static OpenUnicorn openUnicorn;
	private PreInitialisation preInitialisation;
	private Initialisation initialisation;
	
	public static void main(String[] args) {
		openUnicorn = new OpenUnicorn();
	}
	
	public OpenUnicorn(){
		preInitialisation = new PreInitialisation();
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
}
