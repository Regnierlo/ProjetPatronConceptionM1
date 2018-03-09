package exodecorateur_angryballs.maladroit.modele;

import mesmaths.geometrie.base.Vecteur;

public class BilleStateHold implements BilleState {
	/*
	 * (non-Javadoc)
	 * @see exodecorateur_angryballs.maladroit.modele.BilleState#mouvement(mesmaths.geometrie.base.Vecteur, exodecorateur_angryballs.maladroit.modele.Billeable)
	 * la fonction mouvement permet d'atribuer une nouvelle position a la bille et de fixer sa vitesse et son accélération a 0
	 */
	@Override
	public void mouvement(Vecteur pos,Billeable bille) {
		bille.setPosition(pos);
		bille.setAcceleration(new Vecteur(0,0));
		bille.setVitesse(new Vecteur(0,0));
		// TODO Auto-generated method stub		
	}
}
