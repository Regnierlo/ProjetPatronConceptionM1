package exodecorateur_angryballs.maladroit.vues;

/**
 * contrat respecte par toute vue capable de dessiner la liste des billes
 * interagi avec le DP Visitor
 */
public interface VueBillard {

	public double largeurBillard();

	public double hauteurBillard();

	public void montrer();

	public void accepte(Visitor visitor);
}
