/* Programme Banque
 * date : 20/5/2020
 * auteur : Victor Huguet
 * 
 * Le programme Banque permet de gestionner differants comptes 
 */

package banque;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

////////compte courant joint classe fille de compte courant
public class CompteJoint extends CompteCourant {
	private JFrame frame;
	/*
	 * declaration des variables
	 */
	private long idJoint;

	public long getIdJoint() {
		return idJoint;
	}

	public void setIdJoint(long idJoint) {
		this.idJoint = idJoint;
	}

////////////methode creation compte
	public String[] creerCompte(String id, String Nom, String Prenom, String DateDeNaissance,String genre, String adresse,
			String typeCompte, String id2, String solde) {

		frame = new JFrame();
		String[] split;
		String idConvert = id;
		String noCompteConvert = "000" + idConvert;
		int jj, mm, aaaa;
	    long noCompte = Long.valueOf(noCompteConvert);
		solde = "0";
		typeCompte = "JOINT";
		CompteJoint client = new CompteJoint();

		try {
			/////////// afffectation valeurs
			client.id = Long.parseLong(id);
			client.setIdJoint(Long.parseLong(id2));
			client.setNoCompte(noCompte);
			client.nom = Nom;
			client.prenom = Prenom;
			client.adresse = adresse;
			client.genre = genre;
			client.setTypeCompte(typeCompte);
			client.setSolde(Double.parseDouble(solde));

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

		/////////// retourne TabJoint

		String[] TabJoint = { "000" + String.valueOf(client.getNoCompte()), " ", String.valueOf(client.id), " ",
				client.nom, " ", client.prenom, " ", client.DateDeNaissance, " ", client.adresse, " ", client.genre, " ",
				client.getTypeCompte(), " ", String.valueOf(client.getSolde()), " ",
				String.valueOf(client.getIdJoint()), " ", "-", "\n" };

		return TabJoint;

	}
};