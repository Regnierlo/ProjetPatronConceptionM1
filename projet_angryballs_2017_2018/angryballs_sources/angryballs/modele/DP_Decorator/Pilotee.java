package angryballs.modele.DP_Decorator;

import java.util.Vector;

import angryballs.modele.Billeable;
import angryballs.modele.DP_State.BilleState;
import angryballs.modele.DP_State.BilleStateDrop;
import angryballs.modele.DP_State.BilleStateHold;
import mesmaths.geometrie.base.Vecteur;

public class Pilotee extends Decorator{

	private BilleState etatCourant;
	private BilleStateDrop etatDrop;
	private BilleStateHold etatHold;
	
	private double prevx;
	private double prevy;
	private double x;
	private double y;
	
	private Vecteur vectAccel;
	private Vecteur vectVit;
	
	public Pilotee(Billeable bille) {
		super(bille);
		// TODO Auto-generated constructor stub
		this.bille=bille;
		etatDrop = new BilleStateDrop();
		etatHold = new BilleStateHold();
		etatCourant=etatDrop;
	}
	/*
	 * (non-Javadoc)
	 * @see exodecorateur_angryballs.maladroit.modele.Decorator#gestionAcceleration(java.util.Vector)
	 * affecte a l'acceleration un vecteur null
	 */
	@Override
	public void gestionAcceleration(Vector<Billeable> billes) {
		bille.setAcceleration(new Vecteur(0,0));
	}
	/*
	 * (non-Javadoc)
	 * @see exodecorateur_angryballs.maladroit.modele.Decorator#getState()
	 * recupere l'etat courant
	 */
	public BilleState getState() {
		return etatCourant;
		
	}
	/*
	 * affecte un nouvel etat a l'etat courant
	 */
	private void setState(BilleState etat) {
		etatCourant = etat;
	}
	/*
	 * (non-Javadoc)
	 * @see exodecorateur_angryballs.maladroit.modele.Decorator#clic()
	 * si un clic est effectue cette fonction est appelee.
	 * elle stock l'acceleration et le vitesse de la bille, en la remplacant par des vecteur null dans le bille.
	 * recupere la position de la bille
	 * et change d'etat
	 */
	@Override
	public void clic() {
		// TODO Auto-generated method stub
		vectAccel=bille.getAcceleration();
		vectVit=bille.getVitesse();
		bille.setAcceleration(new Vecteur(0,0));
		bille.setVitesse(new Vecteur(0,0));
		setState(etatHold);
		x = bille.getPosition().x;
		prevx = bille.getPosition().x;
		y = bille.getPosition().y;
		prevy = bille.getPosition().y;
	}
	/*
	 * (non-Javadoc)
	 * @see exodecorateur_angryballs.maladroit.modele.Decorator#deClic()
	 * affecte l'ancienne aceleration a la bille,
	 * applique le vecteur vitesse calcule avec les deux precedente coordonnee de la bille
	 */
	@Override
	public void deClic() {
		// TODO Auto-generated method stub
		bille.setAcceleration(vectAccel);
		vectVit.x = (x-prevx)/4;
		vectVit.y = (y-prevy)/4;
		bille.setVitesse(vectVit);
		setState(etatDrop);
	}
	/*
	 * (non-Javadoc)
	 * @see exodecorateur_angryballs.maladroit.modele.Decorator#setPosition(mesmaths.geometrie.base.Vecteur)
	 * fonction appele lors d'un mouvement avec clic de souris
	 * appel la fonction de mouvement de l'etat actuel
	 * et affecte les positions aux variables afin de calculer lors du relachement du clic la vitesse de la souris
	 */
	@Override
	public void setPosition(Vecteur pos) {
		etatCourant.mouvement(pos,bille);
		prevy = y;
		prevx = x;
		x = bille.getPosition().x;
		y = bille.getPosition().y;
	}
}
