package de.unicornworld.openunicorn.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Button extends JPanel implements MouseListener {
	
	private static final long serialVersionUID = 1385235454596571380L;
	
	private Font defaultFont = new Font("Calibri", Font.BOLD, 15);
	private Color defaultColor = Color.decode("#FFFFFF");
	private Color actionColor = Color.decode("#DCDCDC");
	
	private Text text;
	
	public Button(int width, int height){
		setLayout(null);
		text = new Text(width, height);
		add(text);
		setBorder(null);
		setBackground(defaultColor);
		setFocusable(false);
		setFont(defaultFont);
		addMouseListener(this);
	}
	
	public class Text extends JLabel{
		private static final long serialVersionUID = -8590496082145124099L;

		public Text(int width, int height){
			setFont(defaultFont);
			setBounds(0, 0, width, height);
			setVerticalAlignment(SwingConstants.CENTER);
			setHorizontalAlignment(SwingConstants.CENTER);
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
	
	public Text getText() {
		return text;
	}
	
}
