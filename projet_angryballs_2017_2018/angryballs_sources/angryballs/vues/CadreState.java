package angryballs.vues;

import java.util.Observable;
import angryballs.AnimationBilles;

public class CadreState extends Observable{
	
	Boolean run = false;

	/**
	 * Classe permettant de cr�er les fonctions qui vont notifier leurs �tats aupr�s de l'animation.
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