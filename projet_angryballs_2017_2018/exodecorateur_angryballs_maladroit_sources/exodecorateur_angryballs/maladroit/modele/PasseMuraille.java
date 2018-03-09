package exodecorateur_angryballs.maladroit.modele;

import mesmaths.cinematique.Collisions;

public class PasseMuraille extends Decorator{

	public PasseMuraille(Billeable bille) {
		super(bille);
	}
	
	/*
	 * (non-Javadoc)
	 * @see exodecorateur_angryballs.maladroit.modele.Decorator#collisionContour(double, double, double, double)
	 */
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur,double hauteur) {
		Collisions.collisionBilleContourPasseMuraille(this.getPosition(), abscisseCoinHautGauche,ordonnéeCoinHautGauche, largeur, hauteur);
	}
}