package com.project.ihm;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.Font;

public class Principale extends JFrame implements ActionListener  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblprinciple,lbl_g1,lbl_g2,lbl_g3,lbl_g4;
	private JButton  btn_g1,btn_g2,btn_g3,btn_g4;
	private Image image_button_g1, image_button_g2 ,image_button_g3 , image_button_g4; 
	public  Welcome f1 ;
	public Partie f11;
	public Welcome2 f2;
	public GameBoard f22;
	public Machine f4;
	//public InputWH f3;

	public Principale() throws IOException {
		
		this.setTitle("welcome");
        Image img = new ImageIcon(getClass().getResource("frame-templates-with-cute-children_1308-35997.jpg")).getImage();
		this.setIconImage(img);
		this.setBounds(100, 100, 639, 618);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		this.f1 = new Welcome(this);
		this.f11 = new Partie(this.f1);
		
		this.f2= new Welcome2(this);
		this.f22 = new GameBoard(6,6,10,3,this.f2);
		
		this.f4 = new Machine();
		//this.f3 = new InputWH();
		lblprinciple = new JLabel("");
		lblprinciple.setIcon(new ImageIcon(getClass().getResource("frame-templates-with-cute-children_1308-35997.jpg")));
		lblprinciple.setBounds(0, 0, 626, 587);
		
		lbl_g1 = new JLabel("Skill Mitter");
		lbl_g1.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 13));
		lbl_g1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_g1.setBackground(Color.PINK);
		lbl_g1.setBounds(79, 208, 119, 29);
		this.getContentPane().add(lbl_g1);
		
		btn_g1 = new JButton("");
		image_button_g1 =  new ImageIcon(getClass().getResource("game1.png")).getImage();
		btn_g1.setIcon(new ImageIcon(image_button_g1.getScaledInstance(85, 85, Image.SCALE_SMOOTH)));
		btn_g1.setToolTipText("Skill Mitter");
		btn_g1.setBounds(79, 71, 119, 126);
		this.getContentPane().add(btn_g1);
		
		btn_g2 = new JButton("");
		image_button_g2 =  new ImageIcon(getClass().getResource("game2.png")).getImage();
		btn_g2.setIcon(new ImageIcon(image_button_g2.getScaledInstance(85, 85, Image.SCALE_SMOOTH)));
		btn_g2.setBounds(389, 71, 119, 126);
		this.getContentPane().add(btn_g2);
		
		lbl_g2 = new JLabel("Minesweeper");
		lbl_g2.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 13));
		lbl_g2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_g2.setBounds(385, 208, 119, 29);
		this.getContentPane().add(lbl_g2);
		
		btn_g3 = new JButton("");
		image_button_g3 =  new ImageIcon(getClass().getResource("game3.jpg")).getImage();
		btn_g3.setIcon(new ImageIcon(image_button_g3.getScaledInstance(85, 85, Image.SCALE_SMOOTH)));
		btn_g3.setBounds(79, 361, 119, 126);
		this.getContentPane().add(btn_g3);
		
		btn_g4 = new JButton("");
		image_button_g4 =  new ImageIcon(getClass().getResource("interface4.png")).getImage();
		btn_g4.setIcon(new ImageIcon(image_button_g4.getScaledInstance(85, 85, Image.SCALE_SMOOTH)));
		btn_g4.setBounds(389, 362, 119, 126);
		this.getContentPane().add(btn_g4);
		
		lbl_g3 = new JLabel("Paint");
		lbl_g3.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 13));
		lbl_g3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_g3.setBounds(79, 498, 119, 29);
		this.getContentPane().add(lbl_g3);
		
		lbl_g4 = new JLabel("washing machine ");
		lbl_g4.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 13));
		lbl_g4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_g4.setBackground(Color.BLACK);
		lbl_g4.setBounds(389, 499, 119, 29);
		this.getContentPane().add(lbl_g4);
		this.getContentPane().add(lblprinciple );
		
		this.btn_g1.addActionListener(this);
		this.btn_g2.addActionListener(this);
		this.btn_g3.addActionListener(this);
		this.btn_g4.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		if(a.getSource()==this.btn_g1){
			this.setVisible(false);
			this.f1.setVisible(true);
		}
		if(a.getSource()==this.btn_g2){
			this.setVisible(false);
			this.f2.setVisible(true);
		}
		if(a.getSource()== this.btn_g3){
			this.setVisible(false);
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					try {
						new InputWH(new Principale());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			
		}
		if(a.getSource()==this.btn_g4){
			this.setVisible(false);
			this.f4.setVisible(true);
		}
		
	}
}
