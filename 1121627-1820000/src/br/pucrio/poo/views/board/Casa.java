package br.pucrio.poo.views.board;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Casa {
	private int x_min;
	private int x_max;
	private int y_min;
	private int y_max;
	private Color color;
	private boolean tem_reta;  // true=sim e false=nao
	private int width;
	private int heigth;
	private boolean casa_final; //true se casas finais, false nao)
	private int num_casa;
	private Token token1;
	private Token token2;
	
	public Casa(int x_min,int x_max, int y_min, int y_max, Color color, boolean tem_reta, int width, int heigth, boolean casa_final, int num_casa, Token token1, Token token2) {
		this.x_min = x_min;
		this.x_max = x_max;
		this.y_min = y_min;
		this.y_max = y_max;
		this.color = color;
		this.tem_reta = tem_reta;
		this.width = width;
		this.heigth = heigth;
		this.casa_final = casa_final;
		this.num_casa = num_casa;
		this.token1 = token1;
		this.token2 = token2;
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
	
	public int getWidth() {
		return width;
	}

	public int getHeigth() {
		return heigth;
	}
	
	public int getNum() {
		return num_casa;
	}
	
	public boolean getTemReta() {
		return tem_reta;
	}
	
	public boolean getCasaFinal() {
		return casa_final;
	}
	
	public Token getToken1() {
		return token1;
	}
	
	public Token getToken2() {
		return token2;
	}
	
	public void modifyColorToken1(Color color) {
		this.token1.modifyColor(color);
	}

	public void modifyColorToken2(Color color) {
		this.token2.modifyColor(color);
	}
	
	public void paintCasa(Graphics2D graphics) {
		
		// codigo de desenho das casas do jogo
		Rectangle2D casainicial = new Rectangle2D.Double(this.getXMIN(), this.getYMIN(), this.width, this.heigth);
		graphics.setPaint(Color.BLACK);
		graphics.draw(casainicial);
		graphics.setPaint(this.getColor());
		graphics.fill(casainicial);
	}
}
