/* Programme Add
 * date : 20/5/2020
 * auteur : Victor
 * 
 * Le programme Add permet de gestionner differants comptes 
 * 
 */

package banque;

///importation des bibliotheque java
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
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

////////////classe creer
public class Add {

	//////////////// declaration des variable
	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu menuFile;
	private JMenu menuCreer;
	private JMenuItem creerCompte;
	private JMenuItem fileAccueil;
	private JMenuItem fileQuitter;
	private JMenu menuAfficher;
	private JMenuItem affichertToutCompte;
	private JMenu menuSupprimer;
	private JMenuItem supprimerCompte;
	private JLabel lblId;
	private JTextField textId;
	private JButton btnReset;
	private JButton btnAdd;
	private JButton btnCancel;
	private JLabel lblNom;
	private JTextField textNom;
	private JLabel lblPrenom;
	private JTextField textPrenom;
	private JLabel lblDateNaissance;
	private JTextField textDateNaissance;
	private JLabel lblGenre;
	private JTextField textGenre;
	private JLabel lblAdresse;
	private JTextField textAdresse;
	private JLabel lblTypeCompte;
	@SuppressWarnings("rawtypes")
	private JComboBox JcomboType;
	private JLabel lblId2;
	private JTextField textId2;
	private JLabel lblTaux;
	private JTextField textTaux;
	private JLabel lblTitle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add window = new Add();
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
	public Add() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frame.getContentPane().setLayout(null);

		lblId = new JLabel("Id :");
		lblId.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblId.setBounds(12, 57, 428, 25);
		frame.getContentPane().add(lblId);

		textId = new JTextField();
		textId.setHorizontalAlignment(SwingConstants.LEFT);
		textId.setColumns(10);
		textId.setBounds(12, 93, 507, 25);
		frame.getContentPane().add(textId);

		lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNom.setBounds(12, 129, 428, 25);
		frame.getContentPane().add(lblNom);

		textNom = new JTextField();
		textNom.setHorizontalAlignment(SwingConstants.LEFT);
		textNom.setFont(new Font("Dialog", Font.PLAIN, 13));
		textNom.setColumns(10);
		textNom.setBounds(12, 165, 507, 25);
		frame.getContentPane().add(textNom);

		lblPrenom = new JLabel("Prénom :");
		lblPrenom.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPrenom.setBounds(12, 201, 428, 25);
		frame.getContentPane().add(lblPrenom);

		textPrenom = new JTextField();
		textPrenom.setHorizontalAlignment(SwingConstants.LEFT);
		textPrenom.setFont(new Font("Dialog", Font.PLAIN, 13));
		textPrenom.setColumns(10);
		textPrenom.setBounds(12, 237, 507, 25);
		frame.getContentPane().add(textPrenom);

		lblDateNaissance = new JLabel("Date de naissance (jj-mm-yyyy) :");
		lblDateNaissance.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDateNaissance.setBounds(12, 273, 428, 25);
		frame.getContentPane().add(lblDateNaissance);

		textDateNaissance = new JTextField();
		textDateNaissance.setHorizontalAlignment(SwingConstants.LEFT);
		textDateNaissance.setFont(new Font("Dialog", Font.PLAIN, 13));
		textDateNaissance.setColumns(10);
		textDateNaissance.setBounds(12, 309, 507, 25);
		frame.getContentPane().add(textDateNaissance);

		lblGenre = new JLabel("Genre:");
		lblGenre.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGenre.setBounds(12, 345, 428, 25);
		frame.getContentPane().add(lblGenre);

		textGenre = new JTextField();
		textGenre.setHorizontalAlignment(SwingConstants.LEFT);
		textGenre.setFont(new Font("Dialog", Font.PLAIN, 13));
		textGenre.setColumns(10);
		textGenre.setBounds(12, 381, 507, 25);
		frame.getContentPane().add(textGenre);

		lblAdresse = new JLabel("Adresse:");
		lblAdresse.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAdresse.setBounds(12, 417, 428, 25);
		frame.getContentPane().add(lblAdresse);

		textAdresse = new JTextField();
		textAdresse.setHorizontalAlignment(SwingConstants.LEFT);
		textAdresse.setFont(new Font("Dialog", Font.PLAIN, 13));
		textAdresse.setColumns(10);
		textAdresse.setBounds(12, 453, 507, 25);
		frame.getContentPane().add(textAdresse);

		lblTypeCompte = new JLabel("Type de compte:");
		lblTypeCompte.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTypeCompte.setBounds(12, 489, 428, 25);
		frame.getContentPane().add(lblTypeCompte);

		JcomboType = new JComboBox();
		JcomboType.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		JcomboType.setBounds(12, 525, 507, 26);
		frame.getContentPane().add(JcomboType);
		JcomboType.addItem("COURANT");
		JcomboType.addItem("EPARGNE");
		JcomboType.addItem("JOINT");

		lblId2 = new JLabel("Si c'est un Compte Joint Veuillez Préciser l'Id de cette personne");
		lblId2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblId2.setBounds(10, 562, 521, 25);
		frame.getContentPane().add(lblId2);

		textId2 = new JTextField();
		textId2.setColumns(10);
		textId2.setBounds(12, 598, 507, 25);
		frame.getContentPane().add(textId2);

		lblTaux = new JLabel("Si c'est un Compte Epargne rentrer le Taux en %");
		lblTaux.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTaux.setBounds(12, 634, 428, 25);
		frame.getContentPane().add(lblTaux);

		textTaux = new JTextField();
		textTaux.setHorizontalAlignment(SwingConstants.LEFT);
		textTaux.setColumns(10);
		textTaux.setBounds(12, 670, 507, 25);
		frame.getContentPane().add(textTaux);

		btnReset = new JButton("Reinitialiser");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textId.setText("");
				textNom.setText("");
				textPrenom.setText("");
				textDateNaissance.setText("");
				textGenre.setText("");
				textAdresse.setText("");
				textId2.setText("");
				textTaux.setText("");
			}
		});
		btnReset.setFont(new Font("Dialog", Font.BOLD, 18));
		btnReset.setBounds(12, 706, 135, 36);
		frame.getContentPane().add(btnReset);

		btnCancel = new JButton("Annuler");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("annuler");
				if (JOptionPane.showConfirmDialog(frame, "Voulez-vous Annuler?", "Banque MoKass",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
							Add.this.frame.setVisible(false);
							BanqueMoKass.main(null);
					}
			}
		});
		btnCancel.setFont(new Font("Dialog", Font.BOLD, 18));
		btnCancel.setBounds(183, 706, 135, 36);
		frame.getContentPane().add(btnCancel);

		btnAdd = new JButton("Ajouter");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompteBancaire compte = new CompteBancaire();
				JFrame frameConfirm = new JFrame();
				String[] array = {};
				compte.creerCompte(frame, frameConfirm, JcomboType, textId, textNom, textPrenom, textDateNaissance,
						textGenre, textAdresse, textId2, textTaux, array);
			}
		});
		btnAdd.setFont(new Font("Dialog", Font.BOLD, 18));
		btnAdd.setBounds(351, 706, 135, 36);
		frame.getContentPane().add(btnAdd);

		lblTitle = new JLabel("Créer un Compte");
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 24));
		lblTitle.setBounds(135, 12, 210, 36);
		frame.getContentPane().add(lblTitle);
		frame.setBackground(SystemColor.inactiveCaptionBorder);
		frame.setBounds(100, 100, 551, 813);
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
				if (JOptionPane.showConfirmDialog(frame, "Voulez-vous réelement quitter l'appli banque?",
						"Banque MoKass", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
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
				if (JOptionPane.showConfirmDialog(frame, "Voulez-vous réelement retourner a l'accueil?",
						" Banque MoKass", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					Add.this.frame.setVisible(false);
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
				Add.this.frame.setVisible(false);
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
				Add.this.frame.setVisible(false);
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
				Add.this.frame.setVisible(false);
				Delete.main(null);
			}
		});
		supprimerCompte.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuSupprimer.add(supprimerCompte);

	}
}