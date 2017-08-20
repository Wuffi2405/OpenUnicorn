package de.unicornworld.openunicorn.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Button extends JPanel implements MouseListener {
	
	private static final long serialVersionUID = 1385235454596571380L;
	
	private Font defaultFont = new Font("Calibri", Font.BOLD, 15);
	private Color defaultColor = Color.decode("#FFFFFF");
	private Color actionColor = Color.decode("#DCDCDC");
	
	public Text text;
	
	public Button(){
		text = new Button.Text();
		setBorder(null);
		setBackground(defaultColor);
		setFocusable(false);
		setFont(defaultFont);
		addMouseListener(this);
	}
	
	public class Text extends JLabel{
		private static final long serialVersionUID = -8590496082145124099L;

		public Text(){
			setFont(defaultFont);
			Button.this.add(this);
		}
	}	
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		setBackground(actionColor);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		setBackground(defaultColor);
	}
	
	
	
	public Font getDefaultFont() {
		return defaultFont;
	}

	public void setDefaultFont(Font defaultFont) {
		this.defaultFont = defaultFont;
	}

	public Color getDefaultColor() {
		return defaultColor;
	}

	public void setDefaultColor(Color defaultColor) {
		this.defaultColor = defaultColor;
		setBackground(this.defaultColor);
	}

	public Color getActionColor() {
		return actionColor;
	}

	public void setActionColor(Color actionColor) {
		this.actionColor = actionColor;
	}
	
}
