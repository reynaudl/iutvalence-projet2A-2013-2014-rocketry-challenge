package fr.iutvalence.rocketuino;

import javax.swing.SwingUtilities;

import fr.iutvalence.rocketuino.ihm.TacheAffichage;

public class ApplicationRocketruino
{
	public static final String NOM_APPLICATION = "Rocketruino 1.0";
	public static final int LARGEUR_FENETRE = 1000;
	public static final int HAUTEUR_FENETRE = 600;

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new TacheAffichage(LARGEUR_FENETRE, HAUTEUR_FENETRE));
	}

//	private static void testMesureSimple()
//	{
//		MesureSimple m1 = new MesureSimple(0.654f, 2.142f, 1.546f, 5.546f, 500);
//		MesureSimple m2 = new MesureSimple(0.874f, 5.142f, 6.546f, 0.546f, 550);
//		MesureSimple m3 = new MesureSimple(4.654f, 1.142f, 3.546f, 2.546f, 480);
//
//		System.out.println("Mesure Simple m1 :");
//		System.out.println(m1);
//	}
//
//	private static void testRocketruinoEnVol()
//	{
//		RocketruinoEnVol rocketruinoEnVol = new RocketruinoEnVol();
//		AffichageConsoleEnVol interfaceConsoleEnVol = new AffichageConsoleEnVol(rocketruinoEnVol);
//		rocketruinoEnVol.setVue(interfaceConsoleEnVol);
//	}

}