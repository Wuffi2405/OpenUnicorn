package de.unicornworld.openunicorn.map.editor;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import de.unicornworld.openunicorn.frame.Button;

public class MapEditor extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6911600628982462082L;
	private JFrame frame;
	private Button buttonRender;
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
		frame.repaint();

		buttonRender = new Button(150, 20);
		buttonRender.setBounds(10, 10, 150, 20);
		buttonRender.getText().setText("Render");
		buttonRender.getText().setFont(new Font("Calibri", Font.BOLD, 20));
		buttonRender.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				start();

			}
		});
		// frame.add(buttonRender);

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
		setBounds(0, 0, frame.getWidth(), frame.getHeight());

		g.dispose();
		bs.show();
	}

}
