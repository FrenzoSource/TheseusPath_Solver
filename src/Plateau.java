package src;
import java.util.*;







public class Plateau {
    private int nbreLigne;
    private int nbreCase;
    private ArrayList<Ligne> grille;

    Plateau() {
        this.nbreCase = 0;
        this.nbreLigne = 0;
        this.grille = new ArrayList<Ligne>();
    }

    public ArrayList<Ligne> getGrille() { return this.grille; }
    public int getNbreCase() { return this.nbreCase; }
    public int getNbreLigne() { return this.nbreLigne; }
    public int getNbreColonne() { return this.nbreCase / this.nbreLigne; }




    public void ajouterLigne(Ligne ligne) {
        this.grille.add(ligne);
    }

    public void ajouterLigne() {
        this.grille.add(new Ligne());
    }

    public void afficherGrille() {
        System.out.println("Affichage de la grille de labyrinthe.");
        for (Ligne ligne: this.grille) {
            ligne.afficherLigne();
        };
    }


}
