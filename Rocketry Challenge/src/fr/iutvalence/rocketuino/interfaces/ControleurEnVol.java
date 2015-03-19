package fr.iutvalence.rocketuino.interfaces;

import fr.iutvalence.rocketuino.MesureSimple;

public interface ControleurEnVol
{
	public void redemarrerCapture();
	public void ajouterMesure(MesureSimple mesure);
}