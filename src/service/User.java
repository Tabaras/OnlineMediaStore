package service;

public class User {

	private int id;
	private String prenume;
	private String nume;
	private String adresa_email;
	private String parola;
	

	public User() {

	}

	public User(int id, String prenume, String nume, String adresa_email,String parola) {
		this.id = id;
		this.prenume = prenume;
		this.nume = nume;
		this.adresa_email = adresa_email;
		this.parola = parola;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getAdresa_email() {
		return adresa_email;
	}

	public void setAdresa_email(String adresa_email) {
		this.adresa_email = adresa_email;
	}
	

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public String toString() {

		return "Clientul logat este : " + nume + " " + prenume;
	}

}
