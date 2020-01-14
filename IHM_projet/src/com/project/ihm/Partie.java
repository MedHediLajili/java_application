package com.project.ihm;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Partie extends JFrame  implements ActionListener,MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton btn_quit,btn_alea,btn_pause;
	JPanel p_south,p_north,p_total;
	int i=0;
	JFrame home;
	BufferedImage gason,baby,cancel,pause, back ;
	ImageIcon x;
	Image bg,bebe,can,pau, back_image ;
	JLabel background,character;
	public JButton cancel_button,replay_button , back_button;
	ImageIcon image_gason,image_bebe,image_cancel,image_pause, image_back;
	Font fnt;
	long start,end;
	ArrayList<Long> calcul;
	/**
	 * @throws IOException 
	 * 
	 */
	
	
	public Partie(JFrame home) throws IOException {
		Image img = new ImageIcon(getClass().getResource("image_icon.jpg")).getImage();
		this.setIconImage(img);

		this.setBounds(100, 100, 680, 451);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Game");
		getContentPane().setLayout(null);
		
		this.home= home;
		
		background = new JLabel(new ImageIcon(getClass().getResource("arriere1.png")));
		background.setBounds(0, 0, 664, 412);
	
		
		back_button = new JButton("");
		back_button.setToolTipText("when you click this button you will be back to home");
		back_button.setIcon(new ImageIcon(getClass().getResource("back.png")));
		back_button.setBounds(10, 11, 68, 42);
		getContentPane().add(back_button);
		
		cancel_button = new JButton("");
		cancel_button.setToolTipText("If you want to cancel the game click this button ");
		cancel_button.setIcon(new ImageIcon(getClass().getResource("cancel.png")));
		cancel_button.setBounds(580, 11, 68, 42);
		getContentPane().add(cancel_button);
		
		replay_button = new JButton("");
		replay_button.setToolTipText("If You want to replay click this button ");
		replay_button.setEnabled(false);
		replay_button.setIcon(new ImageIcon(getClass().getResource("replay.png")));
		replay_button.setBounds(273, 11, 68, 42);
		getContentPane().add(replay_button);
		
		character = new JLabel("");
		character.setBounds(79, 210, 113, 127);
		
		calcul = new ArrayList<>();
		start = System.currentTimeMillis();
		
		character.setIcon(new ImageIcon(getClass().getResource("cat.png")));
		getContentPane().add(character);
		
		getContentPane().add(background);
		
		character.addMouseListener(this);
		cancel_button.addMouseListener(this);
		replay_button.addMouseListener(this);
		back_button.addMouseListener(this);
		
	}
	@Override
	public void mouseClicked(MouseEvent a) {
		// TODO Auto-generated method stub
		if(a.getSource()== character) {
			this.replay_button.setEnabled(true);
			end = (System.currentTimeMillis())-start;
			calcul.add(end);
			start = System.currentTimeMillis();
			int j=(int)(Math.random()*250);
			int k=(int)(Math.random()*250);
			
			character.setLocation(j,k);
			if(i<8) {
			i++;
				}
			else 
			{
				long s=0;
				
				for (int xs =0;xs<calcul.size();xs++)
				{
					System.out.println(xs+" : "+calcul.get(xs));
					s+=calcul.get(xs);
				}
				float xz=(float) s;
				float r = (xz /1000)/9;
				System.out.println(r);

				JOptionPane.showMessageDialog(this, "Your reaction time is:"+ r + " seconds");
			}
		}
		if(a.getSource()== cancel_button) {
			Object[] options = {"Yes","No"};
			int i=JOptionPane.showOptionDialog(this, "Do you really want to leave!","Cancel", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null,options,options[0]);
			if(i==0)
			System.exit(0);
			}
		if(a.getSource()==back_button){
			this.setVisible(false);
			this.home.setVisible(true);
		}
		if(a.getSource()== replay_button) {
			Partie sm;
			try {
				sm = new Partie(this.home);
				sm.setVisible(true);
				this.setVisible(false);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}


