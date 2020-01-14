package com.project.ihm;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class Welcome extends JFrame  implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbl_principale,lblClickTheCat;
	public JButton btn_help,btn_start,btn_exit ;
	public JFrame home;

	public Welcome(JFrame home) {
		
		this.home = home;
		
		this.setBounds(100, 100, 539, 383);
		Image img = new ImageIcon(getClass().getResource("image_icon.jpg")).getImage();
		this.setIconImage(img);
		this.setTitle("Welcome to Skill Mitter");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
	
		lbl_principale = new JLabel(new ImageIcon(getClass().getResource("giphy.gif")));
		lbl_principale.setBounds(0, 0, 523, 344);
		
		btn_help = new JButton("Help");
		btn_help.setBounds(10, 55, 89, 40);
		btn_help.setToolTipText("If You Need any Help ");
		this.getContentPane().add(btn_help);
		
		btn_start = new JButton("Start");
		btn_start.setBounds(225, 55, 94, 40);
		btn_start.setToolTipText("Let the game begain");
		this.getContentPane().add(btn_start);
		
		btn_exit = new JButton("Main Home");
		btn_exit.setBounds(424, 55, 89, 40);
		btn_exit.setToolTipText("Back To Our Games");
		this.getContentPane().add(btn_exit);
		
		lblClickTheCat = new JLabel("Find The Cat");
		lblClickTheCat.setForeground(new Color(220, 20, 60));
		lblClickTheCat.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 23));
		lblClickTheCat.setHorizontalAlignment(SwingConstants.CENTER);
		lblClickTheCat.setBounds(168, 11, 194, 40);
		this.getContentPane().add(lblClickTheCat);
		
		this.getContentPane().add(lbl_principale);
		
		this.btn_start.addActionListener(this);
		this.btn_help.addActionListener(this);	
		this.btn_exit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== btn_exit) {
			Object[] options = {"Yes","No"};
			int i=JOptionPane.showOptionDialog(this, "Do you really want to leave Us!","Leave Skill Mitter", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null,options,options[0]);
			if(i==0){
			this.setVisible(false);
			this.home.setVisible(true);
			}
		}
		if(e.getSource()== btn_help) {
			JOptionPane.showMessageDialog(this, "click on the Cat when it appears");
		}
		
		if(e.getSource()== btn_start) {
			Partie sm;
			try {
				sm = new Partie(this);
				sm.setVisible(true);
				this.setVisible(false);
			} catch (IOException ee) {
				// TODO Auto-generated catch block
				ee.printStackTrace();
			}
		}
		
	}
}
