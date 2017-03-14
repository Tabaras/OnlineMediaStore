package service;

import repository.GlobalDataHolder;

public class Login {

	public boolean login() {

		int index = 0;
		boolean isFound = false;
		System.out.println("Introduceti numele : ");
		String nume = GlobalDataHolder.scan.next();
		System.out.println("Introduceti parola.");
		String parola = GlobalDataHolder.scan.next();
		
		for (User client : GlobalDataHolder.clienti) {

			if ((nume.equalsIgnoreCase(client.getNume())) && (parola.equalsIgnoreCase(client.getParola()))) {
				System.out.println("V-ati autentificat cu succes: " + client.toString());
				isFound = true;
				break;
			}
				
			index++;
				
					
		}//end for
		if(!isFound)
		System.out.println("user not found!!");
	
		GlobalDataHolder.currentUser = index;
		return isFound;
	}

}
