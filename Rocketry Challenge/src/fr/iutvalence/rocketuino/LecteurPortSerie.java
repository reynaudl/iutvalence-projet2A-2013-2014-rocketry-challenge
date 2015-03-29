package fr.iutvalence.rocketuino;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

import fr.iutvalence.rocketuino.exceptions.PortCOMIntrouvable;
import fr.iutvalence.rocketuino.interfaces.ControleurEnVol;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import java.util.ArrayList;
import java.util.Enumeration;

public class LecteurPortSerie implements SerialPortEventListener
{
	SerialPort portSerie;
	
	private final ControleurEnVol controleur;

	/**
	 * A BufferedReader which will be fed by a InputStreamReader converting the bytes into
	 * characters making the displayed results codepage independent
	 */
	private BufferedReader entree;

	/** Temps maximal d'attente lors de l'ouverture d'un port COM (en ms) */
	private static final int DELAI_MAX = 2000;

	/** Débit du port COM */
	private static final int DEBIT = 9600;
	
	public LecteurPortSerie(ControleurEnVol controleur)
	{
		this.controleur = controleur;
		
		try
		{
			this.ouvrirPortCOM();
			this.controleur.setReady();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			this.controleur.erreurConnexionAvecRecepteur();
		}
	}

	private void ouvrirPortCOM() throws PortCOMIntrouvable
	{
		CommPortIdentifier portId = null;
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

		// Recherche d'une instance de port série parmi la liste de noms paramétrée
		while (portEnum.hasMoreElements())
		{
			CommPortIdentifier idPortCourant = (CommPortIdentifier) portEnum.nextElement();
			for (int numero = 0; numero < 10; numero++)
				if (idPortCourant.getName().equals("COM" + numero))
				{
					portId = idPortCourant;
					break;
				}
		}
		if (portId == null)
		{
			throw new PortCOMIntrouvable();
		}

		try
		{
			// open serial port, and use class name for the appName.
			portSerie = (SerialPort) portId.open(this.getClass().getName(), DELAI_MAX);

			// Paramétrage du port
			portSerie.setSerialPortParams(DEBIT, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);

			entree = new BufferedReader(new InputStreamReader(portSerie.getInputStream()));

			portSerie.addEventListener(this);
			portSerie.notifyOnDataAvailable(true);
		}
		catch (Exception e)
		{
			System.err.println(e.toString());
		}
	}

	/**
	 * This should be called when you stop using the port. This will prevent port locking on
	 * platforms like Linux.
	 */
	public synchronized void close()
	{
		if (portSerie != null)
		{
			portSerie.removeEventListener();
			portSerie.close();
		}
	}

	/**
	 * Handle an event on the serial port. Lecture des données, création d'une mesure et
	 * transmission de la mesure à l'application
	 */
	public synchronized void serialEvent(SerialPortEvent oEvent)
	{
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE)
		{
			try
			{
				String ligneRecue = entree.readLine();
				this.stringVersMesure(ligneRecue);
				// TODO : Si la ligne signale la fin de la capture, stopper et signaler
			}
			catch (Exception e)
			{
				System.err.println(e.toString());
			}
		}
	}

	private void stringVersMesure(String ligneRecue)
	{
		ArrayList tableauValeursMesure = new ArrayList();
		
		String valeurs[] = ligneRecue.split(",");
		
		if (valeurs.length == 5)
		{
			tableauValeursMesure.add(Float.parseFloat(valeurs[0])); // Accélération X
			tableauValeursMesure.add(Float.parseFloat(valeurs[1])); // Accélération Y
			tableauValeursMesure.add(Float.parseFloat(valeurs[2])); // Accélération Z
			tableauValeursMesure.add(Float.parseFloat(valeurs[3])); // Altitude
			tableauValeursMesure.add(Long.parseLong(valeurs[4])); // Temps
			
			this.controleur.ajouterMesure(new MesureSimple(tableauValeursMesure));
		}
	}
}