package exodecorateur_angryballs.maladroit.modele;

import mesmaths.cinematique.Collisions;

public class PasseMuraille extends Decorator{

	public PasseMuraille(Billable bille) {
		super(bille);
		// TODO Auto-generated constructor stub
	}
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur,
			double hauteur) {
		Collisions.collisionBilleContourPasseMuraille(this.getPosition(), abscisseCoinHautGauche,
				ordonnéeCoinHautGauche, largeur, hauteur);

	}

}
