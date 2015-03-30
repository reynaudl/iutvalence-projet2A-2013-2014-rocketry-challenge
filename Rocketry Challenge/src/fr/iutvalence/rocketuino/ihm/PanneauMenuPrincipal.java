package fr.iutvalence.rocketuino.ihm;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.iutvalence.rocketuino.ApplicationRocketruino;

public class PanneauMenuPrincipal extends JPanel implements ActionListener
{
	private final TacheAffichage tacheAffichage;
	private JLabel labelTitre;
	private JButton boutonEnVol;
	private JButton boutonPostVol;
	private JButton boutonQuitter;
	private JLabel labelTexte;
	
	public PanneauMenuPrincipal(TacheAffichage tacheAffichage)
	{
		this.tacheAffichage = tacheAffichage;
		this.labelTitre = this.creerJLabelTitre();
		this.boutonEnVol = this.creerJButtonEnVol();
		this.boutonPostVol = this.creerJButtonPostVol();
		this.boutonQuitter = this.creerJButtonQuitter();
		this.labelTexte = this.creerJLabelTexte();
		
		JPanel panneauChoixMode = new JPanel();
		panneauChoixMode.setOpaque(true);
		panneauChoixMode.setBackground(Color.WHITE);
		panneauChoixMode.setLayout(new BoxLayout(panneauChoixMode, BoxLayout.X_AXIS));
		panneauChoixMode.setBorder(new EmptyBorder(100, 0, 20, 0));
		
		panneauChoixMode.add(this.boutonEnVol);
		panneauChoixMode.add(this.boutonPostVol);
		
		this.setOpaque(true);
		this.setBackground(Color.WHITE);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.add(this.labelTitre);
		this.add(panneauChoixMode);
		this.add(this.labelTexte);
		this.add(this.boutonQuitter);
	}

	private JLabel creerJLabelTitre()
	{
		JLabel titre = new JLabel("Bienvenue sur " + ApplicationRocketruino.NOM_APPLICATION + " !");
		titre.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		titre.setBorder(new EmptyBorder(100, 0, 0, 0));
		titre.setFont(new Font("Segoe UI", Font.PLAIN, 36));
		titre.setForeground(new Color(91, 60, 17));
		return titre;
	}

	private JButton creerJButtonPostVol()
	{
		JButton boutonPostVol = new JButton("Mode post-vol");
		boutonPostVol.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		boutonPostVol.setBorder(new EmptyBorder(10, 80, 10, 80));
		boutonPostVol.setBackground(Color.LIGHT_GRAY);
		boutonPostVol.setCursor(new Cursor(Cursor.HAND_CURSOR));
		boutonPostVol.addActionListener(this);
		boutonPostVol.setFocusable(false);
		return boutonPostVol;
	}

	private JButton creerJButtonEnVol()
	{
		JButton boutonEnVolVol = new JButton("Mode en vol");
		boutonEnVolVol.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		boutonEnVolVol.setBorder(new EmptyBorder(10, 80, 10, 80));
		boutonEnVolVol.setBackground(Color.LIGHT_GRAY);
		boutonEnVolVol.setCursor(new Cursor(Cursor.HAND_CURSOR));
		boutonEnVolVol.addActionListener(this);
		return boutonEnVolVol;
	}

	private JButton creerJButtonQuitter()
	{
		JButton boutonQuitter = new JButton("Quitter");
		boutonQuitter.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		boutonQuitter.setBorder(new EmptyBorder(10, 50, 10, 50));
		boutonQuitter.setBackground(Color.LIGHT_GRAY);
		boutonQuitter.setCursor(new Cursor(Cursor.HAND_CURSOR));
		boutonQuitter.addActionListener(this);
		boutonQuitter.setFocusable(false);
		return boutonQuitter;
	}

	private JLabel creerJLabelTexte()
	{
		// TODO
		JLabel texte = new JLabel("Explications sur les 2 modes à venir...");
		texte.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		return texte;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		JComponent source = (JComponent) e.getSource();
		if (source == this.boutonEnVol)
			this.tacheAffichage.lancerAffichageEnVol();

		if (source == this.boutonPostVol)
			this.tacheAffichage.lancerAffichagePostVol();
		
		if (source == this.boutonQuitter)
			if (JOptionPane.showOptionDialog(tacheAffichage.getFenetre(), "Etes-vous sûr de vouloir quitter l'application ?", "Quitter - confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Oui !", "Non"}, "Oui !") == JOptionPane.OK_OPTION)
				System.exit(0);
	}
}
