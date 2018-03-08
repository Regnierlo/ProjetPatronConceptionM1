package exodecorateur_angryballs.maladroit.modele;

import java.awt.Graphics;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

public class Decorator implements Billeable{
    protected Billeable bille;

    public Decorator(final Billeable bille) {
        this.bille = bille;
    }
	public void gestionAccélération(Vector<Billeable> billes) {
		bille.gestionAccélération(billes);
	}
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) {
		bille.collisionContour(abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
	}
	@Override
	public Vecteur getPosition() {
		// TODO Auto-generated method stub
		return bille.getPosition();
	}
	@Override
	public double getRayon() {
		// TODO Auto-generated method stub
		return bille.getRayon();
	}
	@Override
	public Vecteur getVitesse() {
		// TODO Auto-generated method stub
		return bille.getVitesse();
	}
	@Override
	public Vecteur getAccélération() {
		// TODO Auto-generated method stub
		return bille.getAccélération();
	}
	@Override
	public int getClef() {
		// TODO Auto-generated method stub
		return bille.getClef();
	}
	@Override
	public double masse() {
		// TODO Auto-generated method stub
		return bille.masse();
	}
	@Override
	public boolean gestionCollisionBilleBille(Vector<Billeable> billes) {
		return bille.gestionCollisionBilleBille(billes);
		// TODO Auto-generated method stub
		
	}
	@Override
	public void déplacer(double deltaT) {
		// TODO Auto-generated method stub
		bille.déplacer(deltaT);
	}
	@Override
	public void dessine(Graphics g) {
		// TODO Auto-generated method stub
		bille.dessine(g);
	}
}