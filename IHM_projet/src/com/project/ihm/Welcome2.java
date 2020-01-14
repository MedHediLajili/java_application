package com.project.ihm;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Color;

public class Welcome2 extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbl_background, lbl_titre ;
	public JButton btn_help, btn_start, btn_exit ;
	public JFrame home;
	



	public  Welcome2(JFrame home) {
		this.home = home ;
		this.setBounds(100, 100, 630, 450);
		Image img = new ImageIcon(getClass().getResource("image_icon.png")).getImage();
		this.setIconImage(img);
		this.setTitle("Welcome to Minesweeper");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		
		lbl_background = new JLabel(new ImageIcon(getClass().getResource("trip_prin1.gif")));
		lbl_background.setForeground(new Color(0, 128, 0));
		/*Image rawImage = new ImageIcon(getClass().getClassLoader().getResource(filepath)).getImage();
        Image renderedImage = rawImage.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(renderedImage);*/
		lbl_background.setBounds(0, 0, 614, 411);
		
		btn_help = new JButton("Help");
		btn_help.setBounds(10, 350, 89, 45);
		btn_help.setToolTipText("If You Need any Help ");
		this.getContentPane().add(btn_help);
		
		btn_start = new JButton("Start");
		btn_start.setBounds(281, 350, 94, 45);
		btn_start.setToolTipText("Let the game begain");
		this.getContentPane().add(btn_start);
		
		btn_exit = new JButton("Main Home");
		btn_exit.setBounds(515, 350, 89, 45);
		btn_exit.setToolTipText("Back To Our Games");
		this.getContentPane().add(btn_exit);
		
		
		lbl_titre = new JLabel("Enjoy playing Minesweeper in nature");
		lbl_titre.setForeground(new Color(220, 20, 60));
		lbl_titre.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titre.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 19));
		lbl_titre.setBounds(150, 310, 310, 38);
		this.getContentPane().add(lbl_titre);
		
		this.getContentPane().add(lbl_background);
		this.btn_start.addActionListener(this);
		this.btn_help.addActionListener(this);	
		this.btn_exit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== btn_exit) {
			Object[] options = {"Yes","No"};
			int i=JOptionPane.showOptionDialog(this, "Do you really want to leave us !","Leave Minesweeper", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null,options,options[0]);
			if(i==0){
			this.setVisible(false);
			this.home.setVisible(true);
			}
		}
		if(e.getSource()== btn_help) {
			JOptionPane.showMessageDialog(this, "Try To Win Minesweeper");
		}
		
		if(e.getSource()== btn_start) {
			this.setVisible(false);
            new GameBoard(6,6,10,3,this).setVisible(true);
		}
		
	}

}
