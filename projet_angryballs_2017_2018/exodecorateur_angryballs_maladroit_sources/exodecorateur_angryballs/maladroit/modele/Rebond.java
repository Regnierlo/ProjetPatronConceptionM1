package exodecorateur_angryballs.maladroit.modele;

import mesmaths.cinematique.Collisions;

public class Rebond extends Decorator{

	public Rebond(Billeable bille) {
		super(bille);
	}
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) {
		Collisions.collisionBilleContourAvecRebond(this.getPosition(), this.getRayon(), this.getVitesse(),
				abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
	}

}
