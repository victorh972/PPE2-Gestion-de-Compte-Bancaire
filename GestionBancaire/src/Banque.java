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
				// demmander � l'utilisateur son choix et valider (entre 1 et 5).
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
					String sex = s.next();

					System.out.println("Entrer adresse du domicile");
					String Adresse = s.next();

					System.out.println("Entrer le type de compte :");
					String typeCompte = s.next();

					System.out.println("entrer la somme de d�p�t d'ouverture :");
					double solde = s.nextDouble();
					System.out.println("votre compte a �t� cr��  et enregistr� comme compte num�ro : "
							+ myBank.openNewAccount(prenom, nom, dateNaissance, sex, Adresse, typeCompte, solde));
					break;
				case 2:
					System.out.println("entrer le num�ro du compte");
					int an = s.nextInt();
					System.out.println("entrer le montant � d�poser");
					double da = s.nextDouble();
					myBank.depositTo(an, da);
					break;
				case 3:
					System.out.println("entrer le num�ro du compte :");
					int acn = s.nextInt();
					System.out.println("entrer le montant � retirer");
					double wa = s.nextDouble();
					myBank.withdrawFrom(acn, wa);
					break;
				case 4:
					System.out.println("entrer le num�ro du compte");
					int anum = s.nextInt();
					myBank.printAccountInfo(anum);
					break;
				case 5:

					System.exit(0);
				}
			} while (user_choice != '6'); // si l'utilisateur rentre un choix sup�rieur ou �gale a 6 le programme r�affiche les choix
		} catch (Exception e) {			// jusqu'� ma saisie du choix soit bon.
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
		public int openNewAccount(String prenom, String nom, String dateNaissance, String sex, String Adresse,
				String typeCompte, double solde) {

			BankAccount b = new BankAccount(prenom, nom, solde);
			accounts[numOfAccounts] = b;
			numOfAccounts++;
			return b.getAccountNum();
		}

		// effectue un retrait du montant indiqu� dans le compte dont le num�ro est
		// donn�. Si
		// le compte est
		// non existant dans la banque, un message devrait s'afficher.
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
		// si le comte est
		// non existant dans la banque, un message devrait s'afficher
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
		// le num�ro de comte est donn�. si le comte est non existant dans la banque
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

		public void printAccountInfo(int accountNum, int n) {
			for (int i = 0; i < numOfAccounts; i++) {
				if (accountNum == accounts[i].getAccountNum()) {
					System.out.println(accounts[i].getAccountInfo());
					return;
				}
			}
			System.out.println("num�ro de compte incorrect.");
		}

	}

	static class BankAccount {

		private int accountNum;
		private String customerName;
		private String customerSurname;
		private double balance;
		private static int noOfAccounts = 0;

		public String getAccountInfo() {
			return "compte num�ro: " + accountNum + "\nPrenom: " + customerName + "\nNom: " + customerSurname
					+ "\nBalance:" + balance + "\n";
		}

		public BankAccount(String abc, String ijk, double xyz) {
			customerName = abc;
			customerSurname = ijk;
			balance = xyz;
			noOfAccounts++;
			accountNum = noOfAccounts;
		}

		public int getAccountNum() {
			return accountNum;
		}

		public void deposit(double amount) {

			if (amount <= 0) {
				System.out.println("le montant � d�poser doit �tre positif");
				
			} else if (amount > 0) {
				System.out.println("montant d�pos� avec succ�s ");
				balance = balance + amount;
			}
		}

		public void withdraw(double amount) {
			if (amount <= 0) {
				System.out.println("Le montant � retirer doit �tre positif");
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

	}// end of class

}
