package angryballs;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import angryballs.vues.CadreState;

/**
 * Changement du bouton qui n'est plus un ecouteur mais un bouton à part entiere.
 * Ainsi, on va l'utiliser pour changer l'etat du Cadre.
 * 
 */
public class BoutonArreter extends Button implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CadreState cadreState;
	String string;

	/**
	 * Permet d'arrêter l'animation via un Action listener
	 * Creation du bouton
	 * @param str
	 * @param cadreState
	 */
	public BoutonArreter(String str, CadreState cadreState) {
		this.string = str;
		this.cadreState = cadreState;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.cadreState.arreterBilles();
	}
}