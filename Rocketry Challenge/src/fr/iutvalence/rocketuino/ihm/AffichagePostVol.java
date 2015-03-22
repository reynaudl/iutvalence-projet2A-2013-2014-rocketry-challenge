package fr.iutvalence.rocketuino.ihm;

import java.util.ArrayList;

import javax.swing.JPanel;

import fr.iutvalence.rocketuino.MesureComplete;
import fr.iutvalence.rocketuino.interfaces.ControleurPostVol;
import fr.iutvalence.rocketuino.interfaces.VuePostVol;
import gov.nasa.worldwind.BasicModel;
import gov.nasa.worldwind.awt.WorldWindowGLCanvas;

public class AffichagePostVol extends JPanel implements VuePostVol
{
	private ControleurPostVol controleur;

	public AffichagePostVol(int largeurFenetre, int hauteurFenetre) // TODO Demander un controleur
	{
		this.controleur = null; // TODO
		
        WorldWindowGLCanvas worldWind = new WorldWindowGLCanvas();
        worldWind.setPreferredSize(new java.awt.Dimension(largeurFenetre, hauteurFenetre));
        this.add(worldWind, java.awt.BorderLayout.CENTER);
        worldWind.setModel(new BasicModel());
	}

	@Override
	public void initialiserGraphiques()
	{
		// TODO
	}

	@Override
	public void initialiserTableaux()
	{
		// TODO
	}

	@Override
	public void afficherMesures(ArrayList<MesureComplete> mesures)
	{
		// TODO
	}

	@Override
	public void afficherTableauExtremums(MesureComplete mesureExtremums)
	{
		// TODO
	}
}
