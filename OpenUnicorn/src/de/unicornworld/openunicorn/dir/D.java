package de.unicornworld.openunicorn.dir;

import java.io.File;
import java.io.IOException;

public class D {

	// Global
	public static String PATH_DIRECTORY_SYSTEM = "C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming";
	public static String PATH_DIRECTORY = PATH_DIRECTORY_SYSTEM + "\\UnicornWorld";
	public static String PATH_DIRECTORY_SAVES = PATH_DIRECTORY + "\\saves";
	public static String PATH_FILE_SAVE = PATH_DIRECTORY_SAVES + "\\save.uwf";

	//Private
	private File dDir;
	private File dSaves;
	private File fSave;
	
	//---Global speicher bedürftige Werte-----------------------
	
	//----------------------------------------------------------
	
	public D() {
		System.out.println("[OpenUnicorn] [D] [D] called");
		// init File-Objects
		dDir = new File(PATH_DIRECTORY);
		dSaves = new File(PATH_DIRECTORY_SAVES);
		fSave = new File(PATH_FILE_SAVE);
		createDirectory();
		
		D_Load.loadD();
	}

	public void createDirectory() {
		System.out.println("[OpenUnicorn] [D] [createDirectory] undefined Directories and Files are creating...");
		// Main Directory
		if (!dDir.exists()) {
			dDir.mkdirs();
		}
		// Saves Directory
		if (!dSaves.exists()) {
			dSaves.mkdirs();
		}
		// Save File
		if (!fSave.exists()) {
			try {
				fSave.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("[OpenUnicorn] [D] [createDirectory] defined all Directories and Files");
	}

}
