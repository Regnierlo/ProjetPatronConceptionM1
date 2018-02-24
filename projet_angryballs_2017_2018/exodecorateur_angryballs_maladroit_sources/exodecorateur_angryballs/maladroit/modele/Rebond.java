package exodecorateur_angryballs.maladroit.modele;

import mesmaths.cinematique.Collisions;

public class Rebond extends Decorator{

	public Rebond(Billable bille) {
		super(bille);
		// TODO Auto-generated constructor stub
	}
	public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur) {
		Collisions.collisionBilleContourAvecRebond(this.getPosition(), this.getRayon(), this.getVitesse(),
				abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);
	}

}
