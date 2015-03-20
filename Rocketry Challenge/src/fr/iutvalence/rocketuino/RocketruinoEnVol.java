package fr.iutvalence.rocketuino;

import java.util.ArrayList;

import fr.iutvalence.rocketuino.interfaces.ControleurEnVol;
import fr.iutvalence.rocketuino.interfaces.VueEnVol;

public class RocketruinoEnVol implements ControleurEnVol
{
	private VueEnVol vue;
	private ArrayList<MesureSimple> mesures;
	private LecteurPortSerie lecteurPortSerie;
	private MesureSimple mesureExtremums;
	
	public RocketruinoEnVol()
	{
		// TODO Créé lors de l'appel à setVue()
	}

	public void setVue(VueEnVol vue)
	{
		this.vue = vue;
		this.mesures = new ArrayList<MesureSimple>();
		this.mesureExtremums = new MesureSimple(0, 0, 0, 0, 0);
		this.lecteurPortSerie = new LecteurPortSerie(this);
		
		while(true); // TODO
	}

	@Override
	public void redemarrerCapture()
	{
		this.mesures.clear();
		this.viderTableauExtremums();
		this.vue.actualiserMesures();
	}

	@Override
	public void ajouterMesure(MesureSimple mesure)
	{
		this.mesures.add(mesure);
		this.vue.actualiserMesures();
		this.actualiserTableauExtremums(mesure);
	}

	@Override
	public void erreurConnexionAvecRecepteur()
	{
		this.vue.afficherErreurConnexionAvecRecepteur();
	}

	@Override
	public ArrayList<MesureSimple> getMesures()
	{
		return mesures;
	}

	@Override
	public MesureSimple getMesureExtremums()
	{
		return mesureExtremums;
	}

	private void actualiserTableauExtremums(MesureSimple mesure)
	{
		boolean valeursExtremumsModifiees = false;
		
		float accelerationX = this.mesureExtremums.getAccelerationX();
		float accelerationY = this.mesureExtremums.getAccelerationY();
		float accelerationZ = this.mesureExtremums.getAccelerationZ();
		float pression = this.mesureExtremums.getPression();

		if (mesure.getAccelerationX() > this.mesureExtremums.getAccelerationX())
		{
			accelerationX = mesure.getAccelerationX();
			valeursExtremumsModifiees = true;
		}
		
		if (mesure.getAccelerationY() > this.mesureExtremums.getAccelerationY())
		{
			accelerationY = mesure.getAccelerationY();
			valeursExtremumsModifiees = true;
		}

		if (mesure.getAccelerationZ() > this.mesureExtremums.getAccelerationZ())
		{
			accelerationZ = mesure.getAccelerationZ();
			valeursExtremumsModifiees = true;
		}

		if (mesure.getPression() > this.mesureExtremums.getPression())
		{
			pression = mesure.getPression();
			valeursExtremumsModifiees = true;
		}
		
		this.mesureExtremums = new MesureSimple(accelerationX, accelerationY, accelerationZ, pression, 0);
		
		if (valeursExtremumsModifiees)
			this.vue.actualiserTableauExtremums();
	}

	private void viderTableauExtremums()
	{
		this.mesureExtremums = new MesureSimple(0, 0, 0, 0, 0);
		this.vue.actualiserTableauExtremums();
	}
}
