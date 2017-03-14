package main;

import repository.GlobalDataHolder;
import repository.JDBCTest;

import service.Login;
import service.Register;
import service.User;
import ui.Menu;
import ui.OperatiuniService;

import java.util.ArrayList;

import products.Produs;

public class App {

	Register utilizatorNou = new Register();
	Login login = new Login();
	
	Menu menu = new Menu();
	int opt;
	int pretTotalComanda;

	public void run() {

		JDBCTest.initConnection();

		// starting application
		while (GlobalDataHolder.pornesteAplicatia) {
			System.out.println("Alegeti una din valorile de mai jos.");
			menu.afiseazaMeniuLogare();
			opt = GlobalDataHolder.scan.nextInt();

			switch (opt) {
			case 1:
				logareClient();
				break;
			case 2:
				inregistrareUserNou();
				break;
			case 3:
				continuaFaraCont();
				break;
			default:
				System.out.println("Nu exista aceasta optiune.");

			}// sfarsit primul switch
		}

	}

	// handler secondary menu
	public void administrareMeniuPrincipal() {

		int opt;
		while (GlobalDataHolder.ruleazaMeniuPrincipal) {
			menu.afiseazaMeniuPrincipal();
			opt = GlobalDataHolder.scan.nextInt();

			switch (opt) {

			case 1:
				new OperatiuniService().cumparareCarti();
				break;
			case 2:
				new OperatiuniService().cumparareDvd();
				break;
			case 3:
				new OperatiuniService().cumparareCd();
				break;
			case 4:
				afiseazaComandaCurenta(GlobalDataHolder.produse);
				break;
			case 5:
				afiseazaPretComandaCurenta();
				break;
			case 6:
				iesireMeniuPrincipal();
				break;
			default:
				System.out.println("Input incorect.");
				break;
			}// end switch
			System.out.println("Va multumim ca ati vizitat magazinul nostru!!!");
		} // end while
	}// end afiseaza meniu principal

	public User getCurrentUser() {
		return GlobalDataHolder.clienti.get(GlobalDataHolder.currentUser);
	}

	public void logareClient() {
		boolean logare = login.login();
		if (logare == true) {
			administrareMeniuPrincipal();
			GlobalDataHolder.pornesteAplicatia = false;
		} else {
			System.out.println("Logarea nu a fost posibila.");
			login.login();
		}
	}

	public void afiseazaPretComandaCurenta() {
		
		System.out.println("Comanda curenta este compusa din: " + GlobalDataHolder.produse.size() + " produse.");
		pretTotalComanda = new OperatiuniService().calculeazaPretProduse(GlobalDataHolder.produse);
		System.out.println("Pretul total al comenzii este: " + pretTotalComanda + " lei.");

	}

	public void afiseazaComandaCurenta(ArrayList<Produs> produse) {

		int nrProduse = produse.size();
		System.out.println("Comanda curenta este compusa din " + nrProduse+" produse.");

		for (Produs p : produse) {
			System.out.println(p);
		}
	}

	public void inregistrareUserNou() {

		boolean esteCreat = utilizatorNou.registerUser();
		System.out.println("Este creat ? " + esteCreat);
		System.out.println("Dimensiune array: " + GlobalDataHolder.clienti.size());
		if (esteCreat) {
			JDBCTest.updateBazaDeDate();
			logareClient();
		} else {
			System.out.println("Userul nu a fost creat.");
		}
	}

	public void iesireMeniuPrincipal() {
		GlobalDataHolder.ruleazaMeniuPrincipal = false;
	}

	public void continuaFaraCont() {
		System.out.println("Bine ati venit.");
		administrareMeniuPrincipal();
		GlobalDataHolder.pornesteAplicatia = false;
	}

}
