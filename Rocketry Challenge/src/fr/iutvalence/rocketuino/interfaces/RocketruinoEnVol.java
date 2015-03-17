package fr.iutvalence.rocketuino.interfaces;

public class RocketruinoEnVol implements ControleurEnVol
{
	private final VueEnVol vue;
	
	public RocketruinoEnVol(VueEnVol vue)
	{
		this.vue = vue;
	}

	@Override
	public void redemarrerCapture()
	{
		// TODO Auto-generated method stub
	}
}
