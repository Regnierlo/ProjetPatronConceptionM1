package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;
import mesmaths.mecanique.MecaniquePoint;

public class Frottement extends Decorator{

	public Frottement(Billeable bille) {
		super(bille);
	}
	
	/*
	 * (non-Javadoc)
	 * @see exodecorateur_angryballs.maladroit.modele.Decorator#gestionAcceleration(java.util.Vector)
	 */
	public void gestionAcceleration(Vector<Billeable> billes) {
		super.gestionAcceleration(billes); // remise à zéro du vecteur accélération
		this.getAcceleration().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse())); 

		// contribution de l'acceleration due au frottement dans l'air
	}
}