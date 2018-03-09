package exodecorateur_angryballs.maladroit.modele;

import mesmaths.cinematique.Collisions;

public class Arret extends Decorator{

	public Arret(Billeable bille) {
		super(bille);
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) 
	{
		super.collisionContour(abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
		Collisions.collisionBilleContourAvecArretHorizontal(bille.getPosition(), bille.getRayon(), bille.getVitesse(), abscisseCoinHautGauche, largeur);
		Collisions.collisionBilleContourAvecArretVertical(bille.getPosition(), bille.getRayon(), bille.getVitesse(), ordonnéeCoinHautGauche, hauteur);
	}
}