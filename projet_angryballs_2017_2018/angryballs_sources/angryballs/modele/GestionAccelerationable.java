package angryballs.modele;

import java.util.Vector;
import mesmaths.geometrie.base.Vecteur;

public interface GestionAccelerationable {
	public void gestionAcceleration(Vector<Billeable> billes);
	public Vecteur getAcceleration();
}