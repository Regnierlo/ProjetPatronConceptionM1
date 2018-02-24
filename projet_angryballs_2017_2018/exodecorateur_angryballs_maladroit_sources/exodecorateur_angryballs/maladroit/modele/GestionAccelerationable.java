package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

public interface GestionAccelerationable {
	public void gestionAccélération(Vector<Billeable> billes);
	public Vecteur getAccélération();
}
