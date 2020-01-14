package com.project.ihm;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Machine extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel back;

	public Machine(){
		this.setBounds(100, 100, 273, 589);
		Image img = new ImageIcon(getClass().getResource("image_icon4.jpg")).getImage();
		this.setIconImage(img);
		this.setTitle("Interface washing machine");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		back = new JLabel("");
		back.setIcon(new ImageIcon(Machine.class.getResource("machine-ConvertImage.png")));
		back.setBounds(0, 0, 263, 555);
		this.getContentPane().add(back);
	}
}
