package fr.iutvalence.rocketrychallenge;

/**
 * @author Sebastien
 * Classe principale de l'application
 */
public class RocketryChallenge
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		MesureLive m1 = new MesureLive(0.654f, 2.142f, 1.546f, 5.546f, 500);
		MesureLive m2 = new MesureLive(0.874f, 5.142f, 6.546f, 0.546f, 550);
		MesureLive m3 = new MesureLive(4.654f, 1.142f, 3.546f, 2.546f, 480);
		
		DonneesLive d1 = new DonneesLive();
		d1.ajouterMesure(m1);
		d1.ajouterMesure(m2);
		d1.ajouterMesure(m3);

		System.out.println("Mesure live m1 :");
		System.out.println(m1);
		System.out.println("Données live d1 :");
		System.out.println(d1);
	}
}