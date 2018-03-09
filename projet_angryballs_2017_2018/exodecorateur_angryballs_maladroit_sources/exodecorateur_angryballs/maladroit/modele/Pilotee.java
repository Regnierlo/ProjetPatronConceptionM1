package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;
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
		x = bille.getPosition().x;
		prevx = bille.getPosition().x;
		y = bille.getPosition().y;
		prevy = bille.getPosition().y;
	}
	@Override
	public void deClic() {
		// TODO Auto-generated method stub
		bille.setAcceleration(vectAccel);
		vectVit.x = (x-prevx)/4;
		vectVit.y = (y-prevy)/4;
		bille.setVitesse(vectVit);
		setState(etatDrop);
	}
	@Override
	public void setPosition(Vecteur pos) {
		etatCourant.mouvement(pos,bille);

		prevy = y;
		prevx = x;
		x = bille.getPosition().x;
		y = bille.getPosition().y;
	}
}
