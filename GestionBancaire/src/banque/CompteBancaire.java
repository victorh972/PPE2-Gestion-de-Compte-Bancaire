/* Programme Banque
 * date : 20/5/2020
 * auteur :Victor Huguet
 * 
 * Le programme Banque permet de gestionner differants comptes 
 * 
 */
package banque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/////////class mere compte bancaire
public class CompteBancaire {
	/**
	 * declaration des variables
	 */
	private long noCompte;
	/**
	 * 
	 */
	private String TypeCompte;

	/**
	 * 
	 */
	private double solde;

	public void creerCompte(JFrame frame, JFrame frameConfirm, JComboBox texttype, JTextField textid,
			JTextField textnom, JTextField textprenom,JTextField textdob, JTextField textsexe, JTextField textadresse,
			JTextField textid2, JTextField texttaux, String[] array) {
		String compte = texttype.getSelectedItem().toString().toUpperCase();
		int i = 0;

		try {
			File banque = new File("banque.dat");
			if (!banque.exists()) {
				banque.createNewFile();
			}
			switch (compte) {
			case "JOINT":
				CompteJoint joint = new CompteJoint();
				array = (joint.creerCompte(textid.getText(), textnom.getText(), textprenom.getText(),
						textdob.getText(), textsexe.getText(), textadresse.getText(), texttype.getSelectedItem().toString(),
						textid2.getText(), "0"));

				FileWriter fileWritterjoint = new FileWriter(banque.getName(), true);
				BufferedWriter bwjoint = new BufferedWriter(fileWritterjoint);
				for (i = 0; i < array.length; i++) {
					bwjoint.write(array[i]);
				}
				bwjoint.close();

				JOptionPane.showMessageDialog(frameConfirm, "Utilisateur crée");
				frame.setVisible(false);
				BanqueMoKass.main(null);
				break;

			case "COURANT":
				CompteCourant courant = new CompteCourant();
				array = (courant.creerCompte(textid.getText(), textnom.getText(), textprenom.getText(),
						textdob.getText(), textsexe.getText(), textadresse.getText(), texttype.getSelectedItem().toString(), "0"));

				FileWriter fileWrittercourant = new FileWriter(banque.getName(), true);
				BufferedWriter bwcourant = new BufferedWriter(fileWrittercourant);
				for (i = 0; i < array.length; i++) {
					bwcourant.write(array[i]);
				}
				bwcourant.close();

				JOptionPane.showMessageDialog(frameConfirm, "Utilisateur crée");
				frame.setVisible(false);
				BanqueMoKass.main(null);
				break;

			case "EPARGNE":
				CompteEpargne epargne = new CompteEpargne();
				array = (epargne.creerCompte(textid.getText(), textnom.getText(), textprenom.getText(),
						textdob.getText(), textsexe.getText(), textadresse.getText(), texttype.getSelectedItem().toString(),
						texttaux.getText(), "0"));

				FileWriter fileWritterepargne = new FileWriter(banque.getName(), true);
				BufferedWriter bwepargne = new BufferedWriter(fileWritterepargne);
				for (i = 0; i < array.length; i++) {
					bwepargne.write(array[i]);
				}
				bwepargne.close();

				JOptionPane.showMessageDialog(frameConfirm, "Utilisateur crée");
				frame.setVisible(false);
				BanqueMoKass.main(null);
				break;

			default:
				JOptionPane.showMessageDialog(frameConfirm, "Erreur type de compte incorrect");
			}
		} catch (IOException e1) {
			e1.printStackTrace();

		}

	}

	@SuppressWarnings("resource")
	public void affichercompte() {

		String filePath = "banque.dat";
		File file = new File(filePath);

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			DefaultTableModel model = (DefaultTableModel) AfficherTout.AffichageDesDonnéeDesCompte.getModel();
			Object[] lines = br.lines().toArray();

			for (int i = 0; i < lines.length; i++) {
				String[] row = lines[i].toString().split(" ");
				model.addRow(row);
			}

		} catch (FileNotFoundException ex) {

		}

	}

	@SuppressWarnings({ "resource", "rawtypes" })
	public void affichertype(JComboBox Type, JTable table) {
		File writter = new File("search.dat");
		try {
			if (writter.exists()) {
				writter.delete();
				writter.createNewFile();
			}

			if (!writter.exists()) {
				writter.createNewFile();
			}

			FileWriter fileWritter = new FileWriter(writter.getName(), false);
			File verificator = new File("banque.dat");
			Scanner in = null;
			in = new Scanner(verificator);
			while (in.hasNext()) {
				String line = in.nextLine();
				if (line.contains(Type.getSelectedItem().toString().toUpperCase())) {
					fileWritter.write(line);
					fileWritter.write("\n");
				}

			}
			fileWritter.close();
		} catch (Exception f) {
			f.printStackTrace();
		}

		String filePath = "search.dat";
		File file = new File(filePath);

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			Object[] lines = br.lines().toArray();

			for (int i = 0; i < lines.length; i++) {
			}

			for (int i = 0; i < lines.length; i++) {
				String[] row = lines[i].toString().split(" ");
				model.addRow(row);
			}

		} catch (FileNotFoundException ex) {

		}
	}

	@SuppressWarnings({ "resource" })
	void supprimercompte(String string) {
		JFrame frame = new JFrame("Supprimer");
		File writter = new File("temp.dat");
		try {
			if (writter.exists()) {
				writter.delete();
				writter.createNewFile();
			}

			if (!writter.exists()) {
				writter.createNewFile();
			}

			FileWriter fileWritter = new FileWriter(writter.getName(), false);
			File read = new File("banque.dat");
			Scanner scan = null;
			scan = new Scanner(read);
			while (scan.hasNext()) {
				String line = scan.nextLine();
				if (!line.contains(string)) {
					fileWritter.write(line);
					fileWritter.write("\n");
				}

			}
			fileWritter.close();

			PrintWriter banque = new PrintWriter("banque.dat");
			banque.print("");
			banque.close();

		} catch (Exception f) {
			f.printStackTrace();
		}

		File modify = new File("banque.dat");
		try {
			if (modify.exists()) {
				modify.delete();
				modify.createNewFile();
			}

			if (!modify.exists()) {
				modify.createNewFile();
			}
			FileWriter filereWritter = new FileWriter(modify.getName(), false);
			File readagain = new File("temp.dat");
			Scanner rescan = null;
			rescan = new Scanner(readagain);
			while (rescan.hasNext()) {
				String reline = rescan.nextLine();
				filereWritter.write(reline);
				filereWritter.write("\n");

			}
			filereWritter.close();

		} catch (Exception f) {
			f.printStackTrace();
		}

		JOptionPane.showMessageDialog(frame, "Suppression terminé");
	}

	public long getNoCompte() {
		return noCompte;
	}

	public void setNoCompte(long noCompte) {
		this.noCompte = noCompte;
	}

	public String getTypeCompte() {
		return TypeCompte;
	}

	public void setTypeCompte(String typeCompte) {
		TypeCompte = typeCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}
}