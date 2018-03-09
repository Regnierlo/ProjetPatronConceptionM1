package outilsvues;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import exodecorateur_angryballs.maladroit.modele.Billeable;

public class EcouteurMouse implements MouseListener {

	private Vector<Billeable> billes;
	public EcouteurMouse(Vector<Billeable> billes) {
		this.billes=billes;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 * si la souris est préssé dans une bille, lance la focntion clic() de la bille en question
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i<billes.size();i++) {
			if(e.getPoint().getX()>billes.elementAt(i).getPosition().x - billes.elementAt(i).getRayon()&&
					e.getPoint().getX()<billes.elementAt(i).getPosition().x + billes.elementAt(i).getRayon() &&
					e.getPoint().getX()>billes.elementAt(i).getPosition().y - billes.elementAt(i).getRayon()&&
					e.getPoint().getY()<billes.elementAt(i).getPosition().y+billes.elementAt(i).getRayon()){
				billes.elementAt(i).clic();
			}
		}
	}
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 * Si un clic est relaché dans une bille, lance la focntion declic() de la bille en question
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i<billes.size();i++) {
			if(e.getPoint().getX()>billes.elementAt(i).getPosition().x - billes.elementAt(i).getRayon() && 
					e.getPoint().getX()<billes.elementAt(i).getPosition().x+billes.elementAt(i).getRayon() &&
					e.getPoint().getX()>billes.elementAt(i).getPosition().y - billes.elementAt(i).getRayon() && 
					e.getPoint().getY()<billes.elementAt(i).getPosition().y+billes.elementAt(i).getRayon()){
				billes.elementAt(i).deClic();
			}
		}
	}

}
