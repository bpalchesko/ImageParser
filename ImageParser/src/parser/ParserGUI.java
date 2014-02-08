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

public class ParserGUI extends JFrame{
	
	View view;
	JPanel menuBar;
	JButton originalColor;
	JButton rainbowColor;
	JButton blackWhiteColor;
	
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
		setSize(view.getWidth(), view.getHeight()+25);
		add(view, BorderLayout.CENTER);
		createMenuBar();
		setVisible(true);
	}
	
	void createMenuBar() {
		menuBar = new JPanel();
		menuBar.setLayout(new BorderLayout());
		menuBar.setBackground(Color.WHITE);
		menuBar.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		menuBar.setPreferredSize(new Dimension(view.getWidth(), 25));
		add(menuBar, BorderLayout.NORTH);
		addOriginalColorButton();
		addRainbowColorButton();
		addBlackWhiteColorButton();		
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
		menuBar.add(originalColor, BorderLayout.WEST);
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
		menuBar.add(rainbowColor, BorderLayout.CENTER);
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
		menuBar.add(blackWhiteColor, BorderLayout.EAST);
	}

}
