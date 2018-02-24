package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

public interface GestionAccelerationable {
	public void gestionAcc�l�ration(Vector<Billeable> billes);
	public Vecteur getAcc�l�ration();
}
