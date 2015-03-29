package fr.iutvalence.rocketuino.ihm;

import javax.swing.JComponent;
import javax.swing.JFrame;

import fr.iutvalence.rocketuino.ApplicationRocketruino;
import fr.iutvalence.rocketuino.RocketruinoEnVol;

public class TacheAffichage implements Runnable
{
	public int largeurFenetre;
	public int hauteurFenetre;
	
	private JFrame fenetre;
	
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
		RocketruinoEnVol controleur = new RocketruinoEnVol();
		AffichageEnVol vue = new AffichageEnVol(controleur, this);
		controleur.setVue(vue);
		
		if (vue.isReady())
		{
			this.changerContenuFenetre(vue);
		}
	}
	
	public void lancerMenuPrincipal()
	{
		PanneauMenuPrincipal panneauMenuPrincipal = new PanneauMenuPrincipal(this);
		this.changerContenuFenetre(panneauMenuPrincipal);
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
