package exodecorateur_angryballs.maladroit;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import exodecorateur_angryballs.maladroit.vues.CadreState;

/**
 * Changement du bouton qui n'est plus un écouteur mais un bouton à part entière.
 * Ainsi, on va l'utiliser pour changer l'état du Cadre.
 * 
 */
public class BoutonArreter extends Button implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CadreState cadreState;
	String string;

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