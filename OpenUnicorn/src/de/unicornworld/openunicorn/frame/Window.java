package de.unicornworld.openunicorn.frame;

import java.awt.Canvas;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import de.unicornworld.openunicorn.world.World;

public class Window extends Canvas {

	private static final long serialVersionUID = 8904967363319735435L;
	private static JFrame frame;
	public static JLayeredPane layeredPane;
	public static LayeredPaneLauncher layeredPaneLauncher;
	public static LayeredPaneCredits layeredPaneCredits;
	public static LayeredPaneGame layeredPaneGame;

	public static ArrayList<Button> button_launcher = new ArrayList<>();
	public static ArrayList<Button> button_credits = new ArrayList<>();
	public static ArrayList<Button> button_game = new ArrayList<>();

	public Window() {
		System.out.println("[OpenUnicorn] [Window] [Window] called");

		frame = new JFrame();
		frame.setLayout(null);
		frame.setSize(800, 600);
		MenuPane(frame);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(true);
		frame.requestFocus();

		frame.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {

			}

			@Override
			public void windowIconified(WindowEvent e) {

			}

			@Override
			public void windowDeiconified(WindowEvent e) {

			}

			@Override
			public void windowDeactivated(WindowEvent e) {

			}

			@Override
			public void windowClosing(WindowEvent e) {

				System.err.println("GAMEPROCESS CRASHED / EXITED");
				System.exit(1);
			}

			@Override
			public void windowClosed(WindowEvent e) {

			}

			@Override
			public void windowActivated(WindowEvent e) {

			}
		});

	}

	public void MenuPane(JFrame frame) {
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 800, 600);

		/**
		 * Ebenen initialisieren
		 */
		layeredPaneLauncher = new LayeredPaneLauncher(Window.this);
		layeredPaneCredits = new LayeredPaneCredits();
		layeredPaneGame = new LayeredPaneGame();

		/**
		 * Ebenen hinzuf�gen
		 */
		layeredPane.add(layeredPaneLauncher, 0);
		layeredPane.add(layeredPaneCredits, 1);
		layeredPane.add(layeredPaneGame, 2);

		/**
		 * Buttons visible || alles was nicht auf den Hauptscreen geh�rt wird unsichtbar
		 */
		LayeredPaneGame.button_closeGame.setVisible(false);

		/**
		 * LayeredPane zum Frame hinzuf�gen
		 */
		frame.add(layeredPane);
	}

	public void callCreditsAnimation() {
		layeredPaneCredits.run();
	}

	public static JFrame getJFrame() {
		return frame;
	}

	public static boolean containsPoint(int x, int y) {

		if (x + World.difx < 0 || x + World.difx > frame.getWidth() | y + World.dify < 0 || y + World.dify > frame.getHeight()) {
			return false;
		}

		return true;

	}

	public static boolean containsRectangle(int x, int y, int width, int height) {

		if (x + width + World.difx < 0 || x + width + World.difx > frame.getWidth() + 20 || y + height + World.dify < 0 || y + height + World.dify > frame.getHeight()) {
			return false;
		}

		return true;

	}

}
