package exodecorateur_angryballs.maladroit.modele;

import java.awt.Graphics;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

public interface Billable {
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur,double hauteur);
	public void gestionAccélération(Vector<Billable> billes);
	public Vecteur getPosition();
	public double getRayon();
	public Vecteur getVitesse();
	public Vecteur getAccélération();
	public int getClef();
	public double masse();
	public boolean gestionCollisionBilleBille(Vector<Billable> billes);
	public void déplacer(double deltaT);
	public void dessine(Graphics g);
}