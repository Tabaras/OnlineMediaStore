package repository;

import java.sql.*;

import products.Carte;
import products.Cd;
import products.Dvd;
import service.User;

public class JDBCTest {
	static Connection conn = null;

	public static void initConnection() {

		Statement stmt = null;
		// daca folosesc un singur result set nu imi inchide conexiunea chiar
		// daca este inchisa in blocul finally
		ResultSet rs = null;
		ResultSet rsCd = null;
		ResultSet rsDvd = null;
		ResultSet rsUser = null;
		String urlDb = "jdbc:mysql://localhost:3306/mediastore";
		String userDb = "student";
		String passDb = "Student1";

		Carte carte = null;
		Cd cd = null;
		Dvd dvd = null;
		User client = null;

		try {
			conn = DriverManager.getConnection(urlDb, userDb, passDb);

			stmt = conn.createStatement();

			String queryCarti = "select * from carti";
			String queryCd = "select * from cd";
			String queryDvd = "select* from dvd";
			String queryUsers = "select * from users";

			// Baza date Carti
			rs = stmt.executeQuery(queryCarti);
			while (rs.next()) {
				carte = new Carte();

				int id = rs.getInt(1);
				String titlu = rs.getString(2);
				String gen = rs.getString(3);
				String autor = rs.getString(4);
				int pret = rs.getInt(5);
				int an_aparitie = rs.getInt(6);

				carte.setId(id);
				carte.setTitlu(titlu);
				carte.setGen(gen);
				carte.setAutor(autor);
				carte.setPret(pret);
				carte.setAn_aparitie(an_aparitie);

				GlobalDataHolder.carti.add(carte);
			} // end while carti ResultSet

			// Baza de date CD-uri
			rsCd = stmt.executeQuery(queryCd);
			while (rsCd.next()) {
				cd = new Cd();

				int id = rsCd.getInt(1);
				String artist = rsCd.getString(2);
				int nr_piese = rsCd.getInt(3);
				int pret = rsCd.getInt(4);
				String gen_muzical = rsCd.getString(5);

				cd.setId(id);
				cd.setArtist(artist);
				cd.setNr_piese(nr_piese);
				cd.setPret(pret);
				cd.setGen_muzical(gen_muzical);

				GlobalDataHolder.cds.add(cd);

			} // end cds ResultSet

			// Baza de date DVD-uri
			rsDvd = stmt.executeQuery(queryDvd);

			while (rsDvd.next()) {
				dvd = new Dvd();

				int id = rsDvd.getInt(1);
				String titlu_dvd = rsDvd.getString(2);
				String regizor = rsDvd.getString(3);
				int durata = rsDvd.getInt(4);
				int pret = rsDvd.getInt(5);
				int an_aparitie = rsDvd.getInt(6);

				dvd.setId(id);
				dvd.setTitlu_dvd(titlu_dvd);
				dvd.setRegizor(regizor);
				dvd.setDurata(durata);
				dvd.setPret(pret);
				dvd.setAn_aparitie(an_aparitie);

				GlobalDataHolder.dvd.add(dvd);

			}

			// Baza de date clienti
			rsUser = stmt.executeQuery(queryUsers);
			while (rsUser.next()) {

				client = new User();

				int id = rsUser.getInt(1);
				String prenume = rsUser.getString(2);
				String nume = rsUser.getString(3);
				String adresa_email = rsUser.getString(4);
				String parola = rsUser.getString(5);

				client.setId(id);
				client.setPrenume(prenume);
				client.setNume(nume);
				client.setAdresa_email(adresa_email);
				client.setParola(parola);
				GlobalDataHolder.clienti.add(client);

			} // end user ResultSet

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}

		}
	}// end init connection

	public static void updateBazaDeDate() {

		User u = GlobalDataHolder.clienti.get(GlobalDataHolder.clienti.size() - 1);

		Statement stmt = null;

		String urlDb = "jdbc:mysql://localhost:3306/mediastore";
		String userDb = "student";
		String passDb = "Student1";
		String nume = u.getNume();
		String prenume = u.getPrenume();
		String mail = u.getAdresa_email();
		String parola = u.getParola();
		String query = "insert into users (prenume, nume, adresa_email, parola) values" + " ('" + prenume + "','" + nume + "','" + mail + "','" + parola
				+ "');";
		try {

			conn = DriverManager.getConnection(urlDb, userDb, passDb);
			stmt = conn.createStatement();
			stmt.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

}