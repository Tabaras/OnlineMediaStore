package service;

import repository.GlobalDataHolder;

public class Register {

	public boolean registerUser() {

		User clientNou = new User();
		System.out.println("Va rugam introduceti prenumele dumneavoastra.");
		String prenume = GlobalDataHolder.scan.next();
		if (prenume != "") {
			clientNou.setPrenume(prenume);
		} else {
			return false;
		}
		System.out.println("Va rugam introduceti numele dumneavoastra.");
		String nume = GlobalDataHolder.scan.next();
		if(nume != ""){
			clientNou.setNume(nume);
		}else{
			return false;
		}
		System.out.println("Introduceti adresa de email");
		String adresa_email = GlobalDataHolder.scan.next();
		if(adresa_email != ""){
		clientNou.setAdresa_email(adresa_email);
		}else{
			return false;
		}
		String parola1 = null;
		String parola2 = null;
		System.out.println("Introduceti o parola.");
		do {
			parola1 = GlobalDataHolder.scan.next();
			System.out.println("Confirmati parola.");
			parola2 = GlobalDataHolder.scan.next();
		} while (!parola1.equals(parola2));
		if (parola1 != "") {
			clientNou.setParola(parola1);
		} else {
			return false;
		}
		GlobalDataHolder.clienti.add(clientNou);
		System.out.println("Utilizator nou creat: "+clientNou.getNume()+" "+clientNou.getPrenume());
		
		return true;

	}
}
