package fr.iutvalence.rocketuino;

public class MesureSimple
{
	private final float	accelerationX;
	private final float	accelerationY;
	private final float	accelerationZ;
	private final float	pression;
	private final long	millisecondesDepuisMesurePrecedente;

	public MesureSimple(float accelerationX, float accelerationY, float accelerationZ,
			float pression, long millisecondesDepuisMesurePrecedente)
	{
		this.accelerationX = accelerationX;
		this.accelerationY = accelerationY;
		this.accelerationZ = accelerationZ;
		this.pression = pression;
		this.millisecondesDepuisMesurePrecedente = millisecondesDepuisMesurePrecedente;
	}

	@Override
	public String toString()
	{
		return "Ax " + this.accelerationX + ", Ay " + this.accelerationY + ", Az "
				+ this.accelerationZ + ", P " + this.pression + ", T "
				+ this.millisecondesDepuisMesurePrecedente;
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