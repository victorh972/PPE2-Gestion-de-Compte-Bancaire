/* Programme Banque
 * date : 20/5/2020
 * auteur : Victor Huguet
 * 
 * Le programme Banque permet de gerer différents comptes
 */

package banque;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CompteEpargne extends CompteCourant {
	private JFrame frame;
	public float taux;

	public String[] creerCompte(String id, String nom, String prenom, String DateDeNaissance, String genre, String adresse,
			String typeCompte, String taux, String solde) {
		frame = new JFrame();
		String[] split;
		String idConvert = id;
		String noCompteConvert = "000" + idConvert;
		int jj, mm, aaaa;
	    long noCompte = Long.valueOf(noCompteConvert);
		solde = "0";
		typeCompte = "EPARGNE";
		CompteEpargne client = new CompteEpargne();

		try {
			client.id = Long.parseLong(id);
			client.setNoCompte(noCompte);
			client.nom = nom;
			client.prenom = prenom;
			client.adresse = adresse;
			client.genre = genre;
			client.setTypeCompte(typeCompte);
			client.setSolde(Double.parseDouble(solde));
			client.taux = Float.parseFloat(taux);

			split = DateDeNaissance.split("-");

			jj = Integer.parseInt(split[0]);
			mm = Integer.parseInt(split[1]);
			aaaa = Integer.parseInt(split[2]);

			if (jj < 0 || mm < 0 || aaaa < 1900) {
				JOptionPane.showMessageDialog(frame, "date invalide...veuillez réesayer");
			}

			if (jj > 31 || mm > 12 || aaaa > 2100) {
				JOptionPane.showMessageDialog(frame, "date invalide...veuillez réesayer");
			}

			client.DateDeNaissance = DateDeNaissance;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, "Erreur caractères invalides détecté...veuillez réesayer");
		}

		String[] tabEpargne = { "000" + String.valueOf(client.getNoCompte()), " ", String.valueOf(client.id), " ",
				client.nom, " ", client.prenom, " ", client.DateDeNaissance, " ", client.adresse, " ", client.genre, " ",
				client.getTypeCompte(), " ", String.valueOf(client.getSolde()), " ", "-", " ",
				String.valueOf(client.taux), "\n" };

		return tabEpargne;
	}
};