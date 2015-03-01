package fr.iutvalence.rocketrychallenge;

public class MesureNormalisee extends Mesure
{
	private final float	accelerationX;
	private final float	accelerationY;
	private final float	accelerationZ;
	private final float	orientationX;
	private final float	orientationY;
	private final float	orientationZ;
	private final float	champMagnetiqueX;
	private final float	champMagnetiqueY;
	private final float	champMagnetiqueZ;
	private final float	pression;
	private final long	millisecondesDepuisMesurePrecedente;

	public MesureNormalisee(float accelerationX, float accelerationY, float accelerationZ,
			float orientationX, float orientationY, float orientationZ, float champMagnetiqueX,
			float champMagnetiqueY, float champMagnetiqueZ, float pression, long millisecondesDepuisMesurePrecedente)
	{
		this.accelerationX = accelerationX;
		this.accelerationY = accelerationY;
		this.accelerationZ = accelerationZ;
		this.orientationX = orientationX;
		this.orientationY = orientationY;
		this.orientationZ = orientationZ;
		this.champMagnetiqueX = champMagnetiqueX;
		this.champMagnetiqueY = champMagnetiqueY;
		this.champMagnetiqueZ = champMagnetiqueZ;
		this.pression = pression;
		this.millisecondesDepuisMesurePrecedente = millisecondesDepuisMesurePrecedente;
	}

	@Override
	public String toString()
	{
		return "Ax " + this.accelerationX + ", Ay " + this.accelerationY + ", Az "
				+ this.accelerationZ + ", Ox " + this.orientationX + ", Oy " + this.orientationY
				+ ", Oz " + this.orientationZ + ", Mx " + this.champMagnetiqueX + ", My "
				+ this.champMagnetiqueY + ", Mz " + this.champMagnetiqueZ + ", P " + this.pression
				+ ", T " + this.millisecondesDepuisMesurePrecedente;
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

	public float getOrientationX()
	{
		return this.orientationX;
	}

	public float getOrientationY()
	{
		return this.orientationY;
	}

	public float getOrientationZ()
	{
		return this.orientationZ;
	}

	public float getChampMagnetiqueX()
	{
		return this.champMagnetiqueX;
	}

	public float getChampMagnetiqueY()
	{
		return this.champMagnetiqueY;
	}

	public float getChampMagnetiqueZ()
	{
		return this.champMagnetiqueZ;
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