package src;

/*
Grille convData = new ConversionDonnee(filename);
Fonction pour remplir convData.plateau

Plateau plat1 = new Plateau(convData.plateau.grille) */

public class Main {
    public static void main(String args[]) {
        /*Instanciation dun object convertisseur + enregistrement des données + assignation au plateau */
        ConversionDonnee conv1 = new ConversionDonnee("exemple/exemple2.txt");
        conv1.recuperationDonnees();
        System.out.println("tentative d'affichge des données de la grille.");
        Plateau plat1 = conv1.getPlateau();
        plat1.afficherGrille();
        plat1.afficherPlateau();
    }
    
}
