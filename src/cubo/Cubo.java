package cubo;

import static java.lang.Math.PI;
import static java.lang.Math.atan;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import java.awt.Graphics2D;
import java.util.Set;

public class Cubo {
	
	private Punto3D[] puntos;
	private Set<Arista> aristas;
	
	public Cubo(int size) {
		puntos = new Punto3D[8];
		puntos[0] = new Punto3D(-size, -size, -size); 
		puntos[1] = new Punto3D(-size, -size, size); 
		puntos[2] = new Punto3D(-size, size, -size);
		puntos[3] = new Punto3D(-size, size, size);
		puntos[4] = new Punto3D(size, -size, -size);
		puntos[5] = new Punto3D(size, -size, size);
		puntos[6] = new Punto3D(size, size, -size);
		puntos[7] = new Punto3D(size, size, size);
		
		aristas = Set.of(new Arista(0, 1), new Arista(0, 2), new Arista(0, 4), new Arista(1, 3), new Arista(1, 5),
				new Arista(2, 3), new Arista(2, 6), new Arista(3, 7), new Arista(4, 5), new Arista(4, 6),
				new Arista(5, 7), new Arista(6, 7));
		
		for (int i = 0; i < 4; i++) {
			girar(PI/4, atan(sqrt(2)));
		}
	}
	
	public void dibujar(Graphics2D g2d) {
		for (Arista a: aristas) {
			g2d.drawLine((int) puntos[a.getV1()].getX(), (int) puntos[a.getV1()].getY(), (int) puntos[a.getV2()].getX(), (int) puntos[a.getV2()].getY());
		}
	}
	
	public void girar() {
		girar(PI/180, 0);
	}
	
	private void girar(double anguloX, double anguloY) {
        final double sinX = sin(anguloX);
        final double cosX = cos(anguloX);
        
        final double sinY = sin(anguloY);
        final double cosY = cos(anguloY);

        for (Punto3D p: puntos) {
        	double x = p.getX();
            p.setX(x * cosX - p.getZ() * sinX);
            p.setZ(p.getZ() * cosX + x * sinX);
            
            double y = p.getY();
            p.setY(y * cosY - p.getZ() * sinY);
            p.setZ(p.getZ() * cosY + y * sinY);
        }
	}
}
