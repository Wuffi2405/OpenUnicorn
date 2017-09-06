package de.unicornworld.openunicorn.util;

import java.awt.Graphics;
import java.util.Stack;

import de.unicornworld.openunicorn.entity.NPC;

public class CreateNPCs {

	public static NPC markens;
	private static Path markens_path;

	public CreateNPCs() {

		createPaths();

		markens = new NPC(markens_path, "markens");

	}

	public void update() {

		markens.update();

	}

	public void render(Graphics g) {

		markens.render(g);

	}

	public static void createPaths() {

		markens_path = new Path(new Stack<>(), new Stack<>(), new Stack<>(), new Stack<>());
		markens_path.pushX(200);
		markens_path.pushY(40);
		markens_path.pushX(300);
		markens_path.pushY(30);
	}

}
