package de.wuffitv.openunicorn;

public class OpenUnicorn {
	
	public static OpenUnicorn openUnicorn;
	private PreInitialisation preInitialisation;
	private Initialisation initialisation;
	
	public static void main(String[] args) {
		openUnicorn = new OpenUnicorn();
	}
	
	public OpenUnicorn(){
		preInitialisation = new PreInitialisation();
		initialisation = new Initialisation();
	}
	
}
