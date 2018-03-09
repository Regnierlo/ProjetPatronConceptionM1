package exodecorateur_angryballs.maladroit;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import exodecorateur_angryballs.maladroit.vues.CadreState;

/**
 * Changement du bouton qui n'est plus un ecouteur mais un bouton a part entiere.
 * Ainsi, on va l'utiliser pour changer l'etat du Cadre.
 */
public class BoutonLancer extends Button implements ActionListener {

	private static final long serialVersionUID = 1L;
	CadreState cadreState;
	String string;

	/**
	 * 
	 * @param str
	 * @param cadreState
	 */
	public BoutonLancer(String str, CadreState cadreState) {
		this.string = str;
		this.cadreState = cadreState;
		this.addActionListener(this);
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.cadreState.lancerBilles();
	}
}