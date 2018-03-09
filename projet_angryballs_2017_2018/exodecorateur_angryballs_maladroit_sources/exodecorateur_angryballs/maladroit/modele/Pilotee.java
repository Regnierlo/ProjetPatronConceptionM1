package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;
import mesmaths.geometrie.base.Vecteur;

public class Pilotee extends Decorator{

	private BilleState etatCourant;
	private BilleStateDrop etatDrop;
	private BilleStateHold etatHold;
	
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
	@Override
	public void gestionAcceleration(Vector<Billeable> billes) {
		bille.setAcceleration(new Vecteur(0,0));
	}
	public BilleState getState() {
		return etatCourant;
		
	}
	private void setState(BilleState etat) {
		etatCourant = etat;
	}
	@Override
	public void clic() {
		// TODO Auto-generated method stub
		vectAccel=bille.getAcceleration();
		vectVit=bille.getVitesse();
		bille.setAcceleration(new Vecteur(0,0));
		bille.setVitesse(new Vecteur(0,0));
		setState(etatHold);
		System.out.println(vectAccel+"  "+vectVit);
	}
	@Override
	public void deClic() {
		// TODO Auto-generated method stub
		bille.setAcceleration(vectAccel);
		bille.setVitesse(vectVit);
		setState(etatDrop);
	}
	@Override
	public void setPosition(Vecteur pos) {
		etatCourant.mouvement(pos,bille);
	}
}
