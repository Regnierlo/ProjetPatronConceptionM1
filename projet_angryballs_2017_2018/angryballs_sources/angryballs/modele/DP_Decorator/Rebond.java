package angryballs.modele.DP_Decorator;

import angryballs.modele.Billeable;
import mesmaths.cinematique.Collisions;

public class Rebond extends Decorator{

	public Rebond(Billeable bille) {
		super(bille);
	}
	
	public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur) {
		Collisions.collisionBilleContourAvecRebond(this.getPosition(), this.getRayon(), this.getVitesse(),
				abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);
	}
}