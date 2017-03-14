package ui;

import java.util.ArrayList;

import products.Carte;
import products.Cd;
import products.Dvd;
import products.Produs;
import repository.GlobalDataHolder;

public class OperatiuniService {

	
	/* => Metoda pentru a adauga dvd <=*/
	public void adaugaDvdInListaDeProduse(int index) {
		index--;
		if (index < 0 || index >= GlobalDataHolder.dvd.size()) {
			return;
		}
		Dvd dvd = null;
		dvd = GlobalDataHolder.dvd.get(index);
		System.out.println("Dvd-ul este: " + dvd);
		GlobalDataHolder.produse.add(dvd);
		GlobalDataHolder.dvd.remove(index);

	}

	public void cumparareDvd() {
		Dvd dvd = new Dvd();
		dvd.afiseazaListaDvd();
		int choice;
		System.out.println("Dvd disponibile in magazin.");
		System.out.println("Pentru a adauga in cos dvd-urile dorite introduceti id-ul aferent.");
		choice = GlobalDataHolder.scan.nextInt();
		adaugaDvdInListaDeProduse(choice);

	}
	/* => Metode pentru a adauga carti <=*/
	
	public void cumparareCarti() {
		Carte carte = new Carte();
		carte.afiseazaListaCarti();
		int choice;
		System.out.println("Carti disponibile in magazin.");
		System.out.println("Pentru a adauga in cos produsele dorite introduceti id-ul aferent.");
		choice = GlobalDataHolder.scan.nextInt();
		adaugaCarteInListaDeProduse(choice);

	}

	public void adaugaCarteInListaDeProduse(int index) {
		index--;
		if (index < 0 || index > GlobalDataHolder.carti.size()) {
			return;
		}
		Carte c = null;
		c = GlobalDataHolder.carti.get(index);
		System.out.println("Cartea e " + c);
		GlobalDataHolder.produse.add(c);
		GlobalDataHolder.carti.remove(index);
	}

	/* => Metode pentru a adauga cd-uri <=*/
	public void cumparareCd() {
		Cd cds = new Cd();
		cds.afiseazaListaCds();
		int choice;
		System.out.println("Cd-uri disponibile in magazin.");
		System.out.println("Pentru a adauga in cos dvd-urile dorite introduceti id-ul aferent.");
		choice = GlobalDataHolder.scan.nextInt();
		adaugaCdInListaDeProduse(choice);

	}

	public void adaugaCdInListaDeProduse(int index) {
		index--;
		if (index < 0 || index >= GlobalDataHolder.cds.size()) {
			return;
		}
		Cd cd = null;
		cd = GlobalDataHolder.cds.get(index);
		System.out.println("Cd-ul este: " + cd);
		GlobalDataHolder.produse.add(cd);
		GlobalDataHolder.cds.remove(index);

	}

	// calcul comanda
	public int calculeazaPretProduse(ArrayList<Produs> produse) {

		int sumaTotala = 0;
		for (Produs p : produse) {
			sumaTotala += p.getPret();
		}
		return sumaTotala;

	}// end calculeazaPretProduse

}
