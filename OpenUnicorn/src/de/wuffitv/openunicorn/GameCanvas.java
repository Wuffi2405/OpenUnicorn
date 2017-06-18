package de.wuffitv.openunicorn;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class GameCanvas extends Canvas {
	
	private static final long serialVersionUID = 3809363670935094921L;

	public GameCanvas(){
		System.out.println("[OpenUnicorn] [GameCanvas] [GameCanvas] called");
		
		setBounds(0, 0, Window.dimension.width, Window.dimension.height);
		setBackground(Color.MAGENTA);
	}
	
	public void update(){
		OpenUnicorn.getOpenUnicorn().getInitialisation().update();
	}
	
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, Initialisation.getFrame_width(), Initialisation.getFrame_height());
//		System.out.println("width: " + Window.getJFrame().getWidth() + " || ");
//		System.out.println("insets: " + Window.getJFrame().getInsets().right + " || " + Window.getJFrame().getInsets().left);
		
		g.setColor(Color.RED);
		g.fillRect(790, 0, 10, 500);
		
		g.dispose();
		bs.show();
	}
	
}
