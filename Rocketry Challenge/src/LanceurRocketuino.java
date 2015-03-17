import fr.iutvalence.rocketuino.MesureSimple;

public class LanceurRocketuino
{

	public static void main(String[] args)
	{
		MesureSimple m1 = new MesureSimple(0.654f, 2.142f, 1.546f, 5.546f, 500);
		MesureSimple m2 = new MesureSimple(0.874f, 5.142f, 6.546f, 0.546f, 550);
		MesureSimple m3 = new MesureSimple(4.654f, 1.142f, 3.546f, 2.546f, 480);

		System.out.println("Mesure Simple m1 :");
		System.out.println(m1);
	}
}