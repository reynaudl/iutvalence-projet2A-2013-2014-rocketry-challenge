package fr.iutvalence.rocketrychallenge;

import java.util.ArrayList;

public class DonneesImportees extends Donnees
{
	public DonneesImportees()
	{
		this.listeMesures = new ArrayList<MesureComplete>();
	}

	public void ajouterMesure(MesureComplete mesure)
	{
		this.listeMesures.add(mesure);
	}
}
