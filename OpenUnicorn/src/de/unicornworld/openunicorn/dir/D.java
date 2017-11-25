package de.unicornworld.openunicorn.dir;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
	private ArrayList<File> dirs = new ArrayList<>();
	private ArrayList<File> files = new ArrayList<>();
	
	//---Global speicher bedürftige Werte-----------------------
	
	//----------------------------------------------------------
	
	public D() {
		System.out.println("[OpenUnicorn] [D] [D] called");
		// init File-Objects
		dDir = new File(PATH_DIRECTORY);
		dSaves = new File(PATH_DIRECTORY_SAVES);
		fSave = new File(PATH_FILE_SAVE);
		
		dirs.add(dDir);
		dirs.add(dSaves);
		files.add(fSave);
		
		createDirectory();
		
	}

	public void createDirectory() {
		System.out.println("[OpenUnicorn] [D] [createDirectory] undefined Directories and Files are creating...");
		for(int i = 0; i < dirs.size(); i++) {
			if(!dirs.get(i).exists()) {
				dirs.get(i).mkdirs();
			}
		}
		for(int i = 0; i < files.size(); i++) {
			if(!files.get(i).exists()) {
				try {
					files.get(i).createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("[OpenUnicorn] [D] [createDirectory] defined all Directories and Files");
	}

}
