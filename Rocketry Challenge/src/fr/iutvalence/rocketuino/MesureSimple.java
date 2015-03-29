package fr.iutvalence.rocketuino;

import java.util.ArrayList;

public class MesureSimple
{
	private final float accelerationX;
	private final float accelerationY;
	private final float accelerationZ;
	private final float altitude;
	private final long millisecondes;

	public MesureSimple(float accelerationX, float accelerationY, float accelerationZ,
			float altitude, long millisecondes)
	{
		this.accelerationX = accelerationX;
		this.accelerationY = accelerationY;
		this.accelerationZ = accelerationZ;
		this.altitude = altitude;
		this.millisecondes = millisecondes;
	}

	public MesureSimple(ArrayList tableau)
	{
		this.accelerationX = (float) tableau.get(0);
		this.accelerationY = (float) tableau.get(1);
		this.accelerationZ = (float) tableau.get(2);
		this.altitude = (float) tableau.get(3);
		this.millisecondes = (long) tableau.get(4);
	}

	@Override
	public String toString()
	{
		return "\n\t(Ax " + this.accelerationX + ",\tAy " + this.accelerationY + ",\tAz "
				+ this.accelerationZ + ",\tP " + this.altitude + ",\tT "
				+ this.millisecondes + ")";
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

	public float getAltitude()
	{
		return this.altitude;
	}

	public float getMillisecondes()
	{
		return millisecondes;
	}
}