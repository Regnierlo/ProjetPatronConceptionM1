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
	
	/*
	 * (non-Javadoc)
	 * @see exodecorateur_angryballs.maladroit.modele.CollisionContourable#getPosition()
	 */
	@Override
	public Vecteur getPosition() {
		// TODO Auto-generated method stub
		return bille.getPosition();
	}
	
	/*
	 * (non-Javadoc)
	 * @see exodecorateur_angryballs.maladroit.modele.CollisionContourable#getRayon()
	 */
	@Override
	public double getRayon() {
		// TODO Auto-generated method stub
		return bille.getRayon();
	}
	
	/*
	 * (non-Javadoc)
	 * @see exodecorateur_angryballs.maladroit.modele.CollisionContourable#getVitesse()
	 */
	@Override
	public Vecteur getVitesse() {
		// TODO Auto-generated method stub
		return bille.getVitesse();
	}
	
	/*
	 * (non-Javadoc)
	 * @see exodecorateur_angryballs.maladroit.modele.GestionAccelerationable#getAcceleration()
	 */
	@Override
	public Vecteur getAcceleration() {
		// TODO Auto-generated method stub
		return bille.getAcceleration();
	}
	
	/*
	 * (non-Javadoc)
	 * @see exodecorateur_angryballs.maladroit.modele.Billeable#getClef()
	 */
	@Override
	public int getClef() {
		// TODO Auto-generated method stub
		return bille.getClef();
	}
	
	/*
	 * (non-Javadoc)
	 * @see exodecorateur_angryballs.maladroit.modele.Billeable#masse()
	 */
	@Override
	public double masse() {
		// TODO Auto-generated method stub
		return bille.masse();
	}
	
	/*
	 * (non-Javadoc)
	 * @see exodecorateur_angryballs.maladroit.modele.Billeable#gestionCollisionBilleBille(java.util.Vector)
	 */
	@Override
	public boolean gestionCollisionBilleBille(Vector<Billeable> billes) {
		return bille.gestionCollisionBilleBille(billes);
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see exodecorateur_angryballs.maladroit.modele.Billeable#deplacer(double)
	 */
	@Override
	public void deplacer(double deltaT) {
		// TODO Auto-generated method stub
		bille.deplacer(deltaT);
	}
	
	/*
	 * (non-Javadoc)
	 * @see exodecorateur_angryballs.maladroit.modele.Billeable#dessine(java.awt.Graphics)
	 */
	@Override
	public void dessine(Graphics g) {
		// TODO Auto-generated method stub
		bille.dessine(g);
	}
	
	/*
	 * (non-Javadoc)
	 * @see exodecorateur_angryballs.maladroit.modele.Billeable#clic()
	 */
	@Override
	public void clic() {
		bille.clic();
		// TODO Auto-generated method stub
	}
	
	/*
	 * (non-Javadoc)
	 * @see exodecorateur_angryballs.maladroit.modele.Billeable#deClic()
	 */
	@Override
	public void deClic() {
		bille.deClic();
	}
	
	/*
	 * (non-Javadoc)
	 * @see exodecorateur_angryballs.maladroit.modele.Billeable#setPosition(mesmaths.geometrie.base.Vecteur)
	 */
	@Override
	public void setPosition(Vecteur pos) {
		bille.setPosition(pos);
	}
	
	/*
	 * (non-Javadoc)
	 * @see exodecorateur_angryballs.maladroit.modele.Billeable#getState()
	 */
	@Override
	public BilleState getState() {
		return bille.getState();
	}
	
	/*
	 * (non-Javadoc)
	 * @see exodecorateur_angryballs.maladroit.modele.Billeable#setVitesse(mesmaths.geometrie.base.Vecteur)
	 */
	@Override
	public void setVitesse(Vecteur vit) {
		// TODO Auto-generated method stub
		bille.setVitesse(vit);
	}
	
	/*
	 * (non-Javadoc)
	 * @see exodecorateur_angryballs.maladroit.modele.Billeable#setAcceleration(mesmaths.geometrie.base.Vecteur)
	 */
	@Override
	public void setAcceleration(Vecteur Accel) {
		// TODO Auto-generated method stub
		bille.setAcceleration(Accel);
	}
}