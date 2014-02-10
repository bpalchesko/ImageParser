package parser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import parser.Parser.ColorEffect;
import parser.Parser.Pattern;

public class ParserGUI extends JFrame{
	
	View view;
	JPanel topMenuBar;
	JPanel bottomMenuBar;
	JButton originalColor;
	JButton rainbowColor;
	JButton blackWhiteColor;
	JButton originalPattern;
	JButton dotPattern;
	JButton linePattern;
	
	public static void main(String[] args) {
		try {
			UIManager
					.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		new ParserGUI().runParser();	
	}
	
	void runParser() {
		view = new View();
		setSize(view.getWidth(), view.getHeight()+50);
		setTitle("Image Parser");
		add(view, BorderLayout.CENTER);
		createTopMenuBar();
		createBottomMenuBar();
		setVisible(true);
	}
	
	void createTopMenuBar() {
		topMenuBar = new JPanel();
		topMenuBar.setLayout(new BorderLayout());
		topMenuBar.setBackground(Color.WHITE);
		topMenuBar.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		topMenuBar.setPreferredSize(new Dimension(view.getWidth(), 25));
		add(topMenuBar, BorderLayout.NORTH);
		addOriginalColorButton();
		addRainbowColorButton();
		addBlackWhiteColorButton();		
	}
	
	void createBottomMenuBar() {
		bottomMenuBar = new JPanel();
		bottomMenuBar.setLayout(new BorderLayout());
		bottomMenuBar.setBackground(Color.WHITE);
		bottomMenuBar.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		bottomMenuBar.setPreferredSize(new Dimension(view.getWidth(), 25));
		add(bottomMenuBar, BorderLayout.SOUTH);
		addOriginalPatternButton();
		addDotPatternButton();
		addLinePatternButton();
	}
	
	void addOriginalColorButton() {
		originalColor = new JButton("Original");
		originalColor.setPreferredSize(new Dimension(view.getWidth()/3, 25));
		originalColor.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				view.parser.setColorEffect(ColorEffect.ORIGINAL);
				view.parser.makeCurrentColorMap();
				repaint();
			}

			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
		});
		topMenuBar.add(originalColor, BorderLayout.WEST);
	}
	
	void addRainbowColorButton() {
		rainbowColor = new JButton("Rainbow");
		rainbowColor.setPreferredSize(new Dimension(view.getWidth()/3, 25));
		rainbowColor.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				view.parser.setColorEffect(ColorEffect.RAINBOW);
				view.parser.makeCurrentColorMap();
				repaint();
			}

			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
		});
		topMenuBar.add(rainbowColor, BorderLayout.CENTER);
	}
	
	void addBlackWhiteColorButton() {
		blackWhiteColor = new JButton("Black & White");
		blackWhiteColor.setPreferredSize(new Dimension(view.getWidth()/3, 25));
		blackWhiteColor.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				view.parser.setColorEffect(ColorEffect.BLACKWHITE);
				view.parser.makeCurrentColorMap();
				repaint();
			}

			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
		});
		topMenuBar.add(blackWhiteColor, BorderLayout.EAST);
	}
	
	void addOriginalPatternButton() {
		originalPattern = new JButton("Original");
		originalPattern.setPreferredSize(new Dimension(view.getWidth()/3, 25));
		originalPattern.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				view.parser.setPattern(Pattern.ORIGINAL);
				repaint();
			}

			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
		});
		bottomMenuBar.add(originalPattern, BorderLayout.WEST);
	}
	
	void addDotPatternButton() {
		dotPattern = new JButton("Dots");
		dotPattern.setPreferredSize(new Dimension(view.getWidth()/3, 25));
		dotPattern.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				view.parser.setPattern(Pattern.DOTS);
				repaint();
			}

			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
		});
		bottomMenuBar.add(dotPattern, BorderLayout.CENTER);
	}
	
	void addLinePatternButton() {
		linePattern = new JButton("Lines");
		linePattern.setPreferredSize(new Dimension(view.getWidth()/3, 25));
		linePattern.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				view.parser.setPattern(Pattern.LINES);
				repaint();
			}

			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
		});
		bottomMenuBar.add(linePattern, BorderLayout.EAST);
	}

}
