package fr.iutvalence.rocketuino.interfaces;

import fr.iutvalence.rocketuino.MesureSimple;

public interface VueEnVol
{
	public void initialiserGraphiques();
	public void initialiserTableaux();
	
	public void ajouterMesure(MesureSimple m);
	public void actualiserTableauExtremums(int[] extremumsVolEnCours);
	
	public void signalerFinCapture();
}