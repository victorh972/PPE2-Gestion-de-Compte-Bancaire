package banque;
/*
 * Banque.java
 * 
 * programme créé par : Victor Huguet
 * 
 * 
 * simmulation d'un gestionnaire d'un compte Bancaire.
 * 
 * 
 * 
 */

import java.util.Scanner;

public class Banque {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Bank myBank = new Bank();

		int user_choice = 2;
		try {
			do {
				// afficher le menu à l'utilisateur.
				// demander à l'utilisateur son choix et valider (entre 1 et 5).
				System.out.println();
				System.out.println("1) Ouvrir un nouveau compte Bancaire ");
				System.out.println("2) effectuer un dépôt");
				System.out.println("3) effectuer un retrait");
				System.out.println("4) afficher données du compte");
				System.out.println("5) Quitter");
				System.out.println();
				System.out.print("Entrer votre choix [1-5]: ");
				user_choice = s.nextInt();
				switch (user_choice) {
				case 1:
					System.out.println("Entrer le prénom :");
					String prenom = s.next();

					System.out.println("Entrer le nom");
					String nom = s.next();

					System.out.println("entrer la date de naissance");
					String dateNaissance = s.next();

					System.out.println("Entrer le genre :");
					String genre = s.next();

					System.out.println("Entrer adresse du domicile");
					String Adresse = s.next();

					System.out.println("Entrer le type de compte :");
					String typeCompte = s.next();

					System.out.println("entrer la somme de dépôt d'ouverture :");
					double solde = s.nextDouble();
					System.out.println("votre compte a été créé  et enregistré comme compte numéro : "
							+ myBank.openNewAccount(prenom, nom, dateNaissance, genre, Adresse, typeCompte, solde));
					break;
				case 2:
					System.out.println("entrer le numéro du compte");
					int numCompteDepot = s.nextInt();
					System.out.println("entrer le montant à déposer");
					double depot = s.nextDouble();
					myBank.depositTo(numCompteDepot, depot);
					break;
				case 3:
					System.out.println("entrer le numéro du compte :");
					int numCompteRetrait = s.nextInt();
					System.out.println("entrer le montant à retirer");
					double retrait = s.nextDouble();
					myBank.withdrawFrom(numCompteRetrait,retrait);
					break;
				case 4:
					System.out.println("entrer le numéro du compte");
					int numCompte = s.nextInt();
					myBank.printAccountInfo(numCompte);
					break;
				case 5:

					System.exit(0);
				}
			} while (user_choice != '6'); // si l'utilisateur rentre un choix supérieur ou égale a 6, le programme réaffiche les choix,
		} catch (Exception e) {			// jusqu'à ce que l'utilisateur rentre le choix correcte.
			System.out.println(" ERREUR !!! Entrez une valeur convenable !!!");// si l'utilisateur rentre un caractère particulier
			System.exit(1);													   // le programme affiche un message et s'arrete il faudra donc le relancer.
		}
	}

	static class Bank {
		private BankAccount[] accounts; // tous les comptes bancaires de cette banque
		private int numOfAccounts = 5; // le nombre de comptes bancaires de la banque

		// Constructor: le nouvel objet 'banque', initialisé ne contient pas encore de
		// compte
		public Bank() {
			accounts = new BankAccount[5];
			numOfAccounts = 0;
		}

		// Lorsque l'utilisateur a entré ses informations et son solde de départ,
		// un nouveau compte est créé.
		// Un numéro de compte est alors attribué. Il ajoute également ce
		// compte à la liste des comptes
		// dans l'objet s'appelant BankAccount.
		public int openNewAccount(String prenom, String nom, String dateNaissance, String genre, String Adresse,
				String typeCompte, double solde) {

			BankAccount b = new BankAccount(prenom, nom, solde);
			accounts[numOfAccounts] = b;
			numOfAccounts++;
			return b.getAccountNum();
		}

		// effectue un retrait du montant indiqué dans le compte dont le numéro est donné. 
		//Si le compte n'existe pas un message d'erreur s'affichera.
		public void withdrawFrom(int accountNum, double amount) {
			for (int i = 0; i < numOfAccounts; i++) {
				if (accountNum == accounts[i].getAccountNum()) {
					accounts[i].withdraw(amount);
					return;
				}
			}
			System.out.println("Numéro de compte incorrect.");
		}

		// faire un dépôt de la somme indiquée au compte dont le numéro est indiqué. Si
		// si le compte n'existe pas, un message s'affichera.
		
		public void depositTo(int accountNum, double amount) {
			for (int i = 0; i < numOfAccounts; i++) {
				if (accountNum == accounts[i].getAccountNum()) {
					accounts[i].deposit(amount);
					return;
				}
			}
			System.out.println("numéro de compte incorrect");
		}

		// Afficher le numéro de compte, le nom du client et le solde du compte
		// dont
		// le numéro de compte est donné. si le compte est non existant dans la banque
		// un message devrait s'afficher
		public void printAccountInfo(int accountNum) {
			for (int i = 0; i < numOfAccounts; i++) {
				if (accountNum == accounts[i].getAccountNum()) {
					System.out.println(accounts[i].getAccountInfo());
					return;
				}
			}
			System.out.println("numéro de compte incorrect");
		}
		
	}
	
	static class BankAccount {

		private int accountNum;
		private String customerName;
		private String customerSurname;
		private double balance;
		private static int noOfAccounts = 0;
		
		// permet de récupérer les information du compte et de l'afficher à l'utilisateur.
		public String getAccountInfo() {
			return "compte numéro: " + accountNum + "\nPrenom: " + customerName + "\nNom: " + customerSurname
					+ "\nSolde:" + balance + "\n";
		}
		// permet d'organisé l'affichage des informations du compte de l'utilisateur, quand celui-ci veut voir la solde de son compte bancaire.
		public BankAccount(String prenom, String nom, double solde) {
			customerName = prenom;
			customerSurname = nom;
			balance = solde;
			noOfAccounts++;
			accountNum = noOfAccounts;
		}

		public int getAccountNum() {
			return accountNum;
		}
		
		//vérifie et renvoie un message à l'utilisateur si le dépot à pu se faire où si l'utilisateur à entrées des mauvaises valeurs
		public void deposit(double amount) {

			if (amount <= 0) {
				System.out.println("le montant à déposer doit être positif et supérieur à 0");
				
			} else if (amount > 0) {
				System.out.println("montant déposé avec succès ");
				balance = balance + amount;
			}
		}
		// vérifie et renvoie un message à l'utilisateur si le retrait effectuer à pu se faire où non.
		public void withdraw(double amount) {
			if (amount <= 0) {
				System.out.println("Le montant à retirer doit être positif et supérieur à 0");
				return;
			} else if (amount > 0) {
				System.out.println("montant retiré avec succès");
				balance = balance - amount;
			} else {
				if (balance < amount) {
					System.out.println("Solde insuffisant");
					

				}
			}
		}

	}// fin de la classe

}
