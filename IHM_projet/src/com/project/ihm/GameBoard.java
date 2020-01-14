package com.project.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author SISES
 */
public class GameBoard extends JFrame implements ActionListener,MouseListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel pgame,pmenu,ptimem1,ptimem2,ptimes1,ptimes2,ptimesep;
    public JButton bpause,bdiscover,bhome;
    MineCell bretry;
    JLabel timerm1,timers1,timerm2,timers2,timesep,heart1,heart2,heart3;
    long current,start;
    long pstart,pfinish;
    Timer timer,timerdiscover;
    Font ftimer;
    JFrame home;
    
    int bombOnBoard;
    MineCell[][] grid;
    int[][] board;
    int[][] vois;
    JLabel[] lbllives;
    Dimension matrixDimension;
    int bombCells,safeCells,lives,initialbombCells,initiallives;
    int discover=5000;
    
    boolean stopped=false;
    
    ActionListener countdown;
   
    public GameBoard(int nbLigne,int nbColumn,int nbBomb,int lives,JFrame home) {
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setMaximumSize(new java.awt.Dimension(600, 600));
        this.setMinimumSize(new java.awt.Dimension(600, 600));
        this.setPreferredSize(new java.awt.Dimension(600, 600));
        this.setBounds(300, 100, 600, 600);
        this.setResizable(false);
        this.setBackground(new Color(221, 238, 224));
        this.setForeground(new Color(211, 211, 211));
        Image img = new ImageIcon(getClass().getResource("image_icon.png")).getImage();
		this.setIconImage(img);
		this.setTitle("Enjoy Minesweeper");
        
        this.home = home;
        this.initialbombCells = nbBomb;
        this.initiallives = lives;
        this.lives = this.initiallives;
        this.bombCells = this.initialbombCells;
        safeCells = nbColumn*nbLigne-bombCells;
        matrixDimension = new Dimension(nbLigne, nbColumn);
        this.bombOnBoard = nbBomb;
        
        this.lbllives = new JLabel[initiallives];
        
        for(int i=0;i<initiallives;i++){
            lbllives[i] = new JLabel(new javax.swing.ImageIcon(getClass().getResource("heart-balloon.png")));
        }
        
        this.grid = new MineCell[matrixDimension.height][this.matrixDimension.width];
        this.board = new int[this.matrixDimension.height][this.matrixDimension.width];
        this.vois = new int[this.matrixDimension.height][this.matrixDimension.width];
        for (int i=0;i<matrixDimension.height;i++){
            for (int j=0;j<this.matrixDimension.width;j++){
                this.board[i][j]=0;
            }
        }
        ftimer = new Font("Bebas Neue Regular", Font.BOLD, 20);
        
        timer = new Timer(1000, this);
        timer.setInitialDelay(1);
        timer.start(); 
        start = System.currentTimeMillis();
        current = System.currentTimeMillis();
        
        timerm1 = new JLabel("0");
        timerm1.setFont(ftimer);
        timerm1.setForeground(new Color(31,132,206));
        timerm2 = new JLabel("0");
        timerm2.setFont(ftimer);
        timerm2.setForeground(new Color(31,132,206));
        timers1 = new JLabel("0");
        timers1.setFont(ftimer);
        timers1.setForeground(new Color(31,132,206));
        timers2 =new JLabel("0");
        timers2.setFont(ftimer);
        timers2.setForeground(new Color(31,132,206));
        timesep = new JLabel(":");
        timesep.setForeground(new Color(31,132,206));
        heart1 = new JLabel(new javax.swing.ImageIcon(getClass().getResource("heart-balloon.png")));
        heart2 = new JLabel(new javax.swing.ImageIcon(getClass().getResource("heart-balloon.png")));
        heart3 = new JLabel(new javax.swing.ImageIcon(getClass().getResource("heart-balloon.png")));
        
        ptimem1 = new JPanel();
        ptimem1.add(timerm1);
        ptimem1.setBackground(new Color(221, 238, 224));
        
        ptimem2 = new JPanel();
        ptimem2.add(timerm2);
        ptimem2.setBackground(new Color(221, 238, 224));
        
        ptimes1 = new JPanel();
        ptimes1.add(timers1);
        ptimes1.setBackground(new Color(221, 238, 224));
        
        ptimes2 = new JPanel();
        ptimes2.add(timers2);
        ptimes2.setBackground(new Color(221, 238, 224));
        
        ptimesep = new JPanel();
        ptimesep.add(timesep);
        ptimesep.setBackground(new Color(221, 238, 224));
        
        bhome = new JButton(new ImageIcon(getClass().getResource("house.png")));
        bhome.setToolTipText("back to the welcome frame ");
        
        bhome.setOpaque(false);
        bhome.setContentAreaFilled(false);
        bhome.setBorderPainted(false);
        
        bretry = new MineCell();
        bretry.setIcon(new javax.swing.ImageIcon(getClass().getResource("reload.png")));
        bretry.setToolTipText("To retry the game ");
        bretry.setClickable(false);
        bretry.setEnabled(false);
        bretry.setOpaque(false);
        bretry.setContentAreaFilled(false);
        bretry.setBorderPainted(false);
        bpause = new JButton(new javax.swing.ImageIcon(getClass().getResource("pause2.png")));
        bpause.setToolTipText("If You want to pause the game");
        bpause.setOpaque(false);
        bpause.setContentAreaFilled(false);
        bpause.setBorderPainted(false);
        bdiscover = new JButton(new javax.swing.ImageIcon(getClass().getResource("loupe.png")));
        bdiscover.setToolTipText("to show the places of Minesweepers present in carte ");
        bdiscover.setOpaque(false);
        bdiscover.setContentAreaFilled(false);
        bdiscover.setBorderPainted(false);
        bdiscover.setSelected(false);
        pmenu = new JPanel();
        pmenu.setBackground(new Color(221, 238, 224));
        
        pmenu.add(bretry);
        pmenu.add(bdiscover);
        pmenu.add(ptimem1);
        pmenu.add(ptimem2);
        pmenu.add(ptimem1);
        pmenu.add(ptimesep);
        pmenu.add(ptimes1);
        pmenu.add(ptimes2);
        pmenu.add(bpause);
        
        for(int i=0;i<this.lives;i++){
            pmenu.add(lbllives[i]);
        }
        
        pmenu.add(bhome);
        
        this.add(pmenu,BorderLayout.NORTH);
        
        
        this.showgrid(board,this.matrixDimension);
        System.out.println("");
        this.randomaize(this.board,this.bombOnBoard,this.matrixDimension);
        System.out.println("");
        this.showgrid(this.board,this.matrixDimension);
        System.out.println("");
        
        
        this.vois = this.voisignage(this.board,matrixDimension);
        System.out.println("");
        this.showgrid(this.vois,this.matrixDimension);
        
        pgame = new JPanel();
        pgame.setLayout(new GridLayout(matrixDimension.height,matrixDimension.width));
        pgame.setBackground(new Color(221, 238, 224));
        this.intializeGrid(board, vois, pgame, matrixDimension);
        
        this.add(pgame,BorderLayout.CENTER);

        
        countdown=new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                discover -= 100;
                if(discover<=0)
                {   discover = 5000;
                    timerdiscover.stop();
                    for(int k=0;k<matrixDimension.height;k++){
                        for(int l=0;l<matrixDimension.width;l++){
                    
                            if(grid[k][l].isIsbomb()){
                                grid[k][l].setIcon(null);
                            }
                            
                            grid[k][l].setEnabled(true);
                        }
                    }
                    
                }
            }
        };
        timerdiscover=new Timer(100, countdown);
        bdiscover.addActionListener(this);
        bpause.addActionListener(this);
        bretry.addActionListener(this);
        bhome.addActionListener(this);
    }
    public void showgrid(int[][] grid,Dimension d){
        for (int i=0;i<d.height;i++){
            for (int j=0;j<d.width;j++){
                
                System.out.print(grid[i][j]);
            }
            System.out.println(); 
        }
    }
    public int[][] randomaize(int[][] grid,int nbBomb,Dimension d){
        for (int i=0;i<nbBomb;i++){
            
            Random rln = new Random();
            int resln= rln.nextInt(d.height-1);
            Random rcl = new Random();
            int rescl= rcl.nextInt(d.width-1);
            if(grid[resln][rescl]!=1){
                System.out.println(rescl+" "+resln);
                grid[resln][rescl]=1;
            }else{
                i--;
            }
        }
        return grid;
        
        
    }
    public int[][] voisignage(int[][] board,Dimension d){
        int iMax = d.height;
        int jMax = d.width;
        int[][] vois = new int[iMax][jMax];
        
        for (int i=0;i<iMax;i++){
            for (int j=0;j<jMax;j++){
                if(i>0&&i<(iMax-1)&&j>0&&j<(jMax-1)){
                    vois[i][j]=board[i-1][j-1]+board[i-1][j]+board[i-1][j+1]+board[i][j+1]+
                    board[i+1][j+1]+board[i+1][j]+board[i+1][j-1]+board[i][j-1];
                }else if(i==0&&j>0&&j<(jMax-1)){
                    vois[i][j]=board[i][j+1]+
                    board[i+1][j+1]+board[i+1][j]+board[i+1][j-1]+board[i][j-1];
                }else if(i==(iMax-1)&&j>0&&j<(jMax-1)){
                    vois[i][j]=board[i-1][j-1]+board[i-1][j]+board[i-1][j+1]+board[i][j+1]+board[i][j-1];
                }else if(i>0&&i<(iMax-1)&&j==0){
                    vois[i][j]=board[i-1][j]+board[i-1][j+1]+board[i][j+1]+board[i+1][j+1]+board[i+1][j];
                }else if(i>0&&i<(iMax-1)&&j==(jMax-1)){
                    vois[i][j]=board[i-1][j-1]+board[i-1][j]+board[i+1][j]+board[i+1][j-1]+board[i][j-1];
                }else if(i==0&&j==0){
                    vois[i][j]=board[0][1]+board[1][1]+board[1][0];
                }else if(i==0&&j==(jMax-1)){
                    vois[i][j]=board[0][(jMax-2)]+board[1][(jMax-2)]+board[1][(jMax-1)];
                }else if(i==(iMax-1)&&j==0){
                    vois[i][j]=board[(iMax-2)][0]+board[(iMax-2)][1]+board[(iMax-1)][1];
                }else if(i==(iMax-1)&&j==(jMax-1)){
                    vois[i][j]=board[(iMax-1)][(jMax-2)]+board[(iMax-2)][(jMax-2)]+board[(iMax-2)][(jMax-1)];
                }
            }
             
        }
        return vois;
    }
    public void intializeGrid(int[][] board,int[][] vois,JPanel pgame,Dimension d){
        int iMax = d.height,jMax = d.width;
        for (int i=0;i<iMax;i++){
            for(int j=0;j<jMax;j++){
                this.grid[i][j] = new MineCell(i,j,false,vois[i][j]);
                if(board[i][j] == 1){
                    this.grid[i][j].setIsbomb(true);
                }
                this.grid[i][j].setPreferredSize(new Dimension(40, 40));
                this.grid[i][j].setMinimumSize(new Dimension(40, 40));
                this.grid[i][j].setMaximumSize(new Dimension(40, 40));
                this.grid[i][j].setBackground(new Color(255, 255, 255));
                this.grid[i][j].addActionListener(this);
                this.grid[i][j].addMouseListener(this);
                pgame.add(this.grid[i][j]);
            }
        }
    }
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
    	UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        new GameBoard(6,6,6,3,null).setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource() == bdiscover){
           System.out.println("here");
            for(int k=0;k<this.matrixDimension.height;k++){
                for(int l=0;l<this.matrixDimension.width;l++){
                    
                    if(this.grid[k][l].isIsbomb()){
                        System.out.println("discovering");
                        this.grid[k][l].setIcon(new javax.swing.ImageIcon(getClass().getResource("bomb.png")));
                    }
                    
                    this.grid[k][l].setEnabled(false);
                    timerdiscover.start();
                }
            }
        }
       
       if(ae.getSource() == bpause){
           
           if(stopped == false){
               timer.stop();
               pstart = System.currentTimeMillis();
               System.out.println(start);
               bdiscover.setEnabled(false);
           }else{
               pfinish = System.currentTimeMillis();
               long pduration =pfinish-pstart;
               start = start+pduration;
               System.out.println(pduration);
               System.out.println(start);
               timer.restart();
               bdiscover.setEnabled(true);
           }
           stopped=!stopped;
       } 
       if(ae.getSource() == bretry){
           new GameBoard(matrixDimension.height,matrixDimension.width,this.initialbombCells,this.initiallives,this.home).setVisible(true);
           this.setVisible(false);
       }
       if(ae.getSource() == bhome){
           this.setVisible(false);
           this.home.setVisible(true);
       }
       
       current = System.currentTimeMillis();
       long diff = (current-start)/1000;
       long diffm = (diff)/60;
       long diffs = (diff)%60;
       long diffm1 = diffm/10;
        long diffm2 = diffm%10;
        long diffs1 = diffs/10;
        long diffs2 = diffs%10;
        timerm1.setText(Long.toString(diffm2));
        timerm2.setText(Long.toString(diffm1));
        timers1.setText(Long.toString(diffs1));
        timers2.setText(Long.toString(diffs2));
       
       for(int i=0;i<this.matrixDimension.height;i++){
           for(int j=0;j<this.matrixDimension.width;j++){
               if(ae.getSource() == this.grid[i][j] && this.grid[i][j].isClickable()){
                   if(!bretry.isClickable()){
                       bretry.setEnabled(true);
                       bretry.setClickable(true);
                   }
                   this.grid[i][j].setPressed(true);
                   if(this.grid[i][j].isbomb){
                       this.grid[i][j].setBackground(new Color(237,41,57));
                       this.grid[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("bomb.png")));
                       lbllives[3-lives].setEnabled(false);
                       lives--;
                       
                   }else if(this.grid[i][j].vois == 0){
                       this.grid[i][j].setForeground(new Color(235,235,237));
                       this.grid[i][j].setBackground(new Color(152,251,152));
                       String txt = Integer.toString(this.grid[i][j].vois);
                       this.grid[i][j].setText(txt);
                       this.grid[i][j].setFont(new Font("TimesRoman", Font.BOLD | Font.ITALIC, 40));
                       safeCells--;
                   }else if(this.grid[i][j].vois == 1){
                       this.grid[i][j].setForeground(new Color(123,218,246));
                       this.grid[i][j].setBackground(new Color(35,199,238));
                       String txt = Integer.toString(this.grid[i][j].vois);
                       this.grid[i][j].setText(txt);
                       this.grid[i][j].setFont(new Font("TimesRoman", Font.BOLD | Font.ITALIC, 40));
                       safeCells--;
                   }else if(this.grid[i][j].vois == 2){
                	   this.grid[i][j].setForeground(new Color(255,245,100));
                	   this.grid[i][j].setBackground(new Color(255,221,67));
                       String txt = Integer.toString(this.grid[i][j].vois);
                       this.grid[i][j].setText(txt);
                       this.grid[i][j].setFont(new Font("TimesRoman", Font.BOLD | Font.ITALIC, 40));
                       safeCells--;
                   }else if(this.grid[i][j].vois == 3){
                	   this.grid[i][j].setForeground(new Color(255,120,188));
                	   this.grid[i][j].setBackground(new Color(251,68,153));
                       String txt = Integer.toString(this.grid[i][j].vois);
                       this.grid[i][j].setText(txt);
                       this.grid[i][j].setFont(new Font("TimesRoman", Font.BOLD | Font.ITALIC, 40));
                       safeCells--;
                   }else{
                	   this.grid[i][j].setForeground(new Color(204,221,245));
                	   this.grid[i][j].setBackground(new Color(67,85,120));
                       String txt = Integer.toString(this.grid[i][j].vois);
                       this.grid[i][j].setText(txt);
                       this.grid[i][j].setFont(new Font("TimesRoman", Font.BOLD | Font.ITALIC, 40));
                       safeCells--;
                   }
                   //this.grid[i][j].setBackground(Color.BLACK);
                   this.grid[i][j].setClickable(false);
                   if(safeCells ==0){
                       timer.stop();
                       JOptionPane.showMessageDialog(this, "you won");
                       for(int k=0;k<this.matrixDimension.height;k++){
                            for(int l=0;l<this.matrixDimension.width;l++){
                                this.grid[k][l].setEnabled(false);
                            }
                       }
                   }
                   if(lives == 0){
                       timer.stop();
                       JOptionPane.showMessageDialog(this, "you died");
                       for(int k=0;k<this.matrixDimension.height;k++){
                            for(int l=0;l<this.matrixDimension.width;l++){
                                this.grid[k][l].setEnabled(false);
                            }
                       }
                   }
               }
           }
       }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    for(int i=0;i<this.matrixDimension.height;i++){
           for(int j=0;j<this.matrixDimension.width;j++){
               if(e.getSource() == this.grid[i][j] && e.getButton()==MouseEvent.BUTTON3 && !this.grid[i][j].isPressed()){
                   if(this.grid[i][j].getIcon() == null){
                        this.grid[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("flag.png")));
                        this.grid[i][j].addActionListener(null);
                        this.grid[i][j].setClickable(false);
                   }else{
                        this.grid[i][j].setIcon(null);
                        this.grid[i][j].setClickable(true);
                   }
               }
           }
       }    
    }

    @Override
    public void mousePressed(MouseEvent e) {
    
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    
    }

    @Override
    public void mouseExited(MouseEvent e) {
    
    }
}
