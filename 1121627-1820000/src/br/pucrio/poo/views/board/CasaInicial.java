package br.pucrio.poo.views.board;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class CasaInicial extends Casa {

	public CasaInicial(int x_min, int x_max, int y_min, int y_max, Color color, int width, int heigth, int num_casa) {
		super(x_min, x_max, y_min, y_max, color, width, heigth, num_casa);
//precisa definir construtor com so esses argumentos?
		
	}

	public void paintCasa(Graphics2D graphics) {
		Rectangle2D casainicial = new Rectangle2D.Double(this.getXMIN(), this.getYMIN(), this.width, this.heigth);
		graphics.setPaint(this.getColor());
		graphics.setStroke(new BasicStroke(2));
		graphics.draw(casainicial);
		graphics.setPaint(this.getColor());
		graphics.fill(casainicial);

		paintToken(graphics);
		
		// tempor�rio
		paintSpotNum(graphics);
	}

	public void paintToken(Graphics2D graphics) {

		Ellipse2D token = new Ellipse2D.Double(x_min, y_min, x_max - x_min, x_max - x_min);
		graphics.setPaint(Color.BLACK);
		graphics.draw(token);
		graphics.setPaint(Color.WHITE);
		graphics.fill(token);
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
        
        
        graphics.setColor(Color.blue);
        graphics.drawString(text, sx, sy);
	}

}
