package de.unicornworld.openunicorn.world;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import de.unicornworld.openunicorn.entity.NPC;
import de.unicornworld.openunicorn.frame.Window;
import de.unicornworld.openunicorn.util.Path;

public class World {
	public static int worldW = 100, worldH = 100, npcamount = 1;
	public Block[][] block = new Block[worldW][worldH];
	public NPC[] npcs = new NPC[npcamount];

	private static BufferedReader reader;

	public static int difx;
	public static int dify;

	private String uwwfName;

	public World(String uwwfName) {
		this.uwwfName = uwwfName;

		for (int x = 0; x < block.length; x++) {
			for (int y = 0; y < block[0].length; y++) {
				block[x][y] = new Block(new Rectangle(x * Tile.tileSize, y * Tile.tileSize, Tile.tileSize, Tile.tileSize), Tile.air);
			}
		}
		generateLevel();

	}

	public void generateLevel() {

		try {
			reader = new BufferedReader(new FileReader(new File("OpenUnicorn/src/assets/files/worlds/" + uwwfName + ".uwwf")));

			worldW = Integer.parseInt(reader.readLine());
			worldH = Integer.parseInt(reader.readLine());

			for (int y = 0; y < worldH; y++) {
				try {

					String s = reader.readLine();

					String[] numbers = s.split("");

					for (int x = 0; x < worldW; x++) {

						if (Integer.parseInt(numbers[x]) == 1) {
							block[x][y] = new Block(new Rectangle(x * Tile.tileSize, y * Tile.tileSize, Tile.tileSize, Tile.tileSize), Tile.stone);

						} else if (Integer.parseInt(numbers[x]) == 2) {
							block[x][y] = new Block(new Rectangle(x * Tile.tileSize, y * Tile.tileSize, Tile.tileSize, Tile.tileSize), Tile.earth);
						} else {
							block[x][y] = new Block(new Rectangle(x * Tile.tileSize, y * Tile.tileSize, Tile.tileSize, Tile.tileSize), Tile.grass);

						}
					}

				} catch (Exception e) {

				}
			}

			reader.readLine();

			int npcamount = Integer.parseInt(reader.readLine());

			for (int i = 0; i < npcamount; i++) {

				String npc = reader.readLine();
				String[] npctokens = npc.split("/");
				
				String[] directions = npctokens[6].split(",");

				NPC newNPC = new NPC(Integer.parseInt(npctokens[0]), Integer.parseInt(npctokens[1]), Integer.parseInt(npctokens[2]), Integer.parseInt(npctokens[3]), Integer.parseInt(npctokens[4]), npctokens[5], new Path(directions));
				npcs[i] = newNPC;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void tick(int camX, int camY, int renW, int renH) {

		for (int i = 0; i < npcs.length; i++) {
			npcs[i].update();
		}

	}

	public void render(Graphics g, int camX, int camY, int renW, int renH) {

		// cam has to be used against lags coming soon!

		for (int x = 0; x < worldW; x++) {
			for (int y = 0; y < worldH + renH; y++) {

				if (x >= 0 && y >= 0 && x < worldW && y < worldH) {

					if (Window.containsRectangle(block[x][y].x, block[x][y].y, block[x][y].width, block[x][y].height)) {
						block[x][y].render(g);
					}
				}
			}
		}

		for (int i = 0; i < npcs.length; i++) {
			npcs[i].render(g);
		}
	}

}
