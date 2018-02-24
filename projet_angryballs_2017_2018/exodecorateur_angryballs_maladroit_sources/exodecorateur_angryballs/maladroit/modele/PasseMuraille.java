package exodecorateur_angryballs.maladroit.modele;

import mesmaths.cinematique.Collisions;

public class PasseMuraille extends Decorator{

	public PasseMuraille(Billeable bille) {
		super(bille);
	}
	
	public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur,
			double hauteur) {
		Collisions.collisionBilleContourPasseMuraille(this.getPosition(), abscisseCoinHautGauche,
				ordonn�eCoinHautGauche, largeur, hauteur);

	}

}
