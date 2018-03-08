package exodecorateur_angryballs.maladroit.vues;

import java.awt.*;
import java.util.Vector;
<<<<<<< HEAD
import exodecorateur_angryballs.maladroit.AnimationBilles;
import exodecorateur_angryballs.maladroit.BoutonArreter;
import exodecorateur_angryballs.maladroit.BoutonLancer;
=======
>>>>>>> DP_Decorator
import exodecorateur_angryballs.maladroit.modele.Billeable;
import outilsvues.EcouteurTerminaison;
import outilsvues.Outils;

/**
 * Vue dessinant les billes et contenant les 3 boutons de contr�le (arr�t du
 * programme, lancer les billes, arr�ter les billes)
 */
public class CadreAngryBalls extends Frame implements VueBillard {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TextField pr�sentation;
	Billard billard;
	public Button lancerBilles, arreterBilles;
	Panel haut, centre, bas;
	EcouteurTerminaison ecouteurTerminaison;
	AnimationBilles animationBilles;
	BoutonLancer BoutonLancer;
	BoutonArreter BoutonArreter;
	private CadreState cadreState;
	
	public CadreAngryBalls(String titre, String message, Vector<Billeable> billes) throws HeadlessException {
		super(titre);
		Outils.place(this, 0.33, 0.33, 0.5, 0.5);
		this.ecouteurTerminaison = new EcouteurTerminaison(this);
		
		this.haut = new Panel();
		this.haut.setBackground(Color.LIGHT_GRAY);
		this.add(this.haut, BorderLayout.NORTH);

		this.centre = new Panel();
		this.add(this.centre, BorderLayout.CENTER);

		this.bas = new Panel();
		this.bas.setBackground(Color.LIGHT_GRAY);
		this.add(this.bas, BorderLayout.SOUTH);

		this.pr�sentation = new TextField(message, 100);
		this.pr�sentation.setEditable(false);
		this.haut.add(this.pr�sentation);

		this.billard = new Billard(billes);
<<<<<<< HEAD
		this.billard.setBackground(new Color(10,110,10)); //petite couleur de billard 
	    this.add(this.billard);
	        
	    this.animationBilles = new AnimationBilles(billes, this);
	    this.cadreState = new CadreState(this.animationBilles);
	
	    this.lancerBilles = (Button) new BoutonLancer("",this.cadreState); 
	    this.lancerBilles.setLabel("Lancer"); //ici on force le label pour qu'il soit affich�
	    this.bas.add(this.lancerBilles);
	     
	    this.arreterBilles = (Button) new BoutonArreter("", this.cadreState);
	    this.arreterBilles.setLabel("Arr�ter"); //ici on force le label pour qu'il soit affich�
	    this.bas.add(this.arreterBilles);
=======
		this.add(this.billard);

		this.lancerBilles = new Button("lancer les billes");
		this.bas.add(this.lancerBilles);
		this.arr�terBilles = new Button("arr�ter les billes");
		this.bas.add(this.arr�terBilles);
>>>>>>> DP_Decorator
	}

	public double largeurBillard() {
		return this.billard.getWidth();
	}

	public double hauteurBillard() {
		return this.billard.getHeight();
	}
	
	@Override
	public void miseAJour() {
		this.billard.repaint();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exodecorateur.vues.VueBillard#montrer()
	 */
	@Override
	public void montrer() {
		
		this.setVisible(true);
	}
}