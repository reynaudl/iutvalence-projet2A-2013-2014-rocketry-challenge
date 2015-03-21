package fr.iutvalence.rocketuino.interfaces;

import java.util.ArrayList;

import fr.iutvalence.rocketuino.MesureComplete;

public interface VuePostVol
{
	public void initialiserGraphiques();
	public void initialiserTableaux();

	public void afficherMesures(ArrayList<MesureComplete> mesures);
	public void afficherTableauExtremums(MesureComplete mesureExtremums);
	
	// TODO : afficherProfilDeVol()
}