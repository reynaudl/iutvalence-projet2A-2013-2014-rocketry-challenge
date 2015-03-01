package fr.iutvalence.rocketrychallenge;

import java.util.ArrayList;

public class DonneesNormalisees extends Donnees
{
	public DonneesNormalisees()
	{
		this.listeMesures = new ArrayList<MesureNormalisee>();
	}

	public void ajouterMesure(MesureNormalisee mesure)
	{
		this.listeMesures.add(mesure);
	}
	
	public MesureNormalisee normaliserEtAjouterMesure(Mesure mesure)
	{
		return null; // TODO
	}
}
