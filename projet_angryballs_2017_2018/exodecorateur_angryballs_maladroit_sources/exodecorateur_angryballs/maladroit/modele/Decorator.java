package exodecorateur_angryballs.maladroit.modele;

import java.awt.Graphics;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

public class Decorator implements Billeable{
    protected Billeable bille;

    public Decorator(final Billeable bille) {
        this.bille = bille;
    }
	public void gestionAcc�l�ration(Vector<Billeable> billes) {
		bille.gestionAcc�l�ration(billes);
	}
	public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur) {
		bille.collisionContour(abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);
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
	public Vecteur getAcc�l�ration() {
		// TODO Auto-generated method stub
		return bille.getAcc�l�ration();
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
	public void d�placer(double deltaT) {
		// TODO Auto-generated method stub
		bille.d�placer(deltaT);
	}
	@Override
	public void dessine(Graphics g) {
		// TODO Auto-generated method stub
		bille.dessine(g);
	}
}