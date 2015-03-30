package fr.iutvalence.rocketuino.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.application.Platform;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fr.iutvalence.rocketuino.MesureSimple;
import fr.iutvalence.rocketuino.interfaces.ControleurEnVol;
import fr.iutvalence.rocketuino.interfaces.VueEnVol;

public class AffichageEnVol extends JPanel implements VueEnVol, ActionListener
{
	private final ControleurEnVol controleur;
	private final TacheAffichage tacheAffichage;
	private boolean isReady = false;

	private PanneauGraphiquesLive panneauGraphiques;
	private PanneauTableauMesure panneauTableauMinimums;
	private PanneauTableauMesure panneauTableauMaximums;

	public AffichageEnVol(ControleurEnVol controleur, TacheAffichage tacheAffichage)
	{
		this.controleur = controleur;
		this.tacheAffichage = tacheAffichage;
		this.panneauGraphiques = new PanneauGraphiquesLive(this.tacheAffichage);
		this.panneauTableauMinimums = new PanneauTableauMesure();
		this.panneauTableauMaximums = new PanneauTableauMesure();
		this.initialiserAffichage();
	}

	private void initialiserAffichage()
	{
		this.setLayout(new BorderLayout());
		this.add(this.panneauGraphiques, BorderLayout.CENTER);

		JLabel valeursMin = new JLabel("          Valeurs minimales          ");
		valeursMin.setFont(new Font("Arial", Font.BOLD, 13));
		valeursMin.setForeground(Color.DARK_GRAY);

		JLabel valeursMax = new JLabel("          Valeurs maximales          ");
		valeursMax.setFont(new Font("Arial", Font.BOLD, 13));
		valeursMax.setForeground(Color.DARK_GRAY);

		JPanel panneauBas = new JPanel();
		panneauBas.setBackground(Color.WHITE);
		panneauBas.add(valeursMin);
		panneauBas.add(this.panneauTableauMinimums);
		panneauBas.add(valeursMax);
		panneauBas.add(this.panneauTableauMaximums);

		this.add(panneauBas, BorderLayout.PAGE_END);

		this.initialiserBarreMenu();
	}

	private void initialiserBarreMenu()
	{
		JMenuBar barreDeMenu = new JMenuBar();

		JMenu menu = new JMenu("Menu");
		JMenuItem redemarrerCapture = new JMenuItem("Redémarrer la capture");
		JMenuItem quitter = new JMenuItem("Quitter");

		redemarrerCapture.addActionListener(this);
		quitter.addActionListener(this);

		menu.add(redemarrerCapture);
		menu.add(quitter);
		
		barreDeMenu.add(menu);
		
		this.tacheAffichage.getFenetre().setJMenuBar(barreDeMenu);
	}

	@Override
	public void viderGraphiques()
	{
		Platform.runLater(new Runnable()
		{
			@Override
			public void run()
			{
				panneauGraphiques.viderGraphiques();
				panneauTableauMinimums.viderTableau();
				panneauTableauMaximums.viderTableau();
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
				panneauGraphiques.ajouterMesure(mesure);
			}
		});
	}

	@Override
	public void actualiserTableauxExtremums()
	{
		Platform.runLater(new Runnable()
		{
			@Override
			public void run()
			{
				panneauTableauMinimums.actualiserMesure(controleur.getMinimums());
				panneauTableauMaximums.actualiserMesure(controleur.getMaximums());
			}
		});
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

	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch (e.getActionCommand())
		{
			case "Redémarrer la capture":
				this.controleur.redemarrerCapture();
				break;
			case "Quitter":
				if (JOptionPane.showOptionDialog(tacheAffichage.getFenetre(), "Etes-vous sûr de vouloir quitter l'application ?", "Quitter - confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Oui !", "Non"}, "Oui !") == JOptionPane.OK_OPTION)
					System.exit(0);
				break;
		}
	}
}
