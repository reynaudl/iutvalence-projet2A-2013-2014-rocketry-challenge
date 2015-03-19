package fr.iutvalence.rocketuino;

import java.util.ArrayList;

public class MesureSimple
{
	private final float accelerationX;
	private final float accelerationY;
	private final float accelerationZ;
	private final float pression;
	private final long millisecondesDepuisMesurePrecedente;

	public MesureSimple(float accelerationX, float accelerationY, float accelerationZ,
			float pression, long millisecondesDepuisMesurePrecedente)
	{
		this.accelerationX = accelerationX;
		this.accelerationY = accelerationY;
		this.accelerationZ = accelerationZ;
		this.pression = pression;
		this.millisecondesDepuisMesurePrecedente = millisecondesDepuisMesurePrecedente;
	}

	public MesureSimple(ArrayList tableau)
	{
		this.accelerationX = (float) tableau.get(0);
		this.accelerationY = (float) tableau.get(1);
		this.accelerationZ = (float) tableau.get(2);
		this.pression = (float) tableau.get(3);
		this.millisecondesDepuisMesurePrecedente = (long) tableau.get(4);
	}

	@Override
	public String toString()
	{
		return "\n\t(Ax " + this.accelerationX + ",\tAy " + this.accelerationY + ",\tAz "
				+ this.accelerationZ + ",\tP " + this.pression + ",\tT "
				+ this.millisecondesDepuisMesurePrecedente + ")";
	}

	public float getAccelerationX()
	{
		return this.accelerationX;
	}

	public float getAccelerationY()
	{
		return this.accelerationY;
	}

	public float getAccelerationZ()
	{
		return this.accelerationZ;
	}

	public float getPression()
	{
		return this.pression;
	}

	public float getMillisecondesDepuisMesurePrecedente()
	{
		return millisecondesDepuisMesurePrecedente;
	}
}