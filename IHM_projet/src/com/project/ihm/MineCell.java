package com.project.ihm;

import javax.swing.JButton;

/**
 *
 * @author SISES
 */
public class MineCell extends JButton{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int column,ligne,vois;
    public boolean isbomb,clickable=true,pressed=false;
    

    public MineCell(){
        super();
    }
    public MineCell( int ligne,int column,boolean isbomb,int vois) {
        super();
        this.column = column;
        this.ligne = ligne;
        this.isbomb = isbomb;
        this.vois = vois;
    }

    public boolean isClickable() {
        return clickable;
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getLigne() {
        return ligne;
    }

    public int getVois() {
        return vois;
    }

    public void setVois(int vois) {
        this.vois = vois;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public boolean isIsbomb() {
        return isbomb;
    }

    public void setIsbomb(boolean isbomb) {
        this.isbomb = isbomb;
    }

    boolean isPressed() {
        return pressed;
    }
    void setPressed(boolean pressed) {
        this.pressed=pressed;
    }
    
    
}
