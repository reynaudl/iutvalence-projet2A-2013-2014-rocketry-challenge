package fr.iutvalence.rocketuino.ihm;

import fr.iutvalence.rocketuino.interfaces.ControleurEnVol;
import fr.iutvalence.rocketuino.interfaces.VueEnVol;

public class InterfaceConsoleEnVol implements VueEnVol
{
	private ControleurEnVol controleur;

	public InterfaceConsoleEnVol(ControleurEnVol controleurEnVol)
	{
		this.controleur = controleurEnVol;
	}

	@Override
	public void initialiserGraphiques()
	{
		System.out.println("Graphiques initialisés.");
	}

	@Override
	public void initialiserTableaux()
	{
		System.out.println("Tableaux initialisés.");
	}

	@Override
	public void actualiserMesures()
	{
		System.out.println("Mesures mises à jour.");
	}

	@Override
	public void actualiserTableauExtremums()
	{
		System.out.println("Tableau des extremums :");
		System.out.println(this.controleur.getMesureExtremums());
	}

	@Override
	public void signalerFinCapture()
	{
		System.out.println("Fin de la capture.");
	}

	@Override
	public void afficherErreurConnexionAvecRecepteur()
	{
		System.out.println("Erreur lors de la connexion avec le récepteur !");
	}

}
