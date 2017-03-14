package products;

import repository.GlobalDataHolder;

public class Carte implements Produs {

	private int id;
	private String titlu;
	private String gen;
	private String autor;
	private int pret;
	private int an_aparitie;

	public Carte() {

	}

	public Carte(int id, String titlu, String gen, String autor, int pret, int an_aparitie) {
		this.id = id;
		this.titlu = titlu;
		this.gen = gen;
		this.autor = autor;
		this.pret = pret;
		this.an_aparitie = an_aparitie;
	}

	public int getId() {
		return id;
	}

	public String getTitlu() {
		return titlu;
	}

	public String getGen() {
		return gen;
	}

	public String getAutor() {
		return autor;
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

	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}

	public void setGen(String gen) {
		this.gen = gen;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setPret(int pret) {
		this.pret = pret;
	}

	public void setAn_aparitie(int an_aparitie) {
		this.an_aparitie = an_aparitie;
	}

	public void afiseazaListaCarti() {
		
		try {
			System.err.println("ID\t"+"Pret\t"+"An Aparitie\t"+"Titlu");
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < GlobalDataHolder.carti.size(); i++) {
			
			System.out.println((i+1)+"\t"+GlobalDataHolder.carti.get(i).getPret()+"\t"+GlobalDataHolder.carti.get(i).getAn_aparitie()+"\t\t"+GlobalDataHolder.carti.get(i).getTitlu());
		}
	}

	@Override
	public String toString() {
		return "ID=" + id + ", titlu=" + titlu + ", gen=" + gen + ", autor=" + autor + ", pret=" + pret
				+ ", an_aparitie=" + an_aparitie;
	}

}
