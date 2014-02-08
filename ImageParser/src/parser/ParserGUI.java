package parser;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class ParserGUI extends JFrame{
	
	View view;

	public static void main(String[] args) {
		new ParserGUI().runParser();	
	}
	
	void runParser() {
		view = new View();
		setSize(view.getWidth(), view.getHeight());
		add(view, BorderLayout.CENTER);
		setVisible(true);
	}

}
