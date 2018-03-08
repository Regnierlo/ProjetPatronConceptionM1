package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;
import mesmaths.mecanique.MecaniquePoint;

public class Frottement extends Decorator{

	public Frottement(Billeable bille) {
		super(bille);
	}
	
<<<<<<< HEAD
	public void gestionAcceleration(Vector<Billeable> billes) {
		super.gestionAcceleration(billes); // remise à zéro du vecteur accélération
		this.getAcceleration().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse())); 
=======
	public void gestionAccélération(Vector<Billeable> billes) {
		super.gestionAccélération(billes); // remise à zéro du vecteur accélération
		this.getAccélération().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse())); 
>>>>>>> DP_Decorator
		// contribution de l'accélération due au frottement dans l'air
	}
}