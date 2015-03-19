package fr.iutvalence.rocketuino;

import java.util.ArrayList;

import fr.iutvalence.rocketuino.exceptions.PortCOMIntrouvable;
import fr.iutvalence.rocketuino.interfaces.ControleurEnVol;
import fr.iutvalence.rocketuino.interfaces.VueEnVol;

public class RocketruinoEnVol implements ControleurEnVol
{
	private final VueEnVol vue;
	private ArrayList<MesureSimple> mesures;
	private LecteurPortSerie lecteurPortSerie;
	
	public RocketruinoEnVol(VueEnVol vue)
	{
		this.vue = vue;
		this.mesures = new ArrayList<MesureSimple>();
		this.lecteurPortSerie = new LecteurPortSerie(this);
		
		while(true);
	}

	@Override
	public void redemarrerCapture()
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void ajouterMesure(MesureSimple mesure)
	{
		this.mesures.add(mesure);
	}
	
	
}
