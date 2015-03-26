package fr.iutvalence.rocketuino.ihm;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fr.iutvalence.rocketuino.interfaces.ControleurEnVol;
import fr.iutvalence.rocketuino.interfaces.VueEnVol;

public class AffichageEnVol extends JPanel implements VueEnVol
{
	private final ControleurEnVol controleur;
	private final TacheAffichage tacheAffichage;
	private boolean isReady = false;
	
	public AffichageEnVol(ControleurEnVol controleur, TacheAffichage tacheAffichage)
	{
		this.controleur = controleur;
		this.tacheAffichage = tacheAffichage;
	}

	@Override
	public void initialiserGraphiques()
	{
		// TODO
		System.out.println("Graphiques initialisés.");
	}

	@Override
	public void initialiserTableaux()
	{
		// TODO
		System.out.println("Tableaux initialisés.");
	}

	@Override
	public void actualiserMesures()
	{
		// TODO
		System.out.println("Mesures mises à jour.");
	}

	@Override
	public void actualiserTableauExtremums()
	{
		// TODO
		System.out.println("Tableau des extremums :");
		System.out.println(this.controleur.getMesureExtremums());
	}

	@Override
	public void signalerFinCapture()
	{
		// TODO
		System.out.println("Fin de la capture.");
	}

	@Override
	public void afficherErreurConnexionAvecRecepteur()
	{
		JOptionPane.showMessageDialog(this, "Erreur lors de la connexion avec le récepteur, veuillez vérifier qu'il est bien branché à l'ordinateur", "Erreur connexion récepteur", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void setReady()
	{
		this.isReady = true;
	}

	@Override
	public boolean isReady()
	{
		return this.isReady;
	}
}
