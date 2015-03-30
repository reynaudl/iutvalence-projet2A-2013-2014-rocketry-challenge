package fr.iutvalence.rocketuino;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import fr.iutvalence.rocketuino.interfaces.ControleurEnVol;
import fr.iutvalence.rocketuino.interfaces.VueEnVol;

public class RocketruinoEnVol implements ControleurEnVol
{
	private VueEnVol vue;
	private ArrayList<MesureSimple> mesures;
	private LecteurPortSerie lecteurPortSerie;
	private MesureSimple maximums;
	private MesureSimple minimums;

	public void setVue(VueEnVol vue)
	{
		this.vue = vue;
		this.mesures = new ArrayList<MesureSimple>();
		this.maximums = new MesureSimple(0, 0, 0, 0, 0);
		this.minimums = new MesureSimple(0, 0, 0, 0, 0);
		this.lecteurPortSerie = new LecteurPortSerie(this);
	}

	@Override
	public void redemarrerCapture()
	{
		this.mesures.clear();
		this.viderTableauExtremums();
		this.vue.viderGraphiques();
	}

	@Override
	public void ajouterMesure(MesureSimple mesure)
	{
		this.mesures.add(mesure);
		this.vue.ajouterMesure(mesure);
		this.actualiserExtremums(mesure);
	}

	@Override
	public ArrayList<MesureSimple> getMesures()
	{
		return this.mesures;
	}

	@Override
	public MesureSimple getMaximums()
	{
		return this.maximums;
	}

	@Override
	public MesureSimple getMinimums()
	{
		return this.minimums;
	}

	@Override
	public void erreurConnexionAvecRecepteur()
	{
		this.vue.afficherErreurConnexionAvecRecepteur();
	}

	private void actualiserExtremums(MesureSimple mesure)
	{
		boolean valeursMaximumModifiees = false;
		boolean valeursMinimumModifiees = false;
		
		float accelXMax = this.maximums.getAccelerationX();
		float accelYMax = this.maximums.getAccelerationY();
		float accelZMax = this.maximums.getAccelerationZ();
		float pressionMax = this.maximums.getAltitude();
		
		float accelXMin = this.minimums.getAccelerationX();
		float accelYMin = this.minimums.getAccelerationY();
		float accelZMin = this.minimums.getAccelerationZ();
		float pressionMin = this.minimums.getAltitude();

		// Màj valeurs max
		if (mesure.getAccelerationX() > this.maximums.getAccelerationX())
		{
			accelXMax = mesure.getAccelerationX();
			valeursMaximumModifiees = true;
		}
		
		if (mesure.getAccelerationY() > this.maximums.getAccelerationY())
		{
			accelYMax = mesure.getAccelerationY();
			valeursMaximumModifiees = true;
		}

		if (mesure.getAccelerationZ() > this.maximums.getAccelerationZ())
		{
			accelZMax = mesure.getAccelerationZ();
			valeursMaximumModifiees = true;
		}

		if (mesure.getAltitude() > this.maximums.getAltitude())
		{
			pressionMax = mesure.getAltitude();
			valeursMaximumModifiees = true;
		}

		// Màj valeurs min
		if (mesure.getAccelerationX() < this.minimums.getAccelerationX())
		{
			accelXMin = mesure.getAccelerationX();
			valeursMinimumModifiees = true;
		}
		
		if (mesure.getAccelerationY() < this.minimums.getAccelerationY())
		{
			accelYMin = mesure.getAccelerationY();
			valeursMinimumModifiees = true;
		}

		if (mesure.getAccelerationZ() < this.minimums.getAccelerationZ())
		{
			accelZMin = mesure.getAccelerationZ();
			valeursMinimumModifiees = true;
		}

		if (mesure.getAltitude() < this.minimums.getAltitude())
		{
			pressionMin = mesure.getAltitude();
			valeursMinimumModifiees = true;
		}

		this.maximums = new MesureSimple(accelXMax, accelYMax, accelZMax, pressionMax, 0);
		this.minimums = new MesureSimple(accelXMin, accelYMin, accelZMin, pressionMin, 0);
		
		if (valeursMaximumModifiees || valeursMinimumModifiees)
			this.vue.actualiserTableauxExtremums();
	}

	private void viderTableauExtremums()
	{
		this.maximums = new MesureSimple(0, 0, 0, 0, 0);
		this.minimums = new MesureSimple(0, 0, 0, 0, 0);
		this.vue.actualiserTableauxExtremums();
	}

	@Override
	public void setReady()
	{
		this.vue.setReady();
	}
}