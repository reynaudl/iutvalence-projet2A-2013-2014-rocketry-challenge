package fr.iutvalence.rocketuino.interfaces;

import java.util.ArrayList;

import fr.iutvalence.rocketuino.MesureSimple;

public interface ControleurEnVol
{
	public void redemarrerCapture();
	public void ajouterMesure(MesureSimple mesure);
	public void erreurConnexionAvecRecepteur();
	
	public ArrayList<MesureSimple> getMesures();
	public MesureSimple getMesureExtremums();
}