package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;
import mesmaths.mecanique.MecaniquePoint;

public class Frottement extends Decorator{

	public Frottement(Billeable bille) {
		super(bille);
	}
	
<<<<<<< HEAD
	public void gestionAcceleration(Vector<Billeable> billes) {
		super.gestionAcceleration(billes); // remise � z�ro du vecteur acc�l�ration
		this.getAcceleration().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse())); 
=======
	public void gestionAcc�l�ration(Vector<Billeable> billes) {
		super.gestionAcc�l�ration(billes); // remise � z�ro du vecteur acc�l�ration
		this.getAcc�l�ration().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse())); 
>>>>>>> DP_Decorator
		// contribution de l'acc�l�ration due au frottement dans l'air
	}
}