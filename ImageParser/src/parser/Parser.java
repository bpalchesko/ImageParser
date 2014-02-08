package parser;

import java.awt.Color;

public class Parser {

	SourceImage source;
	Color[][] currentColorMap;
	int blue;
	int green;
	int red;
	ColorEffect colorEffect;
	public static final Color[] rainbow = {Color.RED, new Color(230,100,10), Color.YELLOW, 
		Color.GREEN, Color.BLUE, Color.CYAN, Color.MAGENTA};
	
	public enum ColorEffect {ORIGINAL, RAINBOW, BLACKWHITE};
	
	public Parser() {
		source = new SourceImage();
		colorEffect = ColorEffect.BLACKWHITE;
		makeCurrentColorMap();
	}
	
	private void makeCurrentColorMap() {
		currentColorMap = new Color[source.original.getHeight()][source.original.getWidth()];
		for (int height = 0; height < source.original.getHeight(); height++) {
			for (int width = 0; width < source.original.getWidth(); width++) {
				blue = source.originalMap[height][width] & 0xFF;
				green = (source.originalMap[height][width] >> 8) & 0xFF;
				red = (source.originalMap[height][width] >> 16) & 0xFF;
				currentColorMap[height][width] = transformColor(height, width);
			}
		}
	}
	
	public Color transformColor(int y, int x) {
		Color updatedColor = Color.WHITE;
		switch(colorEffect) {
		case ORIGINAL: 
			updatedColor = new Color(source.originalMap[y][x]);
			break;
		case RAINBOW:
			updatedColor = rainbowTransform(y,x);
			break;
		case BLACKWHITE:
			updatedColor = blackWhiteTransform(y,x);
		}
		return updatedColor;
	}
	
	public Color rainbowTransform(int y, int x) {
		if (blue > 150 || green > 150 || red > 150) {
			return Color.WHITE;
		} else return rainbow[7 * x / (source.original.getWidth())];
	}
	
	public Color blackWhiteTransform(int y, int x) {
		if (blue > 175 || green > 175 || red > 175) {
			return Color.WHITE;
		} else return Color.BLACK;
	}
	
	
}
