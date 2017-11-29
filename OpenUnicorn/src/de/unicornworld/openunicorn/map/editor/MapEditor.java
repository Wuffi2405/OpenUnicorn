package de.unicornworld.openunicorn.map.editor;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.unicornworld.openunicorn.frame.Button;

public class MapEditor extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6911600628982462082L;
	private static final int RENDER_DISTANCE_FROM_TOP = 50;
	private static JFrame frame;
	private static JPanel panel;
	private MenuBar menuBar;
	private boolean running = false;
	private Thread thread;
	private World world;

	public MapEditor() {
		frame = new JFrame();
		frame.setLayout(null);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(true);

		frame.add(this);
//		frame.repaint();
		
		addKeyListener(new de.unicornworld.openunicorn.map.editor.KeyListener());
		addMouseMotionListener(new de.unicornworld.openunicorn.map.editor.MouseListener());
		addMouseListener(new de.unicornworld.openunicorn.map.editor.MouseListener());
		
		/**
		 * panel size is set in the update
		 */
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.RED);
		
		Button buttonSettings = new Button(100, 25);
		buttonSettings.setBounds(0, 0, 100, 25);
		buttonSettings.getText().setText("Einstellungen");
		panel.add(buttonSettings);
		
		Button buttonClose = new Button(100, 25);
		buttonClose.setBounds(0, 25, 100, 25);
		buttonClose.getText().setText("Beenden");
		buttonClose.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);				
			}
		});
		panel.add(buttonClose);
		
		menuBar = new MenuBar();
		menuBar.setBounds(100, 0, 250, 50);
		panel.add(menuBar);
		
		frame.add(panel);
		frame.repaint();

		world = new World();
		start();
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this);
		thread.setName("OpenUnicorn");
		thread.start();
	}

	public synchronized void stop() {
		System.out.println("[OpenUnicorn] [MapEditor] [stop] stopped running");
		running = false;

		thread.interrupt();
	}

	@Override
	public void run() {
		System.out.println("[OpenUnicorn] [MapEditor] [run] started running");
		while (running) {
			requestFocus();
			long lastTime = System.nanoTime();
			long timer = System.currentTimeMillis();
			double ns = 1000000000.0 / 60.0;
			double delta = 0;
			int frames = 0;
			int updates = 0;
			while (running) {
				long now = System.nanoTime();
				delta += (now - lastTime) / ns;
				lastTime = now;
				while (delta >= 1) {
					update();
					updates++;
					delta--;
				}
				render();
				frames++;

				if (System.currentTimeMillis() - timer > 1000) {
					timer += 1000;
					System.out.println(updates + "ups, " + frames + "fps");
					frames = 0;
					updates = 0;
				}
			}
			stop();
		}
	}

	public void update() {
		world.update();
		panel.setSize(frame.getWidth(), RENDER_DISTANCE_FROM_TOP);
		menuBar.setSize(frame.getWidth()-100, RENDER_DISTANCE_FROM_TOP);
		panel.repaint();
	}

	public void render() {

		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.GRAY);
		g.fillRect(0, 0, frame.getWidth(), frame.getHeight());

		world.render(g);
		setBounds(0, RENDER_DISTANCE_FROM_TOP, frame.getWidth(), frame.getHeight());

		g.dispose();
		bs.show();
	}

	public static JFrame getJFrame() {
		return frame;
	}
	
}
