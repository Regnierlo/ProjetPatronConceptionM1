package exodecorateur_angryballs.maladroit.modele;

import mesmaths.geometrie.base.Vecteur;

public class BilleStateHold implements BilleState {

	@Override
	public void mouvement(Vecteur pos,Billeable bille) {
		bille.setPosition(pos);
		bille.setAcceleration(new Vecteur(0,0));
		bille.setVitesse(new Vecteur(0,0));
		// TODO Auto-generated method stub		
	}
}
