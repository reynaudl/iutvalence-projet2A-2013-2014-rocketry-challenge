package fr.iutvalence.rocketuino.ihm;

import javafx.application.Platform;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fr.iutvalence.rocketuino.MesureSimple;
import fr.iutvalence.rocketuino.interfaces.ControleurEnVol;
import fr.iutvalence.rocketuino.interfaces.VueEnVol;

public class AffichageEnVol extends JPanel implements VueEnVol
{
	private final ControleurEnVol controleur;
	private final TacheAffichage tacheAffichage;
	private boolean isReady = false;

	private PanneauGraphiqueLive panneauGraphique;

	public AffichageEnVol(ControleurEnVol controleur, TacheAffichage tacheAffichage)
	{
		this.controleur = controleur;
		this.tacheAffichage = tacheAffichage;
		this.panneauGraphique = new PanneauGraphiqueLive();
		this.add(this.panneauGraphique);
	}

	@Override
	public void viderGraphiques()
	{
		Platform.runLater(new Runnable()
		{
			@Override
			public void run()
			{
				panneauGraphique.viderGraphiques();
			}
		});
	}

	@Override
	public void ajouterMesure(MesureSimple mesure)
	{
		Platform.runLater(new Runnable()
		{
			@Override
			public void run()
			{
				panneauGraphique.ajouterMesure(mesure);
			}
		});
	}

	@Override
	public void actualiserTableauExtremums(MesureSimple mesureExtremums)
	{
		// TODO
	}

	@Override
	public void signalerFinCapture()
	{
		// TODO
	}

	@Override
	public void afficherErreurConnexionAvecRecepteur()
	{
		JOptionPane
				.showMessageDialog(
						this,
						"Erreur lors de la connexion avec le récepteur, veuillez vérifier qu'il est bien branché à l'ordinateur",
						"Erreur connexion récepteur", JOptionPane.ERROR_MESSAGE);
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
