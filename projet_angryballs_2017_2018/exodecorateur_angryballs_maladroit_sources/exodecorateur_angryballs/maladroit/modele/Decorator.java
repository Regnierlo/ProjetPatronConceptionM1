package exodecorateur_angryballs.maladroit.modele;

import java.awt.Graphics;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

public class Decorator implements Billeable{
    protected Billeable bille;

    public Decorator(final Billeable bille) {
        this.bille = bille;
    }
	public void gestionAcceleration(Vector<Billeable> billes) {
		bille.gestionAcceleration(billes);
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
	public Vecteur getAcceleration() {
		// TODO Auto-generated method stub
		return bille.getAcceleration();
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
	public void deplacer(double deltaT) {
		// TODO Auto-generated method stub
		bille.deplacer(deltaT);
	}
	@Override
	public void dessine(Graphics g) {
		// TODO Auto-generated method stub
		bille.dessine(g);
	}
	@Override
	public void clic() {
		bille.clic();
		// TODO Auto-generated method stub
	}
	@Override
	public void deClic() {
		bille.deClic();
	}
	@Override
	public void setPosition(Vecteur pos) {
		bille.setPosition(pos);
	}
	@Override
	public BilleState getState() {
		return bille.getState();
	}
	@Override
	public void setVitesse(Vecteur vit) {
		// TODO Auto-generated method stub
		bille.setVitesse(vit);
	}
	@Override
	public void setAcceleration(Vecteur Accel) {
		// TODO Auto-generated method stub
		bille.setAcceleration(Accel);
	}
}