package angryballs.vues;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Vector;

import angryballs.modele.Billeable;
import outilsvues.EcouteurMouse;
import outilsvues.EcouteurMouseMotion;

/**
 * responsable du dessin des billes
 * 
 */
public class Billard extends Canvas{

	private static final long serialVersionUID = 1L;
	Vector<Billeable> billes;

	/**
	 * 
	 * @param billes2
	 */
	public Billard(Vector<Billeable> billes2) {
		this.billes = billes2;
		this.addMouseListener(new EcouteurMouse(billes));
		this.addMouseMotionListener(new EcouteurMouseMotion(billes));
	}

	@Override
	public void paint(Graphics graphics) {
		int i;

		for (i = 0; i < this.billes.size(); ++i)
			this.billes.get(i).dessine(graphics);
	}
	
	/**
	 * Methode permettant l'affichage de maniere fluide grace a la creation d'un double buffer
	 * celui-ci va etre retourne afin d'avoir l'affichage des frames sur un canvas
	 * on va ensuite recreer un background avec les dimensions afin d'afficher les resultats
	 * puis on va tout simplement dessiner les billes et montrer ce que le buffer recoit en frame
	 */
	public void redessine() {
		int i;
		BufferStrategy myStrategy = getBufferStrategy();        
        
		if (myStrategy == null) {
			createBufferStrategy(2);
			return;
		}
		Graphics g = null;
		g = myStrategy.getDrawGraphics();
		g.setColor( getBackground() );
        g.fillRect( 0, 0, this.getWidth(), this.getHeight() );
		for (i = 0; i < this.billes.size(); ++i)
		{
			this.billes.get(i).dessine(g);
		}
		g.dispose();
		myStrategy.show();
	}
}