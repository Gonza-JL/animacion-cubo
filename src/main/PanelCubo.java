package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import javax.swing.Timer;
import cubo.Cubo;

@SuppressWarnings("serial")
public class PanelCubo extends JPanel {
	
	private Cubo cubo;
	
	public PanelCubo() {
		setBackground(Color.WHITE);
		
		cubo = new Cubo(100);
		
		new Timer(15, (e) -> { girarCubo(); }).start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Mejora el dibujo
		g2d.translate(getWidth() / 2, getHeight() / 2); // Traslada el origen al medio de la pantalla
		
		cubo.dibujar(g2d);
	}
	
	public void girarCubo() {	
		cubo.girar();
		repaint();
	}
}
