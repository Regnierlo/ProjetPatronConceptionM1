package exodecorateur_angryballs.maladroit.vues;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Vector;
import exodecorateur_angryballs.maladroit.modele.Billeable;
import outilsvues.EcouteurMouse;
import outilsvues.EcouteurMouseMotion;

/**
 * responsable du dessin des billes
 * 
 */
public class Billard extends Canvas{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Vector<Billeable> billes;

	public Billard(Vector<Billeable> billes2) {
		this.billes = billes2;
		this.addMouseListener(new EcouteurMouse(billes));
		this.addMouseMotionListener(new EcouteurMouseMotion(billes));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.Canvas#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics graphics) {
		int i;

		for (i = 0; i < this.billes.size(); ++i)
			this.billes.get(i).dessine(graphics);
	}

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