package fr.iutvalence.rocketuino;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import fr.iutvalence.rocketuino.exceptions.FichierImporteInvalideException;
import fr.iutvalence.rocketuino.interfaces.ControleurPostVol;
import fr.iutvalence.rocketuino.interfaces.VuePostVol;

public class RocketruinoPostVol implements ControleurPostVol
{
	private static final int NB_DONNEES_PAR_LIGNE = 11;
	private final VuePostVol vue;
	private ArrayList<MesureComplete> mesures;

	public RocketruinoPostVol(VuePostVol vue)
	{
		this.vue = vue;
	}

	@Override
	public void importerDepuisFichier(String cheminFichierMesures)
	{
		try
		{
			InputStream inStream = new FileInputStream(cheminFichierMesures);
			InputStreamReader inStreamReader = new InputStreamReader(inStream);
			BufferedReader bufferedReader = new BufferedReader(inStreamReader);

			String ligneCourante = bufferedReader.readLine();

			while ((ligneCourante != null) && (!ligneCourante.isEmpty()))
			{
				this.mesures.add(this.ligneTexteVersMesures(ligneCourante));
				ligneCourante = bufferedReader.readLine();
			}
			bufferedReader.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (FichierImporteInvalideException e)
		{
			e.printStackTrace();
		}
	}

	private MesureComplete ligneTexteVersMesures(String ligneCourante) throws FichierImporteInvalideException
	{
		String[] valeursLigneCourante = ligneCourante.split(",");

		if (valeursLigneCourante.length != RocketruinoPostVol.NB_DONNEES_PAR_LIGNE)
			throw new FichierImporteInvalideException();

		ArrayList liste = new ArrayList();
		for (int i = 0; i < RocketruinoPostVol.NB_DONNEES_PAR_LIGNE - 1; i++)
			liste.add(Float.parseFloat(valeursLigneCourante[i]));
		liste.add(Long.parseLong(valeursLigneCourante[RocketruinoPostVol.NB_DONNEES_PAR_LIGNE]));

		return new MesureComplete(liste);
	}

	@Override
	public void exporterExcel()
	{
		// TODO Auto-generated method stub
	}
}
