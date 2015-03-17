package fr.iutvalence.rocketuino.interfaces;

import fr.iutvalence.rocketuino.MesureComplete;

public interface VuePostVol
{
	public void initialiserGraphiques();
	public void initialiserTableaux();

	public void afficherMesures(MesureComplete[] m);
	public void afficherTableauExtremums(int[] extremums);
	
	// TODO : afficherProfilDeVol()
}