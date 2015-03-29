package fr.iutvalence.rocketuino.interfaces;

import fr.iutvalence.rocketuino.MesureSimple;

public interface VueEnVol
{
	public void viderGraphiques();
	
	public void ajouterMesure(MesureSimple mesure);
	public void actualiserTableauExtremums(MesureSimple mesureExtremums);
	
	public void signalerFinCapture();
	
	public void afficherErreurConnexionAvecRecepteur();
	
	public void setReady();
	public boolean isReady();
}