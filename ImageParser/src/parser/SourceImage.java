package parser;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SourceImage {
	
	BufferedImage original;
	int colorSample;
	int blue, green, red;
	int[][] originalMap;
	int[][] currentMap;
	
	SourceImage() {
		original = SourceImage.loadImage("bw_leopard.jpg");
		originalMap = mapImageColor();
		currentMap = mapImageColor();
	}
	
	private int[][] mapImageColor() {
		int map[][] = new int[original.getHeight()][original.getWidth()];
		for(int height = 0; height < original.getHeight(); height++) {
			for(int width = 0; width < original.getWidth(); width++) {
				map[height][width] = original.getRGB(width, height);
			}
		}
		return map;
	}

	static BufferedImage loadImage(String fileName) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("resources/" + fileName));
		} catch (IOException exc) {
			System.out.println("Can't load image.");
		}
		return img;
	}
}
