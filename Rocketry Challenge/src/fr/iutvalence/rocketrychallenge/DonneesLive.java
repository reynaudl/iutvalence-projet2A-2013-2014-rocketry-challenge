package fr.iutvalence.rocketrychallenge;

import java.util.ArrayList;

public class DonneesLive extends Donnees
{
	public DonneesLive()
	{
		this.listeMesures = new ArrayList<MesureLive>();
	}

	public void ajouterMesure(MesureLive mesure)
	{
		this.listeMesures.add(mesure);
	}
}
