package exodecorateur_angryballs.maladroit.vues;

public class ActiveVisitor implements Visitor {

	/*
	 * Classe implementant le DP Visitor et donnant lieu a une animation plus fluide.
	 * Elle appelle la methode redessine
	 */
	@Override
	public void visite(Billard billard) {
		billard.redessine();
	}
}
