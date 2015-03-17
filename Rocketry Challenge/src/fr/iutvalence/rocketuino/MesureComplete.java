package fr.iutvalence.rocketuino;

import java.util.ArrayList;

public class MesureComplete extends MesureSimple
{
	private final float	orientationX;
	private final float	orientationY;
	private final float	orientationZ;
	private final float	champMagnetiqueX;
	private final float	champMagnetiqueY;
	private final float	champMagnetiqueZ;

	public MesureComplete(float accelerationX, float accelerationY, float accelerationZ,
			float orientationX, float orientationY, float orientationZ, float champMagnetiqueX,
			float champMagnetiqueY, float champMagnetiqueZ, float pression,
			long millisecondesDepuisMesurePrecedente)
	{
		super(accelerationX, accelerationY, accelerationZ, pression,
				millisecondesDepuisMesurePrecedente);
		this.orientationX = orientationX;
		this.orientationY = orientationY;
		this.orientationZ = orientationZ;
		this.champMagnetiqueX = champMagnetiqueX;
		this.champMagnetiqueY = champMagnetiqueY;
		this.champMagnetiqueZ = champMagnetiqueZ;
	}

	public MesureComplete(ArrayList tableau)
	{
		super((float) tableau.get(0), (float) tableau.get(1), (float) tableau.get(2),
				(float) tableau.get(9), (long) tableau.get(10));
		this.orientationX = (float) tableau.get(3);
		this.orientationY = (float) tableau.get(4);
		this.orientationZ = (float) tableau.get(5);
		this.champMagnetiqueX = (float) tableau.get(6);
		this.champMagnetiqueY = (float) tableau.get(7);
		this.champMagnetiqueZ = (float) tableau.get(8);
	}

	@Override
	public String toString()
	{
		return "Ax " + this.getAccelerationX() + ", Ay " + this.getAccelerationY() + ", Az "
				+ this.getAccelerationZ() + ", Ox " + this.orientationX + ", Oy "
				+ this.orientationY + ", Oz " + this.orientationZ + ", Mx " + this.champMagnetiqueX
				+ ", My " + this.champMagnetiqueY + ", Mz " + this.champMagnetiqueZ + ", P "
				+ this.getPression() + ", T " + this.getMillisecondesDepuisMesurePrecedente();
	}
}