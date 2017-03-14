package products;

import repository.GlobalDataHolder;

public class Dvd implements Produs{

	int id;
	String titlu_dvd;
	String regizor;
	int durata;
	int pret;
	int an_aparitie;
	
	
	public Dvd(){
		
	}
	
	public Dvd(int id, String titlu_dvd, String regizor, int durata, int pret, int an_aparitie) {
		super();
		this.id = id;
		this.titlu_dvd = titlu_dvd;
		this.regizor = regizor;
		this.durata = durata;
		this.pret = pret;
		this.an_aparitie = an_aparitie;
	}

	public int getId() {
		return id;
	}

	public String getTitlu_dvd() {
		return titlu_dvd;
	}

	public String getRegizor() {
		return regizor;
	}

	public int getDurata() {
		return durata;
	}

	public int getPret() {
		return pret;
	}

	public int getAn_aparitie() {
		return an_aparitie;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setTitlu_dvd(String titlu_dvd) {
		this.titlu_dvd = titlu_dvd;
	}

	public void setRegizor(String regizor) {
		this.regizor = regizor;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public void setPret(int pret) {
		this.pret = pret;
	}

	public void setAn_aparitie(int an_aparitie) {
		this.an_aparitie = an_aparitie;
	}
	
	public void afiseazaListaDvd() {
		try {
			System.err.println("ID\t" + "Pret\t"+"Tilu");
			Thread.sleep(300);
			} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < GlobalDataHolder.dvd.size(); i++) {
			System.out.println((i + 1) + "\t" + GlobalDataHolder.dvd.get(i).getPret()
			+"\t"+ GlobalDataHolder.dvd.get(i).getTitlu_dvd());
		}
	}
	

	
	
	@Override
	public String toString() {
		return "ID= "+ id + " titlu_dvd: "+titlu_dvd+"regizor: "+regizor+"durata: "+durata+"pret: "
				+pret+"an_aparitie: "+an_aparitie+ "]";
	}

	
		
	


	
	
	
}
