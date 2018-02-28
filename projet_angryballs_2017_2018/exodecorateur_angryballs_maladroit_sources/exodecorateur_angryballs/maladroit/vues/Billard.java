package exodecorateur_angryballs.maladroit.vues;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.Vector;
import exodecorateur_angryballs.maladroit.modele.Billeable;
import outilsvues.EcouteurMouse;
import outilsvues.EcouteurMouseMotion;

/**
 * responsable du dessin des billes
 * 
 * ICI : IL N'Y A RIEN A CHANGER
 * 
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
		// System.out.println("billes dans le billard = " + billes);
	}
}