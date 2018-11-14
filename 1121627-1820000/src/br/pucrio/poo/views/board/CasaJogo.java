package br.pucrio.poo.views.board;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class CasaJogo {
	private int x_min;
	private int x_max;
	private int y_min;
	private int y_max;
	private Color color;
	private boolean tem_reta;  // true=sim e false=nao
	//private int width;
	//private int heigth;
	private boolean casa_final; //true se casas finais, false nao)
	private int num_casa;
	private Color color1;
	private Color color2;
	
	public CasaJogo(int x_min,int x_max, int y_min, int y_max, Color color, boolean tem_reta, boolean casa_final, int num_casa, Color color1, Color color2) {
		this.x_min = x_min;
		this.x_max = x_max;
		this.y_min = y_min;
		this.y_max = y_max;
		this.color = color;
		this.tem_reta = tem_reta;
		//this.width = width;
		//this.heigth = heigth;
		this.casa_final = casa_final;
		this.num_casa = num_casa;
		this.color1 = color1;
		this.color2 = color2;
	}
	
	public int getXMIN() {
		return x_min;
	}
	
	public int getXMAX() {
		return x_max;
	}

	public int getYMIN() {
		return y_min;
	}

	public int getYMAX() {
		return y_max;
	}

	public Color getColor() {
		return color;
	}
	
/*	public int getWidth() {
		return width;
	}

	public int getHeigth() {
		return heigth;
	}*/
	
	public int getNum() {
		return num_casa;
	}
	
	public boolean getTemReta() {
		return tem_reta;
	}
	
	public boolean getCasaFinal() {
		return casa_final;
	}
	
	public Color getColor1() {
		return color1;
	}
	public Color getColor2() {
		return color2;
	}
	
	
	public void modifyColor1(Color color) {
		this.color1 = color;
	}

	public void modifyColor2(Color color) {
		this.color2 = color;
	}
	
	public void paintCasaJogo(Graphics2D graphics) {
		
		// codigo de desenho das casas do jogo
		Rectangle2D casainicial = new Rectangle2D.Double(this.getXMIN(), this.getYMIN(), 500/15, 500/15);
		graphics.setPaint(Color.BLACK);
		graphics.draw(casainicial);
		graphics.setPaint(this.getColor());
		graphics.fill(casainicial);
	}
}
