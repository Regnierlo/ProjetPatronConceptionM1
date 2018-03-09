package exodecorateur_angryballs.maladroit.modele;

import mesmaths.geometrie.base.Vecteur;

public interface CollisionContourable {
	public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur,double hauteur);
	public Vecteur getPosition();
	public double getRayon();
	public Vecteur getVitesse();
}
