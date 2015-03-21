package fr.iutvalence.rocketuino.ihm;

import java.util.ArrayList;

import javax.swing.JFrame;

import fr.iutvalence.rocketuino.MesureComplete;
import fr.iutvalence.rocketuino.interfaces.ControleurPostVol;
import fr.iutvalence.rocketuino.interfaces.VuePostVol;
import gov.nasa.worldwind.BasicModel;
import gov.nasa.worldwind.awt.WorldWindowGLCanvas;

public class AffichagePostVol extends JFrame implements VuePostVol
{
	private ControleurPostVol controleur;

	public AffichagePostVol() // TODO Demander un controleur
	{
		this.controleur = null; // TODO
		
        WorldWindowGLCanvas wwd = new WorldWindowGLCanvas();
        wwd.setPreferredSize(new java.awt.Dimension(1100, 750));
        this.getContentPane().add(wwd, java.awt.BorderLayout.CENTER);
        wwd.setModel(new BasicModel());
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
	public void afficherMesures(ArrayList<MesureComplete> mesures)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void afficherTableauExtremums(MesureComplete mesureExtremums)
	{
		// TODO Auto-generated method stub
	}
}
