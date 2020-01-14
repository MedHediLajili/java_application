package com.project.ihm;

import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, IOException {
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		Principale p = new Principale();
		p.setVisible(true);

	}

}
