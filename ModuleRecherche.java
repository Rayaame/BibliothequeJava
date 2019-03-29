/**
 * TP2 INF1120 : Programme permettant de faire des recherche
 * (recherche par categorie, recherche par titre, recherche par 
 * auteur, recherche par periode) dans une bibliothe.
 * 
 * @author Bitchi Rayane Ame-Voltaire
 * Code permanent : BITR24129605
 * @version Mars 2019
 */
public class ModuleRecherche {
	
	// ------------
	// CONSTANTES
	// ------------
	
	static final String MSG_PRESENTATION = "Cette application permet d'executer"
			+ " diverses requetes pour rechercher des livres\r\n" + 
			"dans une bibliotheque donnee. Elle permet plus particulierement"+
			"de faire des recherches par categorie(s),\r\n" + 
			"par expression dans le titre, par auteur, et par\r\n" + 
			"periode de publication.\n\n";

	static final String MENU = "-----------------\r\n" + 
			"MENU DE RECHERCHE\r\n" + 
			"-----------------\r\n" + 
			"1. Recherche par categorie(s)\r\n" + 
			"2. Recherche par titre\r\n" + 
			"3. Recherche par auteur\r\n" + 
			"4. Recherche par periode\r\n" + 
			"5. Quitter\n";
	static final String LISTE_CATEGORIE = "\nLISTE DES CATEGORIES :\n"+ 
			"   1. Science fiction\r\n" + 
			"   2. Romance\r\n" + 
			"   3. Thriller\r\n" + 
			"   4. Policier\r\n" + 
			"   5. Humour\r\n" + 
			"   6. Drame\r\n" + 
			"";
	static final String MSG_SOL_CHOIX = "Entrez votre choix : ";
	static final String MSG_ERR_CHOIX = "Erreur, choix invalide! Recommencez...";

	static final String MSG_SOL_TYPE_RECHERCHE_CAT = "Recherche par (C)onjonction ou (D)isjonction : ";
	static final String MSG_ERR_TYPE_RECHERCHE_CAT = "Erreur, entrez C ou D ! Recommencez...";

	static final String MSG_SOL_CAT = "Entrez un numero de categorie (0 pour terminer) : ";
	static final String MSG_ERR_CAT = "Erreur, numero de categorie invalide! Recommencez...";

	static final String MSG_SOL_TITRE = "Entrez le titre ou une"
			+ " partie du titre (<ENTREE> pour terminer) : ";
	static final String MSG_ERR_TITRE = "Erreur, le titre "
			+ "doit contenir au moins 5 caracteres ! Recommencez...";

	static final String MSG_SOL_AUTEUR = "Entrez le nom de l'auteur (<ENTREE> pour terminer) : ";
	static final String MSG_ERR_AUTEUR = "Erreur, le nom de l'auteur doit"
			+ " contenir au moins 3 caracteres ! Recommencez... ";

	static final String MSG_SOL_DEBUT_PERIODE = "Entrez l'annee du debut"
			+ " de la periode (0 pour terminer) : ";
	static final String MSG_SOL_FIN_PERIODE = "Entrez l'annee de la fin "
			+ "de la periode (0 pour terminer) : ";
	static final String MSG_ERR_PERIODE = "Erreur, l'annee doit etre un entier entre "
			+ "1900 et 2019 inclusivement! Recommencez...";

	static final String RECHERCHE_ANNULEE = "\nRECHERCHE ANNULEE.\n\n\n";
	static final String MSG_FIN = "\n\nAUREVOIR !";

	static final int MIN_TITRE = 5;
	static final int MIN_AUTEUR = 3;
	static final int MIN_PERIODE = 1900;
	static final int MAX_PERIODE = 2019;

	// ------------
	// METHODES
	// ------------

	/**
	 * Provoque l'arret du programme et demande d'entrer un 
	 * ENTER pour continuer.
	 */
	public static void pause () {
		System.out.print("Tapez <ENTREE> pour revenir au menu de recherche...");
		Clavier.lireFinLigne();
		System.out.println("\n");
	}
	
	/**
	 * Affiche une breve presentation du logiciel.
	 */
	public static void presenterLogiciel () {
		System.out.println(MSG_PRESENTATION);
	}
	
	/**
	 * Saisit et valide le choix de l'utilisateur, ce choix doit etre compris entre  
	 * (1 et 6 inclusivement)
	 * @param msgSolChoix le message de sollicitation pour le choix a valider
	 * @param msgErrChoix le message d'erreur pour le choix a valider
	 * @return 
	 */
	public static String saisieChoixMenu(String msgSolChoix, String msgErrChoix) {
		String choix;
		System.out.print(msgSolChoix);
		choix = Clavier.lireString();
		while(choix.isEmpty() || (!choix.equals("1") && !choix.equals("2")
				&& !choix.equals("3") && !choix.equals("4") && !choix.equals("5"))) {
			System.out.println(msgErrChoix+"\n");
			afficherMenu();
			System.out.print(msgSolChoix);
			choix = Clavier.lireString();
		}
		return choix;
	}
	
	/**
	 * Saisit et valide le type de recherche par categorie (Conjonction ou Dijonction),
	 * les caracteres valides sont (c ,C ,d, D)
	 * @param msgSolcat le message de sollicitation pour le type de recherche 
	 * @param msgErrCat le message d'erreur pour le type de recherche
	 * @return typeCat
	 */
	public static char saisirTypeRechercheCat(String msgSolcat, String msgErrCat) {
		char typeCat;
		System.out.print(msgSolcat);
		typeCat = Clavier.lireCharLn();
		while (typeCat != 'C' && typeCat != 'c' && typeCat != 'D' && typeCat != 'd') {
			System.out.println("\n"+msgErrCat);
			System.out.print(msgSolcat);
			typeCat = Clavier.lireCharLn();				
		}
		return typeCat;
	} 
	/**
	 * Retourne la description de la categorie selon le numero de la catgorie recu en parametre
	 * @param categorieNumerique le numero de la categorie en numerique
	 * @return
	 */
	public static String descriptionCategorie(int categorieNumerique) {
		String categorie = "";
		switch (categorieNumerique) {
		case 1:
			categorie = "Science fiction";
			break;
		case 2:
			categorie = "Romance";
			break;
		case 3:
			categorie = "Thriller";
			break;
		case 4:
			categorie = "Policier";
			break;
		case 5:
			categorie = "Humour";
			break;
		case 6:
			categorie = "Drame";
			break;
		}		
		return categorie;
	}
	
	/**
	 * Affiche un message de fin du programme.
	 */
	public static void afficherFinProg () {
		System.out.println(MSG_FIN);
	}

	/**
	 * Affiche un message de fin du programme.
	 */
	public static void afficherMenu () {
		System.out.println(MENU);
	}

	/**
	 * Affiche la liste des categories.
	 */
	public static void afficherListeCategorie() {
		System.out.println(LISTE_CATEGORIE);
	}
	
	/**
	 * Affiche la bibliotheque passee en parametre si elle n'est pas vide
	 * ou un message dans le cas ou la bibliotheque est vide
	 * @param biblio les livres a afficher
	 */
	public static void afficherResultats(String biblio) {
		if (!biblio.isEmpty()) {
			System.out.println("\nRESULTAT(S) DE RECHERCHE :\n" + 
					"--------------------------");
			System.out.println(biblio);
			pause();
		}else {
			System.out.println("\nAUCUN LIVRE TROUVE.\n");
			pause();
		}
	}
	
	/**
	 * Retourne et/ou selon le type de recherche saisi (Conjoction ou Dijontion).
	 * @param typeRecherche le type de recherche recut en parametre ('C','c','d','D').
	 * @return
	 */
	public static String descriptionTypeRecherche(char typeRecherche) {
		String descripTypeRecherche = null;
		if (typeRecherche == 'C' || typeRecherche == 'c') {
			descripTypeRecherche = "et";
		}else if(typeRecherche == 'D' || typeRecherche == 'd'){
			descripTypeRecherche = "ou";
		}
		return descripTypeRecherche;
	}
	
	/**
	 * Saisit et valide la categorie du livre
	 * une categorie valide est comprise entre 0 et 6 inclusivement.
	 * @param msgSol le message de solicitation pour la categorie a valider
	 * @param msgErr le message d'erreur pour une categorie invalide
	 * @return
	 */
	public static String saisirCategorie(String msgSol, String msgErr) {
		String categorie;
		System.out.print(msgSol);
		categorie = Clavier.lireString();
		while(categorie.isEmpty() || categorie.charAt(0) < '0' || categorie.charAt(0) > '6'
				||(Integer.parseInt(categorie) < 0 || Integer.parseInt(categorie) > 6)) {	
		
			System.out.println("\n"+msgErr);
			System.out.print(msgSol);
			categorie = Clavier.lireString();
		}
		return categorie;
	}
	
	/**
	 * Saisit et valide l'auteur ou le titre du livre.
	 * @param msgSol le message de solicitation pour l'auteur ou le titre.
	 * @param msgErr le message d'erreur pour l'auteur ou le titre.
	 * @param max la longueur maximale valide pour la chaine a saisir
	 * 			  pour l'auteur : max est valide si max >= 3
	 * 			  pour le titre : max est valide si max >= 5.
	 * @return
	 */
	public static String saisirTitreOuAuteur(String msgSol, String msgErr, int max) {
		String titre;
		System.out.print(msgSol);
		titre = Clavier.lireString();
		while (!titre.isEmpty() && titre.length() < max) {
			System.out.println("\n"+msgErr);
			System.out.print(msgSol);
			titre = Clavier.lireString();
		}
		return titre;
	}
	
	/**
	 * Saisit et valide la periode
	 * @param msgSol le message de solicitation pour la periode
	 * @param msgErr le message d'erreur pour la periode
	 * @param periodeMin la periode mininum a saisir
	 * 		  periodeMin est valide si periodeMin >= 1900.
	 * @param periodeMax la periode maximun a saisir
	 * 		  periodeMax est valide si periodeMax <= 2019.
	 * @return
	 */
	public static String saisirPeriode(String msgSol, String msgErr, 
			int periodeMin, int periodeMax) {
		String annee;
		System.out.print(msgSol);
		annee = Clavier.lireString();
		while (annee == "" || (annee.charAt(0) < '0' || annee.charAt(0) > '9') ||
				(Integer.parseInt(annee) != 0 && (Integer.parseInt(annee) < periodeMin
						|| Integer.parseInt(annee) > periodeMax))) {
			System.out.println("\n"+msgErr);
			System.out.print(msgSol);
			annee = Clavier.lireString();
		}
		return annee;
	}

	/**
	 * Retourne:
	 * - la description de la categorie recue en parametre concatenee du
	 * type de recherche par categorie ("et" ou "ou") si la requete passee 
	 * en parametre de contient pas deja la description de la categorie recue en parametre.
	 * - Sinon retourne une chaine vide.
	 * @param requeteDonnee la requete dans laquelle on verie si la categorie n'existe pas deja
	 * @param typeRechercheCat le type de recherche par categorie ("et" ou "ou").
	 * @param laCategorie la categorie a ajouter si elle n'existe pas deja dans la requete
	 * @return
	 */
	public static String requeteCategorie(String requeteDonnee,
			String laCategorie, String typeRechercheCat) {
		String requete = "";
		laCategorie = laCategorie.toUpperCase();
		if (!requeteDonnee.contains(laCategorie)) {
			requete = laCategorie+" "+typeRechercheCat+" ";
		}	   
		return requete;
	}
	
	/**
	 * Cette methode retourne l'element extrait dans la bibliotheque 
	 * (titre , auteur, categorie, periode) .
	 * @param laLigne la ligne dans laquelle ont veut extraire l'element
	 * @param element la position de l'element qu'on veut etraire dans l'ordre
	 * (titre , auteur, categorie, periode) .
	 * @return
	 */
	public static String extraireElement(String laLigne, int element) {
		String elementRecherche = "";
		String titre;
		String auteur;
		String annee;
		String categories;
		titre = laLigne.substring(0,laLigne.indexOf('\t'));
		laLigne = laLigne.substring(laLigne.indexOf('\t')+1);
		auteur = laLigne.substring(0,laLigne.indexOf('\t'));
		laLigne = laLigne.substring(laLigne.indexOf('\t')+1);
		annee = laLigne.substring(0,laLigne.indexOf('\t'));
		laLigne = laLigne.substring(laLigne.indexOf('\t')+1);
		categories = laLigne;
		switch (element) {
		case 1:
			elementRecherche = titre;
			break;
		case 2:
			elementRecherche = auteur;
			break;
		case 3:
			elementRecherche = annee;
			break;
		case 4:
			elementRecherche = categories;
			break;
		}
		return elementRecherche;
	}
	
	/**
	 * Cette methode permet de formater la categorie
	 * (supprimer les '\t' et metre "," a la fin de chaque categorie sauf la derniere)
	 * @param categorie la categorie a formater
	 * @return
	 */
	public static String formaterCategorie(String categorie) {
		String cat = "";
		int cpt = 0;
		for (int i = 0; i < categorie.length(); i++) {
			if (categorie.charAt(i) == '\t') {
				cat += categorie.substring(cpt,i)+", ";
				cpt = i+1;
			}
		}
		return cat.substring(0, cat.length()-2);
	}
	
	/**
	 * Cette methode permet de retourner les ligne 
	 * correspondant a notre recherche dans le bon format
	 * @param titre le titre du livre
	 * @param auteur l'auteur du livre
	 * @param periode la periode du livre
	 * @param categories la ou les categorie(s) du livre
	 * @return
	 */
	public static String retournerLigneTrouve(String titre , String auteur ,
			String periode , String categories) {
		String ligne;
		ligne = "- "+titre.toUpperCase()+" ("+periode.toUpperCase()+"), "
				+ ""+auteur.toUpperCase()+" [ "+categories+" ]\n";
		return ligne;

	} 

	/**
	 * Afficher le numero de la categorie selon la description de la categorie
	 * @param categorie la categorie sous forme alphabetique
	 * @return
	 */
	public static String retournerNumCat(String categorie) {
		String numCat = "";
		if (categorie.equalsIgnoreCase("Science fiction")) {
			numCat = "1";
		}else if (categorie.equalsIgnoreCase("Romance")) {
			numCat = "2";
		}else if (categorie.equalsIgnoreCase("Thriller")) {
			numCat = "3";
		}else if (categorie.equalsIgnoreCase("Policier")) {
			numCat = "4";
		}else if (categorie.equalsIgnoreCase("Humour")) {
			numCat = "5";
		}else if (categorie.equalsIgnoreCase("Drame")) {
			numCat = "6";
		}
		return numCat;
	}

	/**
	 * Cette methode retourne toutes les categories d'un livre 
	 * sous forme numerique , elle utilise la methode retournerNumCat(String)
	 * pour avoir le numero de chaque categorie et le concatener l'un apres l'autre
	 * @param categories toutes les categorie d'un livre
	 * @return
	 */
	public static String retournerNumCategories(String categories) {
		String numCat = "";
		String num = "";
		String cat;
		int cpt = 0;
		for (int i = 0; i < categories.length(); i++) {
			if (categories.charAt(i) == '\t') {
				cat = categories.substring(cpt,i);
				num = retournerNumCat(cat);
				if (!numCat.contains(num)) {
					numCat += num;
				}else {
					numCat += "";
				}
				cpt = i+1;
			}

		}
		return numCat;
	}
	/**
	 * Cette methode concatene les differentes categorie saisie 
	 * par l'utilisateur si elle n'a pas ete saisi auparavent.
	 * @param cat la categorie qu'on vient de saisir
	 * @param laCategorie la categorie dans laquelle on 
	 * verifie si la categorie qui vient d'etre saisie existe deja 
	 * @return
	 */
	public static String numCatString(int cat , String laCategorie) {
		String categorie = String.valueOf(cat);
		String numCat = "";
		if (!laCategorie.contains(categorie)) {
			numCat = categorie;
		}
		return numCat;
	}

	/**
	 * Cette methode effectuee une recherche par Conjonction (et) dans notre bibliotheque
	 * avec la ou les categories saisies par l'utilisateur et la ou les 
	 * categorie qui existen dans la bibliotheque
	 * @param catSaisie la ou les categorie saisi par l'utilisateur
	 * @param catExtrait la categorie qui vient d'etre extrait dans la bibliotheque
	 * @return
	 */
	public static boolean rechercheConjonction(String catSaisie, String catExtrait) {
		boolean trouve = false;
		int nbCorresp = 0;
		for (int i = 0; i < catSaisie.length(); i++) {
			for (int j = 0; j < catExtrait.length(); j++) {
				if (catSaisie.charAt(i) == catExtrait.charAt(j)) {
					nbCorresp++;
				}
			}
		}
		if (nbCorresp == catExtrait.length()) {
			trouve = true;
		}
		return trouve;
	}
	/**
	 * Cette methode a affiche la requete consernant la recherche pas periode
	 * @param debutPeriode la periode de debut
	 * @param finPeriode la periode de fin
	 * @return
	 */
	public static String requetePeriode(int debutPeriode, int finPeriode) {
		String requete = "";
		if(finPeriode == debutPeriode) {
			requete = "L'annee est "+debutPeriode;
		}else {
			requete = "L'annee est entre "+debutPeriode+" et "+finPeriode;
		}
		return requete;
	}
	
	/**
	 * Cette methode effectuee une recherche par Dijonction (ou) dans notre bibliotheque
	 * avec la ou les categories saisies par l'utilisateur et la ou les 
	 * categorie qui existen dans la bibliotheque
	 * @param catSaisie la ou les categorie saisi par l'utilisateur
	 * @param catExtrait la categorie qui vient d'etre extrait dans la bibliotheque
	 * @return
	 */
	public static boolean rechercheDijonction(String catBiblio, String catExtrait) {
		boolean trouve = false;
		for (int i = 0; i < catBiblio.length(); i++) {
			for (int j = 0; j < catExtrait.length(); j++) {
				if (catBiblio.charAt(i) == catExtrait.charAt(j)) {
					trouve = true;
				}
			}
		}
		return trouve;
	}

	/**
	 * Cette methode permet d'afficher la requete passee en parametre
	 * @param requete le requete a afficher
	 */
	public static void afficherRequete(String requete) {
		System.out.println("\n"+requete);
	}
	
	
	public static void main(String[] args) {
		
		// ------------
		// VARIABLES
		// ------------
		
		String biblio = UtilitaireTP2.lireBibliotheque();
		String choixMenu;
		char typeCat;
		String requete;
		String laCategorie;
		boolean requetEstSaisie = false;//verifie si une categorie a ete saisie
		String ligne;
		int compteur1;
		String titre;
		String auteur;
		String nomAuteur;
		String annee;
		String categories;
		String rechercheTitre;
		String ligneCorrespondante;
		String rechercheAuteur;
		String debutPeriode;
		String finPeriode = "0";
		int debutPeriodeEnInt;
		int finPeriodeEnInt = 0;
		String msgErrFinPeriode;
		String numCatString;
		//Numero de toutes les categorie
		String numCats = "";

		biblio = biblio.trim()+"\n";
		presenterLogiciel();

		do {
			afficherMenu();
			choixMenu = saisieChoixMenu(MSG_SOL_CHOIX, MSG_ERR_CHOIX);
			switch (choixMenu) {

			case "1":
				//Recherche par categorie(s)
				
				requete = "";
				numCatString = "";
				ligneCorrespondante = "";
				
				System.out.println("\n*** RECHERCHE PAR CATEGORIE(S) ***"+"\n");
				typeCat = saisirTypeRechercheCat(MSG_SOL_TYPE_RECHERCHE_CAT,
						MSG_ERR_TYPE_RECHERCHE_CAT);
				
				//Affichage de la liste des gategories
				afficherListeCategorie();
				
				do {
					laCategorie = saisirCategorie(MSG_SOL_CAT, MSG_ERR_CAT);
					if (Integer.parseInt(laCategorie) != 0) {
						requetEstSaisie = true;
						requete += requeteCategorie(requete,
								descriptionCategorie(Integer.parseInt(laCategorie)),
								descriptionTypeRecherche(typeCat));
						numCatString += numCatString(Integer.parseInt(laCategorie), numCatString); 
					}
				} while (Integer.parseInt(laCategorie) != 0);			
				if (requetEstSaisie) {
					//Suppression du dernier "et" ou "ou" dans la requete
					requete = requete.substring(0, requete.length()-4);
					
					//Parcour de la bibliotheque
					compteur1 = 0;
					for (int i = 0; i < biblio.length(); i++) {
						if (biblio.charAt(i) == '\n') {
							ligne = biblio.substring(compteur1, i)+"\t";
							titre = extraireElement(ligne, 1);
							auteur = extraireElement(ligne, 2);
							annee = extraireElement(ligne, 3);
							categories = extraireElement(ligne, 4);
							numCats = retournerNumCategories(categories);
							if (typeCat == 'c' || typeCat == 'C') {
								if (rechercheConjonction(numCats,numCatString)) {
									ligneCorrespondante += retournerLigneTrouve(titre,
											auteur, annee, formaterCategorie(categories));
								}
							}else if (typeCat == 'd' || typeCat == 'D'){
								if (rechercheDijonction(numCats,numCatString)) {
									ligneCorrespondante += retournerLigneTrouve(titre,
											auteur, annee, formaterCategorie(categories));
								}
							}
							compteur1 = i+1;
						}	
					}
					requete = "REQUETE : "+requete;
					afficherRequete(requete);
					afficherResultats(ligneCorrespondante);
				}else {
					System.out.println(RECHERCHE_ANNULEE);
				}
				break;

	
			case "2":
				//Recherche par titre
				
				String titreMinus = "";
				requete = "REQUETE : Le titre contient l'expression ";
				ligneCorrespondante = "";
				System.out.println("\n*** RECHERCHE PAR TITRE ***\n");
				rechercheTitre = saisirTitreOuAuteur(MSG_SOL_TITRE,
						MSG_ERR_TITRE , MIN_TITRE);
				if (rechercheTitre == "") {
					System.out.print(RECHERCHE_ANNULEE);
				}else {
					
					//Parcour de la bibliotheque
					compteur1 = 0;
					for (int i = 0; i < biblio.length(); i++) {
						if (biblio.charAt(i) == '\n') {
							ligne = biblio.substring(compteur1, i)+"\t";
							titre = extraireElement(ligne, 1);
							auteur = extraireElement(ligne, 2);
							annee = extraireElement(ligne, 3);
							categories = extraireElement(ligne, 4);
							
							/*Convertir le titre saisi en nimuscule et l'affeter a titreMinus
							 puis faire vefier si le titre extrait (en minuscul) contient le titreMinus
							 pour eviter les probleme de casse*/
							titreMinus = rechercheTitre.toLowerCase();
							if (titre.equalsIgnoreCase(rechercheTitre) ||
									titre.toLowerCase().contains(titreMinus)) {
								ligneCorrespondante += retournerLigneTrouve(titre,
										auteur, annee, formaterCategorie(categories));
							}
							compteur1 = i+1;
						}	
					}
					requete += rechercheTitre.toUpperCase();
					afficherRequete(requete);
					afficherResultats(ligneCorrespondante);
				}
				break;

			case "3":
				//Recherche par auteur
				
				ligneCorrespondante = "";
				requete = "REQUETE : Le nom de l'auteur est ";
				System.out.println("\n*** RECHERCHE PAR AUTEUR ***\n");
				rechercheAuteur = saisirTitreOuAuteur(MSG_SOL_AUTEUR, MSG_ERR_AUTEUR, MIN_AUTEUR);
				if (rechercheAuteur.isEmpty()) {
					System.out.print(RECHERCHE_ANNULEE);
				}else {
					compteur1 = 0;
					for (int i = 0; i < biblio.length(); i++) {
						if (biblio.charAt(i) == '\n') {
							ligne = biblio.substring(compteur1, i)+"\t";
							titre = extraireElement(ligne, 1);
							auteur = extraireElement(ligne, 2);
							annee = extraireElement(ligne, 3);
							categories = extraireElement(ligne, 4);
							nomAuteur = auteur.substring(auteur.lastIndexOf('.')+2, auteur.length());
							if (nomAuteur.equalsIgnoreCase(rechercheAuteur)) {
								ligneCorrespondante += retournerLigneTrouve(titre,
										auteur, annee, formaterCategorie(categories));
							}
							compteur1 = i+1;
						}	
					}
					requete += rechercheAuteur.toUpperCase();
					afficherRequete(requete);
					afficherResultats(ligneCorrespondante);
				}
				break;	

			case "4":
				//Recherche par periode
				requete = "REQUETE : ";
				ligneCorrespondante = "";
				System.out.println("\n*** RECHERCHE PAR PERIODE ***\n");
				debutPeriode = saisirPeriode(MSG_SOL_DEBUT_PERIODE,
						MSG_ERR_PERIODE, MIN_PERIODE, MAX_PERIODE);
				debutPeriodeEnInt = Integer.parseInt(debutPeriode);
				
				if (debutPeriodeEnInt != 0) {
					msgErrFinPeriode = "Erreur, l'annee doit etre un entier "
							+ "entre "+debutPeriode+" et "+MAX_PERIODE+" inclusivement! Recommencez...";
					finPeriode = saisirPeriode(MSG_SOL_FIN_PERIODE,
							msgErrFinPeriode, MIN_PERIODE, MAX_PERIODE);
					finPeriodeEnInt = Integer.parseInt(finPeriode);
					
					while (finPeriodeEnInt != 0 && finPeriodeEnInt < debutPeriodeEnInt) {
						System.out.println("\nErreur, l'annee doit etre un entier "
								+ "entre "+debutPeriode+" et "+MAX_PERIODE+" inclusivement! Recommencez...");
						finPeriode = saisirPeriode(MSG_SOL_FIN_PERIODE, 
								msgErrFinPeriode, MIN_PERIODE, MAX_PERIODE);
						finPeriodeEnInt = Integer.parseInt(finPeriode);
					}
				}
				
				if (debutPeriodeEnInt == 0 || finPeriodeEnInt == 0) {
					System.out.print(RECHERCHE_ANNULEE);
				}else {
					compteur1 = 0;
					for (int i = 0; i < biblio.length(); i++) {
						if (biblio.charAt(i) == '\n') {
							ligne = biblio.substring(compteur1, i)+"\t";
							titre = extraireElement(ligne, 1);
							auteur = extraireElement(ligne, 2);
							annee = extraireElement(ligne, 3);
							categories = extraireElement(ligne, 4);
							if (debutPeriode.equals(finPeriode)) {
								if (Integer.parseInt(annee) == debutPeriodeEnInt ) {
									ligneCorrespondante += retournerLigneTrouve(titre,
											auteur, annee, formaterCategorie(categories));
								}
							}else {
								if (Integer.parseInt(annee) >= debutPeriodeEnInt 
										&& Integer.parseInt(annee) <= finPeriodeEnInt ) {
									ligneCorrespondante += retournerLigneTrouve(titre,
											auteur, annee, formaterCategorie(categories));
								}
							}							
							compteur1 = i+1;
						}	
					}
					requete += requetePeriode(debutPeriodeEnInt, finPeriodeEnInt);
					afficherRequete(requete);
					afficherResultats(ligneCorrespondante);
				}
				break;	
			default :
				choixMenu = "5";
				break;
			}
		}while(choixMenu != "5");
		afficherFinProg();

	}

}