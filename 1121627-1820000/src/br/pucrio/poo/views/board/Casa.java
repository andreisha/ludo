package br.pucrio.poo.views.board;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class Casa {
	protected int x_min;
	protected int x_max;
	protected int y_min;
	protected int y_max;
	private Color color;
	private boolean tem_reta;  // true=sim e false=nao
	protected int width;
	protected int heigth;
	private boolean casa_final; //true se casas finais, false nao)
	protected int num_casa;

	private List<Token> tokens;
	
	public Casa(int x_min,int x_max, int y_min, int y_max, Color color, int width, int heigth, int num_casa) {
		this.x_min = x_min;
		this.x_max = x_max;
		this.y_min = y_min;
		this.y_max = y_max;
		this.color = color;
		this.width = width;
		this.heigth = heigth;
		this.num_casa = num_casa;
		this.tokens = new ArrayList<Token>();
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
	
	public void addToken(Token token) {
		this.tokens.add(token);
	}
	
	public void removeToken(Token token) {
		this.tokens.remove(token);
	}
	
	public boolean anyToken() {
		return !this.tokens.isEmpty();
	}
	
	public List<Token> getTokens() {
		return this.tokens;
	}
	
	public void paintCasa(Graphics2D graphics) {
		
		// codigo de desenho das casas do jogo
		Rectangle2D casainicial = new Rectangle2D.Double(this.getXMIN(), this.getYMIN(), this.width, this.heigth);		
		graphics.setPaint(Color.BLACK);
		graphics.setStroke(new BasicStroke(2));
		graphics.draw(casainicial);
		graphics.setPaint(this.getColor());
		graphics.fill(casainicial);	
		
		// tempor�rio
		paintSpotNum(graphics);
	}

	private void paintSpotNum(Graphics2D graphics) {
		Font font = graphics.getFont().deriveFont(16f);
		graphics.setFont(font);
        String text = String.valueOf(num_casa);
        FontRenderContext frc = graphics.getFontRenderContext();
        int textWidth = (int)font.getStringBounds(text, frc).getWidth();
        LineMetrics lm = font.getLineMetrics(text, frc);
        int textHeight = (int)(lm.getAscent() + lm.getDescent());
        int sx = this.getXMIN() + (this.width - textWidth)/2;
        int sy = (int)(this.getYMIN() + (this.heigth + textHeight)/2 - lm.getDescent());
        
        if(this.getColor() == Color.blue)
        	graphics.setColor(Color.white);
        else
        	graphics.setColor(Color.blue);
        graphics.drawString(text, sx, sy);
	}
}
