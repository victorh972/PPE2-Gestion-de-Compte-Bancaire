package banque;
/*
 * Banque.java
 * 
 * programme cr�� par : Victor Huguet
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
				// afficher le menu � l'utilisateur.
				// demander � l'utilisateur son choix et valider (entre 1 et 5).
				System.out.println();
				System.out.println("1) Ouvrir un nouveau compte Bancaire ");
				System.out.println("2) effectuer un d�p�t");
				System.out.println("3) effectuer un retrait");
				System.out.println("4) afficher donn�es du compte");
				System.out.println("5) Quitter");
				System.out.println();
				System.out.print("Entrer votre choix [1-5]: ");
				user_choice = s.nextInt();
				switch (user_choice) {
				case 1:
					System.out.println("Entrer le pr�nom :");
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

					System.out.println("entrer la somme de d�p�t d'ouverture :");
					double solde = s.nextDouble();
					System.out.println("votre compte a �t� cr��  et enregistr� comme compte num�ro : "
							+ myBank.openNewAccount(prenom, nom, dateNaissance, genre, Adresse, typeCompte, solde));
					break;
				case 2:
					System.out.println("entrer le num�ro du compte");
					int numCompteDepot = s.nextInt();
					System.out.println("entrer le montant � d�poser");
					double depot = s.nextDouble();
					myBank.depositTo(numCompteDepot, depot);
					break;
				case 3:
					System.out.println("entrer le num�ro du compte :");
					int numCompteRetrait = s.nextInt();
					System.out.println("entrer le montant � retirer");
					double retrait = s.nextDouble();
					myBank.withdrawFrom(numCompteRetrait,retrait);
					break;
				case 4:
					System.out.println("entrer le num�ro du compte");
					int numCompte = s.nextInt();
					myBank.printAccountInfo(numCompte);
					break;
				case 5:

					System.exit(0);
				}
			} while (user_choice != '6'); // si l'utilisateur rentre un choix sup�rieur ou �gale a 6, le programme r�affiche les choix,
		} catch (Exception e) {			// jusqu'� ce que l'utilisateur rentre le choix correcte.
			System.out.println(" ERREUR !!! Entrez une valeur convenable !!!");// si l'utilisateur rentre un caract�re particulier
			System.exit(1);													   // le programme affiche un message et s'arrete il faudra donc le relancer.
		}
	}

	static class Bank {
		private BankAccount[] accounts; // tous les comptes bancaires de cette banque
		private int numOfAccounts = 5; // le nombre de comptes bancaires de la banque

		// Constructor: le nouvel objet 'banque', initialis� ne contient pas encore de
		// compte
		public Bank() {
			accounts = new BankAccount[5];
			numOfAccounts = 0;
		}

		// Lorsque l'utilisateur a entr� ses informations et son solde de d�part,
		// un nouveau compte est cr��.
		// Un num�ro de compte est alors attribu�. Il ajoute �galement ce
		// compte � la liste des comptes
		// dans l'objet s'appelant BankAccount.
		public int openNewAccount(String prenom, String nom, String dateNaissance, String genre, String Adresse,
				String typeCompte, double solde) {

			BankAccount b = new BankAccount(prenom, nom, solde);
			accounts[numOfAccounts] = b;
			numOfAccounts++;
			return b.getAccountNum();
		}

		// effectue un retrait du montant indiqu� dans le compte dont le num�ro est donn�. 
		//Si le compte n'existe pas un message d'erreur s'affichera.
		public void withdrawFrom(int accountNum, double amount) {
			for (int i = 0; i < numOfAccounts; i++) {
				if (accountNum == accounts[i].getAccountNum()) {
					accounts[i].withdraw(amount);
					return;
				}
			}
			System.out.println("Num�ro de compte incorrect.");
		}

		// faire un d�p�t de la somme indiqu�e au compte dont le num�ro est indiqu�. Si
		// si le compte n'existe pas, un message s'affichera.
		
		public void depositTo(int accountNum, double amount) {
			for (int i = 0; i < numOfAccounts; i++) {
				if (accountNum == accounts[i].getAccountNum()) {
					accounts[i].deposit(amount);
					return;
				}
			}
			System.out.println("num�ro de compte incorrect");
		}

		// Afficher le num�ro de compte, le nom du client et le solde du compte
		// dont
		// le num�ro de compte est donn�. si le compte est non existant dans la banque
		// un message devrait s'afficher
		public void printAccountInfo(int accountNum) {
			for (int i = 0; i < numOfAccounts; i++) {
				if (accountNum == accounts[i].getAccountNum()) {
					System.out.println(accounts[i].getAccountInfo());
					return;
				}
			}
			System.out.println("num�ro de compte incorrect");
		}
		
	}
	
	static class BankAccount {

		private int accountNum;
		private String customerName;
		private String customerSurname;
		private double balance;
		private static int noOfAccounts = 0;
		
		// permet de r�cup�rer les information du compte et de l'afficher � l'utilisateur.
		public String getAccountInfo() {
			return "compte num�ro: " + accountNum + "\nPrenom: " + customerName + "\nNom: " + customerSurname
					+ "\nSolde:" + balance + "\n";
		}
		// permet d'organis� l'affichage des informations du compte de l'utilisateur, quand celui-ci veut voir la solde de son compte bancaire.
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
		
		//v�rifie et renvoie un message � l'utilisateur si le d�pot � pu se faire o� si l'utilisateur � entr�es des mauvaises valeurs
		public void deposit(double amount) {

			if (amount <= 0) {
				System.out.println("le montant � d�poser doit �tre positif et sup�rieur � 0");
				
			} else if (amount > 0) {
				System.out.println("montant d�pos� avec succ�s ");
				balance = balance + amount;
			}
		}
		// v�rifie et renvoie un message � l'utilisateur si le retrait effectuer � pu se faire o� non.
		public void withdraw(double amount) {
			if (amount <= 0) {
				System.out.println("Le montant � retirer doit �tre positif et sup�rieur � 0");
				return;
			} else if (amount > 0) {
				System.out.println("montant retir� avec succ�s");
				balance = balance - amount;
			} else {
				if (balance < amount) {
					System.out.println("Solde insuffisant");
					

				}
			}
		}

	}// fin de la classe

}
