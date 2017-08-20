package de.wuffitv.openunicorn;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import de.wuffitv.openunicorn.frame.LayeredPaneLauncher;
import de.wuffitv.openunicorn.frame.Window;

public class GameCanvas extends Canvas {
	
	private static final long serialVersionUID = 3809363670935094921L;

	public GameCanvas(){
		System.out.println("[OpenUnicorn] [GameCanvas] [GameCanvas] called");
		
		setBounds(0, 0, 800, 600); // test
		
		Initialisation.setFrame_widthWithoutInsets(Window.getJFrame().getWidth()-(Window.getJFrame().getInsets().left+Window.getJFrame().getInsets().right));
		Initialisation.setFrame_heightWithoutInsets(Window.getJFrame().getHeight()-(Window.getJFrame().getInsets().top+Window.getJFrame().getInsets().bottom));
		
		addKeyListener(new KeyInput());
	}
	
	public void update(){
//		OpenUnicorn.getOpenUnicorn().getInitialisation().update();
		LayeredPaneLauncher.initialisation.update();
	}
	
	public void render(){
		
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		/**
		 * set bg, against a bug xD
		 */
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 20000, 20000);

//		OpenUnicorn.getOpenUnicorn().getInitialisation().render(g);
		LayeredPaneLauncher.initialisation.render(g);
		
		g.dispose();
		bs.show();
	}
	
}
