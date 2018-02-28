package exodecorateur_angryballs.maladroit.modele;

import mesmaths.geometrie.base.Vecteur;

public class BilleStateHold implements BilleState {

	@Override
	public void mouvement(Vecteur pos,Billeable bille) {
		bille.setPosition(pos);
		// TODO Auto-generated method stub
		
	}

}
