package products;

import repository.GlobalDataHolder;

public class Cd implements Produs {
	private int id;
	private String artist;
	private int nr_piese;
	private int pret;
	private String gen_muzical;

	public Cd() {

	}

	public Cd(int id, String artist, int nr_piese, int pret, String gen_muzical) {
		super();
		this.id = id;
		this.artist = artist;
		this.nr_piese = nr_piese;
		this.pret = pret;
		this.gen_muzical = gen_muzical;
	}

	public int getId() {
		return id;
	}

	public String getArtist() {
		return artist;
	}

	public int getNr_piese() {
		return nr_piese;
	}

	public int getPret() {
		return pret;
	}

	public String getGen_muzical() {
		return gen_muzical;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void setNr_piese(int nr_piese) {
		this.nr_piese = nr_piese;
	}

	public void setPret(int pret) {
		this.pret = pret;
	}

	public void setGen_muzical(String gen_muzical) {
		this.gen_muzical = gen_muzical;
	}

	public void afiseazaListaCds() {


		try {
			System.err.println("ID\t" + "Pret\t"+"Artist");
			Thread.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		for (int i = 0; i < GlobalDataHolder.cds.size(); i++) {
			System.out.println((i + 1) + "\t" + GlobalDataHolder.cds.get(i).getPret()
			+"\t"+ GlobalDataHolder.cds.get(i).getArtist());
		}
	}

	public String toString() {
		return "ID= " + id + " artist: " + artist + " nr piese: " + nr_piese + " pret: " + pret + " gen muzical: "
				+ gen_muzical;

	}

}
