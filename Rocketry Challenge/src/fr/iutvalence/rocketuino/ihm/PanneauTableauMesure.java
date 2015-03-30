package fr.iutvalence.rocketuino.ihm;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import fr.iutvalence.rocketuino.MesureSimple;

public class PanneauTableauMesure extends JTable
{
	private DefaultTableModel tableModel;
	private static final String LIGNES[] = { "Accélération X :", "Accélération Y :", "Accélération Z :",
			"Altitude :" };

	public PanneauTableauMesure()
	{
		super();
		
		this.tableModel = new DefaultTableModel();
		this.setModel(this.tableModel);

		this.tableModel.addColumn("", LIGNES);
		this.tableModel.addColumn("", new Object[] {});
		
		this.creer();
	}

	private void creer()
	{
		this.setBackground(Color.WHITE);
		this.setForeground(Color.DARK_GRAY);
		this.setShowGrid(false);
		this.setFont(new Font("Arial", Font.BOLD, 13));
		this.setEnabled(false);

		this.setRowHeight(25);

		DefaultTableCellRenderer rendererDroite = new DefaultTableCellRenderer();
		rendererDroite.setHorizontalAlignment(SwingConstants.RIGHT);

		this.getColumnModel().getColumn(0).setCellRenderer(rendererDroite);

		this.tableHeader.setResizingColumn(this.getColumnModel().getColumn(0));
		this.getColumnModel().getColumn(0).setWidth(110);

		this.tableHeader.setResizingColumn(this.getColumnModel().getColumn(1));
		this.getColumnModel().getColumn(1).setWidth(50);
	}

	public void actualiserMesure(MesureSimple mesure)
	{
		this.tableModel.setValueAt(mesure.getAccelerationX(), 0, 1);
		this.tableModel.setValueAt(mesure.getAccelerationY(), 1, 1);
		this.tableModel.setValueAt(mesure.getAccelerationZ(), 2, 1);
		this.tableModel.setValueAt(mesure.getAltitude(), 3, 1);
	}

	public void viderTableau()
	{
		this.tableModel.setValueAt(0, 0, 1);
		this.tableModel.setValueAt(0, 1, 1);
		this.tableModel.setValueAt(0, 2, 1);
		this.tableModel.setValueAt(0, 3, 1);
	}
}