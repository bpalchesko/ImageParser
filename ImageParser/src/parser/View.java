package parser;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class View extends JPanel {
	
	Parser parser;
	SourceImage source;
	public static final Color[] rainbow = {Color.RED, new Color(230,100,10), Color.YELLOW, 
			Color.GREEN, Color.BLUE, Color.CYAN, Color.MAGENTA};
	
	public View() {
		parser = new Parser();
		source = parser.source;
		setSize(source.original.getWidth(), source.original.getHeight());
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, source.original.getWidth(), source.original.getHeight());
		for(int height = 0; height < source.original.getHeight(); height++) {
			for(int width = 0; width < source.original.getWidth(); width++) {
				g.setColor(parser.currentColorMap[height][width]);
				g.drawLine(width, height, width, height);
			}
		}
	}
}
