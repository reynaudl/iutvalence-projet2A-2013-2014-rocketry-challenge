package fr.iutvalence.rocketuino.ihm;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import javax.swing.JPanel;

import fr.iutvalence.rocketuino.MesureSimple;

public class PanneauGraphiqueLive extends JPanel
{
	private static final int TEMPS_AFFICHAGE_MESURES = 10; // (en secondes)
	private static final int FREQUENCE_MAX_MESURES = 50; // TODO (par seconde)

	private JFXPanel fxPanel;
	
	private NumberAxis axeX;
	private NumberAxis axeY;

	private XYChart.Series donneesAccelX;
	private XYChart.Series donneesAccelY;
	private XYChart.Series donneesAccelZ;
	private XYChart.Series donneesAltitude;
	private LineChart<Number, Number> graphique;

	public PanneauGraphiqueLive()
	{
		this.fxPanel = new JFXPanel();
		this.add(this.fxPanel);

		this.axeX = new NumberAxis(0, TEMPS_AFFICHAGE_MESURES, 1);
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

		this.donneesAccelX = new XYChart.Series();
		this.donneesAccelY = new XYChart.Series();
		this.donneesAccelZ = new XYChart.Series();
		this.donneesAltitude = new XYChart.Series();

		this.donneesAccelX.setName("Accélération X (en g)");
		this.donneesAccelY.setName("Accélération Y (en g)");
		this.donneesAccelZ.setName("Accélération Z (en g)");
		this.donneesAltitude.setName("Altitude (en m)");

		this.donneesAccelX.getData().add(new XYChart.Data(0F, 0F));
		this.donneesAccelY.getData().add(new XYChart.Data(0F, 0F));
		this.donneesAccelZ.getData().add(new XYChart.Data(0F, 0F));
		this.donneesAltitude.getData().add(new XYChart.Data(0F, 0F));
		
		Scene scene = new Scene(this.graphique, 600, 400); // TODO
		this.graphique.getData().addAll(this.donneesAccelX, this.donneesAccelY, this.donneesAccelZ, this.donneesAltitude);
		this.fxPanel.setScene(scene);
	}

	public void ajouterMesure(MesureSimple mesure)
	{
		float secondes = mesure.getMillisecondes() / 1000;
		
		this.donneesAccelX.getData().add(new XYChart.Data(secondes, mesure.getAccelerationX()));
		this.donneesAccelY.getData().add(new XYChart.Data(secondes, mesure.getAccelerationY()));
		this.donneesAccelZ.getData().add(new XYChart.Data(secondes, mesure.getAccelerationZ()));
		this.donneesAltitude.getData().add(new XYChart.Data(secondes, mesure.getAltitude()));

		
		// Suppression des valeurs qui ne sont plus affichées
		if (donneesAccelX.getData().size() > TEMPS_AFFICHAGE_MESURES * FREQUENCE_MAX_MESURES)
			donneesAccelX.getData().remove(0, 1);

		if (donneesAccelY.getData().size() > TEMPS_AFFICHAGE_MESURES * FREQUENCE_MAX_MESURES)
			donneesAccelY.getData().remove(0, 1);

		if (donneesAccelZ.getData().size() > TEMPS_AFFICHAGE_MESURES * FREQUENCE_MAX_MESURES)
			donneesAccelZ.getData().remove(0, 1);

		if (donneesAltitude.getData().size() > TEMPS_AFFICHAGE_MESURES * FREQUENCE_MAX_MESURES)
			donneesAltitude.getData().remove(0, 1);
		
		// Mise à jour des bornes inférieur et supérieure de l'axe X
		axeX.setLowerBound(secondes - TEMPS_AFFICHAGE_MESURES);
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

//Button btn = new Button();
//btn.setText("Passer en mode tableaux");
//btn.setOnAction(new EventHandler<ActionEvent>() {
//    @Override
//    public void handle(ActionEvent event) {
//        //defining a series
//        XYChart.Series series = new XYChart.Series();
//        series.setName("My Test Data");
//        //populating the series with data
//        series.getData().add(new XYChart.Data(1, 23));
//        series.getData().add(new XYChart.Data(2, 14));
//        series.getData().add(new XYChart.Data(3, 15));
//        series.getData().add(new XYChart.Data(4, 24));
//        series.getData().add(new XYChart.Data(5, 34));
//        series.getData().add(new XYChart.Data(6, 36));
//        series.getData().add(new XYChart.Data(7, 22));
//        series.getData().add(new XYChart.Data(8, 45));
//        series.getData().add(new XYChart.Data(9, 43));
//        series.getData().add(new XYChart.Data(10, 17));
//        series.getData().add(new XYChart.Data(11, 29));
//        series.getData().add(new XYChart.Data(12, 25));
//
//        graphique.getData().add(series);
//    }
//});
//VBox root = new VBox();
//root.getChildren().addAll(btn, graphique);