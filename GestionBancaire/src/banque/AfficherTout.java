/*Programme Banque
 * date : 20/5/2020
 * auteur : Victor Huguet
 * 
 * Le programme Banque permet de gestionner differants comptes 
 * 
 */
package banque;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;

public class AfficherTout {

	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu menuFile;
	private JMenu menuCreer;
	private JMenuItem creerCompte;
	private JMenuItem fileQuitter;
	private JMenuItem fileAccueil;
	private JMenu menuAfficher;
	private JMenuItem affichertToutCompte;
	private JMenu menuSupprimer;
	private JMenuItem supprimerCompte;
	private JButton btnRetour;
	private JScrollPane scrollPane;
	private JLabel lblAffichageDesComptes;
	static JTable AffichageDesDonnéeDesCompte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfficherTout window = new AfficherTout();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AfficherTout() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(SystemColor.inactiveCaptionBorder);
		frame.setBounds(100, 100, 1200, 632);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


		/*
		 * Barre de Menu
		 */
		menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.inactiveCaptionBorder);
		frame.setJMenuBar(menuBar);

		menuFile = new JMenu("Menu");
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuFile.setBackground(SystemColor.inactiveCaptionBorder);
		menuBar.add(menuFile);

		/*
		 * Option Quitter dans la barre de menu
		 */
		fileQuitter = new JMenuItem("Quitter");
		fileQuitter.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		fileQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("quitter");
				if (JOptionPane.showConfirmDialog(frame, "Voulez-vous réelement quitter l'appli banque?", "MoKass Bank",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(1);
				}
			}
		});
		menuFile.add(fileQuitter);
		
		/*
		 * Option Accueil dans la barre de menu
		 */
		fileAccueil = new JMenuItem("Accueil");
		fileAccueil.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		fileAccueil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("quitter");
				if (JOptionPane.showConfirmDialog(frame, "Voulez-vous réelement retourner a  'accueil?", "MoKass Bank",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					 AfficherTout.this.frame.setVisible(false);
					 BanqueMoKass.main(null);
				}
			}
		});
		menuFile.add(fileAccueil);

		menuCreer = new JMenu("Creer");
		menuCreer.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuCreer.setBackground(SystemColor.inactiveCaptionBorder);
		menuBar.add(menuCreer);
		/*
		 * Option Ajouter un nouveau compte dans la barre de menu
		 */
		creerCompte = new JMenuItem("Nouveau Compte");
		creerCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfficherTout.this.frame.setVisible(false);
				Add.main(null);
			}
		});

		creerCompte.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuCreer.add(creerCompte);

		menuAfficher = new JMenu("Afficher");
		menuAfficher.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuAfficher.setBackground(SystemColor.inactiveCaptionBorder);
		menuBar.add(menuAfficher);

		/*
		 * Option affichage de tous les comptes dans la barre de menu
		 */

		affichertToutCompte = new JMenuItem("Tous les comptes");
		affichertToutCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfficherTout.this.frame.setVisible(false);
				AfficherTout.main(null);
			}
		});
		affichertToutCompte.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuAfficher.add(affichertToutCompte);

		menuSupprimer = new JMenu("Supprimer");
		menuSupprimer.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuSupprimer.setBackground(SystemColor.inactiveCaptionBorder);
		menuBar.add(menuSupprimer);
		/*
		 * Option suppression d'un compte dans la barre de menu
		 */
		supprimerCompte = new JMenuItem("Supprimer un compte");
		supprimerCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfficherTout.this.frame.setVisible(false);
				Delete.main(null);
			}
		});
		supprimerCompte.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuSupprimer.add(supprimerCompte);
		frame.getContentPane().setLayout(null);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 69, 1158, 471);
		frame.getContentPane().add(scrollPane);
		
		// permet d'afficher dans un tableau les donnée des personnes ayant créer un compte.
		
		AffichageDesDonnéeDesCompte = new JTable();
		AffichageDesDonnéeDesCompte.setForeground(new Color(0, 0, 0));
		AffichageDesDonnéeDesCompte.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		AffichageDesDonnéeDesCompte.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "NoCompte", "Id", "Nom", "Prenom",
				"Date de naissance", "Adresse", "Genre", "Type de Compte", "Solde", "Id 2(si Compte Join", "Taux(si Compte epargne)" }));
		scrollPane.setViewportView(AffichageDesDonnéeDesCompte);

		CompteBancaire compte = new CompteBancaire();
		compte.affichercompte();
		
		btnRetour = new JButton("Retour");
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfficherTout.this.frame.setVisible(false);
				BanqueMoKass.main(null);
			}
		});
		btnRetour.setBounds(835, 18, 226, 37);
		frame.getContentPane().add(btnRetour);
		
		lblAffichageDesComptes = new JLabel("Affichage des comptes");
		lblAffichageDesComptes.setFont(new Font("Dialog", Font.BOLD, 30));
		lblAffichageDesComptes.setBounds(432, 18, 360, 39);
		frame.getContentPane().add(lblAffichageDesComptes);
	}
}