package fr.iutvalence.rocketuino.ihm;

import javax.swing.JComponent;
import javax.swing.JFrame;

import fr.iutvalence.rocketuino.ApplicationRocketruino;
import fr.iutvalence.rocketuino.RocketruinoEnVol;
import fr.iutvalence.rocketuino.RocketruinoPostVol;

public class TacheAffichage implements Runnable
{
	public int largeurFenetre;
	public int hauteurFenetre;
	
	private JFrame fenetre;
	private PanneauMenuPrincipal panneauMenuPrincipal;
	
	public TacheAffichage(int largeurFenetre, int hauteurFenetre)
	{
		this.largeurFenetre = largeurFenetre;
		this.hauteurFenetre = hauteurFenetre;
		
		this.fenetre = new JFrame();
		this.fenetre.setTitle(ApplicationRocketruino.NOM_APPLICATION);
		this.fenetre.setSize(this.largeurFenetre, this.hauteurFenetre);
		this.fenetre.setLocationRelativeTo(null);
		this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void run()
	{
		this.lancerMenuPrincipal();
	}

	public void lancerAffichagePostVol()
	{
		this.changerContenuFenetre(new AffichagePostVol(this.largeurFenetre, this.hauteurFenetre));
		// TODO
	}
	
	public void lancerAffichageEnVol()
	{
		RocketruinoEnVol controleurEnVol = new RocketruinoEnVol();
		AffichageEnVol vueEnVol = new AffichageEnVol(controleurEnVol, this);
		
		controleurEnVol.setVue(vueEnVol);
		
		if (vueEnVol.isReady())
			this.changerContenuFenetre(vueEnVol);
	}
	
	public void lancerMenuPrincipal()
	{
		if (this.panneauMenuPrincipal == null)
			this.panneauMenuPrincipal = new PanneauMenuPrincipal(this);
		
		this.changerContenuFenetre(this.panneauMenuPrincipal);
	}

	private void changerContenuFenetre(JComponent composant)
	{
		this.fenetre.getContentPane().removeAll();
		this.fenetre.getContentPane().add(composant);
		this.fenetre.setVisible(true);
	}
	
	public JFrame getFenetre()
	{
		return this.fenetre;
	}
}
