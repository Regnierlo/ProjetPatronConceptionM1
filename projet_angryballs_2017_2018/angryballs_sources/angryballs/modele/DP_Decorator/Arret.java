package angryballs.modele.DP_Decorator;

import angryballs.modele.Billeable;
import mesmaths.cinematique.Collisions;

public class Arret extends Decorator{

	/**
	 * 
	 * @param bille
	 */
	public Arret(Billeable bille) {
		super(bille);
	}
	
	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur) 
	{
		super.collisionContour(abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);
		Collisions.collisionBilleContourAvecArretHorizontal(bille.getPosition(), bille.getRayon(), bille.getVitesse(), abscisseCoinHautGauche, largeur);
		Collisions.collisionBilleContourAvecArretVertical(bille.getPosition(), bille.getRayon(), bille.getVitesse(), ordonn�eCoinHautGauche, hauteur);
	}
}