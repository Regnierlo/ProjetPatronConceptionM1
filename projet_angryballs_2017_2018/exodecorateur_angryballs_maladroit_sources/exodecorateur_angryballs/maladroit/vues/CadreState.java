package exodecorateur_angryballs.maladroit.vues;

import java.util.Observable;
import exodecorateur_angryballs.maladroit.AnimationBilles;

public class CadreState extends Observable{
	
	Boolean run = false;

	/**
	 * Classe permettant de créer les fonctions qui vont notifier leurs états auprès de l'animation.
	 * @param animationBilles
	 */
	public CadreState(AnimationBilles animationBilles) {
		this.addObserver(animationBilles);
	}

	public void lancerBilles() {
		run = true;
		this.setChanged();
        notifyObservers();
	}

	public void arreterBilles() {
		run = false;
		this.setChanged();
        notifyObservers();
	}

	/**
	 * retour le statut du cadre
	 * @return
	 */
	public Boolean getCadreState() {
		return run;
	}
}