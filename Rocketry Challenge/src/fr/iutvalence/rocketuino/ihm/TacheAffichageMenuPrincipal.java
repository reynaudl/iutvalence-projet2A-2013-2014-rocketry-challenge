package fr.iutvalence.rocketuino.ihm;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import fr.iutvalence.rocketuino.ApplicationRocketruino;

public class TacheAffichageMenuPrincipal implements Runnable, ActionListener
{
	public int largeurFenetre;
	public int hauteurFenetre;
	
	private JLabel labelTitre;
	private JButton boutonEnVol;
	private JButton boutonPostVol;
	private JButton boutonQuitter;
	private JLabel labelTexte;
	private JFrame fenetre;
	
	public TacheAffichageMenuPrincipal(int largeurFenetre, int hauteurFenetre)
	{
		this.largeurFenetre = largeurFenetre;
		this.hauteurFenetre = hauteurFenetre;
		
		this.fenetre = new JFrame();
		this.fenetre.setTitle(ApplicationRocketruino.NOM_APPLICATION);
		this.fenetre.setSize(this.largeurFenetre, this.hauteurFenetre);
		this.fenetre.setLocationRelativeTo(null);
		this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void lancerAffichagePostVol()
	{
		this.changerContenuFenetre(new AffichagePostVol(this.largeurFenetre, this.hauteurFenetre));
	}
	
	private void lancerAffichageEnVol()
	{
		// TODO
	}

	@Override
	public void run()
	{
		JPanel panneauPrincipal = this.creerPanneauMenuPrincipal();
		this.changerContenuFenetre(panneauPrincipal);
	}

	private JPanel creerPanneauMenuPrincipal()
	{
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
		
		JPanel panneauPrincipal = new JPanel();
		panneauPrincipal.setOpaque(true);
		panneauPrincipal.setBackground(Color.WHITE);
		panneauPrincipal.setLayout(new BoxLayout(panneauPrincipal, BoxLayout.Y_AXIS));

		panneauPrincipal.add(this.labelTitre);
		panneauPrincipal.add(panneauChoixMode);
		panneauPrincipal.add(this.labelTexte);
		panneauPrincipal.add(this.boutonQuitter);
		
		return panneauPrincipal;
	}

	private void changerContenuFenetre(JComponent composant)
	{
		this.fenetre.getContentPane().removeAll();
		this.fenetre.getContentPane().add(composant);
		this.fenetre.setVisible(true);
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
		JLabel texte = new JLabel("Explications sur les 2 modes à venir..."); // TODO
		texte.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		return texte;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		JComponent source = (JComponent) e.getSource();
		if (source == this.boutonEnVol)
			this.lancerAffichageEnVol();

		if (source == this.boutonPostVol)
			this.lancerAffichagePostVol();
		
		if (source == this.boutonQuitter)
			if (JOptionPane.showConfirmDialog(this.fenetre, "Etes-vous sûr de vouloir quitter l'application ?", "Quitter - confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
				this.fenetre.dispose();
	}
}
