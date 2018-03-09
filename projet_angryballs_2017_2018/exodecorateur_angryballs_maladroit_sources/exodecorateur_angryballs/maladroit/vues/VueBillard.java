package exodecorateur_angryballs.maladroit.vues;

/**
 * contrat respecte par toute vue capable de dessiner la liste des billes
 * 
 * Comme ça si vous n'aimez pas mes composants awt vous pouvez les changer sans
 * changer le reste de l'appli
 */
public interface VueBillard {

	public double largeurBillard();

	public double hauteurBillard();

	public void montrer();

	public void accepte(Visitor visitor);
}
