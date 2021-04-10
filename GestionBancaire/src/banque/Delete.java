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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Delete {

	private JFrame frame;
	private JTextField Idclient;
	private JMenuBar menuBar;
	private JMenu menuFile;
	private JMenu menuCreer;
	private JMenuItem creerCompte;
	private JMenuItem fileQuitter;
	private JMenu menuAfficher;
	private JMenuItem affichertToutCompte;
	private JMenu menuSupprimer;
	private JMenuItem supprimerCompte;
	private JMenuItem fileAccueil;
	private JLabel lblTitle;
	private JButton delete;
	private JButton cancel;
	private JLabel idCompteSupprimer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete window = new Delete();
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
	public Delete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(SystemColor.inactiveCaptionBorder);
		frame.setBounds(100, 100, 380, 379);
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
				if (JOptionPane.showConfirmDialog(frame, "Voulez-vous réelement retourner a l'accueil?", "MoKass Bank",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					Delete.this.frame.setVisible(false);
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
				Delete.this.frame.setVisible(false);
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
				Delete.this.frame.setVisible(false);
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
				Delete.this.frame.setVisible(false);
				Delete.main(null);
			}
		});
		supprimerCompte.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuSupprimer.add(supprimerCompte);

		lblTitle = new JLabel("Supprimer un compte");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 30));
		lblTitle.setBounds(12, 13, 338, 45);
		frame.getContentPane().add(lblTitle);

		Idclient = new JTextField();
		Idclient.setBounds(84, 173, 189, 22);
		frame.getContentPane().add(Idclient);
		Idclient.setColumns(10);

		delete = new JButton("Supprimer");
		delete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompteBancaire compte = new CompteBancaire();
				compte.supprimercompte(Idclient.getText());
				Delete.this.frame.setVisible(false);
				BanqueMoKass.main(null);
			}
		});
		delete.setBounds(18, 233, 332, 25);
		frame.getContentPane().add(delete);

		// bouton permettant d'effectuer la suppression d'un compte
		cancel = new JButton("Annuler");
		cancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(frame, "Voulez-vous réelement retourner a l'accueil banque?",//affiche un fênetre de dialogue
						" Banque MoKass", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {// permet d'effectuer une action selon si l'utilisateur clique sur oui ou non 
					Delete.this.frame.setVisible(false); //permet l'execution la fonction/méthode Delete du programme
					BanqueMoKass.main(null);
				}

			}
		});
		cancel.setBounds(18, 263, 332, 25);
		frame.getContentPane().add(cancel);

		idCompteSupprimer = new JLabel("Saississez le Numéro de compte du client");
		idCompteSupprimer.setHorizontalAlignment(SwingConstants.CENTER);
		idCompteSupprimer.setBounds(12, 123, 338, 16);
		frame.getContentPane().add(idCompteSupprimer);
	}
}