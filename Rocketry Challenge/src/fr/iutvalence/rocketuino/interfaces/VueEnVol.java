package fr.iutvalence.rocketuino.interfaces;

import fr.iutvalence.rocketuino.MesureSimple;

public interface VueEnVol
{
	public void initialiserGraphiques();
	public void initialiserTableaux();
	
	public void actualiserMesures();
	public void actualiserTableauExtremums();
	
	public void signalerFinCapture();
	
	public void afficherErreurConnexionAvecRecepteur();
	
	public void setReady();
	public boolean isReady();
}