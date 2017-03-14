package repository;

import java.util.ArrayList;
import java.util.Scanner;

import products.Carte;
import products.Cd;
import products.Dvd;
import products.Produs;
import service.User;

public class GlobalDataHolder {
	
	public static Scanner scan = new Scanner(System.in);
	public static ArrayList<Produs> produse = new ArrayList<Produs>();
	//public static ArrayList<Comanda> comanda = new ArrayList<Comanda>();
	
	public static ArrayList<Dvd> dvd = new ArrayList<Dvd>();
	public static ArrayList<Cd> cds = new ArrayList<Cd>();
	public static ArrayList<Carte> carti = new ArrayList<Carte>();
	
	public static ArrayList<User> clienti = new ArrayList<User>();
	
	
	public static boolean pornesteAplicatia = true;
	public static boolean ruleazaMeniuPrincipal = true;
	public static int currentUser;

}
