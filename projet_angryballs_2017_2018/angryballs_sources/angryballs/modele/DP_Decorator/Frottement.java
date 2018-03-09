package angryballs.modele.DP_Decorator;

import java.util.Vector;

import angryballs.modele.Billeable;
import mesmaths.mecanique.MecaniquePoint;

public class Frottement extends Decorator{

	public Frottement(Billeable bille) {
		super(bille);
	}
	
	public void gestionAcceleration(Vector<Billeable> billes) {
		super.gestionAcceleration(billes); // remise a zero du vecteur acceleration
		this.getAcceleration().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse())); 

		// contribution de l'acceleration due au frottement dans l'air
	}
}