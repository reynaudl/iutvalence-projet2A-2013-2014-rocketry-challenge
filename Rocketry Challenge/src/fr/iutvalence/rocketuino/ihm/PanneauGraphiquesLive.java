package fr.iutvalence.rocketuino.ihm;

import java.awt.Color;

import javax.swing.JOptionPane;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import fr.iutvalence.rocketuino.MesureSimple;

public class PanneauGraphiquesLive extends JFXPanel
{
	private final int tempsAffMesures;
	private static final int FREQUENCE_MAX_MESURES = 50; // TODO (par seconde)
	
	private NumberAxis axeX;
	private NumberAxis axeY;

	private XYChart.Series donneesAccelX;
	private XYChart.Series donneesAccelY;
	private XYChart.Series donneesAccelZ;
	private XYChart.Series donneesAltitude;
	private LineChart<Number, Number> graphique;

	public PanneauGraphiquesLive(TacheAffichage tacheAffichage)
	{
		this.tempsAffMesures = new JSliderOnJOptionPane(tacheAffichage.getFenetre()).afficher();
		
		this.axeX = new NumberAxis(0, this.tempsAffMesures, 1);
		this.axeX.setForceZeroInRange(false);
		this.axeX.setAutoRanging(false);
		this.axeX.setLabel("Temps (s)");

		this.axeY = new NumberAxis();
		this.axeY.setAutoRanging(true);
		this.axeY.setLabel(""); // TODO ?
		
		this.graphique = new LineChart<Number, Number>(this.axeX, this.axeY)
		{
			// Pour que les points ne soient pas affichés lors d'un ajout
			@Override
			protected void dataItemAdded(Series<Number, Number> series, int itemIndex, Data<Number, Number> item)
			{
			}
		};
		this.graphique.setTitle("Affichage en direct de l'accélération et de l'altitude");
		this.graphique.setAnimated(false);
		this.graphique.setId("graphiqueLive");
		this.graphique.setStyle("-fx-background-color: white;");

		this.donneesAccelX = new XYChart.Series();
		this.donneesAccelY = new XYChart.Series();
		this.donneesAccelZ = new XYChart.Series();
		this.donneesAltitude = new XYChart.Series();

		this.donneesAccelX.setName("Accélération X (en g)");
		this.donneesAccelY.setName("Accélération Y (en g)");
		this.donneesAccelZ.setName("Accélération Z (en g)");
		this.donneesAltitude.setName("Altitude (en m)");
		
		Scene scene = new Scene(this.graphique);
		this.graphique.getData().addAll(this.donneesAccelX, this.donneesAccelY, this.donneesAccelZ, this.donneesAltitude);
		this.setScene(scene);
	}

	public void ajouterMesure(MesureSimple mesure)
	{
		float secondes = mesure.getMillisecondes() / 1000;
		
		this.donneesAccelX.getData().add(new XYChart.Data(secondes, mesure.getAccelerationX()));
		this.donneesAccelY.getData().add(new XYChart.Data(secondes, mesure.getAccelerationY()));
		this.donneesAccelZ.getData().add(new XYChart.Data(secondes, mesure.getAccelerationZ()));
		this.donneesAltitude.getData().add(new XYChart.Data(secondes, mesure.getAltitude()));

		
		// Suppression des valeurs qui ne sont plus affichées
		if (donneesAccelX.getData().size() > this.tempsAffMesures * FREQUENCE_MAX_MESURES)
			donneesAccelX.getData().remove(0, 1);

		if (donneesAccelY.getData().size() > this.tempsAffMesures * FREQUENCE_MAX_MESURES)
			donneesAccelY.getData().remove(0, 1);

		if (donneesAccelZ.getData().size() > this.tempsAffMesures * FREQUENCE_MAX_MESURES)
			donneesAccelZ.getData().remove(0, 1);

		if (donneesAltitude.getData().size() > this.tempsAffMesures * FREQUENCE_MAX_MESURES)
			donneesAltitude.getData().remove(0, 1);
		
		// Mise à jour des bornes inférieur et supérieure de l'axe X
		axeX.setLowerBound(secondes - this.tempsAffMesures);
		axeX.setUpperBound(secondes);
	}

	public void viderGraphiques()
	{
		this.donneesAccelX.getData().clear();
		this.donneesAccelY.getData().clear();
		this.donneesAccelZ.getData().clear();
		this.donneesAltitude.getData().clear();
	}
}